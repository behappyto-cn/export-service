package cn.behappyto.export.biz.impl;

import cn.behappyto.export.biz.ExportTaskBiz;
import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.behappyto.export.manage.strategy.ExportStrategy;
import cn.behappyto.export.service.IExportTaskService;
import cn.behappyto.export.service.IExportTemplateService;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 导出任务
 *
 * @author behappyto.cn
 */
@Slf4j
@Component
public class ExportTaskBizImpl implements ExportTaskBiz {

    @Resource
    private IExportTaskService taskService;

    @Resource
    private IExportTemplateService templateService;

    @Resource
    private ExportStrategy exportStrategy;

    @Override
    public Boolean execute(int sliceNum, int status) {
        // 查询数据
        Page<ExportTask> configPage = taskService.page(new Page<>(0, 10)
                , Wrappers.lambdaQuery(ExportTask.class)
                        // 处理最近一天的数据
                        .ge(ExportTask::getCreateTime, LocalDateTime.now().plusDays(-1))
                        .eq(ExportTask::getStatus, status)
                        .eq(ExportTask::getSliceNum, sliceNum));
        if (configPage == null || CollUtil.isEmpty(configPage.getRecords())) {
            return true;
        }
        List<ExportTask> configList = configPage.getRecords();
        for (ExportTask task : configList) {
            // 查询 模板信息
            ExportTemplate exportTemplate = templateService.getOne(Wrappers.lambdaQuery(ExportTemplate.class)
                    .eq(ExportTemplate::getAppId, task.getAppId())
                    .eq(ExportTemplate::getName, task.getTemplateName()));
            if (exportTemplate == null) {
                continue;
            }
            // 执行导出任务, 1、导出类型 2、导出方式
            String exportUrl;
            try {
                exportUrl = exportStrategy.export(exportTemplate, task);

                // 更新下载地址
                task.setUrl(exportUrl);
                // 更新状态
                task.setStatus(Strings.isNotBlank(exportUrl) ? 1 : -1);
            } catch (Exception e) {
                log.error("导出失败：{}", e);
                task.setRemark(MessageFormat.format("导出失败：{0}", e.getMessage()));
                task.setStatus(-1);
            }
            // 更新处理状态
            task.setUpdateTime(LocalDateTime.now());
            taskService.updateById(task);
        }
        return true;
    }
}
