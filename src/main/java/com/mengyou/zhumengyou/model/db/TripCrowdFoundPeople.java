package com.mengyou.zhumengyou.model.db;


import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/4.
 * <p/>
 * 众筹-人 表
 */
public class TripCrowdFoundPeople {
    private Long id;
    private Long userId; //报名人Id
    private String vc2nickname; //报名人昵称
    private Integer num; //报名人数
    private Integer status; //状态
    private Long productId; //参与众筹项目Id
    private Timestamp createTime; //
    private Timestamp updateTime; //

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

    public String getVc2nickname() {
        return vc2nickname;
    }

    public void setVc2nickname(String vc2nickname) {
        this.vc2nickname = vc2nickname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
        return "TripCrowdFoundPeople{" +
                "id=" + id +
                ", userId=" + userId +
                ", vc2nickname='" + vc2nickname + '\'' +
                ", num=" + num +
                ", productId=" + productId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
