package cn.behappyto.export.common.exception;

/**
 * ServiceRuntimeException
 *
 * @author behappyto.cn
 * @date 2022/09/19 20:11
 */
public class ServiceRuntimeException extends RuntimeException {

    /**
     * 异常
     */
    public ServiceRuntimeException() {
        super("参数不合法");
    }

    /**
     * 异常
     *
     * @param message 错误信息
     */
    public ServiceRuntimeException(String message) {
        super(message);
    }
}
