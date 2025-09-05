package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UnfinishedTaskOrder;

/**
 * 未完工任务单Mapper接口
 * 
 * @author ruoyi
 */
public interface UnfinishedTaskOrderMapper 
{
    /**
     * 查询未完工任务单
     * 
     * @param taskId 未完工任务单ID
     * @return 未完工任务单
     */
    public UnfinishedTaskOrder selectUnfinishedTaskOrderById(Long taskId);

    /**
     * 查询未完工任务单列表
     * 
     * @param unfinishedTaskOrder 未完工任务单
     * @return 未完工任务单集合
     */
    public List<UnfinishedTaskOrder> selectUnfinishedTaskOrderList(UnfinishedTaskOrder unfinishedTaskOrder);

    /**
     * 新增未完工任务单
     * 
     * @param unfinishedTaskOrder 未完工任务单
     * @return 结果
     */
    public int insertUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder);

    /**
     * 修改未完工任务单
     * 
     * @param unfinishedTaskOrder 未完工任务单
     * @return 结果
     */
    public int updateUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder);

    /**
     * 删除未完工任务单
     * 
     * @param taskId 未完工任务单ID
     * @return 结果
     */
    public int deleteUnfinishedTaskOrderById(Long taskId);

    /**
     * 批量删除未完工任务单
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUnfinishedTaskOrderByIds(Long[] taskIds);
}