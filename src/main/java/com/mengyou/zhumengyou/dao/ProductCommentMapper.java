package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.ProductComment;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/9.
 */
public interface ProductCommentMapper {

    public void save(ProductComment productComment);

    public void update(ProductComment productComment);

    public List<ProductComment> getBy(ProductComment productComment);
}
