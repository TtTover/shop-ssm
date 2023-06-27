package com.gec.mapper;

import com.gec.bean.Orderitem;
import com.gec.bean.Orders;

import java.util.List;

/**
* @author 17740
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2023-06-21 10:33:31
* @Entity com.gec.bean.Orders
*/
public interface OrdersMapper {

    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /**
     * 通过用户编号查询对应的用户订单信息的方法
     * @param uid
     * @return
     */
    List<Orders> findOrdersByUid(String uid);
}
