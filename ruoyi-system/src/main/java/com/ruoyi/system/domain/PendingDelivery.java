package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待出货对象 pending_delivery
 * 
 * @author ruoyi
 */
public class PendingDelivery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long deliveryId;

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

    /** 当前尾款 */
    private BigDecimal remainingBalance;

    /** 销售员 */
    private String salesman;

    /** 设计师 */
    private String designer;

    /** 出货进度：0-待安装，1-待送货，2-安装中 */
    private Integer shipmentProgress;

    public Long getDeliveryId()
    {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId)
    {
        this.deliveryId = deliveryId;
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

    public BigDecimal getRemainingBalance()
    {
        return remainingBalance;
    }

    public void setRemainingBalance(BigDecimal remainingBalance)
    {
        this.remainingBalance = remainingBalance;
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

    public Integer getShipmentProgress()
    {
        return shipmentProgress;
    }

    public void setShipmentProgress(Integer shipmentProgress)
    {
        this.shipmentProgress = shipmentProgress;
    }
}