package com.daac.pacq.web;


import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daac.pacq.domain.entity.TenderDocument;
import com.daac.pacq.service.entity.TenderDocumentService;
//
//import com.sgam.mf.domain.sys.DBStoredFile;
//import com.sgam.mf.helper.ProxyCurrentUser;
//import com.sgam.mf.service.sys.SysDBStoredFileService;

@Controller
@RequestMapping("/f")
public class FileIOController {
		
	protected final Logger log = Logger.getLogger(getClass());
	
	@Autowired private TenderDocumentService 		tenderDocumentService;
	
  	
//  	public List<DBStoredFile> listDBStoredFile() {
//  		log.debug("AppController - listDBStoredFile");
//  		return sysDBStoredFileService.list(new ProxyCurrentUser()); 
//   	}  
// 	
//  	public  @ResponseBody List<DBStoredFile> listDBStoredFileJSON() {
//  		log.debug("AppController - listDBStoredFile");
//  		return sysDBStoredFileService.list(new ProxyCurrentUser()); 
//   	}    	
	
//  	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
//  	@ResponseBody
//  	public DBStoredFile uploadImage(MultipartHttpServletRequest request) {
//  		DBStoredFile result = null;
//  	    try {
//		  	
//  	    	Iterator<String> 	itr 			= request.getFileNames();
//  	    	String fileName = 	itr.next();
//  	    	
//		  	MultipartFile 		multipartFile 	= request.getFile(fileName);
//		
//		  	DBStoredFile dbFile = new DBStoredFile();
//		  	Integer fileSize 			= multipartFile.getBytes().length;
//		  	String  originalFileName 	= multipartFile.getOriginalFilename();
//		  	String  fileMimeType 		= multipartFile.getContentType();
//		  	
//		  	if (fileSize > 0) {  
//		  		dbFile.setFileName(originalFileName);
//		  		dbFile.setFileMimeType(fileMimeType);
//		  		
//		  		dbFile.setFileSize(fileSize);
//		  		dbFile.setParentDocumentId(0);
//		  		dbFile.setParentDocumentType("FOTO");
//		  		dbFile.setFileBlob(multipartFile.getBytes());
//		  		result = sysDBStoredFileService.update(dbFile, new ProxyCurrentUser());
//		  	}   
//		  	
//  	    } catch (Exception e) {
//  	 //Handle exception if any
//  	    }
//  	    return result;
//  	}   	
//  	
//	
// 	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//  	@ResponseBody
//  	public Integer uploadFile(MultipartHttpServletRequest request) {
// 		Integer result = 0;
//  	    try {
//		  	
//  	    	Iterator<String> 	itr 			= request.getFileNames();
//  	    	String fileName = 	itr.next();
//  	    	
//		  	MultipartFile 		multipartFile 	= request.getFile(fileName);
//		
//		  	DBStoredFile dbFile = new DBStoredFile();
//		  	Integer fileSize 			= multipartFile.getBytes().length;
//		  	String  originalFileName 	= multipartFile.getOriginalFilename();
//		  	String  fileMimeType 		= multipartFile.getContentType();
//		  	
//		  	if (fileSize > 0) {  
//		  		dbFile.setFileName(originalFileName);
//		  		dbFile.setFileMimeType(fileMimeType);
//		  		
//		  		dbFile.setFileSize(fileSize);
//		  		dbFile.setParentDocumentId(1);
//		  		dbFile.setParentDocumentType("TEST");
//		  		dbFile.setFileBlob(multipartFile.getBytes());
//		  		result = sysDBStoredFileService.update(dbFile, new ProxyCurrentUser()).getId();
//		  	}   
//		  	
//  	    } catch (Exception e) {
//  	 //Handle exception if any
//  	    }
//  	    return result;
//  	} 
 	
 	@RequestMapping(value = "/downlodFileById", method = RequestMethod.GET)
  	@ResponseBody
  	public void downloadFile(Model model, HttpServletResponse response, @RequestParam(value="pId") Integer pId) {
  	    try {
		  	 
    	TenderDocument fileItem = tenderDocumentService.get(pId);
  	    	byte[] fileBytes = fileItem.getContent();
  	    	
  	    	//response.setContentType( fileItem.getFileMimeType() );
  	    	response.setContentType( "doc" );
  	    	response.setHeader("Content-Disposition","attachment; filename=\""+ URLEncoder.encode(fileItem.getFileName(), "UTF-8") +"\"");
            response.setHeader("cache-control", "no-cache");
            response.setHeader("cache-control", "must-revalidate");

            response.getOutputStream().write(fileBytes);
            response.flushBuffer();
  	    } catch (Exception e) {
  	 //Handle exception if any
  	    }
  	} 
 	
	
 
  	
  	
}
    
	
