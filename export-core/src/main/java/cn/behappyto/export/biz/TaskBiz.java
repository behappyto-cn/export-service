package cn.behappyto.export.biz;

import cn.behappyto.export.domain.vo.request.task.TaskAddV1Req;
import cn.behappyto.export.domain.vo.request.task.TaskEditV1Req;

import java.util.List;

/**
 * http 请求的配置
 *
 * @author behappyto.cn
 */
public interface TaskBiz {

    /**
     * 查询
     *
     * @param appId appId
     * @return 返回
     */
    List list(String appId);

    /**
     * 新增
     *
     * @param taskAddV1Req 请求参数
     * @return 返回
     */
    Boolean add(TaskAddV1Req taskAddV1Req);

    /**
     * 修改
     *
     * @param editV1Req 请求参数
     * @return 返回
     */
    Boolean modify(TaskEditV1Req editV1Req);

    /**
     * 删除
     *
     * @param id 主键
     * @return 返回
     */
    Boolean delete(Long id);
}
