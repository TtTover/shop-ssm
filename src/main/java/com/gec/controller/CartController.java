package com.gec.controller;

import com.gec.bean.Cart;
import com.gec.bean.CartItem;
import com.gec.bean.Product;
import com.gec.bean.User;
import com.gec.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 处理购物车请求的控制器
 */
@Controller
public class CartController {

    @Autowired
    HttpSession session;

    @Autowired
    ProductService productService;

    @RequestMapping("/addCart")
    public String addCart(String pid,int buyNum){
        //获取session中的购物车信息
        Cart cart = (Cart) session.getAttribute("cart");
        //如果session中没有购物车就创建一个新的购物车对象
        if(cart==null){
            cart=new Cart();
        }
        //要将商品加入购物车 判断购物车中是否已经存在这个商品了
        //拿购物车明细出来看看里面是否存在重复的商品数据
        Map<String, CartItem> cartItems = cart.getCartItems();
        //遍历购物车中的数据 判断一下是否存在这个商品
        if (cartItems.get(pid)!=null){
            //如果商品的编号能够在购物车明细中获取商品 说明这个商品已经存在购物车里面了 直接修改数据就行
            CartItem cartItem = cartItems.get(pid);
            //获取购物车中原来购买商品的数量
            int oldNum = cartItem.getBuyNum();
            //加上新购买的数量
            cartItem.setBuyNum(oldNum + buyNum);
            //将这个数据修改回去
            cartItems.put(pid,cartItem);
            //将这个购物车商品明细容器加入到购物车对象中
            cart.setCartItems(cartItems);
        }else {
            //拿pid去购物车中找不到商品 说明商品为空 购物车中不存在对应的商品 直接添加就行
            //如果购物车没有对应的商品 直接添加商品就行
            CartItem cartItem = new CartItem();
            cartItem.setBuyNum(buyNum);
            //购物车明细中要记录商品信息 所以要把对应商品的信息查询出来
            Product product = productService.getById(pid);
            //将查询出来的商品信息放到购物车中去
            cartItem.setProduct(product);
            //将这个新增的购物车商品明显加入到购物车商品明细对象容器中
            cartItems.put(pid,cartItem);
            //将这个商品对象明细容器加入到购物车对象中
            cart.setCartItems(cartItems);
        }
        //更新session中购物车的数据
       session.setAttribute("cart",cart);
        //去到购物车详情的页面cart.jsp 展示购物车中的信息
        return "cart";
    }

    @RequestMapping("/updateBuyNum")
    public String updateBuyNum(String pid,int buyNum){
        //获取session中的购物车信息
        Cart cart = (Cart) session.getAttribute("cart");
        //如果session中没有购物车就创建一个新的购物车对象
        if(cart==null){
            cart=new Cart();
        }
        //要将商品加入购物车 判断购物车中是否已经存在这个商品了
        //拿购物车明细出来看看里面是否存在重复的商品数据
        Map<String, CartItem> cartItems = cart.getCartItems();
        CartItem cartItem = cartItems.get(pid);
        cartItem.setBuyNum(buyNum);
        cartItems.put(pid,cartItem);
        //将这个购物车商品明细容器加入到购物车对象中
        cart.setCartItems(cartItems);
        //更新session中购物车的数据
        session.setAttribute("cart",cart);
        //去到购物车详情的页面cart.jsp 展示购物车中的信息
        return "cart";
    }

    @RequestMapping("/deleteCartItem")
    public String deleteCartItem(String pid){
        //获取购物车中的信息
        Cart cart = (Cart) session.getAttribute("cart");

        //获取购物车中的商品明细信息
        Map<String, CartItem> cartItems = cart.getCartItems();

        //通过pid移除购物车中的商品
        cartItems.remove(pid);

        //更新购物车对象中的数据
        cart.setCartItems(cartItems);
        session.setAttribute("cart",cart);

        //如果购物车中没有该商品 让用户去购物
        if (cartItems.isEmpty()){
            //如果购物车明细中没有该商品 移除session中的cart购物车对象 清空购物车对象 才能显示去购物的页面
            session.removeAttribute("cart");
        }

        //重新回到购物车页面cart.jsp
        return "cart";
    }

    @RequestMapping("/cleanCart")
    public String cleanCart(){
        //获取购物车中的信息
        Cart cart = (Cart) session.getAttribute("cart");

        //获取购物车中的商品明细信息
        Map<String, CartItem> cartItems = cart.getCartItems();

        //清空购物车中的商品
        cartItems.clear();

        //更新购物车对象中的数据
        cart.setCartItems(cartItems);
        session.setAttribute("cart",cart);

        //如果购物车中没有该商品 让用户去购物
        if (cartItems.isEmpty()){
            //如果购物车明细中没有该商品 移除session中的cart购物车对象 清空购物车对象 才能显示去购物的页面
            session.removeAttribute("cart");
        }

        //重新回到购物车页面cart.jsp
        return "cart";
    }
}
