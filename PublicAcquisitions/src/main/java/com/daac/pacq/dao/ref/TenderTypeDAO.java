package com.daac.pacq.dao.ref;

import java.util.List;

import com.daac.pacq.domain.ref.TenderType;

public interface TenderTypeDAO {

	public TenderType			get(Integer id);
	public List<TenderType> 	list();
	public List<TenderType> 	filter(String filterString);
}
