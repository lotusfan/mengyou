package com.mengyou.zhumengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.zhumengyou.model.RequestModel;
import com.mengyou.zhumengyou.model.db.VersionController;
import com.mengyou.zhumengyou.model.parametercode.HTTPCODE;
import com.mengyou.zhumengyou.model.parametercode.ParameterActionCode;
import com.mengyou.zhumengyou.service.SoftwareControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangfan on 2015/3/10.
 * <p/>
 * 终端信信息  版本 控制
 */
@Controller
@RequestMapping(value = "/software")
public class SoftwareControllerAction extends ActionParent {

    @Autowired
    private SoftwareControllerService softwareControllerService;

    @RequestMapping(value = "/checkversion", method = RequestMethod.POST)
    @ResponseBody
    public String checkVersion(@RequestBody RequestModel requestModel) {
        try {
            VersionController versionController = (VersionController) transformJSONObjectToModel(requestModel, VersionController.class); //将requestModel里的o强转为user对象

            if (versionController.getMtType() == null || versionController.getVersionCodeNew() == null) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.VERSIONINCOMPLETE.getCode(), null, null));//返回结构化信息体
            }

            VersionController versionControllerNew = softwareControllerService.checkVersion(versionController);
            if (versionControllerNew == null) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.VERSIONNOTNEEDUPDATE.getCode(), null, null));//返回结构化信息体
            }
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.VERSIONNEEDUPDATE.getCode(), null, versionControllerNew));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

}
