package com.daac.pacq.service.ref;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.ref.TenderStatusDAO;
import com.daac.pacq.domain.ref.TenderStatus;

@Service
public class TenderStatusServiceImpl implements TenderStatusService {

	@Autowired
	private TenderStatusDAO dao;
	
	@Transactional
	public TenderStatus 		get(Integer id){
		System.out.println("TenderStatusServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<TenderStatus> list() {
		System.out.println("TenderStatusServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<TenderStatus> filter(String filterString) {
		System.out.println("TenderStatusServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
