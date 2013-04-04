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
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daac.pacq.domain.entity.Tender;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class TenderDAOImpl implements TenderDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public Tender get(Integer id) {
		System.out.println("TenderDAOImpl.get() ---- id="+id);
		Tender result = (Tender)sessionFactory.getCurrentSession().get(Tender.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tender> list() {
		
//		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(Tender.class);
//		crit.add(Restrictions.eq("id",258629));
//		List<Tender>  result = crit.list();
		
		return sessionFactory.getCurrentSession().createQuery("from Tender").list();
	}	
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tender> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from Tender").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tender> 		search(Map<String, String[]> filtersMap){
		System.out.println("TenderDAOImpl - search");
		Boolean vProcedureOpenDataRestricred 	= false;
		
		String vOrderByFieldName	= "id";
		String vOrderByMode		= "asc";
		
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(Tender.class);
		crit.createCriteria("tenderStatus", "tenderStatus");
		crit.createCriteria("tenderType","tenderType");
		crit.createCriteria("stateOrg","stateOrg");
		crit.createCriteria("tenderData","tenderData");
		crit.add( Restrictions.in( "tenderStatus.id", new Integer[] { 2,3,4,5,6,8,9,10} ) );
		
		Date vProcedureOpenDataFrom = null, vProcedureOpenDataTo = null;
			try {
				vProcedureOpenDataFrom	 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vProcedureOpenDataTo	 = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			for (Map.Entry<String, String[]> entry : filtersMap.entrySet())
			{
			    System.out.println(entry.getKey() + "/" + entry.getValue()[0]);
			    if (entry.getKey().toLowerCase().contains("filters[fTenderStatus]".toLowerCase()) && entry.getValue()[0].length()>0) {
			    	System.out.println("Parse TENDER STATUS");	
			    	//crit.createCriteria("tenderStatus").
			    	crit.add(Restrictions.eq("tenderStatus.id", Integer.parseInt(entry.getValue()[0])));	
			    }
			    
			    if (entry.getKey().toLowerCase().contains("filters[fpGoodsDescr]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse GOODS DECRITION ");
			    	//crit.createCriteria("tenderData").
			    	crit.add(Restrictions.like("tenderData.goodsDescr", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
			    }	
			    
			    
			    if (entry.getKey().toLowerCase().contains("filters[fProcedureOpenDataFrom]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse PROCEDURE DATA FROM ");
				    	try {
				    	vProcedureOpenDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
				    	vProcedureOpenDataRestricred 	= true;
				    	} catch (ParseException e) {e.printStackTrace();}
			    }
			    
			    if (entry.getKey().toLowerCase().contains("filters[fProcedureOpenDataTo]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse PROCEDURE DATA TO ");
				    	try {
						vProcedureOpenDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
						vProcedureOpenDataRestricred 	= true;
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
		
			if (vProcedureOpenDataRestricred) {
				crit.add(Restrictions.between("refTendeOpenDate",vProcedureOpenDataFrom,vProcedureOpenDataTo));	
			}
			
			
			if (vOrderByMode.equalsIgnoreCase("desc")) {
				 crit.addOrder( Order.desc(vOrderByFieldName));
			 } else {
				 crit.addOrder( Order.asc(vOrderByFieldName));
			 } 
			
			List<Tender>  result = crit.list();
			
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tender> 		search_backup(Map<String, String[]> filtersMap){
		System.out.println("TenderDAOImpl - search");
		Boolean vProcedureOpenDataRestricred 	= false;
		
		String vOrderByFieldName	= "id";
		String vOrderByMode		= "asc";
		
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(Tender.class)
		 .add( Restrictions.sqlRestriction("{alias}.REF_CURRENT_STATUS_ID in (2,3,4,5,6,8,9,10)") );
		
		Date vProcedureOpenDataFrom = null, vProcedureOpenDataTo = null;
			try {
				vProcedureOpenDataFrom	 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vProcedureOpenDataTo	 = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
//				filters[fProcedureOpenDataFrom]
//				filters[fProcedureOpenDataTo] = 			
//				filters[fpGoodsDescr] = 
//				filters[fTenderStatus] = 

			for (Map.Entry<String, String[]> entry : filtersMap.entrySet())
			{
			    System.out.println(entry.getKey() + "/" + entry.getValue()[0]);
			    if (entry.getKey().toLowerCase().contains("filters[fTenderStatus]".toLowerCase()) && entry.getValue()[0].length()>0) {
			    	System.out.println("Parse TENDER STATUS");	
			    	crit.createCriteria("tenderStatus").add(Restrictions.eq("id", Integer.parseInt(entry.getValue()[0])));	
//			    	if (entry.getValue()[0].length()>0) {
//			    		crit.createCriteria("tenderStatus").
//		    			add( Property.forName("id").in( new Integer[] { 2,3,4,5,6,8,9,10 } )).
//		    					add(Restrictions.eq("id", Integer.parseInt(entry.getValue()[0])));				    				    		
//			    	} else {
//			    		crit.createCriteria("tenderStatus").
//		    			add( Property.forName("id").in( new Integer[] { 2,3,4,5,6,8,9,10 } ));
//			    	}
			    }
			    
			    if (entry.getKey().toLowerCase().contains("filters[fpGoodsDescr]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse GOODS DECRITION ");
			    	crit.createCriteria("tenderData").add(Restrictions.like("goodsDescr", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
			    }	
			    
			    
			    if (entry.getKey().toLowerCase().contains("filters[fProcedureOpenDataFrom]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse PROCEDURE DATA FROM ");
				    	try {
				    	vProcedureOpenDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
				    	vProcedureOpenDataRestricred 	= true;
				    	} catch (ParseException e) {e.printStackTrace();}
			    }
			    
			    if (entry.getKey().toLowerCase().contains("filters[fProcedureOpenDataTo]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse PROCEDURE DATA TO ");
				    	try {
						vProcedureOpenDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
						vProcedureOpenDataRestricred 	= true;
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
		
			if (vProcedureOpenDataRestricred) {
				crit.add(Restrictions.between("refTendeOpenDate",vProcedureOpenDataFrom,vProcedureOpenDataTo));	
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
			
			List<Tender>  result = crit.list();
			
		return result;
	}	
}
