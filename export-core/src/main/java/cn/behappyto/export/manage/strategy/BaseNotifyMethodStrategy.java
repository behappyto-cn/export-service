package cn.behappyto.export.manage.strategy;

import cn.behappyto.export.domain.bo.ExcelTemplateBO;
import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;

import java.util.Map;

/**
 * 通知方式
 *
 * @author behappyto.cn
 */
public abstract class BaseNotifyMethodStrategy {

    /**
     * 处理
     *
     * @param template    模板配置
     * @param config      配置文件
     * @param currentPage 当前页码
     * @return 返回 处理的字符串 Map<前缀标识，Map<填充方向 true：纵向，数据>>
     */
    public abstract Map<String, ExcelTemplateBO> handle(ExportTemplate template
            , ExportTask config, Long currentPage);
}
