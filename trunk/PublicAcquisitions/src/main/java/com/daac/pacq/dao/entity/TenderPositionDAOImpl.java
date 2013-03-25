/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.TenderPosition;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class TenderPositionDAOImpl implements TenderPositionDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderPositionDAO#get(java.lang.Integer)
	 */
	@Override
	public TenderPosition get(Integer id) {
		System.out.println("TenderPositionDAOImpl.get() ---- id="+id);
		TenderPosition result = (TenderPosition)sessionFactory.getCurrentSession().get(TenderPosition.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderPositionDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TenderPosition> list(Integer id) {

		return sessionFactory.getCurrentSession().createQuery("from TenderPosition where FK_TENDER_DATA_ID="+id).list();
	}	
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderPositionDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TenderPosition> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from TenderPosition").list();
	}

}
