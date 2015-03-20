package com.mengyou.model;

import com.mengyou.model.db.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan on 2015/3/17.
 */
public class StatisticsTransactionModel {

    private String time;
    private BigDecimal total = new BigDecimal(0);
    private BigDecimal ticketTotal = new BigDecimal(0);
    private BigDecimal supportTotal = new BigDecimal(0);
    private List<Transaction> transactions = new ArrayList<>();
    private Integer num = 0;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTicketTotal() {
        return ticketTotal;
    }

    public void setTicketTotal(BigDecimal ticketTotal) {
        this.ticketTotal = ticketTotal;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public BigDecimal getSupportTotal() {
        return supportTotal;
    }

    public void setSupportTotal(BigDecimal supportTotal) {
        this.supportTotal = supportTotal;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "StatisticsTransactionModel{" +
                "time='" + time + '\'' +
                ", total=" + total +
                ", ticketTotal=" + ticketTotal +
                ", supportTotal=" + supportTotal +
                ", transactions=" + transactions +
                ", num=" + num +
                '}';
    }
}
