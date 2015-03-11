package com.mengyou.zhumengyou.main;

import com.alibaba.fastjson.JSON;
import com.mengyou.zhumengyou.model.RequestModel;
import com.mengyou.zhumengyou.model.db.*;
import com.mengyou.zhumengyou.model.test.TestModel;
import com.mengyou.zhumengyou.model.test.TestModelSon1;

import java.math.BigDecimal;

/**
 * Created by zhangfan on 2015/3/9.
 */
public class GenerateJSONString {
    public static void main(String[] args) throws Exception{
       /* RequestModel requestModel = new RequestModel();
        TestModel testModel = new TestModel();
        testModel.setName("zhangfan");

        requestModel.setO(testModel);
        requestModel.setVersion("10.001");
        System.out.println(JSON.toJSONString(requestModel));*/

        /*TestModelSon1 testModelSon1 = new TestModelSon1();
        TestModelSon1 testModelSon11 = new TestModelSon1();

        testModelSon1.setAge(4);
        testModelSon11.setAge(5);
        if(testModelSon1.compareTo(testModelSon11) == 0)
        System.out.println(testModelSon1.compareTo(testModelSon11));*/

        RequestModel requestModel = new RequestModel();
        /*VersionController o = new VersionController();

        o.setMtType(1);
        o.setVersionCodeNew("10.10");*/

        /*User o = new User();
        o.setVc2loginpassword("123");
        o.setVc2loginaccount("xiaoming");*/

        requestModel.setVersion("10.10");
//        User o = (User) InitModel.initModel("com.mengyou.zhumengyou.model.db.User", 0L, new BigDecimal("500.00"), "");
//        ProductComment o = (ProductComment) InitModel.initModel("com.mengyou.zhumengyou.model.db.ProductComment", 0L, new BigDecimal("500.00"), "");
//        ProductDiary o = (ProductDiary) InitModel.initModel("com.mengyou.zhumengyou.model.db.ProductDiary", 0L, new BigDecimal("500.00"), "");
        SupportOption o = (SupportOption) InitModel.initModel("com.mengyou.zhumengyou.model.db.SupportOption", 0L, new BigDecimal("500.00"), "");

        requestModel.setO(o);

        System.out.println(JSON.toJSONString(requestModel));

    }
}
