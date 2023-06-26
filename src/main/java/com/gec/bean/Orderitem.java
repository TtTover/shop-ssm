package com.gec.bean;

import java.io.Serializable;

/**
 * 
 * @TableName orderitem
 */
public class Orderitem implements Serializable {
    /**
     * 
     */
    private String itemid;

    /**
     * 
     */
    private Integer count;

    /**
     * 每个订单明细的总价
     */
    private Double subtotal;

    /**
     * 
     */
    private String pid;

    /**
     * 
     */
    private String oid;

    //一个订单明细对于一个商品
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * 
     */
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    /**
     * 
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * 
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * 
     */
    public String getPid() {
        return pid;
    }

    /**
     * 
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

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
        Orderitem other = (Orderitem) that;
        return (this.getItemid() == null ? other.getItemid() == null : this.getItemid().equals(other.getItemid()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getSubtotal() == null ? other.getSubtotal() == null : this.getSubtotal().equals(other.getSubtotal()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getOid() == null ? other.getOid() == null : this.getOid().equals(other.getOid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemid() == null) ? 0 : getItemid().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getSubtotal() == null) ? 0 : getSubtotal().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getOid() == null) ? 0 : getOid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemid=").append(itemid);
        sb.append(", count=").append(count);
        sb.append(", subtotal=").append(subtotal);
        sb.append(", pid=").append(pid);
        sb.append(", oid=").append(oid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}