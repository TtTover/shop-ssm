package com.gec.service;

import com.gec.bean.Orderitem;
import com.gec.bean.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 添加订单的方法
     * @param orders
     * @return
     */
    boolean addOrders(Orders orders);

    /**
     * 通过订单编号修改订单信息
     * @param oid
     * @return
     */
    boolean updatePay(String oid);

    /**
     * 通过订单编号查询出订单信息
     * @return
     */
    Orders findOrderById(String oid);

    /**
     * 通过用户编号查找该用户所有的订单信息
     * @param uid
     * @return
     */
    List<Orders> findOrdersByUid(String uid);
}
