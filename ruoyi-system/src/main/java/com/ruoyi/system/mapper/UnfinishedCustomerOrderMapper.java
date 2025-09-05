package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UnfinishedCustomerOrder;

/**
 * 未完工客户单Mapper接口
 * 
 * @author ruoyi
 */
public interface UnfinishedCustomerOrderMapper 
{
    /**
     * 查询未完工客户单
     * 
     * @param orderId 未完工客户单ID
     * @return 未完工客户单
     */
    public UnfinishedCustomerOrder selectUnfinishedCustomerOrderById(Long orderId);

    /**
     * 查询未完工客户单列表
     * 
     * @param unfinishedCustomerOrder 未完工客户单
     * @return 未完工客户单集合
     */
    public List<UnfinishedCustomerOrder> selectUnfinishedCustomerOrderList(UnfinishedCustomerOrder unfinishedCustomerOrder);

    /**
     * 新增未完工客户单
     * 
     * @param unfinishedCustomerOrder 未完工客户单
     * @return 结果
     */
    public int insertUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder);

    /**
     * 修改未完工客户单
     * 
     * @param unfinishedCustomerOrder 未完工客户单
     * @return 结果
     */
    public int updateUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder);

    /**
     * 删除未完工客户单
     * 
     * @param orderId 未完工客户单ID
     * @return 结果
     */
    public int deleteUnfinishedCustomerOrderById(Long orderId);

    /**
     * 批量删除未完工客户单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUnfinishedCustomerOrderByIds(Long[] orderIds);
}