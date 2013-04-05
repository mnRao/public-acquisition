<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){
	setMenuSelection("explicatii");
	
	var pid = ${tenderId};
	var curLangRef = "${pageContext.response.locale}" + 'Value';
	var content='';
	$("#xxx").val(pid);
	$("#proceduricardLink").html('<a href=proceduricard?pid='+pid+'><img src="resources/images/datele-icon.gif" /></a>');
	$("#contracteLink").html('<a href=contracteprocedura?pid='+pid+'><img src="resources/images/contracte-icon.gif" /></a>');
	$("#plingeriLink").html('<a href=plingeri?pid='+pid+'><img src="resources/images/jaloba-icon.gif" /></a>');
	
	var jqxhr = $.getJSON( "json/explicatiiList", {id:pid}, function(list) {
		$.each(list.rows, function(key, value) {
			content=content+'<br><hr width="90%"><br><table width="90%">'
			+'<tr><td width="20%""><spring:message code="label.numExpl"/></td><td> '+ value.questionNumb+'</td></tr>'
			+'<tr><td><spring:message code="label.dateExpl"/></td><td> '+ value.askedDate+'</td></tr>'
			+'<tr><td><spring:message code="label.explTxt"/></td><td> '+ value.questionText+'</td></tr>'
			+'<tr><td colspan="2"><spring:message code="label.raspTxt"/></td></tr>'
			+'<tr><td colspan="2">'+ value.answerText+'</td></tr>'
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
<table id="t0" border="1" width="100%" height=14 cellspacing="0" cellpadding="0" style="background-color: #708EA7; ">

<tr>
<td width="93%" align="center" valign="middle"><div id="headerLine"></div>
</td>
<td width="2%" align="center"><div id="proceduricardLink"><img src="resources/images/datele-icon.gif" /></div>
</td>
<td width="2%" align="center"><div id="contracteLink"><img src="resources/images/contracte-icon.gif" /></div>
</td>
<td width="2%" align="center"><div id="plingeriLink"><img src="resources/images/jaloba-icon.gif"  /></div>
</td>
<td width="1%" align="center">&nbsp;
</td>
</tr>

</table>
<div id="titleLine">
	<br>
	<img src="resources/images/explic_1.png" />
	<spring:message code="label.explicatii"/>
</div>
<div id=pageContent>
</div>	   	
</center>
</html>