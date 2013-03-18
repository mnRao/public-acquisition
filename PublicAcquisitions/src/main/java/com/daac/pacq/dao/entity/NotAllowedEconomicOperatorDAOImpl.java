/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.NotAllowedEconomicOperator;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class NotAllowedEconomicOperatorDAOImpl implements NotAllowedEconomicOperatorDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public NotAllowedEconomicOperator get(Integer id) {
		NotAllowedEconomicOperator result = (NotAllowedEconomicOperator)sessionFactory.getCurrentSession().get(NotAllowedEconomicOperator.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NotAllowedEconomicOperator> list() {

		return sessionFactory.getCurrentSession().createQuery("from NotAllowedEconomicOperator").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NotAllowedEconomicOperator> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from NotAllowedEconomicOperator").list();
	}

}
