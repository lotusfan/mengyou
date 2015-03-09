package com.mengyou.zhumengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.zhumengyou.model.TestModel;
import com.mengyou.zhumengyou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by zhangfan on 2015/3/2.
 */
@Controller
public class TestAction {

    @Autowired
    public TestService testService;

    @RequestMapping(value = "/testmodel", method = RequestMethod.POST)
    @ResponseBody
    public String testModelMethod(@RequestBody TestModel testModel1) {
        System.out.println("testModel action success!!");
        testService.testMethod();
        TestModel testModel = new TestModel();
        testModel.setTest1("dddd");
        testModel.setTest2("aaaa");
        System.out.println(testModel1);
        return JSON.toJSONString(testModel);
    }

    @RequestMapping(value = "/teststring", method = RequestMethod.GET)
    @ResponseBody
    public String testStringMethod(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession();

        httpSession.setMaxInactiveInterval(10);
        System.out.println("JSESSIONID "+httpSession.getId());
        System.out.println(httpSession.getCreationTime());
        System.out.println(httpSession.getLastAccessedTime());
        System.out.println(httpRequest.isRequestedSessionIdValid());

        System.out.println("test action success!!");
        testService.testMethod();
        return "testString action success";
    }
    @RequestMapping(value = "/teststring1", method = RequestMethod.GET)
    @ResponseBody
    public String testStringMethod1(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession();

        httpSession.setMaxInactiveInterval(10);
        System.out.println("JSESSIONID "+httpSession.getId());
        System.out.println(httpSession.getCreationTime());
        System.out.println(httpSession.getLastAccessedTime());

        System.out.println("test action success!!");
        testService.testMethod();
        return "testString action success1";
    }

}
