<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>


<script type="text/javascript">
$(document).ready(function(){

	setMenuSelection("contracteprocedura");
	var pid = ${tenderId};
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
	   	url:'json/contractCardList',
		datatype: "json",
		mtype: 'POST',
	   	colNames:[	'#',
	   	          	'<spring:message code="label.contractNumber"/>',
	   	       		'<spring:message code="label.contractType"/>',
	   	       		'<spring:message code="label.contractType"/>',
		   			'<spring:message code="label.contractDate"/>',
		   			'<spring:message code="label.participant"/>',
		   			'<spring:message code="label.zO"/>',
		   			'<spring:message code="label.goodsDescr"/>',
		   			'<spring:message code="label.amountTVA"/>'],
	   	colModel:[
	   		{name:'id',							index:'id', 							width:200, hidden: true},
	   		{name:'contractNumber',				index:'contractNumber', 				width:100, align:"center", formatter:highlight},
	   		{name:'contractType.'+curLangRef,	index:'contractType.'+curLangRef, 		width:100, align:"center", formatter:highlight},
 	   		{name:'contractType.id',			index:'contractType.id',		 		width:100, hidden: true},
	   		{name:'contractDate',				index:'contractDate',					width:100, align:"center"},
	   		{name:'participant.fullName',		index:'participant.fullName',			width:200, align:"center", formatter:hidevalue},
	   		{name:'tender.stateOrg.orgName',	index:'tender.stateOrg.orgName', 		width:200, hidden: true},
	   		{name:'tender.tenderData.goodsDescr',	index:'tender.tenderData.goodsDescr', 				width:200, align:"center", formatter:hidevalue, sortable: false},
	   		{name:'amount',						index:'amount', 						width:100, align:"right"}
	   	],
	   	rowNum:10,
	   	rowList:[10,20,30],
	   	pager: '#pager',
	   	sortname: 'id',
	    viewrecords: true,
	    sortorder: "desc",
	    width: "1000",
	    height: "100%",
	    hidegrid: false,
	    gridview: true,
	    altRows: true,
	    altclass: "evenTableRow",
	    postData: 	{ id:		pid}
	});
	
// 	$("#list").jqGrid({gridComplete: function() {
// 	    $("tr.jqgrow:odd").addClass('oddTableRow');}
// 	});
	
// 	$("#list").jqGrid({gridComplete:
// 		applyZebra('list')
// 	});
	
	var jqxhrh = $.getJSON( "json/tenderCard", {id:pid}, function(card) {
		$("#headerLine").html('<spring:message code="label.header1"/> '+card.regNumber+' <spring:message code="label.header2"/> '+ (card.bulletin?card.bulletin.publDate:"")+ ' <spring:message code="label.header3"/> ' + card.tenderData.forWhoPurchase);
	}); 
	
	$("#proceduricardLink").html('<a href=proceduricard?pid='+pid+'><img src="resources/images/datele-icon.gif" /></a>');
	$("#explicatiiLink").html('<a href=explicatii?pid='+pid+'><img src="resources/images/vopros-icon.gif" /></a>');
	$("#plingeriLink").html('<a href=plingeri?pid='+pid+'><img src="resources/images/jaloba-icon.gif" /></a>');
	
// 	function applyZebra(containerId) {
// 	    $('#' + containerId + ' tr:nth-child(even)').addClass("jqgrow evenTableRow");
// 	    $('#' + containerId + ' tr:nth-child(odd)').addClass("jqgrow oddTableRow");
// 	};

function highlight (cellValue, options, rowObject) {
               var weight;
              		if (rowObject['contractType'].id==0) {
              			weight ="bold";
              		}
              		else {
              			weight ="normal";
              		};
               var cellHtml = "<span style='font-weight:" + weight + "' originalValue='" + cellValue + "'>" + cellValue + "</span>";
               
               return cellHtml;
               //console.log(rowObject['contractType'].id);
               //return rowObject['contractType.ruValue'];
}

function hidevalue (cellValue, options, rowObject) {
    var v;
   		if (rowObject['contractType'].id==0) {
   			v = cellValue;
   		}
   		else {
   			v = "-----";
   		};
    
    return v;
}
}); 

</script>
<html>
<center>

<!-- <table id="t0" border="1" width="100%" height=14 cellspacing="0" cellpadding="0" style="background-color: #708EA7; "> -->

<!-- <tr> -->
<!-- <td width="93%" align="center" valign="middle"><div id="headerLine"></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="explicatiiLink"><img src="resources/images/vopros-icon.gif" /></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="proceduricardLink"><img src="resources/images/datele-icon.gif" /></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="plingeriLink"><img src="resources/images/jaloba-icon.gif"  /></div> -->
<!-- </td> -->
<!-- <td width="1%" align="center">&nbsp; -->
<!-- </td> -->
<!-- </tr> -->

<!-- </table> -->

<div id="headerDiv">
<span id="headerLine" style="position:relative; top:5px"></span> <!--  style="position:relative; top:5px" -->
<div style="float:right; margin-right:20px">
	<div id="explicatiiLink" style="float:right;"><img src="resources/images/vopros-icon.gif" /></div>
	<div id="proceduricardLink" style="float:right;"><img src="resources/images/datele-icon.gif" /></div>
	<div id="plingeriLink" style="float:right;"><img src="resources/images/jaloba-icon.gif"  /></div>
</div>
</div>


<!-- <br> -->
<!-- <img src="resources/images/contracte_1.png" /> -->
<%-- <spring:message code="label.contracts"/> --%>
<!-- <hr width="90%"><br> -->

<br>
<div id="form-div">

<div style="text-align:center">
<span style="white-space: nowrap; margin-bottom:10px">
	<img src="resources/images/contracte_1.png" style="margin-bottom:-5px" />
	<span id="form-header" style="float:none">
		<spring:message code="label.contracts"/>
	</span>
</span>
</div>
<br>

<table id="list">
<thead style="background-color: #7196B0"/>
<tr><td/></tr>
</table>	

<!-- <div id="pager"></div> -->
</div>
</center>
</html>