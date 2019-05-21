package com.uic.controller;

import com.alibaba.fastjson.JSONObject;
import com.uic.pojo.User;
import com.uic.pojo.Role;
import com.uic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 登录系统控制层
 */
@Controller
@RequestMapping("/log")
public class LoginController {

    @Autowired
    private UserService userService;

    /**  用户登录url **/
    @ResponseBody
    @RequestMapping("/login")
    public String login(String userId, String password, HttpSession session)throws Exception {
        //控制台输出测试
        System.out.println(userId +" "+ password +" "+ session);

        User user = userService.findUserByUserId(userId);
        JSONObject jsonObject = new JSONObject();

        if (user == null) {
            jsonObject.put("state", "noUser");
        }else{
            if(user.getFlag()!=0){
                if (!password.equals(user.getUserPassword())) {
                    jsonObject.put("state", "errorPassword");
                }else{
                    Role role = userService.findRoleByRoleId(user.getUserRoleId());
                    if(!role.getRoleName().equals("学生")){
                        session.setAttribute("userId",user.getUserId());
                        session.setAttribute("userRole",role.getRoleName());
                        if (role.getRoleName().equals("职工")) {
                            jsonObject.put("character", "worker");
                        }
                        if (role.getRoleName().equals("管理员")) {
                            jsonObject.put("character", "admin");
                        }
                    }else{
                        jsonObject.put("state", "errorRole");
                    }
                }
            }else {
                jsonObject.put("state", "noUser");
            }
        }
        return jsonObject.toString();
    }

    /**
     * 跳转至职工主页
     */
    @RequestMapping("/toWork")
    public ModelAndView toWorker() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPageWork");
        return modelAndView;
    }

    /**
     * 跳转至管理员主页
     */
    @RequestMapping("/toAdmin")
    public ModelAndView toAdmin() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPageAdmin");
        return modelAndView;
    }

    /**
     * 用户退出url
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session)throws Exception {
        session.invalidate();
        return ("redirect:/login");
    }

}
