/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.Contract;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class ContractDAOImpl implements ContractDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public Contract get(Integer id) {
		Contract result = (Contract)sessionFactory.getCurrentSession().get(Contract.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> list(Integer id) {

		return sessionFactory.getCurrentSession().createQuery("from Contract where FK_TENDERID="+id).list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> list() {

		return sessionFactory.getCurrentSession().createQuery("from Contract").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from Contract").list();
	}

}
