package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingOrder;
import com.ruoyi.system.mapper.PendingOrderMapper;
import com.ruoyi.system.service.impl.PendingOrderServiceImpl;
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
 * 待下单管理Service层测试类
 *
 * @author ruoyi
 */
public class PendingOrderServiceTest {

    @Mock
    private PendingOrderMapper pendingOrderMapper;

    @InjectMocks
    private PendingOrderServiceImpl pendingOrderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectPendingOrderList() {
        // 准备测试数据
        List<PendingOrder> expectedList = new ArrayList<>();
        PendingOrder order = new PendingOrder();
        order.setProgressId(1L);
        order.setCustomId(1L);
        order.setCustomerName("测试客户");
        order.setIntention(2);
        order.setEstimatedOrderTime(new Date());
        order.setEstimatedPrice(new BigDecimal("5000.00"));
        order.setCurrentStatus("跟进中");
        order.setFocusStyle("现代风格");
        order.setRecentContact(new Date());
        order.setCustomerSource("线上推广");
        order.setSalesman("张三");
        order.setDetails("详细信息");
        expectedList.add(order);

        // 模拟Mapper层返回
        when(pendingOrderMapper.selectPendingOrderList(any(PendingOrder.class))).thenReturn(expectedList);

        // 执行测试
        List<PendingOrder> actualList = pendingOrderService.selectPendingOrderList(new PendingOrder());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("测试客户", actualList.get(0).getCustomerName());

        // 验证Mapper方法被调用
        verify(pendingOrderMapper, times(1)).selectPendingOrderList(any(PendingOrder.class));
    }

    @Test
    public void testSelectPendingOrderById() {
        // 准备测试数据
        PendingOrder expectedOrder = new PendingOrder();
        expectedOrder.setProgressId(1L);
        expectedOrder.setCustomId(1L);
        expectedOrder.setCustomerName("测试客户");
        expectedOrder.setIntention(2);
        expectedOrder.setEstimatedOrderTime(new Date());
        expectedOrder.setEstimatedPrice(new BigDecimal("5000.00"));
        expectedOrder.setCurrentStatus("跟进中");
        expectedOrder.setFocusStyle("现代风格");
        expectedOrder.setRecentContact(new Date());
        expectedOrder.setCustomerSource("线上推广");
        expectedOrder.setSalesman("张三");
        expectedOrder.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingOrderMapper.selectPendingOrderById(1L)).thenReturn(expectedOrder);

        // 执行测试
        PendingOrder actualOrder = pendingOrderService.selectPendingOrderById(1L);

        // 验证结果
        assertNotNull(actualOrder);
        assertEquals("测试客户", actualOrder.getCustomerName());
        assertEquals(2, actualOrder.getIntention());

        // 验证Mapper方法被调用
        verify(pendingOrderMapper, times(1)).selectPendingOrderById(1L);
    }

    @Test
    public void testInsertPendingOrder() {
        // 准备测试数据
        PendingOrder order = new PendingOrder();
        order.setCustomId(1L);
        order.setCustomerName("测试客户");
        order.setIntention(2);
        order.setEstimatedOrderTime(new Date());
        order.setEstimatedPrice(new BigDecimal("5000.00"));
        order.setCurrentStatus("跟进中");
        order.setFocusStyle("现代风格");
        order.setRecentContact(new Date());
        order.setCustomerSource("线上推广");
        order.setSalesman("张三");
        order.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingOrderMapper.insertPendingOrder(order)).thenReturn(1);

        // 执行测试
        int result = pendingOrderService.insertPendingOrder(order);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingOrderMapper, times(1)).insertPendingOrder(order);
    }

    @Test
    public void testUpdatePendingOrder() {
        // 准备测试数据
        PendingOrder order = new PendingOrder();
        order.setProgressId(1L);
        order.setCustomId(1L);
        order.setCustomerName("更新客户");
        order.setIntention(1);
        order.setEstimatedOrderTime(new Date());
        order.setEstimatedPrice(new BigDecimal("6000.00"));
        order.setCurrentStatus("已完成");
        order.setFocusStyle("北欧风格");
        order.setRecentContact(new Date());
        order.setCustomerSource("线下门店");
        order.setSalesman("李四");
        order.setDetails("更新详细信息");

        // 模拟Mapper层返回
        when(pendingOrderMapper.updatePendingOrder(order)).thenReturn(1);

        // 执行测试
        int result = pendingOrderService.updatePendingOrder(order);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingOrderMapper, times(1)).updatePendingOrder(order);
    }

    @Test
    public void testDeletePendingOrderByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(pendingOrderMapper.deletePendingOrderByIds(ids)).thenReturn(3);

        // 执行测试
        int result = pendingOrderService.deletePendingOrderByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(pendingOrderMapper, times(1)).deletePendingOrderByIds(ids);
    }
}