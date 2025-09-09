package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingCompletion;
import com.ruoyi.system.mapper.PendingCompletionMapper;
import com.ruoyi.system.service.impl.PendingCompletionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 待完工管理Service层测试类
 *
 * @author ruoyi
 */
public class PendingCompletionServiceTest {

    @Mock
    private PendingCompletionMapper pendingCompletionMapper;

    @InjectMocks
    private PendingCompletionServiceImpl pendingCompletionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectPendingCompletionList() {
        // 准备测试数据
        List<PendingCompletion> expectedList = new ArrayList<>();
        PendingCompletion completion = new PendingCompletion();
        completion.setInstallationId(1L);
        completion.setCustomId(1L);
        completion.setCustomerName("测试客户");
        completion.setUrgency(1);
        completion.setContractPaymentDate(new Date());
        completion.setInstallationDate(new Date());
        completion.setPendingProcessingDate(new Date());
        completion.setSalesman("张三");
        completion.setDesigner("李四");
        completion.setInstaller("王五");
        completion.setDetails("详细信息");
        expectedList.add(completion);

        // 模拟Mapper层返回
        when(pendingCompletionMapper.selectPendingCompletionList(any(PendingCompletion.class))).thenReturn(expectedList);

        // 执行测试
        List<PendingCompletion> actualList = pendingCompletionService.selectPendingCompletionList(new PendingCompletion());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("测试客户", actualList.get(0).getCustomerName());

        // 验证Mapper方法被调用
        verify(pendingCompletionMapper, times(1)).selectPendingCompletionList(any(PendingCompletion.class));
    }

    @Test
    public void testSelectPendingCompletionById() {
        // 准备测试数据
        PendingCompletion expectedCompletion = new PendingCompletion();
        expectedCompletion.setInstallationId(1L);
        expectedCompletion.setCustomId(1L);
        expectedCompletion.setCustomerName("测试客户");
        expectedCompletion.setUrgency(1);
        expectedCompletion.setContractPaymentDate(new Date());
        expectedCompletion.setInstallationDate(new Date());
        expectedCompletion.setPendingProcessingDate(new Date());
        expectedCompletion.setSalesman("张三");
        expectedCompletion.setDesigner("李四");
        expectedCompletion.setInstaller("王五");
        expectedCompletion.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingCompletionMapper.selectPendingCompletionById(1L)).thenReturn(expectedCompletion);

        // 执行测试
        PendingCompletion actualCompletion = pendingCompletionService.selectPendingCompletionById(1L);

        // 验证结果
        assertNotNull(actualCompletion);
        assertEquals("测试客户", actualCompletion.getCustomerName());
        assertEquals(1, actualCompletion.getUrgency());

        // 验证Mapper方法被调用
        verify(pendingCompletionMapper, times(1)).selectPendingCompletionById(1L);
    }

    @Test
    public void testInsertPendingCompletion() {
        // 准备测试数据
        PendingCompletion completion = new PendingCompletion();
        completion.setCustomId(1L);
        completion.setCustomerName("测试客户");
        completion.setUrgency(1);
        completion.setContractPaymentDate(new Date());
        completion.setInstallationDate(new Date());
        completion.setPendingProcessingDate(new Date());
        completion.setSalesman("张三");
        completion.setDesigner("李四");
        completion.setInstaller("王五");
        completion.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingCompletionMapper.insertPendingCompletion(completion)).thenReturn(1);

        // 执行测试
        int result = pendingCompletionService.insertPendingCompletion(completion);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingCompletionMapper, times(1)).insertPendingCompletion(completion);
    }

    @Test
    public void testUpdatePendingCompletion() {
        // 准备测试数据
        PendingCompletion completion = new PendingCompletion();
        completion.setInstallationId(1L);
        completion.setCustomId(1L);
        completion.setCustomerName("更新客户");
        completion.setUrgency(2);
        completion.setContractPaymentDate(new Date());
        completion.setInstallationDate(new Date());
        completion.setPendingProcessingDate(new Date());
        completion.setSalesman("赵六");
        completion.setDesigner("孙七");
        completion.setInstaller("周八");
        completion.setDetails("更新详细信息");

        // 模拟Mapper层返回
        when(pendingCompletionMapper.updatePendingCompletion(completion)).thenReturn(1);

        // 执行测试
        int result = pendingCompletionService.updatePendingCompletion(completion);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingCompletionMapper, times(1)).updatePendingCompletion(completion);
    }

    @Test
    public void testDeletePendingCompletionByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(pendingCompletionMapper.deletePendingCompletionByIds(ids)).thenReturn(3);

        // 执行测试
        int result = pendingCompletionService.deletePendingCompletionByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(pendingCompletionMapper, times(1)).deletePendingCompletionByIds(ids);
    }
}