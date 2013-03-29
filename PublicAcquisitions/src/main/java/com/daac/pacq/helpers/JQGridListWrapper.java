package com.daac.pacq.helpers;

import java.io.Serializable;
import java.util.List;

/** 
 * Wrapper class for JSON data to send to the client. 
 *  
 * Currently we are using JQGrid for displaying JSON data in table. 
 
 *  
 * jQuery JQGrid plug-in requires data to be in the below specified format. 
 *  
 *	{ 
 *		"total": "xxx", 
 *		"page": "yyy", 
 *		"records": "zzz",
 *		"rows" : [
 *		    {"id" :"1", "cell" :["cell11", "cell12", "cell13"]},
 *		    {"id" :"2", "cell":["cell21", "cell22", "cell23"]},
 *		      ...
 *		  ]
 *	}
 *  
 * @param T generic data type for list of objects to be sent in the JSON response. 
 */  
public class JQGridListWrapper<T> implements Serializable {  
	
	 private static final long serialVersionUID = 1L;  

	 //total number of PAGES for the given entity.  
	 private long total;  
	 //current page  
	 private int page;  

	 //total number of records for the query
	 private long records;
	 
	 //list of records to be displayed.  
	 private List<T> rows;  
	  
	 public JQGridListWrapper(long total, int page, long records,  List<T> rows) {
		 this.total = total;  
		 this.page = page;
		 this.records = records;
		 this.rows = rows;  
	 }

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 
	 

}
