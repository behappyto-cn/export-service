package cn.behappyto.export.controller;

import cn.behappyto.export.biz.TemplateBiz;
import cn.behappyto.export.domain.vo.request.template.TemplateAddV1Req;
import cn.behappyto.export.domain.vo.request.template.TemplateEditV1Req;
import cn.behappyto.export.domain.vo.response.Result;
import cn.behappyto.export.domain.vo.response.template.ListV1Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 导出 的相关操作
 *
 * @author behappyto.cn
 */
@RestController
@Api(tags = "模板管理")
@RequestMapping("template")
public class TemplateController {

    @Resource
    private TemplateBiz templateBiz;

    /**
     * 查询
     *
     * @return 返回
     */
    @GetMapping("list/v1")
    @ApiOperation(value = "模板管理 - 列表查询")
    public Result<List<ListV1Resp>> list(@RequestHeader String appId) {
        return Result.ok(templateBiz.list(appId));
    }

    /**
     * 新增模板
     *
     * @param templateAddV1Req 请求参数
     * @return 返回
     */
    @PostMapping("add/v1")
    @ApiOperation(value = "模板管理 - 新增数据")
    public Result<Boolean> add(@RequestBody TemplateAddV1Req templateAddV1Req) {
        return Result.ok(templateBiz.add(templateAddV1Req));
    }

    /**
     * 修改模板
     *
     * @param templateEditV1Req 请求参数
     * @return 返回
     */
    @PostMapping("modify/v1")
    @ApiOperation(value = "模板管理 - 修改数据")
    public Result<Boolean> modify(@RequestBody TemplateEditV1Req templateEditV1Req) {
        return Result.ok(templateBiz.modify(templateEditV1Req));
    }

    /**
     * 删除模板
     *
     * @param id 主键
     * @return 返回
     */
    @DeleteMapping("delete/v1")
    @ApiOperation(value = "模板管理 - 删除数据")
    public Result<Boolean> delete(@RequestParam Long id) {
        return Result.ok(templateBiz.delete(id));
    }
}
