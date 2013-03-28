package com.daac.pacq.service.ref;

import java.util.List;

import com.daac.pacq.domain.ref.TenderStatus;

public interface TenderStatusService {

	public TenderStatus 		get(Integer id);
	public List<TenderStatus> 	list();
	public List<TenderStatus> 	filter(String filterString);
}
