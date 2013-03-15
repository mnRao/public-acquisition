package com.daac.pacq.service.ref;

import java.util.List;

import com.daac.pacq.domain.ref.IntentionStatus;

public interface IntentionStatusService {

	public IntentionStatus 		get(Integer id);
	public List<IntentionStatus> list();
	public List<IntentionStatus> filter(String filterString);
}
