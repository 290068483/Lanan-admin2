package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.PendingCompletion;
import com.ruoyi.system.service.IPendingCompletionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 待完工管理Controller层测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class PendingCompletionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IPendingCompletionService pendingCompletionService;

    @InjectMocks
    private PendingCompletionController pendingCompletionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pendingCompletionController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<PendingCompletion> completions = new ArrayList<>();
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
        completions.add(completion);

        // 模拟服务层返回
        when(pendingCompletionService.selectPendingCompletionList(any(PendingCompletion.class))).thenReturn(completions);

        // 执行测试
        mockMvc.perform(get("/customer/pending-completions/list")
                .param("customerName", "测试客户"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingCompletionService, times(1)).selectPendingCompletionList(any(PendingCompletion.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
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

        // 模拟服务层返回
        when(pendingCompletionService.selectPendingCompletionById(1L)).thenReturn(completion);

        // 执行测试
        mockMvc.perform(get("/customer/pending-completions/{installationId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(pendingCompletionService, times(1)).selectPendingCompletionById(1L);
    }

    @Test
    public void testAdd() throws Exception {
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

        // 模拟服务层返回
        when(pendingCompletionService.insertPendingCompletion(completion)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/customer/pending-completions")
                .contentType("application/json")
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"urgency\":1,\"contractPaymentDate\":\"2023-06-01\",\"installationDate\":\"2023-07-01\",\"pendingProcessingDate\":\"2023-07-01\",\"salesman\":\"张三\",\"designer\":\"李四\",\"installer\":\"王五\",\"details\":\"详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingCompletionService, times(1)).insertPendingCompletion(any(PendingCompletion.class));
    }

    @Test
    public void testEdit() throws Exception {
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

        // 模拟服务层返回
        when(pendingCompletionService.updatePendingCompletion(completion)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/customer/pending-completions")
                .contentType("application/json")
                .content("{\"installationId\":1,\"customId\":1,\"customerName\":\"更新客户\",\"urgency\":2,\"contractPaymentDate\":\"2023-07-01\",\"installationDate\":\"2023-08-01\",\"pendingProcessingDate\":\"2023-08-01\",\"salesman\":\"赵六\",\"designer\":\"孙七\",\"installer\":\"周八\",\"details\":\"更新详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingCompletionService, times(1)).updatePendingCompletion(any(PendingCompletion.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟服务层返回
        when(pendingCompletionService.deletePendingCompletionByIds(ids)).thenReturn(3);

        // 执行测试
        mockMvc.perform(delete("/customer/pending-completions/{installationIds}", "1,2,3"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingCompletionService, times(1)).deletePendingCompletionByIds(ids);
    }
}