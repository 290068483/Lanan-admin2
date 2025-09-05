package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.UnfinishedCustomerOrder;
import com.ruoyi.system.service.IUnfinishedCustomerOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = RuoYiApplication.class)
public class UnfinishedCustomerOrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IUnfinishedCustomerOrderService unfinishedCustomerOrderService;

    @InjectMocks
    private UnfinishedCustomerOrderController unfinishedCustomerOrderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(unfinishedCustomerOrderController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<UnfinishedCustomerOrder> orders = new ArrayList<>();
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");
        orders.add(order);

        // 模拟服务层返回
        when(unfinishedCustomerOrderService.selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class))).thenReturn(orders);

        // 执行测试
        mockMvc.perform(get("/unfinishedCustomerOrder/list")
                .param("userId", "1")
                .param("orderCode", "OC001"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unfinishedCustomerOrderService, times(1)).selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");

        // 模拟服务层返回
        when(unfinishedCustomerOrderService.selectUnfinishedCustomerOrderById(1L)).thenReturn(order);

        // 执行测试
        mockMvc.perform(get("/unfinishedCustomerOrder/{orderId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(unfinishedCustomerOrderService, times(1)).selectUnfinishedCustomerOrderById(1L);
    }

    @Test
    public void testAdd() throws Exception {
        // 准备测试数据
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");

        // 模拟服务层返回
        when(unfinishedCustomerOrderService.insertUnfinishedCustomerOrder(order)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/unfinishedCustomerOrder")
                .contentType("application/json")
                .content("{\"userId\":1,\"orderCode\":\"OC001\",\"customerName\":\"Test Customer\",\"orderAmount\":100.0,\"orderStatus\":\"PROCESSING\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unfinishedCustomerOrderService, times(1)).insertUnfinishedCustomerOrder(any(UnfinishedCustomerOrder.class));
    }

    @Test
    public void testEdit() throws Exception {
        // 准备测试数据
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Updated Customer");
        order.setOrderAmount(200.0);
        order.setOrderStatus("COMPLETED");

        // 模拟服务层返回
        when(unfinishedCustomerOrderService.updateUnfinishedCustomerOrder(order)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/unfinishedCustomerOrder")
                .contentType("application/json")
                .content("{\"orderId\":1,\"userId\":1,\"orderCode\":\"OC001\",\"customerName\":\"Updated Customer\",\"orderAmount\":200.0,\"orderStatus\":\"COMPLETED\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unfinishedCustomerOrderService, times(1)).updateUnfinishedCustomerOrder(any(UnfinishedCustomerOrder.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 模拟服务层返回
        when(unfinishedCustomerOrderService.deleteUnfinishedCustomerOrderByIds(any(Long[].class))).thenReturn(1);

        // 执行测试
        mockMvc.perform(delete("/unfinishedCustomerOrder/{orderIds}", "1"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unfinishedCustomerOrderService, times(1)).deleteUnfinishedCustomerOrderByIds(any(Long[].class));
    }
}