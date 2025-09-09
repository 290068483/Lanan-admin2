package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.PendingOrder;
import com.ruoyi.system.service.IPendingOrderService;
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
 * 待下单管理Controller层测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class PendingOrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IPendingOrderService pendingOrderService;

    @InjectMocks
    private PendingOrderController pendingOrderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pendingOrderController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<PendingOrder> orders = new ArrayList<>();
        PendingOrder order = new PendingOrder();
        order.setProgressId(1L);
        order.setCustomId(1L);
        order.setCustomerName("测试客户");
        order.setIntention(2);
        order.setEstimatedOrderTime(new Date());
        order.setEstimatedPrice(new BigDecimal("5000.00"));
        order.setCurrentStatus("跟进中");
        order.setFocusStyle("现代风格");
        order.setRecentContact(new Date());
        order.setCustomerSource("线上推广");
        order.setSalesman("张三");
        order.setDetails("详细信息");
        orders.add(order);

        // 模拟服务层返回
        when(pendingOrderService.selectPendingOrderList(any(PendingOrder.class))).thenReturn(orders);

        // 执行测试
        mockMvc.perform(get("/customer/pending-orders/list")
                .param("customerName", "测试客户"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingOrderService, times(1)).selectPendingOrderList(any(PendingOrder.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        PendingOrder order = new PendingOrder();
        order.setProgressId(1L);
        order.setCustomId(1L);
        order.setCustomerName("测试客户");
        order.setIntention(2);
        order.setEstimatedOrderTime(new Date());
        order.setEstimatedPrice(new BigDecimal("5000.00"));
        order.setCurrentStatus("跟进中");
        order.setFocusStyle("现代风格");
        order.setRecentContact(new Date());
        order.setCustomerSource("线上推广");
        order.setSalesman("张三");
        order.setDetails("详细信息");

        // 模拟服务层返回
        when(pendingOrderService.selectPendingOrderById(1L)).thenReturn(order);

        // 执行测试
        mockMvc.perform(get("/customer/pending-orders/{progressId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(pendingOrderService, times(1)).selectPendingOrderById(1L);
    }

    @Test
    public void testAdd() throws Exception {
        // 准备测试数据
        PendingOrder order = new PendingOrder();
        order.setCustomId(1L);
        order.setCustomerName("测试客户");
        order.setIntention(2);
        order.setEstimatedOrderTime(new Date());
        order.setEstimatedPrice(new BigDecimal("5000.00"));
        order.setCurrentStatus("跟进中");
        order.setFocusStyle("现代风格");
        order.setRecentContact(new Date());
        order.setCustomerSource("线上推广");
        order.setSalesman("张三");
        order.setDetails("详细信息");

        // 模拟服务层返回
        when(pendingOrderService.insertPendingOrder(order)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/customer/pending-orders")
                .contentType("application/json")
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"intention\":2,\"estimatedOrderTime\":\"2023-06-01\",\"estimatedPrice\":5000.00,\"currentStatus\":\"跟进中\",\"focusStyle\":\"现代风格\",\"recentContact\":\"2023-05-20\",\"customerSource\":\"线上推广\",\"salesman\":\"张三\",\"details\":\"详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingOrderService, times(1)).insertPendingOrder(any(PendingOrder.class));
    }

    @Test
    public void testEdit() throws Exception {
        // 准备测试数据
        PendingOrder order = new PendingOrder();
        order.setProgressId(1L);
        order.setCustomId(1L);
        order.setCustomerName("更新客户");
        order.setIntention(1);
        order.setEstimatedOrderTime(new Date());
        order.setEstimatedPrice(new BigDecimal("6000.00"));
        order.setCurrentStatus("已完成");
        order.setFocusStyle("北欧风格");
        order.setRecentContact(new Date());
        order.setCustomerSource("线下门店");
        order.setSalesman("李四");
        order.setDetails("更新详细信息");

        // 模拟服务层返回
        when(pendingOrderService.updatePendingOrder(order)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/customer/pending-orders")
                .contentType("application/json")
                .content("{\"progressId\":1,\"customId\":1,\"customerName\":\"更新客户\",\"intention\":1,\"estimatedOrderTime\":\"2023-07-01\",\"estimatedPrice\":6000.00,\"currentStatus\":\"已完成\",\"focusStyle\":\"北欧风格\",\"recentContact\":\"2023-06-20\",\"customerSource\":\"线下门店\",\"salesman\":\"李四\",\"details\":\"更新详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingOrderService, times(1)).updatePendingOrder(any(PendingOrder.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟服务层返回
        when(pendingOrderService.deletePendingOrderByIds(ids)).thenReturn(3);

        // 执行测试
        mockMvc.perform(delete("/customer/pending-orders/{progressIds}", "1,2,3"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingOrderService, times(1)).deletePendingOrderByIds(ids);
    }
}