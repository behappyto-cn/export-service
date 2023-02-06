package cn.behappyto.export.manage.strategy.http;

import cn.behappyto.export.domain.vo.request.detail.TaskHttpAddV1Req;
import cn.behappyto.export.manage.strategy.BaseNotifyHttpStrategy;
import cn.hutool.http.HttpUtil;
import lombok.Builder;

import java.text.MessageFormat;

/**
 * Post 请求通知
 *
 * @author behappyto.cn
 */
@Builder
public class NotifyHttpPost extends BaseNotifyHttpStrategy {

    @Override
    public String handle(TaskHttpAddV1Req taskHttp, Long currentPage) {
        String currentPageName = taskHttp.getCurrentPageName();
        // url的分页参数
        String url = super.handleCurrentPage(taskHttp.getUrl(), currentPageName, currentPage);
        // 请求内容的分页参数
        String body = taskHttp.getBody();
        // 格式为 "currentPage": 12
        String oldStr = MessageFormat.format("\"{0}\".*:.*\\d*", currentPageName);
        String newStr = MessageFormat.format("\"{0}\": {1}", currentPageName
                , String.valueOf(currentPage));
        // 替换分页参数
        body = body.replaceAll(oldStr, newStr);

        // post 请求
        return HttpUtil.post(url, body, taskHttp.getTimeout());
    }
}
