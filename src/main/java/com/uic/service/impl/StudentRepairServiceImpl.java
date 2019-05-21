package com.uic.service.impl;

import com.uic.dao.RepairRecordMapper;
import com.uic.pojo.RepairRecord;
import com.uic.pojo.RepairRecordCustom;
import com.uic.service.StudentRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生报修管理业务层实现类
 */
@Service
public class StudentRepairServiceImpl implements StudentRepairService{
    @Autowired
    private RepairRecordMapper repairRecordMapper;

    /**
     * 学生报修信息录入
     */
    @Override
    public void insertRepairRecord(RepairRecord repairRecord) throws Exception {
        repairRecordMapper.insertRepairRecord(repairRecord);
    }

    /**
     * 遍历所有未处理的学生维修信息
     */
    public List<RepairRecordCustom> queryNoDealRepairRecord() throws Exception{
        return repairRecordMapper.queryNoDealRepairRecord();
    }


}
