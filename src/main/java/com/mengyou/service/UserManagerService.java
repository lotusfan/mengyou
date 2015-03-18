package com.mengyou.service;

import com.mengyou.dao.UserMapper;
import com.mengyou.model.db.User;
import com.mengyou.model.parametercode.ParameterActionCode;
import com.mengyou.util.ParseProperties;
import com.mengyou.util.Random6Digit;
import com.mengyou.util.SmsUtil;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhangfan on 2015/3/9.
 */

@Service
public class UserManagerService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param userModel
     * @return
     */
    public String userLogin(User userModel) {

        try {
            User selectUser = new User();
            selectUser.setVc2loginaccount(userModel.getVc2loginaccount());
//            selectUser.setVc2loginpassword(MD5Encrypt.EncryptMD5(userModel.getVc2loginpassword()));
            selectUser.setVc2loginpassword(userModel.getVc2loginpassword());
            List<User> list = userMapper.getBy(selectUser);

            if (list == null || list.size() < 1) {
                return ParameterActionCode.SELECTUSERERROR.getCode(); //数据库无此数据  返回查询错误码
            }
            return ParameterActionCode.SELECTUSERSUCCESS.getCode();

        } catch (Exception e) {
            System.out.println(e.toString());
            return ParameterActionCode.SERVERERROR.getCode();
        }
    }

    /**
     * 用户信息修改
     * @param userModel
     * @return
     */
    public String userAlert(User userModel) {
        try {
            userMapper.update(userModel);
            return ParameterActionCode.SELECTUSERSUCCESS.getCode();

        } catch (Exception e) {
            System.out.println(e.toString());
            return ParameterActionCode.SERVERERROR.getCode();
        }
    }


    /**
     * 用户注册发送验证码
     * @param user
     * @return
     */
    public String smsRegiste(User user, HttpSession httpSession) {
        try {
            String authenticode = "" + Random6Digit.generatePin();
            String loginContent = ParseProperties.get("mslogin").replaceAll("XXXXXX", authenticode);
            if (!SmsUtil.sendMessage(user.getVc2loginaccount(), loginContent)) {
                return ParameterActionCode.AUTHENTICODEERROR.getCode();
            }

            //将验证信息放入Session
            httpSession.setAttribute("authenticode", authenticode);
            httpSession.setAttribute("vc2loginaccount", user.getVc2loginaccount());
            httpSession.setMaxInactiveInterval(2*60);
            return ParameterActionCode.AUTHENTICODESUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.AUTHENTICODEERROR.getCode();
        }
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public String userRegiste(User user) {
        try {
            userMapper.save(user);
            return ParameterActionCode.INSERTSUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.INSERTERROR.getCode();
        }
    }
}
