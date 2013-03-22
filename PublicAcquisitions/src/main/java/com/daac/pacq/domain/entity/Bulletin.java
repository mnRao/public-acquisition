package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.helpers.CustomDateSerializer;



@Entity
@Table(name = "BULLETIN")
public class Bulletin {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "BULLETIN_NUMB") 
    private String bulletinNumb;  

    @Column(name = "PUBL_DATE") 
    private Date publDate;  

    @Column(name = "ACCESS_TIME") 
    private Integer accessTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBulletinNumb() {
		return bulletinNumb;
	}

	public void setBulletinNumb(String bulletinNumb) {
		this.bulletinNumb = bulletinNumb;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getPublDate() {
		return publDate;
	}

	public void setPublDate(Date publDate) {
		this.publDate = publDate;
	}

	public Integer getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Integer accessTime) {
		this.accessTime = accessTime;
	}
    
    
    
	
}

/*
   ID             NUMBER(19)                     NOT NULL,
  BULLETIN_NUMB  VARCHAR2(255 CHAR)             NOT NULL,
  PUBL_DATE      DATE                           NOT NULL,
  ACCESS_TIME    INTEGER                        DEFAULT 36
 */