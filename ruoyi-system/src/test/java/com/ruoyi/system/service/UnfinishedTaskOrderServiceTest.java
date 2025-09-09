package com.ruoyi.system.service;

import com.ruoyi.system.domain.UnfinishedTaskOrder;
import com.ruoyi.system.mapper.UnfinishedTaskOrderMapper;
import com.ruoyi.system.service.impl.UnfinishedTaskOrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UnfinishedTaskOrderServiceTest {

    @Mock
    private UnfinishedTaskOrderMapper unfinishedTaskOrderMapper;

    @InjectMocks
    private UnfinishedTaskOrderServiceImpl unfinishedTaskOrderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectUnfinishedTaskOrderList() {
        // 准备测试数据
        List<UnfinishedTaskOrder> expectedList = new ArrayList<>();
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setTaskId(1L);
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Test Task");
        task.setTaskDescription("Test Description");
        task.setTaskStatus(0);
        expectedList.add(task);

        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.selectUnfinishedTaskOrderList(any(UnfinishedTaskOrder.class))).thenReturn(expectedList);

        // 执行测试
        List<UnfinishedTaskOrder> actualList = unfinishedTaskOrderService.selectUnfinishedTaskOrderList(new UnfinishedTaskOrder());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("TC001", actualList.get(0).getTaskCode());

        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).selectUnfinishedTaskOrderList(any(UnfinishedTaskOrder.class));
    }

    @Test
    public void testSelectUnfinishedTaskOrderById() {
        // 准备测试数据
        UnfinishedTaskOrder expectedTask = new UnfinishedTaskOrder();
        expectedTask.setTaskId(1L);
        expectedTask.setUserId(1L);
        expectedTask.setTaskCode("TC001");
        expectedTask.setTaskName("Test Task");
        expectedTask.setTaskDescription("Test Description");
        expectedTask.setTaskStatus(0);

        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.selectUnfinishedTaskOrderById(1L)).thenReturn(expectedTask);

        // 执行测试
        UnfinishedTaskOrder actualTask = unfinishedTaskOrderService.selectUnfinishedTaskOrderById(1L);

        // 验证结果
        assertNotNull(actualTask);
        assertEquals("TC001", actualTask.getTaskCode());

        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).selectUnfinishedTaskOrderById(1L);
    }

    @Test
    public void testInsertUnfinishedTaskOrder() {
        // 准备测试数据
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Test Task");
        task.setTaskDescription("Test Description");
        task.setTaskStatus(0);

        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.insertUnfinishedTaskOrder(task)).thenReturn(1);

        // 执行测试
        int result = unfinishedTaskOrderService.insertUnfinishedTaskOrder(task);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).insertUnfinishedTaskOrder(task);
    }

    @Test
    public void testUpdateUnfinishedTaskOrder() {
        // 准备测试数据
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setTaskId(1L);
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Updated Task");
        task.setTaskDescription("Updated Description");
        task.setTaskStatus(1);

        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.updateUnfinishedTaskOrder(task)).thenReturn(1);

        // 执行测试
        int result = unfinishedTaskOrderService.updateUnfinishedTaskOrder(task);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).updateUnfinishedTaskOrder(task);
    }

    @Test
    public void testDeleteUnfinishedTaskOrderById() {
        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.deleteUnfinishedTaskOrderById(1L)).thenReturn(1);

        // 执行测试
        int result = unfinishedTaskOrderService.deleteUnfinishedTaskOrderById(1L);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).deleteUnfinishedTaskOrderById(1L);
    }

    @Test
    public void testDeleteUnfinishedTaskOrderByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.deleteUnfinishedTaskOrderByIds(ids)).thenReturn(3);

        // 执行测试
        int result = unfinishedTaskOrderService.deleteUnfinishedTaskOrderByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).deleteUnfinishedTaskOrderByIds(ids);
    }
}