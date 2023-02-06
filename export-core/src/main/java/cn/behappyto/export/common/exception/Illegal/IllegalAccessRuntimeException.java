package cn.behappyto.export.common.exception.Illegal;

/**
 * IllegalAccessRuntimeException
 *
 * @author behappyto.cn
 * @date 2022/4/14 23:03
 */
public class IllegalAccessRuntimeException extends RuntimeException {

    /**
     * 异常
     */
    public IllegalAccessRuntimeException() {
        super("参数不合法");
    }

    /**
     * 异常
     *
     * @param message 错误信息
     */
    public IllegalAccessRuntimeException(String message) {
        super(message);
    }
}
