<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>


<script type="text/javascript">
$(document).ready(function(){

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
	   	url:'json/contractList',
		datatype: "json",
		mtype: 'POST',
	   	colNames:[	'#',
	   	          	'<spring:message code="label.contractNumber"/>',
	   	       		'<spring:message code="label.contractType"/>',
		   			'<spring:message code="label.contractDate"/>',
		   			'<spring:message code="label.participant"/>',
		   			'<spring:message code="label.zO"/>',
		   			'<spring:message code="label.goodsDescr"/>',
		   			'<spring:message code="label.amountTVA"/>'],
	   	colModel:[
	   		{name:'id',							index:'id', 							width:200, hidden: true},
	   		{name:'contractNumber',				index:'contractNumber', 				width:500},
	   		{name:'contractType.'+curLangRef,	index:'contractType.'+curLangRef, 		width:500},
	   		{name:'contractDate',				index:'contractDate',					width:500},
	   		{name:'participant.fullName',		index:'participant.fullName',			width:500},
	   		{name:'tender.stateOrg.orgName',	index:'tender.stateOrg.orgName', 		width:500},
	   		{name:'tender.tenderData.goodsDescr',	index:'tender.tenderData.goodsDescr', 				width:500},
	   		{name:'amount',						index:'amount', 						width:500}
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	sortname: 'id',
	    viewrecords: true,
	    sortorder: "desc",
	    caption:'<spring:message code="label.module_name.contracte"/>',
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

</center>
</html>