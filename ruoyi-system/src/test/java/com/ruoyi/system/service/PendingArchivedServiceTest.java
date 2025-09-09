package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingArchived;
import com.ruoyi.system.mapper.PendingArchivedMapper;
import com.ruoyi.system.service.impl.PendingArchivedServiceImpl;
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
 * 待归档管理Service层测试类
 *
 * @author ruoyi
 */
public class PendingArchivedServiceTest {

    @Mock
    private PendingArchivedMapper pendingArchivedMapper;

    @InjectMocks
    private PendingArchivedServiceImpl pendingArchivedService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectPendingArchivedList() {
        // 准备测试数据
        List<PendingArchived> expectedList = new ArrayList<>();
        PendingArchived archived = new PendingArchived();
        archived.setArchiveId(1L);
        archived.setCustomId(1L);
        archived.setCustomerName("测试客户");
        archived.setCustomerSatisfaction(2);
        archived.setOrderDate(new Date());
        archived.setCompletionDate(new Date());
        archived.setTotalContractAmount(new BigDecimal("10000.00"));
        archived.setSalesman("张三");
        archived.setDesigner("李四");
        archived.setInstaller("王五");
        archived.setMeasurementCount(2);
        archived.setAfterSalesCount(1);
        archived.setExtendedRelationship("朋友推荐");
        archived.setDetails("详细信息");
        expectedList.add(archived);

        // 模拟Mapper层返回
        when(pendingArchivedMapper.selectPendingArchivedList(any(PendingArchived.class))).thenReturn(expectedList);

        // 执行测试
        List<PendingArchived> actualList = pendingArchivedService.selectPendingArchivedList(new PendingArchived());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("测试客户", actualList.get(0).getCustomerName());

        // 验证Mapper方法被调用
        verify(pendingArchivedMapper, times(1)).selectPendingArchivedList(any(PendingArchived.class));
    }

    @Test
    public void testSelectPendingArchivedById() {
        // 准备测试数据
        PendingArchived expectedArchived = new PendingArchived();
        expectedArchived.setArchiveId(1L);
        expectedArchived.setCustomId(1L);
        expectedArchived.setCustomerName("测试客户");
        expectedArchived.setCustomerSatisfaction(2);
        expectedArchived.setOrderDate(new Date());
        expectedArchived.setCompletionDate(new Date());
        expectedArchived.setTotalContractAmount(new BigDecimal("10000.00"));
        expectedArchived.setSalesman("张三");
        expectedArchived.setDesigner("李四");
        expectedArchived.setInstaller("王五");
        expectedArchived.setMeasurementCount(2);
        expectedArchived.setAfterSalesCount(1);
        expectedArchived.setExtendedRelationship("朋友推荐");
        expectedArchived.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingArchivedMapper.selectPendingArchivedById(1L)).thenReturn(expectedArchived);

        // 执行测试
        PendingArchived actualArchived = pendingArchivedService.selectPendingArchivedById(1L);

        // 验证结果
        assertNotNull(actualArchived);
        assertEquals("测试客户", actualArchived.getCustomerName());
        assertEquals(2, actualArchived.getCustomerSatisfaction());

        // 验证Mapper方法被调用
        verify(pendingArchivedMapper, times(1)).selectPendingArchivedById(1L);
    }

    @Test
    public void testInsertPendingArchived() {
        // 准备测试数据
        PendingArchived archived = new PendingArchived();
        archived.setCustomId(1L);
        archived.setCustomerName("测试客户");
        archived.setCustomerSatisfaction(2);
        archived.setOrderDate(new Date());
        archived.setCompletionDate(new Date());
        archived.setTotalContractAmount(new BigDecimal("10000.00"));
        archived.setSalesman("张三");
        archived.setDesigner("李四");
        archived.setInstaller("王五");
        archived.setMeasurementCount(2);
        archived.setAfterSalesCount(1);
        archived.setExtendedRelationship("朋友推荐");
        archived.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingArchivedMapper.insertPendingArchived(archived)).thenReturn(1);

        // 执行测试
        int result = pendingArchivedService.insertPendingArchived(archived);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingArchivedMapper, times(1)).insertPendingArchived(archived);
    }

    @Test
    public void testUpdatePendingArchived() {
        // 准备测试数据
        PendingArchived archived = new PendingArchived();
        archived.setArchiveId(1L);
        archived.setCustomId(1L);
        archived.setCustomerName("更新客户");
        archived.setCustomerSatisfaction(1);
        archived.setOrderDate(new Date());
        archived.setCompletionDate(new Date());
        archived.setTotalContractAmount(new BigDecimal("20000.00"));
        archived.setSalesman("赵六");
        archived.setDesigner("孙七");
        archived.setInstaller("周八");
        archived.setMeasurementCount(3);
        archived.setAfterSalesCount(2);
        archived.setExtendedRelationship("同事推荐");
        archived.setDetails("更新详细信息");

        // 模拟Mapper层返回
        when(pendingArchivedMapper.updatePendingArchived(archived)).thenReturn(1);

        // 执行测试
        int result = pendingArchivedService.updatePendingArchived(archived);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingArchivedMapper, times(1)).updatePendingArchived(archived);
    }

    @Test
    public void testDeletePendingArchivedByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(pendingArchivedMapper.deletePendingArchivedByIds(ids)).thenReturn(3);

        // 执行测试
        int result = pendingArchivedService.deletePendingArchivedByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(pendingArchivedMapper, times(1)).deletePendingArchivedByIds(ids);
    }
}