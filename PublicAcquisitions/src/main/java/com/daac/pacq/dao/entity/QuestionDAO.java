/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Question;
import com.daac.pacq.domain.entity.TenderPosition;

/**
 * @author Serghey.Golub
 *
 */
public interface QuestionDAO {
	
	public Question	get(Integer id);
	public List<Question> 	list(Integer id);
	public List<Question> 	filter(String filterString);
}
