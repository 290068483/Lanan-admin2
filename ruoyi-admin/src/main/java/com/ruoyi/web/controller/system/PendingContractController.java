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
import com.ruoyi.system.domain.PendingContract;
import com.ruoyi.system.service.IPendingContractService;

/**
 * 待签合同Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/pendingcontract")
public class PendingContractController extends BaseController
{
    @Autowired
    private IPendingContractService pendingContractService;

    /**
     * 查询待签合同列表
     */
    @PreAuthorize("@ss.hasPermi('system:pendingcontract:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingContract pendingContract)
    {
        startPage();
        List<PendingContract> list = pendingContractService.selectPendingContractList(pendingContract);
        return getDataTable(list);
    }

    /**
     * 获取待签合同详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pendingcontract:query')")
    @GetMapping(value = "/{contractId}")
    public AjaxResult getInfo(@PathVariable("contractId") Long contractId)
    {
        return AjaxResult.success(pendingContractService.selectPendingContractById(contractId));
    }

    /**
     * 新增待签合同
     */
    @PreAuthorize("@ss.hasPermi('system:pendingcontract:add')")
    @Log(title = "待签合同", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingContract pendingContract)
    {
        return toAjax(pendingContractService.insertPendingContract(pendingContract));
    }

    /**
     * 修改待签合同
     */
    @PreAuthorize("@ss.hasPermi('system:pendingcontract:edit')")
    @Log(title = "待签合同", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingContract pendingContract)
    {
        return toAjax(pendingContractService.updatePendingContract(pendingContract));
    }

    /**
     * 删除待签合同
     */
    @PreAuthorize("@ss.hasPermi('system:pendingcontract:remove')")
    @Log(title = "待签合同", businessType = BusinessType.DELETE)
    @DeleteMapping("/{contractIds}")
    public AjaxResult remove(@PathVariable Long[] contractIds)
    {
        return toAjax(pendingContractService.deletePendingContractByIds(contractIds));
    }
}