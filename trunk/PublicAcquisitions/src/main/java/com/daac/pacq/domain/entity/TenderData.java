package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.daac.pacq.domain.ref.Status;


@Entity
@Table(name = "TENDER_DATA")
public class TenderData {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name="GOODS_DESCR")
    private String goodsDescr;

//    @Column(name="REF_CURRENT_STATUS_ID")
//    private String currentStatusId;
    
    @OneToOne
    @JoinColumn(name="REF_CURRENT_STATUS_ID")
    private Status status;
    
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

    
}

/*  ID                             NUMBER(19)     NOT NULL,
  REF_CURRENT_STATUS_ID          NUMBER(19),
  CURRENT_STATUS_DATE            TIMESTAMP(6),
  FK_CURRENT_STATUS_ID           NUMBER(19),
  GOODS_DESCR                    VARCHAR2(250 CHAR),
  FOR_WHO_PURCHASE               VARCHAR2(250 CHAR),
  REF_SOURCE_OF_FINANCE_ID       NUMBER(19),
  PRES_OFFERS_PLACE              VARCHAR2(200 CHAR),
  PRES_OFFERS_DATE               TIMESTAMP(6),
  OPEN_PLACE                     VARCHAR2(200 CHAR),
  OPEN_DATE_TIME                 TIMESTAMP(6),
  PHONE                          VARCHAR2(30 CHAR),
  REF_LANGUAGE_ID                NUMBER(19),
  REF_CURRENCY_ID                NUMBER(19),
  MONEY_HOST                     VARCHAR2(250 CHAR),
  REF_DELIVERY_TERMS_ID          NUMBER(19),
  DELIVERY_DATE                  NVARCHAR2(100),
  PAYMENT_TERMS                  VARCHAR2(100 CHAR),
  OFFER_VALIDITY                 NUMBER(10),
  OFFER_B_WARRANTY               NUMBER(10),
  OFFER_ENSURING_PERCENT         NUMBER(19,2),
  CONTRACT_CONCL_PERIOD          NUMBER(10)     NOT NULL,
  CONTRACT_ENSURING_PERCENT      NUMBER(19,2),
  CONTRACT_B_WARRANTY            NUMBER(10),
  REF_DOC_PAYMENT_BANK_ID        NUMBER(19),
  DOC_PAYMENT_ACCOUNT            VARCHAR2(255 CHAR),
  DOC_PAYMENT_TREASURY_ACC       VARCHAR2(255 CHAR),
  DOC_PAYMENT_FISCAL_CODE        VARCHAR2(255 CHAR),
  REF_OFFER_GUARANT_BANK_ID      NUMBER(19),
  OFFER_GUARANT_ACCOUNT          VARCHAR2(255 CHAR),
  OFFER_GUARANT_TREASURY_ACC     VARCHAR2(255 CHAR),
  OFFER_GUARANT_FISCAL_CODE      VARCHAR2(255 CHAR),
  REF_CONTRACT_GUARANT_BANK_ID   NUMBER(19),
  CONTRACT_GUARANT_ACCOUNT       VARCHAR2(255 CHAR),
  CONTRACT_GUARANT_TREASURY_ACC  VARCHAR2(255 CHAR),
  CONTRACT_GUARANT_FISCAL_CODE   VARCHAR2(255 CHAR),
  GOODS_RECEIVER                 VARCHAR2(250 CHAR),
  PRELIM_SELECT_DATE             TIMESTAMP(6),
  CHANGE_DESCR                   CLOB,
  FK_TENDER_ID                   NUMBER(19),
  FOR_RESIDENTS_ONLY             NUMBER(10),
  FOR_RESIDENTS_ONLY_REASON      CLOB,
  CONTRACT_GUARANT_BANK_ACCOUNT  VARCHAR2(20 CHAR),
  DOC_PAYMENT_BANK_ACCOUNT       VARCHAR2(20 CHAR),
  DOCUMENTS_DISTR_PLACE          VARCHAR2(500 CHAR),
  DOCUMENTS_PRICE                NUMBER(15,2),
  EXPECTED_BUYING_SUMM           NUMBER(15,2),
  FK_BULLETIN_ID                 NUMBER,
  FK_CONTRACT_GUARANT_TREASURE   NUMBER(19),
  FK_DOC_PAYMENT_TREASURE        NUMBER(19),
  FK_GOODS_CATHEGORY             NUMBER,
  FK_OFFER_GUARANT_TREASURE      NUMBER(19),
  OFFER_GUARANT_BANK_ACCOUNT     VARCHAR2(20 CHAR),
  OFFER_ESTIMATE_BY_PRICE        NUMBER(10)*/