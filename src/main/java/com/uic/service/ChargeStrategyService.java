package com.uic.service;

import com.uic.pojo.ChargeStrategy;

import java.util.List;

/**
 * 收费策略业务层
 */
public interface ChargeStrategyService {
    /**
     * 遍历收费策略信息
     */
    public List<ChargeStrategy> queryChargeStrategy()throws Exception;

    /**
     * 新增收费策略信息
     */
    public void insertChargeStrategy(ChargeStrategy chargeStrategy)throws Exception;

    /**
     * 修改收费策略信息
     */
    public void updateChargeStrategy(ChargeStrategy chargeStrategy)throws Exception;

    /**
     * 逻辑删除收费策略信息
     */
    public void deleteChargeStrategyById(String id)throws Exception;
}
