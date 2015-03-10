package com.mengyou.zhumengyou.model.parametercode;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * Action层返回前台参数编码
 */
public enum ParameterActionCode {
    /*Action层*/
    REQUESTSUCCESS("0200"),
    REQUESTFAIL("0500"),
    LOGINSUCCESS("0001"),
    LOGINFAIL("0002"),
    NOAUTHORITY("0003"),
    TIMEOUT("0004"),
    SERVERERROR("0005"),
    REQUESTLEGAL("0006"),

    /*服务器层*/
    SELECTUSERERROR("0007"), //用户名和密码不匹配
    SELECTUSERSUCCESS("0008"), //用户登录成功
    NOID("0009"), //没有用户ID
    UPDATEERROR("0010"),//更新错误
    UPDATESUCCESS("0011"),//更新成功
    ;


    private String code;

    ParameterActionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
