package com.uic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testcontroller {

    @RequestMapping("/")
    public String test(){
        return "login";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        return "test";
    }

    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page) {
        return page ;
    }


    @RequestMapping("/{page}/{page2}")
    public String toPage(@PathVariable("page") String page,@PathVariable("page2") String page2) {

        return page+"/"+page2 ;
    }
}
