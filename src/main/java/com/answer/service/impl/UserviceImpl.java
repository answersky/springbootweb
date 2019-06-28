package com.answer.service.impl;

import com.answer.dao.UserMapper;
import com.answer.model.User;
import com.answer.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * created by liufeng
 * 2019/6/28
 */
@Service(value = "userService")
public class UserviceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public String findUserByName(String username) {
        User user=userMapper.findUserByName(username);
        return user.getUsername();
    }
}
