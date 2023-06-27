package com.gec.service.impl;

import com.gec.bean.Orderitem;
import com.gec.bean.Orders;
import com.gec.bean.Product;
import com.gec.mapper.OrderitemMapper;
import com.gec.mapper.OrdersMapper;
import com.gec.mapper.ProductMapper;
import com.gec.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    OrderitemMapper orderitemMapper;

    @Autowired
    ProductMapper productMapper;

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

    @Override
    public boolean updatePay(String oid) {
        //通过订单编号查询订单信息
        Orders orders = ordersMapper.selectByPrimaryKey(oid);
        //将订单状态修改为支付状态
        orders.setState(1);
        return true;
    }

    @Override
    public Orders findOrderById(String oid) {
        //根据订单编号查询订单信息
        Orders orders = ordersMapper.selectByPrimaryKey(oid);
        //根据订单编号 把订单明细也查询出来
        //一个订单有多个订单明细 都要查询出来
        List<Orderitem> orderitems = orderitemMapper.findAllOrderByOidOrderitems(oid);
        for (Orderitem orderitem : orderitems){
            //根据订单明细中的商品编号查询出对应商品的信息
            String pid = orderitem.getPid();
            Product product = productMapper.selectByPrimaryKey(pid);
            //将查询出来的商品详情设置到订单明细中
            orderitem.setProduct(product);
        }
        //修改一下订单中的订单明细数据
        orders.setOrderitems(orderitems);
        return orders;
    }
}
