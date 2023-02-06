package cn.behappyto.export.common.exception;

import cn.behappyto.export.domain.vo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关全局异常处理器
 * 处理网关过滤器、request、response出现问题的情况
 * 不合法参数问题
 *
 * @author behappyto.cn
 * @date 2022/4/14 22:49
 */
@Slf4j
@RestController
@ControllerAdvice
public class GlobalException {

    /**
     * Throwable 兜底异常捕捉
     *
     * @param ex 异常
     * @return 返回 异常
     */
    @ExceptionHandler(value = ServiceRuntimeException.class)
    public Result<Void> handle(ServiceRuntimeException ex) {
        log.error("系统异常：", ex);
        return Result.fail(500, ex.getMessage());
    }

    /**
     * Throwable 兜底异常捕捉
     *
     * @param ex 异常
     * @return 返回 异常
     */
    @ExceptionHandler(value = Throwable.class)
    public Result<Void> handle(Throwable ex) {
        log.error("系统异常：", ex);
        return Result.fail(500, "系统异常");
    }
}
