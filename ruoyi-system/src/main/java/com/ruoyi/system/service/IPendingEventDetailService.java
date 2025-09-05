package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PendingEventDetail;

/**
 * 待处理事件详情Service接口
 * 
 * @author ruoyi
 */
public interface IPendingEventDetailService 
{
    /**
     * 查询待处理事件详情
     * 
     * @param detailId 待处理事件详情ID
     * @return 待处理事件详情
     */
    public PendingEventDetail selectPendingEventDetailById(Long detailId);

    /**
     * 查询待处理事件详情列表
     * 
     * @param pendingEventDetail 待处理事件详情
     * @return 待处理事件详情集合
     */
    public List<PendingEventDetail> selectPendingEventDetailList(PendingEventDetail pendingEventDetail);

    /**
     * 新增待处理事件详情
     * 
     * @param pendingEventDetail 待处理事件详情
     * @return 结果
     */
    public int insertPendingEventDetail(PendingEventDetail pendingEventDetail);

    /**
     * 修改待处理事件详情
     * 
     * @param pendingEventDetail 待处理事件详情
     * @return 结果
     */
    public int updatePendingEventDetail(PendingEventDetail pendingEventDetail);

    /**
     * 批量删除待处理事件详情
     * 
     * @param detailIds 需要删除的待处理事件详情ID
     * @return 结果
     */
    public int deletePendingEventDetailByIds(Long[] detailIds);

    /**
     * 删除待处理事件详情信息
     * 
     * @param detailId 待处理事件详情ID
     * @return 结果
     */
    public int deletePendingEventDetailById(Long detailId);

    /**
     * 根据事件ID删除详情
     * 
     * @param eventId 事件ID
     * @return 结果
     */
    public int deletePendingEventDetailsByEventId(Long eventId);
}