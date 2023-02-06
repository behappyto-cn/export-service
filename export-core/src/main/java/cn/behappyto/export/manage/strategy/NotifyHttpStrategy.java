package cn.behappyto.export.manage.strategy;

import cn.behappyto.export.common.constant.TaskHttpConstant;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpAddV1Req;
import cn.behappyto.export.manage.strategy.http.NotifyHttpGet;
import cn.behappyto.export.manage.strategy.http.NotifyHttpPost;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * 通知
 *
 * @author behappyto.cn
 */
@Setter
@Getter
@Builder
@Component
public class NotifyHttpStrategy extends BaseNotifyHttpStrategy {

    @Override
    public String handle(TaskHttpAddV1Req taskHttpAddV1Req, Long currentPage) {
        if (StrUtil.isBlankIfStr(taskHttpAddV1Req.getMethod())) {
            taskHttpAddV1Req.setMethod(TaskHttpConstant.HTTP_METHOD_NAME);
        }
        if (StrUtil.isBlankIfStr(taskHttpAddV1Req.getCurrentPageName())) {
            taskHttpAddV1Req.setCurrentPageName(TaskHttpConstant.CURRENT_PAGE_NAME);
        }
        if (StrUtil.isBlankIfStr(taskHttpAddV1Req.getPageSizeName())) {
            taskHttpAddV1Req.setPageSizeName(TaskHttpConstant.PAGE_SIZE_NAME);
        }
        // 处理参数
        switch (taskHttpAddV1Req.getMethod().toUpperCase()) {
            case ServletUtil.METHOD_GET:
                return NotifyHttpGet.builder().build()
                        .handle(taskHttpAddV1Req, currentPage);
            case ServletUtil.METHOD_POST:
                return NotifyHttpPost.builder().build()
                        .handle(taskHttpAddV1Req, currentPage);
            default:
                break;
        }
        // 默认 GET 请求
        return NotifyHttpGet.builder().build()
                .handle(taskHttpAddV1Req, currentPage);
    }
}
