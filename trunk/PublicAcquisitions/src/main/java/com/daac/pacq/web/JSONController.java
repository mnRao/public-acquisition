package com.daac.pacq.web;

import java.util.Date;
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
import com.daac.pacq.domain.ref.IntentionStatus;
import com.daac.pacq.domain.ref.PositionType;
import com.daac.pacq.domain.ref.TenderType;
import com.daac.pacq.helpers.FlexGridListWrapper;
import com.daac.pacq.service.entity.ComplaintService;
import com.daac.pacq.service.entity.ContractService;
import com.daac.pacq.service.entity.IntentionAnounceService;
import com.daac.pacq.service.entity.IntentionAnounceStatusService;
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
	private IntentionAnounceService intentionAnounceService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private ComplaintService сomplaintService;	
	
	
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
	   
	   
	   @RequestMapping(value="/intentionAnounceList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody FlexGridListWrapper<IntentionAnounce> intentionAnounceList(WebRequest request) { 
		   System.out.println("JSONController - INTENTION ANOUNCE LIST");
	    	System.out.println(request.toString());
	    	List<IntentionAnounce> result = intentionAnounceService.list(); 
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
}
