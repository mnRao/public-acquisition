package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TENDER")
public class TenderShort {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @OneToOne
    @JoinColumn(name="FK_STATE_ORG_ID")
    private StateOrg stateOrg;
    
    @OneToOne
    @JoinColumn(name="FK_CURRENT_DATA_ID")
    private TenderDataShort tenderData;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StateOrg getStateOrg() {
		return stateOrg;
	}

	public void setStateOrg(StateOrg stateOrg) {
		this.stateOrg = stateOrg;
	}

	public TenderDataShort getTenderData() {
		return tenderData;
	}

	public void setTenderData(TenderDataShort tenderData) {
		this.tenderData = tenderData;
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
