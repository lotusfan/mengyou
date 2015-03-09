package com.mengyou.zhumengyou.model.db;

import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * 众筹项目-评论表
 */
public class ProductComment {

    private Long id;
    private Long productId; //项目Id
    private Long userId; //用户Id
    private String vc2nickname; //用户昵称
    private String content; //评论内容
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "ProductComment{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", vc2nickname='" + vc2nickname + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
