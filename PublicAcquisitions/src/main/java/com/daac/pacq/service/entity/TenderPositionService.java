package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.TenderPosition;

public interface TenderPositionService {

	public TenderPosition 		get(Integer id);
	public List<TenderPosition> list(Integer id);
	public List<TenderPosition> filter(String filterString);
}
