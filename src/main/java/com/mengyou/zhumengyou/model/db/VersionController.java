package com.mengyou.zhumengyou.model.db;

import java.sql.Timestamp;
import java.util.Comparator;

/**
 * Created by zhangfan on 2015/3/10.
 * <p/>
 * 版本控制表
 */
public class VersionController implements Comparable<VersionController> {

    private Long id;
    private Integer mtType;
    private String versionCodeOld;
    private String versionCodeNew;
    private String upContent;
    private Timestamp upTime;
    private String path;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMtType() {
        return mtType;
    }

    public void setMtType(Integer mtType) {
        this.mtType = mtType;
    }

    public String getVersionCodeOld() {
        return versionCodeOld;
    }

    public void setVersionCodeOld(String versionCodeOld) {
        this.versionCodeOld = versionCodeOld;
    }

    public String getVersionCodeNew() {
        return versionCodeNew;
    }

    public void setVersionCodeNew(String versionCodeNew) {
        this.versionCodeNew = versionCodeNew;
    }

    public String getUpContent() {
        return upContent;
    }

    public void setUpContent(String upContent) {
        this.upContent = upContent;
    }

    public Timestamp getUpTime() {
        return upTime;
    }

    public void setUpTime(Timestamp upTime) {
        this.upTime = upTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        return "VersionController{" +
                "id=" + id +
                ", mtType=" + mtType +
                ", versionCodeOld='" + versionCodeOld + '\'' +
                ", versionCodeNew='" + versionCodeNew + '\'' +
                ", upContent='" + upContent + '\'' +
                ", upTime=" + upTime +
                ", path='" + path + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
    @Override
    public int compareTo(VersionController o) {
        if (o.getMtType()==this.getMtType() && o.getVersionCodeNew().equals(this.getVersionCodeNew()))
            return 0;
        return -1;
    }
}
