<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>



<script type="text/javascript">
$(document).ready(function(){
	setMenuSelection("proceduricard");
	
	var pid = ${tenderId};
	var curLangRef = "${pageContext.response.locale}" + 'Value';	
	var curLang = "${pageContext.response.locale}";	
	
// 	$.ajax({
// 		  dataType: "json",
// 		  url: 'json/tenderCard',
// 		  data: {id:pid},
// 		  success: success
// 		});
	
// 	function success(){
// 		$("#p1").val("dgfdg");
// 	}
	

var jqxhr = $.getJSON( "json/tenderCard", {id:pid}, function(card) {
//   $("#zzz").val(card.id);
  $("#regNumber").val(card.regNumber);
  //$("#tenderStatus").val(card.tenderStatus.ruValue);
  switch (curLang)
  {
    case "ru": $("#tenderStatus").val(card.tenderStatus.ruValue);
                      break;
    case "ro": $("#tenderStatus").val(card.tenderStatus.roValue);
                      break;
    case "en": $("#tenderStatus").val(card.tenderStatus.enValue);
                      break;
    default: $("#tenderStatus").val(card.tenderStatus.ruValue);
  }
  $("#bulletinNumber").val(card.bulletin?card.bulletin.bulletinNumb:"");
  $("#bulletinDate").val(card.bulletin?card.bulletin.publDate:"");		
  $("#goodsDescr").val(card.tenderData.goodsDescr);		
  
  $("#pressOffersPlace").val(card.tenderData.pressOffersPlace);	
  $("#pressOffersDate").val(card.tenderData.pressOffersDate);
  $("#openDateTime").val(card.tenderData.openDateTime);		
  //$("#language").val(card.tenderData.language.ruValue);
  switch (curLang)  {
    case "ru": $("#language").val(card.tenderData.language.ruValue);
                      break;
    case "ro": $("#language").val(card.tenderData.language.roValue);
                      break;
    case "en": $("#language").val(card.tenderData.language.enValue);
                      break;
    default: $("#language").val(card.tenderData.language.ruValue);
  }
  
  $("#name").val(card.stateOrg.orgName);
  $("#address").val(card.stateOrg.address);		
  $("#phone").val(card.stateOrg.phone);
  
  $("#deliveryDate").val(card.tenderData.deliveryDate);	
  //$("#deliveryTerms").val(card.tenderData.deliveryTerms.ruValue);
  switch (curLang)  {
	case "ru": $("#deliveryTerms").val(card.tenderData.deliveryTerms.ruValue);
	                    break;
	case "ro": $("#deliveryTerms").val(card.tenderData.deliveryTerms.roValue);
	                    break;
	case "en": $("#deliveryTerms").val(card.tenderData.deliveryTerms.enValue);
	                    break;
	default: $("#deliveryTerms").val(card.tenderData.deliveryTerms.ruValue);
  }
  $("#offerEstimateByPrice").val(card.tenderData.offerEstimateByPrice);		
  $("#forResidenceOnlyReason").val(card.tenderData.forResidenceOnlyReason);
  
  $("#headerLine").html('<spring:message code="label.header1"/> '+card.regNumber+' <spring:message code="label.header2"/> '+ (card.bulletin?card.bulletin.publDate:"")+ ' <spring:message code="label.header3"/> ' + card.tenderData.forWhoPurchase);
  $("#explicatiiLink").html('<a href=explicatii?pid='+card.id+'><img src="resources/images/vopros-icon.gif" /></a>');
  $("#contracteLink").html('<a href=contracteprocedura?pid='+card.id+'><img src="resources/images/contracte-icon.gif" /></a>');
  $("#plingeriLink").html('<a href=plingeri?pid='+card.id+'><img src="resources/images/jaloba-icon.gif" /></a>');
  $("#list").jqGrid('setGridParam', { postData: { id:card.tenderData.id} , datatype: 'json'}).trigger('reloadGrid');
 
  
});


$("#list").jqGrid({
	jsonReader : {
	      root:"rows",
	      page: "page",
	      total: "total",
	      records: "records",
	      repeatitems: false,
	      id: "0"
	   },	
   	url:'json/positionList',
	datatype: "local",
	mtype: 'POST',
	
   	colNames:[	'#',
   	      	 '<spring:message code="label.goodsName"/>',
   	      	 '<spring:message code="label.codeCPV"/>',
   	      	 '<spring:message code="label.quantity"/>',
   	      	 '<spring:message code="label.um"/>'],
   	colModel:[
   		{name:'id',								index:'id', 							width:200, hidden: true},
   		{name:'goodsName',						index:'goodsName', 						width:460},
   		{name:'goods.code',						index:'goods.code',						width:200, align:"center"},
   		{name:'quantity',						index:'quantity', 						width:120, align:"center"},
   		{name:'unitMeasure.'+curLangRef,		index:'unitMeasure.'+curLangRef,		width:150, align:"center"}
   	],
   	rowNum:10,
   	rowList:[10,20,30],
   	//pager: '#pager',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
    caption:'',
    height: "100%"
});

	

});

</script>
<html>
<center>

