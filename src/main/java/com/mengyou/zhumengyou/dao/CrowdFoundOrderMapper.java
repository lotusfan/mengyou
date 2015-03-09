package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.CrowdFoundOrder;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/4.
 */
public interface CrowdFoundOrderMapper {

    public void save(CrowdFoundOrder crowdFoundOrder);

    public void update(CrowdFoundOrder crowdFoundOrder);

    public List<CrowdFoundOrder> getBy(CrowdFoundOrder crowdFoundOrder);

}
