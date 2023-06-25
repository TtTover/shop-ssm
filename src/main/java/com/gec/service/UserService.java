package com.gec.service;

import com.gec.bean.User;

public interface UserService {
    /**
     * 进行登陆校验的业务逻辑代码
     * @param username
     * @param password
     * @return
     */
    User doLogin(String username,String password);
}
