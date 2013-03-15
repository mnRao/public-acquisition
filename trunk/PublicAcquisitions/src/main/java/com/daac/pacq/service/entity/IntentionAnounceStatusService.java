package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.IntentionAnounceStatus;

public interface IntentionAnounceStatusService {

	public IntentionAnounceStatus 		get(Integer id);
	public List<IntentionAnounceStatus> list();
	public List<IntentionAnounceStatus> filter(String filterString);
}
