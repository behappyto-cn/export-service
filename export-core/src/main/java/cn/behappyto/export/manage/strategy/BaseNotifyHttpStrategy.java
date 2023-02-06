package cn.behappyto.export.manage.strategy;

import cn.behappyto.export.domain.vo.request.detail.TaskHttpAddV1Req;

import java.text.MessageFormat;

/**
 * 回调策略
 *
 * @author behappyto.cn
 */
public abstract class BaseNotifyHttpStrategy {

    /**
     * 处理回调请求
     *
     * @param taskHttpAddV1Req 任务明细
     * @param currentPage      页码
     * @return 返回 结果
     */
    public abstract String handle(TaskHttpAddV1Req taskHttpAddV1Req, Long currentPage);

    /**
     * 处理 当url的当前页的值
     *
     * @param url             请求地址
     * @param currentPageName 当前页的名称
     * @param currentPage     当前页码
     * @return 返回
     */
    protected String handleCurrentPage(String url, String currentPageName, Long currentPage) {
        // GET 请求，请求参数放到 url 地址上
        String oldStr = MessageFormat.format("{0}=\\d*", currentPageName);
        String newStr = MessageFormat.format("{0}={1}", currentPageName
                , String.valueOf(currentPage));
        // 替换分页的值
        return url.replaceAll(oldStr, newStr);
    }
}
