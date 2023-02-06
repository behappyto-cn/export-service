package cn.behappyto.export.domain.vo.response.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 列表返回
 *
 * @author behappyto.cn
 */
@Setter
@Getter
@ToString
@ApiModel("任务管理 - 响应参数")
public class TaskListV1Resp {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true, example = "1")
    private Long id;

    /**
     * 任务名称
     */
    @ApiModelProperty(value = "任务名称", required = true, example = "财务数据")
    private String name;

    /**
     * 应用编码
     */
    @ApiModelProperty(value = "应用编码", required = true, example = "fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9")
    private String appId;

    /**
     * 处理状态（0：等待导出； 1：执行成功； -1：执行失败； 2：正在执行； 3：已经下载）
     */
    @ApiModelProperty(value = "处理状态（0：等待导出； 1：执行成功； -1：执行失败； 2：正在执行； 3：已经下载）", required = true, example = "0")
    private Integer status;

    /**
     * 模板主键
     */
    @ApiModelProperty(value = "模板主键", required = true, example = "1")
    private Long templateId;

    /**
     * 模板名称
     */
    @ApiModelProperty(value = "模板名称", required = true, example = "财务模板")
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
     * 备注
     */
    @ApiModelProperty(value = "备注", required = true, example = "财务数据")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true, example = "2022-10-01 09:00:00")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", required = true, example = "2022-10-01 09:00:00")
    private LocalDateTime updateTime;
}
