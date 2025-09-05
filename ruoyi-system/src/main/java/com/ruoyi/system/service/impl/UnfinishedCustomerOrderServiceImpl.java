package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UnfinishedCustomerOrderMapper;
import com.ruoyi.system.domain.UnfinishedCustomerOrder;
import com.ruoyi.system.service.IUnfinishedCustomerOrderService;

/**
 * 未完工客户单Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class UnfinishedCustomerOrderServiceImpl implements IUnfinishedCustomerOrderService 
{
    @Autowired
    private UnfinishedCustomerOrderMapper unfinishedCustomerOrderMapper;

    /**
     * 查询未完工客户单
     * 
     * @param orderId 未完工客户单ID
     * @return 未完工客户单
     */
    @Override
    public UnfinishedCustomerOrder selectUnfinishedCustomerOrderById(Long orderId)
    {
        return unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderById(orderId);
    }

    /**
     * 查询未完工客户单列表
     * 
     * @param unfinishedCustomerOrder 未完工客户单
     * @return 未完工客户单
     */
    @Override
    public List<UnfinishedCustomerOrder> selectUnfinishedCustomerOrderList(UnfinishedCustomerOrder unfinishedCustomerOrder)
    {
        return unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderList(unfinishedCustomerOrder);
    }

    /**
     * 新增未完工客户单
     * 
     * @param unfinishedCustomerOrder 未完工客户单
     * @return 结果
     */
    @Override
    public int insertUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder)
    {
        return unfinishedCustomerOrderMapper.insertUnfinishedCustomerOrder(unfinishedCustomerOrder);
    }

    /**
     * 修改未完工客户单
     * 
     * @param unfinishedCustomerOrder 未完工客户单
     * @return 结果
     */
    @Override
    public int updateUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder)
    {
        return unfinishedCustomerOrderMapper.updateUnfinishedCustomerOrder(unfinishedCustomerOrder);
    }

    /**
     * 批量删除未完工客户单
     * 
     * @param orderIds 需要删除的未完工客户单ID
     * @return 结果
     */
    @Override
    public int deleteUnfinishedCustomerOrderByIds(Long[] orderIds)
    {
        return unfinishedCustomerOrderMapper.deleteUnfinishedCustomerOrderByIds(orderIds);
    }

    /**
     * 删除未完工客户单信息
     * 
     * @param orderId 未完工客户单ID
     * @return 结果
     */
    @Override
    public int deleteUnfinishedCustomerOrderById(Long orderId)
    {
        return unfinishedCustomerOrderMapper.deleteUnfinishedCustomerOrderById(orderId);
    }
}