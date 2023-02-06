package cn.behappyto.export.manage.strategy.format;

import cn.behappyto.export.common.annotation.ExportType;
import cn.behappyto.export.domain.bo.ExcelTemplateBO;
import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.behappyto.export.manage.strategy.BaseExportTypeStrategy;
import cn.behappyto.export.manage.strategy.NotifyMethodStrategy;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * 导出 excel 类型的数据
 *
 * @author behappyto.cn
 */
@Slf4j
@Component
@ExportType(type = {"xls", "xlsx"})
public class ExportExcelTypeStrategy implements BaseExportTypeStrategy {

    /**
     * 下载路径
     */
    String DOWNLOAD_PATH = "export/download";

    /**
     * 模板路径
     */
    String TEMPLATE_PATH = "export/template";

    /**
     * 保存格式
     */
    String DATE_FORMAT = "yyyy-MM/dd";

    @Resource
    private NotifyMethodStrategy notifyMethodStrategy;

    @Override
    public String handle(ExportTemplate template, ExportTask config) {
        // 获取模板文件
        String tempFile = getTempFile(template);
        // 保存的文件名称
        String exportFile = getExportFile(template);
        // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量
        try (ExcelWriter excelWriter = EasyExcel.write(exportFile).withTemplate(tempFile).build()) {
            long currentPage = 0L;
            while (true) {
                log.info("正在导出：{}_{}，当前第 {} 页", config.getId(), exportFile, currentPage);
                // 获取数据
                Map<String, ExcelTemplateBO> mapData = notifyMethodStrategy.handle(template, config, ++currentPage);
                // 验证是否执行完成
                Set<Map.Entry<String, ExcelTemplateBO>> entrySet = checkHandleFinish(tempFile, mapData);
                if (entrySet == null) {
                    // 返回导出的文件地址
                    File file = new File(exportFile);
                    if (file.exists()) {
                        return file.getAbsolutePath();
                    }
                    return Strings.EMPTY;
                }
                for (Map.Entry<String, ExcelTemplateBO> entry : entrySet) {
                    ExcelTemplateBO excelTemplateBO = entry.getValue();
                    if (CollUtil.isEmpty(excelTemplateBO.getValue())) {
                        continue;
                    }
                    // 填充方向：默认纵向
                    WriteDirectionEnum vertical = WriteDirectionEnum.VERTICAL;
                    if (BooleanUtil.isFalse(excelTemplateBO.getVertical())) {
                        vertical = WriteDirectionEnum.HORIZONTAL;
                    }
                    WriteSheet writeSheet = EasyExcel.writerSheet().build();
                    // 填充方向
                    FillConfig fillConfig = FillConfig.builder().direction(vertical).build();
                    // 如果有多个list 模板上必须有{前缀.} 这里的前缀就是 data1，然后多个list必须用 FillWrapper包裹
                    excelWriter.fill(new FillWrapper(entry.getKey()
                            , excelTemplateBO.getValue()), fillConfig, writeSheet);
                }
            }
        }
    }

    // ---- 私有方法 ----

    /**
     * 获取 模板文件
     *
     * @param template 模板
     * @return 返回 模板文件
     */
    @NotNull
    private String getTempFile(ExportTemplate template) {
        // 下载模板
        String path = MessageFormat.format("{0}/{1}", TEMPLATE_PATH, DateUtil.format(new Date(), DATE_FORMAT));
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String tempFile = MessageFormat.format("{0}/temp_{1}_{2}.{3}", path, template.getAppId(),
                template.getName(), template.getType());
        // 存在则先删除
        FileUtil.del(Paths.get(tempFile));
        // 下载模板
        HttpUtil.downloadFile(template.getUrl(), new File(tempFile));
        return tempFile;
    }

    /**
     * 获取 导出的文件
     *
     * @param template 模板文件
     * @return 返回 导出的文件
     */
    @NotNull
    private String getExportFile(ExportTemplate template) {
        // 下载模板
        String path = MessageFormat.format("{0}/{1}", DOWNLOAD_PATH, DateUtil.format(new Date(), DATE_FORMAT));
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = MessageFormat.format("{0}/{1}_{2}.{3}", path, template.getAppId(),
                template.getName(), template.getType());
        // 存在则先删除
        Path filePath = Paths.get(fileName);
        if (FileUtil.exist(filePath.toFile())) {
            FileUtil.del(filePath);
        }
        return fileName;
    }

    /**
     * 验证是否执行完成
     *
     * @param tempFile 模板文件
     * @param mapData  数据
     * @return 返回 null 则执行完成
     */
    @Nullable
    private Set<Map.Entry<String, ExcelTemplateBO>> checkHandleFinish(String tempFile
            , Map<String, ExcelTemplateBO> mapData) {
        if (MapUtil.isEmpty(mapData)) {
            // 删除模板文件
            FileUtil.del(Paths.get(tempFile));
            return null;
        }
        Set<Map.Entry<String, ExcelTemplateBO>> entrySet = mapData.entrySet();
        // 验证是否结束
        long emptyCount = entrySet.stream().filter(n -> n.getValue() == null
                || CollUtil.isEmpty(n.getValue().getValue())).count();
        if (emptyCount == entrySet.size()) {
            // 执行完成，删除模板文件
            FileUtil.del(Paths.get(tempFile));
            return null;
        }
        return entrySet;
    }
}
