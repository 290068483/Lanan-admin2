package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 待完工对象 pending_completion
 * 
 * @author ruoyi
 */
public class PendingCompletion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long installationId;

    /** 客户ID */
    private Long customId;

    /** 客户姓名 */
    private String customerName;

    /** 紧急度：0-正常，1-紧急，2-非常紧急 */
    private Integer urgency;

    /** 合同款日期 */
    private Date contractPaymentDate;

    /** 安装日期 */
    private Date installationDate;

    /** 待处理日期 */
    private Date pendingProcessingDate;

    /** 销售员 */
    private String salesman;

    /** 设计师 */
    private String designer;

    /** 安装师傅 */
    private String installer;

    /** 详情 */
    private String details;

    public Long getInstallationId()
    {
        return installationId;
    }

    public void setInstallationId(Long installationId)
    {
        this.installationId = installationId;
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

    public Date getContractPaymentDate()
    {
        return contractPaymentDate;
    }

    public void setContractPaymentDate(Date contractPaymentDate)
    {
        this.contractPaymentDate = contractPaymentDate;
    }

    public Date getInstallationDate()
    {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate)
    {
        this.installationDate = installationDate;
    }

    public Date getPendingProcessingDate()
    {
        return pendingProcessingDate;
    }

    public void setPendingProcessingDate(Date pendingProcessingDate)
    {
        this.pendingProcessingDate = pendingProcessingDate;
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

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }
}