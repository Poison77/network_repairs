package com.uic.service.impl;

import com.uic.dao.StudentOrderMapper;
import com.uic.pojo.StudentOrder;
import com.uic.service.StudentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生订单管理业务层实现类
 */
@Service
public class StudentOrderServiceImpl implements StudentOrderService{
    @Autowired
    private StudentOrderMapper studentOrderMapper;

    /**
     * 根据工号、时间段来查询订单记录（排除已经作废的订单）
     */
    @Override
    public List<StudentOrder> findStudentOrderByDateAndWorkerId(String workerId, String topDate, String buttomDate) {
        return studentOrderMapper.findStudentOrderByDateAndWorkerId(workerId,topDate,buttomDate);
    }

    /**
     * 遍历所有学生的订单信息(排除已经作废的订单)
     */
    @Override
    public List<StudentOrder> queryStudentOrder() throws Exception {
        return studentOrderMapper.queryStudentOrder();
    }


    /**
     *遍历查询被作废的订单的信息
     */
    @Override
    public List<StudentOrder> queryStudentOrderCancel() throws Exception {
        return studentOrderMapper.queryStudentOrderCancel();
    }

    /**
     * 根据订单号查询被作废的订单的信息
     * （studentOrder、AccountCancel两表）
     */
    @Override
    public StudentOrder findStudentOrderCancelByOrderId(String orderId) throws Exception {
        return studentOrderMapper.findStudentOrderCancelByOrderId(orderId);
    }

    /**
     * 根据学号查询被作废的订单的信息
     */
    @Override
    public StudentOrder findStudentOrderCancelById(String studentId) throws Exception {
        return studentOrderMapper.findStudentOrderCancelById(studentId);
    }
}
