package com.mengyou.zhumengyou.model.db;

import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * 众筹项目—更新日志表
 */
public class ProductDiary {

    private Long id;
    private Long productId; //项目Id
    private String content; //内容
    private String contentIconPath; //内容图片
    private Timestamp noteTime; //更新时间
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentIconPath() {
        return contentIconPath;
    }

    public void setContentIconPath(String contentIconPath) {
        this.contentIconPath = contentIconPath;
    }

    public Timestamp getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(Timestamp noteTime) {
        this.noteTime = noteTime;
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
        return "ProductDiary{" +
                "id=" + id +
                ", productId=" + productId +
                ", content='" + content + '\'' +
                ", contentIconPath='" + contentIconPath + '\'' +
                ", noteTime=" + noteTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
