package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "VISITS")
public class Visits {
		
	@Id
	@Column(name = "VISIT_DATE")
	@Type(type="timestamp")
    private Date visitDate = new Date();
			
	@Column(name = "COUNT")
    private Integer count;
	
	@Formula(value="(SELECT sum(COUNT) FROM VISITS)")
   	private Integer countTotal;

	
	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(Integer countTotal) {
		this.countTotal = countTotal;
	}					

	public String toString(){
		return "visitDate :" + this.visitDate.toString() + "\n count :" + this.count  +
				"\n countTotal :" + this.countTotal;
	}
	
	public void increaseCounter(){
		this.count ++;
	}	
	
}
