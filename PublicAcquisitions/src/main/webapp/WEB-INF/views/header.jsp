<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

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
	<a href="proceduri">	<spring:message code="lable.module_name.proceduri"/></a>
	<a href="intentii">		<spring:message code="lable.module_name.intentii"/></a>
	<a href="contracte">			<spring:message code="lable.module_name.contracte"/></a>
	<a href="contestatii">			<spring:message code="lable.module_name.contestatii"/></a>
	<a href="whiteList">			<spring:message code="lable.module_name.whiteList"/></a>
    <a href="blackList">			<spring:message code="lable.module_name.blackList"/></a>
          <div id='help'>
          	<a href='#'>
              	<img src='resources/images/help_icon.gif'/>
                  <span><spring:message code="label.help"/></span>
              </a>
          </div>
</div>				