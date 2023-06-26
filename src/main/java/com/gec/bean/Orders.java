package com.gec.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName orders
 */
public class Orders implements Serializable {
    /**
     * 
     */
    private String oid;

    /**
     * 
     */
    private Date ordertime;

    /**
     * 
     */
    private Double total;

    /**
     * 
     */
    private Integer state;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String telephone;

    /**
     * 
     */
    private String uid;

    //一个订单有多个订单明细 使用集合list容器来存放多个订单明细数据
    private List<Orderitem> orderitems = new ArrayList<>();

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    /**
     * 
     */
    private String assess;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getOid() {
        return oid;
    }

    /**
     * 
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * 
     */
    public Date getOrdertime() {
        return ordertime;
    }

    /**
     * 
     */
    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    /**
     *
     */
    public Double getTotal() {
        //遍历集合orderitems订单中的价格数据累加起来
        double money = 0;
        for (Orderitem orderitem: orderitems) {
            money = money + orderitem.getSubtotal();
        }
        total = money;
        return total;
    }

    /**
     * 
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 
     */
    public String getUid() {
        return uid;
    }

    /**
     * 
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 
     */
    public String getAssess() {
        return assess;
    }

    /**
     * 
     */
    public void setAssess(String assess) {
        this.assess = assess;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Orders other = (Orders) that;
        return (this.getOid() == null ? other.getOid() == null : this.getOid().equals(other.getOid()))
            && (this.getOrdertime() == null ? other.getOrdertime() == null : this.getOrdertime().equals(other.getOrdertime()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getAssess() == null ? other.getAssess() == null : this.getAssess().equals(other.getAssess()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOid() == null) ? 0 : getOid().hashCode());
        result = prime * result + ((getOrdertime() == null) ? 0 : getOrdertime().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getAssess() == null) ? 0 : getAssess().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", ordertime=").append(ordertime);
        sb.append(", total=").append(total);
        sb.append(", state=").append(state);
        sb.append(", address=").append(address);
        sb.append(", name=").append(name);
        sb.append(", telephone=").append(telephone);
        sb.append(", uid=").append(uid);
        sb.append(", assess=").append(assess);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}