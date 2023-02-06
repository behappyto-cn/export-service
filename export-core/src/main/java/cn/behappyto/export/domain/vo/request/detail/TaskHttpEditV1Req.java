package cn.behappyto.export.domain.vo.request.detail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * http 的请求参数
 *
 * @author behappyto.cn
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel("http请求 - 请求参数")
public class TaskHttpEditV1Req extends TaskHttpAddV1Req {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true, example = "1")
    private Long id;
}
