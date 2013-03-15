/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.IntentionAnounceStatus;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class IntentionAnounceStatusDAOImpl implements IntentionAnounceStatusDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public IntentionAnounceStatus get(Integer id) {
		IntentionAnounceStatus result = (IntentionAnounceStatus)sessionFactory.getCurrentSession().get(IntentionAnounceStatus.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounceStatus> list() {

		return sessionFactory.getCurrentSession().createQuery("from IntentionAnounceStatus").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounceStatus> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from IntentionAnounceStatus").list();
	}

}
