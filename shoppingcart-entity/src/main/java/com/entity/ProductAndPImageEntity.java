package com.entity;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * @author SherWin
 * @date 2019/12/11 12:05
 */

public class ProductAndPImageEntity {
    private Integer pid;
    private String pname;
    private String pdesc;
    private BigDecimal unitprice;
    private String pimage;
    private Integer cid;
    private MultipartFile multipartFile;

    public ProductAndPImageEntity() {
    }

    public ProductAndPImageEntity(Integer pid, String pname, String pdesc, BigDecimal unitprice, String pimage, Integer cid, MultipartFile multipartFile) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.unitprice = unitprice;
        this.pimage = pimage;
        this.cid = cid;
        this.multipartFile = multipartFile;
    }


    @Override
    public String toString() {
        return "ProductAndPImageEntity{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", unitprice=" + unitprice +
                ", pimage='" + pimage + '\'' +
                ", cid=" + cid +
                ", multipartFile=" + multipartFile +
                '}';
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

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

}
