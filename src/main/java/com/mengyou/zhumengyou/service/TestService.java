package com.mengyou.zhumengyou.service;

import com.mengyou.zhumengyou.dao.TestMapper;
import com.mengyou.zhumengyou.model.db.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangfan on 2015/3/2.
 */
@Service
public class TestService {


    @Autowired
    private TestMapper testMapper;
    public void testMethod() {
        Test test = new Test();
        test.setId(2);
        System.out.println(testMapper.getBy(test));

        System.out.println("test Service Success!!");
    }
}
