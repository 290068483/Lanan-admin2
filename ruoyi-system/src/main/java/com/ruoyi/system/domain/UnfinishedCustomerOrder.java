package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 未完工客户单对象 unfinished_customer_order
 * 
 * @author ruoyi
 */
public class UnfinishedCustomerOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 客户单ID */
    private Long orderId;

    /** 用户ID */
    private Long userId;

    /** 客户单编号 */
    private String orderCode;

    /** 客户名称 */
    private String customerName;

    /** 订单金额 */
    private Double orderAmount;

    /** 订单状态 */
    private String orderStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public UnfinishedCustomerOrder() {
    }

    public UnfinishedCustomerOrder(Long orderId) {
        this.orderId = orderId;
    }

    // Getter和Setter方法
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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