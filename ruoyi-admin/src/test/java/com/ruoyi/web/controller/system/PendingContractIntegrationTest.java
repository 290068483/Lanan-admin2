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
 * 待签合同管理集成测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
@Transactional
public class PendingContractIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/customer/pending-contracts/list")
                .param("customerName", "测试"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInfo() throws Exception {
        mockMvc.perform(get("/customer/pending-contracts/{contractId}", 999999))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(post("/customer/pending-contracts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"contractDate\":\"2023-01-01\",\"totalAmount\":10000.00,\"depositAmount\":5000.00,\"salesman\":\"张三\",\"designer\":\"李四\",\"status\":0,\"urgency\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testEdit() throws Exception {
        mockMvc.perform(put("/customer/pending-contracts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"contractId\":999999,\"customId\":1,\"customerName\":\"更新客户\",\"contractDate\":\"2023-01-01\",\"totalAmount\":12000.00,\"depositAmount\":6000.00,\"salesman\":\"王五\",\"designer\":\"赵六\",\"status\":1,\"urgency\":2}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(delete("/customer/pending-contracts/{contractIds}", "999999"))
                .andExpect(status().isOk());
    }
}