package com.gec.service;

import com.gec.bean.User;

public interface UserService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    User doLogin(String username,String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean doRegister(User user);

    /**
     * 按编号查询用户信息
     * @param uid
     * @return
     */
    User findUserById(String uid);

    boolean updateByPrimaryKey(User user);
}
