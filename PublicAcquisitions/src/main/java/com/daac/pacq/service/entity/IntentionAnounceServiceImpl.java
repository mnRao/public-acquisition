package com.daac.pacq.service.entity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.IntentionAnounceDAO;
import com.daac.pacq.domain.entity.IntentionAnounce;

@Service
public class IntentionAnounceServiceImpl implements IntentionAnounceService {

	@Autowired
	private IntentionAnounceDAO dao;
	
	@Transactional
	public IntentionAnounce		get(Integer id){
		System.out.println("IntentionAnounceServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<IntentionAnounce> list() {
		System.out.println("IntentionAnounceServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<IntentionAnounce> filter(String filterString) {
		System.out.println("IntentionAnounceServiceImpl - filter");
		return dao.filter(filterString);
	}
 
	@Transactional
	public List<IntentionAnounce> search(Map<String, String[]> filtersMap){
		System.out.println("IntentionAnounceServiceImpl - search");
		return dao.search(filtersMap);
	}

	
}
