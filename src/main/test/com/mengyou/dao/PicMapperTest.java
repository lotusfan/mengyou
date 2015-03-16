package com.mengyou.dao;

import com.mengyou.model.db.Pic;
import com.mengyou.zhumengyou.main.InitModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PicMapperTest {


    @Autowired
    private PicMapper picMapper;

    @Test
    public void testSave() throws Exception {
        Pic pic = new Pic();
        pic = (Pic) InitModel.initModel(pic.getClass().getName(), 0L, new BigDecimal(0), "");
        picMapper.save(pic);
    }

    @Test
    public void testUpdate() throws Exception {

        Pic pic = new Pic();
        pic = (Pic) InitModel.initModel(pic.getClass().getName(), 0L, new BigDecimal(0), "aa");
        pic.setId(2L);
        picMapper.update(pic);
    }

    @Test
    public void testGetBy() throws Exception {

        Pic pic = new Pic();
        pic.setId(2L);
        System.out.println(picMapper.getBy(pic));
    }
}