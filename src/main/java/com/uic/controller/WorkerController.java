package com.uic.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.uic.pojo.*;
import com.uic.pojo.String.RepairRecordCustomStr;
import com.uic.service.*;
import com.uic.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import com.uic.util.StudentUtil;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private StudentRepairService studentRepairService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ChargeStrategyService chargeStrategyService;
    @Autowired
    private StudentDTOService studentDTOService;
    @Autowired
    private UserService userService;


    /**********************************学生基本信息和宽带信息管理**********************************/

    /**
     * 信息处理首页
     * 遍历学生的信息（基本信息、宽带信息）
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //分页
        String pageNum = request.getParameter("pageNum");
        String pageSize =request.getParameter("pageSize");
        //默认起始页是第一页，每页10条数据
        int num = 1;
        int size = 10;
        if (pageNum != null && !"".equals(pageNum)) {
            num = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            size = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(num, size);

//        //获得studentDTOList
//        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
//        studentDTOList = studentDTOService.queryStudentAndBroadband();
//        //获得studentDTO的分页数据
//        PageInfo<StudentDTO> pagehelper = new PageInfo<StudentDTO>(studentDTOList);
//        //获得studentDTOStrList
//        //控制台报错aDate is null，应该是遍历返回的结果中user为null，又赋值给StudentDTO的List,所以报错，但是不影响结果
//        //解决办法是创建一个新的dto类,只有student表和studentBroadband表的信息，没有user
//        List<StudentDTOStr> studentDTOStrList = new ArrayList<StudentDTOStr>();
//        StudentDTOStr studentDTOStr;
//        List<StudentDTO> studentDTOPage=pagehelper.getList();
//        for (StudentDTO studentDTO : studentDTOPage) {
//
//            System.out.println(studentDTO.toString());
//            studentDTOStr = new StudentDTOStr();
//            studentDTOStr = StudentUtil.studentDTOToStr(studentDTO);
//            studentDTOStrList.add(studentDTOStr);
//        }
//        //获得收费策略列表
//        List<ChargeStrategy> strategyList=chargeStrategyService.queryChargeStrategy();
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("strategyList",strategyList);
//        //用于显示数据
//        modelAndView.addObject("studentDTOStrList", studentDTOStrList);
//        //用于分页查询
//        modelAndView.addObject("pagehelper",pagehelper);
//        modelAndView.setViewName("useropen/userOpenIndex");
//
//        return modelAndView;
        return null;
    }

    /**
     * 新生开通首页
     * 遍历学生表、宽带信息表（两表）
     * /worker/openIndex.action
     */
    @RequestMapping("/openIndex")
    public ModelAndView openIndex(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //分页
        String pageNum = request.getParameter("pageNum");
        String pageSize =request.getParameter("pageSize");
        //默认起始页是第一页，每页10条数据
        int num = 1;
        int size = 10;
        if (pageNum != null && !"".equals(pageNum)) {
            num = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            size = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(num, size);

        //获得studentDTOList
        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
        studentDTOList = studentDTOService.queryStudentAndBroadbandByNotInOrder();
        //获得studentDTO的分页数据
        PageInfo<StudentDTO> pagehelper = new PageInfo<StudentDTO>(studentDTOList);

        //得到收费策略
        List<ChargeStrategy> strategyList = chargeStrategyService.queryChargeStrategy();
        //测试
        for (StudentDTO sList : studentDTOList) {
            System.out.println(sList.toString());
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentDTOList", studentDTOList);
        modelAndView.addObject("pagehelper", pagehelper);
        modelAndView.addObject("strategyList", strategyList);
        modelAndView.setViewName("useropen/newOpen");
        return modelAndView;
    }

    /**
     * 新生开通
     * 根据学号遍历学生表、宽带信息表（两表）
     */
    @RequestMapping("/findStudentOpenIndex")
    public ModelAndView findStudentOpenIndex(HttpServletRequest request,String studentId)throws Exception{
        List<StudentDTO> studentDTOList=new ArrayList<StudentDTO>();

        studentDTOList=studentDTOService.findStudentAndBroadbandByNotInOrder(studentId);
        //获得studentDTO的分页数据
        PageInfo<StudentDTO> pagehelper = new PageInfo<StudentDTO>(studentDTOList);

        //得到收费策略
        List<ChargeStrategy> strategyList = chargeStrategyService.queryChargeStrategy();

        //测试
        for (StudentDTO sList : studentDTOList) {
            System.out.println(sList.toString());
        }
        for (ChargeStrategy c : strategyList) {
            System.out.println(c);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pagehelper",pagehelper);
        modelAndView.addObject("studentDTOList", studentDTOList);
        modelAndView.addObject("strategyList", strategyList);
        modelAndView.setViewName("useropen/newOpen");

        return modelAndView;

    }
    /**
     * 用户续费首页
     * 遍历学生表与宽带表的信息（两表）
     * /worker/reNewIndex.action
     */
    @RequestMapping("/reNewIndex")
    public ModelAndView reNewIndex(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //分页
        String pageNum = request.getParameter("pageNum");
        String pageSize =request.getParameter("pageSize");
        //默认起始页是第一页，每页10条数据
        int num = 1;
        int size = 10;
        if (pageNum != null && !"".equals(pageNum)) {
            num = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            size = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(num, size);
//        //得到学生与宽带联合信息,获得studentDTO
//        List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
//        studentDTOList=studentDTOService.queryStudentAndBroadbandByOrder();
//        //获得studentDTO的分页数据
//        PageInfo<StudentDTO> pagehelper = new PageInfo<StudentDTO>(studentDTOList);
//
//        //获得studentDTOStrList
//        List<StudentDTOStr> studentDTOStrList = new ArrayList<StudentDTOStr>();
//        StudentDTOStr studentDTOStr;
//        List<StudentDTO> studentDTOPage=pagehelper.getList();
//
//        for (StudentDTO studentDTO : studentDTOPage) {
//            System.out.println(studentDTO.toString());
//            studentDTOStr = new StudentDTOStr();
//            studentDTOStr = StudentUtil.studentDTOToStr(studentDTO);
//            studentDTOStrList.add(studentDTOStr);
//        }
//
//        //得到收费策略
//        List<ChargeStrategy> strategyList=chargeStrategyService.queryChargeStrategy();

        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.addObject("strategyList",strategyList);
//        modelAndView.addObject("studentDTOStrList",studentDTOStrList);
//        modelAndView.addObject("pagehelper",pagehelper);
        modelAndView.setViewName("useropen/StudentReNew");
        return modelAndView;
    }

    /**
     * 新增收费策略信息
     */
    @RequestMapping("/insertChargeStrategy")
    public String insertChargeStrategy(ChargeStrategy chargeStrategy) throws Exception {
        chargeStrategyService.insertChargeStrategy(chargeStrategy);
        return "redirect:/worker/queryChargeStrategy.action";
    }

    /**
     * 修改收费策略
     */
    @RequestMapping("/updateChargeStrategy")
    public String updateChargeStrategy(ChargeStrategy chargeStrategy) throws Exception {

        chargeStrategyService.updateChargeStrategy(chargeStrategy);

        return "redirect:/worker/queryChargeStrategy.action";
    }

    /**
     * 逻辑删除收费策略
     */
    @RequestMapping("/deleteChargeStrategyById")
    public String deleteChargeStrategyById(String id) throws Exception {
        chargeStrategyService.deleteChargeStrategyById(id);
        return "redirect:/worker/queryChargeStrategy.action";
    }

    /***************************************学生报修管理模块**************************************************/
    /***************************************学生报修信息录入**************************************************/
    /**
     * 遍历所有学生报修信息
     */
    @RequestMapping("/queryRepairRecord")
    public ModelAndView queryRepairRecord(HttpServletResponse response,HttpServletRequest request) throws Exception {

        //分页
        String pageNum = request.getParameter("pageNum");
        String pageSize =request.getParameter("pageSize");
        //默认起始页是第一页，每页8条数据
        int num = 1;
        int size =8;
        if (pageNum != null && !"".equals(pageNum)) {
            num = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            size = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(num, size);

        //获得RepairRecordCustom分页数据
        List<RepairRecordCustom> repairRecordCustomsList = new ArrayList<RepairRecordCustom>();
        repairRecordCustomsList = studentRepairService.queryRepairRecord();
        PageInfo<RepairRecordCustom> pagehelper = new PageInfo<RepairRecordCustom>(repairRecordCustomsList);
        //获得RepairRecordCustomStr分页数据
        List<RepairRecordCustomStr> repairRecordCustomStrList=new ArrayList<RepairRecordCustomStr>();
        RepairRecordCustomStr repairRecordCustomStr;
        List<RepairRecordCustom> RepairRecordCustomPage=pagehelper.getList();
        for (RepairRecordCustom repairRecordCustom : RepairRecordCustomPage) {
            repairRecordCustomStr=new RepairRecordCustomStr();
            repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustom);
            repairRecordCustomStrList.add(repairRecordCustomStr);
            System.out.println(repairRecordCustom);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("repairRecordCustomStrList", repairRecordCustomStrList);
        modelAndView.addObject("pagehelper",pagehelper);
        modelAndView.setViewName("repair/repairSearchAll");
        return modelAndView;
    }

    /**
     * 根据学生Id查询用户的基本报修信息
     */
    @RequestMapping("/findrepairStudent")
    public ModelAndView findrepairStudent(String studentId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.findrepairStudent(studentId);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("repair/repairInput");
        return modelAndView;
    }

    /**
     * 跳转报修信息插入界面
     */
    @RequestMapping("/toinsertRepairRecord")
    public ModelAndView toinsertRepairRecord() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("repair/repairInput");
        return modelAndView;
    }
    /**
     * 插入学生的报修信息
     */
    @RequestMapping("/insertRepairRecord")
    public ModelAndView insertRepairRecord(HttpSession session, RepairRecord repairRecord) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        repairRecord.setAddTime(date);
        studentRepairService.insertRepairRecord(repairRecord);
        modelAndView.setViewName("repair/repairInput");
        return modelAndView;
    }

    /**
     * 根据studentId查询未处理的报修信息
     */
    @RequestMapping("/findNoDealRepairRecoreByStudentId")
    public ModelAndView findNoDealRepairRecoreByStudentId(String studentId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<RepairRecordCustom> repairRecordCustomsList = new ArrayList<RepairRecordCustom>();
        repairRecordCustomsList = studentRepairService.findNoDealRepairRecoreByStudentId(studentId);
        List<RepairRecordCustomStr> repairRecordCustomStrList=new ArrayList<RepairRecordCustomStr>();
        RepairRecordCustomStr repairRecordCustomStr;

        for (RepairRecordCustom repairRecordCustom : repairRecordCustomsList) {
            repairRecordCustomStr=new RepairRecordCustomStr();
            repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustom);
            repairRecordCustomStrList.add(repairRecordCustomStr);
            System.out.println(repairRecordCustom);
        }

        //modelAndView.addObject("repairRecordCustomsList", repairRecordCustomsList);
        modelAndView.addObject("repairRecordCustomStrList", repairRecordCustomStrList);
        modelAndView.setViewName("repair/repairSearchNot");
        return modelAndView;
    }

    /**
     * 遍历所有未处理的学生维修信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryNoDealRepairRecord")
    public ModelAndView queryNoDealRepairRecord(HttpServletResponse response,HttpServletRequest request) throws Exception {

        //分页
        String pageNum = request.getParameter("pageNum");
        String pageSize =request.getParameter("pageSize");
        //默认起始页是第一页，每页8条数据
        int num = 1;
        int size =8;
        if (pageNum != null && !"".equals(pageNum)) {
            num = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            size = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(num, size);

        //获得RepairRecordCustom分页数据
        List<RepairRecordCustom> repairRecordCustomsList = new ArrayList<RepairRecordCustom>();
        repairRecordCustomsList = studentRepairService.queryNoDealRepairRecord();
        PageInfo<RepairRecordCustom> pagehelper = new PageInfo<RepairRecordCustom>(repairRecordCustomsList);
        //获得RepairRecordCustomStr分页数据
        List<RepairRecordCustomStr> repairRecordCustomStrList=new ArrayList<RepairRecordCustomStr>();
        RepairRecordCustomStr repairRecordCustomStr;
        List<RepairRecordCustom> RepairRecordCustomPage=pagehelper.getList();
        for (RepairRecordCustom repairRecordCustom : RepairRecordCustomPage) {
            repairRecordCustomStr=new RepairRecordCustomStr();
            repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustom);
            repairRecordCustomStrList.add(repairRecordCustomStr);
            System.out.println(repairRecordCustom);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("repairRecordCustomStrList", repairRecordCustomStrList);
        modelAndView.addObject("pagehelper",pagehelper);
        modelAndView.setViewName("repair/repairSearchNot");
        return modelAndView;
    }

    /**
     * 根据sudentId与repairContent来查找唯一报修记录(未处理)
     */
    @RequestMapping("/findRepairRecordByStudentIdAndrepairContentNot")
    public ModelAndView findRepairRecordByStudentIdAndrepairContentNot(String studentId, String repairContent) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<RepairRecordCustom> repairRecordCustomsList = new ArrayList<RepairRecordCustom>();
        repairRecordCustomsList = studentRepairService.findRepairRecordByStudentIdAndrepairContent(studentId, repairContent);

        List<RepairRecordCustomStr> repairRecordCustomStrList=new ArrayList<RepairRecordCustomStr>();
        RepairRecordCustomStr repairRecordCustomStr;
        repairRecordCustomStr=new RepairRecordCustomStr();
        repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustomsList.get(0));
        repairRecordCustomStrList.add(repairRecordCustomStr);

        modelAndView.addObject("repairRecordCustomStrList", repairRecordCustomStrList);
        modelAndView.setViewName("repair/repairUserInfermationNot");
        return modelAndView;
    }

    /**
     * 根据studentId查询已处理的报修信息
     */
    @RequestMapping("/findDealRepairRecoreByStudentId")
    public ModelAndView findDealRepairRecoreByStudentId(String studentId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<RepairRecordCustom> repairRecordCustomsList = new ArrayList<RepairRecordCustom>();
        repairRecordCustomsList = studentRepairService.findDealRepairRecoreByStudentId(studentId);
        List<RepairRecordCustomStr> repairRecordCustomStrList=new ArrayList<RepairRecordCustomStr>();
        RepairRecordCustomStr repairRecordCustomStr;

        for (RepairRecordCustom repairRecordCustom : repairRecordCustomsList) {
            repairRecordCustomStr=new RepairRecordCustomStr();
            repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustom);
            repairRecordCustomStrList.add(repairRecordCustomStr);
            System.out.println(repairRecordCustom);
        }

        //modelAndView.addObject("repairRecordCustomsList1", repairRecordCustomsList);
        modelAndView.addObject("repairRecordCustomStrList", repairRecordCustomStrList);
        modelAndView.setViewName("repair/repairSearchYet");
        return modelAndView;
    }

    /**
     * 根据学生Id查询全部报修信息
     */
    @RequestMapping("/findRepairRecordByStudentId")
    public ModelAndView findRepairRecordByStudentId(String studentId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<RepairRecordCustom> repairRecordCustomsList = new ArrayList<RepairRecordCustom>();
        repairRecordCustomsList = studentRepairService.findRepairRecordByStudentId(studentId);
        List<RepairRecordCustomStr> repairRecordCustomStrList=new ArrayList<RepairRecordCustomStr>();
        RepairRecordCustomStr repairRecordCustomStr;

        for (RepairRecordCustom repairRecordCustom : repairRecordCustomsList) {
            repairRecordCustomStr=new RepairRecordCustomStr();
            repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustom);
            repairRecordCustomStrList.add(repairRecordCustomStr);
            System.out.println(repairRecordCustom);
        }

        //modelAndView.addObject("repairRecordCustomsList", repairRecordCustomsList);
        modelAndView.addObject("repairRecordCustomStrList", repairRecordCustomStrList);
        modelAndView.setViewName("repair/repairSearchAll");
        return modelAndView;
    }

    /**
     * 遍历所有已处理的学生维修信息
     */
    @RequestMapping("/queryDealRepairRecord")
    public ModelAndView queryDealRepairRecord(HttpServletResponse response,HttpServletRequest request) throws Exception {
        //分页
        String pageNum = request.getParameter("pageNum");
        String pageSize =request.getParameter("pageSize");
        //默认起始页是第一页，每页8条数据
        int num = 1;
        int size =8;
        if (pageNum != null && !"".equals(pageNum)) {
            num = Integer.parseInt(pageNum);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            size = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(num, size);


        //获得RepairRecordCustom分页数据
        List<RepairRecordCustom> repairRecordCustomsList = new ArrayList<RepairRecordCustom>();
        repairRecordCustomsList = studentRepairService.queryDealRepairRecord();
        PageInfo<RepairRecordCustom> pagehelper = new PageInfo<RepairRecordCustom>(repairRecordCustomsList);
        //获得RepairRecordCustomStr分页数据
        List<RepairRecordCustomStr> repairRecordCustomStrList=new ArrayList<RepairRecordCustomStr>();
        RepairRecordCustomStr repairRecordCustomStr;
        List<RepairRecordCustom> RepairRecordCustomPage=pagehelper.getList();
        for (RepairRecordCustom repairRecordCustom : RepairRecordCustomPage) {
            repairRecordCustomStr=new RepairRecordCustomStr();
            repairRecordCustomStr=StudentUtil.repairRecordCustomToStr(repairRecordCustom);
            repairRecordCustomStrList.add(repairRecordCustomStr);
            System.out.println(repairRecordCustom);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("repairRecordCustomStrList", repairRecordCustomStrList);
        modelAndView.addObject("pagehelper",pagehelper);
        modelAndView.setViewName("repair/repairSearchYet");
        return modelAndView;
    }

    /****************************************************收费策略管理模块*****************************************/

    /**
     * 遍历所有收费策略信息
     * @throws Exception /worker/queryChargeStrategy.action
     */
    @RequestMapping("/queryChargeStrategy")
    public ModelAndView queryChargeStrategy() throws Exception {
        List<ChargeStrategy> strategyList = chargeStrategyService.queryChargeStrategy();
        for (ChargeStrategy cs : strategyList) {
            System.out.println(cs.toString());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("strategyList", strategyList);
        modelAndView.setViewName("chargeStrategy/chargeStrategy");
        return modelAndView;
    }

    /********************************************个人信息模块****************************************************/
    /**
     * 查询当前个人信息
     */
    @RequestMapping("/queryInfo")
    public ModelAndView queryInfo(HttpSession session) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String workerId = session.getAttribute("userId").toString();
        System.out.println(workerId);
        Worker worker = userService.findWorkerByWorkerId(workerId);
        modelAndView.addObject("worker", worker);
        modelAndView.setViewName("userManage/personalInformation");
        return modelAndView;
    }

    /**
     * 职工修改个人信息
     */
    @RequestMapping("/updatePersonalInfo")
    public String updatePersonalInfo(Worker worker) throws Exception {
        userService.updateWorkerByWorkerId(worker);
        return "redirect:/worker/queryInfo.action";
    }
}
