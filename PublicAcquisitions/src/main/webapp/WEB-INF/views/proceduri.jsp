<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){

//	$("#currentContentPageName").val("proceduri");
	setMenuSelection("proceduri");
	
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
	   	url:'json/tenderList',
		datatype: "json",
		mtype: 'POST',
	   	colNames:[	'#',
	   	         '<spring:message code="label.procedureRegNumber"/>',
	   	      	 '<spring:message code="label.tenderType"/>',
	   	      	 '<spring:message code="label.tendeOpenDate"/>',
	   	      	 '<spring:message code="label.stateOrg_orgName"/>',
	   	      	 '<spring:message code="label.currentStatus"/>',
	   	      	 '<spring:message code="label.goodsDescr"/>'],
	   	colModel:[
	   		{name:'id',								index:'id', 							width:100, hidden: true},
	   		{name:'regNumber',						index:'regNumber', 						width:150, formatter:cardLink, align:'center',  height:'auto'  },
	   		{name:'tenderType.'+curLangRef,			index:'tenderType.'+curLangRef,			width:150, align:'center'},
	   		{name:'refTendeOpenDate',				index:'refTendeOpenDate', 				width:150, align:'center'},
	   		{name:'stateOrg.orgName',				index:'stateOrg.orgName', 				width:500},
	   		{name:'tenderStatus.'+curLangRef,		index:'tenderStatus.'+curLangRef, 		width:150, align:'center'},
	   		{name:'tenderData.goodsDescr',			index:'tenderData.goodsDescr', 			width:500},
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
	    	fTenderStatus:				function() { return getKendoComboBoxSelectedValue($('#pTenderStatus').data("kendoComboBox"));}, 
	    	fProcedureOpenDataFrom:		function() { return $('#pProcedureOpenDataFrom').val(); }, 
	    	fProcedureOpenDataTo:		function() { return $('#pProcedureOpenDataTo').val(); }, 
	    	fpGoodsDescr:				function() { return $('#pGoodsDescr').val();} 
				}
			}
	});

	$("#list").jqGrid({onRightClickRow: function(rowid){ alert(rowid); }});
	
	function cardLink(cellvalue, options, rowObject) {
		var linkStr;   
		 linkStr='<a href="proceduricard?pid='+ rowObject['id'] +'">'+ rowObject['regNumber'] +'</a><br><img src="resources/images/jaloba_small_icon.png" width="0" height="16">';
		 if (rowObject['questionCount']>0){
				linkStr=linkStr+'<a href=explicatii?pid='+rowObject['id']+'><img alt="Explicatii" src="resources/images/vopros_small_icon.png"></a>'; 
		 };
		 if (rowObject['complaintCount']>0){
				linkStr=linkStr+'<a href=plingeri?pid='+rowObject['id']+'><img alt="Plingeri" src="resources/images/jaloba_active_small_icon.png"></a>'; 
		 };
		 if (rowObject['contractsCount']>0){
				linkStr=linkStr+'<a href=contracteprocedura?pid='+rowObject['id']+'><img alt="Contracte" src="resources/images/contracte_small_icon.png"></a>'; 
		 };
		 return linkStr;	   
 	   };
	
	
	$("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false,search:false, refresh:false});
	

/*  Data FROM and TO - data pickers initialization and functionality */	
    function startProcedureOpenDataFromChange() {
        var startDate = startProcedureOpenDataFrom.value(),
        endDate = endProcedureOpenDataTo.value();

        if (startDate) {
            startDate = new Date(startDate);
            startDate.setDate(startDate.getDate());
            endProcedureOpenDataTo.min(startDate);
        } else if (endDate) {
        	startProcedureOpenDataFrom.max(new Date(endDate));
        } else {
            endDate = new Date();
            startProcedureOpenDataFrom.max(endDate);
            endProcedureOpenDataTo.min(endDate);
        }
    }

    function endProcedureOpenDataToChange() {
        var endDate = endProcedureOpenDataTo.value(),
        startDate = startProcedureOpenDataFrom.value();

        if (endDate) {
            endDate = new Date(endDate);
            endDate.setDate(endDate.getDate());
            startProcedureOpenDataFrom.max(endDate);
        } else if (startDate) {
        	endProcedureOpenDataTo.min(new Date(startDate));
        } else {
            endDate = new Date();
            startProcedureOpenDataFrom.max(endDate);
            endProcedureOpenDataTo.min(endDate);
        }
    }

    var startProcedureOpenDataFrom = $("#pProcedureOpenDataFrom").kendoDatePicker({
        change: startProcedureOpenDataFromChange,
        format: "dd.MM.yyyy"
    }).data("kendoDatePicker");

    var endProcedureOpenDataTo = $("#pProcedureOpenDataTo").kendoDatePicker({
        change: endProcedureOpenDataToChange,
        format: "dd.MM.yyyy"
    }).data("kendoDatePicker");

    startProcedureOpenDataFrom.max(endProcedureOpenDataTo.value());
    endProcedureOpenDataTo.min(startProcedureOpenDataFrom.value());
/* ------------------------------------------------------------------------------------- */    
    $("#pTenderStatus").width(260).kendoComboBox({
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
                read: "json/tenderStatusList"
            }
        }
    });

    
 /* ------------------ FILTERS FUNCTION ----------------- */	  
 	
	$("#resetFilter").click(function(){

		$("#pTenderStatus").data("kendoComboBox").select(-1);
		$("#pTenderStatus").data("kendoComboBox").value("-- // --");
		
		$("#pGoodsDescr").val("");
		
		$("#pProcedureOpenDataFrom").data("kendoDatePicker").value(null);
		$("#pProcedureOpenDataFrom").data("kendoDatePicker").max(null);
		$("#pProcedureOpenDataTo").data("kendoDatePicker").value(null);
		$("#pProcedureOpenDataTo").data("kendoDatePicker").min(null);
		
		
		$("#list").trigger("reloadGrid");
	});
	
	$("#submitFilter").click(function(){
		$("#list").trigger("reloadGrid");
	});    
    
	
}); 



	   
</script>
<html>
<center>
		
