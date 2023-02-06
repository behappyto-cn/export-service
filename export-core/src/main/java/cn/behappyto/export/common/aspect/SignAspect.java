package cn.behappyto.export.common.aspect;

import cn.behappyto.export.common.annotation.CheckSign;
import cn.behappyto.export.common.constant.HeaderConstant;
import cn.behappyto.export.common.exception.ServiceRuntimeException;
import cn.behappyto.export.domain.dao.entity.ExportApp;
import cn.behappyto.export.service.IExportAppService;
import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * 签名验证
 *
 * @author behappyto.cn
 */
@Slf4j
@Aspect
@Component
public class SignAspect {

    @Resource
    private HttpServletRequest request;

    @Resource
    private IExportAppService appService;

    /**
     * 切点
     */
    @Pointcut(value = "@annotation(cn.behappyto.export.common.annotation.CheckSign)")
    public void doPointCut() {
    }

    /**
     * 环绕通知
     *
     * @param pjp pjp
     * @return 返回 结果
     * @throws Throwable 抛出异常，应该放在全局异常类
     */
    @Around(value = "doPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Class<?> clz = pjp.getTarget().getClass();
        if (this.checkSign(pjp, clz)) {
            return pjp.proceed();
        }

        return pjp.proceed();
    }

    /**
     * 权限 校验
     *
     * @param pjp pjp
     * @param clz 类
     * @return 返回 是否成功
     */
    private boolean checkSign(ProceedingJoinPoint pjp, Class<?> clz) {
        CheckSign checkSign = clz.getAnnotation(CheckSign.class);
        if (checkSign == null) {
            Method method = this.getMethod(pjp);
            if (method == null) {
                return true;
            }
            checkSign = clz.getAnnotation(CheckSign.class);
        }
        if (checkSign == null) {
            return true;
        }
        String appId = request.getHeader(HeaderConstant.TOKEN_APP_ID);
        String appSecret = request.getHeader(HeaderConstant.TOKEN_APP_SECRET);
        // 权限验证，下面的可以加缓存
        ExportApp exportApp = appService.getOne(Wrappers.lambdaQuery(ExportApp.class)
                .eq(ExportApp::getAppId, appId));
        if (exportApp == null) {
            throw new ServiceRuntimeException("权限不合法");
        }
        // base64(md5(appId+appSecret))
        String secret = Base64Encoder.encode(MD5.create().digest(MessageFormat.format("{0}{1}"
                , exportApp.getAppId(), exportApp.getAppSecret())));
        if (!StrUtil.equals(appSecret, secret)) {
            throw new ServiceRuntimeException("权限不合法");
        }
        return true;
    }

    /**
     * 获取 方法
     *
     * @param pjp 请求参数
     * @return 返回 方法
     */
    @SneakyThrows
    private Method getMethod(ProceedingJoinPoint pjp) {
        Signature sig = pjp.getSignature();
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        MethodSignature methodSignature = (MethodSignature) sig;
        Object target = pjp.getTarget();
        return target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }
}
