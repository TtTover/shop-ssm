package com.gec.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName product
 */
public class Product implements Serializable {
    /**
     * 
     */
    private String pid;

    /**
     * 
     */
    private String pname;

    /**
     * 
     */
    private Double marketPrice;

    /**
     * 
     */
    private Double shopPrice;

    /**
     * 
     */
    private String pimage;

    /**
     * 
     */
    private Date pdate;

    /**
     * 
     */
    private Integer isHot;

    /**
     * 
     */
    private String pdesc;

    /**
     * 
     */
    private Integer pflag;

    /**
     * 
     */
    private String cid;

    private static final long serialVersionUID = 1L;

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
    public String getPname() {
        return pname;
    }

    /**
     * 
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * 
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 
     */
    public Double getShopPrice() {
        return shopPrice;
    }

    /**
     * 
     */
    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * 
     */
    public String getPimage() {
        return pimage;
    }

    /**
     * 
     */
    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    /**
     * 
     */
    public Date getPdate() {
        return pdate;
    }

    /**
     * 
     */
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    /**
     * 
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * 
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * 
     */
    public String getPdesc() {
        return pdesc;
    }

    /**
     * 
     */
    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    /**
     * 
     */
    public Integer getPflag() {
        return pflag;
    }

    /**
     * 
     */
    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    /**
     * 
     */
    public String getCid() {
        return cid;
    }

    /**
     * 
     */
    public void setCid(String cid) {
        this.cid = cid;
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
        Product other = (Product) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getShopPrice() == null ? other.getShopPrice() == null : this.getShopPrice().equals(other.getShopPrice()))
            && (this.getPimage() == null ? other.getPimage() == null : this.getPimage().equals(other.getPimage()))
            && (this.getPdate() == null ? other.getPdate() == null : this.getPdate().equals(other.getPdate()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getPdesc() == null ? other.getPdesc() == null : this.getPdesc().equals(other.getPdesc()))
            && (this.getPflag() == null ? other.getPflag() == null : this.getPflag().equals(other.getPflag()))
            && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getShopPrice() == null) ? 0 : getShopPrice().hashCode());
        result = prime * result + ((getPimage() == null) ? 0 : getPimage().hashCode());
        result = prime * result + ((getPdate() == null) ? 0 : getPdate().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getPdesc() == null) ? 0 : getPdesc().hashCode());
        result = prime * result + ((getPflag() == null) ? 0 : getPflag().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", pname=").append(pname);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", pimage=").append(pimage);
        sb.append(", pdate=").append(pdate);
        sb.append(", isHot=").append(isHot);
        sb.append(", pdesc=").append(pdesc);
        sb.append(", pflag=").append(pflag);
        sb.append(", cid=").append(cid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}