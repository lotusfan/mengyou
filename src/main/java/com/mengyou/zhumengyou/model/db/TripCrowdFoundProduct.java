package com.mengyou.zhumengyou.model.db;

import java.math.BigDecimal;
import java.security.Timestamp;

/**
 * Created by zhangfan on 2015/3/4.
 * <p/>
 * 众筹表
 */
public class TripCrowdFoundProduct {
    private Integer id;
    private Integer userId;   //创建人
    private String tourName;  //旅游名称
    private Timestamp timeStart; //项目报名时间
    private Timestamp timeEnd; //项目结束时间
    private Integer period; //筹集期间
    private BigDecimal money; //筹集金额
    private Integer operatorId; //操作员Id
    private Timestamp operateTime; //操作时间
    private Timestamp createTime; //记录创建时间
    private Timestamp updateTime; //记录修改时间
}
