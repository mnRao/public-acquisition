package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.daac.pacq.domain.ref.OrgLegalForm;
import com.daac.pacq.domain.ref.TenderType;


@Entity
@Table(name = "STATE_ORG")
public class StateOrg {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "CODE")
    private String 	code;

    @Column(name = "ORG_NAME")
    private String 	orgName;
    
    @Column(name = "ADDRESS")
    private String 	address;
    
    @Column(name = "CUTAM")
    private Integer 	cuatm;
    
//    @Column(name = "REF_LEGAL_FORM_ID")
//    private Integer 	refLegalFormId;
    
    @OneToOne
    @JoinColumn(name="REF_LEGAL_FORM_ID")
    private OrgLegalForm orgLegalForm;
      
    @Column(name = "PHONE")
    private String 	phone;
    
    @Column(name = "FAX")
    private String 	fax;
    
    @Column(name = "EMAIL")
    private String 	email;
    
    @Column(name = "REF_BANK_ID")
    private Integer 	refBankId;
    
    @Column(name = "ACCOUNT")
    private String 	account;
    
    @Column(name = "TREASURY_ACC")
    private String 	treasutyAcc;

    @Column(name = "FISCAL_CODE")
    private String 	fiscalCode;

    @Column(name = "BANK_ACCOUNT")
    private String 	bankAccount;

    @Column(name = "FK_REF_TER_DEP_TREASURE")
    private Integer 	fkRefTerDepTreasure;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCuatm() {
		return cuatm;
	}

	public void setCuatm(Integer cuatm) {
		this.cuatm = cuatm;
	}



	public OrgLegalForm getOrgLegalForm() {
		return orgLegalForm;
	}

	public void setOrgLegalForm(OrgLegalForm orgLegalForm) {
		this.orgLegalForm = orgLegalForm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRefBankId() {
		return refBankId;
	}

	public void setRefBankId(Integer refBankId) {
		this.refBankId = refBankId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTreasutyAcc() {
		return treasutyAcc;
	}

	public void setTreasutyAcc(String treasutyAcc) {
		this.treasutyAcc = treasutyAcc;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Integer getFkRefTerDepTreasure() {
		return fkRefTerDepTreasure;
	}

	public void setFkRefTerDepTreasure(Integer fkRefTerDepTreasure) {
		this.fkRefTerDepTreasure = fkRefTerDepTreasure;
	}
 
    
}

/*
Column Name	ID	Pk	Null?	Data Type	Default	Histogram	Encryption Alg	Salt

ID					1	1	N	NUMBER (19)		None		
CODE				2		Y	VARCHAR2 (13 Char)		None		
ORG_NAME			3		Y	VARCHAR2 (250 Char)		None		
ADDRESS				4		Y	VARCHAR2 (250 Char)		None		
CUTAM				5		Y	NUMBER (19)		None		
REF_LEGAL_FORM_ID	6		Y	NUMBER (19)		None		
PHONE				7		Y	VARCHAR2 (30 Char)		None		
FAX					8		Y	VARCHAR2 (30 Char)		None		
EMAIL				9		Y	VARCHAR2 (30 Char)		None		
REF_BANK_ID			10		Y	NUMBER (19)		None		
ACCOUNT				11		Y	VARCHAR2 (20 Char)		None		
TREASURY_ACC		12		Y	VARCHAR2 (20 Char)		None		
FISCAL_CODE			13		Y	VARCHAR2 (20 Char)		None		
BANK_ACCOUNT		14		Y	VARCHAR2 (20 Char)		None		
FK_REF_TER_DEP_TREASURE	15		Y	NUMBER (19)		None		
	
*/
