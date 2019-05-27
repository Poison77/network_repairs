package com.uic.service.impl;

import com.uic.dao.RepairRecordMapper;
import com.uic.pojo.RepairRecord;
import com.uic.pojo.RepairRecordCustom;
import com.uic.service.StudentRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    /**
     * 根据studentId查询未处理的报修信息
     */
    public List<RepairRecordCustom> findNoDealRepairRecoreByStudentId(String studentId) throws Exception{
        return repairRecordMapper.findNoDealRepairRecoreByStudentId(studentId);
    }

    /**
     * 遍历所有已处理的学生维修信息
     */
    public List<RepairRecordCustom> queryDealRepairRecord() throws Exception{
        return repairRecordMapper.queryDealRepairRecord();
    }

    /**
     * 根据studentId查询处理的报修信息
     */
    public List<RepairRecordCustom> findDealRepairRecoreByStudentId(String studentId) throws Exception{
        return repairRecordMapper.findDealRepairRecoreByStudentId(studentId);
    }

    /**
     * 遍历所有学生维修信息
     */
    @Override
    public List<RepairRecordCustom> queryRepairRecord() throws Exception {
        return repairRecordMapper.queryRepairRecord();
    }

    /**
     * 根据学生Id查询报修信息
     * 根据日期进行排列
     */
    @Override
    public List<RepairRecordCustom> findRepairRecordByStudentId(String studentId) throws Exception{
        return repairRecordMapper.findRepairRecordByStudentId(studentId);
    }

    /**
     * 根据sudentId与addTime来查找唯一报修记录
     */
    public List<RepairRecordCustom> findRepairRecordByStudentIdAndrepairContent(String studentId, String repairContent)throws Exception{
        return repairRecordMapper.findRepairRecordByStudentIdAndrepairContent(studentId,repairContent);
    }

    /**
     * 根据学生维修内容修改学生报修信息及结果录入
     */
    public void updateRepairRecordByStudentRepairContent(String repairContent,String advice)throws  Exception{
        repairRecordMapper.updateRepairRecordByStudentRepairContent(repairContent,advice);
    }

    /**
     * 根据studentID 与报修内容删除 对应报修信息
     */
    public void deleteRepairRecordByStudentIdAndrepairContent(String studentId,String repairContent)throws Exception{
        repairRecordMapper.deleteRepairRecordByStudentIdAndrepairContent(studentId, repairContent);
    }
}
