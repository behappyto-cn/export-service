package cn.behappyto.export.common.annotation;

import java.lang.annotation.*;

/**
 * 导出类型定义
 *
 * @author behappyto.cn
 */
@Inherited
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExportType {

    /**
     * 导出的类型
     *
     * @return 返回
     */
    String[] type();
}
