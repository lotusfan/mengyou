package com.mengyou.zhumengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.zhumengyou.model.RequestModel;
import com.mengyou.zhumengyou.model.db.User;
import com.mengyou.zhumengyou.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * 登录，注册 接口提供
 */

@Controller
@RequestMapping(value = "/user")
public class UserManagerAction extends ActionParent {


    @Autowired
    private UserManagerService userManagerService;


    /**
     * 用户登录
     *
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {
            User user = (User) transformJSONObjectToModel(requestModel, User.class); //将requestModel里的o强转为user对象
            return JSON.toJSONString(generateResponseModel(200, userManagerService.userLogin(user), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(500, null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 用户信息修改
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String userRegister(@RequestBody RequestModel requestModel) {
        try {
            User user = (User) transformJSONObjectToModel(requestModel, User.class); //将requestModel里的o强转为user对象
            return JSON.toJSONString(generateResponseModel(200, userManagerService.userRegister(user), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(500, null, e.getMessage(), null));//服务异常返回
        }
    }


}
