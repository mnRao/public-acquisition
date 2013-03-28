package com.daac.pacq.dao.ref;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.ref.IntentionStatus;
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
		return sessionFactory.getCurrentSession().createQuery("from TenderStatus").list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TenderStatus> filter(String filterString) {
		return sessionFactory.getCurrentSession().createQuery("from TenderStatus").list();
	}

}
