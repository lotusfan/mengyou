package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSave() throws Exception {

        User user = new User();
        user.setVc2nickname("小明");

        userMapper.save(user);

    }

    @Test
    public void testUpdate() throws Exception {

        User user = new User();
        user.setId(2L);
        user.setVc2nickname("小王");

        userMapper.update(user);

    }

    @Test
    public void testGetBy() throws Exception {

        User tripUser = new User();
        tripUser.setId(2L);

        List<User> list = userMapper.getBy(tripUser);
        if (list != null) {
            for (User user : list) {
                System.out.println(user);
            }
        }

    }
}