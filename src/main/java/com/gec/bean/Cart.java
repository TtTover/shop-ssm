package com.gec.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车的实体类
 *
 * 一个购物车里面包含多个商品 购物车和商品明细之间的关联关系是一对多
 */
public class Cart {

    /**
     * 购物车的明细 一个购物车有很多个商品 多出来的商品就放到 map 容器中
     * 这里为了方便判断购物车中是存在同一个商品所以我们使用的是map 健值对数据来进行
     * 存放购物车中的商品明细 离品编号 + 购物车的明细
     */
    private Map<String,CartItem> cartItems = new HashMap<>();


    /**
     * 购物车里面的总价
     */
    private double total;

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItem) {
        this.cartItems = cartItem;
    }

    /**
     * 通过每个商品计算总价格
     *
     * @return
     */
    public double getTotal() {
        total = 0;
        Collection<CartItem> values = cartItems.values();
        for (CartItem item : values) {
            total +=item.getSubTotal();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItem=" + cartItems +
                ", total=" + total +
                '}';
    }
}
