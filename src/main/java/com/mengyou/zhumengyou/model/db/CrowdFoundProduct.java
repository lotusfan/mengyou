package com.mengyou.zhumengyou.model.db;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/4.
 * <p/>
 * 众筹项目表
 */
public class CrowdFoundProduct {
    private Long id;
    private Long userId;   //创建人
    private String vc2nickname; //创建人昵称
    private String tourName;  //旅游名称
    private String lable; //标签
    private Timestamp timeStart; //项目发布时间
    private Timestamp timeEnd; //项目下线时间
    private Integer period; //筹集期间
    private BigDecimal moneyTotal; //筹集总金额
    private BigDecimal moneyReceive; //筹集到的金额
    private Integer numTotal; //筹集人数
    private Integer numReceive; //筹集到的人数
    private Long operatorId; //操作员Id
    private Timestamp operateTime; //操作时间
    private Integer status; //状态
    private String describe; //项目描述
    private String iconPath; //logo图片路径
    private Timestamp createTime; //记录创建时间
    private Timestamp updateTime; //记录修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getVc2nickname() {
        return vc2nickname;
    }

    public void setVc2nickname(String vc2nickname) {
        this.vc2nickname = vc2nickname;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(BigDecimal moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    public BigDecimal getMoneyReceive() {
        return moneyReceive;
    }

    public void setMoneyReceive(BigDecimal moneyReceive) {
        this.moneyReceive = moneyReceive;
    }

    public Integer getNumTotal() {
        return numTotal;
    }

    public void setNumTotal(Integer numTotal) {
        this.numTotal = numTotal;
    }

    public Integer getNumReceive() {
        return numReceive;
    }

    public void setNumReceive(Integer numReceive) {
        this.numReceive = numReceive;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
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
        return "TripCrowdFoundProduct{" +
                "id=" + id +
                ", userId=" + userId +
                ", vc2nickname='" + vc2nickname + '\'' +
                ", tourName='" + tourName + '\'' +
                ", lable='" + lable + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", period=" + period +
                ", moneyTotal=" + moneyTotal +
                ", moneyReceive=" + moneyReceive +
                ", numTotal=" + numTotal +
                ", numReceive=" + numReceive +
                ", operatorId=" + operatorId +
                ", operateTime=" + operateTime +
                ", status=" + status +
                ", describe='" + describe + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
