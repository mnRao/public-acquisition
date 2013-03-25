/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.TenderPosition;

/**
 * @author Serghey.Golub
 *
 */
public interface TenderPositionDAO {
	
	public TenderPosition	get(Integer id);
	public List<TenderPosition> 	list(Integer id);
	public List<TenderPosition> 	filter(String filterString);
}
