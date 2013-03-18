package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class BudgetPeriod {

    @Id
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "YEAR")
    private Integer year;
    
    @Column(name = "AMOUNT")
    private Float amount;
    
    @Column(name = "FK_INTENTION_ID")
    private Integer intentionId;
    
    @Column(name = "FK_TENDER_DATA_ID")
    private Integer tenderDataId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Integer getIntentionId() {
		return intentionId;
	}

	public void setIntentionId(Integer intentionId) {
		this.intentionId = intentionId;
	}

	public Integer getTenderDataId() {
		return tenderDataId;
	}

	public void setTenderDataId(Integer tenderDataId) {
		this.tenderDataId = tenderDataId;
	}
 
    
}
