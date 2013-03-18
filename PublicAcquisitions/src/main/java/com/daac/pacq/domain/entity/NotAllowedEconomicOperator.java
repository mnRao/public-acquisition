package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.helpers.CustomDateSerializer;


@Entity
@Table(name = "NOT_ALLOWED_OPERATOR")
public class NotAllowedEconomicOperator extends AbstractEconomicOperator {

    @Column(name = "DISABLE_END_DATE")
    private Date 	disableEndDate;

    @JsonSerialize (using = CustomDateSerializer.class)
	public Date getDisableEndDate() {
		return disableEndDate;
	}

	public void setDisableEndDate(Date disableEndDate) {
		this.disableEndDate = disableEndDate;
	}	
    
}


/*

DISABLE_END_DATE

 */