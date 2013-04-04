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

import com.daac.pacq.domain.entity.Contract;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class ContractDAOImpl implements ContractDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public Contract get(Integer id) {
		Contract result = (Contract)sessionFactory.getCurrentSession().get(Contract.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> list(Integer id) {

		return sessionFactory.getCurrentSession().createQuery("from Contract where FK_TENDER_ID="+id).list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> list() {

		return sessionFactory.getCurrentSession().createQuery("from Contract").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from Contract").list();
	}

	@SuppressWarnings("unchecked")
	@Override	
	public List<Contract> 		search(Map<String, String[]> filtersMap){
		System.out.println("ContractDAOImpl - search");
		Boolean vContractDataRestricred 	= false;
		
		String vOrderByFieldName	= "id";
		String vOrderByMode		= "asc";
		
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(Contract.class);
		
		Date vContractDataFrom = null, vContractDataTo = null;
			try {
				vContractDataFrom	 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vContractDataTo		 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
//	filters[fContractDataTo] = 
//	filters[fProcedureNumber] = 
//	filters[fContractDataFrom] = 
//	filters[fContractType] = 
			for (Map.Entry<String, String[]> entry : filtersMap.entrySet())
			{
			    System.out.println(entry.getKey() + "/" + entry.getValue()[0]);
			    
			    if (entry.getKey().toLowerCase().contains("filters[fProcedureNumber]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse GOODS DECRITION ");
			    	crit.createCriteria("tender").add(Restrictions.like("regNumber", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
			    }	
			    
			    if (entry.getKey().toLowerCase().contains("filters[fContractType]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse CONTRACT TYPE");
			    	crit.createCriteria("contractType").add(Restrictions.eq("id", Integer.parseInt(entry.getValue()[0])));
			    }
			    
			    
			    if (entry.getKey().toLowerCase().contains("filters[fContractDataFrom]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse CONTRACT DATA FROM ");
				    	try {
				    		vContractDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
				    		vContractDataRestricred 	= true;
				    	} catch (ParseException e) {e.printStackTrace();}
			    }
			    
			    if (entry.getKey().toLowerCase().contains("filters[fContractDataTo]".toLowerCase()) &&
			    		entry.getValue()[0].length()>0) {
			    	System.out.println("Parse CONTRACT DATA TO ");
				    	try {
				    		vContractDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
				    		vContractDataRestricred 	= true;
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
		
			if (vContractDataRestricred) {
				crit.add(Restrictions.between("contractDate",vContractDataFrom,vContractDataTo));	
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
			
			List<Contract>  result = crit.list();
			
		return result;
	}
	
}
