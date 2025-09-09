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
import com.ruoyi.system.domain.PendingCompletion;
import com.ruoyi.system.service.IPendingCompletionService;

/**
 * 待完工Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/customer/pending-completions")
public class PendingCompletionController extends BaseController
{
    @Autowired
    private IPendingCompletionService pendingCompletionService;

    /**
     * 查询待完工列表
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingcompletion:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingCompletion pendingCompletion)
    {
        startPage();
        List<PendingCompletion> list = pendingCompletionService.selectPendingCompletionList(pendingCompletion);
        return getDataTable(list);
    }

    /**
     * 获取待完工详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingcompletion:query')")
    @GetMapping(value = "/{installationId}")
    public AjaxResult getInfo(@PathVariable("installationId") Long installationId)
    {
        return AjaxResult.success(pendingCompletionService.selectPendingCompletionById(installationId));
    }

    /**
     * 新增待完工
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingcompletion:add')")
    @Log(title = "待完工", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingCompletion pendingCompletion)
    {
        return toAjax(pendingCompletionService.insertPendingCompletion(pendingCompletion));
    }

    /**
     * 修改待完工
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingcompletion:edit')")
    @Log(title = "待完工", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingCompletion pendingCompletion)
    {
        return toAjax(pendingCompletionService.updatePendingCompletion(pendingCompletion));
    }

    /**
     * 删除待完工
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingcompletion:remove')")
    @Log(title = "待完工", businessType = BusinessType.DELETE)
    @DeleteMapping("/{installationIds}")
    public AjaxResult remove(@PathVariable Long[] installationIds)
    {
        return toAjax(pendingCompletionService.deletePendingCompletionByIds(installationIds));
    }
}