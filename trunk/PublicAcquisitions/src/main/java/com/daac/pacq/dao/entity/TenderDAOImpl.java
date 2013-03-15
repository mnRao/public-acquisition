/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.Tender;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class TenderDAOImpl implements TenderDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public Tender get(Integer id) {
		Tender result = (Tender)sessionFactory.getCurrentSession().load(Tender.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tender> list() {

		return sessionFactory.getCurrentSession().createQuery("from Tender").list();
	}	
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tender> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from Tender").list();
	}

}
