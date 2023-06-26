package com.gec.controller;

import com.gec.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class OrderController {

    @Autowired
    HttpSession session;

    /**
     * 订单预览功能 只需要将购物车中的数据去出来放到订单页面预览
     * 不需要将数据存放到数据库
     *
     * 只需要从session中取出购物车数据和用户的收货信息即可
     * @return
     */
    @RequestMapping("/showOrder")
    public String showOrder(Model model){
        //展示订单要用到用户的收货信息 所以要在登陆的情况下才能访问这个方法
        User user = (User) session.getAttribute("user");
        if (user == null){
            //如果用户信息为空 说明用户没有登陆 重定向到登陆页面让用户登陆
            return "redirect:login.jsp";
        }

        //取出session中的购物车数据
        Cart cart = (Cart) session.getAttribute("cart");

        //创建订单对象 记录订单信息
        Orders orders = new Orders();
        //使用uuid工具生成主键编号
        orders.setOid(UUID.randomUUID().toString());
        orders.setOrdertime(new Date());
        //订单的状态设置
        orders.setState(0);
        //订单的收货信息
        orders.setOid(user.getUid());
        orders.setTelephone(user.getTelephone());
        orders.setName(user.getName());
        orders.setAddress(user.getAddress());
        //获取订单中订单明细的数据
        List<Orderitem> orderitems = orders.getOrderitems();

        //去取出购物车中的商品信息 让它们记录到订单中来
        //遍历购物车中的商品数据
        Map<String, CartItem> cartItems = cart.getCartItems();
        //购物车中的商品数据 在map中我们可以以set集合的数据将它取出来
        Set<Map.Entry<String, CartItem>> entrySet = cartItems.entrySet();
        //将hashMap的数据 变成set集合的数据进行遍历
        for (Map.Entry<String,CartItem> entry : entrySet){
            //逐个取出里面的value值的内容 value的值就是购物车的明细
            CartItem cartItem = entry.getValue();
            //将购物车的明细中的数据 拿出来变成orderItem订单明细中的数据
            Orderitem orderitem = new Orderitem();
            //设置一下这个订单明细属于哪个订单
            orderitem.setPid(orders.getOid());
            orderitem.setItemid(UUID.randomUUID().toString());
            //将购物车中的商品明细取出来放到订单明细里面去
            orderitem.setSubtotal(cartItem.getSubTotal());
            orderitem.setCount(cartItem.getBuyNum());
            orderitem.setPid(cartItem.getProduct().getPid());
            orderitem.setProduct((cartItem.getProduct()));
            //将订单明细数据放入到订单对象中
            orderitems.add(orderitem);
            //更新订单明细的数据
            orders.setOrderitems(orderitems);
        }
        //通过model模型对象将数据带到订单order_info.jsp展示订单的页面去
        model.addAttribute("order",orders);
        return "order_info";
    }
}
