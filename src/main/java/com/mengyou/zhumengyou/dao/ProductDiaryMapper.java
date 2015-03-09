package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.ProductDiary;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/9.
 */
public interface ProductDiaryMapper {

    public void save(ProductDiary productDiary);

    public void update(ProductDiary productDiary);

    public List<ProductDiary> getBy(ProductDiary productDiary);
}
