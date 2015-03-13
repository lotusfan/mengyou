package com.mengyou.service;

import com.mengyou.dao.VersionControllerMapper;
import com.mengyou.model.db.VersionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangfan on 2015/3/10.
 * <p/>
 * 软件的配置   版本控制
 */

@Service
public class SoftwareControllerService {

    @Autowired
    private VersionControllerMapper versionControllerMapper;

    public VersionController checkVersion(VersionController versionController) {

        VersionController versionControllerNew = new VersionController();
        versionControllerNew.setMtType(versionController.getMtType());
        versionControllerNew = versionControllerMapper.getNewVersionBy(versionControllerNew);
        if (versionControllerNew.compareTo(versionController) == 0) {
            return null;
        }
        return versionControllerNew;
    }
}
