package com.daac.pacq.dao.ref;

import java.util.List;

import com.daac.pacq.domain.ref.IntentionStatus;

public interface IntentionStatusDAO {

	public IntentionStatus				get(Integer id);
	public List<IntentionStatus> 		list();
	public List<IntentionStatus> 		filter(String filterString);
}
