package com.mengyou.dao;

import com.mengyou.model.db.Suggestion;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/13.
 */
public interface SuggestionMapper {

    public void save(Suggestion suggestion);

    public void update(Suggestion suggestion);

    public List<Suggestion> getBy(Suggestion suggestion);
}
