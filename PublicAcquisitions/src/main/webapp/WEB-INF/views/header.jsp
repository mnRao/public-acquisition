<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" 	uri="http://tiles.apache.org/tags-tiles" %>

<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
	function setMenuSelection(activateMenuItemName){

		if (activateMenuItemName=="proceduri") {
			$("#proceduri").css( "background", "#990066" );	
		}
		
		if (activateMenuItemName=="intentii") {
			$("#intentii").css( "background", "#990066" );	
		}
		
		if (activateMenuItemName=="contracte") {
			$("#contracte").css( "background", "#990066" );	
		} 		
		
		if (activateMenuItemName=="whiteList") {
			$("#whiteList").css( "background", "#990066" );	
		}
		
		if (activateMenuItemName=="blackList") {
			$("#blackList").css( "background", "#990066" );	
		}
		
	}		
	
</script>

<a href="#" id="logo">
	<img src="resources/images/logo.png" height="46px" width="35px"/>

<!-- 	<span>Registrul de stat al achiziţiilor publice - Регистр Государственных закупок</span> -->

	<span><spring:message code="label.title"/></span>
</a>
<div id="user-info-container">
	<span style="float: right">
	    <a href="?lang=md">Md</a>
	    | 
	    <a href="?lang=ru">Ru</a>
	    |
	    <a href="?lang=en">En</a>
	</span>

	<div>
		Current Locale : ${pageContext.response.locale}
		<a href="#">Înregistrarea în sistem</a>
	</div>
</div>
<div id="menu-container">
	<a id="proceduri" 	href="proceduri" >			<spring:message code="label.module_name.proceduri"/></a>
	<a id="intentii" 	href="intentii">				<spring:message code="label.module_name.intentii"/></a>
	<a id="contracte" 	href="contracte">			<spring:message code="label.module_name.contracte"/></a>
	<a id="contestatii" href="contestatii">			<spring:message code="label.module_name.contestatii"/></a>
	<a id="whiteList" 	href="whiteList">			<spring:message code="label.module_name.whiteList"/></a>
    <a id="blackList"	href="blackList">			<spring:message code="label.module_name.blackList"/></a>
          <div id='help'>
          	<a href='#'>
              	<img src='resources/images/help_icon.gif'/>
                  <span><spring:message code="label.help"/></span>
              </a>
          </div>
</div>				