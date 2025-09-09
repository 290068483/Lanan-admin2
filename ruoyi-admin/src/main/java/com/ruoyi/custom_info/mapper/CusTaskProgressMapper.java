package com.ruoyi.custom_info.mapper;

import java.util.List;
import com.ruoyi.custom_info.domain.CusTaskProgress;
import org.springframework.stereotype.Repository;

/**
 * 任务进度Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Repository
public interface CusTaskProgressMapper 
{
    /**
     * 查询任务进度
     * 
     * @param id 任务进度主键
     * @return 任务进度
     */
    public CusTaskProgress selectCusTaskProgressById(Long id);

    /**
     * 查询任务进度列表
     * 
     * @param cusTaskProgress 任务进度
     * @return 任务进度集合
     */
    public List<CusTaskProgress> selectCusTaskProgressList(CusTaskProgress cusTaskProgress);

    /**
     * 新增任务进度
     * 
     * @param cusTaskProgress 任务进度
     * @return 结果
     */
    public int insertCusTaskProgress(CusTaskProgress cusTaskProgress);

    /**
     * 修改任务进度
     * 
     * @param cusTaskProgress 任务进度
     * @return 结果
     */
    public int updateCusTaskProgress(CusTaskProgress cusTaskProgress);

    /**
     * 删除任务进度
     * 
     * @param id 任务进度主键
     * @return 结果
     */
    public int deleteCusTaskProgressById(Long id);

    /**
     * 批量删除任务进度
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCusTaskProgressByIds(Long[] ids);
}