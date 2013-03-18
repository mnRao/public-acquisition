/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.StateOrg;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class StateOrgDAOImpl implements StateOrgDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public StateOrg get(Integer id) {
		StateOrg result = (StateOrg)sessionFactory.getCurrentSession().get(StateOrg.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StateOrg> list() {

		return sessionFactory.getCurrentSession().createQuery("from StateOrg").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StateOrg> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from StateOrg").list();
	}

}
