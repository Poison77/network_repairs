package com.uic.service;

import com.uic.pojo.Student;

/**
 * 学生基本信息管理业务层
 */
public interface StudentService {

    /**
     * 根据学号查询学生基本信息(针对于报修)
     */
    public Student findrepairStudent(String studentId)throws Exception;



}
