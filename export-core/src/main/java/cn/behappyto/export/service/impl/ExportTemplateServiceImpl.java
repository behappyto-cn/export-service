package cn.behappyto.export.service.impl;

import cn.behappyto.export.domain.dao.entity.ExportTemplate;
import cn.behappyto.export.domain.dao.mapper.ExportTemplateMapper;
import cn.behappyto.export.service.IExportTemplateService;
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
public class ExportTemplateServiceImpl extends ServiceImpl<ExportTemplateMapper, ExportTemplate> implements IExportTemplateService {

}
