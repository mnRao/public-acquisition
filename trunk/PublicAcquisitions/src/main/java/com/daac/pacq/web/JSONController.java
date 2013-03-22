package com.daac.pacq.web;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.daac.pacq.domain.entity.Complaint;
import com.daac.pacq.domain.entity.Contract;
import com.daac.pacq.domain.entity.IntentionAnounce;
import com.daac.pacq.domain.entity.IntentionAnounceStatus;
import com.daac.pacq.domain.entity.NotAllowedEconomicOperator;
import com.daac.pacq.domain.entity.QualifiedEconomicOperator;
import com.daac.pacq.domain.entity.Tender;
import com.daac.pacq.domain.ref.IntentionStatus;
import com.daac.pacq.domain.ref.PositionType;
import com.daac.pacq.domain.ref.TenderType;
import com.daac.pacq.helpers.FlexGridListWrapper;
import com.daac.pacq.service.entity.ComplaintService;
import com.daac.pacq.service.entity.ContractService;
import com.daac.pacq.service.entity.IntentionAnounceService;
import com.daac.pacq.service.entity.IntentionAnounceStatusService;
import com.daac.pacq.service.entity.NotAllowedEconomicOperatorService;
import com.daac.pacq.service.entity.QualifiedEconomicOperatorService;
import com.daac.pacq.service.entity.TenderService;
import com.daac.pacq.service.ref.IntentionStatusService;
import com.daac.pacq.service.ref.PositionTypeService;
import com.daac.pacq.service.ref.TenderTypeService;


@Controller 
@RequestMapping("/json")
public class JSONController {

	@Autowired
	private TenderTypeService tenderTypeService;
	
	@Autowired
	private PositionTypeService positionTypeService;
	
	@Autowired
	private IntentionStatusService intentionStatusService;
	
	@Autowired
	private IntentionAnounceStatusService intentionAnounceStatusService;
	
	@Autowired
	private TenderService 	tenderService;
	
	@Autowired
	private IntentionAnounceService intentionAnounceService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private ComplaintService сomplaintService;	
	
	@Autowired
	private  NotAllowedEconomicOperatorService notAllowedEconomicOperatorService;
	
