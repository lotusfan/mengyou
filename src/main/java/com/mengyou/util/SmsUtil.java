package com.mengyou.util;

import com.mengyou.model.parametercode.ParameterActionCode;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

/**
 * 及时通讯短信发送
 *
 * @author guoxl
 */
public class SmsUtil {


    /**
     * 发送短信方法
     *
     * @param mobile
     * @return
     * @throws Exception
     */
    public static boolean sendMessage(String mobile,String content) throws Exception {

        String method = "SendSms";
        Service service = new Service();

        Call call = (Call)service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(ParseProperties.get("msurl")));
        call.setUseSOAPAction(true);
        call.setReturnType(XMLType.SOAP_STRING);
        call.setOperationName(new QName("http://www.vcomcn.co/", method));
        call.setSOAPActionURI("http://www.vcomcn.co/SendSms");

        call.addParameter(new QName("http://www.vcomcn.co/", "login_name"),
                XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName("http://www.vcomcn.co/", "password"),
                XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName("http://www.vcomcn.co/", "mobile"),
                XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName("http://www.vcomcn.co/", "message"),
                XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName("http://www.vcomcn.co/", "start_time"),
                XMLType.XSD_STRING, ParameterMode.IN);
        call.addParameter(new QName("http://www.vcomcn.co/", "Search_ID"),
                XMLType.XSD_STRING, ParameterMode.IN);
        String retVal = (String) call.invoke(new Object[]{ParseProperties.get("msusername"), ParseProperties.get("mspassword"),
                mobile, content, null, "-1"});
        if (!"504".equals(retVal)) {
            System.out.println(retVal);
            return false;
        }
        return true;
    }

}
