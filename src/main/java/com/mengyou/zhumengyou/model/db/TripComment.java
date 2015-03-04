package com.mengyou.zhumengyou.model.db;

import java.util.Date;

/**
 * TripComment entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TripComment implements java.io.Serializable {

	// Fields

	private Long id;
	private Long numactivityid;
	private Long numuserid;
	private String vc2name;
	private String vc2nickname;
	private Date datcomment;
	private String vc2content;

	// Constructors

	/** default constructor */
	public TripComment() {
	}

	/** minimal constructor */
	public TripComment(Long id, Long numactivityid, Long numuserid) {
		this.id = id;
		this.numactivityid = numactivityid;
		this.numuserid = numuserid;
	}

	/** full constructor */
	public TripComment(Long id, Long numactivityid, Long numuserid,
			String vc2name, String vc2nickname, Date datcomment,
			String vc2content) {
		this.id = id;
		this.numactivityid = numactivityid;
		this.numuserid = numuserid;
		this.vc2name = vc2name;
		this.vc2nickname = vc2nickname;
		this.datcomment = datcomment;
		this.vc2content = vc2content;
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

	public String getVc2nickname() {
		return this.vc2nickname;
	}

	public void setVc2nickname(String vc2nickname) {
		this.vc2nickname = vc2nickname;
	}

	public Date getDatcomment() {
		return this.datcomment;
	}

	public void setDatcomment(Date datcomment) {
		this.datcomment = datcomment;
	}

	public String getVc2content() {
		return this.vc2content;
	}

	public void setVc2content(String vc2content) {
		this.vc2content = vc2content;
	}

}