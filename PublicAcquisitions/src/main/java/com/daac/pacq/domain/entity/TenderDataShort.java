package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TENDER_DATA")
public class TenderDataShort {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name="GOODS_DESCR")
    private String goodsDescr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsDescr() {
		return goodsDescr;
	}

	public void setGoodsDescr(String goodsDescr) {
		this.goodsDescr = goodsDescr;
	}

    
}

