/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<QualifiedEconomicOperator>			search(Map<String, String[]> filtersMap){
		System.out.println("QualifiedEconomicOperatorDAOImpl - search");
		Boolean vDecisionDataRestricred 	= false;
		
		String vOrderByFieldName	= "id";
		String vOrderByMode		= "asc";
		
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(QualifiedEconomicOperator.class);
		
		Date vDecisionDataFrom = null, vDecisionDataTo = null;
			try {
				vDecisionDataFrom	 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vDecisionDataTo		 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
//filters[fCode] =
//filters[fDecisionDateFrom] = 			
//filters[fDecisionDateTo] = 
//filters[fDecisionNumb] = 
//filters[fName] = 
			for (Map.Entry<String, String[]> entry : filtersMap.entrySet())
			{
			    System.out.println(entry.getKey() + "/" + entry.getValue()[0]);
			    
			    if (entry.getKey().toLowerCase().contains("filters[fCode]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse IDNO/IDNP ");
			    	crit.add(Restrictions.like("code", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
			    }	
			    
			    if (entry.getKey().toLowerCase().contains("filters[fDecisionNumb]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse Decision Number ");
			    	crit.add(Restrictions.like("decisionNumb", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
			    }
			    
			    if (entry.getKey().toLowerCase().contains("filters[fName]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse Denumirea ");
			    	crit.add(Restrictions.like("name", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
			    }			    
			    
			    
			    
			    if (entry.getKey().toLowerCase().contains("filters[fDecisionDateFrom]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse DECISION DATA FROM ");
				    	try {
				    		vDecisionDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
				    		vDecisionDataRestricred 	= true;
				    	} catch (ParseException e) {e.printStackTrace();}
			    }
			    
			    if (entry.getKey().toLowerCase().contains("filters[fDecisionDateTo]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse DECISION DATA TO ");
				    	try {
				    		vDecisionDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
				    		vDecisionDataRestricred 	= true;
						} catch (ParseException e) {e.printStackTrace();}		    	
			    }
			    
				 /* SORTING */		    
			    if (entry.getKey().toLowerCase().contains("sord".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse ORDER MODE ");
			    	vOrderByMode = entry.getValue()[0];
			    }		    
			    
			    if (entry.getKey().toLowerCase().contains("sidx".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse ORDER FIELD ");
			    	vOrderByFieldName = entry.getValue()[0];
			    }
			    
			}
			
			
			if (vDecisionDataRestricred) {
				crit.add(Restrictions.between("decisionDate",vDecisionDataFrom,vDecisionDataTo));	
			}				
		
		
			 if (vOrderByFieldName.contains(".")){
				 String lCriteria= "", lFieldName= "";	
				 lCriteria = vOrderByFieldName.substring(0, vOrderByFieldName.indexOf("."));
				 lFieldName = vOrderByFieldName.substring( vOrderByFieldName.indexOf(".") + 1, vOrderByFieldName.length() );
				 System.out.println(" Associated Ordering criteria = " + lCriteria );
				 System.out.println(" Remained   Ordering field = " + lFieldName);
				 vOrderByFieldName = lFieldName;
				 
				 if (vOrderByMode.equalsIgnoreCase("desc")) {
					 crit.createCriteria(lCriteria).addOrder( Order.desc(vOrderByFieldName));
				 } else {
					 crit.createCriteria(lCriteria).addOrder( Order.asc(vOrderByFieldName));
				 }
				 
			 } else {
				 if (vOrderByMode.equalsIgnoreCase("desc")) {
					 crit.addOrder( Order.desc(vOrderByFieldName));
				 } else {
					 crit.addOrder( Order.asc(vOrderByFieldName));
				 } 
			 }
			
			List<QualifiedEconomicOperator>  result = crit.list();
			
		return result;			
	}

	
}
