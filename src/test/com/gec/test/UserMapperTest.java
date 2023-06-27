package com.gec.test;

import com.gec.bean.Orderitem;
import com.gec.bean.Orders;
import com.gec.bean.User;
import com.gec.mapper.OrdersMapper;
import com.gec.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//如果在SSM框架中需要使用单元测试类 因为要加入spring的环境所以要写前面这两行注解
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    OrdersMapper ordersMapper;

    @Test
    public void findUserByIdTest(){
        User user = userMapper.selectByPrimaryKey("373eb242933b4f5ca3bd43503c34668b");
        System.out.println(user);
    }

    @Test
    public void findOrdersByUidTest(){
        List<Orders> ordersByUid = ordersMapper.findOrdersByUid("1");
        for (Orders orders :ordersByUid) {
            System.out.println(orders);
            //订单中的明细看看有没有查询出来
            List<Orderitem> orderitems = orders.getOrderitems();
            for (Orderitem orderitem : orderitems) {
                System.out.println(orderitem);
                System.out.println(orderitem.getProduct());
            }
        }
    }
}
