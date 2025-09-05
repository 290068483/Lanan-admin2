package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 待处理事件详情对象 pending_event_details
 * 
 * @author ruoyi
 */
public class PendingEventDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 详情ID */
    private Long detailId;

    /** 事件ID */
    private Long eventId;

    /** 详情内容 */
    private String detailContent;

    /** 详情类型 */
    private String detailType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public PendingEventDetail() {
    }

    public PendingEventDetail(Long detailId) {
        this.detailId = detailId;
    }

    public PendingEventDetail(Long eventId, String detailContent) {
        this.eventId = eventId;
        this.detailContent = detailContent;
    }

    // Getter和Setter方法
    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
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