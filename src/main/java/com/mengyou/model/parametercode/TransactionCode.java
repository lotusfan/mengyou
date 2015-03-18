package com.mengyou.model.parametercode;

/**
 * Created by zhangfan on 2015/3/17.
 */
public enum TransactionCode {

    //交易类别
    MENGYOUQUAN(1),
    SUPPORTOPTION(2),

    //交易状态
    NOPAYSTATUS(1),
    PAYSTATUS(2),
    REFUNDSTATUS(3),
    REFUNDSUCCESSSTATUS(4),

    ;


    private Integer code;


    TransactionCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
