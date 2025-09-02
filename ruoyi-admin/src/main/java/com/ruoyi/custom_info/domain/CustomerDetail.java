package com.ruoyi.custom_info.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.ibatis.type.Alias;

/**
 * 客户详情（存储客户补充信息）对象 customer_detail
 * 
 * @author randong
 * @date 2025-09-01
 */
@Alias("CustomInfoCustomerDetail")
public class CustomerDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户详情ID（主键） */
    private Long id;

    /** 客户ID（关联客户信息表的id字段） */
    @Excel(name = "客户ID", readConverterExp = "关=联客户信息表的id字段")
    private Long customId;

    /** 客户定金（默认0，支持小数金额） */
    @Excel(name = "客户定金", readConverterExp = "默=认0，支持小数金额")
    private BigDecimal deposit;

    /** 客户电话（支持手机号/固话，含区号） */
    @Excel(name = "客户电话", readConverterExp = "支=持手机号/固话，含区号")
    private String customerPhone;

    /** 备用电话（防止主电话无法联系） */
    @Excel(name = "备用电话", readConverterExp = "防=止主电话无法联系")
    private String backupPhone;

    /** 客户地址（省市区街道门牌号等详细地址） */
    @Excel(name = "客户地址", readConverterExp = "省=市区街道门牌号等详细地址")
    private String address;

    /** 详情创建时间（自动生成） */
    @Excel(name = "详情创建时间", readConverterExp = "自=动生成")
    private Date createdTime;

    /** 详情更新时间（自动更新） */
    @Excel(name = "详情更新时间", readConverterExp = "自=动更新")
    private Date updatedTime;

    /** 逻辑删除标识（0-未删除，1-已删除） */
    @Excel(name = "逻辑删除标识", readConverterExp = "0=-未删除，1-已删除")
    private Integer isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustomId(Long customId) 
    {
        this.customId = customId;
    }

    public Long getCustomId() 
    {
        return customId;
    }
    public void setDeposit(BigDecimal deposit) 
    {
        this.deposit = deposit;
    }

    public BigDecimal getDeposit() 
    {
        return deposit;
    }
    public void setCustomerPhone(String customerPhone) 
    {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPhone() 
    {
        return customerPhone;
    }
    public void setBackupPhone(String backupPhone) 
    {
        this.backupPhone = backupPhone;
    }

    public String getBackupPhone() 
    {
        return backupPhone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("customId", getCustomId())
            .append("deposit", getDeposit())
            .append("customerPhone", getCustomerPhone())
            .append("backupPhone", getBackupPhone())
            .append("address", getAddress())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
