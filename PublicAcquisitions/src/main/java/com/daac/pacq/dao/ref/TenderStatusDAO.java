package com.daac.pacq.dao.ref;

import java.util.List;

import com.daac.pacq.domain.ref.TenderStatus;

public interface TenderStatusDAO {

	public TenderStatus				get(Integer id);
	public List<TenderStatus> 		list();
	public List<TenderStatus> 		filter(String filterString);
}
