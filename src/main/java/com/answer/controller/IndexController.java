package com.answer.controller;

import com.answer.service.interfaces.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2019/6/28
 */
@Controller
public class IndexController {
    @Resource
    private IUserService userService;

    @RequestMapping("/hello")
    public String index(Model model){
        String name=userService.findUserByName("liufeng");
        model.addAttribute("name","hello word "+name);
        return "hello";
    }
}
