package com.mengyou.model.db;

import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/13.
 * <p/>
 * 意见返馈表
 */
public class Suggestion {
    private Long id;
    private Long userId; //用户Id
    private String sugContent;//意见内容
    private Timestamp sugTime;//反馈时间
    private Timestamp createTime;
    private Timestamp updateTime;

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

    public String getSugContent() {
        return sugContent;
    }

    public void setSugContent(String sugContent) {
        this.sugContent = sugContent;
    }

    public Timestamp getSugTime() {
        return sugTime;
    }

    public void setSugTime(Timestamp sugTime) {
        this.sugTime = sugTime;
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
        return "Suggestion{" +
                "id=" + id +
                ", userId=" + userId +
                ", sugContent='" + sugContent + '\'' +
                ", sugTime=" + sugTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
