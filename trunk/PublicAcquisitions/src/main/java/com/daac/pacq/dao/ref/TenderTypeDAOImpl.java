package com.daac.pacq.dao.ref;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.ref.TenderType;

@Repository
public class TenderTypeDAOImpl implements TenderTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public TenderType get(Integer id) {
		TenderType result = (TenderType)sessionFactory.getCurrentSession().load(TenderType.class, id);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TenderType> list() {
		System.out.println("TenderTypeDAOImpl - list");
		return sessionFactory.getCurrentSession().createQuery("from TenderType").list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TenderType> filter(String filterString) {
		return sessionFactory.getCurrentSession().createQuery("from TenderType").list();
	}

}
