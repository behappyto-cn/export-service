package cn.behappyto.export.biz.impl;

import cn.behappyto.export.biz.TaskBiz;
import cn.behappyto.export.common.util.JacksonUtil;
import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTaskDetail;
import cn.behappyto.export.domain.mapstruct.TaskDetailMapStruct;
import cn.behappyto.export.domain.mapstruct.TaskMapStruct;
import cn.behappyto.export.domain.vo.request.detail.TaskCurlEditV1Req;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpEditV1Req;
import cn.behappyto.export.domain.vo.request.task.TaskAddV1Req;
import cn.behappyto.export.domain.vo.request.task.TaskEditV1Req;
import cn.behappyto.export.service.IExportTaskDetailService;
import cn.behappyto.export.service.IExportTaskService;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 业务操作
 *
 * @author behappyto.cn
 */
@Component
public class TaskBizImpl implements TaskBiz {

    @Resource
    private IExportTaskService taskService;

    @Resource
    private IExportTaskDetailService taskDetailService;

    @Resource
    private TaskMapStruct taskMapStruct;

    @Resource
    private TaskDetailMapStruct taskDetailMapStruct;

    @Override
    public List list(String appId) {
        return taskService.list(Wrappers.lambdaQuery(ExportTask.class)
                .eq(ExportTask::getAppId, appId));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Boolean add(TaskAddV1Req taskAddV1Req) {
        // 新增配置信息
        ExportTask exportTask = this.taskMapStruct.convertAddV1(taskAddV1Req);
        // 设置模板

        boolean save = taskService.save(exportTask);
        if (!save) {
            return false;
        }
        List<ExportTaskDetail> taskDetailList = new ArrayList<>();
        // 对象转换
        TaskEditV1Req taskEditV1Req = taskMapStruct.convertV1(taskAddV1Req);
        // 处理 http 请求
        this.handleHttp(exportTask, taskEditV1Req, taskDetailList);
        // 处理 curl 请求
        this.handleCurl(exportTask, taskEditV1Req, taskDetailList);

        return taskDetailService.saveBatch(taskDetailList);
    }

    @Override
    public Boolean modify(TaskEditV1Req editV1Req) {
        // 新增配置信息
        ExportTask exportTask = this.taskMapStruct.convertEditV1(editV1Req);
        boolean update = taskService.updateById(exportTask);
        if (!update) {
            return false;
        }
        List<ExportTaskDetail> taskDetailList = new ArrayList<>();
        // 处理 http 请求
        this.handleHttp(exportTask, editV1Req, taskDetailList);
        // 处理 curl 请求
        this.handleCurl(exportTask, editV1Req, taskDetailList);

        return taskDetailService.updateBatchById(taskDetailList);
    }

    @Override
    public Boolean delete(Long id) {
        ExportTask exportTask = new ExportTask();
        exportTask.setId(id);
        exportTask.setDeleted(true);
        return taskService.updateById(exportTask);
    }

    // ------ 私有方法 ------

    /**
     * 处理 http 请求
     *
     * @param exportTask     导出任务
     * @param taskEditV1Req  请求参数
     * @param taskDetailList 任务明细
     */
    private void handleHttp(ExportTask exportTask, TaskEditV1Req taskEditV1Req, List<ExportTaskDetail> taskDetailList) {
        List<TaskHttpEditV1Req> listHttpReq = taskEditV1Req.getListHttpReq();
        if (CollUtil.isNotEmpty(listHttpReq)) {
            // 處理請求
            for (TaskHttpEditV1Req httpEditV1Req : listHttpReq) {
                // http 请求
                ExportTaskDetail taskDetail = this.taskDetailMapStruct.convertEditHttpV1(httpEditV1Req);
                taskDetail.setTaskId(exportTask.getId());
                taskDetail.setMethod("http");
                // 具体参数
                taskDetail.setParam(JacksonUtil.objectToJson(httpEditV1Req));
                // 保存数据
                taskDetailList.add(taskDetail);
            }
        }
    }

    /**
     * 处理 curl 请求
     *
     * @param exportTask     导出任务
     * @param taskEditV1Req  请求参数
     * @param taskDetailList 任务明细
     */
    private void handleCurl(ExportTask exportTask, TaskEditV1Req taskEditV1Req, List<ExportTaskDetail> taskDetailList) {
        List<TaskCurlEditV1Req> listHttpReq = taskEditV1Req.getListCurlReq();
        if (CollUtil.isNotEmpty(listHttpReq)) {
            // 處理請求
            for (TaskCurlEditV1Req curlEditV1Req : listHttpReq) {
                // curl 请求
                ExportTaskDetail taskDetail = this.taskDetailMapStruct.convertEditCurlV1(curlEditV1Req);
                taskDetail.setTaskId(exportTask.getId());
                taskDetail.setMethod("curl");
                // 具体参数
                taskDetail.setParam(JacksonUtil.objectToJson(curlEditV1Req));
                // 保存数据
                taskDetailList.add(taskDetail);
            }
        }
    }
}
