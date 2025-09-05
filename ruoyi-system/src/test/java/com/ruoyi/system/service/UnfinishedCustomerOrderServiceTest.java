package com.ruoyi.system.service;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.UnfinishedCustomerOrder;
import com.ruoyi.system.mapper.UnfinishedCustomerOrderMapper;
import com.ruoyi.system.service.impl.UnfinishedCustomerOrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = RuoYiApplication.class)
public class UnfinishedCustomerOrderServiceTest {

    @Mock
    private UnfinishedCustomerOrderMapper unfinishedCustomerOrderMapper;

    @InjectMocks
    private UnfinishedCustomerOrderServiceImpl unfinishedCustomerOrderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectUnfinishedCustomerOrderList() {
        // 准备测试数据
        List<UnfinishedCustomerOrder> expectedList = new ArrayList<>();
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");
        expectedList.add(order);

        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class))).thenReturn(expectedList);

        // 执行测试
        List<UnfinishedCustomerOrder> actualList = unfinishedCustomerOrderService.selectUnfinishedCustomerOrderList(new UnfinishedCustomerOrder());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("OC001", actualList.get(0).getOrderCode());

        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class));
    }

    @Test
    public void testSelectUnfinishedCustomerOrderById() {
        // 准备测试数据
        UnfinishedCustomerOrder expectedOrder = new UnfinishedCustomerOrder();
        expectedOrder.setOrderId(1L);
        expectedOrder.setUserId(1L);
        expectedOrder.setOrderCode("OC001");
        expectedOrder.setCustomerName("Test Customer");
        expectedOrder.setOrderAmount(100.0);
        expectedOrder.setOrderStatus("PROCESSING");

        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderById(1L)).thenReturn(expectedOrder);

        // 执行测试
        UnfinishedCustomerOrder actualOrder = unfinishedCustomerOrderService.selectUnfinishedCustomerOrderById(1L);

        // 验证结果
        assertNotNull(actualOrder);
        assertEquals("OC001", actualOrder.getOrderCode());

        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).selectUnfinishedCustomerOrderById(1L);
    }

    @Test
    public void testInsertUnfinishedCustomerOrder() {
        // 准备测试数据
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");

        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.insertUnfinishedCustomerOrder(order)).thenReturn(1);

        // 执行测试
        int result = unfinishedCustomerOrderService.insertUnfinishedCustomerOrder(order);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).insertUnfinishedCustomerOrder(order);
    }

    @Test
    public void testUpdateUnfinishedCustomerOrder() {
        // 准备测试数据
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Updated Customer");
        order.setOrderAmount(200.0);
        order.setOrderStatus("COMPLETED");

        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.updateUnfinishedCustomerOrder(order)).thenReturn(1);

        // 执行测试
        int result = unfinishedCustomerOrderService.updateUnfinishedCustomerOrder(order);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).updateUnfinishedCustomerOrder(order);
    }

    @Test
    public void testDeleteUnfinishedCustomerOrderById() {
        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.deleteUnfinishedCustomerOrderById(1L)).thenReturn(1);

        // 执行测试
        int result = unfinishedCustomerOrderService.deleteUnfinishedCustomerOrderById(1L);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).deleteUnfinishedCustomerOrderById(1L);
    }

    @Test
    public void testDeleteUnfinishedCustomerOrderByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.deleteUnfinishedCustomerOrderByIds(ids)).thenReturn(3);

        // 执行测试
        int result = unfinishedCustomerOrderService.deleteUnfinishedCustomerOrderByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).deleteUnfinishedCustomerOrderByIds(ids);
    }
}