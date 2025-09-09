package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingDeliveryMapper;
import com.ruoyi.system.domain.PendingDelivery;
import com.ruoyi.system.service.IPendingDeliveryService;

/**
 * 待出货Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingDeliveryServiceImpl implements IPendingDeliveryService 
{
    @Autowired
    private PendingDeliveryMapper pendingDeliveryMapper;

    /**
     * 查询待出货
     * 
     * @param deliveryId 待出货ID
     * @return 待出货
     */
    @Override
    public PendingDelivery selectPendingDeliveryById(Long deliveryId)
    {
        return pendingDeliveryMapper.selectPendingDeliveryById(deliveryId);
    }

    /**
     * 查询待出货列表
     * 
     * @param pendingDelivery 待出货
     * @return 待出货
     */
    @Override
    public List<PendingDelivery> selectPendingDeliveryList(PendingDelivery pendingDelivery)
    {
        return pendingDeliveryMapper.selectPendingDeliveryList(pendingDelivery);
    }

    /**
     * 新增待出货
     * 
     * @param pendingDelivery 待出货
     * @return 结果
     */
    @Override
    public int insertPendingDelivery(PendingDelivery pendingDelivery)
    {
        return pendingDeliveryMapper.insertPendingDelivery(pendingDelivery);
    }

    /**
     * 修改待出货
     * 
     * @param pendingDelivery 待出货
     * @return 结果
     */
    @Override
    public int updatePendingDelivery(PendingDelivery pendingDelivery)
    {
        return pendingDeliveryMapper.updatePendingDelivery(pendingDelivery);
    }

    /**
     * 删除待出货对象
     * 
     * @param deliveryIds 需要删除的待出货ID
     * @return 结果
     */
    @Override
    public int deletePendingDeliveryByIds(Long[] deliveryIds)
    {
        return pendingDeliveryMapper.deletePendingDeliveryByIds(deliveryIds);
    }

    /**
     * 删除待出货信息
     * 
     * @param deliveryId 待出货ID
     * @return 结果
     */
    @Override
    public int deletePendingDeliveryById(Long deliveryId)
    {
        return pendingDeliveryMapper.deletePendingDeliveryById(deliveryId);
    }
}