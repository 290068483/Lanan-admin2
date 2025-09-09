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
 * 未完成任务单管理集成测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
@Transactional
public class UnfinishedTaskOrderIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testList() throws Exception {
        mockMvc.perform(get("/unfinishedTaskOrder/list")
                .param("customerName", "测试"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetInfo() throws Exception {
        mockMvc.perform(get("/unfinishedTaskOrder/{taskId}", 999999))
                .andExpect(status().isOk());
    }

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(post("/unfinishedTaskOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"taskType\":1,\"urgency\":1,\"taskContent\":\"测试任务内容\",\"assignee\":\"张三\",\"status\":0}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testEdit() throws Exception {
        mockMvc.perform(put("/unfinishedTaskOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"taskId\":999999,\"customId\":1,\"customerName\":\"更新客户\",\"taskType\":2,\"urgency\":2,\"taskContent\":\"更新任务内容\",\"assignee\":\"李四\",\"status\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(delete("/unfinishedTaskOrder/{taskIds}", "999999"))
                .andExpect(status().isOk());
    }
}