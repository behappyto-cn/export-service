package cn.behappyto.export.biz.impl;

import cn.behappyto.export.biz.TemplateBiz;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.behappyto.export.domain.mapstruct.TemplateMapStruct;
import cn.behappyto.export.domain.vo.request.template.TemplateAddV1Req;
import cn.behappyto.export.domain.vo.request.template.TemplateEditV1Req;
import cn.behappyto.export.service.IExportTemplateService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 模板
 *
 * @author behappyto.cn
 */
@Component
public class TemplateBizImpl implements TemplateBiz {

    @Resource
    private IExportTemplateService templateService;

    @Resource
    private TemplateMapStruct templateMapStruct;

    @Override
    public List list(String appId) {
        return templateService.list(Wrappers.lambdaQuery(ExportTemplate.class)
                .eq(ExportTemplate::getAppId, appId));
    }

    @Override
    public Boolean add(TemplateAddV1Req templateAddV1Req) {
        return templateService.save(templateMapStruct.convertAddV1(templateAddV1Req));
    }

    @Override
    public Boolean modify(TemplateEditV1Req templateEditV1Req) {
        return templateService.updateById(templateMapStruct.convertEditV1(templateEditV1Req));
    }

    @Override
    public Boolean delete(Long id) {
        return templateService.removeById(id);
    }
}
