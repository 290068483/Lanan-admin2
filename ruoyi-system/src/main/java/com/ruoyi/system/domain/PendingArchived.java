package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待归档对象 pending_archived
 * 
 * @author ruoyi
 */
public class PendingArchived extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long archiveId;

    /** 客户ID */
    private Long customId;

    /** 客户姓名 */
    private String customerName;

    /** 客户满意度：0-不满意，1-一般，2-满意 */
    private Integer customerSatisfaction;

    /** 定单日期 */
    private Date orderDate;

    /** 完工日期 */
    private Date completionDate;

    /** 合同总金额 */
    private BigDecimal totalContractAmount;

    /** 销售员 */
    private String salesman;

    /** 设计师 */
    private String designer;

    /** 安装师傅 */
    private String installer;

    /** 测量次数 */
    private Integer measurementCount;

    /** 售后次数 */
    private Integer afterSalesCount;

    /** 延伸关系 */
    private String extendedRelationship;

    /** 详情 */
    private String details;

    public Long getArchiveId()
    {
        return archiveId;
    }

    public void setArchiveId(Long archiveId)
    {
        this.archiveId = archiveId;
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

    public Integer getCustomerSatisfaction()
    {
        return customerSatisfaction;
    }

    public void setCustomerSatisfaction(Integer customerSatisfaction)
    {
        this.customerSatisfaction = customerSatisfaction;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public Date getCompletionDate()
    {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate)
    {
        this.completionDate = completionDate;
    }

    public BigDecimal getTotalContractAmount()
    {
        return totalContractAmount;
    }

    public void setTotalContractAmount(BigDecimal totalContractAmount)
    {
        this.totalContractAmount = totalContractAmount;
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

    public String getInstaller()
    {
        return installer;
    }

    public void setInstaller(String installer)
    {
        this.installer = installer;
    }

    public Integer getMeasurementCount()
    {
        return measurementCount;
    }

    public void setMeasurementCount(Integer measurementCount)
    {
        this.measurementCount = measurementCount;
    }

    public Integer getAfterSalesCount()
    {
        return afterSalesCount;
    }

    public void setAfterSalesCount(Integer afterSalesCount)
    {
        this.afterSalesCount = afterSalesCount;
    }

    public String getExtendedRelationship()
    {
        return extendedRelationship;
    }

    public void setExtendedRelationship(String extendedRelationship)
    {
        this.extendedRelationship = extendedRelationship;
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