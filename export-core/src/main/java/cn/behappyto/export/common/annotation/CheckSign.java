package cn.behappyto.export.common.annotation;

import java.lang.annotation.*;

/**
 * 验证签名
 *
 * @author behappyto.cn
 * @date 2022/09/28 16:16
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckSign {
}
