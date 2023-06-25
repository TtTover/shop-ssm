package com.gec.mapper;

import com.gec.bean.Orderitem;

/**
* @author 17740
* @description 针对表【orderitem】的数据库操作Mapper
* @createDate 2023-06-21 10:33:31
* @Entity com.gec.bean.Orderitem
*/
public interface OrderitemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    Orderitem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);

}
