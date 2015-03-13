package com.mengyou.model.db;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * 交易记录表
 */
public class Transaction {
    private Long id;
    private Long sourceId; //来源ID
    private Integer type; //交易类别
    private String name; //交易名称
    private Integer status; //状态
    private BigDecimal money; //金额
    private Timestamp time; //交易时间
    private Long userId; //用户ID
    private String vc2nickname; //用户昵称
    private Timestamp createTime;
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVc2nickname() {
        return vc2nickname;
    }

    public void setVc2nickname(String vc2nickname) {
        this.vc2nickname = vc2nickname;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", status=" + status +
                ", time=" + time +
                ", userId=" + userId +
                ", vc2nickname='" + vc2nickname + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
