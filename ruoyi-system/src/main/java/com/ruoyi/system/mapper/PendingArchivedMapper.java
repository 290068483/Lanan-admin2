package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PendingArchived;

/**
 * 待归档Mapper接口
 * 
 * @author ruoyi
 */
public interface PendingArchivedMapper 
{
    /**
     * 查询待归档
     * 
     * @param archiveId 待归档ID
     * @return 待归档
     */
    public PendingArchived selectPendingArchivedById(Long archiveId);

    /**
     * 查询待归档列表
     * 
     * @param pendingArchived 待归档
     * @return 待归档集合
     */
    public List<PendingArchived> selectPendingArchivedList(PendingArchived pendingArchived);

    /**
     * 新增待归档
     * 
     * @param pendingArchived 待归档
     * @return 结果
     */
    public int insertPendingArchived(PendingArchived pendingArchived);

    /**
     * 修改待归档
     * 
     * @param pendingArchived 待归档
     * @return 结果
     */
    public int updatePendingArchived(PendingArchived pendingArchived);

    /**
     * 删除待归档
     * 
     * @param archiveId 待归档ID
     * @return 结果
     */
    public int deletePendingArchivedById(Long archiveId);

    /**
     * 批量删除待归档
     * 
     * @param archiveIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePendingArchivedByIds(Long[] archiveIds);
}