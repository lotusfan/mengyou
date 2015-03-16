package com.mengyou.model.parametercode;

/**
 * Created by zhangfan on 2015/3/16.
 * <p/>
 * Pic Type 种类 1用户头像 2用户使用过的头像  3 助梦游图片 4 更新日志图片
 */
public enum PicType {

    HEADURL(0, "http://127.0.0.1:8080/head/"),
    HEADPIC(1,"U"),
    HEADPICFLAGNEW(11,"U"),
    HEADPICFLAGOLD(12, "U"),

    PRODUCTURL(0, "http://127.0.0.1:8080/project/"),
    PRODUCTPIC(3,"P"),
    PRODUCTDIARYPIC(4,"D");


    PicType(Integer code, String namePrefix) {
        this.code = code;
        this.namePrefix = namePrefix;
    }

    private Integer code;
    private String namePrefix;

    public Integer getCode() {
        return code;
    }

    public String getnamePrefix() {
        return namePrefix;
    }
}
