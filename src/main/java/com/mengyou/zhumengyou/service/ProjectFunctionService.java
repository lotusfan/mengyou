package com.mengyou.zhumengyou.service;

import com.mengyou.zhumengyou.dao.ProductCommentMapper;
import com.mengyou.zhumengyou.dao.ProductDiaryMapper;
import com.mengyou.zhumengyou.dao.SupportOptionMapper;
import com.mengyou.zhumengyou.model.db.ProductComment;
import com.mengyou.zhumengyou.model.db.ProductDiary;
import com.mengyou.zhumengyou.model.db.SupportOption;
import com.mengyou.zhumengyou.model.parametercode.ParameterActionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 查询评论（by项目Id）
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


}
