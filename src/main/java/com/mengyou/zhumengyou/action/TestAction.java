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

/**
 * Created by zhangfan on 2015/3/2.
 */
@Controller
public class TestAction {

    @Autowired
    public TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String testMethod(@RequestBody TestModel testModel1) {
        System.out.println("test action success!!");
        testService.testMethod();
        TestModel testModel = new TestModel();
        testModel.setTest1("dddd");
        testModel.setTest2("aaaa");
        System.out.println(testModel1);
        return JSON.toJSONString(testModel);
    }
}
