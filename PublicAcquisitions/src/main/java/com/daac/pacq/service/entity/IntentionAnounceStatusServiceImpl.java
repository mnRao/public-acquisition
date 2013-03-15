package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.IntentionAnounceStatusDAO;
import com.daac.pacq.domain.entity.IntentionAnounceStatus;

@Service
public class IntentionAnounceStatusServiceImpl implements IntentionAnounceStatusService {

	@Autowired
	private IntentionAnounceStatusDAO dao;
	
	@Transactional
	public IntentionAnounceStatus 		get(Integer id){
		System.out.println("IntentionAnounceStatusServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<IntentionAnounceStatus> list() {
		System.out.println("IntentionAnounceStatusServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<IntentionAnounceStatus> filter(String filterString) {
		System.out.println("IntentionAnounceStatusServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
