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
}
