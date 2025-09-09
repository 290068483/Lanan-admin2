package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PendingProductionOrder;

/**
 * 待生产Mapper接口
 * 
 * @author ruoyi
 */
public interface PendingProductionOrderMapper 
{
    /**
     * 查询待生产
     * 
     * @param pendingOrderId 待生产ID
     * @return 待生产
     */
    public PendingProductionOrder selectPendingProductionOrderById(Long pendingOrderId);

    /**
     * 查询待生产列表
     * 
     * @param pendingProductionOrder 待生产
     * @return 待生产集合
     */
    public List<PendingProductionOrder> selectPendingProductionOrderList(PendingProductionOrder pendingProductionOrder);

    /**
     * 新增待生产
     * 
     * @param pendingProductionOrder 待生产
     * @return 结果
     */
    public int insertPendingProductionOrder(PendingProductionOrder pendingProductionOrder);

    /**
     * 修改待生产
     * 
     * @param pendingProductionOrder 待生产
     * @return 结果
     */
    public int updatePendingProductionOrder(PendingProductionOrder pendingProductionOrder);

    /**
     * 删除待生产
     * 
     * @param pendingOrderId 待生产ID
     * @return 结果
     */
    public int deletePendingProductionOrderById(Long pendingOrderId);

    /**
     * 批量删除待生产
     * 
     * @param pendingOrderIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePendingProductionOrderByIds(Long[] pendingOrderIds);
}