package cn.behappyto.export.domain.vo.response.template;

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
@ApiModel("模板管理 - 响应参数")
public class ListV1Resp {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true, example = "1")
    private Long id;

    /**
     * 应用编码
     */
    @ApiModelProperty(value = "应用编码", required = true, example = "fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9")
    private String appId;

    /**
     * 模板名称
     */
    @ApiModelProperty(value = "模板名称", required = true, example = "财务模板")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型", required = true, example = "xlsx")
    private String type;

    /**
     * 模板路径
     */
    @ApiModelProperty(value = "模板路径", required = true, example = "http://xxx.xxx.com/demo.xlxs")
    private String url;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "财务模板")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true, example = "2022-10-01 09:00:00")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", example = "2022-10-01 09:00:00")
    private LocalDateTime updateTime;
}
