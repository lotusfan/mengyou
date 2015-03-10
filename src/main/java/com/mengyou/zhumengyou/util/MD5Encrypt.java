package com.mengyou.zhumengyou.util;

import java.security.MessageDigest;

/**
 * Created by zhangfan on 2015/3/9.
 */
public class MD5Encrypt {

    /**
     * MD5加密
     */
    public static String EncryptMD5(String str) {
        String pwd = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            pwd = toSixteen(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toSixteen(pwd.getBytes());
    }
    /**
     * 把密文转换成16进制的字符串形式
     */
    public static String toSixteen(byte[] bytes) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int j = bytes.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = bytes[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }
}
