package com.uic.service.impl;

import com.uic.dao.StudentMapper;
import com.uic.pojo.Student;
import com.uic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据学号查询学生基本信息(针对于报修)
     */
    @Override
    public Student findrepairStudent(String studentId)throws Exception{
        Student student=studentMapper.findrepairStudent(studentId);
        return student;
    }
}
