package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待签合同对象 pending_contract
 * 
 * @author ruoyi
 */
public class PendingContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long contractId;

    /** 客户ID */
    private Long customId;

    /** 客户姓名 */
    private String customerName;

    /** 紧急度：0-正常，1-紧急，2-非常紧急 */
    private Integer urgency;

    /** 定金 */
    private BigDecimal deposit;

    /** 定单日期 */
    private Date orderDate;

    /** 测量日期 */
    private Date measurementDate;

    /** 客户来源 */
    private String customerSource;

    /** 销售员 */
    private String salesman;

    /** 设计师 */
    private String designer;

    /** 详情 */
    private String details;

    public Long getContractId()
    {
        return contractId;
    }

    public void setContractId(Long contractId)
    {
        this.contractId = contractId;
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

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public Date getMeasurementDate()
    {
        return measurementDate;
    }

    public void setMeasurementDate(Date measurementDate)
    {
        this.measurementDate = measurementDate;
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

    public String getDesigner()
    {
        return designer;
    }

    public void setDesigner(String designer)
    {
        this.designer = designer;
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