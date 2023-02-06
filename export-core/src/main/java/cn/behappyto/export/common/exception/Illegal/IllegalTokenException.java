package cn.behappyto.export.common.exception.Illegal;

/**
 * IllegalTokenException
 *
 * @author behappyto.cn
 * @date 2022/4/14 23:02
 */
public class IllegalTokenException extends RuntimeException {

    /**
     * 异常
     *
     * @param message 错误信息
     */
    public IllegalTokenException(String message) {
        super(message);
    }
}
