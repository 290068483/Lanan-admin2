package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingCompletionMapper;
import com.ruoyi.system.domain.PendingCompletion;
import com.ruoyi.system.service.IPendingCompletionService;

/**
 * 待完工Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingCompletionServiceImpl implements IPendingCompletionService 
{
    @Autowired
    private PendingCompletionMapper pendingCompletionMapper;

    /**
     * 查询待完工
     * 
     * @param installationId 待完工ID
     * @return 待完工
     */
    @Override
    public PendingCompletion selectPendingCompletionById(Long installationId)
    {
        return pendingCompletionMapper.selectPendingCompletionById(installationId);
    }

    /**
     * 查询待完工列表
     * 
     * @param pendingCompletion 待完工
     * @return 待完工
     */
    @Override
    public List<PendingCompletion> selectPendingCompletionList(PendingCompletion pendingCompletion)
    {
        return pendingCompletionMapper.selectPendingCompletionList(pendingCompletion);
    }

    /**
     * 新增待完工
     * 
     * @param pendingCompletion 待完工
     * @return 结果
     */
    @Override
    public int insertPendingCompletion(PendingCompletion pendingCompletion)
    {
        return pendingCompletionMapper.insertPendingCompletion(pendingCompletion);
    }

    /**
     * 修改待完工
     * 
     * @param pendingCompletion 待完工
     * @return 结果
     */
    @Override
    public int updatePendingCompletion(PendingCompletion pendingCompletion)
    {
        return pendingCompletionMapper.updatePendingCompletion(pendingCompletion);
    }

    /**
     * 删除待完工对象
     * 
     * @param installationIds 需要删除的待完工ID
     * @return 结果
     */
    @Override
    public int deletePendingCompletionByIds(Long[] installationIds)
    {
        return pendingCompletionMapper.deletePendingCompletionByIds(installationIds);
    }

    /**
     * 删除待完工信息
     * 
     * @param installationId 待完工ID
     * @return 结果
     */
    @Override
    public int deletePendingCompletionById(Long installationId)
    {
        return pendingCompletionMapper.deletePendingCompletionById(installationId);
    }
}