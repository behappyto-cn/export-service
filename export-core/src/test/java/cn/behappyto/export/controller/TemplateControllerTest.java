package cn.behappyto.export.controller;

import cn.behappyto.export.Application;
import cn.behappyto.export.domain.vo.request.template.TemplateAddV1Req;
import cn.behappyto.export.domain.vo.request.template.TemplateEditV1Req;
import cn.behappyto.export.domain.vo.response.Result;
import cn.behappyto.export.domain.vo.response.template.ListV1Resp;
import cn.hutool.json.JSONUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TemplateControllerTest {

    public static final String APP_ID = "fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9";

    @Resource
    private TemplateController templateController;

    @Test
    public void list() {
        Result<List<ListV1Resp>> result = templateController.list(APP_ID);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getData());
        System.out.println(JSONUtil.toJsonPrettyStr(result));
    }

    @Test
    public void add() {
        TemplateAddV1Req templateAddV1Req = new TemplateAddV1Req();
        templateAddV1Req.setAppId(APP_ID);
        templateAddV1Req.setName("测试模板");
        templateAddV1Req.setType("xlsx");
        templateAddV1Req.setUrl("http://localhost:8080/template.xlsx");
        templateAddV1Req.setRemark("测试模板 - 单元测试");

        Result<Boolean> result = templateController.add(templateAddV1Req);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getData(), true);
    }

    @Test
    public void modify() {
        TemplateEditV1Req templateAddV1Req = new TemplateEditV1Req();
        templateAddV1Req.setId(2L);
        templateAddV1Req.setAppId(APP_ID);
        templateAddV1Req.setName("测试模板");
        templateAddV1Req.setType("xlsx");
        templateAddV1Req.setUrl("http://localhost:8080/template.xlsx");
        templateAddV1Req.setRemark("测试模板 - 单元测试");

        Result<Boolean> result = templateController.modify(templateAddV1Req);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getData(), true);
    }

    @Test
    public void delete() {
        Result<Boolean> result = templateController.delete(2L);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getData(), true);
    }
}
