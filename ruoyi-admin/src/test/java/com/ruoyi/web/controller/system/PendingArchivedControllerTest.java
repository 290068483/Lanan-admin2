package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.PendingArchived;
import com.ruoyi.system.service.IPendingArchivedService;
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
 * 待归档管理Controller层测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class PendingArchivedControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IPendingArchivedService pendingArchivedService;

    @InjectMocks
    private PendingArchivedController pendingArchivedController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pendingArchivedController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<PendingArchived> archiveds = new ArrayList<>();
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
        archiveds.add(archived);

        // 模拟服务层返回
        when(pendingArchivedService.selectPendingArchivedList(any(PendingArchived.class))).thenReturn(archiveds);

        // 执行测试
        mockMvc.perform(get("/customer/pending-archives/list")
                .param("customerName", "测试客户"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingArchivedService, times(1)).selectPendingArchivedList(any(PendingArchived.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
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

        // 模拟服务层返回
        when(pendingArchivedService.selectPendingArchivedById(1L)).thenReturn(archived);

        // 执行测试
        mockMvc.perform(get("/customer/pending-archives/{archiveId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(pendingArchivedService, times(1)).selectPendingArchivedById(1L);
    }

    @Test
    public void testAdd() throws Exception {
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

        // 模拟服务层返回
        when(pendingArchivedService.insertPendingArchived(archived)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/customer/pending-archives")
                .contentType("application/json")
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"customerSatisfaction\":2,\"orderDate\":\"2023-06-01\",\"completionDate\":\"2023-07-01\",\"totalContractAmount\":10000.00,\"salesman\":\"张三\",\"designer\":\"李四\",\"installer\":\"王五\",\"measurementCount\":2,\"afterSalesCount\":1,\"extendedRelationship\":\"朋友推荐\",\"details\":\"详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingArchivedService, times(1)).insertPendingArchived(any(PendingArchived.class));
    }

    @Test
    public void testEdit() throws Exception {
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

        // 模拟服务层返回
        when(pendingArchivedService.updatePendingArchived(archived)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/customer/pending-archives")
                .contentType("application/json")
                .content("{\"archiveId\":1,\"customId\":1,\"customerName\":\"更新客户\",\"customerSatisfaction\":1,\"orderDate\":\"2023-07-01\",\"completionDate\":\"2023-08-01\",\"totalContractAmount\":20000.00,\"salesman\":\"赵六\",\"designer\":\"孙七\",\"installer\":\"周八\",\"measurementCount\":3,\"afterSalesCount\":2,\"extendedRelationship\":\"同事推荐\",\"details\":\"更新详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingArchivedService, times(1)).updatePendingArchived(any(PendingArchived.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟服务层返回
        when(pendingArchivedService.deletePendingArchivedByIds(ids)).thenReturn(3);

        // 执行测试
        mockMvc.perform(delete("/customer/pending-archives/{archiveIds}", "1,2,3"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingArchivedService, times(1)).deletePendingArchivedByIds(ids);
    }
}