package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待下单对象 pending_order
 * 
 * @author ruoyi
 */
public class PendingOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long progressId;

    /** 客户ID */
    private Long customId;

    /** 客户姓名 */
    private String customerName;

    /** 意向度：0-低，1-中，2-高 */
    private Integer intention;

    /** 预计定单时间 */
    private Date estimatedOrderTime;

    /** 估算金额（单价） */
    private BigDecimal estimatedPrice;

    /** 当前状态 */
    private String currentStatus;

    /** 关注风格 */
    private String focusStyle;

    /** 最近联系 */
    private Date recentContact;

    /** 客户来源 */
    private String customerSource;

    /** 业务员 */
    private String salesman;

    /** 详情 */
    private String details;

    public Long getProgressId()
    {
        return progressId;
    }

    public void setProgressId(Long progressId)
    {
        this.progressId = progressId;
    }

    public Long getCustomId()
    {
        return customId;
    }

    public void setCustomId(Long customId)
    {
        this.customId = customId;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public Integer getIntention()
    {
        return intention;
    }

    public void setIntention(Integer intention)
    {
        this.intention = intention;
    }

    public Date getEstimatedOrderTime()
    {
        return estimatedOrderTime;
    }

    public void setEstimatedOrderTime(Date estimatedOrderTime)
    {
        this.estimatedOrderTime = estimatedOrderTime;
    }

    public BigDecimal getEstimatedPrice()
    {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice)
    {
        this.estimatedPrice = estimatedPrice;
    }

    public String getCurrentStatus()
    {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus)
    {
        this.currentStatus = currentStatus;
    }

    public String getFocusStyle()
    {
        return focusStyle;
    }

    public void setFocusStyle(String focusStyle)
    {
        this.focusStyle = focusStyle;
    }

    public Date getRecentContact()
    {
        return recentContact;
    }

    public void setRecentContact(Date recentContact)
    {
        this.recentContact = recentContact;
    }

    public String getCustomerSource()
    {
        return customerSource;
    }

    public void setCustomerSource(String customerSource)
    {
        this.customerSource = customerSource;
    }

    public String getSalesman()
    {
        return salesman;
    }

    public void setSalesman(String salesman)
    {
        this.salesman = salesman;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }
}