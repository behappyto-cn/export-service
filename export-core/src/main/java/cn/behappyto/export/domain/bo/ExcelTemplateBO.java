package cn.behappyto.export.domain.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * excel 模板
 *
 * @author behappyto.cn
 * @date 2022/09/19 20:43
 */
@Setter
@Getter
public class ExcelTemplateBO {

    /**
     * 是否纵向
     */
    private Boolean vertical;

    /**
     * 值
     */
    private List value;
}
