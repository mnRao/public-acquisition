/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.TenderDocument;

/**
 * @author Serghey.Golub
 *
 */
public interface TenderDocumentDAO {
	
	public TenderDocument	get(Integer id);
	public List<TenderDocument> 	list(Integer id);
	public List<TenderDocument> 	filter(String filterString);
}
