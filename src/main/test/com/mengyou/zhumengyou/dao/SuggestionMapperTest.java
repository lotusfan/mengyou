package com.mengyou.zhumengyou.dao;

import com.mengyou.dao.SuggestionMapper;
import com.mengyou.zhumengyou.main.InitModel;
import com.mengyou.model.db.Suggestion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SuggestionMapperTest {


    @Autowired
    private SuggestionMapper suggestionMapper;

    @Test
    public void testSave() throws Exception {

        Suggestion suggestion = (Suggestion) InitModel.initModel("com.mengyou.model.db.Suggestion", 0L, new BigDecimal("0"), null);
        suggestionMapper.save(suggestion);
    }

    @Test
    public void testUpdate() throws Exception {

        Suggestion suggestion = (Suggestion) InitModel.initModel("com.mengyou.model.db.Suggestion", 0L, new BigDecimal("0"), "0000");
        suggestion.setId(1L);
        suggestionMapper.update(suggestion);
    }

    @Test
    public void testGetBy() throws Exception {

        Suggestion suggestion = new Suggestion();
        suggestion.setId(1L);
        System.out.println(suggestionMapper.getBy(suggestion));
    }
}