package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingDelivery;
import com.ruoyi.system.mapper.PendingDeliveryMapper;
import com.ruoyi.system.service.impl.PendingDeliveryServiceImpl;
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
 * 待出货管理Service层测试类
 *
 * @author ruoyi
 */
public class PendingDeliveryServiceTest {

    @Mock
    private PendingDeliveryMapper pendingDeliveryMapper;

    @InjectMocks
    private PendingDeliveryServiceImpl pendingDeliveryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectPendingDeliveryList() {
        // 准备测试数据
        List<PendingDelivery> expectedList = new ArrayList<>();
        PendingDelivery delivery = new PendingDelivery();
        delivery.setDeliveryId(1L);
        delivery.setCustomId(1L);
        delivery.setCustomerName("测试客户");
        delivery.setContractPaymentTime(new Date());
        delivery.setTotalContractAmount(new BigDecimal("10000.00"));
        delivery.setDeliveryDate(new Date());
        delivery.setRemainingBalance(new BigDecimal("2000.00"));
        delivery.setSalesman("张三");
        delivery.setDesigner("李四");
        delivery.setShipmentProgress(1);
        expectedList.add(delivery);

        // 模拟Mapper层返回
        when(pendingDeliveryMapper.selectPendingDeliveryList(any(PendingDelivery.class))).thenReturn(expectedList);

        // 执行测试
        List<PendingDelivery> actualList = pendingDeliveryService.selectPendingDeliveryList(new PendingDelivery());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("测试客户", actualList.get(0).getCustomerName());

        // 验证Mapper方法被调用
        verify(pendingDeliveryMapper, times(1)).selectPendingDeliveryList(any(PendingDelivery.class));
    }

    @Test
    public void testSelectPendingDeliveryById() {
        // 准备测试数据
        PendingDelivery expectedDelivery = new PendingDelivery();
        expectedDelivery.setDeliveryId(1L);
        expectedDelivery.setCustomId(1L);
        expectedDelivery.setCustomerName("测试客户");
        expectedDelivery.setContractPaymentTime(new Date());
        expectedDelivery.setTotalContractAmount(new BigDecimal("10000.00"));
        expectedDelivery.setDeliveryDate(new Date());
        expectedDelivery.setRemainingBalance(new BigDecimal("2000.00"));
        expectedDelivery.setSalesman("张三");
        expectedDelivery.setDesigner("李四");
        expectedDelivery.setShipmentProgress(1);

        // 模拟Mapper层返回
        when(pendingDeliveryMapper.selectPendingDeliveryById(1L)).thenReturn(expectedDelivery);

        // 执行测试
        PendingDelivery actualDelivery = pendingDeliveryService.selectPendingDeliveryById(1L);

        // 验证结果
        assertNotNull(actualDelivery);
        assertEquals("测试客户", actualDelivery.getCustomerName());
        assertEquals(1, actualDelivery.getShipmentProgress());

        // 验证Mapper方法被调用
        verify(pendingDeliveryMapper, times(1)).selectPendingDeliveryById(1L);
    }

    @Test
    public void testInsertPendingDelivery() {
        // 准备测试数据
        PendingDelivery delivery = new PendingDelivery();
        delivery.setCustomId(1L);
        delivery.setCustomerName("测试客户");
        delivery.setContractPaymentTime(new Date());
        delivery.setTotalContractAmount(new BigDecimal("10000.00"));
        delivery.setDeliveryDate(new Date());
        delivery.setRemainingBalance(new BigDecimal("2000.00"));
        delivery.setSalesman("张三");
        delivery.setDesigner("李四");
        delivery.setShipmentProgress(1);

        // 模拟Mapper层返回
        when(pendingDeliveryMapper.insertPendingDelivery(delivery)).thenReturn(1);

        // 执行测试
        int result = pendingDeliveryService.insertPendingDelivery(delivery);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingDeliveryMapper, times(1)).insertPendingDelivery(delivery);
    }

    @Test
    public void testUpdatePendingDelivery() {
        // 准备测试数据
        PendingDelivery delivery = new PendingDelivery();
        delivery.setDeliveryId(1L);
        delivery.setCustomId(1L);
        delivery.setCustomerName("更新客户");
        delivery.setContractPaymentTime(new Date());
        delivery.setTotalContractAmount(new BigDecimal("20000.00"));
        delivery.setDeliveryDate(new Date());
        delivery.setRemainingBalance(new BigDecimal("3000.00"));
        delivery.setSalesman("王五");
        delivery.setDesigner("赵六");
        delivery.setShipmentProgress(2);

        // 模拟Mapper层返回
        when(pendingDeliveryMapper.updatePendingDelivery(delivery)).thenReturn(1);

        // 执行测试
        int result = pendingDeliveryService.updatePendingDelivery(delivery);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingDeliveryMapper, times(1)).updatePendingDelivery(delivery);
    }

    @Test
    public void testDeletePendingDeliveryByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(pendingDeliveryMapper.deletePendingDeliveryByIds(ids)).thenReturn(3);

        // 执行测试
        int result = pendingDeliveryService.deletePendingDeliveryByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(pendingDeliveryMapper, times(1)).deletePendingDeliveryByIds(ids);
    }
}