package com.daac.pacq.dao.ref;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.ref.IntentionStatus;

@Repository
public class IntentionStatusDAOImpl implements IntentionStatusDAO {

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public IntentionStatus get(Integer id) {
		IntentionStatus result = (IntentionStatus)sessionFactory.getCurrentSession().load(IntentionStatus.class, id);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionStatus> list() {
		System.out.println("PositionTypeDAOImpl - list");
		return sessionFactory.getCurrentSession().createQuery("from IntentionStatus").list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionStatus> filter(String filterString) {
		return sessionFactory.getCurrentSession().createQuery("from IntentionStatus").list();
	}

}
