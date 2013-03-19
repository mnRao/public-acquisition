package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;


@Entity
@Table(name = "PARTICIPANT")
public class Participant {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name="JURISTIC_PERSON")
    private Integer juristicPerson;

    @Column(name="JUR_NAME")
    private String jurName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="PATRONYMIC")
    private String patronymic;

    @Formula(value = "(CASE WHEN (JURISTIC_PERSON=1) THEN JUR_NAME ELSE LAST_NAME||' '||NAME||' '||PATRONYMIC END)")
    private String fullName;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJuristicPerson() {
		return juristicPerson;
	}

	public void setJuristicPerson(Integer juristicPerson) {
		this.juristicPerson = juristicPerson;
	}

	public String getJurName() {
		return jurName;
	}

	public void setJurName(String jurName) {
		this.jurName = jurName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	
}

/*
   ID                       NUMBER(19)           NOT NULL,
  REF_CURRENT_STATUS_ID    NUMBER(19),
  CURRENT_STATUS_DATE      TIMESTAMP(6),
  FK_CURRENT_STATUS_ID     NUMBER(19)           NOT NULL,
  REQUEST_NUMBER           VARCHAR2(12 CHAR),
  ADD_INFO                 CLOB,
  DEBT                     NUMBER(19),
  JURISTIC_PERSON          NUMBER(10),
  CODE                     VARCHAR2(13 CHAR)    NOT NULL,
  REG_BIRTH_DATE           TIMESTAMP(6),
  JUR_NAME                 VARCHAR2(250 CHAR),
  JUR_PREV_NAME            VARCHAR2(250 CHAR),
  REF_LEGAL_FORM_ID        NUMBER(19),
  LAST_NAME                VARCHAR2(30 CHAR),
  NAME                     VARCHAR2(30 CHAR),
  PATRONYMIC               VARCHAR2(30 CHAR),
  PHONE                    VARCHAR2(30 CHAR),
  FAX                      VARCHAR2(30 CHAR),
  EMAIL                    VARCHAR2(30 CHAR),
  ADDRESS                  VARCHAR2(250 CHAR),
  CUTAM                    NUMBER(19),
  REF_DOCUMENT_TYPE_ID     NUMBER(19),
  DOC_NUMBER               VARCHAR2(15 CHAR),
  ISSUE_DATE               TIMESTAMP(6),
  RESIDENT                 NUMBER(10),
  FOUNDERS                 CLOB,
  DIRECTOR_IDNP            VARCHAR2(13 CHAR),
  DIRECTOR                 VARCHAR2(60 CHAR),
  SPONSOR_FIRMS            CLOB,
  NUMB_OF_EMPL             VARCHAR2(15 CHAR),
  NUMB_OF_SPEC             VARCHAR2(15 CHAR),
  WAREHOUSES_PLACING       CLOB,
  MAT_TECH_BASIS           CLOB,
  IMPORT_TURNOVER          CLOB,
  INTERNAL_TURNOVER        CLOB,
  PROD_VOLUME              CLOB,
  REF_BANK_ID              NUMBER(19),
  ACCOUNT                  VARCHAR2(20 CHAR),
  TREASURY_ACC             VARCHAR2(20 CHAR),
  FISCAL_CODE              VARCHAR2(20 CHAR),
  C_ADDRESS                VARCHAR2(255 CHAR),
  C_CUTAM                  NUMBER(19),
  FK_E_OPERATOR_ID         NUMBER(19),
  FK_TENDER_ID             NUMBER(19),
  FK_UNION_ID              NUMBER(19),
  UNION_MAIN               NUMBER(10),
  BANK_ACCOUNT             VARCHAR2(20 CHAR),
  FK_REF_TER_DEP_TREASURE  NUMBER(19),
  PARTICIPATING_PERCENT    NUMBER(15,2),
  ANNULED                  NUMBER(19)
 */
 