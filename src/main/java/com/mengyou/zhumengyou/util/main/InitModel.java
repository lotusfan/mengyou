package com.mengyou.zhumengyou.util.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Created by zhangfan on 2015/3/6.
 */
public class InitModel {

    public static long timeLong = System.currentTimeMillis();
    public static long timeInterval = 0L;
    public static BigDecimal bigDecimal = new BigDecimal("100.00");
    public static BigDecimal bigDecimalInterval = new BigDecimal("0.00");
    public static long aLong = 1000L;
    public static int anInt = 10;
    public static String strInterval = "";


    public static Object initModel(String className, long timei, BigDecimal bigDecimali, String stri) throws Exception {
        Class cl = Class.forName(className);
        Object o = cl.newInstance();

        timeInterval = timei;
        bigDecimalInterval = bigDecimali;
        strInterval = stri;

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            String typeName = field.getType().getName();
            String simpleTypeName = typeName.substring(typeName.lastIndexOf(".") + 1);
            String fieldName = field.getName();

            if (fieldName.equals("id")) continue;

            Method method = cl.getMethod("set" + UpperToFirst(fieldName), field.getType());

            if ("String".equals(simpleTypeName)) {
                method.invoke(o, fieldName+strInterval);
            }
            if ("Timestamp".equals(simpleTypeName)) {
                method.invoke(o, new Timestamp(timeLong + timeInterval));
            }
            if ("BigDecimal".equals(simpleTypeName)) {
                method.invoke(o, bigDecimal.add(bigDecimalInterval));
            }
            if ("Long".equals(simpleTypeName)) {
                method.invoke(o, aLong);
            }
            if ("Integer".equals(simpleTypeName)) {
                method.invoke(o, anInt);
            }
        }
        System.out.println("object is "+o);
        return o;
    }

    public static String UpperToFirst(String str) {

        if (Character.isLowerCase(str.charAt(0))) {
            char[] cs = str.toCharArray();
            cs[0] -= 32;
            return String.valueOf(cs);
        }
        return str;
    }
}
