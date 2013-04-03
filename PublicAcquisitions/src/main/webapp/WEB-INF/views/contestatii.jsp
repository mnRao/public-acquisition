<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){

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
	   	url:'json/complaintList',
		datatype: "json",
		mtype: 'POST',
	   	colNames:[	'#',
					'refCurrentStatusId',
	   	       		'complaintNumb',
	   	          	'complaintDate',
	   	       		'text',
		   			'decisionText'],
	   	colModel:[
	   		{name:'id',						index:'id', 					width:200, hidden: true},
	   		{name:'refCurrentStatusId',				index:'refCurrentStatusId', 				width:500},
	   		{name:'complaintNumb',		index:'budgetPeriod.year', 		width:500},
	   		{name:'complaintDate',		index:'complaintDate', 		width:500},
	   		{name:'text',		index:'text', 		width:500},
	   		{name:'decisionText',		index:'decisionText', 		width:500}
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	sortname: 'id',
	    viewrecords: true,
	    sortorder: "desc",
	    caption:'',
	    width: w,
	    height: 300
	});
	
	$("#list").jqGrid('navGrid','#pager',{edit:false,add:false,del:false});
}); 

</script>
<html>
<center>
		
<div id="filtrationPanel" style="padding: .2em .2em .2em .2em;">
	<table id="prm" 
		style="width: 98%; background-color: #DBD5D6; border: solid; border-width: 1px; border-color: #000000" >
		<tr>
			<td align="right">Tipul suportului:</td>
			<td><input type="text" id="pSupportType" class="ui-widget"></td>
			<td>&nbsp;</td>
			<td align="right">Region:</td>
			<td><input type="text" id="pRegionName" class="ui-widget" ></td>
			<td>&nbsp;</td>
			<td align="right">Localitate:</td>
			<td colspan="2">
				<input type="text" id="pLocalityName"  class="ui-widget" >
				</td>
<!-- 						<td>&nbsp;</td> -->
			<td align="right">&nbsp;</td>
			<td><input id="btApplyFilter" type="button" value="Filtreaza"></td>
		</tr>
		<tr>
			<td align="right">Iluminare:</td>
			<td><input type="checkbox" id="pLight" ></td>						
			<td>&nbsp;</td>
			<td align="right">Adresa:</td>
			<td><input type="text" id="pAddresString" class="ui-widget"></td>
			<td>&nbsp;</td>
			<td align="right">Pret:</td>
			<td>
				<input type="text" id="pPriceFrom" class="ui-widget" >
				<input type="text" id="pPriceTo"   class="ui-widget" >
			</td>
			<td>&nbsp;
				
			</td>
			<td align="right">&nbsp;</td>
			<td><input id="btResetFilter" type="button" value="Curata filtru"></td>
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