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
import com.daac.pacq.domain.entity.Question;
import com.daac.pacq.domain.entity.Tender;
import com.daac.pacq.domain.entity.TenderPosition;
import com.daac.pacq.domain.ref.IntentionStatus;
import com.daac.pacq.domain.ref.PositionType;
import com.daac.pacq.domain.ref.TenderStatus;
import com.daac.pacq.domain.ref.TenderType;
import com.daac.pacq.helpers.JQGridListWrapper;
import com.daac.pacq.service.entity.ComplaintService;
import com.daac.pacq.service.entity.ContractService;
import com.daac.pacq.service.entity.IntentionAnounceService;
import com.daac.pacq.service.entity.IntentionAnounceStatusService;
import com.daac.pacq.service.entity.NotAllowedEconomicOperatorService;
import com.daac.pacq.service.entity.QualifiedEconomicOperatorService;
import com.daac.pacq.service.entity.QuestionService;
import com.daac.pacq.service.entity.TenderPositionService;
import com.daac.pacq.service.entity.TenderService;
import com.daac.pacq.service.ref.IntentionStatusService;
import com.daac.pacq.service.ref.PositionTypeService;
import com.daac.pacq.service.ref.TenderStatusService;
import com.daac.pacq.service.ref.TenderTypeService;


/**
 * @author Serghey.Golub
 *
 */
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
	
	@Autowired
	private TenderPositionService 	tenderPositionService;
	
	@Autowired
	private QuestionService			questionService;
	
	@Autowired
	private TenderStatusService			tenderStatusService;
	
	
	
	
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
	   

	   @RequestMapping(value="/tenderStatusList",  method = { RequestMethod.GET, RequestMethod.POST })
			public @ResponseBody List<TenderStatus> tenderStatusList(WebRequest request) { 
			   System.out.println("JSONController - INTENTION STATUS LIST");
		    	System.out.println(request.toString());

		    	return  tenderStatusService.list();
		    }	  	 
		   
	   
	   
	   
	   
	   @RequestMapping(value="/tenderList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<Tender> tenderList(WebRequest request) { 
		   		System.out.println("JSONController - TENDER LIST");
		   		System.out.println(request.toString());
		   		System.out.println(request.getParameterMap().toString());
			   
			   Iterator<String> userFiltersIter = request.getParameterNames();
			   while ( userFiltersIter.hasNext() ){
				   String paramName = userFiltersIter.next();
				      System.out.println(paramName + " = " + request.getParameter(paramName) );
				    }
	    	
	    	List<Tender> result = tenderService.search(request.getParameterMap());
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<Tender> jdw = new JQGridListWrapper<Tender>(10, 1, result.size(), result);  
	    	 return jdw;  
	    }		
	   
	   
    /**
     * Handle "json/intentionAnounceList" - for INTENTION ANOUNCE PAGINATED FILTERED LIST
	 * @param request - Web request from jqGrid, what contains all pagination and filtration paramenters. 
	 * @return JSON - serialised list of INTENTION ANOUNCE
	 */
	@RequestMapping(value="/intentionAnounceList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<IntentionAnounce> intentionAnounceList(WebRequest request) { 
		   System.out.println("JSONController - INTENTION ANOUNCE LIST");
		   System.out.println(request.toString());
		   System.out.println(request.getParameterMap().toString());
		   int currentPageNumber = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):1;
		   int rowsPerPage 		 = request.getParameter("rows")!=null?Integer.parseInt(request.getParameter("rows")):10;
		   
		   Iterator<String> userFiltersIter = request.getParameterNames();
		   while ( userFiltersIter.hasNext() ){
			   	  String paramName = userFiltersIter.next();
			      System.out.println(paramName + " = " + request.getParameter(paramName) );
			    }
		   
	    	List<IntentionAnounce> result = intentionAnounceService.search(request.getParameterMap());
	    	System.out.println("RECORDS RCVD = " + result.size());

	    	int totalPages = result.size()/rowsPerPage + (result.size()%rowsPerPage>0?1:0);
	    	System.out.println("totalPages :" + totalPages);
	    	
	    	if (currentPageNumber > totalPages) currentPageNumber = 1;
	    	int vFromIndex = rowsPerPage * (currentPageNumber-1);
	    	int vToIndex = (rowsPerPage * currentPageNumber >result.size())?(result.size()):(rowsPerPage * currentPageNumber);
	    	
	    	JQGridListWrapper<IntentionAnounce> jdw = 
	    			new JQGridListWrapper<IntentionAnounce>(totalPages, currentPageNumber, result.size(), result.subList(vFromIndex, vToIndex ));  
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
		public @ResponseBody JQGridListWrapper<Contract> contractList(WebRequest request) { 
		   System.out.println("JSONController - CONTRACT LIST");
	    	System.out.println(request.toString());
	    	List<Contract> result = contractService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<Contract> jdw = new JQGridListWrapper<Contract>(10, 1, result.size(), result);  
	    	 return jdw;  
	    }	
	   
	   @RequestMapping(value="/complaintList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<Complaint> complaintList(WebRequest request) { 
		   System.out.println("JSONController - COMPLAINT LIST");
	    	System.out.println(request.toString());
	    	List<Complaint> result = сomplaintService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<Complaint> jdw = new JQGridListWrapper<Complaint>(10, 1, result.size(), result);  
	    	return jdw;  
	    }	
	   
	   @RequestMapping(value="/whiteList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<QualifiedEconomicOperator> whiteList(WebRequest request) { 
		   System.out.println("JSONController - WHITE LIST");
	    	System.out.println(request.toString());
	    	List<QualifiedEconomicOperator> result = qualifiedEconomicOperatorService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<QualifiedEconomicOperator> jdw = new JQGridListWrapper<QualifiedEconomicOperator>(10, 1, result.size(), result);  
	    	return jdw;  
	    }	
	   
	   @RequestMapping(value="/blackList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<NotAllowedEconomicOperator> blackList(WebRequest request) { 
		   System.out.println("JSONController - BLACK LIST");
	    	System.out.println(request.toString());
	    	List<NotAllowedEconomicOperator> result = notAllowedEconomicOperatorService.list(); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<NotAllowedEconomicOperator> jdw = new JQGridListWrapper<NotAllowedEconomicOperator>(10, 1, result.size(), result);  
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
	   
	   
	   @RequestMapping(value="/positionList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<TenderPosition> positionList(WebRequest request) { 
		   System.out.println("JSONController - TENDER POSITION LIST for TenderDataId="+request.getParameter("id"));
	    	System.out.println(request.toString());
	    	List<TenderPosition> result = tenderPositionService.list(Integer.valueOf(request.getParameter("id"))); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<TenderPosition> jdw = new JQGridListWrapper<TenderPosition>(10, 1, result.size(), result);  
	    	return jdw;  
	    }
	   
	   @RequestMapping(value="/explicatiiList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<Question> explicatiiList(WebRequest request) { 
		   System.out.println("JSONController - TENDER EXPICATION LIST for TenderId="+request.getParameter("id"));
	    	System.out.println(request.toString());
	    	List<Question> result = questionService.list(Integer.valueOf(request.getParameter("id"))); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<Question> jdw = new JQGridListWrapper<Question>(10, 1, result.size(), result); 
	    	//List<Question> jdw = new Lis<Question>(1, result.size(), result);
	    	return jdw;  
	    }
	   
}
