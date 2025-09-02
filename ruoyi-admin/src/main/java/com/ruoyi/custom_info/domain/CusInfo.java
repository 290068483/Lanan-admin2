package com.ruoyi.custom_info.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息（存储客户核心基础信息）对象 cus_info
 * 
 * @author randong
 * @date 2025-09-01
 */
public class CusInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 合同款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractPaymentTime;

    /** 合同总金额 */
    @Excel(name = "合同总金额")
    private BigDecimal contractTotalAmount;

    /** 交货日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryDate;

    /** 尾款金额 */
    @Excel(name = "尾款金额")
    private BigDecimal balancePayment;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 销售员 */
    @Excel(name = "销售员")
    private String salesman;

    /** 设计师 */
    @Excel(name = "设计师")
    private String designer;

    /** 出货进度 */
    @Excel(name = "出货进度")
    private String shipmentProgress;

    /** 详情说明 */
    @Excel(name = "详情说明")
    private String details;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    /** 客户详情（存储客户补充信息）信息 */
    private List<CustomerDetail> customerDetailList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }

    public void setContractPaymentTime(Date contractPaymentTime) 
    {
        this.contractPaymentTime = contractPaymentTime;
    }

    public Date getContractPaymentTime() 
    {
        return contractPaymentTime;
    }

    public void setContractTotalAmount(BigDecimal contractTotalAmount) 
    {
        this.contractTotalAmount = contractTotalAmount;
    }

    public BigDecimal getContractTotalAmount() 
    {
        return contractTotalAmount;
    }

    public void setDeliveryDate(Date deliveryDate) 
    {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() 
    {
        return deliveryDate;
    }

    public void setBalancePayment(BigDecimal balancePayment) 
    {
        this.balancePayment = balancePayment;
    }

    public BigDecimal getBalancePayment() 
    {
        return balancePayment;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setSalesman(String salesman) 
    {
        this.salesman = salesman;
    }

    public String getSalesman() 
    {
        return salesman;
    }

    public void setDesigner(String designer) 
    {
        this.designer = designer;
    }

    public String getDesigner() 
    {
        return designer;
    }

    public void setShipmentProgress(String shipmentProgress) 
    {
        this.shipmentProgress = shipmentProgress;
    }

    public String getShipmentProgress() 
    {
        return shipmentProgress;
    }

    public void setDetails(String details) 
    {
        this.details = details;
    }

    public String getDetails() 
    {
        return details;
    }

    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }

    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    public List<CustomerDetail> getCustomerDetailList()
    {
        return customerDetailList;
    }

    public void setCustomerDetailList(List<CustomerDetail> customerDetailList)
    {
        this.customerDetailList = customerDetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customerName", getCustomerName())
            .append("contractPaymentTime", getContractPaymentTime())
            .append("contractTotalAmount", getContractTotalAmount())
            .append("deliveryDate", getDeliveryDate())
            .append("balancePayment", getBalancePayment())
            .append("status", getStatus())
            .append("salesman", getSalesman())
            .append("designer", getDesigner())
            .append("shipmentProgress", getShipmentProgress())
            .append("details", getDetails())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .append("customerDetailList", getCustomerDetailList())
            .toString();
    }
}
