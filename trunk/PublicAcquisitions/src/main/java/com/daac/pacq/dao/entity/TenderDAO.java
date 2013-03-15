/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Tender;

/**
 * @author Serghey.Golub
 *
 */
public interface TenderDAO {
	
	public Tender			get(Integer id);
	public List<Tender> 	list();
	public List<Tender> 	filter(String filterString);
}
