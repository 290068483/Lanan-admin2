package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingContract;
import com.ruoyi.system.mapper.PendingContractMapper;
import com.ruoyi.system.service.impl.PendingContractServiceImpl;
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
 * 待签合同管理Service层测试类
 *
 * @author ruoyi
 */
public class PendingContractServiceTest {

    @Mock
    private PendingContractMapper pendingContractMapper;

    @InjectMocks
    private PendingContractServiceImpl pendingContractService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectPendingContractList() {
        // 准备测试数据
        List<PendingContract> expectedList = new ArrayList<>();
        PendingContract contract = new PendingContract();
        contract.setContractId(1L);
        contract.setCustomId(1L);
        contract.setCustomerName("测试客户");
        contract.setUrgency(1);
        contract.setDeposit(new BigDecimal("1000.00"));
        contract.setOrderDate(new Date());
        contract.setMeasurementDate(new Date());
        contract.setCustomerSource("线上推广");
        contract.setSalesman("张三");
        contract.setDesigner("李四");
        contract.setDetails("详细信息");
        expectedList.add(contract);

        // 模拟Mapper层返回
        when(pendingContractMapper.selectPendingContractList(any(PendingContract.class))).thenReturn(expectedList);

        // 执行测试
        List<PendingContract> actualList = pendingContractService.selectPendingContractList(new PendingContract());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("测试客户", actualList.get(0).getCustomerName());

        // 验证Mapper方法被调用
        verify(pendingContractMapper, times(1)).selectPendingContractList(any(PendingContract.class));
    }

    @Test
    public void testSelectPendingContractById() {
        // 准备测试数据
        PendingContract expectedContract = new PendingContract();
        expectedContract.setContractId(1L);
        expectedContract.setCustomId(1L);
        expectedContract.setCustomerName("测试客户");
        expectedContract.setUrgency(1);
        expectedContract.setDeposit(new BigDecimal("1000.00"));
        expectedContract.setOrderDate(new Date());
        expectedContract.setMeasurementDate(new Date());
        expectedContract.setCustomerSource("线上推广");
        expectedContract.setSalesman("张三");
        expectedContract.setDesigner("李四");
        expectedContract.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingContractMapper.selectPendingContractById(1L)).thenReturn(expectedContract);

        // 执行测试
        PendingContract actualContract = pendingContractService.selectPendingContractById(1L);

        // 验证结果
        assertNotNull(actualContract);
        assertEquals("测试客户", actualContract.getCustomerName());
        assertEquals(1, actualContract.getUrgency());

        // 验证Mapper方法被调用
        verify(pendingContractMapper, times(1)).selectPendingContractById(1L);
    }

    @Test
    public void testInsertPendingContract() {
        // 准备测试数据
        PendingContract contract = new PendingContract();
        contract.setCustomId(1L);
        contract.setCustomerName("测试客户");
        contract.setUrgency(1);
        contract.setDeposit(new BigDecimal("1000.00"));
        contract.setOrderDate(new Date());
        contract.setMeasurementDate(new Date());
        contract.setCustomerSource("线上推广");
        contract.setSalesman("张三");
        contract.setDesigner("李四");
        contract.setDetails("详细信息");

        // 模拟Mapper层返回
        when(pendingContractMapper.insertPendingContract(contract)).thenReturn(1);

        // 执行测试
        int result = pendingContractService.insertPendingContract(contract);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingContractMapper, times(1)).insertPendingContract(contract);
    }

    @Test
    public void testUpdatePendingContract() {
        // 准备测试数据
        PendingContract contract = new PendingContract();
        contract.setContractId(1L);
        contract.setCustomId(1L);
        contract.setCustomerName("更新客户");
        contract.setUrgency(2);
        contract.setDeposit(new BigDecimal("2000.00"));
        contract.setOrderDate(new Date());
        contract.setMeasurementDate(new Date());
        contract.setCustomerSource("线下门店");
        contract.setSalesman("王五");
        contract.setDesigner("赵六");
        contract.setDetails("更新详细信息");

        // 模拟Mapper层返回
        when(pendingContractMapper.updatePendingContract(contract)).thenReturn(1);

        // 执行测试
        int result = pendingContractService.updatePendingContract(contract);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(pendingContractMapper, times(1)).updatePendingContract(contract);
    }

    @Test
    public void testDeletePendingContractByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(pendingContractMapper.deletePendingContractByIds(ids)).thenReturn(3);

        // 执行测试
        int result = pendingContractService.deletePendingContractByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(pendingContractMapper, times(1)).deletePendingContractByIds(ids);
    }
}