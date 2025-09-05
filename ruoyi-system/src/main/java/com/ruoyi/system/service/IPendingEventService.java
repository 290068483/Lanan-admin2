package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingEvent;

import java.util.List;

/**
 * 待处理事件Service接口
 * 
 * @author ruoyi
 */
public interface IPendingEventService 
{
    /**
     * 查询待处理事件
     * 
     * @param eventId 事件ID
     * @return 待处理事件
     */
    public PendingEvent selectPendingEventById(Long eventId);

    /**
     * 查询待处理事件列表
     * 
     * @param pendingEvent 待处理事件
     * @return 待处理事件集合
     */
    public List<PendingEvent> selectPendingEventList(PendingEvent pendingEvent);

    /**
     * 新增待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    public int insertPendingEvent(PendingEvent pendingEvent);

    /**
     * 修改待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    public int updatePendingEvent(PendingEvent pendingEvent);

    /**
     * 批量删除待处理事件
     * 
     * @param eventIds 需要删除的事件ID
     * @return 结果
     */
    public int deletePendingEventByIds(Long[] eventIds);

    /**
     * 删除待处理事件信息
     * 
     * @param eventId 事件ID
     * @return 结果
     */
    public int deletePendingEventById(Long eventId);
}