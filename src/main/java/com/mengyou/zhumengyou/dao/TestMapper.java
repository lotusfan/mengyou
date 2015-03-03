package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.Test;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/3.
 */
public interface TestMapper {

    public List<Test> getBy(Test test);
}
