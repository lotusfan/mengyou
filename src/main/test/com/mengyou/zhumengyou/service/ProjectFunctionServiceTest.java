package com.mengyou.zhumengyou.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class ProjectFunctionServiceTest {


    @Autowired
    private ProjectFunctionService projectFunctionService;

    @Test
    public void testFunctionProductSelect() throws Exception {

        System.out.println(projectFunctionService.functionProductSelect());

    }
}