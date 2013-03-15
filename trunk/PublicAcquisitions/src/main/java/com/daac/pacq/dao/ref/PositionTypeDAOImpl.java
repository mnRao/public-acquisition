package com.daac.pacq.dao.ref;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.ref.PositionType;

@Repository
public class PositionTypeDAOImpl implements PositionTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public PositionType get(Integer id) {
		PositionType result = (PositionType)sessionFactory.getCurrentSession().load(PositionType.class, id);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PositionType> list() {
		System.out.println("PositionTypeDAOImpl - list");
		return sessionFactory.getCurrentSession().createQuery("from PositionType").list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PositionType> filter(String filterString) {
		return sessionFactory.getCurrentSession().createQuery("from PositionType").list();
	}

}
