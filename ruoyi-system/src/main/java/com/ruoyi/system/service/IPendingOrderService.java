package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PendingOrder;

/**
 * 待下单Service接口
 * 
 * @author ruoyi
 */
public interface IPendingOrderService 
{
    /**
     * 查询待下单
     * 
     * @param progressId 待下单ID
     * @return 待下单
     */
    public PendingOrder selectPendingOrderById(Long progressId);

    /**
     * 查询待下单列表
     * 
     * @param pendingOrder 待下单
     * @return 待下单集合
     */
    public List<PendingOrder> selectPendingOrderList(PendingOrder pendingOrder);

    /**
     * 新增待下单
     * 
     * @param pendingOrder 待下单
     * @return 结果
     */
    public int insertPendingOrder(PendingOrder pendingOrder);

    /**
     * 修改待下单
     * 
     * @param pendingOrder 待下单
     * @return 结果
     */
    public int updatePendingOrder(PendingOrder pendingOrder);

    /**
     * 批量删除待下单
     * 
     * @param progressIds 需要删除的待下单ID
     * @return 结果
     */
    public int deletePendingOrderByIds(Long[] progressIds);

    /**
     * 删除待下单信息
     * 
     * @param progressId 待下单ID
     * @return 结果
     */
    public int deletePendingOrderById(Long progressId);
}