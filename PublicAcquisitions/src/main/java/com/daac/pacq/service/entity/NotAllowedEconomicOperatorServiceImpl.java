package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.NotAllowedEconomicOperatorDAO;
import com.daac.pacq.domain.entity.NotAllowedEconomicOperator;

@Service
public class NotAllowedEconomicOperatorServiceImpl implements NotAllowedEconomicOperatorService {

	@Autowired
	private NotAllowedEconomicOperatorDAO dao;
	
	@Transactional
	public NotAllowedEconomicOperator		get(Integer id){
		System.out.println("NotAllowedEconomicOperatorServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<NotAllowedEconomicOperator> list() {
		System.out.println("NotAllowedEconomicOperatorServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<NotAllowedEconomicOperator> filter(String filterString) {
		System.out.println("NotAllowedEconomicOperatorServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
