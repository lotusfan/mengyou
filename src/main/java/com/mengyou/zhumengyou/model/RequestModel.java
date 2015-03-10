package com.mengyou.zhumengyou.model;

/**
 * Created by zhangfan on 2015/3/10.
 * <p/>
 * 结构化 请求体
 */
public class RequestModel {

    private String version;

    private Object o;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "version='" + version + '\'' +
                ", o=" + o +
                '}';
    }
}