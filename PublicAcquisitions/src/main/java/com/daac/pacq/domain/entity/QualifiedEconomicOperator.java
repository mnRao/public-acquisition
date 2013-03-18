package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "QUALIFIED_OPERATOR")
public class QualifiedEconomicOperator extends AbstractEconomicOperator {

	   @Column(name = "ACTIVITIES")
	    private String activities;    
	   
	   @Column(name = "ADVERTISEMENT")
	    private String advertisment;

	public String getActivities() {
		return activities;
	}

	public void setActivities(String activities) {
		this.activities = activities;
	}

	public String getAdvertisment() {
		return advertisment;
	}

	public void setAdvertisment(String advertisment) {
		this.advertisment = advertisment;
	}    	   

}


/*


Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt

ACTIVITIES			12		Y	CLOB		None		
ADVERTISEMENT		13		Y	CLOB		None		

*/