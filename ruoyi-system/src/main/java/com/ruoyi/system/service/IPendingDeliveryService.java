package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PendingDelivery;

/**
 * 待出货Service接口
 * 
 * @author ruoyi
 */
public interface IPendingDeliveryService 
{
    /**
     * 查询待出货
     * 
     * @param deliveryId 待出货ID
     * @return 待出货
     */
    public PendingDelivery selectPendingDeliveryById(Long deliveryId);

    /**
     * 查询待出货列表
     * 
     * @param pendingDelivery 待出货
     * @return 待出货集合
     */
    public List<PendingDelivery> selectPendingDeliveryList(PendingDelivery pendingDelivery);

    /**
     * 新增待出货
     * 
     * @param pendingDelivery 待出货
     * @return 结果
     */
    public int insertPendingDelivery(PendingDelivery pendingDelivery);

    /**
     * 修改待出货
     * 
     * @param pendingDelivery 待出货
     * @return 结果
     */
    public int updatePendingDelivery(PendingDelivery pendingDelivery);

    /**
     * 批量删除待出货
     * 
     * @param deliveryIds 需要删除的待出货ID
     * @return 结果
     */
    public int deletePendingDeliveryByIds(Long[] deliveryIds);

    /**
     * 删除待出货信息
     * 
     * @param deliveryId 待出货ID
     * @return 结果
     */
    public int deletePendingDeliveryById(Long deliveryId);
}