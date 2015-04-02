package com.mengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.model.IndividualPageModel;
import com.mengyou.model.RequestModel;
import com.mengyou.model.db.Pic;
import com.mengyou.model.db.VersionController;
import com.mengyou.model.parametercode.HTTPCODE;
import com.mengyou.model.parametercode.ParameterActionCode;
import com.mengyou.service.SoftwareControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

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


    /**
     * 版本检测
     *
     * @param requestModel
     * @return
     */
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

    /**
     * 上传用户头像
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/uploadpic", method = RequestMethod.POST)
    @ResponseBody
    public String uploadPic(HttpServletRequest httpServletRequest) {
        Pic pic = new Pic();
//        pic.setTypeId(Long.parseLong((String)httpServletRequest.getSession().getAttribute("userId")));

        pic.setTypeId(2L);
        String code;

        try {
//            code = softwareControllerService.uploadHeadPic(multipartFile.getInputStream(), pic);
            code = softwareControllerService.uploadHeadPic(httpServletRequest.getInputStream(), pic);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));
        }
        return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), code, null, null));
    }

    /**
     * 用户头像替换曾使用过的
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "/alertheadpic", method = RequestMethod.POST)
    @ResponseBody
    public String alertHeadPic(@RequestBody RequestModel requestModel) {
        try {
            Pic pic = (Pic) transformJSONObjectToModel(requestModel, Pic.class); //将requestModel里的o强转为user对象

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), softwareControllerService.alertHeadPic(pic), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 个人中心初始接口
     *
     * @param requestModel
     * @return
     */

    @RequestMapping(value = "/individualpage", method = RequestMethod.POST)
    @ResponseBody
    public String getIndividualPage(@RequestBody RequestModel requestModel) {

        try {
            IndividualPageModel individualPageModel = (IndividualPageModel) transformJSONObjectToModel(requestModel, IndividualPageModel.class); //将requestModel里的o强转为user对象

            individualPageModel = softwareControllerService.getIndividualPage(individualPageModel);
            if (individualPageModel == null) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTERROR.getCode(), null, null));//返回结构化信息体
            }
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTSUCCESS.getCode(), null, individualPageModel));//返回结构化信息体
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }

    }
}
