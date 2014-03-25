package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.TenderDocumentDAO;
import com.daac.pacq.domain.entity.TenderDocument;

@Service
public class TenderDocumentServiceImpl implements TenderDocumentService {

	@Autowired
	private TenderDocumentDAO dao;
	
	@Transactional
	public TenderDocument		get(Integer id){
		System.out.println("TenderDocumentServiceImpl - get ");		
		return dao.get(id);
	}
	
	@Transactional
	public List<TenderDocument> list(Integer id) {
		System.out.println("TenderDocumentServiceImpl - list");
		return dao.list(id);
	}

	@Transactional
	public List<TenderDocument> filter(String filterString) {
		System.out.println("TenderDocumentServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
