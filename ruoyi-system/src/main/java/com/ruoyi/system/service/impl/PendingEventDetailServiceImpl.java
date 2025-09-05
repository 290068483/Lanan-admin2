package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingEventDetailMapper;
import com.ruoyi.system.domain.PendingEventDetail;
import com.ruoyi.system.service.IPendingEventDetailService;

/**
 * 待处理事件详情Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingEventDetailServiceImpl implements IPendingEventDetailService 
{
    @Autowired
    private PendingEventDetailMapper pendingEventDetailMapper;

    /**
     * 查询待处理事件详情
     * 
     * @param detailId 待处理事件详情ID
     * @return 待处理事件详情
     */
    @Override
    public PendingEventDetail selectPendingEventDetailById(Long detailId)
    {
        return pendingEventDetailMapper.selectPendingEventDetailById(detailId);
    }

    /**
     * 查询待处理事件详情列表
     * 
     * @param pendingEventDetail 待处理事件详情
     * @return 待处理事件详情
     */
    @Override
    public List<PendingEventDetail> selectPendingEventDetailList(PendingEventDetail pendingEventDetail)
    {
        return pendingEventDetailMapper.selectPendingEventDetailList(pendingEventDetail);
    }

    /**
     * 新增待处理事件详情
     * 
     * @param pendingEventDetail 待处理事件详情
     * @return 结果
     */
    @Override
    public int insertPendingEventDetail(PendingEventDetail pendingEventDetail)
    {
        return pendingEventDetailMapper.insertPendingEventDetail(pendingEventDetail);
    }

    /**
     * 修改待处理事件详情
     * 
     * @param pendingEventDetail 待处理事件详情
     * @return 结果
     */
    @Override
    public int updatePendingEventDetail(PendingEventDetail pendingEventDetail)
    {
        return pendingEventDetailMapper.updatePendingEventDetail(pendingEventDetail);
    }

    /**
     * 批量删除待处理事件详情
     * 
     * @param detailIds 需要删除的待处理事件详情ID
     * @return 结果
     */
    @Override
    public int deletePendingEventDetailByIds(Long[] detailIds)
    {
        return pendingEventDetailMapper.deletePendingEventDetailByIds(detailIds);
    }

    /**
     * 删除待处理事件详情信息
     * 
     * @param detailId 待处理事件详情ID
     * @return 结果
     */
    @Override
    public int deletePendingEventDetailById(Long detailId)
    {
        return pendingEventDetailMapper.deletePendingEventDetailById(detailId);
    }

    /**
     * 根据事件ID删除详情
     * 
     * @param eventId 事件ID
     * @return 结果
     */
    @Override
    public int deletePendingEventDetailsByEventId(Long eventId)
    {
        return pendingEventDetailMapper.deletePendingEventDetailsByEventId(eventId);
    }
}