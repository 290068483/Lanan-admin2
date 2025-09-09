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
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PendingArchived;
import com.ruoyi.system.service.IPendingArchivedService;

/**
 * 待归档Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/customer/pending-archives")
public class PendingArchivedController extends BaseController
{
    @Autowired
    private IPendingArchivedService pendingArchivedService;

    /**
     * 查询待归档列表
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingarchived:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingArchived pendingArchived)
    {
        startPage();
        List<PendingArchived> list = pendingArchivedService.selectPendingArchivedList(pendingArchived);
        return getDataTable(list);
    }

    /**
     * 获取待归档详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingarchived:query')")
    @GetMapping(value = "/{archiveId}")
    public AjaxResult getInfo(@PathVariable("archiveId") Long archiveId)
    {
        return AjaxResult.success(pendingArchivedService.selectPendingArchivedById(archiveId));
    }

    /**
     * 新增待归档
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingarchived:add')")
    @Log(title = "待归档", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingArchived pendingArchived)
    {
        return toAjax(pendingArchivedService.insertPendingArchived(pendingArchived));
    }

    /**
     * 修改待归档
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingarchived:edit')")
    @Log(title = "待归档", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingArchived pendingArchived)
    {
        return toAjax(pendingArchivedService.updatePendingArchived(pendingArchived));
    }

    /**
     * 删除待归档
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingarchived:remove')")
    @Log(title = "待归档", businessType = BusinessType.DELETE)
    @DeleteMapping("/{archiveIds}")
    public AjaxResult remove(@PathVariable Long[] archiveIds)
    {
        return toAjax(pendingArchivedService.deletePendingArchivedByIds(archiveIds));
    }
}