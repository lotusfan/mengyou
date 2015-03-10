package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.VersionController;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/10.
 */
public interface VersionControllerMapper {

    public void save(VersionController versionController);

    public void update(VersionController versionController);

    public List<VersionController> getBy(VersionController versionController);

    public VersionController getNewVersionBy(VersionController versionController);
}
