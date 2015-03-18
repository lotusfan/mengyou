package com.mengyou.zhumengyou.dao;

import com.mengyou.dao.TransactionMapper;
import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.model.db.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TransactionMapperTest {

    @Autowired
    private TransactionMapper transactionMapper;

    @Test
    public void testSave() throws Exception {

        Transaction o = (Transaction) InitModel.initModel("com.mengyou.model.db.Transaction", 0L, new BigDecimal("500.00"), "");
        int i = 5;
        while (i-- > 0) {
            transactionMapper.save(o);
        }
    }

    @Test
    public void testUpdate() throws Exception {

        Transaction o = (Transaction) InitModel.initModel("com.mengyou.model.db.Transaction", 0L, new BigDecimal("1000.00"), "000");
        o.setId(1L);
        transactionMapper.update(o);

    }

    @Test
    public void testGetBy() throws Exception {

        Transaction transaction = new Transaction();

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2015);
        transaction.setTime(new Timestamp(calendar.getTimeInMillis()));
        System.out.println(transactionMapper.getBy(transaction).size());
    }
    @Test
    public void testGetCountBy() throws Exception {
        Transaction transaction = new Transaction();
        System.out.println(transactionMapper.getCountBy(transaction));
    }
}