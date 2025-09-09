package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingMeasurement;
import com.ruoyi.system.mapper.PendingMeasurementMapper;
import com.ruoyi.system.service.impl.PendingMeasurementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 待测量管理Service层测试类
 *
 * @author ruoyi
 */
public class PendingMeasurementServiceTest {

    @Mock
    private PendingMeasurementMapper pendingMeasurementMapper;

    @InjectMocks
    private PendingMeasurementServiceImpl pendingMeasurementService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectPendingMeasurementList() {
        // 准备测试数据
        List<PendingMeasurement> expectedList = new ArrayList<>();
        PendingMeasurement measurement = new PendingMeasurement();
        measurement.setMeasurementId(1L);
        measurement.setCustomId(1L);
        measurement.setCustomerName("测试客户");
        measurement.setUrgency(1);
        measurement.setDeposit(new BigDecimal("1000.00"));
        measurement.setCustomerDate(new Date());
        measurement.setCurrentStatus("待测量");
        measurement.setFocusStyle("现代风格");
        measurement.setPendingMeasurementDate(new Date());
        measurement.setCustomerSource("线上推广");
        measurement.setSalesman("张三");
        measurement.setDetails("详细信息");
        expectedList.add(measurement);

        // 模拟Mapper层返回
        when(pendingMeasurementMapper.selectPendingMeasurementList(any(PendingMeasurement.class))).thenReturn(expectedList);

        // 执行测试
        List<PendingMeasurement> actualList = pendingMeasurementService.selectPendingMeasurementList(new PendingMeasurement());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("测试客户", actualList.get(0).getCustomerName());

        // 验证Mapper方法被调用
        verify(pendingMeasurementMapper, times(1)).selectPendingMeasurementList(any(PendingMeasurement.class));
    }

    @Test
    public void testSelectPendingMeasurementById() {
        // 准备测试数据
        PendingMeasurement expectedMeasurement = new PendingMeasurement();
        expectedMeasurement.setMeasurementId(1L);
        expectedMeasurement.setCustomId(1L);
        expectedMeasurement.setCustomerName("测试客户");
        expectedMeasurement.setUrgency(1);
        expectedMeasurement.setDeposit(new BigDecimal("1000.00"));
        expectedMeasurement.setCustomerDate(new Date());
        expectedMeasurement.setCurrentStatus("待测量");
        expectedMeasurement.setFocusStyle("现代风格");
        expectedMeasurement.setPendingMeasurementDate(new Date());
        expectedMeasurement.setCustomerSource("线上推广");
        expectedMeasurement.setSalesman("张三");
        expectedMeasurement.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingMeasurementMapper.selectPendingMeasurementById(1L)).thenReturn(expectedMeasurement);

        // 执行测试
        PendingMeasurement actualMeasurement = pendingMeasurementService.selectPendingMeasurementById(1L);

        // 验证结果
        assertNotNull(actualMeasurement);
        assertEquals("测试客户", actualMeasurement.getCustomerName());
        assertEquals(1, actualMeasurement.getUrgency());

        // 验证Mapper方法被调用
        verify(pendingMeasurementMapper, times(1)).selectPendingMeasurementById(1L);
    }

    @Test
    public void testInsertPendingMeasurement() {
        // 准备测试数据
        PendingMeasurement measurement = new PendingMeasurement();
        measurement.setCustomId(1L);
        measurement.setCustomerName("测试客户");
        measurement.setUrgency(1);
        measurement.setDeposit(new BigDecimal("1000.00"));
        measurement.setCustomerDate(new Date());
        measurement.setCurrentStatus("待测量");
        measurement.setFocusStyle("现代风格");
        measurement.setPendingMeasurementDate(new Date());
        measurement.setCustomerSource("线上推广");
        measurement.setSalesman("张三");
        measurement.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingMeasurementMapper.insertPendingMeasurement(measurement)).thenReturn(1);

        // 执行测试
        int result = pendingMeasurementService.insertPendingMeasurement(measurement);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingMeasurementMapper, times(1)).insertPendingMeasurement(measurement);
    }

    @Test
    public void testUpdatePendingMeasurement() {
        // 准备测试数据
        PendingMeasurement measurement = new PendingMeasurement();
        measurement.setMeasurementId(1L);
        measurement.setCustomId(1L);
        measurement.setCustomerName("更新客户");
        measurement.setUrgency(2);
        measurement.setDeposit(new BigDecimal("2000.00"));
        measurement.setCustomerDate(new Date());
        measurement.setCurrentStatus("已完成");
        measurement.setFocusStyle("北欧风格");
        measurement.setPendingMeasurementDate(new Date());
        measurement.setCustomerSource("线下门店");
        measurement.setSalesman("李四");
        measurement.setDetails("更新详细信息");

        // 模拟Mapper层返回
        when(pendingMeasurementMapper.updatePendingMeasurement(measurement)).thenReturn(1);

        // 执行测试
        int result = pendingMeasurementService.updatePendingMeasurement(measurement);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingMeasurementMapper, times(1)).updatePendingMeasurement(measurement);
    }

    @Test
    public void testDeletePendingMeasurementByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(pendingMeasurementMapper.deletePendingMeasurementByIds(ids)).thenReturn(3);

        // 执行测试
        int result = pendingMeasurementService.deletePendingMeasurementByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(pendingMeasurementMapper, times(1)).deletePendingMeasurementByIds(ids);
    }
}