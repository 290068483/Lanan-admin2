package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PendingContract;

/**
 * 待签合同Mapper接口
 * 
 * @author ruoyi
 */
public interface PendingContractMapper 
{
    /**
     * 查询待签合同
     * 
     * @param contractId 待签合同ID
     * @return 待签合同
     */
    public PendingContract selectPendingContractById(Long contractId);

    /**
     * 查询待签合同列表
     * 
     * @param pendingContract 待签合同
     * @return 待签合同集合
     */
    public List<PendingContract> selectPendingContractList(PendingContract pendingContract);

    /**
     * 新增待签合同
     * 
     * @param pendingContract 待签合同
     * @return 结果
     */
    public int insertPendingContract(PendingContract pendingContract);

    /**
     * 修改待签合同
     * 
     * @param pendingContract 待签合同
     * @return 结果
     */
    public int updatePendingContract(PendingContract pendingContract);

    /**
     * 删除待签合同
     * 
     * @param contractId 待签合同ID
     * @return 结果
     */
    public int deletePendingContractById(Long contractId);

    /**
     * 批量删除待签合同
     * 
     * @param contractIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePendingContractByIds(Long[] contractIds);
}