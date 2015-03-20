package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.zhumengyou.model.db.CrowdFoundProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CrowdFoundProductMapperTest {


    @Autowired
    private CrowdFoundProductMapper crowdFoundProductMapper;

    @Test
    public void testSave() throws Exception {

        CrowdFoundProduct crowdFoundProduct = (CrowdFoundProduct) InitModel.initModel("com.mengyou.zhumengyou.model.db.CrowdFoundProduct", 0L, new BigDecimal("0"), null);

        int i = 5;
        while (i-- > 0) {
            crowdFoundProductMapper.save(crowdFoundProduct);
        }
    }

    @Test
    public void testUpdate() throws Exception {

        CrowdFoundProduct crowdFoundProduct = (CrowdFoundProduct) InitModel.initModel("com.mengyou.zhumengyou.model.db.CrowdFoundProduct", 0L, new BigDecimal("0"), "0000");
        crowdFoundProduct.setId(1L);
        crowdFoundProductMapper.update(crowdFoundProduct);
    }

    @Test
    public void testGetBy() throws Exception {

        CrowdFoundProduct crowdFoundProduct = new CrowdFoundProduct();
        crowdFoundProduct.setId(1L);
        System.out.println(crowdFoundProductMapper.getBy(crowdFoundProduct));



    }

    @Test
    public void testGetById() throws  Exception{
        System.out.println(crowdFoundProductMapper.getById(1L));
    }
}