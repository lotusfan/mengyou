package com.mengyou.zhumengyou.model.db;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/4.
 *
 * 众筹-订单 表
 */
public class CrowdFoundOrder {
    private Long id;
    private Integer orderType; //订单类别
    private String orderName; //订单名称
    private Long userId; //支付用户Id
    private String vc2nickname; //支付用户昵称
    private String phone; //手机号
    private Long supportId; //支持项Id
    private BigDecimal supportMoney; //支持项金额
    private Timestamp payTime; //支付时间
    private Long productId; //出资项目Id
    private Integer status; //状态
    private Timestamp createTime; //
    private Timestamp updateTime; //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getSupportId() {
        return supportId;
    }

    public void setSupportId(Long supportId) {
        this.supportId = supportId;
    }

    public BigDecimal getSupportMoney() {
        return supportMoney;
    }

    public void setSupportMoney(BigDecimal supportMoney) {
        this.supportMoney = supportMoney;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "CrowdFoundOrder{" +
                "id=" + id +
                ", orderType=" + orderType +
                ", orderName='" + orderName + '\'' +
                ", userId=" + userId +
                ", vc2nickname='" + vc2nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", supportId=" + supportId +
                ", supportMoney=" + supportMoney +
                ", payTime=" + payTime +
                ", productId=" + productId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
