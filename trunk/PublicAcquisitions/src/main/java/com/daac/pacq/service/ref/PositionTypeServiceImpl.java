package com.daac.pacq.service.ref;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.ref.PositionTypeDAO;
import com.daac.pacq.domain.ref.PositionType;

@Service
public class PositionTypeServiceImpl implements PositionTypeService {

	@Autowired
	private PositionTypeDAO dao;
	
	@Transactional
	public PositionType 		get(Integer id){
		System.out.println("PositionTypeServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<PositionType> list() {
		System.out.println("PositionTypeServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<PositionType> filter(String filterString) {
		System.out.println("PositionTypeServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
