package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UnreadMessageMapper;
import com.ruoyi.system.domain.UnreadMessage;
import com.ruoyi.system.service.IUnreadMessageService;

/**
 * 未读消息Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class UnreadMessageServiceImpl implements IUnreadMessageService 
{
    @Autowired
    private UnreadMessageMapper unreadMessageMapper;

    /**
     * 查询未读消息
     * 
     * @param messageId 未读消息ID
     * @return 未读消息
     */
    @Override
    public UnreadMessage selectUnreadMessageById(Long messageId)
    {
        return unreadMessageMapper.selectUnreadMessageById(messageId);
    }

    /**
     * 查询未读消息列表
     * 
     * @param unreadMessage 未读消息
     * @return 未读消息
     */
    @Override
    public List<UnreadMessage> selectUnreadMessageList(UnreadMessage unreadMessage)
    {
        return unreadMessageMapper.selectUnreadMessageList(unreadMessage);
    }

    /**
     * 新增未读消息
     * 
     * @param unreadMessage 未读消息
     * @return 结果
     */
    @Override
    public int insertUnreadMessage(UnreadMessage unreadMessage)
    {
        return unreadMessageMapper.insertUnreadMessage(unreadMessage);
    }

    /**
     * 修改未读消息
     * 
     * @param unreadMessage 未读消息
     * @return 结果
     */
    @Override
    public int updateUnreadMessage(UnreadMessage unreadMessage)
    {
        return unreadMessageMapper.updateUnreadMessage(unreadMessage);
    }

    /**
     * 批量删除未读消息
     * 
     * @param messageIds 需要删除的未读消息ID
     * @return 结果
     */
    @Override
    public int deleteUnreadMessageByIds(Long[] messageIds)
    {
        return unreadMessageMapper.deleteUnreadMessageByIds(messageIds);
    }

    /**
     * 删除未读消息信息
     * 
     * @param messageId 未读消息ID
     * @return 结果
     */
    @Override
    public int deleteUnreadMessageById(Long messageId)
    {
        return unreadMessageMapper.deleteUnreadMessageById(messageId);
    }
}