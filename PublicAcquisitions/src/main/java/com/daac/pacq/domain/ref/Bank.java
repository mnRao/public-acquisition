package com.daac.pacq.domain.ref;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REF_BANK")
public class Bank  extends AbstractRefEntity  {
	
    @Column(name = "MD_SHORT")
    private String mdShort;
    
    @Column(name = "RU_SHORT")
    private String ruShort;
    
    @Column(name = "EN_SHORT")
    private String enShort;
    
    @Column(name = "MFO_CODE")
    private String mfoCode;
    
    @Column(name = "FISCAL_CODE")
    private String fiscalCode;
    
    @Column(name = "SAPI_CODE")
    private String sapiCode;

	public String getMdShort() {
		return mdShort;
	}

	public void setMdShort(String mdShort) {
		this.mdShort = mdShort;
	}

	public String getRuShort() {
		return ruShort;
	}

	public void setRuShort(String ruShort) {
		this.ruShort = ruShort;
	}

	public String getEnShort() {
		return enShort;
	}

	public void setEnShort(String enShort) {
		this.enShort = enShort;
	}

	public String getMfoCode() {
		return mfoCode;
	}

	public void setMfoCode(String mfoCode) {
		this.mfoCode = mfoCode;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getSapiCode() {
		return sapiCode;
	}

	public void setSapiCode(String sapiCode) {
		this.sapiCode = sapiCode;
	}
	
    
    
}
