package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Tender;

public interface TenderService {

	public Tender 		get(Integer id);
	public List<Tender> list();
	public List<Tender> filter(String filterString);
}
