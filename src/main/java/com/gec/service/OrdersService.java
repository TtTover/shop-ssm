package com.gec.service;

import com.gec.bean.Orders;

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
     * 通过订单编号查询订单信息
     * @param oid
     * @return
     */
    Orders findOrderById(String oid);
}
