package com.uic.dao;

import com.uic.pojo.RepairRecord;
import com.uic.pojo.RepairRecordCustom;

import java.util.List;

/**
 * 报修记录管理
 */
public interface RepairRecordMapper {
    /**
     * 学生报修信息录入
     */
    public void insertRepairRecord(RepairRecord repairRecord) throws Exception;

    /**
     * 遍历所有未处理的学生维修信息
     */
    public List<RepairRecordCustom> queryNoDealRepairRecord() throws Exception;
}
