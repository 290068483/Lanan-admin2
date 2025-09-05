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
import com.ruoyi.system.domain.PendingEventDetail;
import com.ruoyi.system.service.IPendingEventDetailService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 待处理事件详情Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/pendingEventDetails")
public class PendingEventDetailsController extends BaseController
{
    @Autowired
    private IPendingEventDetailService pendingEventDetailService;

    /**
     * 查询待处理事件详情列表
     */
    @PreAuthorize("@ss.hasPermi('pendingEventDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingEventDetail pendingEventDetail)
    {
        startPage();
        List<PendingEventDetail> list = pendingEventDetailService.selectPendingEventDetailList(pendingEventDetail);
        return getDataTable(list);
    }

    /**
     * 获取待处理事件详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('pendingEventDetails:query')")
    @GetMapping(value = "/{detailId}")
    public AjaxResult getInfo(@PathVariable("detailId") Long detailId)
    {
        return AjaxResult.success(pendingEventDetailService.selectPendingEventDetailById(detailId));
    }

    /**
     * 新增待处理事件详情
     */
    @PreAuthorize("@ss.hasPermi('pendingEventDetails:add')")
    @Log(title = "待处理事件详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingEventDetail pendingEventDetail)
    {
        return toAjax(pendingEventDetailService.insertPendingEventDetail(pendingEventDetail));
    }

    /**
     * 修改待处理事件详情
     */
    @PreAuthorize("@ss.hasPermi('pendingEventDetails:edit')")
    @Log(title = "待处理事件详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingEventDetail pendingEventDetail)
    {
        return toAjax(pendingEventDetailService.updatePendingEventDetail(pendingEventDetail));
    }

    /**
     * 删除待处理事件详情
     */
    @PreAuthorize("@ss.hasPermi('pendingEventDetails:remove')")
    @Log(title = "待处理事件详情", businessType = BusinessType.DELETE)
    @DeleteMapping("/{detailIds}")
    public AjaxResult remove(@PathVariable Long[] detailIds)
    {
        return toAjax(pendingEventDetailService.deletePendingEventDetailByIds(detailIds));
    }
}