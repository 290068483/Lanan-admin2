package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.PendingContract;
import com.ruoyi.system.service.IPendingContractService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 待签合同管理Controller层测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class PendingContractControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IPendingContractService pendingContractService;

    @InjectMocks
    private PendingContractController pendingContractController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pendingContractController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<PendingContract> contracts = new ArrayList<>();
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
        contracts.add(contract);

        // 模拟服务层返回
        when(pendingContractService.selectPendingContractList(any(PendingContract.class))).thenReturn(contracts);

        // 执行测试
        mockMvc.perform(get("/customer/pending-contracts/list")
                .param("customerName", "测试客户"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingContractService, times(1)).selectPendingContractList(any(PendingContract.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
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

        // 模拟服务层返回
        when(pendingContractService.selectPendingContractById(1L)).thenReturn(contract);

        // 执行测试
        mockMvc.perform(get("/customer/pending-contracts/{contractId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(pendingContractService, times(1)).selectPendingContractById(1L);
    }

    @Test
    public void testAdd() throws Exception {
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

        // 模拟服务层返回
        when(pendingContractService.insertPendingContract(contract)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/customer/pending-contracts")
                .contentType("application/json")
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"urgency\":1,\"deposit\":1000.00,\"orderDate\":\"2023-06-01\",\"measurementDate\":\"2023-06-01\",\"customerSource\":\"线上推广\",\"salesman\":\"张三\",\"designer\":\"李四\",\"details\":\"详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingContractService, times(1)).insertPendingContract(any(PendingContract.class));
    }

    @Test
    public void testEdit() throws Exception {
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

        // 模拟服务层返回
        when(pendingContractService.updatePendingContract(contract)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/customer/pending-contracts")
                .contentType("application/json")
                .content("{\"contractId\":1,\"customId\":1,\"customerName\":\"更新客户\",\"urgency\":2,\"deposit\":2000.00,\"orderDate\":\"2023-07-01\",\"measurementDate\":\"2023-07-01\",\"customerSource\":\"线下门店\",\"salesman\":\"王五\",\"designer\":\"赵六\",\"details\":\"更新详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingContractService, times(1)).updatePendingContract(any(PendingContract.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟服务层返回
        when(pendingContractService.deletePendingContractByIds(ids)).thenReturn(3);

        // 执行测试
        mockMvc.perform(delete("/customer/pending-contracts/{contractIds}", "1,2,3"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingContractService, times(1)).deletePendingContractByIds(ids);
    }
}