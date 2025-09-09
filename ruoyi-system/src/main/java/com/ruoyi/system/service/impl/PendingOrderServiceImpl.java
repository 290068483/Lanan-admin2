package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingOrderMapper;
import com.ruoyi.system.domain.PendingOrder;
import com.ruoyi.system.service.IPendingOrderService;

/**
 * 待下单Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingOrderServiceImpl implements IPendingOrderService 
{
    @Autowired
    private PendingOrderMapper pendingOrderMapper;

    /**
     * 查询待下单
     * 
     * @param progressId 待下单ID
     * @return 待下单
     */
    @Override
    public PendingOrder selectPendingOrderById(Long progressId)
    {
        return pendingOrderMapper.selectPendingOrderById(progressId);
    }

    /**
     * 查询待下单列表
     * 
     * @param pendingOrder 待下单
     * @return 待下单
     */
    @Override
    public List<PendingOrder> selectPendingOrderList(PendingOrder pendingOrder)
    {
        return pendingOrderMapper.selectPendingOrderList(pendingOrder);
    }

    /**
     * 新增待下单
     * 
     * @param pendingOrder 待下单
     * @return 结果
     */
    @Override
    public int insertPendingOrder(PendingOrder pendingOrder)
    {
        return pendingOrderMapper.insertPendingOrder(pendingOrder);
    }

    /**
     * 修改待下单
     * 
     * @param pendingOrder 待下单
     * @return 结果
     */
    @Override
    public int updatePendingOrder(PendingOrder pendingOrder)
    {
        return pendingOrderMapper.updatePendingOrder(pendingOrder);
    }

    /**
     * 删除待下单对象
     * 
     * @param progressIds 需要删除的待下单ID
     * @return 结果
     */
    @Override
    public int deletePendingOrderByIds(Long[] progressIds)
    {
        return pendingOrderMapper.deletePendingOrderByIds(progressIds);
    }

    /**
     * 删除待下单信息
     * 
     * @param progressId 待下单ID
     * @return 结果
     */
    @Override
    public int deletePendingOrderById(Long progressId)
    {
        return pendingOrderMapper.deletePendingOrderById(progressId);
    }
}