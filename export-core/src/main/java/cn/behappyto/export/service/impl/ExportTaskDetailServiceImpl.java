package cn.behappyto.export.service.impl;

import cn.behappyto.export.domain.dao.entity.ExportTaskDetail;
import cn.behappyto.export.domain.dao.mapper.ExportTaskDetailMapper;
import cn.behappyto.export.service.IExportTaskDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务明细 服务实现类
 * </p>
 *
 * @author behappyto.cn
 * @since 2022-09-22
 */
@Service
public class ExportTaskDetailServiceImpl extends ServiceImpl<ExportTaskDetailMapper
        , ExportTaskDetail> implements IExportTaskDetailService {

}
