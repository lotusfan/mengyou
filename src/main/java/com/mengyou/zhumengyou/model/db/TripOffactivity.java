package com.mengyou.zhumengyou.model.db;

import java.util.Date;

/**
 * TripOffactivity entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TripOffactivity implements java.io.Serializable {

	// Fields

	private Long id;
	private String vc2name;
	private String vc2type;
	private Long numpay;
	private String vc2address;
	private String vc2suggest;
	private Long numapplicants;
	private Date datpublish;
	private Date datoffline;
	private Date datstart;
	private Date datend;
	private Date datcreate;
	private Date datupdate;
	private Date dataudit;
	private String vc2creator;
	private String vc2modifier;
	private String vc2auditor;
	private String vc2status;
	private String vc2imagepath;
	private Long numcomments;
	private Long numpraises;
	private Long numpaynums;
	private String vc2url;

	// Constructors

	/** default constructor */
	public TripOffactivity() {
	}

	/** minimal constructor */
	public TripOffactivity(Long id) {
		this.id = id;
	}

	/** full constructor */
	public TripOffactivity(Long id, String vc2name, String vc2type,
			Long numpay, String vc2address, String vc2suggest,
			Long numapplicants, Date datpublish, Date datoffline,
			Date datstart, Date datend, Date datcreate, Date datupdate,
			Date dataudit, String vc2creator, String vc2modifier,
			String vc2auditor, String vc2status, String vc2imagepath,
			Long numcomments, Long numpraises) {
		this.id = id;
		this.vc2name = vc2name;
		this.vc2type = vc2type;
		this.numpay = numpay;
		this.vc2address = vc2address;
		this.vc2suggest = vc2suggest;
		this.numapplicants = numapplicants;
		this.datpublish = datpublish;
		this.datoffline = datoffline;
		this.datstart = datstart;
		this.datend = datend;
		this.datcreate = datcreate;
		this.datupdate = datupdate;
		this.dataudit = dataudit;
		this.vc2creator = vc2creator;
		this.vc2modifier = vc2modifier;
		this.vc2auditor = vc2auditor;
		this.vc2status = vc2status;
		this.vc2imagepath = vc2imagepath;
		this.numcomments = numcomments;
		this.numpraises = numpraises;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVc2name() {
		return this.vc2name;
	}

	public void setVc2name(String vc2name) {
		this.vc2name = vc2name;
	}

	public String getVc2type() {
		return this.vc2type;
	}

	public void setVc2type(String vc2type) {
		this.vc2type = vc2type;
	}

	public Long getNumpay() {
		return this.numpay;
	}

	public void setNumpay(Long numpay) {
		this.numpay = numpay;
	}

	public String getVc2address() {
		return this.vc2address;
	}

	public void setVc2address(String vc2address) {
		this.vc2address = vc2address;
	}

	public String getVc2suggest() {
		return this.vc2suggest;
	}

	public void setVc2suggest(String vc2suggest) {
		this.vc2suggest = vc2suggest;
	}

	public Long getNumapplicants() {
		return this.numapplicants;
	}

	public void setNumapplicants(Long numapplicants) {
		this.numapplicants = numapplicants;
	}

	public Date getDatpublish() {
		return this.datpublish;
	}

	public void setDatpublish(Date datpublish) {
		this.datpublish = datpublish;
	}

	public Date getDatoffline() {
		return this.datoffline;
	}

	public void setDatoffline(Date datoffline) {
		this.datoffline = datoffline;
	}

	public Date getDatstart() {
		return this.datstart;
	}

	public void setDatstart(Date datstart) {
		this.datstart = datstart;
	}

	public Date getDatend() {
		return this.datend;
	}

	public void setDatend(Date datend) {
		this.datend = datend;
	}

	public Date getDatcreate() {
		return this.datcreate;
	}

	public void setDatcreate(Date datcreate) {
		this.datcreate = datcreate;
	}

	public Date getDatupdate() {
		return this.datupdate;
	}

	public void setDatupdate(Date datupdate) {
		this.datupdate = datupdate;
	}

	public Date getDataudit() {
		return this.dataudit;
	}

	public void setDataudit(Date dataudit) {
		this.dataudit = dataudit;
	}

	public String getVc2creator() {
		return this.vc2creator;
	}

	public void setVc2creator(String vc2creator) {
		this.vc2creator = vc2creator;
	}

	public String getVc2modifier() {
		return this.vc2modifier;
	}

	public void setVc2modifier(String vc2modifier) {
		this.vc2modifier = vc2modifier;
	}

	public String getVc2auditor() {
		return this.vc2auditor;
	}

	public void setVc2auditor(String vc2auditor) {
		this.vc2auditor = vc2auditor;
	}

	public String getVc2status() {
		return this.vc2status;
	}

	public void setVc2status(String vc2status) {
		this.vc2status = vc2status;
	}

	public String getVc2imagepath() {
		return this.vc2imagepath;
	}

	public void setVc2imagepath(String vc2imagepath) {
		this.vc2imagepath = vc2imagepath;
	}

	public Long getNumcomments() {
		return this.numcomments;
	}

	public void setNumcomments(Long numcomments) {
		this.numcomments = numcomments;
	}

	public Long getNumpraises() {
		return this.numpraises;
	}

	public void setNumpraises(Long numpraises) {
		this.numpraises = numpraises;
	}

	public Long getNumpaynums() {
		return numpaynums;
	}

	public void setNumpaynums(Long numpaynums) {
		this.numpaynums = numpaynums;
	}

	public String getVc2url() {
		return vc2url;
	}

	public void setVc2url(String vc2url) {
		this.vc2url = vc2url;
	}

}