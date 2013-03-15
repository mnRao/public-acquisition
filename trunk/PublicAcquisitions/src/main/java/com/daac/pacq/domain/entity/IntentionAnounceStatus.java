package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.domain.ref.IntentionStatus;
import com.daac.pacq.helpers.CustomDateSerializer;

@Entity
@Table(name = "INTENTION_ANOUNCE_STATUS")
public class IntentionAnounceStatus {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "ESTABLISHED_DATE")
    private Date establishedDate; 
    
    @Column(name = "ESTABLISHED_USER")
    private String establishedUser;
    
//    @Column(name = "REF_INTENTION_STATUS_ID")
//    private Integer refIntentionStatusId;

    @OneToOne
    @JoinColumn(name="REF_INTENTION_STATUS_ID")
    private IntentionStatus intentionStatus;
    

//    @Column(name = "INTENTION_ANOUNCE_ID")
//    private Integer refIntentionAnounceId;    


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	public String getEstablishedUser() {
		return establishedUser;
	}

	public void setEstablishedUser(String establishedUser) {
		this.establishedUser = establishedUser;
	}

	public IntentionStatus getIntentionStatus() {
		return intentionStatus;
	}

	public void setIntentionStatus(IntentionStatus intentionStatus) {
		this.intentionStatus = intentionStatus;
	}
    
	
    
}

/*
Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt

ID	1		N	NUMBER (19)		None		
ESTABLISHED_DATE	2		Y	TIMESTAMP(6)		None		
ESTABLISHED_USER	3		Y	VARCHAR2 (255 Char)		None		
REF_INTENTION_STATUS_ID	4		Y	NUMBER (19)		None		
INTENTION_ANOUNCE_ID	5		Y	NUMBER (19)		None		
 
  
  
  
 */
