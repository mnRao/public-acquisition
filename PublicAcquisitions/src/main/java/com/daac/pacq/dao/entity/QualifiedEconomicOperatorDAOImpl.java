/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.QualifiedEconomicOperator;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class QualifiedEconomicOperatorDAOImpl implements QualifiedEconomicOperatorDAO{

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public QualifiedEconomicOperator get(Integer id) {
		QualifiedEconomicOperator result = (QualifiedEconomicOperator)sessionFactory.getCurrentSession().get(QualifiedEconomicOperator.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QualifiedEconomicOperator> list() {

		return sessionFactory.getCurrentSession().createQuery("from QualifiedEconomicOperator").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<QualifiedEconomicOperator> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from QualifiedEconomicOperator").list();
	}

}
