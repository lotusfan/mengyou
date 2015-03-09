package com.mengyou.zhumengyou.model.db;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/6.
 * <p/>
 * 支付项表
 */
public class SupportOption {

    private Long id;
    private Long productId; //支持项Id
    private String supportName; //众筹项目Id
    private String supportDescription; //支持项名称
    private BigDecimal supportMoney; //支持项描述
    private Integer sequencing; //支持金额
    private String supportIconPath; //支持项图片
    private Timestamp createTime;
    private Timestamp updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSupportName() {
        return supportName;
    }

    public void setSupportName(String supportName) {
        this.supportName = supportName;
    }

    public String getSupportDescription() {
        return supportDescription;
    }

    public void setSupportDescription(String supportDescription) {
        this.supportDescription = supportDescription;
    }

    public BigDecimal getSupportMoney() {
        return supportMoney;
    }

    public void setSupportMoney(BigDecimal supportMoney) {
        this.supportMoney = supportMoney;
    }

    public Integer getSequencing() {
        return sequencing;
    }

    public void setSequencing(Integer sequencing) {
        this.sequencing = sequencing;
    }

    public String getSupportIconPath() {
        return supportIconPath;
    }

    public void setSupportIconPath(String supportIconPath) {
        this.supportIconPath = supportIconPath;
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
        return "SupportOption{" +
                "id=" + id +
                ", productId=" + productId +
                ", supportName='" + supportName + '\'' +
                ", supportDescription='" + supportDescription + '\'' +
                ", supportMoney=" + supportMoney +
                ", sequencing=" + sequencing +
                ", supportIconPath='" + supportIconPath + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
