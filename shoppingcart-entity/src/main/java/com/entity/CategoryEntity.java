package com.entity;

/**
 * @author SherWin
 * @date 2019/12/2 11:04
 */
public class CategoryEntity {
    private Integer cid;
    private String cname;

    public CategoryEntity() {
    }

    public CategoryEntity(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
