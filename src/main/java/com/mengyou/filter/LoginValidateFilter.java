package com.mengyou.filter;

import com.alibaba.fastjson.JSON;
import com.mengyou.model.ResponseModel;
import com.mengyou.model.parametercode.HTTPCODE;
import com.mengyou.model.parametercode.ParameterActionCode;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by zhangfan on 2015/3/12.
 */
public class LoginValidateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (!(servletRequest instanceof HttpServletRequest)) {
            return;
        }
        if (!(servletResponse instanceof HttpServletResponse)) {
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if (!isRequestLegal(httpServletRequest)) {

            ResponseModel responseModel = new ResponseModel();
            responseModel.setHttpCode(HTTPCODE.HTTPSUCCESS.getCode());
            responseModel.setCode(ParameterActionCode.REQUESTLEGAL.getCode());

            OutputStream outputStream = httpServletResponse.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            try {
                outputStreamWriter.write(JSON.toJSONString(responseModel));
                outputStreamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            }
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }

    /*public boolean isRequestLegal(HttpServletRequest httpServletRequest) {

        if (!httpServletRequest.isRequestedSessionIdValid()) {
            return false;
        }

        HttpSession httpSession = httpServletRequest.getSession();
        String username = (String) httpSession.getAttribute("username");

        if (username == null || username.length() < 1) {
            return false;
        }

        return true;

    }*/
    public boolean isRequestLegal(HttpServletRequest httpServletRequest) {
        String s = (String) httpServletRequest.getSession().getAttribute("username");
        System.out.println(s+"----------------------------------------------");

        if (s == null || s.length() < 1) {
            return false;
        }
        return true;

    }


}
