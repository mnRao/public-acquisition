package com.daac.pacq.web;

import java.security.Principal;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AppController {

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
    	 
    	 
    @RequestMapping("/index2") 
    public String index2(Map<String, Object> map, WebRequest request, Principal principal) {
    	System.out.println("AppController - index2 ");
    	 return "index2";
    } 
       	    
    
	
}
