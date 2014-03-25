package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.TenderDocument;

public interface TenderDocumentService {

	public TenderDocument 		get(Integer id);
	public List<TenderDocument> list(Integer id);
	public List<TenderDocument> filter(String filterString);
}
