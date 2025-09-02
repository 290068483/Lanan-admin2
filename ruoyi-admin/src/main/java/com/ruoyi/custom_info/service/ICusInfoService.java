package com.ruoyi.custom_info.service;

import java.util.List;
import com.ruoyi.custom_info.domain.CusInfo;

/**
 * 客户信息（存储客户核心基础信息）Service接口
 * 
 * @author randong
 * @date 2025-09-01
 */
public interface ICusInfoService 
{
    /**
     * 查询客户信息（存储客户核心基础信息）
     * 
     * @param id 客户信息（存储客户核心基础信息）主键
     * @return 客户信息（存储客户核心基础信息）
     */
    public CusInfo selectCusInfoById(Long id);

    /**
     * 查询客户信息（存储客户核心基础信息）列表
     * 
     * @param cusInfo 客户信息（存储客户核心基础信息）
     * @return 客户信息（存储客户核心基础信息）集合
     */
    public List<CusInfo> selectCusInfoList(CusInfo cusInfo);

    /**
     * 新增客户信息（存储客户核心基础信息）
     * 
     * @param cusInfo 客户信息（存储客户核心基础信息）
     * @return 结果
     */
    public int insertCusInfo(CusInfo cusInfo);

    /**
     * 修改客户信息（存储客户核心基础信息）
     * 
     * @param cusInfo 客户信息（存储客户核心基础信息）
     * @return 结果
     */
    public int updateCusInfo(CusInfo cusInfo);

    /**
     * 批量删除客户信息（存储客户核心基础信息）
     * 
     * @param ids 需要删除的客户信息（存储客户核心基础信息）主键集合
     * @return 结果
     */
    public int deleteCusInfoByIds(Long[] ids);

    /**
     * 删除客户信息（存储客户核心基础信息）信息
     * 
     * @param id 客户信息（存储客户核心基础信息）主键
     * @return 结果
     */
    public int deleteCusInfoById(Long id);
}
