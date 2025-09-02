package com.ruoyi.custom_info.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.custom_info.domain.CusInfo;
import com.ruoyi.custom_info.service.ICusInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户信息（存储客户核心基础信息）Controller
 * 
 * @author randong
 * @date 2025-09-01
 */
@RestController
@RequestMapping("/custom_info/info")
public class CusInfoController extends BaseController
{
    @Autowired
    private ICusInfoService cusInfoService;

    /**
     * 查询客户信息（存储客户核心基础信息）列表
     */
    @PreAuthorize("@ss.hasPermi('custom_info:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(CusInfo cusInfo)
    {
        startPage();
        List<CusInfo> list = cusInfoService.selectCusInfoList(cusInfo);
        return getDataTable(list);
    }

    /**
     * 导出客户信息（存储客户核心基础信息）列表
     */
    @PreAuthorize("@ss.hasPermi('custom_info:info:export')")
    @Log(title = "客户信息（存储客户核心基础信息）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CusInfo cusInfo)
    {
        List<CusInfo> list = cusInfoService.selectCusInfoList(cusInfo);
        ExcelUtil<CusInfo> util = new ExcelUtil<CusInfo>(CusInfo.class);
        util.exportExcel(response, list, "客户信息（存储客户核心基础信息）数据");
    }

    /**
     * 获取客户信息（存储客户核心基础信息）详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom_info:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cusInfoService.selectCusInfoById(id));
    }

    /**
     * 新增客户信息（存储客户核心基础信息）
     */
    @PreAuthorize("@ss.hasPermi('custom_info:info:add')")
    @Log(title = "客户信息（存储客户核心基础信息）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CusInfo cusInfo)
    {
        return toAjax(cusInfoService.insertCusInfo(cusInfo));
    }

    /**
     * 修改客户信息（存储客户核心基础信息）
     */
    @PreAuthorize("@ss.hasPermi('custom_info:info:edit')")
    @Log(title = "客户信息（存储客户核心基础信息）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CusInfo cusInfo)
    {
        return toAjax(cusInfoService.updateCusInfo(cusInfo));
    }

    /**
     * 删除客户信息（存储客户核心基础信息）
     */
    @PreAuthorize("@ss.hasPermi('custom_info:info:remove')")
    @Log(title = "客户信息（存储客户核心基础信息）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cusInfoService.deleteCusInfoByIds(ids));
    }
}
