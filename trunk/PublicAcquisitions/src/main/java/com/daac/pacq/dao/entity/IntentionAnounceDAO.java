/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.IntentionAnounce;

/**
 * @author Serghey.Golub
 *
 */
public interface IntentionAnounceDAO {
	
	public IntentionAnounce				get(Integer id);
	public List<IntentionAnounce> 		list();
	public List<IntentionAnounce> 		filter(String filterString);
}
