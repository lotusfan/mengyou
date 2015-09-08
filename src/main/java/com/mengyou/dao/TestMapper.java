package com.mengyou.dao;

import com.mengyou.model.db.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/3.
 */
public interface TestMapper {

    public List<Test> getBy(Test test);

    public Integer selectCount();

/*
    public List<Test> pagingBy(Test test, @Param(value = "pageNum") Integer integer);
*/
}
