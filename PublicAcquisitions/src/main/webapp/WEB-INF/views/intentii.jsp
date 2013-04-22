<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript">
$(document).ready(function(){

	var as = window.innerWidth*0.98;  //window.width*0.98; //Greds width
//	$("#currentContentPageName").val("intentii");
	setMenuSelection("intentii");
	
	var curLangRef = "${pageContext.response.locale}" + 'Value';
	
	function getItemTranslation(item){
		if (curLangRef == "mdValue") {
			return item.mdValue;
		} 
		if (curLangRef == "ruValue") {
			return item.ruValue;
		} 
		if (curLangRef == "enValue") {
			return item.enValue;
		}
		return item.mdValue;
	} 
	
	$("#list").jqGrid({
		jsonReader : {
		      root:"rows",
		      page: "page",
		      total: "total",
		      records: "records",
		      repeatitems: false,
		      id: "0"
		   },	
	   	url:'json/intentionAnounceList',
		datatype: "json",
		mtype: 'POST',
	   	colNames:[	'#',
					'<spring:message code="label.intentionRegNumber"/>',
	   	       		'<spring:message code="label.budgetPeriod_year"/>',
	   	          	'<spring:message code="label.quarter"/>',
	   	       		'<spring:message code="label.stateOrg_orgName"/>',
		   			'<spring:message code="label.tenderType"/>',
		   			'<spring:message code="label.summa"/>',
		   			'<spring:message code="label.bulletinDate"/>',
		   			'<spring:message code="label.bulletinNumber"/>',
		   			'<spring:message code="label.currentStatus"/>',
		   			'test'],
	   	colModel:[
	   		{name:'id',						index:'id', 					width:200, hidden: true},
	   		{name:'regNumber',				index:'regNumber', 				width:500, formatter:cardLink  },
	   		{name:'budgetPeriod.year',		index:'budgetPeriod.year', 		width:500},
	   		{name:'purchaseQuarter',		index:'purchaseQuarter', 		width:500},
	   		{name:'stateOrg.orgName',		index:'stateOrg.orgName', 		width:500},
	   		{name:'tenderType.'+curLangRef,	index:'tenderType.'+curLangRef,	width:500},
	   		{name:'plannedSum',				index:'plannedSum', 			width:500},
	   		{name:'bulletinPublishDate',	index:'bulletinPublishDate', 	width:500},
	   		{name:'bulletinNumber',			index:'bulletinNumber', 		width:500},
	   		{name:'currentStatus.intentionStatus.'+curLangRef,		
	   										index:'intentionStatus.'+curLangRef, 		
	   																		width:500},
			{name:'forWhoPurchase',			index:'forWhoPurchase', 		width:500, hidden: true}	   																		
	   																			   																		
	   																		
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	sortname: 'id',
	   	sortorder: 'asc',
	    viewrecords: true,
	    search: true,
	    width: w,
	    height: "100%",
	    hidegrid: false,
	    postData: 	{ filters:{	
	    	fIntentionStatus:		function() { return getKendoComboBoxSelectedValue($('#pIntentionStatus').data("kendoComboBox"));}, 
	    	fTenderType: 			function() { return getKendoComboBoxSelectedValue($('#pTenderType').data("kendoComboBox"));}, 
	    	fStateOrg: 				function() { return $('#pStateOrg').val(); },
	    	fForWhoPurchase: 		function() { return $('#pForWhoPurchase').val();},
	    	fBulletinNumber:		function() { return $('#pBulletinNumber').val(); }, 
	    	fBulletinDataFrom:		function() { return $('#pBulletinDataFrom').val(); }, 
	    	fBulletinDataTo:		function() { return $('#pBulletinDataTo').val(); }, 
	    	fApproveDataFrom:		function() { return $('#pApproveDataFrom').val(); }, 
	    	fApproveDataTo:			function() { return $('#pApproveDataTo').val(); }, 
	    	fGoodsDescription:		function() { return $('#pGoodsDescription').val();} 
				}
			}
	});
	
//	$("#list").jqGrid("setGridWidth", w, true );
	
	
	function cardLink(cellvalue, options, rowObject) {
		   return '<a href="intentiiCard?pid='+ rowObject['id'] +'">'+ rowObject['regNumber'] +'</a>' +
				   '';
		   };
		   
//	$("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});
	
 /* ------------------ FILTERS FUNCTION ----------------- */	  
 	
	$("#resetFilter").click(function(){
		//$("#pIntentionStatus").val("");
		//$("#pTenderType").val("");
		
		$("#pIntentionStatus").data("kendoComboBox").select(-1);
		$("#pIntentionStatus").data("kendoComboBox").value("-- // --");
		$("#pTenderType").data("kendoComboBox").select(-1);
		$("#pTenderType").data("kendoComboBox").value("-- // --");		
		
		$("#pStateOrg").val("");
		$("#pForWhoPurchase").val("");
		$("#pBulletinNumber").val("");
		$("#pGoodsDescription").val("");
		
		$("#pBulletinDataFrom").data("kendoDatePicker").value(null);
		$("#pBulletinDataTo").data("kendoDatePicker").value(null);
		$("#pApproveDataFrom").data("kendoDatePicker").value(null);
		$("#pApproveDataTo").data("kendoDatePicker").value(null);
		
		$("#list").trigger("reloadGrid");
	});
	
	$("#submitFilter").click(function(){
		$("#list").trigger("reloadGrid");
	});
		 
		  //$( "#pBulletinDataFrom" ).datepicker({showOn: "button",buttonImage: "resources/images/calendar.gif",buttonImageOnly: true});
		  //$( "#pBulletinDataTo" ).datepicker({showOn: "button",buttonImage: "resources/images/calendar.gif",buttonImageOnly: true});
		  //$( "#pApproveDataFrom" ).datepicker({showOn: "button",buttonImage: "resources/images/calendar.gif",buttonImageOnly: true});
		  //$( "#pApproveDataTo" ).datepicker({showOn: "button",buttonImage: "resources/images/calendar.gif",buttonImageOnly: true});		 
		  
          $("#pIntentionStatus").width(200).kendoComboBox({
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
                      read: "json/intentionStatusList"
                  }
              }
          });
		  
          $("#pTenderType").width(350).kendoComboBox({
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
                      read: "json/tenderTypeList"
                  }
              }
          });
          
      	$("#zz").click(function(){
      		
    	});      
		 

