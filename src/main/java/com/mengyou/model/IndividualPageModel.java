package com.mengyou.model;

/**
 * Created by zhangfan on 2015/3/16.
 * <p/>
 * 个人中心展示面
 */
public class IndividualPageModel {

    private Integer partakeDreamSum;
    private Integer foundDreamSum;
    private Integer transactionRecordsSum;
    private Object o;

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

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    @Override
    public String toString() {
        return "IndividualPageModel{" +
                "partakeDreamSum=" + partakeDreamSum +
                ", foundDreamSum=" + foundDreamSum +
                ", transactionRecordsSum=" + transactionRecordsSum +
                ", o=" + o +
                '}';
    }
}
