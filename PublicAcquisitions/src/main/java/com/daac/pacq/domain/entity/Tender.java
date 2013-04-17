package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Formula;

import com.daac.pacq.domain.ref.TenderStatus;
import com.daac.pacq.domain.ref.TenderType;
import com.daac.pacq.helpers.CustomDateSerializer;


@Entity
@Table(name = "TENDER")
public class Tender {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
//    @Column(name = "REF_CURRENT_STATUS_ID")
//    private Integer refCurrentStatusId;
    @OneToOne
    @JoinColumn(name="REF_CURRENT_STATUS_ID")
    private TenderStatus tenderStatus;    
    
    @JsonSerialize (using = CustomDateSerializer.class)
    @Column(name = "CURRENT_STATUS_DATE")
    private Date	refCurrentStatusDate;
    
    @Column(name = "FK_CURRENT_STATUS_ID")
    private Integer fkCurrentStatusId;
    
    
//    @Column(name = "REF_TENDER_TYPE_ID")
//    private Integer refTenderTypeId;
    @OneToOne
    @JoinColumn(name="REF_TENDER_TYPE_ID")
    private TenderType tenderType;
    
    @JsonSerialize (using = CustomDateSerializer.class)
    @Column(name = "TENDER_OPEN_DATE")
    private Date	refTendeOpenDate;
    
    @Column(name = "REG_NUMBER")
    private String	regNumber;
    
//    @Column(name = "FK_STATE_ORG_ID")
//    private Integer fkStateOrgId;
    
    @OneToOne
    @JoinColumn(name="FK_STATE_ORG_ID")
    private StateOrg stateOrg;
    
    
//    @Column(name = "FK_CURRENT_DATA_ID")
//    private Integer fkCurrentDataId;
    
    @OneToOne
    @JoinColumn(name="FK_CURRENT_DATA_ID")
    private TenderData tenderData;
    
    @Column(name = "FK_RESPONSIBLE_ID")
    private Integer fkResponsibleId;
    
    @Column(name = "PERSP_DATA_STATUS")
    private Integer perspDataStatus;
   
    @Lob
    @Column(name = "NOTES")
    private String	notes;
    
    @Column(name = "COMPLAINT_COUNT")
    private Integer complaintCount;
    
//    @Column(name = "FK_OPEN_BULLETIN_ID")
//    private Integer fkOpenBulletinId;
    
    @OneToOne
    @JoinColumn(name="FK_OPEN_BULLETIN_ID")
    private Bulletin bulletin;
    
    @Column(name = "FK_ANNUL_BULLETIN_ID")
    private Integer fkAnnulBulletinId;
    
    @Column(name = "FK_DATA_ID_AT_APPROV")
    private Integer fkDataIdAtApprov;
    
    @Formula(value="(SELECT count(*) FROM CONTRACT contr WHERE contr.FK_TENDER_ID = id)")
    	private Integer contractsCount;
    
