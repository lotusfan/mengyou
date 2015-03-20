package com.mengyou.service;

import com.mengyou.dao.PicMapper;
import com.mengyou.dao.TransactionMapper;
import com.mengyou.dao.VersionControllerMapper;
import com.mengyou.model.IndividualPageModel;
import com.mengyou.model.StatisticsTransactionModel;
import com.mengyou.model.db.Pic;
import com.mengyou.model.db.Transaction;
import com.mengyou.model.db.VersionController;
import com.mengyou.model.parametercode.ParameterActionCode;
import com.mengyou.model.parametercode.PicType;
import com.mengyou.model.parametercode.TransactionCode;
import com.mengyou.zhumengyou.dao.CrowdFoundProductMapper;
import com.mengyou.zhumengyou.model.db.CrowdFoundProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by zhangfan on 2015/3/10.
 * <p/>
 * 软件的配置   版本控制
 */

@Service
public class SoftwareControllerService {

    @Autowired
    private VersionControllerMapper versionControllerMapper;
    @Autowired
    private PicMapper picMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private CrowdFoundProductMapper crowdFoundProductMapper;


    /**
     * mengyou 版本检测
     *
     * @param versionController
     * @return
     */
    public VersionController checkVersion(VersionController versionController) {

        VersionController versionControllerNew = new VersionController();
        versionControllerNew.setMtType(versionController.getMtType());
        versionControllerNew = versionControllerMapper.getNewVersionBy(versionControllerNew);
        if (versionControllerNew.compareTo(versionController) == 0) {//不需要更新
            return null;
        }
        return versionControllerNew;
    }

    /**
     * 用户上传头像
     *
     * @param inputStream
     * @param pic
     * @return
     */
    public String uploadHeadPic(InputStream inputStream, Pic pic) {

        String fileName = PicType.HEADPIC.getnamePrefix()
                + pic.getTypeId() + "_" + System.currentTimeMillis();//文件名U + Id + _ + 时间戳

        if (!ParameterActionCode.UPLOADPICSUCCESS.getCode().equals(uploadPic(inputStream, fileName))) {

            return ParameterActionCode.UPLOADPICERROR.getCode();//返回上传失败
        }

        //存入图片成功后，入库图片表
        if (pic.getTypeId() == null) return ParameterActionCode.NOID.getCode();
        pic.setType(PicType.HEADPIC.getCode());
        pic.setUrl(PicType.HEADURL.getnamePrefix() + fileName);
        pic.setFlag(PicType.HEADPICFLAGNEW.getCode());
        picMapper.save(pic);

        pic.setFlag(PicType.HEADPICFLAGOLD.getCode());
        picMapper.updateByTypeIdAndNotId(pic);//将用户其它头像置为使用过

        return ParameterActionCode.UPLOADPICSUCCESS.getCode();
    }

    /**
     * @param pic
     * @return
     */
    public String alertHeadPic(Pic pic) {

        if (pic.getId() == null) {
            return ParameterActionCode.NOID.getCode();
        }

        //创建新对象 防止更新其它内容
        Pic o = new Pic();
        o.setId(pic.getId());
        o.setFlag(PicType.HEADPICFLAGNEW.getCode());
        picMapper.update(o);

        //将用户其它头像置为使用过
        o.setTypeId(pic.getTypeId());
        o.setType(PicType.HEADPIC.getCode());
        o.setFlag(PicType.HEADPICFLAGOLD.getCode());
        picMapper.updateByTypeIdAndNotId(o);

        return ParameterActionCode.UPDATESUCCESS.getCode();
    }


    /**
     * 存图片
     *
     * @param inputStream
     * @param picName
     * @return
     */
    public String uploadPic(InputStream inputStream, String picName) {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("./src/main/webapp/pic/" + picName + ".jpg"));

            //将文件存入pic目录下
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, len);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.UPLOADPICERROR.getCode();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return ParameterActionCode.UPLOADPICSUCCESS.getCode();
    }

    /**
     * 封装个人中心初始接口
     *
     * @return
     */
    public IndividualPageModel getIndividualPage(IndividualPageModel individualPageModel) {
        if (individualPageModel.getUserId() == null) {
            return null;
        }

        Transaction transaction = new Transaction();
        transaction.setUserId(individualPageModel.getUserId());

        //交易记录只获取今年
        Calendar trCalendar = Calendar.getInstance();
        int year = trCalendar.get(Calendar.YEAR);
        trCalendar.clear();
        trCalendar.set(Calendar.YEAR, year);
        transaction.setTime(new Timestamp(trCalendar.getTimeInMillis()));

        //全部交易记录
        List<Transaction> transactions = transactionMapper.getBy(transaction);

        if (transactions == null || transactions.size() == 0) {
            return null;
        }

        individualPageModel.setTransactionRecordsSum(transactions.size()); //交易记录条数
        individualPageModel.setTransactions(transactions); //交易记录详情

        //交易记录统计 只有当年的已过月份
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        List<StatisticsTransactionModel> statisticsTransactionModels = new ArrayList<>(calendar.get(Calendar.MONTH) + 1);

        int month = calendar.get(Calendar.MONTH);
        for (int i = 0; i <= month; i++) {//对返回交易统计List初始化

            calendar.set(Calendar.MONTH, i);
            StatisticsTransactionModel statisticsTransactionModel = new StatisticsTransactionModel();
            statisticsTransactionModel.setTime(simpleDateFormat.format(calendar.getTime()));
            statisticsTransactionModels.add(i, statisticsTransactionModel);
        }
        //减少一次遍历transactions，将记录插入移下

        //我参与的梦游项目
        List<CrowdFoundProduct> crowdFoundProducts = new ArrayList<>();
        for (Transaction tr : transactions) {
            //筛选参与梦游项目
            if (TransactionCode.SUPPORTOPTION.getCode() == tr.getType()) {
                crowdFoundProducts.add(crowdFoundProductMapper.getById(tr.getSourceId()));
            }
            //交易记录统计
            calendar.setTimeInMillis(tr.getTime().getTime());
            StatisticsTransactionModel stm = statisticsTransactionModels.get(calendar.get(Calendar.MONTH));
            stm.setTotal(stm.getTotal().add(tr.getMoney()));
        }

        individualPageModel.setStatisticsTransactionModels(statisticsTransactionModels); //交易统计
        individualPageModel.setPartakeDreamSum(crowdFoundProducts.size()); //参与梦游条数
        individualPageModel.setPartakeProducts(crowdFoundProducts); //参与梦游项目详情

        return individualPageModel;

    }
}
