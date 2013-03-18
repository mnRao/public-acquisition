package com.daac.pacq.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.domain.ref.OrgLegalForm;
import com.daac.pacq.domain.ref.TenderType;
import com.daac.pacq.helpers.CustomDateSerializer;

@Entity
@Table(name = "INTENTION_ANOUNCE")
public class IntentionAnounce {
	
    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "REG_NUMBER")
    private String  		regNumber;
    
    @Column(name = "PURCHASE_QUARTER")
    private String  		purchaseQuarter;
    
    @OneToOne
    @JoinColumn(name="REF_TENDER_TYPE_ID")
    private TenderType tenderType;
    
    @Column(name = "REF_POSITION_TYPE_ID")
    private Integer 		refPositinTypeId;
		
    @Column(name = "POSITION_DESCR")
    private String  		positionDescr;    
    
    @Column(name = "FOR_WHO_PURCHASE")
    private String  		forWhoPurchase;

    @Column(name = "PLANNED_SUM")
    private Integer 		plannedSum;
    
    @Column(name = "PURCHASER_COMMENT")
    private String  		purchaserComment;
    
    @Column(name = "BULLETIN_PUBLISH_DATE")
    private Date 			bulletinPublishDate;

    @Column(name = "BULLETIN_NUMBER")
    private String  		bulletinNumber;
    
    @Column(name = "IS_PUBLISHED")
    private Integer 		isPublished;
    
    @Column(name = "STATE_ORG_COMMENT")
    private String  		stateOrgComment;
    
    @Column(name = "FK_BUDGET_PERIOD_ID")
    private Integer 		fkBudgetPeriodId;
    
    
//    @Column(name = "FK_CURRENT_STATUS_ID")
//    private Integer 		fkCurrentStatusId;
    
    @OneToOne
    @JoinColumn(name="FK_CURRENT_STATUS_ID")
    private IntentionAnounceStatus currentStatus;
    
    
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="INTENTION_ANOUNCE_ID", nullable=false)
    private List<IntentionAnounceStatus> 		intentionAnounceStatus;
    
    
//    @Column(name = "FK_STATE_ORG_ID")
//    private Integer 		fkStateOrgId;
    
    @OneToOne
    @JoinColumn(name="FK_STATE_ORG_ID")
    private StateOrg stateOrg;
    
    
    @Column(name = "PUBLISH_DATE")
    private Date 			publishDate;
    
    @Column(name = "REF_GOODS_ID")
    private Integer 		refGoodsId;

    @Column(name = "FK_BULLETIN_ID")
    private Integer 		fkBulletinId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public String getPurchaseQuarter() {
		return purchaseQuarter;
	}

	public void setPurchaseQuarter(String purchaseQuarter) {
		this.purchaseQuarter = purchaseQuarter;
	}


	public TenderType getTenderType() {
		return tenderType;
	}

	public void setTenderType(TenderType tenderType) {
		this.tenderType = tenderType;
	}

	public Integer getRefPositinTypeId() {
		return refPositinTypeId;
	}

	public void setRefPositinTypeId(Integer refPositinTypeId) {
		this.refPositinTypeId = refPositinTypeId;
	}

	public String getPositionDescr() {
		return positionDescr;
	}

	public void setPositionDescr(String positionDescr) {
		this.positionDescr = positionDescr;
	}

	public String getForWhoPurchase() {
		return forWhoPurchase;
	}

	public void setForWhoPurchase(String forWhoPurchase) {
		this.forWhoPurchase = forWhoPurchase;
	}

	public Integer getPlannedSum() {
		return plannedSum;
	}

	public void setPlannedSum(Integer plannedSum) {
		this.plannedSum = plannedSum;
	}

	public String getPurchaserComment() {
		return purchaserComment;
	}

	public void setPurchaserComment(String purchaserComment) {
		this.purchaserComment = purchaserComment;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getBulletinPublishDate() {
		return bulletinPublishDate;
	}

	public void setBulletinPublishDate(Date bulletinPublishDate) {
		this.bulletinPublishDate = bulletinPublishDate;
	}

	public String getBulletinNumber() {
		return bulletinNumber;
	}

	public void setBulletinNumber(String bulletinNumber) {
		this.bulletinNumber = bulletinNumber;
	}

	public Integer getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Integer isPublished) {
		this.isPublished = isPublished;
	}

	public String getStateOrgComment() {
		return stateOrgComment;
	}

	public void setStateOrgComment(String stateOrgComment) {
		this.stateOrgComment = stateOrgComment;
	}

	public Integer getFkBudgetPeriodId() {
		return fkBudgetPeriodId;
	}

	public void setFkBudgetPeriodId(Integer fkBudgetPeriodId) {
		this.fkBudgetPeriodId = fkBudgetPeriodId;
	}

	public IntentionAnounceStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(IntentionAnounceStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	public List<IntentionAnounceStatus> getIntentionAnounceStatus() {
		return intentionAnounceStatus;
	}

	public void setIntentionAnounceStatus(
			List<IntentionAnounceStatus> intentionAnounceStatus) {
		this.intentionAnounceStatus = intentionAnounceStatus;
	}

//	public Integer getFkStateOrgId() {
//		return fkStateOrgId;
//	} 
//
//	public void setFkStateOrgId(Integer fkStateOrgId) {
//		this.fkStateOrgId = fkStateOrgId;
//	}

	
	
	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getPublishDate() {
		return publishDate;
	}

	public StateOrg getStateOrg() {
		return stateOrg;
	}

	public void setStateOrg(StateOrg stateOrg) {
		this.stateOrg = stateOrg;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getRefGoodsId() {
		return refGoodsId;
	}

	public void setRefGoodsId(Integer refGoodsId) {
		this.refGoodsId = refGoodsId;
	}

	public Integer getFkBulletinId() {
		return fkBulletinId;
	}

	public void setFkBulletinId(Integer fkBulletinId) {
		this.fkBulletinId = fkBulletinId;
	}

    

}


/*   

Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt

ID						1		N	NUMBER (19)		None		
REG_NUMBER				2		Y	VARCHAR2 (8 Char)		Height Balanced		
PURCHASE_QUARTER		3		Y	VARCHAR2 (20 Char)		None		
REF_TENDER_TYPE_ID		4		Y	NUMBER (19)		Frequency		
REF_POSITION_TYPE_ID	5		Y	NUMBER (19)		Frequency		
POSITION_DESCR			6		Y	CLOB		None		
FOR_WHO_PURCHASE		7		Y	VARCHAR2 (200 Char)		None		
PLANNED_SUM				8		Y	NUMBER (15,2)		None		
PURCHASER_COMMENT		9		Y	CLOB		None		
BULLETIN_PUBLISH_DATE	10		Y	TIMESTAMP(6)		Frequency		
BULLETIN_NUMBER			11		Y	VARCHAR2 (25 Char)		Frequency		
IS_PUBLISHED			12		Y	NUMBER (10)		None		
STATE_ORG_COMMENT		13		Y	CLOB		None		
FK_BUDGET_PERIOD_ID		14		Y	NUMBER (19)		Frequency		
FK_CURRENT_STATUS_ID	15		Y	NUMBER (19)		Frequency		
FK_STATE_ORG_ID			16		Y	NUMBER (19)		Frequency		
PUBLISH_DATE			17		Y	TIMESTAMP(6)		Frequency		
REF_GOODS_ID			18		Y	NUMBER		Frequency		
FK_BULLETIN_ID			19		Y	NUMBER		Frequency		


*/