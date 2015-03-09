package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.TripCrowdFoundPeople;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TripCrowdFoundPeopleMapperTest {


    @Autowired
    private TripCrowdFoundPeopleMapper tripCrowdFoundPeopleMapper;

    @Test
    public void testSave() throws Exception {
        TripCrowdFoundPeople tripCrowdFoundPeople = new TripCrowdFoundPeople();
        tripCrowdFoundPeople.setVc2nickname("小张");
        tripCrowdFoundPeople.setUserId(33L);
        tripCrowdFoundPeople.setProductId(22L);
        tripCrowdFoundPeople.setStatus(2);
        tripCrowdFoundPeople.setNum(3);
        tripCrowdFoundPeople.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        tripCrowdFoundPeopleMapper.save(tripCrowdFoundPeople);
    }

    @Test
    public void testUpdate() throws Exception {

        TripCrowdFoundPeople tripCrowdFoundPeople = new TripCrowdFoundPeople();
        tripCrowdFoundPeople.setId(3L);
        tripCrowdFoundPeople.setVc2nickname("小王");
        tripCrowdFoundPeople.setUserId(44L);
        tripCrowdFoundPeople.setProductId(44L);
        tripCrowdFoundPeople.setStatus(4);
        tripCrowdFoundPeople.setNum(4);
        tripCrowdFoundPeople.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        tripCrowdFoundPeopleMapper.update(tripCrowdFoundPeople);
    }

    @Test
    public void testGetBy() throws Exception {

        TripCrowdFoundPeople tripCrowdFoundPeople = new TripCrowdFoundPeople();
//        tripCrowdFoundPeople.setId(3L);
        tripCrowdFoundPeople.setVc2nickname("小王");
//        tripCrowdFoundPeople.setUserId(44L);
//        tripCrowdFoundPeople.setProductId(44L);
//        tripCrowdFoundPeople.setStatus(4);
//        tripCrowdFoundPeople.setNum(4);
//        tripCrowdFoundPeople.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        List<TripCrowdFoundPeople> list = tripCrowdFoundPeopleMapper.getBy(tripCrowdFoundPeople);
        if (list != null) {
            for (TripCrowdFoundPeople foundPeople : list) {
                System.out.println(foundPeople);
            }
        }

    }
}