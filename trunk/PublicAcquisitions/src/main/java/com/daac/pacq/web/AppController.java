package com.daac.pacq.web;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.daac.pacq.domain.entity.IntentionAnounce;
import com.daac.pacq.service.entity.IntentionAnounceService;

@Controller
public class AppController {

	@Autowired
	private IntentionAnounceService intentionAnounceService;	
	
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
    	
    	System.out.println(item.getRegNumber());
    	 map.put("intentionItem", item);
    	 //map.put("intentionId", request.getParameter("pid"));
    	 
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
    	System.out.println("AppController - contracteprocedura ");
    	map.put("tenderId", request.getParameter("pid"));
    	 return "contracteprocedura";    
    }    
    
    @RequestMapping("/index2") 
    public String index2(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - index2 ");
    	 return "index2";
    } 

    
    
	
}
