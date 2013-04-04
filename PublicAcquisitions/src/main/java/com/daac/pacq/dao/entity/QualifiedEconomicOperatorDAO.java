/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;
import java.util.Map;

import com.daac.pacq.domain.entity.QualifiedEconomicOperator;

/**
 * @author Serghey.Golub
 *
 */
public interface QualifiedEconomicOperatorDAO {
	
	public QualifiedEconomicOperator				get(Integer id);
	public List<QualifiedEconomicOperator> 			list();
	public List<QualifiedEconomicOperator> 			filter(String filterString);
	public List<QualifiedEconomicOperator>			search(Map<String, String[]> filtersMap);
}
