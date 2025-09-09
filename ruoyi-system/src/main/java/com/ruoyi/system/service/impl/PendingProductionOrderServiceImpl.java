package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingProductionOrderMapper;
import com.ruoyi.system.domain.PendingProductionOrder;
import com.ruoyi.system.service.IPendingProductionOrderService;

/**
 * 待生产Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingProductionOrderServiceImpl implements IPendingProductionOrderService 
{
    @Autowired
    private PendingProductionOrderMapper pendingProductionOrderMapper;

    /**
     * 查询待生产
     * 
     * @param pendingOrderId 待生产ID
     * @return 待生产
     */
    @Override
    public PendingProductionOrder selectPendingProductionOrderById(Long pendingOrderId)
    {
        return pendingProductionOrderMapper.selectPendingProductionOrderById(pendingOrderId);
    }

    /**
     * 查询待生产列表
     * 
     * @param pendingProductionOrder 待生产
     * @return 待生产
     */
    @Override
    public List<PendingProductionOrder> selectPendingProductionOrderList(PendingProductionOrder pendingProductionOrder)
    {
        return pendingProductionOrderMapper.selectPendingProductionOrderList(pendingProductionOrder);
    }

    /**
     * 新增待生产
     * 
     * @param pendingProductionOrder 待生产
     * @return 结果
     */
    @Override
    public int insertPendingProductionOrder(PendingProductionOrder pendingProductionOrder)
    {
        return pendingProductionOrderMapper.insertPendingProductionOrder(pendingProductionOrder);
    }

    /**
     * 修改待生产
     * 
     * @param pendingProductionOrder 待生产
     * @return 结果
     */
    @Override
    public int updatePendingProductionOrder(PendingProductionOrder pendingProductionOrder)
    {
        return pendingProductionOrderMapper.updatePendingProductionOrder(pendingProductionOrder);
    }

    /**
     * 删除待生产对象
     * 
     * @param pendingOrderIds 需要删除的待生产ID
     * @return 结果
     */
    @Override
    public int deletePendingProductionOrderByIds(Long[] pendingOrderIds)
    {
        return pendingProductionOrderMapper.deletePendingProductionOrderByIds(pendingOrderIds);
    }

    /**
     * 删除待生产信息
     * 
     * @param pendingOrderId 待生产ID
     * @return 结果
     */
    @Override
    public int deletePendingProductionOrderById(Long pendingOrderId)
    {
        return pendingProductionOrderMapper.deletePendingProductionOrderById(pendingOrderId);
    }
}