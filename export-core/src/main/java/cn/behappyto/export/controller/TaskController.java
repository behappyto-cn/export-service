package cn.behappyto.export.controller;

import cn.behappyto.export.biz.TaskBiz;
import cn.behappyto.export.domain.vo.request.task.TaskAddV1Req;
import cn.behappyto.export.domain.vo.request.task.TaskEditV1Req;
import cn.behappyto.export.domain.vo.response.Result;
import cn.behappyto.export.domain.vo.response.task.TaskListV1Resp;
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
@RequestMapping("task")
@Api(tags = "任务管理")
public class TaskController {

    @Resource
    private TaskBiz taskBiz;

    /**
     * 查询
     *
     * @param appId appId
     * @return 返回
     */
    @GetMapping("list/v1")
    @ApiOperation("任务管理 - 查询列表")
    public Result<List<TaskListV1Resp>> list(@RequestHeader String appId) {
        return Result.ok(taskBiz.list(appId));
    }

    /**
     * 新增
     *
     * @param taskAddV1Req 请求参数
     * @return 返回
     */
    @PostMapping("add/v1")
    @ApiOperation("任务管理 - 新增数据")
    public Result<Boolean> add(@RequestBody TaskAddV1Req taskAddV1Req) {
        return Result.ok(taskBiz.add(taskAddV1Req));
    }

    /**
     * 修改
     *
     * @param editV1Req 请求参数
     * @return 返回
     */
    @PostMapping("modify/v1")
    @ApiOperation("任务管理 - 修改数据")
    public Result<Boolean> modify(@RequestBody TaskEditV1Req editV1Req) {
        return Result.ok(taskBiz.modify(editV1Req));
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return 返回
     */
    @DeleteMapping("delete/v1")
    @ApiOperation("任务管理 - 删除数据")
    public Result<Boolean> delete(@RequestParam Long id) {
        return Result.ok(taskBiz.delete(id));
    }
}
