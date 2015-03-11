package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.zhumengyou.model.db.ProductDiary;
import com.mengyou.zhumengyou.model.db.SupportOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SupportOptionMapperTest {


    @Autowired
    private SupportOptionMapper supportOptionMapper;


    @Test
    public void testSave() throws Exception {

        SupportOption supportOption = (SupportOption) InitModel.initModel("com.mengyou.zhumengyou.model.db.SupportOption", 0L, new BigDecimal("0"), null);
        supportOptionMapper.save(supportOption);
    }

    @Test
    public void testUpdate() throws Exception {

        SupportOption supportOption = (SupportOption) InitModel.initModel("com.mengyou.zhumengyou.model.db.SupportOption", 0L, new BigDecimal("0"), "0000");
        supportOption.setId(1L);
        supportOptionMapper.update(supportOption);
    }

    @Test
    public void testGetBy() throws Exception {

        SupportOption supportOption = new SupportOption();
        supportOption.setId(1L);
        List<SupportOption> list = supportOptionMapper.getBy(supportOption);

        if (list != null) {
            for (SupportOption o : list) {
                System.out.println(o);
            }
        }


    }
}