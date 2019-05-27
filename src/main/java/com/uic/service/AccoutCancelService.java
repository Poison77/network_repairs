package com.uic.service;

/**
 * 订单作废管理业务层
 */
public interface AccoutCancelService {

    /**
     * 根据订单号来查询作废订单的作废原因
     */
    public String findAccoutCancelReasonByOrderId(String orderId)throws Exception;

}
