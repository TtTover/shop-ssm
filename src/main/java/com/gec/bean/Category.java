package com.gec.bean;

import java.io.Serializable;

/**
 * 
 * @TableName category
 */
public class Category implements Serializable {
    /**
     * 
     */
    private String cid;

    /**
     * 
     */
    private String cname;

    private static final long serialVersionUID = 1L;

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

    /**
     * 
     */
    public String getCname() {
        return cname;
    }

    /**
     * 
     */
    public void setCname(String cname) {
        this.cname = cname;
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
        Category other = (Category) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", cname=").append(cname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}