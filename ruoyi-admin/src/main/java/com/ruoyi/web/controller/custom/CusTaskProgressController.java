package com.ruoyi.web.controller.custom;

import java.util.List;
import java.util.Date;
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
import com.ruoyi.custom_info.domain.CusTaskProgress;
import com.ruoyi.custom_info.service.ICusTaskProgressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.DateUtils;

/**
 * 任务进度Controller
 * 
 * @author ruoyi
 * @date 2025-09-08
 */
@RestController
@RequestMapping("/custom/taskprogress")
public class CusTaskProgressController extends BaseController
{
    @Autowired
    private ICusTaskProgressService cusTaskProgressService;

    /**
     * 查询任务进度列表 - 默认查询接口
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/list")
    public TableDataInfo list()
    {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }

    /**
     * 根据名称模糊匹配查询
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/listByName/{taskName}")
    public TableDataInfo listByName(@PathVariable("taskName") String taskName)
    {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        cusTaskProgress.setTaskName(taskName);
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }

    /**
     * 根据发布者模糊查询
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/listByPublisher/{publisher}")
    public TableDataInfo listByPublisher(@PathVariable("publisher") String publisher)
    {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        cusTaskProgress.setPublisher(publisher);
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }

    /**
     * 根据开始日期和结束日期查询
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/listByDateRange")
    public TableDataInfo listByDateRange(String startDate, String endDate)
    {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        if (startDate != null && !startDate.isEmpty()) {
            cusTaskProgress.setStartTime(DateUtils.parseDate(startDate));
        }
        if (endDate != null && !endDate.isEmpty()) {
            cusTaskProgress.setCompletionTime(DateUtils.parseDate(endDate));
        }
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }

    /**
     * 获取任务进度详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(cusTaskProgressService.selectCusTaskProgressById(id));
    }

    /**
     * 新增任务进度
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:add')")
    @Log(title = "任务进度", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CusTaskProgress cusTaskProgress)
    {
        return toAjax(cusTaskProgressService.insertCusTaskProgress(cusTaskProgress));
    }

    /**
     * 修改任务进度
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:edit')")
    @Log(title = "任务进度", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CusTaskProgress cusTaskProgress)
    {
        return toAjax(cusTaskProgressService.updateCusTaskProgress(cusTaskProgress));
    }

    /**
     * 删除任务进度
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:remove')")
    @Log(title = "任务进度", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cusTaskProgressService.deleteCusTaskProgressByIds(ids));
    }
}