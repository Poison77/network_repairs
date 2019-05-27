package com.uic.service;

import com.uic.pojo.StudentOrder;

import java.util.List;

/**
 * 学生订单管理业务层
 */
public interface StudentOrderService {

    /**
     * 根据工号、时间段来查询订单记录（排除已经作废的订单）
     */
    public List<StudentOrder> findStudentOrderByDateAndWorkerId(String workerId, String topDate, String buttomDate);

    /**
     * 遍历所有学生的订单信息(排除已经作废的订单)
     */
    public List<StudentOrder> queryStudentOrder()throws Exception;

    /**
     *遍历查询被作废的订单的信息
     */
    public List<StudentOrder> queryStudentOrderCancel()throws Exception;

    /**
     * 根据订单号查询被作废的订单的信息
     */
    public StudentOrder findStudentOrderCancelByOrderId(String orderId)throws Exception;

    /**
     * 根据学号查询被作废的订单的信息
     */
    public StudentOrder findStudentOrderCancelById(String studentId)throws Exception;
}
