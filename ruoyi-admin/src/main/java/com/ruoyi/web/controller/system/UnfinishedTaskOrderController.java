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
import com.ruoyi.system.domain.UnfinishedTaskOrder;
import com.ruoyi.system.service.IUnfinishedTaskOrderService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 未完工任务单Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/unfinishedTaskOrder")
public class UnfinishedTaskOrderController extends BaseController
{
    @Autowired
    private IUnfinishedTaskOrderService unfinishedTaskOrderService;

    /**
     * 查询未完工任务单列表
     */
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(UnfinishedTaskOrder unfinishedTaskOrder)
    {
        startPage();
        List<UnfinishedTaskOrder> list = unfinishedTaskOrderService.selectUnfinishedTaskOrderList(unfinishedTaskOrder);
        return getDataTable(list);
    }

    /**
     * 获取未完工任务单详细信息
     */
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return AjaxResult.success(unfinishedTaskOrderService.selectUnfinishedTaskOrderById(taskId));
    }

    /**
     * 新增未完工任务单
     */
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:add')")
    @Log(title = "未完工任务单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UnfinishedTaskOrder unfinishedTaskOrder)
    {
        return toAjax(unfinishedTaskOrderService.insertUnfinishedTaskOrder(unfinishedTaskOrder));
    }

    /**
     * 修改未完工任务单
     */
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:edit')")
    @Log(title = "未完工任务单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UnfinishedTaskOrder unfinishedTaskOrder)
    {
        return toAjax(unfinishedTaskOrderService.updateUnfinishedTaskOrder(unfinishedTaskOrder));
    }

    /**
     * 删除未完工任务单
     */
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:remove')")
    @Log(title = "未完工任务单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(unfinishedTaskOrderService.deleteUnfinishedTaskOrderByIds(taskIds));
    }
}