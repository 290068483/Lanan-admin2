package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingProductionOrder;
import com.ruoyi.system.mapper.PendingProductionOrderMapper;
import com.ruoyi.system.service.impl.PendingProductionOrderServiceImpl;
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
 * 待生产管理Service层测试类
 *
 * @author ruoyi
 */
public class PendingProductionOrderServiceTest {

    @Mock
    private PendingProductionOrderMapper pendingProductionOrderMapper;

    @InjectMocks
    private PendingProductionOrderServiceImpl pendingProductionOrderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectPendingProductionOrderList() {
        // 准备测试数据
        List<PendingProductionOrder> expectedList = new ArrayList<>();
        PendingProductionOrder order = new PendingProductionOrder();
        order.setPendingOrderId(1L);
        order.setCustomId(1L);
        order.setCustomerName("测试客户");
        order.setContractPaymentTime(new Date());
        order.setTotalContractAmount(new BigDecimal("10000.00"));
        order.setDeliveryDate(new Date());
        order.setSalesman("张三");
        order.setDesigner("李四");
        order.setCurrentProgress(1);
        order.setDetails("详细信息");
        order.setRemarks("备注");
        order.setIntention(2);
        expectedList.add(order);

        // 模拟Mapper层返回
        when(pendingProductionOrderMapper.selectPendingProductionOrderList(any(PendingProductionOrder.class))).thenReturn(expectedList);

        // 执行测试
        List<PendingProductionOrder> actualList = pendingProductionOrderService.selectPendingProductionOrderList(new PendingProductionOrder());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("测试客户", actualList.get(0).getCustomerName());

        // 验证Mapper方法被调用
        verify(pendingProductionOrderMapper, times(1)).selectPendingProductionOrderList(any(PendingProductionOrder.class));
    }

    @Test
    public void testSelectPendingProductionOrderById() {
        // 准备测试数据
        PendingProductionOrder expectedOrder = new PendingProductionOrder();
        expectedOrder.setPendingOrderId(1L);
        expectedOrder.setCustomId(1L);
        expectedOrder.setCustomerName("测试客户");
        expectedOrder.setContractPaymentTime(new Date());
        expectedOrder.setTotalContractAmount(new BigDecimal("10000.00"));
        expectedOrder.setDeliveryDate(new Date());
        expectedOrder.setSalesman("张三");
        expectedOrder.setDesigner("李四");
        expectedOrder.setCurrentProgress(1);
        expectedOrder.setDetails("详细信息");
        expectedOrder.setRemarks("备注");
        expectedOrder.setIntention(2);

        // 模拟Mapper层返回
        when(pendingProductionOrderMapper.selectPendingProductionOrderById(1L)).thenReturn(expectedOrder);

        // 执行测试
        PendingProductionOrder actualOrder = pendingProductionOrderService.selectPendingProductionOrderById(1L);

        // 验证结果
        assertNotNull(actualOrder);
        assertEquals("测试客户", actualOrder.getCustomerName());
        assertEquals(1, actualOrder.getCurrentProgress());

        // 验证Mapper方法被调用
        verify(pendingProductionOrderMapper, times(1)).selectPendingProductionOrderById(1L);
    }

    @Test
    public void testInsertPendingProductionOrder() {
        // 准备测试数据
        PendingProductionOrder order = new PendingProductionOrder();
        order.setCustomId(1L);
        order.setCustomerName("测试客户");
        order.setContractPaymentTime(new Date());
        order.setTotalContractAmount(new BigDecimal("10000.00"));
        order.setDeliveryDate(new Date());
        order.setSalesman("张三");
        order.setDesigner("李四");
        order.setCurrentProgress(1);
        order.setDetails("详细信息");
        order.setRemarks("备注");
        order.setIntention(2);

        // 模拟Mapper层返回
        when(pendingProductionOrderMapper.insertPendingProductionOrder(order)).thenReturn(1);

        // 执行测试
        int result = pendingProductionOrderService.insertPendingProductionOrder(order);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingProductionOrderMapper, times(1)).insertPendingProductionOrder(order);
    }

    @Test
    public void testUpdatePendingProductionOrder() {
        // 准备测试数据
        PendingProductionOrder order = new PendingProductionOrder();
        order.setPendingOrderId(1L);
        order.setCustomId(1L);
        order.setCustomerName("更新客户");
        order.setContractPaymentTime(new Date());
        order.setTotalContractAmount(new BigDecimal("20000.00"));
        order.setDeliveryDate(new Date());
        order.setSalesman("王五");
        order.setDesigner("赵六");
        order.setCurrentProgress(2);
        order.setDetails("更新详细信息");
        order.setRemarks("更新备注");
        order.setIntention(1);

        // 模拟Mapper层返回
        when(pendingProductionOrderMapper.updatePendingProductionOrder(order)).thenReturn(1);

        // 执行测试
        int result = pendingProductionOrderService.updatePendingProductionOrder(order);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingProductionOrderMapper, times(1)).updatePendingProductionOrder(order);
    }

    @Test
    public void testDeletePendingProductionOrderByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(pendingProductionOrderMapper.deletePendingProductionOrderByIds(ids)).thenReturn(3);

        // 执行测试
        int result = pendingProductionOrderService.deletePendingProductionOrderByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(pendingProductionOrderMapper, times(1)).deletePendingProductionOrderByIds(ids);
    }
}