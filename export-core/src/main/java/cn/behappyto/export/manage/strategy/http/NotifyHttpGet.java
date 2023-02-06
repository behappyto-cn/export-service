package cn.behappyto.export.manage.strategy.http;

import cn.behappyto.export.domain.vo.request.detail.TaskHttpAddV1Req;
import cn.behappyto.export.manage.strategy.BaseNotifyHttpStrategy;
import cn.hutool.http.HttpUtil;
import lombok.Builder;

/**
 * GET 请求通知
 *
 * @author behappyto.cn
 */
@Builder
public class NotifyHttpGet extends BaseNotifyHttpStrategy {

    @Override
    public String handle(TaskHttpAddV1Req taskHttp, Long currentPage) {
        String url = super.handleCurrentPage(taskHttp.getUrl(), taskHttp.getCurrentPageName(), currentPage);
        // GET 请求
        return HttpUtil.get(url, taskHttp.getTimeout());
    }
}
