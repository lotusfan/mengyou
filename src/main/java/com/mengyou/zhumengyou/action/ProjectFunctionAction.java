package com.mengyou.zhumengyou.action;

import com.alibaba.fastjson.JSON;
import com.mengyou.action.ActionParent;
import com.mengyou.model.RequestModel;
import com.mengyou.model.db.Suggestion;
import com.mengyou.zhumengyou.model.db.*;
import com.mengyou.model.parametercode.HTTPCODE;
import com.mengyou.model.parametercode.ParameterActionCode;
import com.mengyou.zhumengyou.service.ProjectFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangfan on 2015/3/11.
 * <p/>
 * 项目   功能 模块
 */
@Controller
@RequestMapping(value = "/function")
public class ProjectFunctionAction extends ActionParent {


    @Autowired
    private ProjectFunctionService projectFunctionService;


    /**
     * 获取项目评论
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/selcomment", method = RequestMethod.POST)
    @ResponseBody
    public String commentSelectByProductId(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            ProductComment productComment = (ProductComment) transformJSONObjectToModel(requestModel, ProductComment.class); //将requestModel里的o强转为user对象

            List<ProductComment> list = projectFunctionService.getCommentByProductId(productComment);

            if (list == null || list.size() == 0) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTERROR.getCode(), null, null));//返回结构化信息体
            }
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTSUCCESS.getCode(), null, list));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 添加项目评论
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/addcomment", method = RequestMethod.POST)
    @ResponseBody
    public String commentAdd(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            /* 判定请求是否合法 */
            /*if (!isRequestLegal(httpServletRequest)) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), ParameterActionCode.REQUESTLEGAL.getCode(), null, null));
            }
*/
            ProductComment productComment = (ProductComment) transformJSONObjectToModel(requestModel, ProductComment.class); //将requestModel里的o强转为user对象

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), projectFunctionService.saveComment(productComment), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }



    /**
     * 获取项目更新日志
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/seldiary", method = RequestMethod.POST)
    @ResponseBody
    public String diarySelectByProductId(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            ProductDiary productDiary = (ProductDiary) transformJSONObjectToModel(requestModel, ProductDiary.class); //将requestModel里的o强转为user对象

            List<ProductDiary> list = projectFunctionService.getDiaryByProductId(productDiary);

            if (list == null || list.size() == 0) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTERROR.getCode(), null, null));//返回结构化信息体
            }
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTSUCCESS.getCode(), null, list));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 添加项目更新日志
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/adddiary", method = RequestMethod.POST)
    @ResponseBody
    public String diaryAdd(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            ProductDiary productDiary = (ProductDiary) transformJSONObjectToModel(requestModel, ProductDiary.class); //将requestModel里的o强转为user对象

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), projectFunctionService.saveDiary(productDiary), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 修改项目更新日志
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/alertdiary", method = RequestMethod.POST)
    @ResponseBody
    public String diaryAlert(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            ProductDiary productDiary = (ProductDiary) transformJSONObjectToModel(requestModel, ProductDiary.class); //将requestModel里的o强转为user对象

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), projectFunctionService.updateDiary(productDiary), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }



    /**
     * 获取项目支持项
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/selsupport", method = RequestMethod.POST)
    @ResponseBody
    public String supportSelectByProductId(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            SupportOption supportOption = (SupportOption) transformJSONObjectToModel(requestModel, SupportOption.class); //将requestModel里的o强转为user对象

            List<SupportOption> list = projectFunctionService.getSupportByProductId(supportOption);

            if (list == null || list.size() == 0) {
                return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTERROR.getCode(), null, null));//返回结构化信息体
            }
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), ParameterActionCode.SELECTSUCCESS.getCode(), null, list));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 添加项目支持项
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/addsupport", method = RequestMethod.POST)
    @ResponseBody
    public String supportAdd(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            SupportOption supportOption = (SupportOption) transformJSONObjectToModel(requestModel, SupportOption.class); //将requestModel里的o强转为user对象

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), projectFunctionService.saveSupport(supportOption), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }

    /**
     * 修改项目支持项
     * @param requestModel
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/alertsupport", method = RequestMethod.POST)
    @ResponseBody
    public String supportAlert(@RequestBody RequestModel requestModel, HttpServletRequest httpServletRequest) {
        try {

            SupportOption supportOption = (SupportOption) transformJSONObjectToModel(requestModel, SupportOption.class); //将requestModel里的o强转为user对象

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), projectFunctionService.updateSupport(supportOption), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }


    /**
     * 添加意见反馈
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "/addsuggestion", method = RequestMethod.POST)
    @ResponseBody
    public String suggestionAdd(@RequestBody RequestModel requestModel) {
        try {

            Suggestion suggestion = (Suggestion) transformJSONObjectToModel(requestModel, Suggestion.class); //将requestModel里的o强转为user对象

            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), projectFunctionService.saveSuggestion(suggestion), null, null));//返回结构化信息体
        } catch (Exception e) {
            return JSON.toJSONString(generateResponseModel(HTTPCODE.HTTPERROR.getCode(), null, e.getMessage(), null));//服务异常返回
        }
    }



}
