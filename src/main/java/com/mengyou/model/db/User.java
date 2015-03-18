package com.mengyou.model.db;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TripUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {
    private static final long serialVersionUID = 6528560200635784071L;

    // Fields

	private Long id;
	private String vc2nickname;
	private String vc2username;
	private String vc2sex;
	private Timestamp datbirth;
	private String vc2bloodtype;
	private String vc2occupation;
	private String vc2company;
	private String vc2school;
	private String vc2invitationcode;
	private Long numdreammoney;
	private String vc2idcard;
	private String vc2loginaccount;
	private String vc2loginpassword;
	private Timestamp datregister;
	private String vc2mylabel;
	private String vc2bankaccount;
	private String vc2iconpath;
	private String vc2xingzuo;
	private String vc2area;
	private String code;
	private Long numeverymoney;
	private String vc2age;
    private String location1;
    private String location2;
    private Timestamp createTime;
    private Timestamp updateTime;

    //前端展示用
    private String authentiCode;


    // Constructors

	public String getVc2xingzuo() {
		return vc2xingzuo;
	}

	public void setVc2xingzuo(String vc2xingzuo) {
		this.vc2xingzuo = vc2xingzuo;
	}

	public String getVc2area() {
		return vc2area;
	}

	public void setVc2area(String vc2area) {
		this.vc2area = vc2area;
	}

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Long id) {
		this.id = id;
	}

	/** full constructor */
	public User(Long id, String vc2nickname, String vc2username,
                String vc2sex, Timestamp datbirth, String vc2bloodtype,
                String vc2occupation, String vc2company, String vc2school,
                String vc2invitationcode, Long numdreammoney, String vc2idcard,
                String vc2loginaccount, String vc2loginpassword, Timestamp datregister,
                String vc2mylabel, String vc2bankaccount, String vc2iconpath) {
		this.id = id;
		this.vc2nickname = vc2nickname;
		this.vc2username = vc2username;
		this.vc2sex = vc2sex;
		this.datbirth = datbirth;
		this.vc2bloodtype = vc2bloodtype;
		this.vc2occupation = vc2occupation;
		this.vc2company = vc2company;
		this.vc2school = vc2school;
		this.vc2invitationcode = vc2invitationcode;
		this.numdreammoney = numdreammoney;
		this.vc2idcard = vc2idcard;
		this.vc2loginaccount = vc2loginaccount;
		this.vc2loginpassword = vc2loginpassword;
		this.datregister = datregister;
		this.vc2mylabel = vc2mylabel;
		this.vc2bankaccount = vc2bankaccount;
		this.vc2iconpath = vc2iconpath;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVc2nickname() {
		return this.vc2nickname;
	}

	public void setVc2nickname(String vc2nickname) {
		this.vc2nickname = vc2nickname;
	}

	public String getVc2username() {
		return this.vc2username;
	}

	public void setVc2username(String vc2username) {
		this.vc2username = vc2username;
	}

	public String getVc2sex() {
		return this.vc2sex;
	}

	public void setVc2sex(String vc2sex) {
		this.vc2sex = vc2sex;
	}


	public String getVc2bloodtype() {
		return this.vc2bloodtype;
	}

	public void setVc2bloodtype(String vc2bloodtype) {
		this.vc2bloodtype = vc2bloodtype;
	}

	public String getVc2occupation() {
		return this.vc2occupation;
	}

	public void setVc2occupation(String vc2occupation) {
		this.vc2occupation = vc2occupation;
	}

	public String getVc2company() {
		return this.vc2company;
	}

	public void setVc2company(String vc2company) {
		this.vc2company = vc2company;
	}

	public String getVc2school() {
		return this.vc2school;
	}

	public void setVc2school(String vc2school) {
		this.vc2school = vc2school;
	}

	public String getVc2invitationcode() {
		return this.vc2invitationcode;
	}

	public void setVc2invitationcode(String vc2invitationcode) {
		this.vc2invitationcode = vc2invitationcode;
	}

	public Long getNumdreammoney() {
		return this.numdreammoney;
	}

	public void setNumdreammoney(Long numdreammoney) {
		this.numdreammoney = numdreammoney;
	}

	public String getVc2idcard() {
		return this.vc2idcard;
	}

	public void setVc2idcard(String vc2idcard) {
		this.vc2idcard = vc2idcard;
	}

	public String getVc2loginaccount() {
		return this.vc2loginaccount;
	}

	public void setVc2loginaccount(String vc2loginaccount) {
		this.vc2loginaccount = vc2loginaccount;
	}

	public String getVc2loginpassword() {
		return this.vc2loginpassword;
	}

	public void setVc2loginpassword(String vc2loginpassword) {
		this.vc2loginpassword = vc2loginpassword;
	}

    public Timestamp getDatbirth() {
        return datbirth;
    }

    public void setDatbirth(Timestamp datbirth) {
        this.datbirth = datbirth;
    }

    public Timestamp getDatregister() {
        return datregister;
    }

    public void setDatregister(Timestamp datregister) {
        this.datregister = datregister;
    }

    public String getVc2mylabel() {
		return this.vc2mylabel;
	}

	public void setVc2mylabel(String vc2mylabel) {
		this.vc2mylabel = vc2mylabel;
	}

	public String getVc2bankaccount() {
		return this.vc2bankaccount;
	}

	public void setVc2bankaccount(String vc2bankaccount) {
		this.vc2bankaccount = vc2bankaccount;
	}

	public String getVc2iconpath() {
		return this.vc2iconpath;
	}

	public void setVc2iconpath(String vc2iconpath) {
		this.vc2iconpath = vc2iconpath;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getNumeverymoney() {
		return numeverymoney;
	}

	public void setNumeverymoney(Long numeverymoney) {
		this.numeverymoney = numeverymoney;
	}

	public String getVc2age() {
		return vc2age;
	}

	public void setVc2age(String vc2age) {
		this.vc2age = vc2age;
	}

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuthentiCode() {
        return authentiCode;
    }

    public void setAuthentiCode(String authentiCode) {
        this.authentiCode = authentiCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", vc2nickname='" + vc2nickname + '\'' +
                ", vc2username='" + vc2username + '\'' +
                ", vc2sex='" + vc2sex + '\'' +
                ", datbirth=" + datbirth +
                ", vc2bloodtype='" + vc2bloodtype + '\'' +
                ", vc2occupation='" + vc2occupation + '\'' +
                ", vc2company='" + vc2company + '\'' +
                ", vc2school='" + vc2school + '\'' +
                ", vc2invitationcode='" + vc2invitationcode + '\'' +
                ", numdreammoney=" + numdreammoney +
                ", vc2idcard='" + vc2idcard + '\'' +
                ", vc2loginaccount='" + vc2loginaccount + '\'' +
                ", vc2loginpassword='" + vc2loginpassword + '\'' +
                ", datregister=" + datregister +
                ", vc2mylabel='" + vc2mylabel + '\'' +
                ", vc2bankaccount='" + vc2bankaccount + '\'' +
                ", vc2iconpath='" + vc2iconpath + '\'' +
                ", vc2xingzuo='" + vc2xingzuo + '\'' +
                ", vc2area='" + vc2area + '\'' +
                ", code='" + code + '\'' +
                ", numeverymoney=" + numeverymoney +
                ", vc2age='" + vc2age + '\'' +
                ", location1='" + location1 + '\'' +
                ", location2='" + location2 + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", authentiCode='" + authentiCode + '\'' +
                '}';
    }
}