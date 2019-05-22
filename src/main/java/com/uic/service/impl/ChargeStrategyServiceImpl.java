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

    /**
     * 新增收费策略信息
     */
    @Override
    public void insertChargeStrategy(ChargeStrategy chargeStrategy) throws Exception {
        chargeStrategyMapper.insertChargeStrategy(chargeStrategy);
    }

    /**
     * 修改收费策略信息
     */
    @Override
    public void updateChargeStrategy(ChargeStrategy chargeStrategy) throws Exception {
        chargeStrategyMapper.updateChargeStrategy(chargeStrategy);
    }

    /**
     * 逻辑删除收费策略信息
     */
    @Override
    public void deleteChargeStrategyById(String id) throws Exception {
        chargeStrategyMapper.deleteChargeStrategyById(id);
    }
}
