package com.gec.bean;

/**
 * 购物车中的商品的明细
 * 一个购物车中有很多个商品
 * 每个商品我们用cartItem来存放
 */
public class CartItem {

    /**
     * 购物车里面的每个商品
     */
    private Product product;

    /**
     * 购物车中每个商品的购买数量
     */
    private int buyNum;

    /**
     * 购物车中每个商品的点价 每个商品的价格*购买数
     */
    private double subTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public double getSubTotal() {
        return product.getShopPrice()*buyNum;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "product=" + product +
                ", buyNum=" + buyNum +
                ", subTotal=" + subTotal +
                '}';
    }
}
