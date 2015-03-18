package com.mengyou.model;

import java.math.BigDecimal;

/**
 * Created by zhangfan on 2015/3/17.
 */
public class StatisticsTransactionModel {

    private String time;
    private BigDecimal total = new BigDecimal("0");

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

    @Override
    public String toString() {
        return "StatisticsTransactionModel{" +
                "time='" + time + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
