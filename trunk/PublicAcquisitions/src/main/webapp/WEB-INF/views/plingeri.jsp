<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){
	setMenuSelection("proceduri");
	
	var pid = ${tenderId};
	var curLangRef = "${pageContext.response.locale}" + 'Value';
	var content='';
	$("#proceduricardLink").html('<a href=proceduricard?pid='+pid+'><img src="resources/images/datele-icon.gif" /></a>');
	$("#contracteLink").html('<a href=contracteprocedura?pid='+pid+'><img src="resources/images/contracte-icon.gif" /></a>');
	$("#explicatiiLink").html('<a href=explicatii?pid='+pid+'><img src="resources/images/vopros-icon.gif" /></a>');
	
	var jqxhr = $.getJSON( "json/tenderCard", {id:pid}, function(card) {
		content='<br><hr width="90%"><br><spring:message code="label.plingeriCount"/>'+card.complaintCount+'<br><hr width="90%"><br>';
		$("#pageContent").html(content);
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
<!-- <td width="2%" align="center"><div id="explicatiiLink"><img src="resources/images/vopros-icon.gif"  /></div> -->
<!-- </td> -->
<!-- <td width="1%" align="center">&nbsp; -->
<!-- </td> -->
<!-- </tr> -->

<!-- </table> -->

<div id="headerDiv">
<span id="headerLine" style="position:relative; top:5px"></span> <!--  style="position:relative; top:5px" -->
<div style="float:right; margin-right:20px">
	<div id="explicatiiLink" style="float:right;"><img src="resources/images/datele-icon.gif" /></div>
	<div id="contracteLink" style="float:right;"><img src="resources/images/contracte-icon.gif" /></div>
	<div id="proceduricardLink" style="float:right;"><img src="resources/images/jaloba-icon.gif"  /></div>
</div>
</div>
<br>
<div id="form-div">

<!-- <div id="titleLine"> -->
<!-- 	<img src="resources/images/JALOBA.png" /> -->
<%-- 	<spring:message code="label.plingeri"/> --%>
<!-- </div> -->

<div style="text-align:center">
<span style="white-space: nowrap; margin-bottom:10px">
	<img src="resources/images/JALOBA.png" style="margin-bottom:-5px" />
	<span id="form-header" style="float:none">
		<spring:message code="label.plingeri"/>
	</span>
</span>
</div>

<div id=pageContent>
</div>	 
</div>  	
</center>
</html>