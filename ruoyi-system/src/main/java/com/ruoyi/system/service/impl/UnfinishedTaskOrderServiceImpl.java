package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UnfinishedTaskOrderMapper;
import com.ruoyi.system.domain.UnfinishedTaskOrder;
import com.ruoyi.system.service.IUnfinishedTaskOrderService;

/**
 * 未完工任务单Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class UnfinishedTaskOrderServiceImpl implements IUnfinishedTaskOrderService 
{
    @Autowired
    private UnfinishedTaskOrderMapper unfinishedTaskOrderMapper;

    /**
     * 查询未完工任务单
     * 
     * @param taskId 未完工任务单ID
     * @return 未完工任务单
     */
    @Override
    public UnfinishedTaskOrder selectUnfinishedTaskOrderById(Long taskId)
    {
        return unfinishedTaskOrderMapper.selectUnfinishedTaskOrderById(taskId);
    }

    /**
     * 查询未完工任务单列表
     * 
     * @param unfinishedTaskOrder 未完工任务单
     * @return 未完工任务单
     */
    @Override
    public List<UnfinishedTaskOrder> selectUnfinishedTaskOrderList(UnfinishedTaskOrder unfinishedTaskOrder)
    {
        return unfinishedTaskOrderMapper.selectUnfinishedTaskOrderList(unfinishedTaskOrder);
    }

    /**
     * 新增未完工任务单
     * 
     * @param unfinishedTaskOrder 未完工任务单
     * @return 结果
     */
    @Override
    public int insertUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder)
    {
        return unfinishedTaskOrderMapper.insertUnfinishedTaskOrder(unfinishedTaskOrder);
    }

    /**
     * 修改未完工任务单
     * 
     * @param unfinishedTaskOrder 未完工任务单
     * @return 结果
     */
    @Override
    public int updateUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder)
    {
        return unfinishedTaskOrderMapper.updateUnfinishedTaskOrder(unfinishedTaskOrder);
    }

    /**
     * 批量删除未完工任务单
     * 
     * @param taskIds 需要删除的未完工任务单ID
     * @return 结果
     */
    @Override
    public int deleteUnfinishedTaskOrderByIds(Long[] taskIds)
    {
        return unfinishedTaskOrderMapper.deleteUnfinishedTaskOrderByIds(taskIds);
    }

    /**
     * 删除未完工任务单信息
     * 
     * @param taskId 未完工任务单ID
     * @return 结果
     */
    @Override
    public int deleteUnfinishedTaskOrderById(Long taskId)
    {
        return unfinishedTaskOrderMapper.deleteUnfinishedTaskOrderById(taskId);
    }
}