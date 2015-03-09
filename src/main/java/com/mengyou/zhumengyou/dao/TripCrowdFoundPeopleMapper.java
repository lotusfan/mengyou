package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.TripCrowdFoundPeople;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/4.
 */
public interface TripCrowdFoundPeopleMapper {

    public void save(TripCrowdFoundPeople tripCrowdFoundPeople);

    public void update(TripCrowdFoundPeople tripCrowdFoundPeople);

    public List<TripCrowdFoundPeople> getBy(TripCrowdFoundPeople tripCrowdFoundPeople);
}
