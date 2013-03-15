/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.IntentionAnounceStatus;

/**
 * @author Serghey.Golub
 *
 */
public interface IntentionAnounceStatusDAO {
	
	public IntentionAnounceStatus				get(Integer id);
	public List<IntentionAnounceStatus> 		list();
	public List<IntentionAnounceStatus> 		filter(String filterString);
}
