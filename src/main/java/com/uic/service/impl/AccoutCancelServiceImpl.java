package com.uic.service.impl;

import com.uic.dao.AccoutCancelMapper;
import com.uic.service.AccoutCancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单作废管理业务层实现类
 */
@Service
public class AccoutCancelServiceImpl implements AccoutCancelService {

    @Autowired
    private AccoutCancelMapper accoutCancelMapper;

    /**
     * 根据订单号来查询作废订单的作废原因
     */
    @Override
    public String findAccoutCancelReasonByOrderId(String orderId) throws Exception {
        return accoutCancelMapper.findAccoutCancelReasonByOrderId(orderId);
    }
}
