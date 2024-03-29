package com.daac.pacq.web;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
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
import com.daac.pacq.domain.entity.TenderDocument;
import com.daac.pacq.domain.entity.TenderPosition;
import com.daac.pacq.domain.entity.Visits;
import com.daac.pacq.domain.ref.ContractType;
import com.daac.pacq.domain.ref.IntentionStatus;
import com.daac.pacq.domain.ref.PositionType;
import com.daac.pacq.domain.ref.TenderStatus;
import com.daac.pacq.domain.ref.TenderType;
import com.daac.pacq.helpers.JQGridListWrapper;
import com.daac.pacq.helpers.VisitsCounter;
import com.daac.pacq.service.entity.ComplaintService;
import com.daac.pacq.service.entity.ContractService;
import com.daac.pacq.service.entity.IntentionAnounceService;
import com.daac.pacq.service.entity.IntentionAnounceStatusService;
import com.daac.pacq.service.entity.NotAllowedEconomicOperatorService;
import com.daac.pacq.service.entity.QualifiedEconomicOperatorService;
import com.daac.pacq.service.entity.QuestionService;
import com.daac.pacq.service.entity.TenderDocumentService;
import com.daac.pacq.service.entity.TenderPositionService;
import com.daac.pacq.service.entity.TenderService;
import com.daac.pacq.service.entity.VisitsService;
import com.daac.pacq.service.ref.ContractTypeService;
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
	private TenderDocumentService 	tenderDocumentService;
	
	@Autowired
	private QuestionService			questionService;
	
	@Autowired
	private TenderStatusService			tenderStatusService;
	
	@Autowired
	private ContractTypeService			сontractTypeService;
	
	
	
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
	   
	   @RequestMapping(value="/contractTypeList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody List<ContractType> contractTypeList(WebRequest request) { 
		   System.out.println("JSONController - CONTRACT TYPE LIST");
	    	System.out.println(request.toString());

	    	return  сontractTypeService.list();
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
		   		int currentPageNumber = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):1;
			   int rowsPerPage 		 = request.getParameter("rows")!=null?Integer.parseInt(request.getParameter("rows")):10;
			   
			   Iterator<String> userFiltersIter = request.getParameterNames();
			   while ( userFiltersIter.hasNext() ){
				   String paramName = userFiltersIter.next();
				      System.out.println(paramName + " = " + request.getParameter(paramName) );
				    }
	    	
	    	List<Tender> result = tenderService.search(request.getParameterMap());
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	
	    	int totalPages = result.size()/rowsPerPage + (result.size()%rowsPerPage>0?1:0);
	    	System.out.println("totalPages :" + totalPages);
	    	
	    	if (currentPageNumber > totalPages) currentPageNumber = 1;
	    	int vFromIndex = rowsPerPage * (currentPageNumber-1);
	    	int vToIndex = (rowsPerPage * currentPageNumber >result.size())?(result.size()):(rowsPerPage * currentPageNumber);
	    	
	    	JQGridListWrapper<Tender> jdw = new JQGridListWrapper<Tender>(totalPages, currentPageNumber, result.size(), result.subList(vFromIndex, vToIndex ));  
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
		   System.out.println(request.getParameterMap().toString());
		   int currentPageNumber = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):1;
		   int rowsPerPage 		 = request.getParameter("rows")!=null?Integer.parseInt(request.getParameter("rows")):10;
		   
		   Iterator<String> userFiltersIter = request.getParameterNames();
		   while ( userFiltersIter.hasNext() ){
			   	  String paramName = userFiltersIter.next();
			      System.out.println(paramName + " = " + request.getParameter(paramName) );
			    }
		   
	    	List<Contract> result = contractService.search(request.getParameterMap());
	    	System.out.println("RECORDS RCVD = " + result.size());

	    	int totalPages = result.size()/rowsPerPage + (result.size()%rowsPerPage>0?1:0);
	    	System.out.println("totalPages :" + totalPages);
	    	
	    	if (currentPageNumber > totalPages) currentPageNumber = 1;
	    	int vFromIndex = rowsPerPage * (currentPageNumber-1);
	    	int vToIndex = (rowsPerPage * currentPageNumber >result.size())?(result.size()):(rowsPerPage * currentPageNumber);
	    	
	    	JQGridListWrapper<Contract> jdw = 
	    			new JQGridListWrapper<Contract>(totalPages, currentPageNumber, result.size(), result.subList(vFromIndex, vToIndex ));  
	    	 return jdw;  
		
	    }	
	   
	   @RequestMapping(value="/contractCardList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<Contract> contractCardList(WebRequest request) { 
		   System.out.println("JSONController - TENDER CARD CONTRACT LIST for TenderId="+request.getParameter("id"));
	    	System.out.println(request.toString());
	    	List<Contract> result = contractService.list(Integer.valueOf(request.getParameter("id"))); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<Contract> jdw = new JQGridListWrapper<Contract>(10, 1, result.size(), result); 
	    	//List<Question> jdw = new Lis<Question>(1, result.size(), result);
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
		   System.out.println(request.getParameterMap().toString());
		   int currentPageNumber = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):1;
		   int rowsPerPage 		 = request.getParameter("rows")!=null?Integer.parseInt(request.getParameter("rows")):10;
		   
		   Iterator<String> userFiltersIter = request.getParameterNames();
		   while ( userFiltersIter.hasNext() ){
			   	  String paramName = userFiltersIter.next();
			      System.out.println(paramName + " = " + request.getParameter(paramName) );
			    }
		   
	    	List<QualifiedEconomicOperator> result = qualifiedEconomicOperatorService.search(request.getParameterMap());
	    	System.out.println("RECORDS RCVD = " + result.size());

	    	int totalPages = result.size()/rowsPerPage + (result.size()%rowsPerPage>0?1:0);
	    	System.out.println("totalPages :" + totalPages);
	    	
	    	if (currentPageNumber > totalPages) currentPageNumber = 1;
	    	int vFromIndex = rowsPerPage * (currentPageNumber-1);
	    	int vToIndex = (rowsPerPage * currentPageNumber >result.size())?(result.size()):(rowsPerPage * currentPageNumber);
	    	
	    	JQGridListWrapper<QualifiedEconomicOperator> jdw = 
	    			new JQGridListWrapper<QualifiedEconomicOperator>(totalPages, currentPageNumber, result.size(), result.subList(vFromIndex, vToIndex ));  
	    	 return jdw;  	    	
	    }	
	   
	   @RequestMapping(value="/blackList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<NotAllowedEconomicOperator> blackList(WebRequest request) { 
		   System.out.println("JSONController - BLACK LIST");
		   System.out.println(request.toString());
		   System.out.println(request.getParameterMap().toString());
		   int currentPageNumber = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):1;
		   int rowsPerPage 		 = request.getParameter("rows")!=null?Integer.parseInt(request.getParameter("rows")):10;
		   
		   Iterator<String> userFiltersIter = request.getParameterNames();
		   while ( userFiltersIter.hasNext() ){
			   	  String paramName = userFiltersIter.next();
			      System.out.println(paramName + " = " + request.getParameter(paramName) );
			    }
		   
	    	List<NotAllowedEconomicOperator> result = notAllowedEconomicOperatorService.search(request.getParameterMap());
	    	System.out.println("RECORDS RCVD = " + result.size());

	    	int totalPages = result.size()/rowsPerPage + (result.size()%rowsPerPage>0?1:0);
	    	System.out.println("totalPages :" + totalPages);
	    	
	    	if (currentPageNumber > totalPages) currentPageNumber = 1;
	    	int vFromIndex = rowsPerPage * (currentPageNumber-1);
	    	int vToIndex = (rowsPerPage * currentPageNumber >result.size())?(result.size()):(rowsPerPage * currentPageNumber);
	    	
	    	JQGridListWrapper<NotAllowedEconomicOperator> jdw = 
	    			new JQGridListWrapper<NotAllowedEconomicOperator>(totalPages, currentPageNumber, result.size(), result.subList(vFromIndex, vToIndex ));  
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
	   
	   @RequestMapping(value="/documentsList",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody JQGridListWrapper<TenderDocument> documentsList(WebRequest request) { 
		   System.out.println("JSONController - TENDER DOCUMENTS LIST for TenderDataId="+request.getParameter("id"));
	    	System.out.println(request.toString());
	    	List<TenderDocument> result = tenderDocumentService.list(Integer.valueOf(request.getParameter("id"))); 
	    	System.out.println("RECORDS RCVD = " + result.size());
	    	JQGridListWrapper<TenderDocument> jdw = new JQGridListWrapper<TenderDocument>(10, 1, result.size(), result);  
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

	   @Autowired
		private VisitsCounter visitsCounter;
	   @Autowired
	   private VisitsService visitsService;
	   
	   @RequestMapping(value="/visits",  method = { RequestMethod.GET, RequestMethod.POST })
		public @ResponseBody Visits visits(WebRequest request) { 
		   System.out.println("JSONController - VISITS COUNTER");
	    	System.out.println(request.toString());
	    	
	    	int isOldSession = visitsCounter.getIsOldSession();
	    	
			Date currentServerDate =  DateUtils.truncate(new Date(), Calendar.DATE);
			
			Visits startResult = visitsService.get(currentServerDate);
			Visits tempResult;
			Visits finishResult;
			
			/* IF NO Record for currentServerDate then create it*/
			if (startResult == null) {
				System.out.println("RESULT IS NULL");
				tempResult = new Visits();
				tempResult.setVisitDate(currentServerDate);
				tempResult.setCount(0);
				visitsService.add(tempResult);
				startResult = visitsService.get(currentServerDate);
				
			} else {
				System.out.println("RESULT IS NOT NULL");
			}
			
			System.out.println("STEP 1");
			System.out.println(startResult.toString());

			/* IF NEW VISIT increase IT it*/
			if (isOldSession==0){
				System.out.println("THIS IS NEW SESSION");	
				int oldCount;
				oldCount = startResult.getCount();
				startResult.setCount(oldCount+1);
				visitsService.update(startResult);
			} else {
				System.out.println("THIS IS OLD SESSION");	
			}
			
			System.out.println("STEP 2");
			System.out.println(startResult.toString());
			
			/* GET RESULT */
			finishResult = visitsService.get(currentServerDate);
			
			System.out.println("STEP 3");
			System.out.println(finishResult.toString());

			return finishResult;	    	
	    	
	   }
	   
//	   @RequestMapping(value="/visits",  method = { RequestMethod.GET, RequestMethod.POST })
//		public @ResponseBody Visits visits(WebRequest request) { 
//		   System.out.println("JSONController - VISITS COUNTER");
//	    	System.out.println(request.toString());
//	    	int isOld = visitsCounter.getIsOldSession();
//	    	System.out.println("Visits Counter Helper 'isOldSession'= " + isOld);
//	    	Visits result = visitsService.getCurrentVisits(isOld);
//	    	return result;
//	   }
	   	   
}
