package cn.behappyto.export.common.util;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * ClassLoaderUtil
 *
 * @author behappyto.cn
 * @date 2022/09/19 20:03
 */
public class ClassLoaderUtil {

    public static JavaCompiler compiler;

    static {
        // 获取java的编译器
        compiler = ToolProvider.getSystemJavaCompiler();
    }

    /**
     * 根据内容编译为 class 类
     *
     * @param content 代码内容
     * @return 返回
     */
    public static Class<?> getClass(String content) {

        return null;
    }
}
