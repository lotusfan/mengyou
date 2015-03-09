package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.CrowdFoundProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CrowdFoundProductMapperTest {


    @Autowired
    private CrowdFoundProductMapper crowdFoundProductMapper;

    @Test
    public void testSave() throws Exception {

        CrowdFoundProduct crowdFoundProduct = new CrowdFoundProduct();
        crowdFoundProduct.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        crowdFoundProduct.setStatus(3);
        crowdFoundProduct.setUserId(33L);
        crowdFoundProduct.setDescribe("你好呀呀 工");
        crowdFoundProduct.setLable("标签");
        crowdFoundProduct.setMoneyReceive(new BigDecimal("33.93"));
        crowdFoundProduct.setMoneyTotal(new BigDecimal("3333.43"));
        crowdFoundProduct.setNumReceive(3);
        crowdFoundProduct.setNumTotal(10);
        crowdFoundProduct.setOperateTime(new Timestamp(System.currentTimeMillis() - 6000));
        crowdFoundProduct.setOperatorId(55L);
        crowdFoundProduct.setVc2nickname("小明");
        crowdFoundProduct.setTourName("去哪");
        crowdFoundProduct.setPeriod(33);
        crowdFoundProduct.setTimeStart(crowdFoundProduct.getOperateTime());
        crowdFoundProduct.setTimeEnd(crowdFoundProduct.getOperateTime());

        crowdFoundProductMapper.save(crowdFoundProduct);
    }

    @Test
    public void testUpdate() throws Exception {

        CrowdFoundProduct crowdFoundProduct = new CrowdFoundProduct();

        crowdFoundProduct.setId(1L);
        crowdFoundProduct.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        crowdFoundProduct.setStatus(3);
        crowdFoundProduct.setUserId(33L);
        crowdFoundProduct.setDescribe("你好呀呀 工");
        crowdFoundProduct.setLable("标签");
        crowdFoundProduct.setMoneyReceive(new BigDecimal("33.93"));
        crowdFoundProduct.setMoneyTotal(new BigDecimal("3333.43"));
        crowdFoundProduct.setNumReceive(3);
        crowdFoundProduct.setNumTotal(10);
        crowdFoundProduct.setOperateTime(new Timestamp(System.currentTimeMillis() - 6000));
        crowdFoundProduct.setOperatorId(55L);
        crowdFoundProduct.setVc2nickname("小王");
        crowdFoundProduct.setTourName("去哪");
        crowdFoundProduct.setPeriod(33);
        crowdFoundProduct.setTimeStart(crowdFoundProduct.getOperateTime());
        crowdFoundProduct.setTimeEnd(crowdFoundProduct.getOperateTime());

        crowdFoundProductMapper.update(crowdFoundProduct);
    }

    @Test
    public void testGetBy() throws Exception {

        CrowdFoundProduct crowdFoundProduct = new CrowdFoundProduct();
        crowdFoundProduct.setId(1L);
        /*tripCrowdFoundProduct.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        tripCrowdFoundProduct.setUserId(33L);
        tripCrowdFoundProduct.setDescribe("你好呀呀 工");
        tripCrowdFoundProduct.setLable("标签");
        tripCrowdFoundProduct.setMoneyReceive(new BigDecimal("33.93"));
        tripCrowdFoundProduct.setMoneyTotal(new BigDecimal("3333.43"));
        tripCrowdFoundProduct.setNumReceive(3);
        tripCrowdFoundProduct.setNumTotal(10);
        tripCrowdFoundProduct.setOperateTime(new Timestamp(System.currentTimeMillis() - 6000));
        tripCrowdFoundProduct.setOperatorId(55L);
        tripCrowdFoundProduct.setVc2nickname("小明");
        tripCrowdFoundProduct.setTourName("去哪");
        tripCrowdFoundProduct.setPeriod(33);
        tripCrowdFoundProduct.setTimeStart(tripCrowdFoundProduct.getOperateTime());
        tripCrowdFoundProduct.setTimeEnd(tripCrowdFoundProduct.getOperateTime());*/

        List<CrowdFoundProduct> list =  crowdFoundProductMapper.getBy(crowdFoundProduct);

        if (list != null) {
            for (CrowdFoundProduct foundProduct : list) {
                System.out.println(foundProduct);
            }
        }

    }
}