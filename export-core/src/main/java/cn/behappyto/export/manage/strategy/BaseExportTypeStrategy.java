package cn.behappyto.export.manage.strategy;

import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;

/**
 * 导出类型
 *
 * @author behappyto.cn
 */
public interface BaseExportTypeStrategy {

    /**
     * 处理
     *
     * @param template 模板配置
     * @param config   配置文件
     * @return 返回 处理的字符串
     */
    String handle(ExportTemplate template, ExportTask config);
}
