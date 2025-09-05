package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.UnreadMessage;
import com.ruoyi.system.service.IUnreadMessageService;
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
public class UnreadMessageControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IUnreadMessageService unreadMessageService;

    @InjectMocks
    private UnreadMessageController unreadMessageController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(unreadMessageController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<UnreadMessage> unreadMessages = new ArrayList<>();
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");
        unreadMessages.add(message);

        // 模拟服务层返回
        when(unreadMessageService.selectUnreadMessageList(any(UnreadMessage.class))).thenReturn(unreadMessages);

        // 执行测试
        mockMvc.perform(get("/unreadMessage/list")
                .param("userId", "1")
                .param("messageType", "INFO"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unreadMessageService, times(1)).selectUnreadMessageList(any(UnreadMessage.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");

        // 模拟服务层返回
        when(unreadMessageService.selectUnreadMessageById(1L)).thenReturn(message);

        // 执行测试
        mockMvc.perform(get("/unreadMessage/{messageId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(unreadMessageService, times(1)).selectUnreadMessageById(1L);
    }

    @Test
    public void testAdd() throws Exception {
        // 准备测试数据
        UnreadMessage message = new UnreadMessage();
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");

        // 模拟服务层返回
        when(unreadMessageService.insertUnreadMessage(message)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/unreadMessage")
                .contentType("application/json")
                .content("{\"userId\":1,\"messageTitle\":\"Test Message\",\"messageContent\":\"Test Content\",\"messageType\":\"INFO\",\"isRead\":\"0\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unreadMessageService, times(1)).insertUnreadMessage(any(UnreadMessage.class));
    }

    @Test
    public void testEdit() throws Exception {
        // 准备测试数据
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Updated Message");
        message.setMessageContent("Updated Content");
        message.setMessageType("INFO");
        message.setIsRead("1");

        // 模拟服务层返回
        when(unreadMessageService.updateUnreadMessage(message)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/unreadMessage")
                .contentType("application/json")
                .content("{\"messageId\":1,\"userId\":1,\"messageTitle\":\"Updated Message\",\"messageContent\":\"Updated Content\",\"messageType\":\"INFO\",\"isRead\":\"1\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unreadMessageService, times(1)).updateUnreadMessage(any(UnreadMessage.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 模拟服务层返回
        when(unreadMessageService.deleteUnreadMessageByIds(any(Long[].class))).thenReturn(1);

        // 执行测试
        mockMvc.perform(delete("/unreadMessage/{messageIds}", "1"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unreadMessageService, times(1)).deleteUnreadMessageByIds(any(Long[].class));
    }
}