/*  Data FROM and TO - data pickers initialization and functionality */        
            function startBulletinDataFromChange() {
                var startDate = startBulletinDataFrom.value(),
                endDate = endBulletinDataTo.value();

                if (startDate) {
                    startDate = new Date(startDate);
                    startDate.setDate(startDate.getDate());
                    endBulletinDataTo.min(startDate);
                } else if (endDate) {
                	startBulletinDataFrom.max(new Date(endDate));
                } else {
                    endDate = new Date();
                    startBulletinDataFrom.max(endDate);
                    endBulletinDataTo.min(endDate);
                }
            }

            function endBulletinDataToChange() {
                var endDate = endBulletinDataTo.value(),
                startDate = startBulletinDataFrom.value();

                if (endDate) {
                    endDate = new Date(endDate);
                    endDate.setDate(endDate.getDate());
                    startBulletinDataFrom.max(endDate);
                } else if (startDate) {
                	endBulletinDataTo.min(new Date(startDate));
                } else {
                    endDate = new Date();
                    startBulletinDataFrom.max(endDate);
                    endBulletinDataTo.min(endDate);
                }
            }

            var startBulletinDataFrom = $("#pBulletinDataFrom").kendoDatePicker({
                change: startBulletinDataFromChange,
                format: "dd.MM.yyyy"
            }).data("kendoDatePicker");

            var endBulletinDataTo = $("#pBulletinDataTo").kendoDatePicker({
                change: endBulletinDataToChange,
                format: "dd.MM.yyyy"
            }).data("kendoDatePicker");

            startBulletinDataFrom.max(endBulletinDataTo.value());
            endBulletinDataTo.min(startBulletinDataFrom.value());
        
      	
            function startApproveDataFromChange() {
                var startDate = startApproveDataFrom.value(),
                endDate = endApproveDataTo.value();

                if (startDate) {
                    startDate = new Date(startDate);
                    startDate.setDate(startDate.getDate());
                    endApproveDataTo.min(startDate);
                } else if (endDate) {
                	startApproveDataFrom.max(new Date(endDate));
                } else {
                    endDate = new Date();
                    startApproveDataFrom.max(endDate);
                    endApproveDataTo.min(endDate);
                }
            }

            function endApproveDataToChange() {
                var endDate = endApproveDataTo.value(),
                startDate = startApproveDataFrom.value();

                if (endDate) {
                    endDate = new Date(endDate);
                    endDate.setDate(endDate.getDate());
                    startApproveDataFrom.max(endDate);
                } else if (startDate) {
                	endApproveDataTo.min(new Date(startDate));
                } else {
                    endDate = new Date();
                    startApproveDataFrom.max(endDate);
                    endApproveDataTo.min(endDate);
                }
            }

            var startApproveDataFrom = $("#pApproveDataFrom").kendoDatePicker({
                change: startApproveDataFromChange,
                format: "dd.MM.yyyy"
            }).data("kendoDatePicker");

            var endApproveDataTo = $("#pApproveDataTo").kendoDatePicker({
                change: endApproveDataToChange,
                format: "dd.MM.yyyy"
            }).data("kendoDatePicker");

            startApproveDataFrom.max(endApproveDataTo.value());
            endApproveDataTo.min(startApproveDataFrom.value());
