package com.answer.service.interfaces;

import com.answer.model.User;

/**
 * created by liufeng
 * 2019/6/28
 */
public interface IUserService {
    User findUserByName(String username);
}
