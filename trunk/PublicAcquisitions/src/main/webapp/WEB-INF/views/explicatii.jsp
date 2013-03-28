<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<script type="text/javascript">
$(document).ready(function(){
	
	var pid = ${tenderId};
	var w = screen.width*0.98;
	var curLangRef = "${pageContext.response.locale}" + 'Value';
	
	$("#xxx").val(pid);
	$("#proceduricardLink").html('<a href=proceduricard?pid='+pid+'><img src="resources/images/datele-icon.gif" /></a>');
	
	var jqxhr = $.getJSON( "json/explicatiiList", {id:pid}, function(list) {
		$.each(list.rows, function(key, value) {
			$("#xxx").val(value.questionText);
			});
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
<td width="2%" align="center"><img src="resources/images/contracte-icon.gif" />
</td>
<td width="2%" align="center"><img src="resources/images/jaloba-icon.gif"  />
</td>
<td width="1%" align="center">&nbsp;
</td>
</tr>

</table>

<br>
<spring:message code="label.explicatii"/>
<hr width="90%"><br>
	   <input id="xxx" type="text" style="width: 90%;" readonly="readonly">	
</center>
</html>