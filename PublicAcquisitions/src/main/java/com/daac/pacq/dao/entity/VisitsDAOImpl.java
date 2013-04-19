/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.Visits;

/**
 * @author Serghey.Golub
 *
 */
@Repository
public class VisitsDAOImpl implements VisitsDAO {

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public Visits get(Date id) {
		System.out.println("VisitsDAOImpl - get");
		Visits result = (Visits)sessionFactory.getCurrentSession().get(Visits.class, id);
		return result;
	}
	
	@Override
	public void add(Visits item) {
		System.out.println("VisitsDAOImpl - add");
		sessionFactory.getCurrentSession().save(item);
	}

	@Override
	public void update(Visits item) {
		System.out.println("VisitsDAOImpl - update");
		sessionFactory.getCurrentSession().update(item);
	}


}
