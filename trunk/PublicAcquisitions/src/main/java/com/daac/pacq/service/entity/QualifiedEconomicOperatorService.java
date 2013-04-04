package com.daac.pacq.service.entity;

import java.util.List;
import java.util.Map;

import com.daac.pacq.domain.entity.QualifiedEconomicOperator;

public interface QualifiedEconomicOperatorService {

	public QualifiedEconomicOperator 			get(Integer id);
	public List<QualifiedEconomicOperator>		list();
	public List<QualifiedEconomicOperator> 		filter(String filterString);
	public List<QualifiedEconomicOperator>		search(Map<String, String[]> filtersMap);
}
