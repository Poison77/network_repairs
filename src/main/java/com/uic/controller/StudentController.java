package com.uic.controller;

import com.uic.pojo.RepairRecord;
import org.assertj.core.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    /******************************************学生端报修模块************************************************/
    /******************************************报修信息录入**************************************************/
    /**
     * 插入学生报修信息
     */
    @RequestMapping("/insertRepairRecord")
    public ModelAndView insertRepairRecord(RepairRecord repairRecord) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
//        String nowTime = DateUtil.getDateTime();
//        Date startDate = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", nowTime);
//        repairRecord.setAddTime(startDate);
//        studentRepairService.insertRepairRecord(repairRecord);
//
//        RepairRecordCustom repairRecordCustom= studentRepairService.findRepairRecordByStudentIdAndrepairContent(repairRecord.getStudentId(),repairRecord.getRepairContent()).get(0);
//        RepairRecordCustomStr repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustom);
//        modelAndView.addObject("repairRecordCustomStr",repairRecordCustomStr);
        modelAndView.setViewName("/weChat/repairForSure");
        return modelAndView;
    }
}
