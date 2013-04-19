package com.daac.pacq.service.entity;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.VisitsDAO;
import com.daac.pacq.domain.entity.Visits;

@Service
public class VisitsServiceImpl implements VisitsService {

	@Autowired
	private VisitsDAO dao;
	
	@Transactional
	public Visits		get(Date id){
		System.out.println("VisitsServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public void add(Visits item) {
		dao.add(item);
	}

	@Transactional
	public void update(Visits item) {
		dao.update(item);	
	}
	

 
}
