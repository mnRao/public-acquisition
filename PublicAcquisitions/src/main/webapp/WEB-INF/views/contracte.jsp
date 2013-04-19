<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>


<script type="text/javascript">
$(document).ready(function(){

	setMenuSelection("contracte");
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
		   			'<spring:message code="label.amountTVA"/>',
		   			'<spring:message code="label.procedureNumber"/>'],
	   	colModel:[
	   		{name:'id',							index:'id', 							width:200, hidden: true},
	   		{name:'contractNumber',				index:'contractNumber', 				width:500},
	   		{name:'contractType.'+curLangRef,	index:'contractType.'+curLangRef, 		width:500},
	   		{name:'contractDate',				index:'contractDate',					width:500},
	   		{name:'participant.fullName',		index:'participant.fullName',			width:500},
	   		{name:'tender.stateOrg.orgName',	index:'tender.stateOrg.orgName', 		width:500},
	   		{name:'tender.tenderData.goodsDescr',	index:'tender.tenderData.goodsDescr', 				width:500},
	   		{name:'amount',						index:'amount', 						width:500},
	   		{name:'tender.regNumber',			index:'tender.regNumber', 						width:500}
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
		    	fContractType:		function() { return getKendoComboBoxSelectedValue($('#pContractType').data("kendoComboBox"));}, 
		    	fContractDataFrom: 	function() { return $('#pContractDataFrom').val(); },
		    	fContractDataTo: 	function() { return $('#pContractDataTo').val();},
		    	fProcedureNumber:	function() { return $('#pProcedureNumber').val(); } 
				}
			}	    
	});
	
	$("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false,search:false,refresh:false});
	
	/*  Data FROM and TO - data pickers initialization and functionality */        
    function startContractDataFromChange() {
        var startDate = startContractDataFrom.value(),
        endDate = endContractDataTo.value();

        if (startDate) {
            startDate = new Date(startDate);
            startDate.setDate(startDate.getDate());
            endContractDataTo.min(startDate);
        } else if (endDate) {
        	startContractDataFrom.max(new Date(endDate));
        } else {
            endDate = new Date();
            startContractDataFrom.max(endDate);
            endContractDataTo.min(endDate);
        }
    }

    function endContractDataToChange() {
        var endDate = endContractDataTo.value(),
        startDate = startContractDataFrom.value();

        if (endDate) {
            endDate = new Date(endDate);
            endDate.setDate(endDate.getDate());
            startContractDataFrom.max(endDate);
        } else if (startDate) {
        	endContractDataTo.min(new Date(startDate));
        } else {
            endDate = new Date();
            startContractDataFrom.max(endDate);
            endContractDataTo.min(endDate);
        }
    }

    var startContractDataFrom = $("#pContractDataFrom").kendoDatePicker({
        change: startContractDataFromChange,
        format: "dd.MM.yyyy"
    }).data("kendoDatePicker");

    var endContractDataTo = $("#pContractDataTo").kendoDatePicker({
        change: endContractDataToChange,
        format: "dd.MM.yyyy"
    }).data("kendoDatePicker");

    startContractDataFrom.max(endContractDataTo.value());
    endContractDataTo.min(startContractDataFrom.value());
    
	
    $("#pContractType").width(250).kendoComboBox({
        index: -1,
        placeholder: "-- // --",
        dataTextField: curLangRef,
        dataValueField: "Id",
        filter: "contains",
        dataSource: {
            type: "json",
            serverFiltering: true,
            serverPaging: true,
            pageSize: 20,
            transport: {
                read: "json/contractTypeList"
            }
        }
    });  
    
/* ------------------ FILTERS FUNCTION ----------------- */	  
 	
	$("#resetFilter").click(function(){
		//$("#pIntentionStatus").val("");
		//$("#pTenderType").val("");
		
		$("#pContractType").data("kendoComboBox").select(-1);
		$("#pContractType").data("kendoComboBox").value("-- // --");
		
		$("#pProcedureNumber").val("");
		
		$("#pContractDataFrom").data("kendoDatePicker").value(null);
		$("#pContractDataTo").data("kendoDatePicker").value(null);

		$("#list").trigger("reloadGrid");
	});
	
	$("#submitFilter").click(function(){
		$("#list").trigger("reloadGrid");
	});    
    
}); 

</script>
<html>
<center>
	<div id="filtrationPanel" align="left">
		<form action="" style="width: 90%;">
		<fieldset>
			<label for="pContractDataFrom" 	style="display:inline-block; width: 150px; text-align: right;">	
				<spring:message code="label.contracte.contractDateFrom"/></label>	
				<input id="pContractDataFrom" />
			<label for="pContractDataTo" 	style="display:inline-block; width: 50px; text-align: right;">	
				<spring:message code="label.contracte.dateTo"/></label>
				<input id="pContractDataTo" />
			<label for="pProcedureNumber" 	style="display:inline-block; width: 120px; text-align: right;">
				<spring:message code="label.contracte.procedureNumber"/></label>
				<input id="pProcedureNumber"/>
			<br>
			<label for="pContractType" 			style="display:inline-block; width: 150px; text-align: right;">
				<spring:message code="label.contracte.contractType"/></label>	
				<input id="pContractType" type="text" class="k-widget" style="width: 390px;" />
	
	
			 <div class="form-buttons" style="display: inline-block;">
			 	<label style="display:inline-block; width: 250px; text-align: right;"></label>		
			  	<input id="submitFilter" 	type="button" value="<spring:message code="label.filtrationPanel.ApplyFilter"/>" />
			  	<input id="resetFilter" 	type="button" value="<spring:message code="label.filtrationPanel.ResetFilter"/>" />
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