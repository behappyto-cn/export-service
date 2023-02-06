package cn.behappyto.export.controller;

import cn.behappyto.export.Application;
import cn.behappyto.export.common.util.JacksonUtil;
import cn.behappyto.export.controller.vo.TestReq;
import cn.behappyto.export.domain.vo.request.detail.TaskCurlEditV1Req;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpEditV1Req;
import cn.behappyto.export.domain.vo.request.task.TaskAddV1Req;
import cn.behappyto.export.domain.vo.request.task.TaskEditV1Req;
import cn.behappyto.export.domain.vo.response.Result;
import cn.behappyto.export.domain.vo.response.task.TaskListV1Resp;
import cn.hutool.json.JSONUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TaskControllerTest {

    @Resource
    private TaskController taskController;

    @Test
    public void list() {
        Result<List<TaskListV1Resp>> result = taskController.list(TemplateControllerTest.APP_ID);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        System.out.println(JSONUtil.toJsonPrettyStr(result));
    }

    @Test
    public void add() {
        TaskAddV1Req taskAddV1Req = new TaskAddV1Req();
        taskAddV1Req.setAppId(TemplateControllerTest.APP_ID);
        taskAddV1Req.setName("测试数据导出");
        taskAddV1Req.setTemplateName("unit_test_template");
        taskAddV1Req.setUserId("test");
        taskAddV1Req.setUserName("单元测试");
        List<TaskHttpEditV1Req> listHttpReq = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            TaskHttpEditV1Req taskHttpEditV1Req = new TaskHttpEditV1Req();
            taskHttpEditV1Req.setName("data" + i);
            String url = "http://localhost:8080/demo/test" + i + "?currentPage=1";
            taskHttpEditV1Req.setUrl(url);
            taskHttpEditV1Req.setMethod("get");
            taskHttpEditV1Req.setBody("");
            taskHttpEditV1Req.setCurrentPageName("currentPage");
            taskHttpEditV1Req.setPageSizeName("pageSize");
            taskHttpEditV1Req.setTimeout(5000);
            taskHttpEditV1Req.setFillVertical(true);

            listHttpReq.add(taskHttpEditV1Req);
        }
        for (int i = 2; i < 4; i++) {
            TaskHttpEditV1Req taskHttpEditV1Req = new TaskHttpEditV1Req();
            taskHttpEditV1Req.setName("data" + i);
            String url = "http://localhost:8080/demo/test" + i + "?currentPage=1";
            taskHttpEditV1Req.setUrl(url);
            taskHttpEditV1Req.setMethod("post");
            TestReq testReq = new TestReq();
            testReq.setCurrentPage(1);
            taskHttpEditV1Req.setBody(JacksonUtil.objectToJson(testReq));
            taskHttpEditV1Req.setCurrentPageName("currentPage");
            taskHttpEditV1Req.setPageSizeName("pageSize");
            taskHttpEditV1Req.setTimeout(5000);
            taskHttpEditV1Req.setFillVertical(false);

            listHttpReq.add(taskHttpEditV1Req);
        }
        taskAddV1Req.setListHttpReq(listHttpReq);

        List<TaskCurlEditV1Req> listCurlReq = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TaskCurlEditV1Req taskCurlEditV1Req = new TaskCurlEditV1Req();
            taskCurlEditV1Req.setName("curl 测试");
            taskCurlEditV1Req.setCurl("curl get");
            taskCurlEditV1Req.setTimeout(5000);
            taskCurlEditV1Req.setFillVertical(true);
            listCurlReq.add(taskCurlEditV1Req);
        }
        taskAddV1Req.setListCurlReq(listCurlReq);

        System.out.println(JSONUtil.toJsonStr(taskAddV1Req));
        Result<Boolean> result = taskController.add(taskAddV1Req);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getData(), true);
    }

    @Test
    public void modify() {
        TaskEditV1Req taskAddV1Req = new TaskEditV1Req();
        taskAddV1Req.setId(1575120787790794754L);
        taskAddV1Req.setAppId(TemplateControllerTest.APP_ID);
        taskAddV1Req.setName("测试数据导出");
        taskAddV1Req.setTemplateName("unit_test_template");
        taskAddV1Req.setUserId("test");
        taskAddV1Req.setUserName("单元测试");
        List<TaskHttpEditV1Req> listHttpReq = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            TaskHttpEditV1Req taskHttpEditV1Req = new TaskHttpEditV1Req();
            taskHttpEditV1Req.setName("data" + i);
            String url = "http://localhost:8080/demo/test" + i + "?currentPage=1";
            taskHttpEditV1Req.setUrl(url);
            taskHttpEditV1Req.setMethod("get");
            taskHttpEditV1Req.setBody("");
            taskHttpEditV1Req.setCurrentPageName("currentPage");
            taskHttpEditV1Req.setPageSizeName("pageSize");
            taskHttpEditV1Req.setTimeout(5000);
            taskHttpEditV1Req.setFillVertical(true);

            listHttpReq.add(taskHttpEditV1Req);
        }
        for (int i = 2; i < 4; i++) {
            TaskHttpEditV1Req taskHttpEditV1Req = new TaskHttpEditV1Req();
            taskHttpEditV1Req.setName("data" + i);
            String url = "http://localhost:8080/demo/test" + i + "?currentPage=1";
            taskHttpEditV1Req.setUrl(url);
            taskHttpEditV1Req.setMethod("post");
            TestReq testReq = new TestReq();
            testReq.setCurrentPage(1);
            taskHttpEditV1Req.setBody(JacksonUtil.objectToJson(testReq));
            taskHttpEditV1Req.setCurrentPageName("currentPage");
            taskHttpEditV1Req.setPageSizeName("pageSize");
            taskHttpEditV1Req.setTimeout(5000);
            taskHttpEditV1Req.setFillVertical(false);

            listHttpReq.add(taskHttpEditV1Req);
        }
        taskAddV1Req.setListHttpReq(listHttpReq);

        List<TaskCurlEditV1Req> listCurlReq = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TaskCurlEditV1Req taskCurlEditV1Req = new TaskCurlEditV1Req();
            taskCurlEditV1Req.setName("data" + i);
            taskCurlEditV1Req.setCurl("curl get");
            taskCurlEditV1Req.setTimeout(5000);
            taskCurlEditV1Req.setFillVertical(true);
            listCurlReq.add(taskCurlEditV1Req);
        }
        taskAddV1Req.setListCurlReq(listCurlReq);
        System.out.println(JSONUtil.toJsonStr(taskAddV1Req));

        Result<Boolean> result = taskController.modify(taskAddV1Req);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getData(), true);
    }

    @Test
    public void delete() {
        Result<Boolean> result = taskController.delete(1575120787790794754L);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getData(), true);
    }
}
