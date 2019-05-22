package com.uic.service.impl;

import com.uic.dao.StudentDTOMapper;
import com.uic.pojo.StudentDTO;
import com.uic.service.StudentDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDTOServiceImpl implements StudentDTOService {
    @Autowired
    private StudentDTOMapper studentDTOMapper;

    /**
     * 嵌套查询,只能查询到订单表不存在的学号的学生信息和宽带信息（两表）
     */
    @Override
    public List<StudentDTO> queryStudentAndBroadbandByNotInOrder() throws Exception {
        return studentDTOMapper.queryStudentAndBroadbandByNotInOrder();
    }

    /**
     * 根据学号嵌套查询,只能查询到订单表不存在的学号的学生信息和宽带信息（两表）
     */
    @Override
    public List<StudentDTO> findStudentAndBroadbandByNotInOrder(String studentId) throws Exception {
        return studentDTOMapper.findStudentAndBroadbandByNotInOrder(studentId);
    }
}
