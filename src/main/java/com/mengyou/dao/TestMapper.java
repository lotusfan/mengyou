package com.mengyou.dao;

import com.mengyou.model.db.Test;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/3.
 */
public interface TestMapper {

    public List<Test> getBy(Test test);
}