<div id="form-div" >
<!-- 	<form action="" style="width: 90%;"> -->
<!-- 	<fieldset> -->
<!-- 		<label for="pProcedureOpenDataFrom" 	style="display:inline-block; width: 150px; text-align: right;">	Deschiderea de la:</label>	 -->
<!-- 			<input id="pProcedureOpenDataFrom" /> -->
<!-- 		<label for="pProcedureOpenDataTo" 	style="display:inline-block; width: 50px; text-align: right;">	pana la:</label> -->
<!-- 			<input id="pProcedureOpenDataTo" /> -->
<!-- 		<label for="pTenderStatus" 	style="display:inline-block; width: 120px; text-align: right;">Statutul procedurii:</label> -->
<!-- 			<input id="pTenderStatus"/> -->
<!-- 		<br> -->
<!-- 		<label for="pGoodsDescr" 			style="display:inline-block; width: 150px; text-align: right;">Bun sau serviciu:</label>	 -->
<!-- 			<input id="pGoodsDescr" type="text" class="k-widget" style="width: 390px;" /> -->


<!-- 		 <div class="form-buttons" style="display: inline-block;"> -->
<!-- 		 	<label style="display:inline-block; width: 210px; text-align: right;"></label>		 -->
<%-- 			  	<input id="submitFilter" 	type="button" value="<spring:message code="label.filtrationPanel.ApplyFilter"/>" /> --%>
<%-- 			  	<input id="resetFilter" 	type="button" value="<spring:message code="label.filtrationPanel.ResetFilter"/>" /> --%>
<!-- 		 </div>		 -->
<!-- 	</fieldset>					 -->
<!-- 	</form> -->
	
	<table>
		<tr>
			<td width="120px" align="left"><spring:message code="label.deLa"/>
			</td>
			<td><input id="pProcedureOpenDataFrom" />
			</td>
			
			<td width="60px" align="right"><spring:message code="label.pinaLa"/>
			</td>
			<td><input id="pProcedureOpenDataTo" />
			</td>
			
			<td width="150px" align="right"><spring:message code="label.statProc"/>
			</td>
			<td width="270px" align="right"><input id="pTenderStatus"/>
			</td>
		</tr>
	
		<tr>
			<td align="left"><spring:message code="label.bunServ"/>
			</td>
			<td colspan="6"><input id="pGoodsDescr" type="text" class="k-widget" style="width: 100%;" />
			</td>
		</tr>
		
		<tr>
			<td colspan="6" align="right">
				<input id="submitFilter" 	type="button" value="<spring:message code="label.filtrationPanel.ApplyFilter"/>" />
				<input id="resetFilter" 	type="button" value="<spring:message code="label.filtrationPanel.ResetFilter"/>" />
			</td>
		</tr>
		
	
	</table>
</div>

<br>

<table id="list">
<thead style="background-color: #7196B0"/>
<tr><td/></tr>
</table>


<div id="pager"></div>
</center>
</html>