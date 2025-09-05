package com.ruoyi.system.service;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.UnreadMessage;
import com.ruoyi.system.mapper.UnreadMessageMapper;
import com.ruoyi.system.service.impl.UnreadMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = RuoYiApplication.class)
public class UnreadMessageServiceTest {

    @Mock
    private UnreadMessageMapper unreadMessageMapper;

    @InjectMocks
    private UnreadMessageServiceImpl unreadMessageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSelectUnreadMessageList() {
        // 准备测试数据
        List<UnreadMessage> expectedList = new ArrayList<>();
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");
        expectedList.add(message);

        // 模拟Mapper层返回
        when(unreadMessageMapper.selectUnreadMessageList(any(UnreadMessage.class))).thenReturn(expectedList);

        // 执行测试
        List<UnreadMessage> actualList = unreadMessageService.selectUnreadMessageList(new UnreadMessage());

        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("Test Message", actualList.get(0).getMessageTitle());

        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).selectUnreadMessageList(any(UnreadMessage.class));
    }

    @Test
    public void testSelectUnreadMessageById() {
        // 准备测试数据
        UnreadMessage expectedMessage = new UnreadMessage();
        expectedMessage.setMessageId(1L);
        expectedMessage.setUserId(1L);
        expectedMessage.setMessageTitle("Test Message");
        expectedMessage.setMessageContent("Test Content");
        expectedMessage.setMessageType("INFO");
        expectedMessage.setIsRead("0");

        // 模拟Mapper层返回
        when(unreadMessageMapper.selectUnreadMessageById(1L)).thenReturn(expectedMessage);

        // 执行测试
        UnreadMessage actualMessage = unreadMessageService.selectUnreadMessageById(1L);

        // 验证结果
        assertNotNull(actualMessage);
        assertEquals("Test Message", actualMessage.getMessageTitle());

        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).selectUnreadMessageById(1L);
    }

    @Test
    public void testInsertUnreadMessage() {
        // 准备测试数据
        UnreadMessage message = new UnreadMessage();
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");

        // 模拟Mapper层返回
        when(unreadMessageMapper.insertUnreadMessage(message)).thenReturn(1);

        // 执行测试
        int result = unreadMessageService.insertUnreadMessage(message);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).insertUnreadMessage(message);
    }

    @Test
    public void testUpdateUnreadMessage() {
        // 准备测试数据
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Updated Message");
        message.setMessageContent("Updated Content");
        message.setMessageType("INFO");
        message.setIsRead("1");

        // 模拟Mapper层返回
        when(unreadMessageMapper.updateUnreadMessage(message)).thenReturn(1);

        // 执行测试
        int result = unreadMessageService.updateUnreadMessage(message);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).updateUnreadMessage(message);
    }

    @Test
    public void testDeleteUnreadMessageById() {
        // 模拟Mapper层返回
        when(unreadMessageMapper.deleteUnreadMessageById(1L)).thenReturn(1);

        // 执行测试
        int result = unreadMessageService.deleteUnreadMessageById(1L);

        // 验证结果
        assertEquals(1, result);

        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).deleteUnreadMessageById(1L);
    }

    @Test
    public void testDeleteUnreadMessageByIds() {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟Mapper层返回
        when(unreadMessageMapper.deleteUnreadMessageByIds(ids)).thenReturn(3);

        // 执行测试
        int result = unreadMessageService.deleteUnreadMessageByIds(ids);

        // 验证结果
        assertEquals(3, result);

        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).deleteUnreadMessageByIds(ids);
    }
}