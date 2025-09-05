package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UnreadMessage;

/**
 * 未读消息Service接口
 * 
 * @author ruoyi
 */
public interface IUnreadMessageService 
{
    /**
     * 查询未读消息
     * 
     * @param messageId 未读消息ID
     * @return 未读消息
     */
    public UnreadMessage selectUnreadMessageById(Long messageId);

    /**
     * 查询未读消息列表
     * 
     * @param unreadMessage 未读消息
     * @return 未读消息集合
     */
    public List<UnreadMessage> selectUnreadMessageList(UnreadMessage unreadMessage);

    /**
     * 新增未读消息
     * 
     * @param unreadMessage 未读消息
     * @return 结果
     */
    public int insertUnreadMessage(UnreadMessage unreadMessage);

    /**
     * 修改未读消息
     * 
     * @param unreadMessage 未读消息
     * @return 结果
     */
    public int updateUnreadMessage(UnreadMessage unreadMessage);

    /**
     * 批量删除未读消息
     * 
     * @param messageIds 需要删除的未读消息ID
     * @return 结果
     */
    public int deleteUnreadMessageByIds(Long[] messageIds);

    /**
     * 删除未读消息信息
     * 
     * @param messageId 未读消息ID
     * @return 结果
     */
    public int deleteUnreadMessageById(Long messageId);
}