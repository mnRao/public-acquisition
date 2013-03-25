package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.TenderPositionDAO;
import com.daac.pacq.domain.entity.TenderPosition;

@Service
public class TenderPositionServiceImpl implements TenderPositionService {

	@Autowired
	private TenderPositionDAO dao;
	
	@Transactional
	public TenderPosition		get(Integer id){
		System.out.println("TenderPositionServiceImpl - get ");		
		return dao.get(id);
	}
	
	@Transactional
	public List<TenderPosition> list(Integer id) {
		System.out.println("TenderPositionServiceImpl - list");
		return dao.list(id);
	}

	@Transactional
	public List<TenderPosition> filter(String filterString) {
		System.out.println("TenderServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
