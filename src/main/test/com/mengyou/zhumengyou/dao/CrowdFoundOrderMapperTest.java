package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.zhumengyou.model.db.CrowdFoundOrder;
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
public class CrowdFoundOrderMapperTest {


    @Autowired
    private CrowdFoundOrderMapper crowdFoundOrderMapper;

    @Test
    public void testSave() throws Exception {

        CrowdFoundOrder o = (CrowdFoundOrder)InitModel.initModel("com.mengyou.zhumengyou.model.db.CrowdFoundOrder", 0L, new BigDecimal("500.00"), "");
        crowdFoundOrderMapper.save(o);
    }

    @Test
    public void testUpdate() throws Exception {

        CrowdFoundOrder o = (CrowdFoundOrder)InitModel.initModel("com.mengyou.zhumengyou.model.db.CrowdFoundOrder", 0L, new BigDecimal("500.00"), "0000");
        o.setId(8L);
        crowdFoundOrderMapper.update(o);


    }

    @Test
    public void testGetBy() throws Exception {
        CrowdFoundOrder crowdFoundOrder = new CrowdFoundOrder();
        crowdFoundOrder.setId(1L);
//        crowdFoundOrder.setVc2nickname("小明");
//        tripCrowdFoundMoney.setMoney(new BigDecimal("12.33"));
//        tripCrowdFoundMoney.setProductId(22L);
//        tripCrowdFoundMoney.setStatus(1);
//        tripCrowdFoundMoney.setUpdateTime(new Timestamp(System.currentTimeMillis()));
//        tripCrowdFoundMoney.setUserId(33L);

        List<CrowdFoundOrder> list = crowdFoundOrderMapper.getBy(crowdFoundOrder);
        if (list != null) {
            for (CrowdFoundOrder foundMoney : list) {
                System.out.println(foundMoney);
            }
        }



    }
}