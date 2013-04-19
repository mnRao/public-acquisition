<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){

	setMenuSelection("whiteList");
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
	   		{name:'decisionNumb',				index:'decisionNumb', 					width:250, align:'center'},
	   		{name:'decisionDate',				index:'decisionDate',			 		width:250, align:'center'},
	   		{name:'personType.'+curLangRef,		index:'personType.'+curLangRef,			width:250, align:'center'},
	   		{name:'code',						index:'code',							width:250, align:'center'},
	   		{name:'orgLegalForm.'+curLangRef,	index:'orgLegalForm.'+curLangRef,		width:500},
	   		{name:'name',						index:'name',			 				width:500},
	   		{name:'address',					index:'address', 						width:500},
	   		{name:'phone',						index:'phone', 							width:200, align:'center'},
	   		{name:'email',						index:'email', 							width:250}
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	sortname: 'id',
	    viewrecords: true,
	    sortorder: "desc",
	    width: w,
	    height: "100%",
	    hidegrid: false,
	    postData: 	{ filters:{	
	    	fDecisionNumb:		function() { return $('#pDecisionNumb').val(); }, 
	    	fDecisionDateFrom:	function() { return $('#pDecisionDateFrom').val(); }, 
	    	fDecisionDateTo:	function() { return $('#pDecisionDateTo').val(); }, 
	    	fCode:				function() { return $('#pCode').val();},
	    	fName:				function() { return $('#pName').val();},
				}
			}
	});
	
	$("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false,search:false,refresh:false});
	
	/*  Data FROM and TO - data pickers initialization and functionality */	
    function startDecisionDateFromChange() {
        var startDate = startDecisionDateFrom.value(),
        endDate = endDecisionDateTo.value();

        if (startDate) {
            startDate = new Date(startDate);
            startDate.setDate(startDate.getDate());
            endDecisionDateTo.min(startDate);
        } else if (endDate) {
        	startDecisionDateFrom.max(new Date(endDate));
        } else {
            endDate = new Date();
            startDecisionDateFrom.max(endDate);
            endDecisionDateTo.min(endDate);
        }
    }

    function endDecisionDateToChange() {
        var endDate = endDecisionDateTo.value(),
        startDate = startDecisionDateFrom.value();

        if (endDate) {
            endDate = new Date(endDate);
            endDate.setDate(endDate.getDate());
            startDecisionDateFrom.max(endDate);
        } else if (startDate) {
        	endDecisionDateTo.min(new Date(startDate));
        } else {
            endDate = new Date();
            startDecisionDateFrom.max(endDate);
            endDecisionDateTo.min(endDate);
        }
    }

    var startDecisionDateFrom = $("#pDecisionDateFrom").kendoDatePicker({
        change: startDecisionDateFromChange,
        format: "dd.MM.yyyy"
    }).data("kendoDatePicker");

    var endDecisionDateTo = $("#pDecisionDateTo").kendoDatePicker({
        change: endDecisionDateToChange,
        format: "dd.MM.yyyy"
    }).data("kendoDatePicker");

    startDecisionDateFrom.max(endDecisionDateTo.value());
    endDecisionDateTo.min(startDecisionDateFrom.value());
/* ------------------------------------------------------------------------------------- */
 
/* ------------------ FILTERS FUNCTION ----------------- */	  
 	
	$("#resetFilter").click(function(){
		
		$("#pDecisionNumb").val("");
		$("#pCode").val("");
		$("#pName").val("");
		
		$("#pDecisionDateFrom").data("kendoDatePicker").max(null);
		$("#pDecisionDateFrom").data("kendoDatePicker").value(null);
		$("#pDecisionDateTo").data("kendoDatePicker").max(null);
		$("#pDecisionDateTo").data("kendoDatePicker").value(null);
		
		$("#list").trigger("reloadGrid");
	});
	
	$("#submitFilter").click(function(){
		$("#list").trigger("reloadGrid");
	});    
/* ------------------------------------------------------------------------------------- */	
 
}); 

</script>
<html>
<center>

<div id="filtrationPanel" align="left">
	<form action="" style="width: 90%;">
	<fieldset>
		<label for="pDecisionNumb" 			style="display:inline-block; width: 150px; text-align: right;">
		<spring:message code="label.bw.decisionNumb"/></label>	
			<input id="pDecisionNumb" type="text" class="k-widget" style="width: 150px;" />
		<label for="pDecisionDateFrom" 	style="display:inline-block; width: 175px; text-align: right;">
		<spring:message code="label.bw.decisionDateFrom"/></label>	
			<input id="pDecisionDateFrom" />
		<label for="pDecisionDateTo" 	style="display:inline-block; width: 50px; text-align: right;">
		<spring:message code="label.bw.dateTo"/></label>
			<input id="pDecisionDateTo" />
		<br>	
		
		<label for="pCode" 	style="display:inline-block; width: 150px; text-align: right;">
		<spring:message code="label.bw.code"/></label>
			<input id="pCode"/>
		<label for="pName" 			style="display:inline-block; width: 175px; text-align: right;">
		<spring:message code="label.bw.name"/></label>	
			<input id="pName" type="text" class="k-widget" style="width: 170px;" />


		 <div class="form-buttons" style="display: inline-block;">
		 	<label style="display:inline-block; width: 1px; text-align: right;"></label>		
		  	<input id="submitFilter" 	type="button" 
		  	value="<spring:message code="label.filtrationPanel.ApplyFilter"/>" />
		  	<input id="resetFilter" 	type="button" 
		  	value="<spring:message code="label.filtrationPanel.ResetFilter"/>" />
		 </div>		
	</fieldset>					
	</form>
</div>

<br>

<table id="list">
<thead style="background-color: #7196B0"/>
<tr><td/></tr>
</table>	

<div id="pager"></div>

</center>
</html>
