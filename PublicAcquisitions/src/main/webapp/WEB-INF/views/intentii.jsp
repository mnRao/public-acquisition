<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>
<script type="text/javascript">
$(document).ready(function(){

	var w = screen.width*0.98;
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
		   			'<spring:message code="label.currentStatus"/>'],
	   	colModel:[
	   		{name:'id',						index:'id', 					width:200, hidden: true},
	   		{name:'regNumber',				index:'regNumber', 				width:500},
	   		{name:'budgetPeriod.year',		index:'budgetPeriod.year', 		width:500},
	   		{name:'purchaseQuarter',		index:'purchaseQuarter', 		width:500},
	   		{name:'stateOrg.orgName',		index:'stateOrg.orgName', 		width:500},
	   		{name:'tenderType.'+curLangRef,	index:'tenderType.'+curLangRef,	width:500},
	   		{name:'plannedSum',				index:'plannedSum', 			width:500},
	   		{name:'bulletinPublishDate',	index:'bulletinPublishDate', 	width:500},
	   		{name:'bulletinNumber',			index:'bulletinNumber', 		width:500},
	   		{name:'currentStatus.intentionStatus.'+curLangRef,		
	   										index:'currentStatus.intentionStatus.'+curLangRef, 		
	   																		width:500}
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	toppager: true,
	   	sortname: 'id',
	   	sortorder: 'asc',
	    viewrecords: true,
	    search: true,	    
	    caption:'<spring:message code="label.module_name.intentii"/>',
	    width: w,
	    height: 300,
	    postData: 	{ filters:{	
	    	fIntentionStatus:		function() { return $('#pIntentionStatus').val(); }, 
	    	fTenderType: 			function() { return $('#pTenderType').val(); },
	    	fStateOrg: 				function() { return $('#pStateOrg').val(); },
	    	fForWhoPurchase: 		function() { return $('#pForWhoPurchase').val(); }
				}
			}
	});
	
//	$("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});
	
 /* ------------------ FILTERS FUNCTION ----------------- */	  
 	
	$("#resetFilter").click(function(){
		$("#pIntentionStatus").val("");
		$("#pTenderType").val("");
		$("#pStateOrg").val("");
		$("#pForWhoPurchase").val("");
		
		$("#list").trigger("reloadGrid");
	});
	
	$("#submitFilter").click(function(){
		$("#list").trigger("reloadGrid");
	});
	
	
	
	

	  
	  
		 $("#pTenderType").autocomplete({
			           source : function(request, response) {
			               $.ajax({
			                   url : "json/tenderTypeList",
			                   dataType : "json",
			                   data : {
			                	   style: "full",
			                        maxRows: 12,
			                	   term : request.term
			                   },
			                   success : function(data) {
			                       response($.map(data , function(item) {
			                           return {
			                               		label : getItemTranslation(item),
			                               		value : getItemTranslation(item)
			                           			};
			                       			}));
			                   }
			               });
			           },
			           minLength : 0
		}).focus(function(e) {
		   	    if(!e.isTrigger) {
		   	    	$(this).autocomplete("search", "");
		   	    }
		   	    e.stopPropagation();
		       });			
			
		 
		 $("#pIntentionStatus").autocomplete({
			       source : function(request, response) {
			              $.ajax({
			                   url : "json/intentionStatusList",
			                   dataType : "json",
			                   data : {
			                	   style: "full",
			                        maxRows: 12,
			                	   term : request.term
			                   },
			                   success : function(data) {
			                       response($.map(data , function(item) {
			                           return {
			                               		label : getItemTranslation(item),
			                               		value : getItemTranslation(item)
			                           			};
			                       			}));
			                   }
			               });
			           },
			           minLength : 0
			       }).focus(function(e) {
			    	    if(!e.isTrigger) {
			    	    	$(this).autocomplete("search", "");
			    	    }
			    	    e.stopPropagation();
			       });	
		 
		 
		  $( "#pBulletinDataFrom" ).datepicker({
		      showOn: "button",
		      buttonImage: "resources/images/calendar.gif",
		      buttonImageOnly: true
		    });
		  
		  $( "#pBulletinDataTo" ).datepicker({
		      showOn: "button",
		      buttonImage: "resources/images/calendar.gif",
		      buttonImageOnly: true
		    });
		
		  $( "#pApproveDataFrom" ).datepicker({
		      showOn: "button",
		      buttonImage: "resources/images/calendar.gif",
		      buttonImageOnly: true
		    });
		  
		  $( "#pApproveDataTo" ).datepicker({
		      showOn: "button",
		      buttonImage: "resources/images/calendar.gif",
		      buttonImageOnly: true
		    });		 
		 
}); 
</script>
<html>
<center>

<div id="filtrationPanel" align="left">
	<form action="">
	<fieldset>
		<label for="pIntentionStatus">	Statut:</label>						<input id="pIntentionStatus" type="text"/>
		<label for="pTenderType">		Tipul procedurii:</label>			<input id="pTenderType" type="text" />
		<br>
		<label for="pStateOrg">			Autoritate contractanta:</label>	<input id="pStateOrg" type="text" />
		<label for="pForWhoPurchase">	Destinatie achizitiei:</label>		<input id="pForWhoPurchase" type="text" />
		<br>
		<label for="pBulletinNumber">	Numarul bulletinului:</label>		<input id="pBulletinNumber" type="text" /> 
		<br>
		<label for="pBulletinDataFrom">	Data bulletinului de la:</label>	<input id="pBulletinDataFrom" type="text" />
		<label for="pBulletinDataTo">	pana la:</label>					<input id="pBulletinDataTo" type="text" />
		<label for="pApproveDataFrom">	Data aprobarii de la:</label>		<input id="pApproveDataFrom" type="text" />
		<label for="pApproveDataTo">	pana la:</label>					<input id="pApproveDataTo" type="text" />
		<br>	
		<label for="pGoodsDescription">	Obiectul de achizitie:</label>		<input id="pGoodsDescription" type="text" />
		 <div class="form-buttons">
		  	<input id="submitFilter" 	type="button" value="Apply Filter" />
		  	<input id="resetFilter" 	type="button" value="Reset Filter" />
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


<!-- 	<table id="prm"  -->
<!-- 		style="width: 98%; background-color: #DBD5D6; border: solid; border-width: 1px; border-color: #000000" > -->
<!-- 		<tr valign="middle"> -->
<!-- 			<td align="right" style="width:120px;">Deschiderea de la:</td> -->
<!-- 			<td style="width:100px;"><input type="text" id="pOpenFrom" style="width: 80px; text-align: center;" ></td> -->
<!-- 			<td align="right" style="width: 5em; text-align: center;" >pina la:</td> -->
<!-- 			<td style="width:100px;"><input type="text" id="pOpenTo" style="width: 80px; text-align: center;" ></td> -->
			
<!-- 			<td align="right">Statutul procedurii </td> -->
<!-- 			<td><input type="text" id="pIntentionStatus" style="width: 98%;" ></td> -->
			
<!-- 			<td style="width:30px;"><input id="btApplyFilter" type="button" value="Filtreaza"></td> -->
<!-- 		</tr> -->
<!-- 		<tr valign="middle"> -->
<!-- 			<td align="right">Bun sau serviciu:</td> -->
<!-- 			<td colspan="5"><input type="text" id="pGoodsName" style="width: 99%;" ></td>						 -->
<!-- 			<td><input id="btResetFilter" type="button" value="Curata filtru"></td> -->
<!-- 		</tr>	 -->

<!-- 	</table>  -->