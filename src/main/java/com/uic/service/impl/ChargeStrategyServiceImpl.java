package com.uic.service.impl;

import com.uic.dao.ChargeStrategyMapper;
import com.uic.pojo.ChargeStrategy;
import com.uic.service.ChargeStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeStrategyServiceImpl implements ChargeStrategyService {
    @Autowired
    private ChargeStrategyMapper chargeStrategyMapper;

    /**
     * 遍历收费策略信息
     * @return 收费策略的集合
     * @throws Exception
     */
    @Override
    public List<ChargeStrategy> queryChargeStrategy() throws Exception {
        return chargeStrategyMapper.queryChargeStrategy();
    }
}
