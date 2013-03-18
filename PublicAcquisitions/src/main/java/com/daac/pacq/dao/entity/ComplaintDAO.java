/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Complaint;

/**
 * @author Serghey.Golub
 *
 */
public interface ComplaintDAO {
	
	public Complaint				get(Integer id);
	public List<Complaint> 			list();
	public List<Complaint> 			filter(String filterString);
}
