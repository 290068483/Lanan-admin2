package com.ruoyi.custom_info.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom_info.mapper.CusTaskProgressMapper;
import com.ruoyi.custom_info.domain.CusTaskProgress;
import com.ruoyi.custom_info.service.ICusTaskProgressService;

/**
 * 任务进度Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@Service
public class CusTaskProgressServiceImpl implements ICusTaskProgressService 
{
    @Autowired
    private CusTaskProgressMapper cusTaskProgressMapper;

    /**
     * 查询任务进度
     * 
     * @param id 任务进度主键
     * @return 任务进度
     */
    @Override
    public CusTaskProgress selectCusTaskProgressById(Long id)
    {
        return cusTaskProgressMapper.selectCusTaskProgressById(id);
    }

    /**
     * 查询任务进度列表
     * 
     * @param cusTaskProgress 任务进度
     * @return 任务进度
     */
    @Override
    public List<CusTaskProgress> selectCusTaskProgressList(CusTaskProgress cusTaskProgress)
    {
        return cusTaskProgressMapper.selectCusTaskProgressList(cusTaskProgress);
    }

    /**
     * 新增任务进度
     * 
     * @param cusTaskProgress 任务进度
     * @return 结果
     */
    @Override
    public int insertCusTaskProgress(CusTaskProgress cusTaskProgress)
    {
        return cusTaskProgressMapper.insertCusTaskProgress(cusTaskProgress);
    }

    /**
     * 修改任务进度
     * 
     * @param cusTaskProgress 任务进度
     * @return 结果
     */
    @Override
    public int updateCusTaskProgress(CusTaskProgress cusTaskProgress)
    {
        return cusTaskProgressMapper.updateCusTaskProgress(cusTaskProgress);
    }

    /**
     * 批量删除任务进度
     * 
     * @param ids 需要删除的任务进度主键集合
     * @return 结果
     */
    @Override
    public int deleteCusTaskProgressByIds(Long[] ids)
    {
        return cusTaskProgressMapper.deleteCusTaskProgressByIds(ids);
    }

    /**
     * 删除任务进度信息
     * 
     * @param id 任务进度主键
     * @return 结果
     */
    @Override
    public int deleteCusTaskProgressById(Long id)
    {
        return cusTaskProgressMapper.deleteCusTaskProgressById(id);
    }
}