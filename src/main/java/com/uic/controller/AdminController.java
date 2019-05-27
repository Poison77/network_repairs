package com.uic.controller;

import com.alibaba.fastjson.JSON;
import com.uic.pojo.String.UserStr;
import com.uic.pojo.User;
import com.uic.pojo.Worker;
import com.uic.service.AdminService;
import com.uic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
//        System.out.println("debug..." + JSON.toJSONString(user));
        List<User> userList = userService.queryUser(user);
//        System.out.println(user.toString());
        System.out.println("用户管理" + userList);

        List<UserStr> userStrList = new ArrayList<>();

        for(User us : userList){
           UserStr uStr = combainUser(us);
           userStrList.add(uStr);
        }
        System.out.println("userStrList： " + userStrList);
        modelAndView.addObject("userList",userStrList);
        modelAndView.setViewName("userManage/userManagement");
        return modelAndView;
    }

    private UserStr combainUser(User us) {

        UserStr str = new UserStr();
        if(us.getUserRoleId().equals("1")){
            str.setRoleName("学生");
        }else if(us.getUserRoleId().equals("2")){
            str.setRoleName("职工");
        }else{
            str.setRoleName("管理员");
        }
        str.setId(us.getId());
        str.setUserId(us.getUserId());
        return str;

    }

    /**
     *
     */
    @RequestMapping("/selectUser")
    public ModelAndView selectUser(User user)throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("debug..." + JSON.toJSONString(user));
        List<User> userList = userService.selectUser(user);
        System.out.println(user.toString());
        System.out.println("userListL: " + userList);
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("userManage/userManagement");
        return modelAndView;
    }


    /**
     * 新增用户url
     */
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public ModelAndView insertUser(User user)throws Exception {
        User u = userService.findUserByUserId(user.getUserId());
        ModelAndView modelAndView = new ModelAndView();
        boolean flag = false;
        if (u != null) {
            //modelAndView.addObject("msg", "新增用户失败,用户ID已存在。");
            flag =true;
        }else{
            userService.insertOrUpdateUser(user);
            if(!user.getUserRoleId().equals("1")){
                Worker worker = new Worker();
                worker.setWorkerId(user.getUserId());
                userService.insertWorker(worker);
            }

        }
        modelAndView = this.queryUser(null);
        if(flag){
            modelAndView.addObject("msg", "1");
        }
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

    /**
     * 删除用户信息
     */
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(String userId, HttpSession session)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("userId").toString().equals(userId)){
            modelAndView = this.queryUser(null);
            modelAndView.addObject("msg","亲，您不能删除自己。");
            return modelAndView;
        }
        User user = userService.findUserByUserId(userId);
        userService.deleteUser(userId);
        if (!user.getUserRoleId().equals("1")) {
            userService.deleteWorker(userId);
        }
        modelAndView=this.queryUser(null);
        return modelAndView;
    }

}
