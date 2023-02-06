package cn.behappyto.export.common.constant;

import cn.hutool.extra.servlet.ServletUtil;

/**
 * TaskHttpConstant
 *
 * @author behappyto.cn
 * @date 2022/09/22 11:48
 */
public class TaskHttpConstant {

    /**
     * 分页查询，当前页码的属性名称
     */
    public static final String CURRENT_PAGE_NAME = "currentPage";

    /**
     * 分页查询，当前页的属性名称
     */
    public static final String PAGE_SIZE_NAME = "pageSize";

    /**
     * 请求方法
     */
    public static final String HTTP_METHOD_NAME = ServletUtil.METHOD_GET;
}
