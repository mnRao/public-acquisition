package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.QuestionDAO;
import com.daac.pacq.domain.entity.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAO dao;
	
	@Transactional
	public Question		get(Integer id){
		System.out.println("QuestionServiceImpl - get ");		
		return dao.get(id);
	}
	
	@Transactional
	public List<Question> list(Integer id) {
		System.out.println("QuestionServiceImpl - list");
		return dao.list(id);
	}

	@Transactional
	public List<Question> filter(String filterString) {
		System.out.println("TenderServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
