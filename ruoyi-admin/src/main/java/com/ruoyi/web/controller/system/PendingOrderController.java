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
import com.ruoyi.system.domain.PendingOrder;
import com.ruoyi.system.service.IPendingOrderService;

/**
 * 待下单Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/customer/pending-orders")
public class PendingOrderController extends BaseController
{
    @Autowired
    private IPendingOrderService pendingOrderService;

    /**
     * 查询待下单列表
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingOrder pendingOrder)
    {
        startPage();
        List<PendingOrder> list = pendingOrderService.selectPendingOrderList(pendingOrder);
        return getDataTable(list);
    }

    /**
     * 获取待下单详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingorder:query')")
    @GetMapping(value = "/{progressId}")
    public AjaxResult getInfo(@PathVariable("progressId") Long progressId)
    {
        return AjaxResult.success(pendingOrderService.selectPendingOrderById(progressId));
    }

    /**
     * 新增待下单
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingorder:add')")
    @Log(title = "待下单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingOrder pendingOrder)
    {
        return toAjax(pendingOrderService.insertPendingOrder(pendingOrder));
    }

    /**
     * 修改待下单
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingorder:edit')")
    @Log(title = "待下单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingOrder pendingOrder)
    {
        return toAjax(pendingOrderService.updatePendingOrder(pendingOrder));
    }

    /**
     * 删除待下单
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingorder:remove')")
    @Log(title = "待下单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{progressIds}")
    public AjaxResult remove(@PathVariable Long[] progressIds)
    {
        return toAjax(pendingOrderService.deletePendingOrderByIds(progressIds));
    }
}