package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 待处理事件对象 pending_events
 * 
 * @author ruoyi
 */
public class PendingEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件ID */
    private Long eventId;

    /** 用户ID */
    private Long userId;

    /** 事件名称 */
    private String eventName;

    /** 事件详细描述 */
    private String eventDetail;

    /** 事件状态（未处理/处理中/已处理） */
    private String eventStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;
    
    /** 事件详情列表 */
    private List<PendingEventDetail> details;

    public PendingEvent() {
    }

    public PendingEvent(Long eventId) {
        this.eventId = eventId;
    }

    // Getter和Setter方法
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
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
    
    public List<PendingEventDetail> getDetails() {
        return details;
    }
    
    public void setDetails(List<PendingEventDetail> details) {
        this.details = details;
    }
}