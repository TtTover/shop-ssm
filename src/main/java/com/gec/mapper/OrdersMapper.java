package com.gec.mapper;

import com.gec.bean.Orders;

/**
* @author 17740
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2023-06-21 10:33:31
* @Entity com.gec.bean.Orders
*/
public interface OrdersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

}
