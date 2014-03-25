package com.daac.pacq.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.daac.pacq.domain.ref.Goods;
import com.daac.pacq.domain.ref.UnitMeasure;


@Entity
@Table(name = "TENDER_DOCUMENT")
public class TenderDocument {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "REF_CURRENT_STATUS_ID")
    private Integer refCurrentStatusId;
    
    @Column(name = "DOC_NAME")
    private String docName;
    
    @Column(name = "FILE_NAME")
    private String fileName;
    
    @Column(name = "NUMB_OF_PAGES")
    private Integer numberOfPages;
    
    @Column(name = "VERSION")
    private Integer version;
    
    @Lob
    @Column(name = "CONTENT")
    private byte[] content;

    @Column(name = "CONTENT_SIZE")
    private Integer contentSize;

    @Column(name = "CHANGE_FILE_NAME")
    private String contentFileName;
    
    @Lob
    @Column(name = "CONTENT_CHANGES")
    private byte[] contentChanges;
    
    @Column(name = "FK_TENDER_ID")
    private Integer fkTenderId; 
    
    @Column(name = "DOC_TYPE")
    private Integer docType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRefCurrentStatusId() {
		return refCurrentStatusId;
	}

	public void setRefCurrentStatusId(Integer refCurrentStatusId) {
		this.refCurrentStatusId = refCurrentStatusId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Integer getContentSize() {
		return contentSize;
	}

	public void setContentSize(Integer contentSize) {
		this.contentSize = contentSize;
	}

	public String getContentFileName() {
		return contentFileName;
	}

	public void setContentFileName(String contentFileName) {
		this.contentFileName = contentFileName;
	}

	public byte[] getContentChanges() {
		return contentChanges;
	}

	public void setContentChanges(byte[] contentChanges) {
		this.contentChanges = contentChanges;
	}

	public Integer getFkTenderId() {
		return fkTenderId;
	}

	public void setFkTenderId(Integer fkTenderId) {
		this.fkTenderId = fkTenderId;
	}

	public Integer getDocType() {
		return docType;
	}

	public void setDocType(Integer docType) {
		this.docType = docType;
	} 


  
    
}


