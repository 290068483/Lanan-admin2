package com.ruoyi.detail.service;

import java.util.List;
import com.ruoyi.detail.domain.CustomerDetail;

/**
 * 客户详情（存储客户补充信息）Service接口
 * 
 * @author randong
 * @date 2025-09-01
 */
public interface ICustomerDetailService 
{
    /**
     * 查询客户详情（存储客户补充信息）
     * 
     * @param id 客户详情（存储客户补充信息）主键
     * @return 客户详情（存储客户补充信息）
     */
    public CustomerDetail selectCustomerDetailById(Long id);

    /**
     * 查询客户详情（存储客户补充信息）列表
     * 
     * @param customerDetail 客户详情（存储客户补充信息）
     * @return 客户详情（存储客户补充信息）集合
     */
    public List<CustomerDetail> selectCustomerDetailList(CustomerDetail customerDetail);

    /**
     * 新增客户详情（存储客户补充信息）
     * 
     * @param customerDetail 客户详情（存储客户补充信息）
     * @return 结果
     */
    public int insertCustomerDetail(CustomerDetail customerDetail);

    /**
     * 修改客户详情（存储客户补充信息）
     * 
     * @param customerDetail 客户详情（存储客户补充信息）
     * @return 结果
     */
    public int updateCustomerDetail(CustomerDetail customerDetail);

    /**
     * 批量删除客户详情（存储客户补充信息）
     * 
     * @param ids 需要删除的客户详情（存储客户补充信息）主键集合
     * @return 结果
     */
    public int deleteCustomerDetailByIds(Long[] ids);

    /**
     * 删除客户详情（存储客户补充信息）信息
     * 
     * @param id 客户详情（存储客户补充信息）主键
     * @return 结果
     */
    public int deleteCustomerDetailById(Long id);
}
