package cn.behappyto.export.service.impl;

import cn.behappyto.export.Application;
import cn.behappyto.export.common.util.JacksonUtil;
import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.entity.ExportTaskDetail;
import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpAddV1Req;
import cn.behappyto.export.service.IExportTaskDetailService;
import cn.behappyto.export.service.IExportTaskService;
import cn.behappyto.export.service.IExportTemplateService;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ExportTaskServiceImplTest {

    @Resource
    private IExportTemplateService templateService;

    @Resource
    private IExportTaskService taskService;

    @Resource
    private IExportTaskDetailService taskDetailService;

    @Test
    public void test() {
        String templateUrl = "http://localhost:8080/template.xlsx";
        String uuid = IdUtil.fastUUID();

        ExportTemplate template = new ExportTemplate();
        template.setAppId(uuid);
        template.setName("测试模板");
        template.setUrl(templateUrl);
        templateService.save(template);

        ExportTask exportTask = new ExportTask();
        exportTask.setName("测试任务");

        exportTask.setAppId(uuid);
        exportTask.setTemplateName("模板名称");
        exportTask.setUserId("1");
        exportTask.setUserName("佚名");
        taskService.save(exportTask);

        ExportTaskDetail taskDetail = new ExportTaskDetail();
        taskDetail.setTaskId(exportTask.getId());
        taskDetail.setName("data");
        taskDetail.setMethod("http");

        TaskHttpAddV1Req taskHttp = new TaskHttpAddV1Req();
        taskHttp.setName("data");
        taskHttp.setUrl("http://localhost:8080/demo/test");
        taskHttp.setMethod("GET");
        taskHttp.setBody("");
        taskHttp.setFillVertical(false);
        taskHttp.setCurrentPageName("currentPage");
        taskHttp.setPageSizeName("pageSize");
        taskHttp.setTimeout(5000);

        taskDetail.setParam(JacksonUtil.objectToJson(taskHttp));

        taskDetailService.save(taskDetail);
    }
}
