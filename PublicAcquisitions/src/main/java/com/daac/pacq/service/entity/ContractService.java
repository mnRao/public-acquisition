package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Contract;

public interface ContractService {

	public Contract 		get(Integer id);
	public List<Contract > list();
	public List<Contract > filter(String filterString);
}
