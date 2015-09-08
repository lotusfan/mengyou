package com.mengyou.zhumengyou.service;


import com.mengyou.action.TestAction;
import com.mengyou.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestServiceTest {


    @Autowired
    private TestService testService;

    @Test
    public void testTestMethod() throws Exception {
        testService.testMethod();
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();

    }
}