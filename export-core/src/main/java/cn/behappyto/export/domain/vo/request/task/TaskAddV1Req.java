package cn.behappyto.export.domain.vo.request.task;

import cn.behappyto.export.domain.vo.request.detail.TaskCurlEditV1Req;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpEditV1Req;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 新增查询
 *
 * @author behappyto.cn
 */
@Getter
@Setter
@ToString
@ApiModel("任务管理 - 新增请求参数")
public class TaskAddV1Req {

    /**
     * 应用编码
     */
    @ApiModelProperty(value = "应用编码", required = true, example = "fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9")
    private String appId;

    /**
     * 任务名称
     */
    @ApiModelProperty(value = "任务名称", required = true, example = "工资数据")
    private String name;

    /**
     * 模板名称
     */
    @ApiModelProperty(value = "所属模板", required = true, example = "1")
    private String templateName;

    /**
     * 用户编码
     */
    @ApiModelProperty(value = "用户编码", required = true, example = "zhang-san")
    private String userId;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称", required = true, example = "张三")
    private String userName;

    /**
     * http 请求的请求参数
     */
    @ApiModelProperty(value = "http请求参数", example = "参考：http请求 - 请求参数")
    private List<TaskHttpEditV1Req> listHttpReq;

    /**
     * curl 请求的请求参数
     */
    @ApiModelProperty(value = "curl请求参数", example = "参考：curl请求 - 请求参数")
    private List<TaskCurlEditV1Req> listCurlReq;
}
