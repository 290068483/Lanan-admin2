package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UnreadMessage;
import com.ruoyi.system.service.IUnreadMessageService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 未读消息Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/unreadMessage")
public class UnreadMessageController extends BaseController
{
    @Autowired
    private IUnreadMessageService unreadMessageService;

    /**
     * 查询未读消息列表
     */
    @PreAuthorize("@ss.hasPermi('unreadMessage:list')")
    @GetMapping("/list")
    public TableDataInfo list(UnreadMessage unreadMessage)
    {
        startPage();
        List<UnreadMessage> list = unreadMessageService.selectUnreadMessageList(unreadMessage);
        return getDataTable(list);
    }

    /**
     * 获取未读消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('unreadMessage:query')")
    @GetMapping(value = "/{messageId}")
    public AjaxResult getInfo(@PathVariable("messageId") Long messageId)
    {
        return AjaxResult.success(unreadMessageService.selectUnreadMessageById(messageId));
    }

    /**
     * 新增未读消息
     */
    @PreAuthorize("@ss.hasPermi('unreadMessage:add')")
    @Log(title = "未读消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UnreadMessage unreadMessage)
    {
        return toAjax(unreadMessageService.insertUnreadMessage(unreadMessage));
    }

    /**
     * 修改未读消息
     */
    @PreAuthorize("@ss.hasPermi('unreadMessage:edit')")
    @Log(title = "未读消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UnreadMessage unreadMessage)
    {
        return toAjax(unreadMessageService.updateUnreadMessage(unreadMessage));
    }

    /**
     * 删除未读消息
     */
    @PreAuthorize("@ss.hasPermi('unreadMessage:remove')")
    @Log(title = "未读消息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{messageIds}")
    public AjaxResult remove(@PathVariable Long[] messageIds)
    {
        return toAjax(unreadMessageService.deleteUnreadMessageByIds(messageIds));
    }
}