package com.mengyou.util;

import java.util.Random;

/**
 * 生成6位随机数
 *
 * Created by zhangfan on 2015/3/18.
 */
public class Random6Digit {
    public static int generatePin() throws Exception {
        Random generator = new Random();
        generator.setSeed(System.currentTimeMillis());
        int num = generator.nextInt(899999) + 100000;
        return num;
    }
}
