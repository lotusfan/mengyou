package com.mengyou.zhumengyou.service;

import com.mengyou.zhumengyou.dao.UserMapper;
import com.mengyou.zhumengyou.model.db.User;
import com.mengyou.zhumengyou.model.parametercode.ParameterActionCode;
import com.mengyou.zhumengyou.util.MD5Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            if (userModel.getId() == null) { //没有用户Id  返回错误
                return ParameterActionCode.NOID.getCode();
            }
            userMapper.update(userModel);
            return ParameterActionCode.SELECTUSERSUCCESS.getCode();

        } catch (Exception e) {
            System.out.println(e.toString());
            return ParameterActionCode.SERVERERROR.getCode();
        }
    }
}
