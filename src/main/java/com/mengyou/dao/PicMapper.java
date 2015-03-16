package com.mengyou.dao;

import com.mengyou.model.db.Pic;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/16.
 */
public interface PicMapper {

    public void save(Pic pic);

    public void update(Pic pic);

    public void updateByTypeIdAndNotId(Pic pic);

    public List<Pic> getBy(Pic pic);
}
