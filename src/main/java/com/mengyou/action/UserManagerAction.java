package com.mengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.model.RequestModel;
import com.mengyou.model.db.User;
import com.mengyou.model.parametercode.HTTPCODE;
import com.mengyou.model.parametercode.ParameterActionCode;
import com.mengyou.service.UserManagerService;
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
                httpSession.setAttribute("username", user.getVc2loginaccount());//连接验证项
                httpSession.setMaxInactiveInterval(30 * 60);//有效时长
            }

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), code, null, null));//返回结构化信息体
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
    public String userAlert(@RequestBody RequestModel requestModel) {
        try {
            User user = (User) transformJSONObjectToModel(requestModel, User.class); //将requestModel里的o强转为user对象
            if (user.getId() == null) {//没有用户Id
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.NOID.getCode(), null, null));//返回结构化信息体
            }
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), userManagerService.userAlert(user), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 用户注册发送信息
     *
     * @param requestModel
     * @param httpServletRequest
     * @return
     */

    @RequestMapping(value = "/smsregiste", method = RequestMethod.POST)
    @ResponseBody
    public String smsRegiste(@RequestBody RequestModel requestModel ,HttpServletRequest httpServletRequest) {

        try {
            User user = (User) transformJSONObjectToModel(requestModel, User.class);

            if (user.getVc2loginaccount() == null) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.DATANOTCOMPLETE.getCode(), null, null));//返回Session过期
            }
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), userManagerService.smsRegiste(user, httpServletRequest.getSession()), null, null));//返回Session过期

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 用户注册
     *
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/registe", method = RequestMethod.POST)
    @ResponseBody
    public String userRegiste(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {
            if (!httpServletRequest.isRequestedSessionIdValid()) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SESSIONINVALID.getCode(), null, null));//返回Session过期
            }
            User user = (User) transformJSONObjectToModel(requestModel, User.class);
            if (user.getAuthentiCode() == null || user.getVc2loginaccount() == null) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.DATANOTCOMPLETE.getCode(), null, null));//返回数据上传不完整
            }

            HttpSession httpSession = httpServletRequest.getSession();
            if (!user.getAuthentiCode().equals((String) httpSession.getAttribute("authentiCode")) || !user.getVc2loginaccount().equals((String) httpSession.getAttribute("vc2loginaccount"))) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SESSIONINVALID.getCode(), null, null));//返回Session过期
            }

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), userManagerService.userRegiste(user), null, null));//返回Session过期

        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

}
