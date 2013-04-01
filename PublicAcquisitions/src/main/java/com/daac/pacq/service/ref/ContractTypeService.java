package com.daac.pacq.service.ref;

import java.util.List;

import com.daac.pacq.domain.ref.ContractType;

public interface ContractTypeService {

	public ContractType 		get(Integer id);
	public List<ContractType> 	list();
	public List<ContractType> 	filter(String filterString);
}
