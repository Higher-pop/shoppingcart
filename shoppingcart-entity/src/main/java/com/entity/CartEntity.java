package com.entity;

import java.math.BigDecimal;

/**
 * @author SherWin
 * @date 2019/12/2 10:57
 */
public class CartEntity {
    private Integer id;
    private Integer pid;
    private String pname;
    private BigDecimal unitprice;
    private Integer quantity;
    private String username;

    public CartEntity() {
    }

    public CartEntity(Integer id, Integer pid, String pname, BigDecimal unitprice, Integer quantity, String username) {
        this.id = id;
        this.pid = pid;
        this.pname = pname;
        this.unitprice = unitprice;
        this.quantity = quantity;
        this.username = username;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", unitprice=" + unitprice +
                ", quantity=" + quantity +
                ", username='" + username + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
