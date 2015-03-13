package com.mengyou.model.parametercode;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * Action层返回前台参数编码
 */
public enum ParameterActionCode {
    /*Action层*/
    REQUESTSUCCESS("0200"),
    REQUESTFAIL("0500"),

    NOAUTHORITY("0003"),
    TIMEOUT("0004"),
    SERVERERROR("0005"),
    REQUESTLEGAL("0006"),
    VERSIONINCOMPLETE("0007"), //版本信息不全
    VERSIONNEEDUPDATE("0008"),//版本需要更新
    VERSIONNOTNEEDUPDATE("0009"),//怎么不需要更新


    /*服务器层*/
    SELECTUSERERROR("0051"), //用户名和密码不匹配
    SELECTUSERSUCCESS("0052"), //用户登录成功
    NOID("0053"), //没有用户ID
    UPDATEERROR("0054"),//更新错误
    UPDATESUCCESS("0055"),//更新成功
    SELECTERROR("0056"),//查询错误
    SELECTSUCCESS("0057"),//查询成功
    INSERTERROR("0059"),//数据添加正确
    INSERTSUCCESS("0058"),//数据添加错误

    ;


    private String code;

    ParameterActionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
