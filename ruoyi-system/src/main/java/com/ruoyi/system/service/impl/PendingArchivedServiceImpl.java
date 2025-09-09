package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingArchivedMapper;
import com.ruoyi.system.domain.PendingArchived;
import com.ruoyi.system.service.IPendingArchivedService;

/**
 * 待归档Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingArchivedServiceImpl implements IPendingArchivedService 
{
    @Autowired
    private PendingArchivedMapper pendingArchivedMapper;

    /**
     * 查询待归档
     * 
     * @param archiveId 待归档ID
     * @return 待归档
     */
    @Override
    public PendingArchived selectPendingArchivedById(Long archiveId)
    {
        return pendingArchivedMapper.selectPendingArchivedById(archiveId);
    }

    /**
     * 查询待归档列表
     * 
     * @param pendingArchived 待归档
     * @return 待归档
     */
    @Override
    public List<PendingArchived> selectPendingArchivedList(PendingArchived pendingArchived)
    {
        return pendingArchivedMapper.selectPendingArchivedList(pendingArchived);
    }

    /**
     * 新增待归档
     * 
     * @param pendingArchived 待归档
     * @return 结果
     */
    @Override
    public int insertPendingArchived(PendingArchived pendingArchived)
    {
        return pendingArchivedMapper.insertPendingArchived(pendingArchived);
    }

    /**
     * 修改待归档
     * 
     * @param pendingArchived 待归档
     * @return 结果
     */
    @Override
    public int updatePendingArchived(PendingArchived pendingArchived)
    {
        return pendingArchivedMapper.updatePendingArchived(pendingArchived);
    }

    /**
     * 删除待归档对象
     * 
     * @param archiveIds 需要删除的待归档ID
     * @return 结果
     */
    @Override
    public int deletePendingArchivedByIds(Long[] archiveIds)
    {
        return pendingArchivedMapper.deletePendingArchivedByIds(archiveIds);
    }

    /**
     * 删除待归档信息
     * 
     * @param archiveId 待归档ID
     * @return 结果
     */
    @Override
    public int deletePendingArchivedById(Long archiveId)
    {
        return pendingArchivedMapper.deletePendingArchivedById(archiveId);
    }
}