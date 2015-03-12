package com.mengyou.zhumengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.zhumengyou.model.RequestModel;
import com.mengyou.zhumengyou.model.db.User;
import com.mengyou.zhumengyou.model.parametercode.HTTPCODE;
import com.mengyou.zhumengyou.model.parametercode.ParameterActionCode;
import com.mengyou.zhumengyou.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String userLogin(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {
            User user = (User) transformJSONObjectToModel(requestModel, User.class); //将requestModel里的o强转为user对象
            String code = userManagerService.userLogin(user);
            if (ParameterActionCode.SELECTUSERSUCCESS.getCode().equals(code)) {
                HttpSession httpSession = httpServletRequest.getSession();
                httpSession.setAttribute("username",user.getVc2loginaccount());//连接验证项
                httpSession.setMaxInactiveInterval(30*60);//有效时长
            }

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), userManagerService.userLogin(user), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 用户信息修改
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "/alert", method = RequestMethod.POST)
    @ResponseBody
    public String userAlert(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            /* 判定请求是否合法 */
            if (!isRequestLegal(httpServletRequest)) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), ParameterActionCode.REQUESTLEGAL.getCode(), null, null));
            }

            User user = (User) transformJSONObjectToModel(requestModel, User.class); //将requestModel里的o强转为user对象
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), userManagerService.userAlert(user), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }


}
