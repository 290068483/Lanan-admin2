package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 待出货管理集成测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
@Transactional
public class PendingDeliveryIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/customer/pending-deliveries/list")
                .param("customerName", "测试"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInfo() throws Exception {
        mockMvc.perform(get("/customer/pending-deliveries/{deliveryId}", 999999))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(post("/customer/pending-deliveries")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"contractPaymentTime\":\"2023-01-01\",\"totalContractAmount\":10000.00,\"deliveryDate\":\"2023-02-01\",\"remainingBalance\":2000.00,\"salesman\":\"张三\",\"designer\":\"李四\",\"shipmentProgress\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testEdit() throws Exception {
        mockMvc.perform(put("/customer/pending-deliveries")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"deliveryId\":999999,\"customId\":1,\"customerName\":\"更新客户\",\"contractPaymentTime\":\"2023-01-01\",\"totalContractAmount\":12000.00,\"deliveryDate\":\"2023-02-01\",\"remainingBalance\":3000.00,\"salesman\":\"王五\",\"designer\":\"赵六\",\"shipmentProgress\":2}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(delete("/customer/pending-deliveries/{deliveryIds}", "999999"))
                .andExpect(status().isOk());
    }
}