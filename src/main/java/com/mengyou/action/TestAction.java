package com.mengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.model.RequestModel;
import com.mengyou.model.test.TestModel;
import com.mengyou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Enumeration;

/**
 * Created by zhangfan on 2015/3/2.
 */
@Controller
public class TestAction extends ActionParent {

    @Autowired
    public TestService testService;

    @RequestMapping(value = "/testmodel", method = RequestMethod.POST)
    @ResponseBody
    public String testModelMethod(@RequestBody RequestModel requestModel) {
        System.out.println("testModel action success!!");
        testService.testMethod();
        TestModel testModel = new TestModel();
        testModel.setTest1("dddd");
        testModel.setTest2("aaaa");
        System.out.println(transformJSONObjectToModel(requestModel, TestModel.class));

        return JSON.toJSONString(requestModel);
    }

    @RequestMapping(value = "/teststring", method = RequestMethod.GET)
    @ResponseBody
    public String testStringMethod(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession();

        Enumeration en = httpSession.getAttributeNames();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
        httpSession.setAttribute("time", "" + System.currentTimeMillis());
        httpSession.setMaxInactiveInterval(10);
        System.out.println("JSESSIONID " + httpSession.getId());
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
        System.out.println("JSESSIONID " + httpSession.getId());
        System.out.println(httpSession.getCreationTime());
        System.out.println(httpSession.getLastAccessedTime());

        System.out.println("test action success!!");
        testService.testMethod();
        return "testString action success1";
    }


    @RequestMapping(value = "/search.do", method = RequestMethod.GET)
    @ResponseBody
    public String testFilter(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession();
        httpSession.setAttribute("username", "zhangff");


        httpSession.setMaxInactiveInterval(10);
        System.out.println("JSESSIONID " + httpSession.getId());
        System.out.println(httpSession.getCreationTime());
        System.out.println(httpSession.getLastAccessedTime());

        System.out.println("test filter success!!");
        return "testString filter success1";
    }

    @RequestMapping(value = "/testfile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadPic(@RequestParam MultipartFile pic) {

        System.out.println(pic.getSize() + pic.getName());

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("D:/aa.jpg"));
            InputStream inputStream = pic.getInputStream();

            byte[] bytes = new byte[1024];
            int len = 0;

            while ((len = inputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, len);
            }
            fileOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null ) try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "success";
    }

}
