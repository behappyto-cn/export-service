package cn.behappyto.export.manage.strategy;

import cn.behappyto.export.common.annotation.ExportType;
import cn.behappyto.export.common.exception.ServiceRuntimeException;
import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Map;

/**
 * 导出 类型
 *
 * @author behappyto.cn
 */
@Slf4j
@Component
public class ExportStrategy implements ApplicationContextAware {

    /**
     * 上下文
     */
    private ApplicationContext applicationContext;

    /**
     * 导出任务
     *
     * @param template 模板
     * @param config   配置信息
     * @return 返回
     */
    public String export(ExportTemplate template, ExportTask config) {
        // 获取执行的类型
        Map<String, BaseExportTypeStrategy> mapTypeStrategy = applicationContext
                .getBeansOfType(BaseExportTypeStrategy.class);
        if (MapUtil.isEmpty(mapTypeStrategy)) {
            throw new ServiceRuntimeException("暂时不支持当前的格式");
        }

        BaseExportTypeStrategy exportTypeStrategy = null;
        for (Map.Entry<String, BaseExportTypeStrategy> entry : mapTypeStrategy.entrySet()) {
            exportTypeStrategy = entry.getValue();
            // 获取
            ExportType exportType = exportTypeStrategy.getClass().getAnnotation(ExportType.class);
            if (exportType == null) {
                continue;
            }
            String[] types = exportType.type();
            if (ArrayUtil.isEmpty(types)) {
                // 正常不会出现
                continue;
            }
            if (ArrayUtil.contains(types, template.getType())) {
                // 执行后续的逻辑
                break;
            }
        }
        if (exportTypeStrategy == null) {
            log.error("没有找到可以执行的类型：{}", template.getType());
            throw new ServiceRuntimeException(MessageFormat.format("暂时不支持当前的格式：{0}", template.getType()));
        }
        // 导出的类型
        return exportTypeStrategy.handle(template, config);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
