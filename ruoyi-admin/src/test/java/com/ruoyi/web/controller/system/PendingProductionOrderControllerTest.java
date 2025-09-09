package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.PendingProductionOrder;
import com.ruoyi.system.service.IPendingProductionOrderService;
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
 * 待生产管理Controller层测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class PendingProductionOrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IPendingProductionOrderService pendingProductionOrderService;

    @InjectMocks
    private PendingProductionOrderController pendingProductionOrderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pendingProductionOrderController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<PendingProductionOrder> orders = new ArrayList<>();
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
        orders.add(order);

        // 模拟服务层返回
        when(pendingProductionOrderService.selectPendingProductionOrderList(any(PendingProductionOrder.class))).thenReturn(orders);

        // 执行测试
        mockMvc.perform(get("/customer/pending-productions/list")
                .param("customerName", "测试客户"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingProductionOrderService, times(1)).selectPendingProductionOrderList(any(PendingProductionOrder.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
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

        // 模拟服务层返回
        when(pendingProductionOrderService.selectPendingProductionOrderById(1L)).thenReturn(order);

        // 执行测试
        mockMvc.perform(get("/customer/pending-productions/{pendingOrderId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(pendingProductionOrderService, times(1)).selectPendingProductionOrderById(1L);
    }

    @Test
    public void testAdd() throws Exception {
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

        // 模拟服务层返回
        when(pendingProductionOrderService.insertPendingProductionOrder(order)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/customer/pending-productions")
                .contentType("application/json")
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"contractPaymentTime\":\"2023-06-01\",\"totalContractAmount\":10000.00,\"deliveryDate\":\"2023-07-01\",\"salesman\":\"张三\",\"designer\":\"李四\",\"currentProgress\":1,\"details\":\"详细信息\",\"remarks\":\"备注\",\"intention\":2}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingProductionOrderService, times(1)).insertPendingProductionOrder(any(PendingProductionOrder.class));
    }

    @Test
    public void testEdit() throws Exception {
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

        // 模拟服务层返回
        when(pendingProductionOrderService.updatePendingProductionOrder(order)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/customer/pending-productions")
                .contentType("application/json")
                .content("{\"pendingOrderId\":1,\"customId\":1,\"customerName\":\"更新客户\",\"contractPaymentTime\":\"2023-07-01\",\"totalContractAmount\":20000.00,\"deliveryDate\":\"2023-08-01\",\"salesman\":\"王五\",\"designer\":\"赵六\",\"currentProgress\":2,\"details\":\"更新详细信息\",\"remarks\":\"更新备注\",\"intention\":1}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingProductionOrderService, times(1)).updatePendingProductionOrder(any(PendingProductionOrder.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟服务层返回
        when(pendingProductionOrderService.deletePendingProductionOrderByIds(ids)).thenReturn(3);

        // 执行测试
        mockMvc.perform(delete("/customer/pending-productions/{pendingOrderIds}", "1,2,3"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingProductionOrderService, times(1)).deletePendingProductionOrderByIds(ids);
    }
}