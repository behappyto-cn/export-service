package cn.behappyto.export.biz;

import cn.behappyto.export.domain.vo.request.template.TemplateAddV1Req;
import cn.behappyto.export.domain.vo.request.template.TemplateEditV1Req;

import java.util.List;

/**
 * 模板
 *
 * @author behappyto.cn
 */
public interface TemplateBiz {

    /**
     * 查询列表
     *
     * @param appId 应用ID
     * @return 返回 列表
     */
    List list(String appId);

    /**
     * 新增模板
     *
     * @param templateAddV1Req 请求参数
     * @return 返回
     */
    Boolean add(TemplateAddV1Req templateAddV1Req);

    /**
     * 修改模板
     *
     * @param templateEditV1Req 请求参数
     * @return 返回
     */
    Boolean modify(TemplateEditV1Req templateEditV1Req);

    /**
     * 删除模板
     *
     * @param id 主键
     * @return 返回
     */
    Boolean delete(Long id);
}
