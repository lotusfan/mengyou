package com.mengyou.zhumengyou.model.test;

import java.util.Comparator;

/**
 * Created by zhangfan on 2015/3/10.
 */
public class TestModelSon1 implements Comparable<TestModelSon1>{

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

    @Override
    public int compareTo(TestModelSon1 o) {
        return o.getAge() - this.getAge();
    }
}
