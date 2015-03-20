package com.mengyou.zhumengyou.service;

import com.mengyou.dao.SuggestionMapper;
import com.mengyou.model.db.Suggestion;
import com.mengyou.model.parametercode.ParameterActionCode;
import com.mengyou.zhumengyou.dao.*;
import com.mengyou.zhumengyou.model.CrowdFoundProductCode;
import com.mengyou.zhumengyou.model.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangfan on 2015/3/11.
 * <p/>
 * 项目  功能   Service
 * 评论   增 查
 * 更新日志 ，支持项  增 查 改
 */
@Service
public class ProjectFunctionService {


    @Autowired
    private ProductCommentMapper productCommentMapper;

    @Autowired
    private ProductDiaryMapper productDiaryMapper;


    @Autowired
    private SupportOptionMapper supportOptionMapper;

    @Autowired
    private SuggestionMapper suggestionMapper;

    @Autowired
    private CrowdFoundProductMapper crowdFoundProductMapper;

    @Autowired
    private CrowdFoundOrderMapper crowdFoundOrderMapper;


    /**
     * 查询评论（by项目Id）
     *
     * @param productComment
     * @return
     */
    public List<ProductComment> getCommentByProductId(ProductComment productComment) {
        ProductComment comment = new ProductComment();
        comment.setProductId(productComment.getProductId());
        try {
            List list = productCommentMapper.getBy(comment);
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 添加评论
     *
     * @param productComment
     * @return
     */
    public String saveComment(ProductComment productComment) {
        try {
            productCommentMapper.save(productComment);
            return ParameterActionCode.INSERTSUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.INSERTERROR.getCode();
        }
    }

    /**
     * 查询项目更新日志（by项目Id）
     *
     * @param productDiary
     * @return
     */
    public List<ProductDiary> getDiaryByProductId(ProductDiary productDiary) {
        ProductDiary diary = new ProductDiary();
        diary.setProductId(diary.getProductId());
        try {
            List list = productDiaryMapper.getBy(diary);
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    /**
     * 添加更新日志
     *
     * @param productDiary
     * @return
     */
    public String saveDiary(ProductDiary productDiary) {
        try {
            productDiaryMapper.save(productDiary);
            return ParameterActionCode.INSERTSUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.INSERTERROR.getCode();
        }
    }

    /**
     * 修改更新日志
     *
     * @param productDiary
     * @return
     */
    public String updateDiary(ProductDiary productDiary) {
        try {
            if (productDiary.getId() == null) {
                return ParameterActionCode.NOID.getCode();
            }
            productDiaryMapper.update(productDiary);
            return ParameterActionCode.UPDATESUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.UPDATEERROR.getCode();
        }
    }


    /**
     * 查询项目支持项（by项目Id）
     *
     * @param supportOption
     * @return
     */
    public List<SupportOption> getSupportByProductId(SupportOption supportOption) {
        SupportOption diary = new SupportOption();
        diary.setProductId(diary.getProductId());
        try {
            List list = supportOptionMapper.getBy(diary);
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    /**
     * 添加更新日志
     *
     * @param supportOption
     * @return
     */
    public String saveSupport(SupportOption supportOption) {
        try {
            supportOptionMapper.save(supportOption);
            return ParameterActionCode.INSERTSUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.INSERTERROR.getCode();
        }
    }

    /**
     * 修改更新日志
     *
     * @param supportOption
     * @return
     */
    public String updateSupport(SupportOption supportOption) {
        try {
            if (supportOption.getId() == null) {
                return ParameterActionCode.NOID.getCode();
            }
            supportOptionMapper.update(supportOption);
            return ParameterActionCode.UPDATESUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.UPDATEERROR.getCode();
        }
    }


    /**
     * 添加意见反馈
     *
     * @param suggestion
     * @return
     */
    public String saveSuggestion(Suggestion suggestion) {
        try {
            suggestionMapper.save(suggestion);
            return ParameterActionCode.INSERTSUCCESS.getCode();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ParameterActionCode.INSERTERROR.getCode();
        }
    }

    /**
     * 获取梦游项目列表
     *
     * @return
     */
    public List<CrowdFoundProduct> functionProductSelect() {


        //查询上线的项目
        CrowdFoundProduct crowdFoundProduct = new CrowdFoundProduct();
        crowdFoundProduct.setStatus(CrowdFoundProductCode.PRODUCTLINE.getCode());
        List<CrowdFoundProduct> crowdFoundProducts = crowdFoundProductMapper.getBy(crowdFoundProduct);

        //支持人数，已筹集金额，时间的计算
        for (CrowdFoundProduct foundProduct : crowdFoundProducts) {

            //查询项目的支持订单 人数    总金额
            Map map = crowdFoundOrderMapper.getMoneyAndCountOfUser(foundProduct.getId());
            if (map != null) {
                foundProduct.setMoneyReceive((BigDecimal)map.get("receiveMoney"));
                foundProduct.setSupportSum(Integer.parseInt(map.get("supportNum")+""));
            }

            Long timeEndLong = foundProduct.getTimeEnd().getTime();
            Long currentLong = System.currentTimeMillis();

            if (timeEndLong > currentLong) { //项目众筹时间未到期

                Long hours = (timeEndLong - currentLong) / 1000 / 60 / 60;
                if (hours < 24) {//不够天显示 时，超一天只显示天
                    foundProduct.setRemainingTime(hours + "时");
                } else {
                    foundProduct.setRemainingTime(hours / 24 + "天");
                }

            } else { //项目众筹时间已到期 更改项目状态
                foundProduct.setRemainingTime("0天");

               final CrowdFoundProduct product = new CrowdFoundProduct();
                product.setId(foundProduct.getId());
                if (foundProduct.getMoneyTotal().compareTo(foundProduct.getMoneyReceive()) > 0) {
                    product.setFoundStatus(CrowdFoundProductCode.FOUNDFAIL.getCode()); //筹集金额不够
                } else {
                    product.setFoundStatus(CrowdFoundProductCode.FOUNDSUCCESS.getCode()); //筹集金额正好，或多出
                }
                //启动线程更新项目状态
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        crowdFoundProductMapper.update(product);
                    }
                }).start();
            }

        }

        return crowdFoundProducts;

    }

}
