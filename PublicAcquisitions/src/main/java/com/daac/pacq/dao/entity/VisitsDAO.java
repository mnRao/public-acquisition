/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.Date;

import com.daac.pacq.domain.entity.Visits;

/**
 * @author Serghey.Golub
 *
 */
public interface VisitsDAO {
	
	public Visits					get(Date id);
	public void						add(Visits item);
	public void						update(Visits item);
}
