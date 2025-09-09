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
import com.ruoyi.system.domain.PendingMeasurement;
import com.ruoyi.system.service.IPendingMeasurementService;

/**
 * 待测量Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/customer/pending-measurements")
public class PendingMeasurementController extends BaseController
{
    @Autowired
    private IPendingMeasurementService pendingMeasurementService;

    /**
     * 查询待测量列表
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingmeasurement:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingMeasurement pendingMeasurement)
    {
        startPage();
        List<PendingMeasurement> list = pendingMeasurementService.selectPendingMeasurementList(pendingMeasurement);
        return getDataTable(list);
    }

    /**
     * 获取待测量详细信息
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingmeasurement:query')")
    @GetMapping(value = "/{measurementId}")
    public AjaxResult getInfo(@PathVariable("measurementId") Long measurementId)
    {
        return AjaxResult.success(pendingMeasurementService.selectPendingMeasurementById(measurementId));
    }

    /**
     * 新增待测量
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingmeasurement:add')")
    @Log(title = "待测量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingMeasurement pendingMeasurement)
    {
        return toAjax(pendingMeasurementService.insertPendingMeasurement(pendingMeasurement));
    }

    /**
     * 修改待测量
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingmeasurement:edit')")
    @Log(title = "待测量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingMeasurement pendingMeasurement)
    {
        return toAjax(pendingMeasurementService.updatePendingMeasurement(pendingMeasurement));
    }

    /**
     * 删除待测量
     */
    @PreAuthorize("@ss.hasPermi('customer:pendingmeasurement:remove')")
    @Log(title = "待测量", businessType = BusinessType.DELETE)
    @DeleteMapping("/{measurementIds}")
    public AjaxResult remove(@PathVariable Long[] measurementIds)
    {
        return toAjax(pendingMeasurementService.deletePendingMeasurementByIds(measurementIds));
    }
}