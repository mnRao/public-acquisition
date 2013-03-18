/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.Complaint;
import com.daac.pacq.domain.entity.StateOrg;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class ComplaintDAOImpl implements ComplaintDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public Complaint get(Integer id) {
		Complaint result = (Complaint)sessionFactory.getCurrentSession().get(Complaint.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> list() {

		return sessionFactory.getCurrentSession().createQuery("from Complaint").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from Complaint").list();
	}

}
