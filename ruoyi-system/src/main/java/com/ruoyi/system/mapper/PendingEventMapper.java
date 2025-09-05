package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PendingEvent;

/**
 * 待处理事件Mapper接口
 * 
 * @author ruoyi
 */
public interface PendingEventMapper 
{
    /**
     * 查询待处理事件
     * 
     * @param eventId 待处理事件ID
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
     * 删除待处理事件
     * 
     * @param eventId 待处理事件ID
     * @return 结果
     */
    public int deletePendingEventById(Long eventId);

    /**
     * 批量删除待处理事件
     * 
     * @param eventIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePendingEventByIds(Long[] eventIds);
    
    /**
     * 根据事件ID查询详情列表
     * 
     * @param eventId 事件ID
     * @return 详情列表
     */
    public List<com.ruoyi.system.domain.PendingEventDetail> selectPendingEventDetailsByEventId(Long eventId);
}