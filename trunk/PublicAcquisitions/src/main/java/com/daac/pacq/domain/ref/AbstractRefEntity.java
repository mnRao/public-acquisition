package com.daac.pacq.domain.ref;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.helpers.CustomDateSerializer;


@MappedSuperclass
public abstract class AbstractRefEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "CREATED")
    private Date created;
    
    @Column(name = "END_DATE")
    private Date endDate;
    
    @Column(name = "MD_VALUE")
    private String mdValue;
    
    @Column(name = "RU_VALUE")
    private String ruValue;
    
    @Column(name = "EN_VALUE")
    private String enValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMdValue() {
		return mdValue;
	}

	public void setMdValue(String mdValue) {
		this.mdValue = mdValue;
	}

	public String getRuValue() {
		return ruValue;
	}

	public void setRuValue(String ruValue) {
		this.ruValue = ruValue;
	}

	public String getEnValue() {
		return enValue;
	}

	public void setEnValue(String enValue) {
		this.enValue = enValue;
	}
	
    
}


/*
 
  Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt

ID	1	1	N	NUMBER (19)		None		
CREATED	2		N	TIMESTAMP(6)		None		
END_DATE	3		Y	TIMESTAMP(6)		None		
MD_VALUE	4		N	VARCHAR2 (255 Char)		None		
RU_VALUE	5		Y	VARCHAR2 (255 Char)		None		
EN_VALUE	6		Y	VARCHAR2 (255 Char)		None		

 
 
 */