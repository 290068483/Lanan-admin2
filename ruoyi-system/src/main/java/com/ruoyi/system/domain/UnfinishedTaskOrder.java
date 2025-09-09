package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 未完工任务单对象 unfinished_task_order
 * 
 * @author ruoyi
 */
public class UnfinishedTaskOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务单ID */
    private Long taskId;

    /** 用户ID */
    private Long userId;

    /** 任务单编号 */
    private String taskCode;

    /** 任务名称 */
    private String taskName;

    /** 任务描述 */
    private String taskDescription;

    /** 任务状态 */
    private Integer taskStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public UnfinishedTaskOrder() {
    }

    public UnfinishedTaskOrder(Long taskId) {
        this.taskId = taskId;
    }

    // Getter和Setter方法
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}