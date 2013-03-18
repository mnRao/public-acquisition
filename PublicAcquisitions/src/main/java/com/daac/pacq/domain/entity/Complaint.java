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
@Table(name = "COMPLAINT")
public class Complaint {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "REF_CURRENT_STATUS_ID")
    private Integer refCurrentStatusId;
    
    @Column(name = "CURRENT_STATUS_DATE")
    private Date 	currentStatusDate;
    
    @Column(name = "FK_CURRENT_STATUS_ID")
    private Integer fkCurrentStatusId;    
    
    @Column(name = "COMPLAINT_NUMB")
    private String complaintNumb;
    
    @Column(name = "TEXT")
    private String text;
    
    @Column(name = "COMPLAINT_DATE")
    private Date 	complaintDate;
    
    @Column(name = "DECISION_TEXT")
    private String decisionText;

    @Column(name = "FK_TENDER_ID")
    private Integer fkTenderId;    

    @Column(name = "FK_PARTICIPANT_ID")
    private Integer fkparticipantId;    

    @Column(name = "FK_RESPONSIBLE_ID")
    private Integer fkResponsibleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRefCurrentStatusId() {
		return refCurrentStatusId;
	}

	public void setRefCurrentStatusId(Integer refCurrentStatusId) {
		this.refCurrentStatusId = refCurrentStatusId;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getCurrentStatusDate() {
		return currentStatusDate;
	}

	public void setCurrentStatusDate(Date currentStatusDate) {
		this.currentStatusDate = currentStatusDate;
	}

	public Integer getFkCurrentStatusId() {
		return fkCurrentStatusId;
	}

	public void setFkCurrentStatusId(Integer fkCurrentStatusId) {
		this.fkCurrentStatusId = fkCurrentStatusId;
	}

	public String getComplaintNumb() {
		return complaintNumb;
	}

	public void setComplaintNumb(String complaintNumb) {
		this.complaintNumb = complaintNumb;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getDecisionText() {
		return decisionText;
	}

	public void setDecisionText(String decisionText) {
		this.decisionText = decisionText;
	}

	public Integer getFkTenderId() {
		return fkTenderId;
	}

	public void setFkTenderId(Integer fkTenderId) {
		this.fkTenderId = fkTenderId;
	}

	public Integer getFkparticipantId() {
		return fkparticipantId;
	}

	public void setFkparticipantId(Integer fkparticipantId) {
		this.fkparticipantId = fkparticipantId;
	}

	public Integer getFkResponsibleId() {
		return fkResponsibleId;
	}

	public void setFkResponsibleId(Integer fkResponsibleId) {
		this.fkResponsibleId = fkResponsibleId;
	}    

    
}

/*
Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt

ID							1	1	N	NUMBER (19)		None		
REF_CURRENT_STATUS_ID		2		Y	NUMBER (19)		None		
CURRENT_STATUS_DATE			3		Y	TIMESTAMP(6)		None		
FK_CURRENT_STATUS_ID		4		Y	NUMBER (19)		None		
COMPLAINT_NUMB				5		Y	VARCHAR2 (12 Char)		None		
TEXT						6		Y	CLOB		None		
COMPLAINT_DATE				7		Y	TIMESTAMP(6)		None		
DECISION_TEXT				8		Y	CLOB		None		
FK_TENDER_ID				9		Y	NUMBER (19)		None		
FK_PARTICIPANT_ID			10		Y	NUMBER (19)		None		
FK_RESPONSIBLE_ID			11		Y	NUMBER (19)		None		
  
 */
