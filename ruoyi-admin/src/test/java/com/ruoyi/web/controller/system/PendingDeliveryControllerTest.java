package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.PendingDelivery;
import com.ruoyi.system.service.IPendingDeliveryService;
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
 * 待出货管理Controller层测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class PendingDeliveryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IPendingDeliveryService pendingDeliveryService;

    @InjectMocks
    private PendingDeliveryController pendingDeliveryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pendingDeliveryController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<PendingDelivery> deliveries = new ArrayList<>();
        PendingDelivery delivery = new PendingDelivery();
        delivery.setDeliveryId(1L);
        delivery.setCustomId(1L);
        delivery.setCustomerName("测试客户");
        delivery.setContractPaymentTime(new Date());
        delivery.setTotalContractAmount(new BigDecimal("10000.00"));
        delivery.setDeliveryDate(new Date());
        delivery.setRemainingBalance(new BigDecimal("2000.00"));
        delivery.setSalesman("张三");
        delivery.setDesigner("李四");
        delivery.setShipmentProgress(1);
        deliveries.add(delivery);

        // 模拟服务层返回
        when(pendingDeliveryService.selectPendingDeliveryList(any(PendingDelivery.class))).thenReturn(deliveries);

        // 执行测试
        mockMvc.perform(get("/customer/pending-deliveries/list")
                .param("customerName", "测试客户"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingDeliveryService, times(1)).selectPendingDeliveryList(any(PendingDelivery.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        PendingDelivery delivery = new PendingDelivery();
        delivery.setDeliveryId(1L);
        delivery.setCustomId(1L);
        delivery.setCustomerName("测试客户");
        delivery.setContractPaymentTime(new Date());
        delivery.setTotalContractAmount(new BigDecimal("10000.00"));
        delivery.setDeliveryDate(new Date());
        delivery.setRemainingBalance(new BigDecimal("2000.00"));
        delivery.setSalesman("张三");
        delivery.setDesigner("李四");
        delivery.setShipmentProgress(1);

        // 模拟服务层返回
        when(pendingDeliveryService.selectPendingDeliveryById(1L)).thenReturn(delivery);

        // 执行测试
        mockMvc.perform(get("/customer/pending-deliveries/{deliveryId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(pendingDeliveryService, times(1)).selectPendingDeliveryById(1L);
    }

    @Test
    public void testAdd() throws Exception {
        // 准备测试数据
        PendingDelivery delivery = new PendingDelivery();
        delivery.setCustomId(1L);
        delivery.setCustomerName("测试客户");
        delivery.setContractPaymentTime(new Date());
        delivery.setTotalContractAmount(new BigDecimal("10000.00"));
        delivery.setDeliveryDate(new Date());
        delivery.setRemainingBalance(new BigDecimal("2000.00"));
        delivery.setSalesman("张三");
        delivery.setDesigner("李四");
        delivery.setShipmentProgress(1);

        // 模拟服务层返回
        when(pendingDeliveryService.insertPendingDelivery(delivery)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/customer/pending-deliveries")
                .contentType("application/json")
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"contractPaymentTime\":\"2023-06-01\",\"totalContractAmount\":10000.00,\"deliveryDate\":\"2023-07-01\",\"remainingBalance\":2000.00,\"salesman\":\"张三\",\"designer\":\"李四\",\"shipmentProgress\":1}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingDeliveryService, times(1)).insertPendingDelivery(any(PendingDelivery.class));
    }

    @Test
    public void testEdit() throws Exception {
        // 准备测试数据
        PendingDelivery delivery = new PendingDelivery();
        delivery.setDeliveryId(1L);
        delivery.setCustomId(1L);
        delivery.setCustomerName("更新客户");
        delivery.setContractPaymentTime(new Date());
        delivery.setTotalContractAmount(new BigDecimal("20000.00"));
        delivery.setDeliveryDate(new Date());
        delivery.setRemainingBalance(new BigDecimal("3000.00"));
        delivery.setSalesman("王五");
        delivery.setDesigner("赵六");
        delivery.setShipmentProgress(2);

        // 模拟服务层返回
        when(pendingDeliveryService.updatePendingDelivery(delivery)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/customer/pending-deliveries")
                .contentType("application/json")
                .content("{\"deliveryId\":1,\"customId\":1,\"customerName\":\"更新客户\",\"contractPaymentTime\":\"2023-07-01\",\"totalContractAmount\":20000.00,\"deliveryDate\":\"2023-08-01\",\"remainingBalance\":3000.00,\"salesman\":\"王五\",\"designer\":\"赵六\",\"shipmentProgress\":2}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingDeliveryService, times(1)).updatePendingDelivery(any(PendingDelivery.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟服务层返回
        when(pendingDeliveryService.deletePendingDeliveryByIds(ids)).thenReturn(3);

        // 执行测试
        mockMvc.perform(delete("/customer/pending-deliveries/{deliveryIds}", "1,2,3"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingDeliveryService, times(1)).deletePendingDeliveryByIds(ids);
    }
}