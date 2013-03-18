package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Complaint;

public interface ComplaintService {

	public Complaint 		get(Integer id);
	public List<Complaint>	list();
	public List<Complaint> 	filter(String filterString);
}
