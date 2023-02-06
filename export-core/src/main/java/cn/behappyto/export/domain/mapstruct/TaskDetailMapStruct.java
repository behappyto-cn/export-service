package cn.behappyto.export.domain.mapstruct;

import cn.behappyto.export.domain.dao.entity.ExportTaskDetail;
import cn.behappyto.export.domain.vo.request.detail.TaskCurlAddV1Req;
import cn.behappyto.export.domain.vo.request.detail.TaskCurlEditV1Req;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpAddV1Req;
import cn.behappyto.export.domain.vo.request.detail.TaskHttpEditV1Req;
import org.mapstruct.Mapper;

/**
 * 实体转换
 *
 * @author behappyto.cn
 */
@Mapper(componentModel = "spring")
public interface TaskDetailMapStruct {

    /**
     * 新增参数转换
     *
     * @param addV1Req 新增参数
     * @return 返回 实体
     */
    ExportTaskDetail convertAddHttpV1(TaskHttpAddV1Req addV1Req);

    /**
     * 修改参数转换
     *
     * @param editV1Req 修改参数
     * @return 返回 实体
     */
    ExportTaskDetail convertEditHttpV1(TaskHttpEditV1Req editV1Req);

    /**
     * 新增参数转换
     *
     * @param addV1Req 新增参数
     * @return 返回 实体
     */
    ExportTaskDetail convertAddCurlV1(TaskCurlAddV1Req addV1Req);

    /**
     * 修改参数转换
     *
     * @param editV1Req 修改参数
     * @return 返回 实体
     */
    ExportTaskDetail convertEditCurlV1(TaskCurlEditV1Req editV1Req);
}
