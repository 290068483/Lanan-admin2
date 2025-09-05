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
import com.ruoyi.system.domain.UnfinishedCustomerOrder;
import com.ruoyi.system.service.IUnfinishedCustomerOrderService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 未完工客户单Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/unfinishedCustomerOrder")
public class UnfinishedCustomerOrderController extends BaseController
{
    @Autowired
    private IUnfinishedCustomerOrderService unfinishedCustomerOrderService;

    /**
     * 查询未完工客户单列表
     */
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(UnfinishedCustomerOrder unfinishedCustomerOrder)
    {
        startPage();
        List<UnfinishedCustomerOrder> list = unfinishedCustomerOrderService.selectUnfinishedCustomerOrderList(unfinishedCustomerOrder);
        return getDataTable(list);
    }

    /**
     * 获取未完工客户单详细信息
     */
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(unfinishedCustomerOrderService.selectUnfinishedCustomerOrderById(orderId));
    }

    /**
     * 新增未完工客户单
     */
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:add')")
    @Log(title = "未完工客户单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UnfinishedCustomerOrder unfinishedCustomerOrder)
    {
        return toAjax(unfinishedCustomerOrderService.insertUnfinishedCustomerOrder(unfinishedCustomerOrder));
    }

    /**
     * 修改未完工客户单
     */
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:edit')")
    @Log(title = "未完工客户单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UnfinishedCustomerOrder unfinishedCustomerOrder)
    {
        return toAjax(unfinishedCustomerOrderService.updateUnfinishedCustomerOrder(unfinishedCustomerOrder));
    }

    /**
     * 删除未完工客户单
     */
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:remove')")
    @Log(title = "未完工客户单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(unfinishedCustomerOrderService.deleteUnfinishedCustomerOrderByIds(orderIds));
    }
}