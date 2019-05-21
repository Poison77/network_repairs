package com.uic.service;

import com.uic.pojo.RepairRecord;
import com.uic.pojo.RepairRecordCustom;

import java.util.List;

/**
 * 学生报修信息管理业务层
 */
public interface StudentRepairService {
    /**
     * 学生报修信息录入
     */
    public void insertRepairRecord(RepairRecord repairRecord) throws Exception;

    /**
     * 遍历所有未处理的学生维修信息
     */
    public List<RepairRecordCustom> queryNoDealRepairRecord() throws Exception;

}
