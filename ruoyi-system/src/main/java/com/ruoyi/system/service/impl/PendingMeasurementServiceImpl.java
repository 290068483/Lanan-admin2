package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingMeasurementMapper;
import com.ruoyi.system.domain.PendingMeasurement;
import com.ruoyi.system.service.IPendingMeasurementService;

/**
 * 待测量Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingMeasurementServiceImpl implements IPendingMeasurementService 
{
    @Autowired
    private PendingMeasurementMapper pendingMeasurementMapper;

    /**
     * 查询待测量
     * 
     * @param measurementId 待测量ID
     * @return 待测量
     */
    @Override
    public PendingMeasurement selectPendingMeasurementById(Long measurementId)
    {
        return pendingMeasurementMapper.selectPendingMeasurementById(measurementId);
    }

    /**
     * 查询待测量列表
     * 
     * @param pendingMeasurement 待测量
     * @return 待测量
     */
    @Override
    public List<PendingMeasurement> selectPendingMeasurementList(PendingMeasurement pendingMeasurement)
    {
        return pendingMeasurementMapper.selectPendingMeasurementList(pendingMeasurement);
    }

    /**
     * 新增待测量
     * 
     * @param pendingMeasurement 待测量
     * @return 结果
     */
    @Override
    public int insertPendingMeasurement(PendingMeasurement pendingMeasurement)
    {
        return pendingMeasurementMapper.insertPendingMeasurement(pendingMeasurement);
    }

    /**
     * 修改待测量
     * 
     * @param pendingMeasurement 待测量
     * @return 结果
     */
    @Override
    public int updatePendingMeasurement(PendingMeasurement pendingMeasurement)
    {
        return pendingMeasurementMapper.updatePendingMeasurement(pendingMeasurement);
    }

    /**
     * 删除待测量对象
     * 
     * @param measurementIds 需要删除的待测量ID
     * @return 结果
     */
    @Override
    public int deletePendingMeasurementByIds(Long[] measurementIds)
    {
        return pendingMeasurementMapper.deletePendingMeasurementByIds(measurementIds);
    }

    /**
     * 删除待测量信息
     * 
     * @param measurementId 待测量ID
     * @return 结果
     */
    @Override
    public int deletePendingMeasurementById(Long measurementId)
    {
        return pendingMeasurementMapper.deletePendingMeasurementById(measurementId);
    }
}