package com.mengyou.zhumengyou.main;

import com.alibaba.fastjson.JSON;
import com.mengyou.zhumengyou.model.RequestModel;
import com.mengyou.zhumengyou.model.test.TestModel;

/**
 * Created by zhangfan on 2015/3/9.
 */
public class VaildateEmpty {
    public static void main(String[] args) {
        RequestModel requestModel = new RequestModel();
        TestModel testModel = new TestModel();
        testModel.setName("zhangfan");

        requestModel.setO(testModel);
        requestModel.setVersion("10.001");

        System.out.println(JSON.toJSONString(requestModel));


    }
}
