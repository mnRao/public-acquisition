package com.daac.pacq.service.ref;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.ref.IntentionStatusDAO;
import com.daac.pacq.domain.ref.IntentionStatus;

@Service
public class IntentionStatusServiceImpl implements IntentionStatusService {

	@Autowired
	private IntentionStatusDAO dao;
	
	@Transactional
	public IntentionStatus 		get(Integer id){
		System.out.println("IntentionStatusServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<IntentionStatus> list() {
		System.out.println("IntentionStatusServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<IntentionStatus> filter(String filterString) {
		System.out.println("IntentionStatusServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
