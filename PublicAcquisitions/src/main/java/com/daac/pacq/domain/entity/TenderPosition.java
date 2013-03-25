package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.daac.pacq.domain.ref.Goods;
import com.daac.pacq.domain.ref.UnitMeasure;


@Entity
@Table(name = "TENDER_POSITION")
public class TenderPosition {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
//    @Column(name = "REF_GOODS_ID")
//    private Integer refGoodsId;
    
    @OneToOne
    @JoinColumn(name="REF_GOODS_ID")
    private Goods goods;
    
    @Column(name = "GOODS_NAME")
    private String goodsName;
    
    @Column(name = "QUANTITY")
    private Float quantity;
    
//    @Column(name = "REF_UNIT_MEASURE_ID")
//    private Integer refUnitMeasureId;
    
    @OneToOne
    @JoinColumn(name="REF_UNIT_MEASURE_ID")
    private UnitMeasure unitMeasure;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "FK_LOT_ID")
    private Integer fkLotId;
    
    @Column(name = "FK_TENDER_DATA_ID")
    private Integer fkTenderDataId ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public UnitMeasure getUnitMeasure() {
		return unitMeasure;
	}

	public void setUnitMeasure(UnitMeasure unitMeasure) {
		this.unitMeasure = unitMeasure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFkLotId() {
		return fkLotId;
	}

	public void setFkLotId(Integer fkLotId) {
		this.fkLotId = fkLotId;
	}

	public Integer getFkTenderDataId() {
		return fkTenderDataId;
	}

	public void setFkTenderDataId(Integer fkTenderDataId) {
		this.fkTenderDataId = fkTenderDataId;
	}
    
}

/*
  ID                   NUMBER(19)               NOT NULL,
  REF_GOODS_ID         NUMBER(19),
  GOODS_NAME           VARCHAR2(250 CHAR),
  QUANTITY             FLOAT(126),
  REF_UNIT_MEASURE_ID  NUMBER(19),
  DESCRIPTION          CLOB,
  FK_LOT_ID            NUMBER(19),
  FK_TENDER_DATA_ID    NUMBER(19)		
*/
