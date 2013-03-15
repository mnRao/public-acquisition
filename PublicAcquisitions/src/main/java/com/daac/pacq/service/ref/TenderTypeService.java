package com.daac.pacq.service.ref;

import java.util.List;

import com.daac.pacq.domain.ref.TenderType;

public interface TenderTypeService {

	public TenderType 		get(Integer id);
	public List<TenderType> list();
	public List<TenderType> filter(String filterString);
}
