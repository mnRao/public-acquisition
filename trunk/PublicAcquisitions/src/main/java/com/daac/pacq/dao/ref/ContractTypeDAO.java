package com.daac.pacq.dao.ref;

import java.util.List;

import com.daac.pacq.domain.ref.ContractType;

public interface ContractTypeDAO {

	public ContractType			get(Integer id);
	public List<ContractType> 	list();
	public List<ContractType> 	filter(String filterString);
}