<!-- <table id="t0" border="1" width="100%" height=14 cellspacing="0" cellpadding="0" style="background-color: #708EA7; "> -->

<!-- <tr> -->
<!-- <td width="93%" align="center" valign="middle"><div id="headerLine" style="margin-bottom:10px"></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="explicatiiLink"><img src="resources/images/vopros-icon.gif" /></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="contracteLink"><img src="resources/images/contracte-icon.gif" /></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="plingeriLink"><img src="resources/images/jaloba-icon.gif"  /></div> -->
<!-- </td> -->
<!-- <td width="1%" align="center">&nbsp; -->
<!-- </td> -->
<!-- </tr> -->

<!-- </table> -->

<div id="headerDiv" >
<span id="headerLine" style="position:relative; top:5px"></span> <!--  style="position:relative; top:5px" -->
<div style="float:right; margin-right:20px">
	<div id="explicatiiLink" style="float:right;"><img src="resources/images/vopros-icon.gif" /></div>
	<div id="contracteLink" style="float:right;"><img src="resources/images/contracte-icon.gif" /></div>
	<div id="plingeriLink" style="float:right;"><img src="resources/images/jaloba-icon.gif"  /></div>
</div>
</div>

<br>
<div id="form-div">
<div style="text-align:center">
<span style="white-space: nowrap; margin-bottom:10px">
	<img src="resources/images/datele_1.png" style="margin-bottom:-5px" />
	<span id="form-header" style="float:none">
		<spring:message code="label.commonInfo"/>
	</span>
</span>
</div>
<hr><br>

<table id="t1" border="1" width="98%">

<tr>
<td width="20%" align="right" ><spring:message code="label.procedureRegNumber"/>
</td>
<td width="29%" align="center"> <input id="regNumber" type="text" style="width: 90%;" readonly="readonly">	
</td>
<td width="20%" align="right"><spring:message code="label.currentStatus"/>
</td>
<td width="29%" align="center"> <input id="tenderStatus" type="text" style="width: 90%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.bulletinNumber"/>
</td>
<td width="29%" align="center"> <input id="bulletinNumber" type="text" style="width: 90%;" readonly="readonly">	
</td>
<td width="20%" align="right"><spring:message code="label.bulletinDate"/>
</td>
<td width="29%" align="center"> <input id="bulletinDate" type="text" style="width: 90%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%"  style="vertical-align: middle;" align="right" ><spring:message code="label.goodsDescr"/>
</td>
<td  align="center" colspan="3"> <textarea id="goodsDescr" style="width: 96%;" readonly="readonly" >
</textarea>	
</td>
</tr>

</table>

<br><hr id="hr1"><br>

<table id="t2" border="1" width="98%">

<tr>
<td width="20%" align="right"><spring:message code="label.pressOffersPlace"/>
</td>
<td  align="center" colspan="3"> <input id="pressOffersPlace" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.pressOffersDate"/>
</td>
<td width="29%" align="center"> <input id="pressOffersDate" type="text" style="width: 90%;" readonly="readonly">	
</td>
<td width="20%" align="right">
</td>
<td width="29%" align="center"> 
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.openDateTime"/>
</td>
<td width="29%" align="center"> <input id="openDateTime" type="text" style="width: 90%;" readonly="readonly">	
</td>
<td width="20%" align="right"><spring:message code="label.language"/>
</td>
<td width="29%" align="center"> <input id="language" type="text" style="width: 90%;" readonly="readonly">	
</td>
</tr>



</table>

<br><hr id="hr1"><br>

<table id="t3" border="1" width="98%">

<tr>
<td width="20%" align="right"><spring:message code="label.name"/>
</td>
<td width="80%" align="center"> <input id="name" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.address"/>
</td>
<td width="80%" align="center"> <input id="address" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.phone"/>
</td>
<td  width="80%" align="center"> <input id="phone" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

</table>

<br><hr id="hr1"><br>

<table id="t4" border="1" width="98%">

<tr>
<td width="20%" align="right"><spring:message code="label.deliveryDate"/>
</td>
<td width="80%" align="center"> <input id="deliveryDate" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.deliveryTerms"/>
</td>
<td width="80%" align="center"> <input id="deliveryTerms" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.offerEstimateByPrice"/>
</td>
<td  width="80%" align="center"> <input id="offerEstimateByPrice" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.forResidenceOnlyReason"/>
</td>
<td  width="80%" align="center"> <input id="forResidenceOnlyReason" type="text" style="width: 96%;" readonly="readonly">	
</td>
</tr>

</table>

<div style="text-align:center">
<span style="white-space: nowrap; margin-bottom:10px">
	<img src="resources/images/procedura_1.png" style="margin-bottom:-5px" />
	<span id="form-header" style="float:none">
		<spring:message code="label.detailInfo"/>
	</span>
</span>
</div>

<hr>
<span style="float:left; margin-left:40px; color:#047184; size: 12px; font-weight: bold;">
	<spring:message code="label.bunuri"/>
</span>
<br>

<table id="list">
<thead style="background-color: #7196B0"/>
<tr><td/></tr>
</table>

</div>
</center>
</html>