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
     * 根据学生Id查询全部报修信息
     * @param studentId
     * @return List<RepairRecordCustom>
     * @throws Exception
     */
    public List<RepairRecordCustom> findRepairRecordByStudentId(String studentId) throws Exception;

    /**
     * 遍历所有学生维修信
     */
    public List<RepairRecordCustom> queryRepairRecord() throws Exception;

    /**
     * 根据studentId查询未处理的报修信息
     */
    public List<RepairRecordCustom> findNoDealRepairRecoreByStudentId(String studentId) throws Exception;

    /**
     * 遍历所有未处理的学生维修信息
     */
    public List<RepairRecordCustom> queryNoDealRepairRecord() throws Exception;

    /**
     * 根据studentId查询处理的报修信息
     */
    public List<RepairRecordCustom> findDealRepairRecoreByStudentId(String studentId) throws Exception;

    /**
     * 遍历所有已处理的学生维修信息
     */
    public List<RepairRecordCustom> queryDealRepairRecord() throws Exception;


    /**
     * 根据学生Id删除学生报修信息
     */
    public void deleteRepairRecordByStudentId(String studentId)throws Exception;

    /**
     * 根据StudentId和报修状态查询报修信息
     */
    public List<RepairRecordCustom> findRepairRecordByStudentIdByExample(RepairRecord repairRecord)throws Exception;

    /**
     * 根据学生维修内容修改学生报修信息及结果录入
     */
    public void updateRepairRecordByStudentRepairContent(String repairContent,String advice)throws Exception;

    /**
     * 根据sudentId与addTime来查找唯一报修记录
     */
    public List<RepairRecordCustom> findRepairRecordByStudentIdAndrepairContent(String studentId,String repairContent)throws Exception;

    /**
     * 根据sudentId与resultFlag来查找对应的报修记录
     */
    public List<RepairRecordCustom> findRepairRecordByStudentIdAndresultFlag(String studentId,int resultFlag)throws Exception;

    /**
     * 根据学号前缀删除所有的用户报修信息
     */
    public void deleteRepairRecordTrue(String id)throws Exception;

    /**
     * 根据studentID 与报修内容删除 对应报修信息
     */
    public void deleteRepairRecordByStudentIdAndrepairContent(String studentId,String repairContent)throws Exception;
}
