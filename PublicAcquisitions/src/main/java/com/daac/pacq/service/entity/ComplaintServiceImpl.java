package com.daac.pacq.service.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daac.pacq.dao.entity.ComplaintDAO;
import com.daac.pacq.domain.entity.Complaint;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintDAO dao;
	
	@Transactional
	public Complaint		get(Integer id){
		System.out.println("ComplaintServiceImpl - get");		
		return dao.get(id);
	}
	
	@Transactional
	public List<Complaint> list() {
		System.out.println("ComplaintServiceImpl - list");
		return dao.list();
	}

	@Transactional
	public List<Complaint> filter(String filterString) {
		System.out.println("ComplaintServiceImpl - filter");
		return dao.filter(filterString);
	}
 
}
