package com.ruoyi.detail.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.detail.mapper.CustomerDetailMapper;
import com.ruoyi.detail.domain.CustomerDetail;
import com.ruoyi.detail.service.ICustomerDetailService;

/**
 * 客户详情（存储客户补充信息）Service业务层处理
 * 
 * @author randong
 * @date 2025-09-01
 */
@Service
public class CustomerDetailServiceImpl implements ICustomerDetailService 
{
    @Autowired
    private CustomerDetailMapper customerDetailMapper;

    /**
     * 查询客户详情（存储客户补充信息）
     * 
     * @param id 客户详情（存储客户补充信息）主键
     * @return 客户详情（存储客户补充信息）
     */
    @Override
    public CustomerDetail selectCustomerDetailById(Long id)
    {
        return customerDetailMapper.selectCustomerDetailById(id);
    }

    /**
     * 查询客户详情（存储客户补充信息）列表
     * 
     * @param customerDetail 客户详情（存储客户补充信息）
     * @return 客户详情（存储客户补充信息）
     */
    @Override
    public List<CustomerDetail> selectCustomerDetailList(CustomerDetail customerDetail)
    {
        return customerDetailMapper.selectCustomerDetailList(customerDetail);
    }

    /**
     * 新增客户详情（存储客户补充信息）
     * 
     * @param customerDetail 客户详情（存储客户补充信息）
     * @return 结果
     */
    @Override
    public int insertCustomerDetail(CustomerDetail customerDetail)
    {
        return customerDetailMapper.insertCustomerDetail(customerDetail);
    }

    /**
     * 修改客户详情（存储客户补充信息）
     * 
     * @param customerDetail 客户详情（存储客户补充信息）
     * @return 结果
     */
    @Override
    public int updateCustomerDetail(CustomerDetail customerDetail)
    {
        return customerDetailMapper.updateCustomerDetail(customerDetail);
    }

    /**
     * 批量删除客户详情（存储客户补充信息）
     * 
     * @param ids 需要删除的客户详情（存储客户补充信息）主键
     * @return 结果
     */
    @Override
    public int deleteCustomerDetailByIds(Long[] ids)
    {
        return customerDetailMapper.deleteCustomerDetailByIds(ids);
    }

    /**
     * 删除客户详情（存储客户补充信息）信息
     * 
     * @param id 客户详情（存储客户补充信息）主键
     * @return 结果
     */
    @Override
    public int deleteCustomerDetailById(Long id)
    {
        return customerDetailMapper.deleteCustomerDetailById(id);
    }
}
