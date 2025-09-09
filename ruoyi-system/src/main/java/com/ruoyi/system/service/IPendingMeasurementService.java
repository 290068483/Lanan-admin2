package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PendingMeasurement;

/**
 * 待测量Service接口
 * 
 * @author ruoyi
 */
public interface IPendingMeasurementService 
{
    /**
     * 查询待测量
     * 
     * @param measurementId 待测量ID
     * @return 待测量
     */
    public PendingMeasurement selectPendingMeasurementById(Long measurementId);

    /**
     * 查询待测量列表
     * 
     * @param pendingMeasurement 待测量
     * @return 待测量集合
     */
    public List<PendingMeasurement> selectPendingMeasurementList(PendingMeasurement pendingMeasurement);

    /**
     * 新增待测量
     * 
     * @param pendingMeasurement 待测量
     * @return 结果
     */
    public int insertPendingMeasurement(PendingMeasurement pendingMeasurement);

    /**
     * 修改待测量
     * 
     * @param pendingMeasurement 待测量
     * @return 结果
     */
    public int updatePendingMeasurement(PendingMeasurement pendingMeasurement);

    /**
     * 批量删除待测量
     * 
     * @param measurementIds 需要删除的待测量ID
     * @return 结果
     */
    public int deletePendingMeasurementByIds(Long[] measurementIds);

    /**
     * 删除待测量信息
     * 
     * @param measurementId 待测量ID
     * @return 结果
     */
    public int deletePendingMeasurementById(Long measurementId);
}