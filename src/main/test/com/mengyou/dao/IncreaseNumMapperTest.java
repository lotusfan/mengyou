package com.mengyou.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IncreaseNumMapperTest {


    @Autowired
    private IncreaseNumMapper mapper;
    private StringBuffer stringBuffer = new StringBuffer();

    @Test
    public void testGetNum() throws Exception {

        int i = 10;
        while (--i > 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    int j = 50;
                    while (--j > 0) {
                        getNum();
                    }
                }
            }).start();
        }
        Thread.sleep(100000);
    }

    public synchronized void getNum() {
        System.out.println(mapper.getNum());
    }

}