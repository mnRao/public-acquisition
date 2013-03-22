package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.domain.ref.DeliveryTerms;
import com.daac.pacq.domain.ref.Language;
import com.daac.pacq.domain.ref.Status;
import com.daac.pacq.helpers.CustomDateSerializer;
import com.daac.pacq.helpers.CustomDateTimeSerializer;


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
    
    @Column(name="FOR_WHO_PURCHASE")
    private String forWhoPurchase;
    
//    @Column(name="REF_LANGUAGE_ID")
//    private Integer refLanguageId;
    
    @OneToOne
    @JoinColumn(name="REF_LANGUAGE_ID")
    private Language language;
    
//  @Column(name="REF_DELIVERY_TERMS")
//  private Integer refDeliveryTerms;
  
  @OneToOne
  @JoinColumn(name="REF_DELIVERY_TERMS_ID")
  private DeliveryTerms deliveryTerms;    
    
  @Column(name="PRES_OFFERS_PLACE")
  private String pressOffersPlace;
  
  @Column(name="PRES_OFFERS_DATE")
  private Date pressOffersDate;
  
  @Column(name="OPEN_DATE_TIME")
  private Date openDateTime;
  
  @Column(name="DELIVERY_DATE")
  private String deliveryDate;
  
  @Column(name="OFFER_ESTIMATE_BY_PRICE")
  private Integer offerEstimateByPrice;
  
  @Column(name="FOR_RESIDENTS_ONLY_REASON")
  private String forResidenceOnlyReason;
  
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

	public String getForWhoPurchase() {
		return forWhoPurchase;
	}

	public void setForWhoPurchase(String forWhoPurchase) {
		this.forWhoPurchase = forWhoPurchase;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public DeliveryTerms getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(DeliveryTerms deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public String getPressOffersPlace() {
		return pressOffersPlace;
	}

	public void setPressOffersPlace(String pressOffersPlace) {
		this.pressOffersPlace = pressOffersPlace;
	}

	@JsonSerialize (using = CustomDateTimeSerializer.class)
	public Date getPressOffersDate() {
		return pressOffersDate;
	}

	public void setPressOffersDate(Date pressOffersDate) {
		this.pressOffersDate = pressOffersDate;
	}

	@JsonSerialize (using = CustomDateTimeSerializer.class)
	public Date getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getOfferEstimateByPrice() {
		return offerEstimateByPrice;
	}

	public void setOfferEstimateByPrice(Integer offerEstimateByPrice) {
		this.offerEstimateByPrice = offerEstimateByPrice;
	}

	public String getForResidenceOnlyReason() {
		return forResidenceOnlyReason;
	}

	public void setForResidenceOnlyReason(String forResidenceOnlyReason) {
		this.forResidenceOnlyReason = forResidenceOnlyReason;
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