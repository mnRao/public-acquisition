<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){
	setMenuSelection("explicatii");
	
	function IsStringEmpty(str)
	{
	if(str && str!='') 
	return str;
	else
	return "";
	}
	
	var pid = ${tenderId};
	var curLangRef = "${pageContext.response.locale}" + 'Value';
	var content='';
	$("#xxx").val(pid);
	$("#proceduricardLink").html('<a href=proceduricard?pid='+pid+'><img src="resources/images/datele-icon.gif" /></a>');
	$("#contracteLink").html('<a href=contracteprocedura?pid='+pid+'><img src="resources/images/contracte-icon.gif" /></a>');
	$("#plingeriLink").html('<a href=plingeri?pid='+pid+'><img src="resources/images/jaloba-icon.gif" /></a>');
	
	var jqxhr = $.getJSON( "json/explicatiiList", {id:pid}, function(list) {
		$.each(list.rows, function(key, value) {
			content=content+'<br><hr><br><table width="100%">'
			+'<tr><td width="20%"><span id="labelS"><spring:message code="label.numExpl"/></span></td><td><span  id="labelB"> '+ value.questionNumb+'</span></td></tr>'
			+'<tr><td><span id="labelS"><spring:message code="label.dateExpl"/></span></td><td><span  id="labelB"> '+ value.askedDate+'</span></td></tr>'
			+'<tr><td><span id="labelS"><spring:message code="label.explTxt"/></span></td><td><span  id="labelB"> '+ value.questionText+'</span></td></tr>'
			+'<tr><td colspan="2"><span id="labelS"><spring:message code="label.raspTxt"/></span></td></tr>'
			+'<tr><td colspan="2"><textarea style="width:100%; resize: none" readonly>'+  IsStringEmpty(value.answerText) +'</textarea></td></tr>'
			+'</table>';
			//$("#xxx").val(value.questionText);
			});
		$("#pageContent").html(content);
	}); 
	
	var jqxhrh = $.getJSON( "json/tenderCard", {id:pid}, function(card) {
		$("#headerLine").html('<spring:message code="label.header1"/> '+card.regNumber+' <spring:message code="label.header2"/> '+ (card.bulletin?card.bulletin.publDate:"")+ ' <spring:message code="label.header3"/> ' + card.tenderData.forWhoPurchase);
	}); 
	
}); 

</script>
<html>
<center>
<!-- <table id="t0" border="1" width="100%" height=14 cellspacing="0" cellpadding="0" style="background-color: #708EA7; "> -->

<!-- <tr> -->
<!-- <td width="93%" align="center" valign="middle"><div id="headerLine"></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="proceduricardLink"><img src="resources/images/datele-icon.gif" /></div> -->
<!-- </td> -->
<!-- <td width="2%" align="center"><div id="contracteLink"><img src="resources/images/contracte-icon.gif" /></div> -->
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
	<div id="proceduricardLink" style="float:right;"><img src="resources/images/datele-icon.gif" /></div>
	<div id="contracteLink" style="float:right;"><img src="resources/images/contracte-icon.gif" /></div>
	<div id="plingeriLink" style="float:right;"><img src="resources/images/jaloba-icon.gif"  /></div>
</div>
</div>

<!-- <div id="titleLine"> -->
<!-- 	<br> -->
<!-- 	<img src="resources/images/explic_1.png" /> -->
<%-- 	<spring:message code="label.explicatii"/> --%>
<!-- </div> -->
<br>
<div id="form-div">

<div style="text-align:center">
<span style="white-space: nowrap; margin-bottom:10px">
	<img src="resources/images/explic_1.png" style="margin-bottom:-5px" />
	<span id="form-header" style="float:none">
		<spring:message code="label.explicatii"/>
	</span>
</span>
</div>

<div id=pageContent>
</div>
</div>	   	
</center>
</html>