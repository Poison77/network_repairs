package com.uic.service;

import com.uic.pojo.RepairRecord;
import com.uic.pojo.RepairRecordCustom;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据studentId查询未处理的报修信息
     */
    public List<RepairRecordCustom> findNoDealRepairRecoreByStudentId(String studentId) throws Exception;

    /**
     * 遍历所有已处理的学生维修信息
     */
    public List<RepairRecordCustom> queryDealRepairRecord() throws Exception;

    /**
     * 根据studentId查询处理的报修信息
     */
    public List<RepairRecordCustom> findDealRepairRecoreByStudentId(String studentId) throws Exception;

    /**
     * 遍历所有学生维修信息
     */
    public List<RepairRecordCustom> queryRepairRecord() throws Exception;

    /**
     * 根据学生Id查询报修信息
     */
    public List<RepairRecordCustom> findRepairRecordByStudentId(String studentId) throws Exception;

    /**
     * 根据sudentId与addTime来查找唯一报修记录
     */
    public List<RepairRecordCustom> findRepairRecordByStudentIdAndrepairContent(String studentId,String repairContent)throws Exception;

    /**
     * 根据学生维修内容修改学生报修信息及结果录入
     */
    public void updateRepairRecordByStudentRepairContent(String repairContent,String advice)throws Exception;

    /**
     * 根据studentID 与报修内容删除 对应报修信息
     */
    public void deleteRepairRecordByStudentIdAndrepairContent(String studentId,String repairContent)throws Exception;
}
