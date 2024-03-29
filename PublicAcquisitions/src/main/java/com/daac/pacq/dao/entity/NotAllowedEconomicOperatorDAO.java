/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;
import java.util.Map;

import com.daac.pacq.domain.entity.NotAllowedEconomicOperator;

/**
 * @author Serghey.Golub
 *
 */
public interface NotAllowedEconomicOperatorDAO {
	
	public NotAllowedEconomicOperator					get(Integer id);
	public List<NotAllowedEconomicOperator> 			list();
	public List<NotAllowedEconomicOperator> 			filter(String filterString);
	public List<NotAllowedEconomicOperator>				search(Map<String, String[]> filtersMap);
}
