package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.TenderDAO;
import com.daac.pacq.domain.entity.Tender;

@Service
public class TenderServiceImpl implements TenderService {

	@Autowired
	private TenderDAO dao;
	
	@Transactional
	public Tender		get(Integer id){
		System.out.println("TenderServiceImpl - get ");		
		return dao.get(id);
	}
	
	@Transactional
	public List<Tender> list() {
		System.out.println("TenderServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<Tender> filter(String filterString) {
		System.out.println("TenderServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
