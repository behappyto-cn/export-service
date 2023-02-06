package cn.behappyto.export.domain.vo.request.detail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@ApiModel("curl请求 - 请求参数")
public class TaskCurlEditV1Req extends TaskCurlAddV1Req {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", example = "1")
    private Long id;
}
