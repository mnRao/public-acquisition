package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.NotAllowedEconomicOperator;

public interface NotAllowedEconomicOperatorService {

	public NotAllowedEconomicOperator 			get(Integer id);
	public List<NotAllowedEconomicOperator>		list();
	public List<NotAllowedEconomicOperator> 	filter(String filterString);
}
