package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PendingContractMapper;
import com.ruoyi.system.domain.PendingContract;
import com.ruoyi.system.service.IPendingContractService;

/**
 * 待签合同Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingContractServiceImpl implements IPendingContractService 
{
    @Autowired
    private PendingContractMapper pendingContractMapper;

    /**
     * 查询待签合同
     * 
     * @param contractId 待签合同ID
     * @return 待签合同
     */
    @Override
    public PendingContract selectPendingContractById(Long contractId)
    {
        return pendingContractMapper.selectPendingContractById(contractId);
    }

    /**
     * 查询待签合同列表
     * 
     * @param pendingContract 待签合同
     * @return 待签合同
     */
    @Override
    public List<PendingContract> selectPendingContractList(PendingContract pendingContract)
    {
        return pendingContractMapper.selectPendingContractList(pendingContract);
    }

    /**
     * 新增待签合同
     * 
     * @param pendingContract 待签合同
     * @return 结果
     */
    @Override
    public int insertPendingContract(PendingContract pendingContract)
    {
        return pendingContractMapper.insertPendingContract(pendingContract);
    }

    /**
     * 修改待签合同
     * 
     * @param pendingContract 待签合同
     * @return 结果
     */
    @Override
    public int updatePendingContract(PendingContract pendingContract)
    {
        return pendingContractMapper.updatePendingContract(pendingContract);
    }

    /**
     * 删除待签合同对象
     * 
     * @param contractIds 需要删除的待签合同ID
     * @return 结果
     */
    @Override
    public int deletePendingContractByIds(Long[] contractIds)
    {
        return pendingContractMapper.deletePendingContractByIds(contractIds);
    }

    /**
     * 删除待签合同信息
     * 
     * @param contractId 待签合同ID
     * @return 结果
     */
    @Override
    public int deletePendingContractById(Long contractId)
    {
        return pendingContractMapper.deletePendingContractById(contractId);
    }
}