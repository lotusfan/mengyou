package com.mengyou.model;

import com.mengyou.model.db.Transaction;
import com.mengyou.zhumengyou.model.db.CrowdFoundProduct;

import java.util.List;

/**
 * Created by zhangfan on 2015/3/16.
 * <p/>
 * 个人中心展示面
 */
public class IndividualPageModel {

    private Long userId; //前台发送时传入

    private Integer partakeDreamSum = 0; //参与的梦游项目总数
    private Integer foundDreamSum = 0; //发起的梦游项目总数
    private Integer transactionRecordsSum = 0; //交易记录总数

    private List<CrowdFoundProduct> partakeProducts; //参与梦游项目详情
    private List<CrowdFoundProduct> foundProducts; //发起梦游项目详情

    private List<Transaction> transactions; //交易记录详情
    private List<StatisticsTransactionModel> statisticsTransactionModels; //交易记录统计

    public Integer getPartakeDreamSum() {
        return partakeDreamSum;
    }

    public void setPartakeDreamSum(Integer partakeDreamSum) {
        this.partakeDreamSum = partakeDreamSum;
    }

    public Integer getFoundDreamSum() {
        return foundDreamSum;
    }

    public void setFoundDreamSum(Integer foundDreamSum) {
        this.foundDreamSum = foundDreamSum;
    }

    public Integer getTransactionRecordsSum() {
        return transactionRecordsSum;
    }

    public void setTransactionRecordsSum(Integer transactionRecordsSum) {
        this.transactionRecordsSum = transactionRecordsSum;
    }

    public List<CrowdFoundProduct> getPartakeProducts() {
        return partakeProducts;
    }

    public void setPartakeProducts(List<CrowdFoundProduct> partakeProducts) {
        this.partakeProducts = partakeProducts;
    }

    public List<CrowdFoundProduct> getFoundProducts() {
        return foundProducts;
    }

    public void setFoundProducts(List<CrowdFoundProduct> foundProducts) {
        this.foundProducts = foundProducts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<StatisticsTransactionModel> getStatisticsTransactionModels() {
        return statisticsTransactionModels;
    }

    public void setStatisticsTransactionModels(List<StatisticsTransactionModel> statisticsTransactionModels) {
        this.statisticsTransactionModels = statisticsTransactionModels;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "IndividualPageModel{" +
                "userId=" + userId +
                ", partakeDreamSum=" + partakeDreamSum +
                ", foundDreamSum=" + foundDreamSum +
                ", transactionRecordsSum=" + transactionRecordsSum +
                ", partakeProducts=" + partakeProducts +
                ", foundProducts=" + foundProducts +
                ", transactions=" + transactions +
                ", statisticsTransactionModels=" + statisticsTransactionModels +
                '}';
    }
}
