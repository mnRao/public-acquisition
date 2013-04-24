package com.daac.pacq.web;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.daac.pacq.domain.entity.IntentionAnounce;
import com.daac.pacq.domain.entity.Visits;
import com.daac.pacq.helpers.VisitsCounter;
import com.daac.pacq.service.entity.IntentionAnounceService;
import com.daac.pacq.service.entity.VisitsService;

@Controller
public class AppController {

	
	@Autowired
	private IntentionAnounceService intentionAnounceService;	
	
	@Autowired
	private VisitsCounter visitsCounter;
	
    @RequestMapping("/")
    public String home(WebRequest request) {
    	System.out.println("AppController - redirection to INDEX");
        return "redirect:/index";
    }    
         
           
    @RequestMapping("/index") 
    public String index(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - index "); 
    	 return "index";
    } 
    
    @RequestMapping("/proceduri") 
    public String proceduri(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - proceduri ");
    	 return "proceduri";
    }    
    
    @RequestMapping("/intentii") 
    public String intentii(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - intentii ");    	
    	 return "intentii";    
    }
    
    @RequestMapping("/intentiiCard") 
    public String intentiiCard(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - intentiiCard ");
    	IntentionAnounce item = intentionAnounceService.get(Integer.parseInt( request.getParameter("pid")));
    	
    	 map.put("intentionItem", item);
    	 return "intentiiCard";
    }           
    
    @RequestMapping("/contracte") 
    public String contracte(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - contracte ");    	
    	 return "contracte";    
    }    
    
    @RequestMapping("/contestatii") 
    public String contestatii(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - contestatii ");    	
    	 return "contestatii";    
    }    
    
    @RequestMapping("/whiteList") 
    public String whiteList(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - whiteList ");    	
    	 return "whiteList";    
    }    
    	 
    
    @RequestMapping("/blackList") 
    public String blackList(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - blackList ");    	
    	 return "blackList";    
    }    
    	     	 
    @RequestMapping("/proceduricard")  
    public String proceduricard(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - proceduricard ");    	
    	 map.put("tenderId", request.getParameter("pid"));
    	 return "proceduricard";    
    }      
    
    @RequestMapping("/explicatii") 
    public String explicatii(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - explicatii ");
    	map.put("tenderId", request.getParameter("pid"));
    	 return "explicatii";    
    }    
    
    @RequestMapping("/contracteprocedura") 
    public String contracteprocedura(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - contracteprocedura for Id="+request.getParameter("pid"));
    	map.put("tenderId", request.getParameter("pid"));
    	 return "contracteprocedura";    
    }    
    
    @RequestMapping("/plingeri") 
    public String plingeri(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - plingeri for Id="+request.getParameter("pid"));
    	map.put("tenderId", request.getParameter("pid"));
    	 return "plingeri";    
    }    
    
    @RequestMapping("/index2") 
    public String index2(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - index2 ");
    	 return "index2";
    } 

    /* TESTING PURPOSES*/
    @Autowired
	   private VisitsService visitsService;
    
    @RequestMapping("/counter") 
    public String counter(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - COUNTER");
    	
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

			map.put("cntDay", finishResult.getCount());
			map.put("cntTotal", finishResult.getCountTotal());
	    	
    	return "counter";
    }
    
    @RequestMapping("/footer") 
    public String footer(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - FOOTER");
    	
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

			map.put("cntDay", finishResult.getCount());
			map.put("cntTotal", finishResult.getCountTotal());
	    	
    	return "footer";
    }    
    
    
    
	
}
