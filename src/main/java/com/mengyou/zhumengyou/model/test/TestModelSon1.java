package com.mengyou.zhumengyou.model.test;

/**
 * Created by zhangfan on 2015/3/10.
 */
public class TestModelSon1 extends TestModelParent{

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestModelSon1{" +
                "age=" + age +
                '}';
    }
}