	@Autowired
	private  QualifiedEconomicOperatorService qualifiedEconomicOperatorService; 
	
	
	   @RequestMapping(value="/ping",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody String test(WebRequest request) {    
	    	System.out.println("JSONController - PING");
	    	System.out.println(request.toString());

	    	return new Date().toString();  
	    } 
	   
	   
	   @RequestMapping(value="/tenderTypeList",   method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody List<TenderType> tenderTypeList(WebRequest request) { 
		   System.out.println("JSONController - TENDER TYPE LIST");
	    	System.out.println(request.toString());

	    	return  tenderTypeService.list();
	    }	   

	   @RequestMapping(value="/positionTypeList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody List<PositionType> positionTypeList(WebRequest request) { 
		   System.out.println("JSONController - POSITION TYPE LIST");
	    	System.out.println(request.toString());

	    	return  positionTypeService.list();
	    }
	   
	   @RequestMapping(value="/intentionStatusList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody List<IntentionStatus> intentionStatusList(WebRequest request) { 
		   System.out.println("JSONController - INTENTION STATUS LIST");
	    	System.out.println(request.toString());

	    	return  intentionStatusService.list();
	    }	  	 
	   
   
	   
	   @RequestMapping(value="/intentionAnounceStatusList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody List<IntentionAnounceStatus> intentionAnounceStatusList(WebRequest request) { 
		   System.out.println("JSONController - INTENTION ANOUNCE STATUS LIST");
	    	System.out.println(request.toString());

	    	return  intentionAnounceStatusService.list();
	    }		
	   
	   @RequestMapping(value="/intentionAnounceStatusItem",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody IntentionAnounceStatus intentionAnounceStatusItem(WebRequest request) { 
		   System.out.println("JSONController - INTENTION ANOUNCE STATUS ITEM");
	    	System.out.println(request.toString());

	    	return  intentionAnounceStatusService.get(286210);
	    }		   
	   
	   
	   @RequestMapping(value="/tenderList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody FlexGridListWrapper<Tender> tenderList(WebRequest request) { 
		   System.out.println("JSONController - TENDER LIST");
	    	System.out.println(request.toString());
	    	List<Tender> result = tenderService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	FlexGridListWrapper<Tender> jdw = new FlexGridListWrapper<Tender>(1, result.size(), result);  
	    	 return jdw;  
	    }		
	   
	   @RequestMapping(value="/intentionAnounceList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody FlexGridListWrapper<IntentionAnounce> intentionAnounceList(WebRequest request) { 
		   System.out.println("JSONController - INTENTION ANOUNCE LIST");
		   System.out.println(request.toString());
		   System.out.println(request.getParameterMap().toString());
		   
		   Iterator<String> userFiltersIter = request.getParameterNames();
		   while ( userFiltersIter.hasNext() ){
			   String paramName = userFiltersIter.next();
			      System.out.println(paramName + " = " + request.getParameter(paramName) );
			    }

		   
		   
	    	List<IntentionAnounce> result = intentionAnounceService.search(request.getParameterMap());
	    	
	    	
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	FlexGridListWrapper<IntentionAnounce> jdw = new FlexGridListWrapper<IntentionAnounce>(1, result.size(), result);  
	    	 return jdw;  
	    }	
	   
	   @RequestMapping(value="/intentionAnounceItem",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody IntentionAnounce intentionAnounceItem(WebRequest request) { 
		   System.out.println("JSONController - INTENTION ANOUNCE ITEM");
	    	System.out.println(request.toString());
	    	IntentionAnounce result = intentionAnounceService.get(312750); 
	    	 return result;  
	    }
	   
	   
	   @RequestMapping(value="/contractList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody FlexGridListWrapper<Contract> contractList(WebRequest request) { 
		   System.out.println("JSONController - CONTRACT LIST");
	    	System.out.println(request.toString());
	    	List<Contract> result = contractService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	FlexGridListWrapper<Contract> jdw = new FlexGridListWrapper<Contract>(1, result.size(), result);  
	    	 return jdw;  
	    }	
	   
	   @RequestMapping(value="/complaintList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody FlexGridListWrapper<Complaint> complaintList(WebRequest request) { 
		   System.out.println("JSONController - COMPLAINT LIST");
	    	System.out.println(request.toString());
	    	List<Complaint> result = сomplaintService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	FlexGridListWrapper<Complaint> jdw = new FlexGridListWrapper<Complaint>(1, result.size(), result);  
	    	return jdw;  
	    }	
	   
	   @RequestMapping(value="/whiteList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody FlexGridListWrapper<QualifiedEconomicOperator> whiteList(WebRequest request) { 
		   System.out.println("JSONController - WHITE LIST");
	    	System.out.println(request.toString());
	    	List<QualifiedEconomicOperator> result = qualifiedEconomicOperatorService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	FlexGridListWrapper<QualifiedEconomicOperator> jdw = new FlexGridListWrapper<QualifiedEconomicOperator>(1, result.size(), result);  
	    	return jdw;  
	    }	
	   
	   @RequestMapping(value="/blackList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody FlexGridListWrapper<NotAllowedEconomicOperator> blackList(WebRequest request) { 
		   System.out.println("JSONController - BLACK LIST");
	    	System.out.println(request.toString());
	    	List<NotAllowedEconomicOperator> result = notAllowedEconomicOperatorService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	FlexGridListWrapper<NotAllowedEconomicOperator> jdw = new FlexGridListWrapper<NotAllowedEconomicOperator>(1, result.size(), result);  
	    	return jdw;  
	    }
	   
	   @RequestMapping(value="/tenderCard",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody Tender tenderCard(WebRequest request) { 
		   System.out.println("JSONController - TENDER CARD for ID="+Integer.valueOf(request.getParameter("id")));
	    	//System.out.println(request.toString());
	    	Tender result = tenderService.get(Integer.valueOf(request.getParameter("id"))); 
	    	//System.out.println("RECORDS RCVD = " + result.size());
	    	//FlexGridListWrapper<Tender> jdw = new FlexGridListWrapper<Tender>(1, result.size(), result);  
	    	 return result;  
	    }	
	   
}
