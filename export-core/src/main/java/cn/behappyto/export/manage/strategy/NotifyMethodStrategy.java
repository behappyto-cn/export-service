package cn.behappyto.export.manage.strategy;

import cn.behappyto.export.common.util.JacksonUtil;
import cn.behappyto.export.domain.bo.ExcelTemplateBO;
import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTaskDetail;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.behappyto.export.domain.vo.request.detail.TaskCurlAddV1Req;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpAddV1Req;
import cn.behappyto.export.service.IExportTaskDetailService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RuntimeUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通知方式
 *
 * @author behappyto.cn
 */
@Component
public class NotifyMethodStrategy extends BaseNotifyMethodStrategy {

    @Resource
    private IExportTaskDetailService taskDetailService;

    @Override
    public Map<String, ExcelTemplateBO> handle(ExportTemplate template, ExportTask config, Long currentPage) {
        Map<String, ExcelTemplateBO> templateBOMap = new HashMap<>(16);

        List<ExportTaskDetail> listHttpConfig = taskDetailService.list(Wrappers.lambdaQuery(ExportTaskDetail.class)
                .eq(ExportTaskDetail::getTaskId, config.getId()));
        if (CollUtil.isEmpty(listHttpConfig)) {
            return MapUtil.empty();
        }
        for (ExportTaskDetail taskDetail : listHttpConfig) {
            switch (taskDetail.getMethod()) {
                // http 请求
                case "http":
                    this.getHttpResp(currentPage, templateBOMap, taskDetail);
                    break;
                case "curl":
                    this.getCurlResp(templateBOMap, taskDetail);
                    break;
                case "dubbo":
                    // dubbo rpc 的请求方式
                    break;
                case "grpc":
                    // grpc 的请求方式
                    break;
                default:
                    break;
            }
        }
        // 返回结果
        return templateBOMap;
    }

    // ------ 私有方法 -----

    /**
     * 获取 curl 的结果
     *
     * @param templateBOMap 返回结果
     * @param taskDetail    任务明细
     */
    private void getCurlResp(Map<String, ExcelTemplateBO> templateBOMap, ExportTaskDetail taskDetail) {
        // curl 的请求方式 反序列化参数
        TaskCurlAddV1Req taskCurlReq = JacksonUtil.jsonToObject(taskDetail.getParam()
                , new TypeReference<TaskCurlAddV1Req>() {
                });
        if (taskCurlReq == null) {
            return;
        }
        // 执行 curl 请求
        String execForCurl = RuntimeUtil.execForStr(taskCurlReq.getCurl());
        // 参数值
        ExcelTemplateBO templateBO = new ExcelTemplateBO();
        // 填充方向
        templateBO.setVertical(taskCurlReq.getFillVertical());
        templateBO.setValue(JacksonUtil.jsonToObject(execForCurl, new TypeReference<List>() {
        }));

        // 赋值
        templateBOMap.put(taskCurlReq.getName(), templateBO);
    }

    /**
     * 获取 http 的结果
     *
     * @param templateBOMap 返回结果
     * @param taskDetail    任务明细
     */
    private void getHttpResp(Long currentPage, Map<String, ExcelTemplateBO> templateBOMap, ExportTaskDetail taskDetail) {
        // 反序列化参数
        TaskHttpAddV1Req taskHttpReq = JacksonUtil.jsonToObject(taskDetail.getParam()
                , new TypeReference<TaskHttpAddV1Req>() {
                });
        if (taskHttpReq == null) {
            return;
        }
        // 执行 http 请求
        String respHttp = NotifyHttpStrategy.builder().build()
                .handle(taskHttpReq, currentPage);
        // 参数值
        ExcelTemplateBO templateBO = new ExcelTemplateBO();
        // 填充方向
        templateBO.setVertical(taskHttpReq.getFillVertical());
        templateBO.setValue(JacksonUtil.jsonToObject(respHttp, new TypeReference<List>() {
        }));

        // 赋值
        templateBOMap.put(taskDetail.getName(), templateBO);
    }
}
