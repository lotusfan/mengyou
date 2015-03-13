package com.mengyou.model.test;

/**
 * Created by zhangfan on 2015/3/10.
 */
public class TestModelSon extends TestModelParent {


    private String birthday;
    private String remark;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TestModelSon{" +
                "birthday='" + birthday + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
