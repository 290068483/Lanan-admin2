package com.ruoyi.custom_info.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务进度对象 cus_task_progress
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public class CusTaskProgress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID（主键） */
    private Long id;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务开始时间（精确到时分秒） */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 任务完工时间（未完工时为NULL） */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务完工时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

    /** 任务属性 */
    @Excel(name = "任务属性")
    private String taskProperty;

    /** 任务发布者（姓名或ID） */
    @Excel(name = "任务发布者")
    private String publisher;

    /** 任务说明（任务详情、要求等） */
    @Excel(name = "任务说明")
    private String taskDescription;

    /** 逻辑删除标识（0-未删除，1-已删除） */
    private Integer isDeleted;

    /** 进度百分比 */
    @Excel(name = "进度百分比")
    private Double progress;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setCompletionTime(Date completionTime) 
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime() 
    {
        return completionTime;
    }
    public void setTaskProperty(String taskProperty) 
    {
        this.taskProperty = taskProperty;
    }

    public String getTaskProperty() 
    {
        return taskProperty;
    }
    public void setPublisher(String publisher) 
    {
        this.publisher = publisher;
    }

    public String getPublisher() 
    {
        return publisher;
    }
    public void setTaskDescription(String taskDescription) 
    {
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() 
    {
        return taskDescription;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }
    public void setProgress(Double progress) 
    {
        this.progress = progress;
    }

    public Double getProgress() 
    {
        return progress;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskName", getTaskName())
            .append("startTime", getStartTime())
            .append("completionTime", getCompletionTime())
            .append("taskProperty", getTaskProperty())
            .append("publisher", getPublisher())
            .append("taskDescription", getTaskDescription())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .append("isDeleted", getIsDeleted())
            .append("progress", getProgress())
            .append("status", getStatus())
            .toString();
    }

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}