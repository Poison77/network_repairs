package com.uic.service;

import com.uic.pojo.StudentDTO;

import java.util.List;

/**
 * StudentDTO业务层
 * 实现学生基本信息与宽带信息的操作
 */
public interface StudentDTOService {
    /**
     * 嵌套查询,只能查询到订单表不存在的学号的学生信息和宽带信息（两表）
     */
    public List<StudentDTO> queryStudentAndBroadbandByNotInOrder()throws Exception;
}
