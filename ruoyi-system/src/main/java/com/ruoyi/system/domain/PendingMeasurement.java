package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待测量对象 pending_measurement
 * 
 * @author ruoyi
 */
public class PendingMeasurement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long measurementId;

    /** 客户ID */
    private Long customId;

    /** 客户姓名 */
    private String customerName;

    /** 紧急度：0-正常，1-紧急，2-非常紧急 */
    private Integer urgency;

    /** 定金 */
    private BigDecimal deposit;

    /** 客户日期 */
    private Date customerDate;

    /** 当前状态 */
    private String currentStatus;

    /** 关注风格 */
    private String focusStyle;

    /** 待测量日期 */
    private Date pendingMeasurementDate;

    /** 客户来源 */
    private String customerSource;

    /** 销售员 */
    private String salesman;

    /** 详情 */
    private String details;

    public Long getMeasurementId()
    {
        return measurementId;
    }

    public void setMeasurementId(Long measurementId)
    {
        this.measurementId = measurementId;
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

    public Integer getUrgency()
    {
        return urgency;
    }

    public void setUrgency(Integer urgency)
    {
        this.urgency = urgency;
    }

    public BigDecimal getDeposit()
    {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit)
    {
        this.deposit = deposit;
    }

    public Date getCustomerDate()
    {
        return customerDate;
    }

    public void setCustomerDate(Date customerDate)
    {
        this.customerDate = customerDate;
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

    public Date getPendingMeasurementDate()
    {
        return pendingMeasurementDate;
    }

    public void setPendingMeasurementDate(Date pendingMeasurementDate)
    {
        this.pendingMeasurementDate = pendingMeasurementDate;
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