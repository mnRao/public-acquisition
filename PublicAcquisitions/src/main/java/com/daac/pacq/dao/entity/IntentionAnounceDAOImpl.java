/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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

import com.daac.pacq.domain.entity.IntentionAnounce;


/**
 * @author Serghey.Golub
 *
 */
@Repository
public class IntentionAnounceDAOImpl implements IntentionAnounceDAO {

    @Autowired
    private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#get(java.lang.Integer)
	 */
	@Override
	public IntentionAnounce get(Integer id) {
		IntentionAnounce result = (IntentionAnounce)sessionFactory.getCurrentSession().get(IntentionAnounce.class, id);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounce> list() {

		return sessionFactory.getCurrentSession().createQuery("from IntentionAnounce").list();
	}
	
	/* (non-Javadoc)
	 * @see com.daac.pacq.dao.TenderDAO#filter()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounce> filter(String filterString) {

		return sessionFactory.getCurrentSession().createQuery("from IntentionAnounce").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IntentionAnounce> 		search(Map<String, String[]> filtersMap) {
		System.out.println("IntentionAnounceDAOImpl - search");
		Boolean vBulletinPublishDateRestricted 	= false;
		Boolean vApproveDateRestricted 			= false;
		
		String vOrderByFieldName	= "id";
		String vOrderByMode		= "asc";
		
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(IntentionAnounce.class);
		crit.createCriteria("currentStatus", "currentStatus").createCriteria("intentionStatus", "intentionStatus");
		crit.createCriteria("tenderType","tenderType");
		crit.createCriteria("budgetPeriod","budgetPeriod");
		crit.createCriteria("stateOrg","stateOrg");
		crit.add( Restrictions.in( "intentionStatus.id", new Integer[] { 3 } ) );
		
		Date vBulletinDataFrom = null, vBulletinDataTo = null, vApproveDataFrom = null, vApproveDataTo = null;
			try {
				vBulletinDataFrom = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vBulletinDataTo = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
				vApproveDataFrom = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vApproveDataTo = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

		for (Map.Entry<String, String[]> entry : filtersMap.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue()[0]);
		    if (entry.getKey().toLowerCase().contains("filters[fIntentionStatus]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse INTENTION STATUS");
		    	//crit.createCriteria("currentStatus").createCriteria("intentionStatus");
		    	crit.add(Restrictions.eq("intentionStatus.id", Integer.parseInt(entry.getValue()[0])));
		    	
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fTenderType]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse INTENTION TENDER TYPE");
//		    	crit.createCriteria("tenderType").
		    	crit.add(Restrictions.eq("tenderType.id", Integer.parseInt(entry.getValue()[0])));
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fGoodsDescription]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse POSITION DESCRIPTION");
		    	crit.add(Restrictions.like("positionDescr", entry.getValue()[0], MatchMode.ANYWHERE  ).ignoreCase());
		    }		    
		    
		    if (entry.getKey().toLowerCase().contains("filters[fForWhoPurchase]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse FOR WHO PURCHASE");
		    	crit.add(Restrictions.like("forWhoPurchase", entry.getValue()[0], MatchMode.ANYWHERE  ).ignoreCase());
		    }		    
		    
		    if (entry.getKey().toLowerCase().contains("filters[fStateOrg]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse STATE ORG NAME");
//		    	crit.createCriteria("stateOrg").
		    	crit.add(Restrictions.like("stateOrg.orgName", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fBulletinNumber]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse BULLETIN NUMBER ");
		    	crit.add(Restrictions.like("bulletinNumber", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
		    }	
		    
		    if (entry.getKey().toLowerCase().contains("filters[fBulletinDataFrom]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse BULLETIN FROM ");
			    	try {
			    	vBulletinDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
			    	vBulletinPublishDateRestricted 	= true;
			    	} catch (ParseException e) {e.printStackTrace();}
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fBulletinDataTo]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse BULLETIN TO ");
			    	try {
					vBulletinDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
					vBulletinPublishDateRestricted 	= true;
					} catch (ParseException e) {e.printStackTrace();}		    	
		    }
		    
		    
		    if (entry.getKey().toLowerCase().contains("filters[fApproveDataFrom]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse APPROVE DATA FROM ");
			    	try {
			    	vApproveDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
			    	vApproveDateRestricted 	= true;
			    	} catch (ParseException e) {e.printStackTrace();}
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fApproveDataTo]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse APPROVE DATA TO ");
			    	try {
					vApproveDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
					vApproveDateRestricted 	= true;
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
	
		if (vBulletinPublishDateRestricted) {
			crit.add(Restrictions.between("bulletinPublishDate",vBulletinDataFrom,vBulletinDataTo));	
		}
		 if (vApproveDateRestricted){
			crit.add(Restrictions.between("publishDate",vApproveDataFrom,vApproveDataTo));	 
		}
		 
		
		 if (vOrderByMode.equalsIgnoreCase("desc")) {
			 crit.addOrder( Order.desc(vOrderByFieldName));
		 } else {
			 crit.addOrder( Order.asc(vOrderByFieldName));
		 } 
		 
//		 if (vOrderByFieldName.contains(".")){
//			 String lCriteria= "", lFieldName= "";	
//			 lCriteria = vOrderByFieldName.substring(0, vOrderByFieldName.indexOf("."));
//			 lFieldName = vOrderByFieldName.substring( vOrderByFieldName.indexOf(".") + 1, vOrderByFieldName.length() );
//			 System.out.println(" Associated Ordering criteria = " + lCriteria );
//			 System.out.println(" Remained   Ordering field = " + lFieldName);
//			 vOrderByFieldName = lFieldName;
//			 
//			 if (vOrderByMode.equalsIgnoreCase("desc")) {
//				 if (vOrderByFieldName.contains(".")) {
//					 String zCriteria= "", zFieldName= "";	
//					 zCriteria = vOrderByFieldName.substring(0, vOrderByFieldName.indexOf("."));
//					 zFieldName = vOrderByFieldName.substring( vOrderByFieldName.indexOf(".") + 1, vOrderByFieldName.length() );
//					 System.out.println(" Associated Z Ordering criteria = " + zCriteria );
//					 System.out.println(" Remained  Z Ordering field = " + zFieldName);
//					 vOrderByFieldName = zFieldName;
//					 crit.createCriteria(lCriteria).createCriteria(zCriteria).addOrder( Order.desc(vOrderByFieldName));
//				 } else {
//					 crit.createCriteria(lCriteria).addOrder( Order.desc(vOrderByFieldName));
//				 }
//			 } else {
//				 if (vOrderByFieldName.contains(".")) {
//					 String zCriteria= "", zFieldName= "";	
//					 zCriteria = vOrderByFieldName.substring(0, vOrderByFieldName.indexOf("."));
//					 zFieldName = vOrderByFieldName.substring( vOrderByFieldName.indexOf(".") + 1, vOrderByFieldName.length() );
//					 System.out.println(" Associated Z Ordering criteria = " + zCriteria );
//					 System.out.println(" Remained  Z Ordering field = " + zFieldName);
//					 vOrderByFieldName = zFieldName;
//					 crit.createCriteria(lCriteria).createCriteria(zCriteria).addOrder( Order.asc(vOrderByFieldName));
//				 } else {
//					 crit.createCriteria(lCriteria).addOrder( Order.asc(vOrderByFieldName));
//				 }
//			 }
//			 
//		 } else {
//			 if (vOrderByMode.equalsIgnoreCase("desc")) {
//				 crit.addOrder( Order.desc(vOrderByFieldName));
//			 } else {
//				 crit.addOrder( Order.asc(vOrderByFieldName));
//			 } 
//		 }
		 
		
		 
		 

//			sidx
//			rows
//			sord
//			page
//			nd
//			_search
		 
		 
		 
		 
		List<IntentionAnounce>  result = crit.list();
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<IntentionAnounce> 		search_backup(Map<String, String[]> filtersMap) {
		System.out.println("IntentionAnounceDAOImpl - search");
		Boolean vBulletinPublishDateRestricted 	= false;
		Boolean vApproveDateRestricted 			= false;
		
		String vOrderByFieldName	= "id";
		String vOrderByMode		= "asc";
		
		Criteria crit =  sessionFactory.getCurrentSession().createCriteria(IntentionAnounce.class);
		crit.createCriteria("currentStatus", "currentStatus").createCriteria("intentionStatus", "intentionStatus");
		
		Date vBulletinDataFrom = null, vBulletinDataTo = null, vApproveDataFrom = null, vApproveDataTo = null;
			try {
				vBulletinDataFrom = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vBulletinDataTo = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
				vApproveDataFrom = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("01.01.1900");
				vApproveDataTo = 	new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse("31.12.2999");
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

		for (Map.Entry<String, String[]> entry : filtersMap.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue()[0]);
		    if (entry.getKey().toLowerCase().contains("filters[fIntentionStatus]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse INTENTION STATUS");
		    	crit.add(Restrictions.eq("intentionStatus.id", Integer.parseInt(entry.getValue()[0])));
		    	
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fTenderType]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse INTENTION TENDER TYPE");
		    	crit.createCriteria("tenderType").
		    		add(Restrictions.eq("id", Integer.parseInt(entry.getValue()[0])));
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fGoodsDescription]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse POSITION DESCRIPTION");
		    	crit.add(Restrictions.like("positionDescr", entry.getValue()[0], MatchMode.ANYWHERE  ).ignoreCase());
		    }		    
		    
		    if (entry.getKey().toLowerCase().contains("filters[fForWhoPurchase]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse FOR WHO PURCHASE");
		    	crit.add(Restrictions.like("forWhoPurchase", entry.getValue()[0], MatchMode.ANYWHERE  ).ignoreCase());
		    }		    
		    
		    if (entry.getKey().toLowerCase().contains("filters[fStateOrg]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse STATE ORG NAME");
		    	crit.createCriteria("stateOrg").
		    		add(Restrictions.like("orgName", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fBulletinNumber]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse BULLETIN NUMBER ");
		    	crit.add(Restrictions.like("bulletinNumber", entry.getValue()[0], MatchMode.ANYWHERE ).ignoreCase());
		    }	
		    
		    if (entry.getKey().toLowerCase().contains("filters[fBulletinDataFrom]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse BULLETIN FROM ");
			    	try {
			    	vBulletinDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
			    	vBulletinPublishDateRestricted 	= true;
			    	} catch (ParseException e) {e.printStackTrace();}
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fBulletinDataTo]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse BULLETIN TO ");
			    	try {
					vBulletinDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
					vBulletinPublishDateRestricted 	= true;
					} catch (ParseException e) {e.printStackTrace();}		    	
		    }
		    
		    
		    if (entry.getKey().toLowerCase().contains("filters[fApproveDataFrom]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse APPROVE DATA FROM ");
			    	try {
			    	vApproveDataFrom =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
			    	vApproveDateRestricted 	= true;
			    	} catch (ParseException e) {e.printStackTrace();}
		    }
		    
		    if (entry.getKey().toLowerCase().contains("filters[fApproveDataTo]".toLowerCase()) &&
		    		entry.getValue()[0].length()>0) {
		    	System.out.println("Parse APPROVE DATA TO ");
			    	try {
					vApproveDataTo =  new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(entry.getValue()[0]);
					vApproveDateRestricted 	= true;
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
	
		if (vBulletinPublishDateRestricted) {
			crit.add(Restrictions.between("bulletinPublishDate",vBulletinDataFrom,vBulletinDataTo));	
		}
		 if (vApproveDateRestricted){
			crit.add(Restrictions.between("publishDate",vApproveDataFrom,vApproveDataTo));	 
		}
		 
		 
		 if (vOrderByFieldName.contains(".")){
			 String lCriteria= "", lFieldName= "";	
			 lCriteria = vOrderByFieldName.substring(0, vOrderByFieldName.indexOf("."));
			 lFieldName = vOrderByFieldName.substring( vOrderByFieldName.indexOf(".") + 1, vOrderByFieldName.length() );
			 System.out.println(" Associated Ordering criteria = " + lCriteria );
			 System.out.println(" Remained   Ordering field = " + lFieldName);
			 vOrderByFieldName = lFieldName;
			 
			 if (vOrderByMode.equalsIgnoreCase("desc")) {
				 if (vOrderByFieldName.contains(".")) {
					 String zCriteria= "", zFieldName= "";	
					 zCriteria = vOrderByFieldName.substring(0, vOrderByFieldName.indexOf("."));
					 zFieldName = vOrderByFieldName.substring( vOrderByFieldName.indexOf(".") + 1, vOrderByFieldName.length() );
					 System.out.println(" Associated Z Ordering criteria = " + zCriteria );
					 System.out.println(" Remained  Z Ordering field = " + zFieldName);
					 vOrderByFieldName = zFieldName;
					 crit.createCriteria(lCriteria).createCriteria(zCriteria).addOrder( Order.desc(vOrderByFieldName));
				 } else {
					 crit.createCriteria(lCriteria).addOrder( Order.desc(vOrderByFieldName));
				 }
			 } else {
				 if (vOrderByFieldName.contains(".")) {
					 String zCriteria= "", zFieldName= "";	
					 zCriteria = vOrderByFieldName.substring(0, vOrderByFieldName.indexOf("."));
					 zFieldName = vOrderByFieldName.substring( vOrderByFieldName.indexOf(".") + 1, vOrderByFieldName.length() );
					 System.out.println(" Associated Z Ordering criteria = " + zCriteria );
					 System.out.println(" Remained  Z Ordering field = " + zFieldName);
					 vOrderByFieldName = zFieldName;
					 crit.createCriteria(lCriteria).createCriteria(zCriteria).addOrder( Order.asc(vOrderByFieldName));
				 } else {
					 crit.createCriteria(lCriteria).addOrder( Order.asc(vOrderByFieldName));
				 }
			 }
			 
		 } else {
			 if (vOrderByMode.equalsIgnoreCase("desc")) {
				 crit.addOrder( Order.desc(vOrderByFieldName));
			 } else {
				 crit.addOrder( Order.asc(vOrderByFieldName));
			 } 
		 }
		 
		
		 
		 

//			sidx
//			rows
//			sord
//			page
//			nd
//			_search
		 
		 
		 
		 
		List<IntentionAnounce>  result = crit.list();
		return result;
	}	
}


//if (vBulletinDataFrom != null){System.out.println("Parsed data's FROM : " + vBulletinDataFrom.toString());}
//if (vBulletinDataTo != null){System.out.println(" TO :"+ vBulletinDataTo.toString());}	
//String string = "January 2, 2010";
//Date date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(string);
   
//crit.createCriteria("tenderType").add(Restrictions.eq("ruValue", "Licitaţie publică"));
//crit.createCriteria("currentStatus").createCriteria("intentionStatus").add(Restrictions.eq("id", 5)); // Integer.parseInt(entry.getValue()[0])));		
//crit.setMaxResults(100);		
//crit.add( Restrictions.eq("tenderType.created", "Licitaţie publică") );
//List<Order> orders = session.createCriteria(Order.class)
//	    .createCriteria("user")
//	    	.add(eq("name", "fred"))
//	    .list();
//session.createCriteria(DriversLicence.class)
//   .add(Expression.or(
//     Expression.eq("licenceClass.type", "Car"),
//     Expression.eq("licenceClass.type", "Motorbike")
//   )
//).list();