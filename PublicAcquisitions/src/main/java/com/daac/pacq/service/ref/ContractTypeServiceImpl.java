package com.daac.pacq.service.ref;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.ref.ContractTypeDAO;
import com.daac.pacq.domain.ref.ContractType;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {

	@Autowired
	private ContractTypeDAO dao;
	
	@Transactional
	public ContractType 		get(Integer id){
		System.out.println("ContractTypeServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<ContractType> list() {
		System.out.println("ContractTypeServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<ContractType> filter(String filterString) {
		System.out.println("ContractTypeServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
