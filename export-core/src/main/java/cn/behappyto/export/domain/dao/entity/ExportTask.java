package cn.behappyto.export.domain.dao.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 导出任务
 * </p>
 *
 * @author behappyto.cn
 * @since 2022-09-26
 */
@TableName("export_task")
public class ExportTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 应用编码
     */
    private String appId;

    /**
     * 处理状态（0：等待导出； 1：执行成功； -1：执行失败； 2：正在执行； 3：已经下载）
     */
    private Integer status;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 用户编码
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 回调方式
     */
    private String method;

    /**
     * 分片的值
     */
    private Integer sliceNum;

    /**
     * 文件地址
     */
    private String url;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否有效（0：无效  1：有效）
     */
    private Boolean enabled;

    /**
     * 是否删除（0：正常 1：删除）
     */
    @TableLogic(delval = "1")
    private Boolean deleted;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getSliceNum() {
        return sliceNum;
    }

    public void setSliceNum(Integer sliceNum) {
        this.sliceNum = sliceNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ExportTask{" +
                "id=" + id +
                ", name=" + name +
                ", appId=" + appId +
                ", status=" + status +
                ", templateName=" + templateName +
                ", userId=" + userId +
                ", userName=" + userName +
                ", method=" + method +
                ", sliceNum=" + sliceNum +
                ", remark=" + remark +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                "}";
    }
}
