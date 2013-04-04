package com.daac.pacq.dao.ref;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.ref.TenderStatus;

@Repository
public class TenderStatusDAOImpl implements TenderStatusDAO {

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public TenderStatus get(Integer id) {
		TenderStatus result = (TenderStatus)sessionFactory.getCurrentSession().load(TenderStatus.class, id);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TenderStatus> list() {
		System.out.println("TenderStatusDAOImpl - list");
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(TenderStatus.class);
		crit.add( Restrictions.in( "id", new Integer[] { 2,3,4,5,6,8,9,10} ) );

		List<TenderStatus>  result = crit.list();
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TenderStatus> filter(String filterString) {
		System.out.println("TenderStatusDAOImpl - filter");
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(TenderStatus.class);
		crit.add( Restrictions.in( "id", new Integer[] { 2,3,4,5,6,8,9,10} ) );

		List<TenderStatus>  result = crit.list();
		return result;
	}

}
