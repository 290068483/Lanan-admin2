package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待生产对象 pending_production_order
 * 
 * @author ruoyi
 */
public class PendingProductionOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long pendingOrderId;

    /** 客户ID */
    private Long customId;

    /** 客户姓名 */
    private String customerName;

    /** 合同款时间 */
    private Date contractPaymentTime;

    /** 合同总金额 */
    private BigDecimal totalContractAmount;

    /** 交货日期 */
    private Date deliveryDate;

    /** 销售员 */
    private String salesman;

    /** 设计师 */
    private String designer;

    /** 当前进度：0-设计，1-拆单 */
    private Integer currentProgress;

    /** 详情 */
    private String details;

    /** 备注 */
    private String remarks;

    /** 意向度：0-低，1-中，2-高 */
    private Integer intention;

    public Long getPendingOrderId()
    {
        return pendingOrderId;
    }

    public void setPendingOrderId(Long pendingOrderId)
    {
        this.pendingOrderId = pendingOrderId;
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

    public Date getContractPaymentTime()
    {
        return contractPaymentTime;
    }

    public void setContractPaymentTime(Date contractPaymentTime)
    {
        this.contractPaymentTime = contractPaymentTime;
    }

    public BigDecimal getTotalContractAmount()
    {
        return totalContractAmount;
    }

    public void setTotalContractAmount(BigDecimal totalContractAmount)
    {
        this.totalContractAmount = totalContractAmount;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public String getSalesman()
    {
        return salesman;
    }

    public void setSalesman(String salesman)
    {
        this.salesman = salesman;
    }

    public String getDesigner()
    {
        return designer;
    }

    public void setDesigner(String designer)
    {
        this.designer = designer;
    }

    public Integer getCurrentProgress()
    {
        return currentProgress;
    }

    public void setCurrentProgress(Integer currentProgress)
    {
        this.currentProgress = currentProgress;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public Integer getIntention()
    {
        return intention;
    }

    public void setIntention(Integer intention)
    {
        this.intention = intention;
    }
}