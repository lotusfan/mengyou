package com.mengyou.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMapperTest {


    @Autowired
    private TestMapper testMapper;

    @Test
    public void testGetBy() throws Exception {

        System.out.println(testMapper.getBy(new com.mengyou.model.db.Test()));
    }

    @Test
    public void testSelectCount() throws Exception {

        System.out.println(testMapper.selectCount());
    }
    @Test
    public void testPagingBy() throws Exception{
        com.mengyou.model.db.Test test = new com.mengyou.model.db.Test();

//        System.out.println(testMapper.pagingBy(test, 2));
    }
}