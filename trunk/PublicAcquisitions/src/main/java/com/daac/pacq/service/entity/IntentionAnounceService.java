package com.daac.pacq.service.entity;

import java.util.List;
import java.util.Map;

import com.daac.pacq.domain.entity.IntentionAnounce;

public interface IntentionAnounceService {

	public IntentionAnounce 		get(Integer id);
	public List<IntentionAnounce> list();
	public List<IntentionAnounce> filter(String filterString);
	public List<IntentionAnounce> search(Map<String, String[]> filtersMap);
}
