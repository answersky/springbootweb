package com.answer.controller;

import com.answer.model.User;
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
@RequestMapping("/shiro")
public class IndexController {
    @Resource
    private IUserService userService;

    @RequestMapping("/hello")
    public String index(Model model){
        User user=userService.findUserByName("liufeng");
        model.addAttribute("name","hello word "+user.getUsername());
        return "hello";
    }

}
