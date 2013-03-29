package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.ContractDAO;
import com.daac.pacq.domain.entity.Contract;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractDAO dao;
	
	@Transactional
	public Contract		get(Integer id){
		System.out.println("ContractServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<Contract> list(Integer id) {
		System.out.println("ContractServiceImpl - list");
		return dao.list(id);
	}
	
	@Transactional
	public List<Contract> list() {
		System.out.println("ContractServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<Contract> filter(String filterString) {
		System.out.println("ContractServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
