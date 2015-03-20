package com.mengyou.service;

import com.mengyou.model.StatisticsTransactionModel;
import com.mengyou.model.db.Transaction;
import com.mengyou.model.parametercode.TransactionCode;
import com.mengyou.zhumengyou.dao.CrowdFoundProductMapper;
import com.mengyou.zhumengyou.model.db.CrowdFoundProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zhangfan on 2015/3/20.
 *
 * 交易记录 统计分析Service
 */
@Service
public class TransactionService {


    @Qualifier("crowdFoundProductMapper")
    @Autowired
    private CrowdFoundProductMapper crowdFoundProductMapper;

    /**
     * 获取用户参与的梦游项目
     *
     * @param transactions
     * @return
     */
    public List<CrowdFoundProduct> getPartakeProducts(List<Transaction> transactions) {

        //我参与的梦游项目
        List<CrowdFoundProduct> crowdFoundProducts = new ArrayList<>();
        for (Transaction tr : transactions) {
            //筛选参与梦游项目
            if (TransactionCode.SUPPORTOPTION.getCode() == tr.getType()) {
                crowdFoundProducts.add(crowdFoundProductMapper.getById(tr.getSourceId()));
            }
        }

        return crowdFoundProducts;
    }

    /**
     * 获取 统计用户交易记录信息
     *
     * @param transactions
     * @return
     */
    public List<StatisticsTransactionModel> getStatisticsTransactionModels(List<Transaction> transactions) {


        //交易记录统计 只有当年的已过月份
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        List<StatisticsTransactionModel> statisticsTransactionModels = new ArrayList<>(calendar.get(Calendar.MONTH) + 1);

        int month = calendar.get(Calendar.MONTH);
        for (int i = 0; i <= month; i++) {//对交易统计List按月分顺序初始化

            calendar.set(Calendar.MONTH, i);
            StatisticsTransactionModel statisticsTransactionModel = new StatisticsTransactionModel();
            statisticsTransactionModel.setTime(simpleDateFormat.format(calendar.getTime()));
            statisticsTransactionModels.add(i, statisticsTransactionModel);
        }

        for (Transaction tr : transactions) {
            //交易记录统计
            calendar.setTimeInMillis(tr.getTime().getTime());
            StatisticsTransactionModel stm = statisticsTransactionModels.get(calendar.get(Calendar.MONTH));
            if (TransactionCode.SUPPORTOPTION.getCode() == tr.getType()) {//支持金额
                stm.setSupportTotal(stm.getSupportTotal().add(tr.getMoney()));
            }else if (TransactionCode.MENGYOUQUAN.getCode() == tr.getType()) {//梦游券
                stm.setTicketTotal(stm.getTicketTotal().add(tr.getMoney()));
            }
            stm.getTransactions().add(tr);
        }
        for (StatisticsTransactionModel statisticsTransactionModel : statisticsTransactionModels) {
            statisticsTransactionModel.setTotal(statisticsTransactionModel.getSupportTotal().add(statisticsTransactionModel.getTicketTotal()));
            statisticsTransactionModel.setNum(statisticsTransactionModel.getTransactions().size());
        }

        return statisticsTransactionModels;
    }
}
