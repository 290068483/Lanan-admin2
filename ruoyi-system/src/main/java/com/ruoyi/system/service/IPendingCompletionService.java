package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PendingCompletion;

/**
 * 待完工Service接口
 * 
 * @author ruoyi
 */
public interface IPendingCompletionService 
{
    /**
     * 查询待完工
     * 
     * @param installationId 待完工ID
     * @return 待完工
     */
    public PendingCompletion selectPendingCompletionById(Long installationId);

    /**
     * 查询待完工列表
     * 
     * @param pendingCompletion 待完工
     * @return 待完工集合
     */
    public List<PendingCompletion> selectPendingCompletionList(PendingCompletion pendingCompletion);

    /**
     * 新增待完工
     * 
     * @param pendingCompletion 待完工
     * @return 结果
     */
    public int insertPendingCompletion(PendingCompletion pendingCompletion);

    /**
     * 修改待完工
     * 
     * @param pendingCompletion 待完工
     * @return 结果
     */
    public int updatePendingCompletion(PendingCompletion pendingCompletion);

    /**
     * 批量删除待完工
     * 
     * @param installationIds 需要删除的待完工ID
     * @return 结果
     */
    public int deletePendingCompletionByIds(Long[] installationIds);

    /**
     * 删除待完工信息
     * 
     * @param installationId 待完工ID
     * @return 结果
     */
    public int deletePendingCompletionById(Long installationId);
}