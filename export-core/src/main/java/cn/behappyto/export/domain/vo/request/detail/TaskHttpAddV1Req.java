package cn.behappyto.export.domain.vo.request.detail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * http 的请求参数
 *
 * @author behappyto.cn
 */
@Getter
@Setter
@ToString
@ApiModel("http请求 - 新增请求参数")
public class TaskHttpAddV1Req {

    /**
     * 名称（Excel填充前缀）
     */
    @ApiModelProperty(value = "名称（Excel填充前缀）", required = true, example = "data")
    private String name;

    /**
     * 回调地址
     */
    @ApiModelProperty(value = "回调地址（查询数据地址）", required = true, example = "http://137.0.0.1/listData/v1")
    private String url;

    /**
     * 请求方法
     */
    @ApiModelProperty(value = "请求方式（get、post）", required = true, example = "get")
    private String method;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数（post的请求参数）", example = "{\"name\":\"张三\"}")
    private String body;

    /**
     * 当前页的名称
     */
    @ApiModelProperty(value = "当前页参数名称（默认：currentPage）", example = "currentPage")
    private String currentPageName;

    /**
     * 每页条数名称
     */
    @ApiModelProperty(value = "每页条数名称参数名称（默认：pageSize）", example = "pageSize")
    private String pageSizeName;

    /**
     * 超时时间（单位：毫秒）
     */
    @ApiModelProperty(value = "超时时间（单位：毫秒）", example = "5000")
    private Integer timeout;

    /**
     * 纵向填充
     */
    @ApiModelProperty(value = "是否纵向填充（默认：true）", example = "true")
    private Boolean fillVertical;
}
