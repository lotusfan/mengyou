package com.mengyou.zhumengyou.model.db;

import java.util.Date;

/**
 * TripFeedback entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TripFeedback implements java.io.Serializable {

	// Fields

	private Long id;
	private Long numuserid;
	private Date datfeedback;
	private String vc2content;

	// Constructors

	/** default constructor */
	public TripFeedback() {
	}

	/** minimal constructor */
	public TripFeedback(Long id, Long numuserid) {
		this.id = id;
		this.numuserid = numuserid;
	}

	/** full constructor */
	public TripFeedback(Long id, Long numuserid, Date datfeedback,
			String vc2content) {
		this.id = id;
		this.numuserid = numuserid;
		this.datfeedback = datfeedback;
		this.vc2content = vc2content;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumuserid() {
		return this.numuserid;
	}

	public void setNumuserid(Long numuserid) {
		this.numuserid = numuserid;
	}

	public Date getDatfeedback() {
		return this.datfeedback;
	}

	public void setDatfeedback(Date datfeedback) {
		this.datfeedback = datfeedback;
	}

	public String getVc2content() {
		return this.vc2content;
	}

	public void setVc2content(String vc2content) {
		this.vc2content = vc2content;
	}

	@Override
	public String toString() {
		return "TripFeedback{" +
				"id=" + id +
				", numuserid=" + numuserid +
				", datfeedback=" + datfeedback +
				", vc2content='" + vc2content + '\'' +
				'}';
	}
}