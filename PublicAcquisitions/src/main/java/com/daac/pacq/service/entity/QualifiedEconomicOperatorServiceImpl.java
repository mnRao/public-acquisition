package com.daac.pacq.service.entity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.QualifiedEconomicOperatorDAO;
import com.daac.pacq.domain.entity.QualifiedEconomicOperator;

@Service
public class QualifiedEconomicOperatorServiceImpl implements QualifiedEconomicOperatorService {

	@Autowired
	private QualifiedEconomicOperatorDAO dao;
	
	@Transactional
	public QualifiedEconomicOperator		get(Integer id){
		System.out.println("QualifiedEconomicOperatorServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<QualifiedEconomicOperator> list() {
		System.out.println("QualifiedEconomicOperatorServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<QualifiedEconomicOperator> filter(String filterString) {
		System.out.println("QualifiedEconomicOperatorServiceImpl - filter");
		return dao.filter(filterString);
	}
 	
	@Transactional
	public List<QualifiedEconomicOperator>			search(Map<String, String[]> filtersMap) {
		System.out.println("QualifiedEconomicOperatorServiceImpl - filter");
		return dao.search(filtersMap);
	}
}
