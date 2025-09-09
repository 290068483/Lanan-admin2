package com.ruoyi.custom_info.service;

import java.util.List;
import com.ruoyi.custom_info.domain.CusTaskProgress;

/**
 * 任务进度Service接口
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
public interface ICusTaskProgressService 
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
     * 批量删除任务进度
     * 
     * @param ids 需要删除的任务进度主键集合
     * @return 结果
     */
    public int deleteCusTaskProgressByIds(Long[] ids);

    /**
     * 删除任务进度信息
     * 
     * @param id 任务进度主键
     * @return 结果
     */
    public int deleteCusTaskProgressById(Long id);
}