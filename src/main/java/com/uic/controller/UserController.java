package com.uic.controller;

import com.uic.pojo.User;
import com.uic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private WorkerController workerController;
    @Autowired
    private AdminController adminController;

    /**
     * 跳转至个人密码修改页面url
     */
    @RequestMapping("/jumpToModifyPasswordView")
    public ModelAndView jumpToModifyPasswordView(HttpSession session)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        String id = session.getAttribute("userId").toString();
        modelAndView.addObject("userId", id);
        modelAndView.setViewName("/userManage/modifyPassword");
        return modelAndView;
    }

    /**
     * 修改用户密码url
     */
    @RequestMapping("/updatePassword")
    public ModelAndView  updatePassword(HttpSession session, User user, String oldPassword)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("userRole").toString().equals("管理员") && !session.getAttribute("userId").toString().equals(user.getUserId())){
            userService.updateUserPasswordByUserId(user);
            modelAndView = adminController.queryUser(null);
        }else{
            User u = userService.findUserByUserId(session.getAttribute("userId").toString());
            if (u.getUserPassword().equals(oldPassword)) {
                modelAndView=workerController.queryInfo(session);
                userService.updateUserPasswordByUserId(user);
            } else {
                modelAndView.addObject("msg", "旧密码不正确。");
                modelAndView.setViewName("userManage/modifyPassword");
            }
        }
        return modelAndView;
    }


}
