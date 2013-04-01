/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;
import java.util.Map;

import com.daac.pacq.domain.entity.Contract;
import com.daac.pacq.domain.entity.IntentionAnounce;

/**
 * @author Serghey.Golub
 *
 */
public interface ContractDAO {
	
	public Contract				get(Integer id);
	public List<Contract> 		list();
	public List<Contract> 		list(Integer id);
	public List<Contract> 		filter(String filterString);
	public List<Contract> 		search(Map<String, String[]> filtersMap);
}
