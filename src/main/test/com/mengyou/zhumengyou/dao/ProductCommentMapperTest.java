package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.zhumengyou.model.db.ProductComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProductCommentMapperTest {


    @Autowired
    private ProductCommentMapper productCommentMapper;

    @Test
    public void testSave() throws Exception {

        ProductComment o = (ProductComment) InitModel.initModel("com.mengyou.zhumengyou.model.db.ProductComment", 0L, null, "");
        productCommentMapper.save(o);
    }

    @Test
    public void testUpdate() throws Exception {

        ProductComment o = (ProductComment) InitModel.initModel("com.mengyou.zhumengyou.model.db.ProductComment", 0L, null, "000");
        o.setId(3L);
        productCommentMapper.update(o);

    }

    @Test
    public void testGetBy() throws Exception {

        ProductComment productComment = new ProductComment();
        productComment.setId(1L);
        List<ProductComment> list = productCommentMapper.getBy(productComment);

        if (list != null) {
            for (ProductComment comment : list) {
                System.out.println(comment);
            }
        }
    }

}