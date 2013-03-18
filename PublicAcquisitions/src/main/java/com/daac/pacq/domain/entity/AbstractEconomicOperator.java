package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.helpers.CustomDateSerializer;


@MappedSuperclass
public abstract class AbstractEconomicOperator {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "DECISION_NUMB")
    private String decisionNumb;
    
    @Column(name = "DECISION_DATE")
    private Date 	decisionDate;

    @Column(name = "JURISTIC_PERSON")
    private Integer juristicPerson;
    
    @Column(name = "CODE")
    private String code;    
    
    @Column(name = "REF_LEGAL_FORM_ID")
    private Integer refLegalFormId;

    @Column(name = "NAME")
    private String name;    
    
    @Column(name = "ADDRESS")
    private String address;    

    @Column(name = "CUTAM")
    private Integer cuatm;

    @Column(name = "PHONE")
    private String phone;    

    @Column(name = "EMAIL")
    private String email;    
    
    @Column(name = "STATUS_REASON")
    private String statusReason;
    
    @Column(name = "STATUS")
    private Integer status;
    
    @Column(name = "STATUS_SET_DATE")
    private Date 	statusSetDate;

    @Column(name = "STATUS_SET_USER")
    private String statusSetUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDecisionNumb() {
		return decisionNumb;
	}

	public void setDecisionNumb(String decisionNumb) {
		this.decisionNumb = decisionNumb;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(Date decisionDate) {
		this.decisionDate = decisionDate;
	}

	public Integer getJuristicPerson() {
		return juristicPerson;
	}

	public void setJuristicPerson(Integer juristicPerson) {
		this.juristicPerson = juristicPerson;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getRefLegalFormId() {
		return refLegalFormId;
	}

	public void setRefLegalFormId(Integer refLegalFormId) {
		this.refLegalFormId = refLegalFormId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCuatm() {
		return cuatm;
	}

	public void setCuatm(Integer cuatm) {
		this.cuatm = cuatm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getStatusSetDate() {
		return statusSetDate;
	}

	public void setStatusSetDate(Date statusSetDate) {
		this.statusSetDate = statusSetDate;
	}

	public String getStatusSetUser() {
		return statusSetUser;
	}

	public void setStatusSetUser(String statusSetUser) {
		this.statusSetUser = statusSetUser;
	}

    
}


/*
 
Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt

ID					1	1	N	NUMBER (19)		None		
DECISION_NUMB		2		Y	VARCHAR2 (30 Char)		None		
DECISION_DATE		3		Y	TIMESTAMP(6)		None		
JURISTIC_PERSON		4		Y	NUMBER (10)		None		
CODE				5		Y	VARCHAR2 (13 Char)		None		
REF_LEGAL_FORM_ID	6		Y	NUMBER (19)		None		
NAME				7		Y	VARCHAR2 (250 Char)		None		
ADDRESS				8		Y	VARCHAR2 (250 Char)		None		
CUTAM				9		Y	NUMBER (19)		None		
PHONE				10		Y	VARCHAR2 (30 Char)		None		
EMAIL				11		Y	VARCHAR2 (30 Char)		None		
		
STATUS_REASON		13		Y	CLOB		None		
STATUS				14		Y	NUMBER (10)		None		
STATUS_SET_DATE		15		Y	TIMESTAMP(6)		None		
STATUS_SET_USER		16		Y	VARCHAR2 (255 Char)		None		

 
 
 */