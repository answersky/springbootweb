package com.answer.controller;

import com.answer.model.ResponseResult;
import com.answer.model.User;
import com.answer.service.interfaces.IUserService;
import com.google.gson.Gson;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2019/6/28
 */
@Controller
public class LoginController {
    @Resource
    private IUserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/msg")
    public String message(){
        return "message";
    }

    @RequestMapping("/validate")
    public String validate(Model model, String username, String password) {
        Gson gson=new Gson();
        ResponseResult responseResult = new ResponseResult();
        User user = userService.findUserByName(username);
        if (user == null) {
            responseResult.setMessage("用户不存在");
            responseResult.setStatus("400");
            model.addAttribute("msg",gson.toJson(responseResult));
            return "message";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // shiro登陆验证
        try {
            SecurityUtils.getSubject().login(token);
            //设置登录超时时长 2小时
            SecurityUtils.getSubject().getSession().setTimeout(7200000);
            responseResult.setMessage("登录成功");
            responseResult.setStatus("200");
            return "redirect:/shiro/hello";
        } catch (UnknownAccountException ex) {
            responseResult.setMessage("用户不存在");
            responseResult.setStatus("400");
        } catch (IncorrectCredentialsException ex) {
            responseResult.setMessage("密码错误");
            responseResult.setStatus("400");
        } catch (AuthenticationException ex) {
            responseResult.setMessage("系统异常");
            responseResult.setStatus("400");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
            responseResult.setMessage("系统异常");
            responseResult.setStatus("400");
        }
        model.addAttribute("msg",gson.toJson(responseResult));
        return "message";
    }
}
