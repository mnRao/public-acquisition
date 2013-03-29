package com.daac.pacq.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.daac.pacq.helpers.CustomDateSerializer;


@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @Column(name = "ID")
    @GeneratedValue 
    private Integer id;
    
    @Column(name = "QUESTION_NUMB")
    private String questionNumb;
    
    @Column(name = "QUESTION_TEXT")
    private String questionText;
    
    @Column(name = "ASKED_DATE")
    private Date askedDate;

    @Column(name = "ANSWER_TEXT")
    private String answerText;
    
    @Column(name = "FK_TENDER_ID")
    private String fkTenerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionNumb() {
		return questionNumb;
	}

	public void setQuestionNumber(String questionNumb) {
		this.questionNumb = questionNumb;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@JsonSerialize (using = CustomDateSerializer.class)
	public Date getAskedDate() {
		return askedDate;
	}

	public void setAskedDate(Date askedDate) {
		this.askedDate = askedDate;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getFkTenerId() {
		return fkTenerId;
	}

	public void setFkTenerId(String fkTenerId) {
		this.fkTenerId = fkTenerId;
	}

    
	
	
}

/*
  ID                 NUMBER(19)                 NOT NULL,
  QUESTION_NUMB      VARCHAR2(12 CHAR),
  QUESTION_TEXT      CLOB,
  ASKED_DATE         TIMESTAMP(6),
  ASKED_USER         VARCHAR2(255 CHAR),
  ANSWER_TEXT        CLOB,
  ANSWERED_DATE      TIMESTAMP(6),
  ANSWERED_USER      VARCHAR2(255 CHAR),
  FK_TENDER_ID       NUMBER(19),
  FK_PARTICIPANT_ID  NUMBER(19),
  DIRECTION          NUMBER(10)	
*/
