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
import com.ruoyi.system.domain.PendingDelivery;
import com.ruoyi.system.service.IPendingDeliveryService;

/**
 * 待出货Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/customer/pending-deliveries")
public class PendingDeliveryController extends BaseController
{
    @Autowired
    private IPendingDeliveryService pendingDeliveryService;

    /**
     * 查询待出货列表
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingdelivery:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingDelivery pendingDelivery)
    {
        startPage();
        List<PendingDelivery> list = pendingDeliveryService.selectPendingDeliveryList(pendingDelivery);
        return getDataTable(list);
    }

    /**
     * 获取待出货详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingdelivery:query')")
    @GetMapping(value = "/{deliveryId}")
    public AjaxResult getInfo(@PathVariable("deliveryId") Long deliveryId)
    {
        return AjaxResult.success(pendingDeliveryService.selectPendingDeliveryById(deliveryId));
    }

    /**
     * 新增待出货
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingdelivery:add')")
    @Log(title = "待出货", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingDelivery pendingDelivery)
    {
        return toAjax(pendingDeliveryService.insertPendingDelivery(pendingDelivery));
    }

    /**
     * 修改待出货
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingdelivery:edit')")
    @Log(title = "待出货", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingDelivery pendingDelivery)
    {
        return toAjax(pendingDeliveryService.updatePendingDelivery(pendingDelivery));
    }

    /**
     * 删除待出货
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingdelivery:remove')")
    @Log(title = "待出货", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deliveryIds}")
    public AjaxResult remove(@PathVariable Long[] deliveryIds)
    {
        return toAjax(pendingDeliveryService.deletePendingDeliveryByIds(deliveryIds));
    }
}