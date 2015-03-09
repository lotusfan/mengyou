package com.mengyou.zhumengyou.model.db;

import java.util.Date;

/**
 * TripOrder entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TripOrder implements java.io.Serializable {

	// Fields

	private Long id;
	private Long numactivityid;
	private Long numuserid;
	private String vc2name;
	private String vc2status;
	private Date datpay;
	private String vc2paytype;
	private Long numactid;
	private String vc2mobile;
	private Date datorder;

	// Constructors

	/** default constructor */
	public TripOrder() {
	}

	/** minimal constructor */
	public TripOrder(Long id, Long numactivityid, Long numuserid, Long numactid) {
		this.id = id;
		this.numactivityid = numactivityid;
		this.numuserid = numuserid;
		this.numactid = numactid;
	}

	/** full constructor */
	public TripOrder(Long id, Long numactivityid, Long numuserid,
			String vc2name, String vc2status, Date datpay, String vc2paytype,
			Long numactid, String vc2mobile, Date datorder) {
		this.id = id;
		this.numactivityid = numactivityid;
		this.numuserid = numuserid;
		this.vc2name = vc2name;
		this.vc2status = vc2status;
		this.datpay = datpay;
		this.vc2paytype = vc2paytype;
		this.numactid = numactid;
		this.vc2mobile = vc2mobile;
		this.datorder = datorder;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumactivityid() {
		return this.numactivityid;
	}

	public void setNumactivityid(Long numactivityid) {
		this.numactivityid = numactivityid;
	}

	public Long getNumuserid() {
		return this.numuserid;
	}

	public void setNumuserid(Long numuserid) {
		this.numuserid = numuserid;
	}

	public String getVc2name() {
		return this.vc2name;
	}

	public void setVc2name(String vc2name) {
		this.vc2name = vc2name;
	}

	public String getVc2status() {
		return this.vc2status;
	}

	public void setVc2status(String vc2status) {
		this.vc2status = vc2status;
	}

	public Date getDatpay() {
		return this.datpay;
	}

	public void setDatpay(Date datpay) {
		this.datpay = datpay;
	}

	public String getVc2paytype() {
		return this.vc2paytype;
	}

	public void setVc2paytype(String vc2paytype) {
		this.vc2paytype = vc2paytype;
	}

	public Long getNumactid() {
		return this.numactid;
	}

	public void setNumactid(Long numactid) {
		this.numactid = numactid;
	}

	public String getVc2mobile() {
		return this.vc2mobile;
	}

	public void setVc2mobile(String vc2mobile) {
		this.vc2mobile = vc2mobile;
	}

	public Date getDatorder() {
		return this.datorder;
	}

	public void setDatorder(Date datorder) {
		this.datorder = datorder;
	}

	@Override
	public String toString() {
		return "TripOrder{" +
				"id=" + id +
				", numactivityid=" + numactivityid +
				", numuserid=" + numuserid +
				", vc2name='" + vc2name + '\'' +
				", vc2status='" + vc2status + '\'' +
				", datpay=" + datpay +
				", vc2paytype='" + vc2paytype + '\'' +
				", numactid=" + numactid +
				", vc2mobile='" + vc2mobile + '\'' +
				", datorder=" + datorder +
				'}';
	}
}