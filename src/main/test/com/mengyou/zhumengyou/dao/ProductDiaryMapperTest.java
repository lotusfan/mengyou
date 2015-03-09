package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.zhumengyou.model.db.ProductDiary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProductDiaryMapperTest {

    @Autowired
    private ProductDiaryMapper productDiaryMapper;

    @Test
    public void testSave() throws Exception {

        ProductDiary o = (ProductDiary) InitModel.initModel("com.mengyou.zhumengyou.model.db.ProductDiary", 0L, null, "");
        productDiaryMapper.save(o);
    }

    @Test
    public void testUpdate() throws Exception {

        ProductDiary o = (ProductDiary) InitModel.initModel("com.mengyou.zhumengyou.model.db.ProductDiary", 0L, null, "000");
        o.setId(1L);
        productDiaryMapper.update(o);

    }

    @Test
    public void testGetBy() throws Exception {

        ProductDiary productDiary = new ProductDiary();
        productDiary.setId(1L);
        List<ProductDiary> list = productDiaryMapper.getBy(productDiary);

        if (list != null) {
            for (ProductDiary comment : list) {
                System.out.println(comment);
            }
        }
    }
}