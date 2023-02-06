package cn.behappyto.export.domain.vo.request.template;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 新增查询
 *
 * @author behappyto.cn
 */
@Getter
@Setter
@ToString
@ApiModel("模板管理 - 新增请求参数")
public class TemplateAddV1Req {

    /**
     * 应用编码
     */
    @ApiModelProperty(value = "应用编码", required = true, example = "fa08ae66-00b5-4fa7-a28c-fa6c6d117fa9")
    private String appId;

    /**
     * 模板名称
     */
    @ApiModelProperty(value = "模板名称", required = true, example = "cai_wu_template")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty(value = "模板类型（目前支持：xls、xlsx）", required = true, example = "xlsx")
    private String type;

    /**
     * 模板路径
     */
    @ApiModelProperty(value = "模板路径", required = true, example = "https://xxx.xxx.com/demo.xlsx")
    private String url;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "工资模板")
    private String remark;
}
