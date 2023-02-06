package cn.behappyto.export.domain.mapstruct;

import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.vo.request.task.TaskAddV1Req;
import cn.behappyto.export.domain.vo.request.task.TaskEditV1Req;
import org.mapstruct.Mapper;

/**
 * 实体转换
 *
 * @author behappyto.cn
 */
@Mapper(componentModel = "spring")
public interface TaskMapStruct {

    /**
     * 新增参数转换
     *
     * @param taskAddV1Req 新增参数
     * @return 返回 实体
     */
    TaskEditV1Req convertV1(TaskAddV1Req taskAddV1Req);

    /**
     * 新增参数转换
     *
     * @param taskAddV1Req 新增参数
     * @return 返回 实体
     */
    ExportTask convertAddV1(TaskAddV1Req taskAddV1Req);

    /**
     * 修改参数转换
     *
     * @param editV1Req 修改参数
     * @return 返回 实体
     */
    ExportTask convertEditV1(TaskEditV1Req editV1Req);
}
