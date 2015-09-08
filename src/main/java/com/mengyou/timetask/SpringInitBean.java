package com.mengyou.timetask;

import com.mengyou.dao.TestMapper;
import com.mengyou.model.db.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangfan on 2015/6/16.
 */

@Service
public class SpringInitBean implements InitializingBean {

    @Autowired
    private TestMapper testMapper;


    @Override
    public void afterPropertiesSet() throws Exception {
/*


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(testMapper.getBy(new Test()));
                    try {
                        Thread.sleep(5*1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
*/


    }
}
