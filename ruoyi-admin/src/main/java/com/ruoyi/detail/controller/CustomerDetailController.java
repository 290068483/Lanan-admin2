package com.ruoyi.detail.controller;

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
import com.ruoyi.detail.domain.CustomerDetail;
import com.ruoyi.detail.service.ICustomerDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户详情（存储客户补充信息）Controller
 * 
 * @author randong
 * @date 2025-09-01
 */
@RestController
@RequestMapping("/custom_detail/detail")
public class CustomerDetailController extends BaseController
{
    @Autowired
    private ICustomerDetailService customerDetailService;

    /**
     * 查询客户详情（存储客户补充信息）列表
     */
    @PreAuthorize("@ss.hasPermi('custom_detail:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(CustomerDetail customerDetail)
    {
        startPage();
        List<CustomerDetail> list = customerDetailService.selectCustomerDetailList(customerDetail);
        return getDataTable(list);
    }

    /**
     * 导出客户详情（存储客户补充信息）列表
     */
    @PreAuthorize("@ss.hasPermi('custom_detail:detail:export')")
    @Log(title = "客户详情（存储客户补充信息）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CustomerDetail customerDetail)
    {
        List<CustomerDetail> list = customerDetailService.selectCustomerDetailList(customerDetail);
        ExcelUtil<CustomerDetail> util = new ExcelUtil<CustomerDetail>(CustomerDetail.class);
        util.exportExcel(response, list, "客户详情（存储客户补充信息）数据");
    }

    /**
     * 获取客户详情（存储客户补充信息）详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom_detail:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(customerDetailService.selectCustomerDetailById(id));
    }

    /**
     * 新增客户详情（存储客户补充信息）
     */
    @PreAuthorize("@ss.hasPermi('custom_detail:detail:add')")
    @Log(title = "客户详情（存储客户补充信息）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CustomerDetail customerDetail)
    {
        return toAjax(customerDetailService.insertCustomerDetail(customerDetail));
    }

    /**
     * 修改客户详情（存储客户补充信息）
     */
    @PreAuthorize("@ss.hasPermi('custom_detail:detail:edit')")
    @Log(title = "客户详情（存储客户补充信息）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CustomerDetail customerDetail)
    {
        return toAjax(customerDetailService.updateCustomerDetail(customerDetail));
    }

    /**
     * 删除客户详情（存储客户补充信息）
     */
    @PreAuthorize("@ss.hasPermi('custom_detail:detail:remove')")
    @Log(title = "客户详情（存储客户补充信息）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(customerDetailService.deleteCustomerDetailByIds(ids));
    }
}