/* ------------------------------------------------------------------------------------- */            
            
	
}); 
</script>
<html>
<center>
<!-- <button id="zz" style="visibility: hidden;"> ZZ </button> -->
<div id="filtrationPanel" align="left">
	<form action="" style="width: 90%;">
	<fieldset>
		<label for="pTenderType" 		style="display:inline-block; width: 150px; text-align: right;">
		<spring:message code="label.intentii.procedureType"/></label>			
			<input id="pTenderType" 	/>
		<label for="pIntentionStatus" 	style="display:inline-block; width: 175px; text-align: right; visibility: hidden;">
		<spring:message code="label.intentii.status"/></label>
			<input id="pIntentionStatus" style="visibility: hidden;"/>

		<br>
		<label for="pStateOrg" 			style="display:inline-block; width: 150px; text-align: right;">
		<spring:message code="label.intentii.contractAuthority"/></label>	
			<input id="pStateOrg" type="text" class="k-widget" style="width: 350px;" />
		<label for="pForWhoPurchase" 	style="display:inline-block; width: 126px; text-align: right;">
		<spring:message code="label.intentii.aquisitionDestination"/></label>		
			<input id="pForWhoPurchase" type="text" class="k-widget" style="width: 300px;" />
		<br>
		<label for="pBulletinDataFrom" 	style="display:inline-block; width: 150px; text-align: right;">
		<spring:message code="label.intentii.bulletinDateFrom"/></label>	
			<input id="pBulletinDataFrom" />
		<label for="pBulletinDataTo" 	style="display:inline-block; width: 50px; text-align: right;">
		<spring:message code="label.intentii.dateTo"/></label>
			<input id="pBulletinDataTo" />
		<label for="pBulletinNumber" 	style="display:inline-block; width: 120px; text-align: right;">
		<spring:message code="label.intentii.bulletinNumber"/></label>		
			<input id="pBulletinNumber" type="text" class="k-widget" /> 			
		<br>        		
		<label for="pApproveDataFrom" 	style="display:inline-block; width: 150px; text-align: right;">
		<spring:message code="label.intentii.approveDateFrom"/></label>		
			<input id="pApproveDataFrom" type="text" />
		<label for="pApproveDataTo" 	style="display:inline-block; width: 50px; text-align: right;">
		<spring:message code="label.intentii.dateTo"/></label>					
			<input id="pApproveDataTo" type="text" />
		<br>	
		<label for="pGoodsDescription" 	style="display:inline-block; width: 150px; text-align: right;">
		<spring:message code="label.intentii.aquisitionObject"/></label>		
			<input id="pGoodsDescription" type="text" class="k-widget" style="width: 350px;" />
		 <div class="form-buttons" style="display: inline-block;">
		 	<label style="display:inline-block; width: 250px; text-align: right;"></label>		
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

			
		 


		 