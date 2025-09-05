package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.PendingEvent;
import com.ruoyi.system.mapper.PendingEventMapper;
import com.ruoyi.system.service.IPendingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 待处理事件Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingEventServiceImpl implements IPendingEventService
{
    @Autowired
    private PendingEventMapper pendingEventMapper;

    /**
     * 查询待处理事件
     * 
     * @param eventId 事件ID
     * @return 待处理事件
     */
    @Override
    public PendingEvent selectPendingEventById(Long eventId)
    {
        return pendingEventMapper.selectPendingEventById(eventId);
    }

    /**
     * 查询待处理事件列表
     * 
     * @param pendingEvent 待处理事件
     * @return 待处理事件
     */
    @Override
    public List<PendingEvent> selectPendingEventList(PendingEvent pendingEvent)
    {
        return pendingEventMapper.selectPendingEventList(pendingEvent);
    }

    /**
     * 新增待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    @Override
    public int insertPendingEvent(PendingEvent pendingEvent)
    {
        return pendingEventMapper.insertPendingEvent(pendingEvent);
    }

    /**
     * 修改待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    @Override
    public int updatePendingEvent(PendingEvent pendingEvent)
    {
        return pendingEventMapper.updatePendingEvent(pendingEvent);
    }

    /**
     * 删除待处理事件对象
     * 
     * @param eventIds 需要删除的事件ID
     * @return 结果
     */
    @Override
    public int deletePendingEventByIds(Long[] eventIds)
    {
        return pendingEventMapper.deletePendingEventByIds(eventIds);
    }

    /**
     * 删除待处理事件信息
     * 
     * @param eventId 事件ID
     * @return 结果
     */
    @Override
    public int deletePendingEventById(Long eventId)
    {
        return pendingEventMapper.deletePendingEventById(eventId);
    }
}