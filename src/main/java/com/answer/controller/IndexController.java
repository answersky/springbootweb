package com.answer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by liufeng
 * 2019/6/28
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String index(Model model){
        model.addAttribute("name","hello word");
        return "hello";
    }
}
