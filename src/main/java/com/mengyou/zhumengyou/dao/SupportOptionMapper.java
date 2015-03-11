package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.SupportOption;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/11.
 * <p/>
 * 支持项 表
 */
public interface SupportOptionMapper {
    public void save(SupportOption supportOption);

    public void update(SupportOption supportOption);

    public List<SupportOption> getBy(SupportOption supportOption);
}