    @Formula(value="(SELECT count(*) FROM QUESTION quest WHERE quest.FK_TENDER_ID = id)")
	private Integer questionCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getRefCurrentStatusId() {
//		return refCurrentStatusId;
//	}
//
//	public void setRefCurrentStatusId(Integer refCurrentStatusId) {
//		this.refCurrentStatusId = refCurrentStatusId;
//	}

	
	
	public TenderStatus getTenderStatus() {
		return tenderStatus;
	}

	public void setTenderStatus(TenderStatus tenderStatus) {
		this.tenderStatus = tenderStatus;
	}

	public Date getRefCurrentStatusDate() {
		return refCurrentStatusDate;
	}

	public void setRefCurrentStatusDate(Date refCurrentStatusDate) {
		this.refCurrentStatusDate = refCurrentStatusDate;
	}

	public Integer getFkCurrentStatusId() {
		return fkCurrentStatusId;
	}

	public void setFkCurrentStatusId(Integer fkCurrentStatusId) {
		this.fkCurrentStatusId = fkCurrentStatusId;
	}

//	public Integer getRefTenderTypeId() {
//		return refTenderTypeId;
//	}
//
//	public void setRefTenderTypeId(Integer refTenderTypeId) {
//		this.refTenderTypeId = refTenderTypeId;
//	}
	
	public TenderType getTenderType() {
		return tenderType;
	}

	public void setTenderType(TenderType tenderType) {
		this.tenderType = tenderType;
	}

	public Date getRefTendeOpenDate() {
		return refTendeOpenDate;
	}

	public void setRefTendeOpenDate(Date refTendeOpenDate) {
		this.refTendeOpenDate = refTendeOpenDate;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

//	public Integer getFkStateOrgId() {
//		return fkStateOrgId;
//	}
//
//	public void setFkStateOrgId(Integer fkStateOrgId) {
//		this.fkStateOrgId = fkStateOrgId;
//	}

	public StateOrg getStateOrg() {
		return stateOrg;
	}

	public void setStateOrg(StateOrg stateOrg) {
		this.stateOrg = stateOrg;
	}
	
//	public Integer getFkCurrentDataId() {
//		return fkCurrentDataId;
//	}
//
//	public void setFkCurrentDataId(Integer fkCurrentDataId) {
//		this.fkCurrentDataId = fkCurrentDataId;
//	}

	public Integer getFkResponsibleId() {
		return fkResponsibleId;
	}

	public void setFkResponsibleId(Integer fkResponsibleId) {
		this.fkResponsibleId = fkResponsibleId;
	}

	public Integer getPerspDataStatus() {
		return perspDataStatus;
	}

	public void setPerspDataStatus(Integer perspDataStatus) {
		this.perspDataStatus = perspDataStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getComplaintCount() {
		return complaintCount;
	}

	public void setComplaintCount(Integer complaintCount) {
		this.complaintCount = complaintCount;
	}

//	public Integer getFkOpenBulletinId() {
//		return fkOpenBulletinId;
//	}
//
//	public void setFkOpenBulletinId(Integer fkOpenBulletinId) {
//		this.fkOpenBulletinId = fkOpenBulletinId;
//	}

	public Integer getFkAnnulBulletinId() {
		return fkAnnulBulletinId;
	}

	public void setFkAnnulBulletinId(Integer fkAnnulBulletinId) {
		this.fkAnnulBulletinId = fkAnnulBulletinId;
	}

	public Integer getFkDataIdAtApprov() {
		return fkDataIdAtApprov;
	}

	public void setFkDataIdAtApprov(Integer fkDataIdAtApprov) {
		this.fkDataIdAtApprov = fkDataIdAtApprov;
	}

	public TenderData getTenderData() {
		return tenderData;
	}

	public void setTenderData(TenderData tenderData) {
		this.tenderData = tenderData;
	}

	public Bulletin getBulletin() {
		return bulletin;
	}

	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	public Integer getContractsCount() {
		return contractsCount;
	}

	public void setContractsCount(Integer contractsCount) {
		this.contractsCount = contractsCount;
	}

	public Integer getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	
}

/*
Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt
ID	1	1	N	NUMBER (19)		None		
REF_CURRENT_STATUS_ID	2		Y	NUMBER (19)		None		
CURRENT_STATUS_DATE	3		Y	TIMESTAMP(6)		None
FK_CURRENT_STATUS_ID	4		Y	NUMBER (19)		None		
REF_TENDER_TYPE_ID	5		Y	NUMBER (19)		None		
TENDER_OPEN_DATE	6		Y	TIMESTAMP(6)		None		
REG_NUMBER	7		Y	VARCHAR2 (8 Char)		None		
FK_STATE_ORG_ID	8		Y	NUMBER (19)		None		
FK_CURRENT_DATA_ID	9		Y	NUMBER (19)		None		
FK_RESPONSIBLE_ID	10		Y	NUMBER (19)		None		
PERSP_DATA_STATUS	11		Y	NUMBER (19)		None		
NOTES	12		Y	CLOB		None		
COMPLAINT_COUNT	13		Y	INTEGER		None		
FK_OPEN_BULLETIN_ID	14		Y	NUMBER (19)		None		
FK_ANNUL_BULLETIN_ID	15		Y	NUMBER (19)		None		
FK_DATA_ID_AT_APPROV	16		Y	NUMBER (19)		None		
*/
