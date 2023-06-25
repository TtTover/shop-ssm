package com.gec.mapper;

import com.gec.bean.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @author 17740
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-06-21 10:33:31
* @Entity com.gec.bean.User
*/

public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 通过用户的账号密码去查询用户的信息是否存在
     * @param user
     * @return
     */
    User selectByUserNameAndPassword(User user);
}
