package cn.behappyto.export.domain.vo.response;

import cn.behappyto.export.common.constant.StatusConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 返回结果
 *
 * @author behappyto.cn
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("响应结果 - 通用响应参数")
public class Result<T> {

    /**
     * 编码
     */
    @ApiModelProperty("状态码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty("提示信息")
    private String message;

    /**
     * 数据
     */
    @ApiModelProperty("响应数据")
    private T data;

    /**
     * 成功
     *
     * @param data 返回结果
     * @param <T>  泛型
     * @return 返回 结果
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(StatusConstant.OK, "操作成功", data);
    }

    /**
     * 操作失败
     *
     * @return 返回 结果
     */
    public static <T> Result<T> fail() {
        return fail(StatusConstant.FAIL);
    }

    /**
     * 操作失败
     *
     * @param code 编码
     * @return 返回 结果
     */
    public static <T> Result<T> fail(Integer code) {
        return fail(code, "操作失败");
    }

    /**
     * 操作失败
     *
     * @param code    编码
     * @param message 提示信息
     * @return 返回 结果
     */
    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }
}
