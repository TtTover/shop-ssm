package com.gec.service;

import com.gec.bean.Orders;

public interface OrderService {
    /**
     * 添加订单的方法
     * @param orders
     * @return
     */
    boolean addOrders(Orders orders);
}
