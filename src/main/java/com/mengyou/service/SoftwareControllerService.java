package com.mengyou.service;

import com.mengyou.dao.PicMapper;
import com.mengyou.dao.VersionControllerMapper;
import com.mengyou.model.db.Pic;
import com.mengyou.model.db.VersionController;
import com.mengyou.model.parametercode.ParameterActionCode;
import com.mengyou.model.parametercode.PicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;

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

        if (!ParameterActionCode.UPLOADPICSUCCESS.getCode().equals(uploadPic(inputStream,fileName ))) {

            return ParameterActionCode.UPLOADPICERROR.getCode();//返回上传失败
        }

        //存入图片成功后，入库图片表
        if(pic.getTypeId() == null) return ParameterActionCode.NOID.getCode();
        pic.setType(PicType.HEADPIC.getCode());
        pic.setUrl(PicType.HEADURL.getnamePrefix() + fileName);
        pic.setFlag(PicType.HEADPICFLAGNEW.getCode());
        picMapper.save(pic);

        pic.setFlag(PicType.HEADPICFLAGOLD.getCode());
        picMapper.updateByTypeIdAndNotId(pic);//将用户其它头像置为使用过

        return ParameterActionCode.UPLOADPICSUCCESS.getCode();
    }

    /**
     *
     *
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
}
