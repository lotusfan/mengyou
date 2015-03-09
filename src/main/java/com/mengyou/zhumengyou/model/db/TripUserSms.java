package com.mengyou.zhumengyou.model.db;

import java.util.Date;

/**
 * TripComment entity.
 *
 * @author MyEclipse Persistence Tools
 */

public class TripUserSms implements java.io.Serializable {

    // Fields

    private Long id;
    private String vc2mobile;
    private String vc2status;
    private String vc2code;
    private Date datcreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVc2mobile() {
        return vc2mobile;
    }

    public void setVc2mobile(String vc2mobile) {
        this.vc2mobile = vc2mobile;
    }

    public String getVc2status() {
        return vc2status;
    }

    public void setVc2status(String vc2status) {
        this.vc2status = vc2status;
    }

    public Date getDatcreate() {
        return datcreate;
    }

    public void setDatcreate(Date datcreate) {
        this.datcreate = datcreate;
    }

    public String getVc2code() {
        return vc2code;
    }

    public void setVc2code(String vc2code) {
        this.vc2code = vc2code;
    }


    // Constructors


    @Override
    public String toString() {
        return "TripUserSms{" +
                "id=" + id +
                ", vc2mobile='" + vc2mobile + '\'' +
                ", vc2status='" + vc2status + '\'' +
                ", vc2code='" + vc2code + '\'' +
                ", datcreate=" + datcreate +
                '}';
    }
}