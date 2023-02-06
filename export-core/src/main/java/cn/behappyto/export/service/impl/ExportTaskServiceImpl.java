package cn.behappyto.export.service.impl;

import cn.behappyto.export.domain.dao.entity.ExportTask;
import cn.behappyto.export.domain.dao.mapper.ExportTaskMapper;
import cn.behappyto.export.service.IExportTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author behappyto.cn
 * @since 2022-09-20
 */
@Service
public class ExportTaskServiceImpl extends ServiceImpl<ExportTaskMapper, ExportTask> implements IExportTaskService {

}
