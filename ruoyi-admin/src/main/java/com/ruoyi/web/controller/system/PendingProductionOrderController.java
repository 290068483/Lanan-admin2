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
import com.ruoyi.system.domain.PendingProductionOrder;
import com.ruoyi.system.service.IPendingProductionOrderService;

/**
 * 待生产Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/pendingproductionorder")
public class PendingProductionOrderController extends BaseController
{
    @Autowired
    private IPendingProductionOrderService pendingProductionOrderService;

    /**
     * 查询待生产列表
     */
    @PreAuthorize("@ss.hasPermi('system:pendingproductionorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingProductionOrder pendingProductionOrder)
    {
        startPage();
        List<PendingProductionOrder> list = pendingProductionOrderService.selectPendingProductionOrderList(pendingProductionOrder);
        return getDataTable(list);
    }

    /**
     * 获取待生产详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pendingproductionorder:query')")
    @GetMapping(value = "/{pendingOrderId}")
    public AjaxResult getInfo(@PathVariable("pendingOrderId") Long pendingOrderId)
    {
        return AjaxResult.success(pendingProductionOrderService.selectPendingProductionOrderById(pendingOrderId));
    }

    /**
     * 新增待生产
     */
    @PreAuthorize("@ss.hasPermi('system:pendingproductionorder:add')")
    @Log(title = "待生产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingProductionOrder pendingProductionOrder)
    {
        return toAjax(pendingProductionOrderService.insertPendingProductionOrder(pendingProductionOrder));
    }

    /**
     * 修改待生产
     */
    @PreAuthorize("@ss.hasPermi('system:pendingproductionorder:edit')")
    @Log(title = "待生产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingProductionOrder pendingProductionOrder)
    {
        return toAjax(pendingProductionOrderService.updatePendingProductionOrder(pendingProductionOrder));
    }

    /**
     * 删除待生产
     */
    @PreAuthorize("@ss.hasPermi('system:pendingproductionorder:remove')")
    @Log(title = "待生产", businessType = BusinessType.DELETE)
    @DeleteMapping("/{pendingOrderIds}")
    public AjaxResult remove(@PathVariable Long[] pendingOrderIds)
    {
        return toAjax(pendingProductionOrderService.deletePendingProductionOrderByIds(pendingOrderIds));
    }
}