/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.TenderDocument;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class TenderDocumentDAOImpl implements TenderDocumentDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderPositionDAO#get(java.lang.Integer)
	 */
	@Override
	public TenderDocument get(Integer id) {
		System.out.println("TenderDocumentDAOImpl.get() ---- id="+id);
		TenderDocument result = (TenderDocument)sessionFactory.getCurrentSession().get(TenderDocument.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderPositionDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TenderDocument> list(Integer id) {
		System.out.println("TenderDocumentDAOImpl.list() ---- id="+id);
		List<TenderDocument> result;
		result  = sessionFactory.getCurrentSession().createQuery("from TenderDocument  where FK_TENDER_ID="+id).list(); 
		return result;
	}	
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderPositionDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TenderDocument> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from TenderDocument").list();
	}

}
