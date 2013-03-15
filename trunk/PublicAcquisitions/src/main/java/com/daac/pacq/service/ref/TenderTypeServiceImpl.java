package com.daac.pacq.service.ref;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.ref.TenderTypeDAO;
import com.daac.pacq.domain.ref.TenderType;

@Service
public class TenderTypeServiceImpl implements TenderTypeService {

	@Autowired
	private TenderTypeDAO dao;
	
	@Transactional
	public TenderType 		get(Integer id){
		System.out.println("TenderTypeServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<TenderType> list() {
		System.out.println("TenderTypeServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<TenderType> filter(String filterString) {
		System.out.println("TenderTypeServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
