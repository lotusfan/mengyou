package com.mengyou.zhumengyou.dao;

import com.mengyou.zhumengyou.model.db.User;
import java.util.List;

/**
 * Created by zhangfan on 2015/3/5.
 * <p/>
 * 用户信息表
 */
public interface UserMapper {
    public void save(User user);

    public void update(User user);

    public List<User> getBy(User user);
}
