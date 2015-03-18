package com.mengyou.util;

import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by zhangfan on 2015/3/18.
 */
public class ParseProperties {

    public static Properties properties;

    public static String get(String key) throws Exception{

        if (properties == null) {
            getProperties();
        }
        return properties.getProperty(key);

    }

    public static Properties getProperties() throws Exception{
        properties = new Properties();
        properties.load(new InputStreamReader(ParseProperties.class.getResourceAsStream("/mengyou.properties"),"GBK"));
        return properties;
    }
}
