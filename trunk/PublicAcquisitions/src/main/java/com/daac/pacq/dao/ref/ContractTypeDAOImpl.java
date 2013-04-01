package com.daac.pacq.dao.ref;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.ref.ContractType;

@Repository
public class ContractTypeDAOImpl implements ContractTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public ContractType get(Integer id) {
		ContractType result = (ContractType)sessionFactory.getCurrentSession().load(ContractType.class, id);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContractType> list() {
		System.out.println("ContractTypeDAOImpl - list");
		return sessionFactory.getCurrentSession().createQuery("from ContractType").list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ContractType> filter(String filterString) {
		return sessionFactory.getCurrentSession().createQuery("from ContractType").list();
	}

}
