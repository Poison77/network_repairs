package com.uic.controller;

import com.uic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 管理员控制层
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    @RequestMapping("/test")
//    public String test(){
//        return "login";
//    }
//
//    @RequestMapping("/test2")
//    @ResponseBody
//    public String test2(){
//        return "test";
//    }
//
//    @RequestMapping("/{page}")
//    public String toPage(@PathVariable("page") String page) {
//        return page ;
//    }

}
