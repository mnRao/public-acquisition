/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.Question;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.QuestionDAO#get(java.lang.Integer)
	 */
	@Override
	public Question get(Integer id) {
		System.out.println("QuestionDAOImpl.get() ---- id="+id);
		Question result = (Question)sessionFactory.getCurrentSession().get(Question.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.QuestionDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> list(Integer id) {

		return sessionFactory.getCurrentSession().createQuery("from Question where FK_TENDER_ID="+id).list();
	}	
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.QuestionDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Question> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from Question").list();
	}

}
