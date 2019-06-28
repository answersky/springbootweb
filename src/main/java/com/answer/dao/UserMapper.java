package com.answer.dao;

import com.answer.model.User;

/**
 * created by liufeng
 * 2018/9/11
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User findUserByName(String username);
}
