package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.zhumengyou.model.db.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TransactionMapperTest {

    @Autowired
    private TransactionMapper transactionMapper;

    @Test
    public void testSave() throws Exception {

        Transaction o = (Transaction) InitModel.initModel("com.mengyou.zhumengyou.model.db.Transaction", 0L, new BigDecimal("500.00"), "");
        transactionMapper.save(o);
    }

    @Test
    public void testUpdate() throws Exception {

        Transaction o = (Transaction) InitModel.initModel("com.mengyou.zhumengyou.model.db.Transaction", 0L, new BigDecimal("1000.00"), "000");
        o.setId(1L);
        transactionMapper.update(o);

    }

    @Test
    public void testGetBy() throws Exception {

        Transaction productDiary = new Transaction();
        productDiary.setId(1L);
        List<Transaction> list = transactionMapper.getBy(productDiary);

        if (list != null) {
            for (Transaction comment : list) {
                System.out.println(comment);
            }
        }
    }
}