package com.uic.controller;

import com.uic.pojo.User;
import com.uic.pojo.Worker;
import com.uic.service.AdminService;
import com.uic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 管理员控制层
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    /**
     * 遍历所有用户url
     */
    @RequestMapping("/queryUser")
    public ModelAndView queryUser(User user)throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.queryUser(user);
        System.out.println(user.toString());
        System.out.println("用户管理" + userList);
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("userManage/userManagement");
        return modelAndView;
    }

    /**
     * 遍历所有职工url
     */
    @RequestMapping("/queryWorker")
    public ModelAndView queryWorker()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Worker> workerList = userService.queryWorker();
        modelAndView.addObject("workerList", workerList);
        modelAndView.setViewName("userManage/employeeManagement");
        return modelAndView;
    }

    /**
     * 根据id修改职工信息
     */
    @RequestMapping("/updateWorkerInfo")
    public ModelAndView updateWorkerInfo(Worker worker)throws Exception{
        userService.updateWorkerByWorkerId(worker);
        ModelAndView modelAndView = queryWorker();
        return modelAndView;
    }

}
