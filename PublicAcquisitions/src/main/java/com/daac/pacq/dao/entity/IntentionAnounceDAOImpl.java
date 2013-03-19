/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.IntentionAnounce;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class IntentionAnounceDAOImpl implements IntentionAnounceDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public IntentionAnounce get(Integer id) {
		IntentionAnounce result = (IntentionAnounce)sessionFactory.getCurrentSession().get(IntentionAnounce.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounce> list() {

		return sessionFactory.getCurrentSession().createQuery("from IntentionAnounce").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounce> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from IntentionAnounce").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounce> 		search(Map<String, String[]> filtersMap){
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(IntentionAnounce.class);
		crit.setMaxResults(100);
		
		crit.add( Restrictions.like("tenderType", "%AA%") );
		
		 List<IntentionAnounce>  result = crit.list();
		
		
		
		return result;
	}
	
}
