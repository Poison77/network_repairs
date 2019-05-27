package com.uic.controller;

import com.alibaba.fastjson.JSONObject;
import com.uic.pojo.RepairRecord;
import com.uic.pojo.RepairRecordCustom;
import com.uic.pojo.String.RepairRecordCustomStr;
import com.uic.service.StudentRepairService;
import com.uic.service.WeChatBindService;
import com.uic.util.DateUtil;
import com.uic.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Date;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private WeChatBindService weChatBindService;
    @Autowired
    private StudentRepairService studentRepairService;

    /******************************************学生端报修模块************************************************/
    /******************************************报修信息录入**************************************************/
    /**
     * 插入学生报修信息
     */
    @RequestMapping("/insertRepairRecord")
    public ModelAndView insertRepairRecord(RepairRecord repairRecord) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String nowTime = DateUtil.getDateTime();
        Date startDate = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", nowTime);
        repairRecord.setAddTime(startDate);
        studentRepairService.insertRepairRecord(repairRecord);

        RepairRecordCustom repairRecordCustom= studentRepairService.findRepairRecordByStudentIdAndrepairContent(repairRecord.getStudentId(),repairRecord.getRepairContent()).get(0);
        RepairRecordCustomStr repairRecordCustomStr= StudentUtil.repairRecordCustomToStr(repairRecordCustom);
        modelAndView.addObject("repairRecordCustomStr",repairRecordCustomStr);
        modelAndView.setViewName("/weChat/repairForSure");
        return modelAndView;
    }

    /**
     * 验证学号密码
     */
    @ResponseBody
    @RequestMapping(value = "/checkPassword",produces = "text/html;charset=UTF-8")
    public String checkPassword(String studentId,String password)throws Exception {
        JSONObject jsonObject = new JSONObject();
        if (weChatBindService.checkUserInfo(studentId, password)) {
            jsonObject.put("state", "ok");
        } else {
            jsonObject.put("state", "fail");
        }
        return jsonObject.toString();
    }

    /**
     * 验证学号
     */
    @ResponseBody
    @RequestMapping(value = "/checkId",produces = "text/html;charset=UTF-8")
    public String checkStudentId(String studentId)throws Exception{
        JSONObject jsonObject = new JSONObject();
        if (weChatBindService.checkStudentIdExist(studentId) == null) {
            jsonObject.put("state", "fail");
        } else {
            if (weChatBindService.checkStudentIdBindExist(studentId)) {
                jsonObject.put("state", "bind");
            } else {
                jsonObject.put("state", "ok");
            }
        }
        return jsonObject.toString();
    }

    /**
     * 根据studentID 与报修内容删除对应报修信息
     * @param studentId
     * @param repairContent
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteRepairRecord")
    public ModelAndView deleteRepairRecord(String studentId,String repairContent)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        studentRepairService.deleteRepairRecordByStudentIdAndrepairContent(studentId,repairContent);
        modelAndView.setViewName("/weChat/repairInput");
        return modelAndView;
    }


    /********************************************微信第三方绑定***********************************************************/

    /**
     * 绑定学号与openid
     */
    @ResponseBody
    @RequestMapping(value = "/bindOpenId",method = RequestMethod.POST)
    public String bindOpenId(String studentId, String openId) throws Exception {
        JSONObject jsonObject = new JSONObject();
        try {
            weChatBindService.BindOpenId(studentId, openId);
            jsonObject.put("state", "ok");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("state", "fail");
        }
        return jsonObject.toString();
    }


}
