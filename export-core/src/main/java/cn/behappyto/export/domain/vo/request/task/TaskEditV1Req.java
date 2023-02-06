package cn.behappyto.export.domain.vo.request.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 修改
 *
 * @author behappyto.cn
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@ApiModel("任务管理 - 修改请求参数")
public class TaskEditV1Req extends TaskAddV1Req {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true, example = "1")
    private Long id;
}
