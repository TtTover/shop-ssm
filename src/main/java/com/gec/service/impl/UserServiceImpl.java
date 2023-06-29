package com.gec.service.impl;

import com.gec.bean.User;
import com.gec.mapper.UserMapper;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Service 表示这个类是业务逻辑代码
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 接下来写 实现用户登陆接口的实现类代码
     * @param username
     * @param password
     * @return
     */
    @Override
    public User doLogin(String username, String password) {
        //封装用户的个人信息
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //调用数据库访问层代码，进行查询，判断用户输入的账号密码是否正确
        User select = userMapper.selectByUserNameAndPassword(user);
        return select;
    }

    @Override
    public boolean doRegister(User user) {
        int insert = userMapper.insert(user);
        if (insert>0){
            return true;
        }
        return false;
    }

    @Override
    public User findUserById(String uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public boolean updateByPrimaryKey(User user) {
        int update = userMapper.updateByPrimaryKeySelective(user);
        if (update>0){
            return true;
        }
        return false;
    }
}
