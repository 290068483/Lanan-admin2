package com.ruoyi.custom_info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.custom_info.domain.CustomerDetail;
import com.ruoyi.custom_info.mapper.CusInfoMapper;
import com.ruoyi.custom_info.domain.CusInfo;
import com.ruoyi.custom_info.service.ICusInfoService;

/**
 * 客户信息（存储客户核心基础信息）Service业务层处理
 * 
 * @author randong
 * @date 2025-09-01
 */
@Service
public class CusInfoServiceImpl implements ICusInfoService 
{
    @Autowired
    private CusInfoMapper cusInfoMapper;

    /**
     * 查询客户信息（存储客户核心基础信息）
     * 
     * @param id 客户信息（存储客户核心基础信息）主键
     * @return 客户信息（存储客户核心基础信息）
     */
    @Override
    public CusInfo selectCusInfoById(Long id)
    {
        return cusInfoMapper.selectCusInfoById(id);
    }

    /**
     * 查询客户信息（存储客户核心基础信息）列表
     * 
     * @param cusInfo 客户信息（存储客户核心基础信息）
     * @return 客户信息（存储客户核心基础信息）
     */
    @Override
    public List<CusInfo> selectCusInfoList(CusInfo cusInfo)
    {
        return cusInfoMapper.selectCusInfoList(cusInfo);
    }

    /**
     * 新增客户信息（存储客户核心基础信息）
     * 
     * @param cusInfo 客户信息（存储客户核心基础信息）
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCusInfo(CusInfo cusInfo)
    {
        int rows = cusInfoMapper.insertCusInfo(cusInfo);
        insertCustomerDetail(cusInfo);
        return rows;
    }

    /**
     * 修改客户信息（存储客户核心基础信息）
     * 
     * @param cusInfo 客户信息（存储客户核心基础信息）
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCusInfo(CusInfo cusInfo)
    {
        cusInfoMapper.deleteCustomerDetailByCustomId(cusInfo.getId());
        insertCustomerDetail(cusInfo);
        return cusInfoMapper.updateCusInfo(cusInfo);
    }

    /**
     * 批量删除客户信息（存储客户核心基础信息）
     * 
     * @param ids 需要删除的客户信息（存储客户核心基础信息）主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCusInfoByIds(Long[] ids)
    {
        cusInfoMapper.deleteCustomerDetailByCustomIds(ids);
        return cusInfoMapper.deleteCusInfoByIds(ids);
    }

    /**
     * 删除客户信息（存储客户核心基础信息）信息
     * 
     * @param id 客户信息（存储客户核心基础信息）主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCusInfoById(Long id)
    {
        cusInfoMapper.deleteCustomerDetailByCustomId(id);
        return cusInfoMapper.deleteCusInfoById(id);
    }

    /**
     * 新增客户详情（存储客户补充信息）信息
     * 
     * @param cusInfo 客户信息（存储客户核心基础信息）对象
     */
    public void insertCustomerDetail(CusInfo cusInfo)
    {
        List<CustomerDetail> customerDetailList = cusInfo.getCustomerDetailList();
        Long id = cusInfo.getId();
        if (StringUtils.isNotNull(customerDetailList))
        {
            List<CustomerDetail> list = new ArrayList<CustomerDetail>();
            for (CustomerDetail customerDetail : customerDetailList)
            {
                customerDetail.setCustomId(id);
                list.add(customerDetail);
            }
            if (list.size() > 0)
            {
                cusInfoMapper.batchCustomerDetail(list);
            }
        }
    }
}
