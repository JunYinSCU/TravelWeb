package com.entity;

import com.baomidou.mybatisplus.annotations.TableName;


import java.math.BigDecimal;
import java.time.LocalDateTime;


@TableName("orders")
public class OrderEntity {
    private Long id;
    private String jingdianmingcheng;
    private LocalDateTime goupiaoshijian;
    private BigDecimal zongjine;
    private String status; // "history" or "current"
    private Long userid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJingdianmingcheng() {
        return jingdianmingcheng;
    }

    public void setJingdianmingcheng(String jingdianmingcheng) {
        this.jingdianmingcheng = jingdianmingcheng;
    }

    public LocalDateTime getGoupiaoshijian() {
        return goupiaoshijian;
    }

    public void setGoupiaoshijian(LocalDateTime goupiaoshijian) {
        this.goupiaoshijian = goupiaoshijian;
    }

    public BigDecimal getZongjine() {
        return zongjine;
    }

    public void setZongjine(BigDecimal zongjine) {
        this.zongjine = zongjine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}