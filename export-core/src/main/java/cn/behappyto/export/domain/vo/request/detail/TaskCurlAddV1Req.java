package cn.behappyto.export.domain.vo.request.detail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * TaskCurlEditV1Req
 *
 * @author behappyto.cn
 * @date 2022/09/27 11:28
 */
@Getter
@Setter
@ToString
@ApiModel("curl请求 - 请求参数")
public class TaskCurlAddV1Req {

    /**
     * 名称（Excel填充前缀）
     */
    @ApiModelProperty(value = "名称（Excel填充前缀）", required = true, example = "data")
    private String name;

    /**
     * curl 的值
     */
    @ApiModelProperty(value = "curl命令", required = true, example = "curl GET xxxx")
    private String curl;

    /**
     * 超时时间（单位：毫秒）
     */
    @ApiModelProperty(value = "超时时间（单位：毫秒）", required = true, example = "5000")
    private Integer timeout;

    /**
     * 纵向填充
     */
    @ApiModelProperty(value = "是否纵向填充（默认：true）", required = true, example = "true")
    private Boolean fillVertical;
}
