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
 * 待归档管理集成测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
@Transactional
public class PendingArchivedIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/customer/pending-archives/list")
                .param("customerName", "测试"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInfo() throws Exception {
        mockMvc.perform(get("/customer/pending-archives/{archiveId}", 999999))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(post("/customer/pending-archives")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"customerSatisfaction\":2,\"orderDate\":\"2023-01-01\",\"completionDate\":\"2023-02-01\",\"totalContractAmount\":10000.00,\"salesman\":\"张三\",\"designer\":\"李四\",\"installer\":\"王五\",\"measurementCount\":2,\"afterSalesCount\":1,\"extendedRelationship\":\"朋友推荐\",\"details\":\"详细信息\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testEdit() throws Exception {
        mockMvc.perform(put("/customer/pending-archives")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"archiveId\":999999,\"customId\":1,\"customerName\":\"更新客户\",\"customerSatisfaction\":1,\"orderDate\":\"2023-01-01\",\"completionDate\":\"2023-02-01\",\"totalContractAmount\":12000.00,\"salesman\":\"赵六\",\"designer\":\"孙七\",\"installer\":\"周八\",\"measurementCount\":3,\"afterSalesCount\":2,\"extendedRelationship\":\"同事推荐\",\"details\":\"更新详细信息\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(delete("/customer/pending-archives/{archiveIds}", "999999"))
                .andExpect(status().isOk());
    }
}