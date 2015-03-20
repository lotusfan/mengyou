package com.mengyou.zhumengyou.model;

/**
 * Created by zhangfan on 2015/3/19.
 */
public enum CrowdFoundProductCode {
    PRODUCTLINE(1), //产品上线
    PRODUCTOFFLINE(2), //产品下线

    FOUNDING(1), //众筹中
    FOUNDSUCCESS(2), //众筹成功
    FOUNDFAIL(3), //众筹失败
    ;



    private Integer code;

    CrowdFoundProductCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
