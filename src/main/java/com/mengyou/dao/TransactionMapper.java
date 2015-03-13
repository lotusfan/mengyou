package com.mengyou.dao;

import com.mengyou.model.db.Transaction;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/9.
 */
public interface TransactionMapper {

    public void save(Transaction transaction);

    public void update(Transaction transaction);

    public List<Transaction> getBy(Transaction transaction);
}
