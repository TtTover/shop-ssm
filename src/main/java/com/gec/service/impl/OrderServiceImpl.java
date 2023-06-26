package com.gec.service.impl;

import com.gec.bean.Orderitem;
import com.gec.bean.Orders;
import com.gec.mapper.OrderitemMapper;
import com.gec.mapper.OrdersMapper;
import com.gec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    OrderitemMapper orderitemMapper;

    @Override
    public boolean addOrders(Orders orders) {
        //订单数据和订单明细的数据要同时写入数据库中
        //先写订单数据 然后写订单明细的数据
        int insert = ordersMapper.insert(orders);
        //如果写入成功就继续添加订单明细的信息
        if (insert>0){
            //添加订单明细信息
            List<Orderitem> orderitems = orders.getOrderitems();
            //它是一组数据 逐个写入到数据库中
            for (Orderitem orderitem:orderitems){
                orderitemMapper.insert(orderitem);
            }
            //添加成功 返回true
            return true;
        }
        return false;
    }
}
