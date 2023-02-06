package cn.behappyto.export.domain.mapstruct;

import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.behappyto.export.domain.vo.request.template.TemplateAddV1Req;
import cn.behappyto.export.domain.vo.request.template.TemplateEditV1Req;
import org.mapstruct.Mapper;

/**
 * 实体转换
 *
 * @author behappyto.cn
 */
@Mapper(componentModel = "spring")
public interface TemplateMapStruct {

    /**
     * 新增参数转换
     *
     * @param templateAddV1Req 新增参数
     * @return 返回 实体
     */
    ExportTemplate convertAddV1(TemplateAddV1Req templateAddV1Req);

    /**
     * 修改参数转换
     *
     * @param templateEditV1Req 修改参数
     * @return 返回 实体
     */
    ExportTemplate convertEditV1(TemplateEditV1Req templateEditV1Req);
}
