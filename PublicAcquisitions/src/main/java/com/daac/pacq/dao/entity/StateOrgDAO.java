/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.StateOrg;

/**
 * @author Serghey.Golub
 *
 */
public interface StateOrgDAO {
	
	public StateOrg				get(Integer id);
	public List<StateOrg> 		list();
	public List<StateOrg> 		filter(String filterString);
}
