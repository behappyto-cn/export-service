package cn.behappyto.export.common.exception.Illegal;

/**
 * IllegalParamException
 *
 * @author behappyto.cn
 * @date 2022/4/14 23:03
 */
public class IllegalParamException extends RuntimeException {

    /**
     * 异常
     *
     * @param message 错误信息
     */
    public IllegalParamException(String message) {
        super(message);
    }
}
