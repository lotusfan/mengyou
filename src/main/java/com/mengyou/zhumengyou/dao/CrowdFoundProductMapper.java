package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.CrowdFoundProduct;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/4.
 */
public interface CrowdFoundProductMapper {

    public void save(CrowdFoundProduct crowdFoundProduct);

    public void update(CrowdFoundProduct crowdFoundProduct);

    public List<CrowdFoundProduct> getBy(CrowdFoundProduct crowdFoundProduct);

    public CrowdFoundProduct getById(Long id);
}
