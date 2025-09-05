package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PendingEvent;
import com.ruoyi.system.service.IPendingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 待处理事件Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/pendingEvents")
public class PendingEventController extends BaseController
{
    @Autowired
    private IPendingEventService pendingEventService;

    /**
     * 查询待处理事件列表
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingEvent pendingEvent)
    {
        startPage();
        List<PendingEvent> list = pendingEventService.selectPendingEventList(pendingEvent);
        return getDataTable(list);
    }

    /**
     * 获取待处理事件详细信息
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:query')")
    @GetMapping(value = "/{eventId}")
    public AjaxResult getInfo(@PathVariable("eventId") Long eventId)
    {
        return AjaxResult.success(pendingEventService.selectPendingEventById(eventId));
    }

    /**
     * 新增待处理事件
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:add')")
    @Log(title = "待处理事件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingEvent pendingEvent)
    {
        return toAjax(pendingEventService.insertPendingEvent(pendingEvent));
    }

    /**
     * 修改待处理事件
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:edit')")
    @Log(title = "待处理事件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingEvent pendingEvent)
    {
        return toAjax(pendingEventService.updatePendingEvent(pendingEvent));
    }

    /**
     * 删除待处理事件
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:remove')")
    @Log(title = "待处理事件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{eventIds}")
    public AjaxResult remove(@PathVariable Long[] eventIds)
    {
        return toAjax(pendingEventService.deletePendingEventByIds(eventIds));
    }
}