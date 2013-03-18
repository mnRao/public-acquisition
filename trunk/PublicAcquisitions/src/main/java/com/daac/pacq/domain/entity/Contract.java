package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "CONTRACT")
public class Contract {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "REF_CURRENT_STATUS_ID") 
    private Integer currentStatusId;

    @Column(name = "CURRENT_STATUS_DATE") 
    private Date currentStatusDate;
    
    @Column(name = "FK_CURRENT_STATUS_ID") 
    private Integer fkCurrentStatusId;
    
    @Column(name = "FK_TENDER_ID") 
    private Integer fkTenderId;
    
    @Column(name = "REF_CONTR_TYPE_ID") 
    private Integer contrTypeId;    

    @Column(name = "FK_BASE_CONTRACT_ID") 
    private Integer fkBaseContractId;  
    
    @Column(name = "CONTRACT_NUMBER") 
    private String contract_Number;  
    
    @Column(name = "CONTRACT_DATE") 
    private Date contractDate;  
    
    @Column(name = "AMOUNT") 
    private Float amount;  

    @Column(name = "FK_PARTICIPANT_ID") 
    private Integer fkParticipantId;
    
    @Column(name = "FK_OFFER_ID") 
    private Integer fkOfferId;
    
    @Column(name = "FK_DECISION_ID") 
    private Integer fkDecisionId;
    
    @Column(name = "REGISTER_DATE") 
    private Date registerDate;
    
    @Column(name = "FINAL_DATE") 
    private Date finalDate;
    
    @Column(name = "CONTRACT_REAL_NUMBER") 
    private String contractRealNumber;
    
    @Column(name = "ADD_ACCORD_REASON_DOCUMENTS") 
    private String addAccordReasonDocuments;

    @Column(name = "ADD_ACCORD_REASON") 
    private String addAccordReason;
    
    @Column(name = "ADD_ACCORD_SHORT_DESCR") 
    private String addAccordShortDescr;
    
    @Column(name = "INDIVIDUAL_CONTRACTS_QUANTITY") 
    private Integer individualContractsQuantity;
    
    @Column(name = "FK_REF_GOODS") 
    private Integer fkRefGoods;
    
    @Column(name = "NOTE") 
    private String note;
    
    @Column(name = "FK_TENDER_DOC_CONTRACT_SCAN") 
    private Integer fkTenderDocContractScan;
    
    @Column(name = "FK_TENDER_DOC_DECIPHERING_IND") 
    private Integer fkTenderDocDecipheringId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCurrentStatusId() {
		return currentStatusId;
	}

	public void setCurrentStatusId(Integer currentStatusId) {
		this.currentStatusId = currentStatusId;
	}

	public Date getCurrentStatusDate() {
		return currentStatusDate;
	}

	public void setCurrentStatusDate(Date currentStatusDate) {
		this.currentStatusDate = currentStatusDate;
	}

	public Integer getFkCurrentStatusId() {
		return fkCurrentStatusId;
	}

	public void setFkCurrentStatusId(Integer fkCurrentStatusId) {
		this.fkCurrentStatusId = fkCurrentStatusId;
	}

	public Integer getFkTenderId() {
		return fkTenderId;
	}

	public void setFkTenderId(Integer fkTenderId) {
		this.fkTenderId = fkTenderId;
	}

	public Integer getContrTypeId() {
		return contrTypeId;
	}

	public void setContrTypeId(Integer contrTypeId) {
		this.contrTypeId = contrTypeId;
	}

	public Integer getFkBaseContractId() {
		return fkBaseContractId;
	}

	public void setFkBaseContractId(Integer fkBaseContractId) {
		this.fkBaseContractId = fkBaseContractId;
	}

	public String getContract_Number() {
		return contract_Number;
	}

	public void setContract_Number(String contract_Number) {
		this.contract_Number = contract_Number;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Integer getFkParticipantId() {
		return fkParticipantId;
	}

	public void setFkParticipantId(Integer fkParticipantId) {
		this.fkParticipantId = fkParticipantId;
	}

	public Integer getFkOfferId() {
		return fkOfferId;
	}

	public void setFkOfferId(Integer fkOfferId) {
		this.fkOfferId = fkOfferId;
	}

	public Integer getFkDecisionId() {
		return fkDecisionId;
	}

	public void setFkDecisionId(Integer fkDecisionId) {
		this.fkDecisionId = fkDecisionId;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public String getContractRealNumber() {
		return contractRealNumber;
	}

	public void setContractRealNumber(String contractRealNumber) {
		this.contractRealNumber = contractRealNumber;
	}

	public String getAddAccordReasonDocuments() {
		return addAccordReasonDocuments;
	}

	public void setAddAccordReasonDocuments(String addAccordReasonDocuments) {
		this.addAccordReasonDocuments = addAccordReasonDocuments;
	}

	public String getAddAccordReason() {
		return addAccordReason;
	}

	public void setAddAccordReason(String addAccordReason) {
		this.addAccordReason = addAccordReason;
	}

	public String getAddAccordShortDescr() {
		return addAccordShortDescr;
	}

	public void setAddAccordShortDescr(String addAccordShortDescr) {
		this.addAccordShortDescr = addAccordShortDescr;
	}

	public Integer getIndividualContractsQuantity() {
		return individualContractsQuantity;
	}

	public void setIndividualContractsQuantity(Integer individualContractsQuantity) {
		this.individualContractsQuantity = individualContractsQuantity;
	}

	public Integer getFkRefGoods() {
		return fkRefGoods;
	}

	public void setFkRefGoods(Integer fkRefGoods) {
		this.fkRefGoods = fkRefGoods;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getFkTenderDocContractScan() {
		return fkTenderDocContractScan;
	}

	public void setFkTenderDocContractScan(Integer fkTenderDocContractScan) {
		this.fkTenderDocContractScan = fkTenderDocContractScan;
	}

	public Integer getFkTenderDocDecipheringId() {
		return fkTenderDocDecipheringId;
	}

	public void setFkTenderDocDecipheringId(Integer fkTenderDocDecipheringId) {
		this.fkTenderDocDecipheringId = fkTenderDocDecipheringId;
	}

   
    
	
}
