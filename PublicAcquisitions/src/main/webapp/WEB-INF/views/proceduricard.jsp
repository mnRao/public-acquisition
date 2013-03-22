<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>



<script type="text/javascript">
$(document).ready(function(){
	
	var pid = ${tenderId};
	var curLangRef = "${pageContext.response.locale}" + 'Value';	
	
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
  $("#tenderStatus").val(card.tenderStatus.ruValue);
  $("#bulletinNumber").val(card.bulletin.bulletinNumb);
  $("#bulletinDate").val(card.bulletin.publDate);		
  $("#goodsDescr").val(card.tenderData.goodsDescr);		
  
  $("#pressOffersPlace").val(card.tenderData.pressOffersPlace);	
  $("#pressOffersDate").val(card.tenderData.pressOffersDate);
  $("#openDateTime").val(card.tenderData.openDateTime);		
  $("#language").val(card.tenderData.language.ruValue);
  
  $("#name").val(card.stateOrg.orgName);
  $("#address").val(card.stateOrg.address);		
  $("#phone").val(card.stateOrg.phone);
  
  $("#deliveryDate").val(card.tenderData.deliveryDate);	
  $("#deliveryTerms").val(card.tenderData.deliveryTerms.ruValue);
  $("#offerEstimateByPrice").val(card.tenderData.offerEstimateByPrice);		
  $("#forResidenceOnlyReason").val(card.tenderData.forResidenceOnlyReason);
});
	

});

</script>
<html>
<center>


<table id="t0" border="1" width="100%" height=14 cellspacing="0" cellpadding="0" style="background-color: #708EA7; ">

<tr>
<td width="93%" align="center">aaa
</td>
<td width="2%" align="center"><img src="resources/images/vopros-icon.gif" />
</td>
<td width="2%" align="center"><img src="resources/images/contracte-icon.gif" />
</td>
<td width="2%" align="center"><img src="resources/images/jaloba-icon.gif"  />
</td>
<td width="1%" align="center">&nbsp;
</td>
</tr>

</table>

<table id="t1" border="1" width="98%">

<tr>
<td width="20%" align="right"><spring:message code="label.procedureRegNumber"/>
</td>
<td width="29%" align="center"> <input id="regNumber" type="text" style="width: 90%;">	
</td>
<td width="20%" align="right"><spring:message code="label.currentStatus"/>
</td>
<td width="29%" align="center"> <input id="tenderStatus" type="text" style="width: 90%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.bulletinNumber"/>
</td>
<td width="29%" align="center"> <input id="bulletinNumber" type="text" style="width: 90%;">	
</td>
<td width="20%" align="right"><spring:message code="label.bulletinDate"/>
</td>
<td width="29%" align="center"> <input id="bulletinDate" type="text" style="width: 90%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.goodsDescr"/>
</td>
<td  align="center" colspan="3"> <input id="goodsDescr" type="text" style="width: 96%;">	
</td>
</tr>

</table>

<br><hr width="90%"><br>

<table id="t2" border="1" width="98%">

<tr>
<td width="20%" align="right"><spring:message code="label.pressOffersPlace"/>
</td>
<td  align="center" colspan="3"> <input id="pressOffersPlace" type="text" style="width: 96%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.pressOffersDate"/>
</td>
<td width="29%" align="center"> <input id="pressOffersDate" type="text" style="width: 90%;">	
</td>
<td width="20%" align="right">
</td>
<td width="29%" align="center"> 
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.openDateTime"/>
</td>
<td width="29%" align="center"> <input id="openDateTime" type="text" style="width: 90%;">	
</td>
<td width="20%" align="right"><spring:message code="label.language"/>
</td>
<td width="29%" align="center"> <input id="language" type="text" style="width: 90%;">	
</td>
</tr>



</table>

<br><hr width="90%"><br>

<table id="t3" border="1" width="98%">

<tr>
<td width="20%" align="right"><spring:message code="label.name"/>
</td>
<td width="80%" align="center"> <input id="name" type="text" style="width: 96%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.address"/>
</td>
<td width="80%" align="center"> <input id="address" type="text" style="width: 96%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.phone"/>
</td>
<td  width="80%" align="center"> <input id="phone" type="text" style="width: 96%;">	
</td>
</tr>

</table>

<br><hr width="90%"><br>

<table id="t4" border="1" width="98%">

<tr>
<td width="20%" align="right"><spring:message code="label.deliveryDate"/>
</td>
<td width="80%" align="center"> <input id="deliveryDate" type="text" style="width: 96%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.deliveryTerms"/>
</td>
<td width="80%" align="center"> <input id="deliveryTerms" type="text" style="width: 96%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.offerEstimateByPrice"/>
</td>
<td  width="80%" align="center"> <input id="offerEstimateByPrice" type="text" style="width: 96%;">	
</td>
</tr>

<tr>
<td width="20%" align="right"><spring:message code="label.forResidenceOnlyReason"/>
</td>
<td  width="80%" align="center"> <input id="forResidenceOnlyReason" type="text" style="width: 96%;">	
</td>
</tr>

</table>

</center>
</html>