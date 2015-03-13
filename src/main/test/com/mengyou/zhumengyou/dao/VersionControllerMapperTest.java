package com.mengyou.zhumengyou.dao;

import com.mengyou.dao.VersionControllerMapper;
import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.model.db.VersionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class VersionControllerMapperTest {


    @Autowired
    private VersionControllerMapper versionControllerMapper;

    @Test
    public void testSave() throws Exception {

        VersionController o = (VersionController) InitModel.initModel("com.mengyou.model.db.VersionController", 0L, new BigDecimal("500.00"), "");
        versionControllerMapper.save(o);
    }

    @Test
    public void testUpdate() throws Exception {

        VersionController o = (VersionController)InitModel.initModel("com.mengyou.model.db.VersionController", 0L, new BigDecimal("500.00"), "0000");
        o.setId(1L);
        versionControllerMapper.update(o);


    }

    @Test
    public void testGetBy() throws Exception {
        VersionController o = new VersionController();
        o.setId(1L);
        List<VersionController> list = versionControllerMapper.getBy(o);
        if (list != null) {
            for (VersionController oo : list) {
                System.out.println(oo);
            }
        }
    }
    @Test
    public void testGetNewVersionBy() throws Exception {
        VersionController o = new VersionController();
        System.out.println(versionControllerMapper.getNewVersionBy(o));

    }

}