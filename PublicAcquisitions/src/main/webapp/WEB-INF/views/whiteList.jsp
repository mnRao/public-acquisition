<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){

	setMenuSelection("whiteList");
	var w = screen.width*0.98;
	var curLangRef = "${pageContext.response.locale}" + 'Value';
	
	$("#list").jqGrid({
		jsonReader : {
		      root:"rows",
		      page: "page",
		      total: "total",
		      records: "records",
		      repeatitems: false,
		      id: "0"
		   },	
	   	url:'json/whiteList',
		datatype: "json",
		mtype: 'POST',
	   	colNames:[	'#',
	   	          	'<spring:message code="label.decisionNumb"/>',
	   	       		'<spring:message code="label.decisionDate"/>',
		   			'<spring:message code="label.juristicPerson"/>',
		   			'<spring:message code="label.code"/>',
		   			'<spring:message code="label.legalForm"/>',
		   			'<spring:message code="label.name"/>',
		   			'<spring:message code="label.address"/>',
		   			'<spring:message code="label.phone"/>',
		   			'<spring:message code="label.email"/>'],
	   	colModel:[
	   		{name:'id',							index:'id', 							width:200, hidden: true},
	   		{name:'decisionNumb',				index:'decisionNumb', 					width:500},
	   		{name:'decisionDate',				index:'decisionDate',			 		width:500},
	   		{name:'personType.'+curLangRef,		index:'personType.'+curLangRef,			width:500},
	   		{name:'code',						index:'code',							width:500},
	   		{name:'orgLegalForm.'+curLangRef,	index:'orgLegalForm.'+curLangRef,		width:500},
	   		{name:'name',						index:'name',			 				width:500},
	   		{name:'address',					index:'address', 						width:500},
	   		{name:'phone',						index:'phone', 							width:500},
	   		{name:'email',						index:'email', 							width:500}
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	sortname: 'id',
	    viewrecords: true,
	    sortorder: "desc",
	    caption:'<spring:message code="label.module_name.whiteList"/>',
	    width: w,
	    height: 300
	});
	
	$("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});
}); 

</script>
<html>
<center>

<table id="list">
<thead style="background-color: #7196B0"/>
<tr><td/></tr>
</table>	

<div id="pager"></div>

</center>
</html>