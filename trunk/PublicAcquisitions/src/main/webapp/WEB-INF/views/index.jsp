<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	
	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<title><spring:message code="label.title"/></title>
  
<!--   	<script src="resources/js/jquery-1.9.1.js"></script> -->
	<!-- jQuery JavaScript -->
		<script src="resources/js/jquery-1.8.2.js"></script>

  	
  	<script  src="resources/js/jquery-ui-1.9.2.custom.js"></script>
  	<link 	href="resources/css/jquery-ui-1.9.2.custom.css" rel="stylesheet"  type="text/css" media="screen" />
  	
  	<script src="resources/js/jquery.jqGrid.min.js" type="text/javascript"></script>
  	<script src="resources/js/grid.locale-en.js" 	type="text/javascript"></script>
	<link 	href="resources/css/ui.jqgrid.css" 		rel="stylesheet" type="text/css" media="screen"  />	
  
  
	<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
	
	
	<!-- Common Kendo UI Web CSS -->
	<link href="resources/styles/kendo.common.min.css" rel="stylesheet" />
	<!-- Default Kendo UI Web theme CSS -->
	<link href="resources/styles/kendo.default.min.css" rel="stylesheet" />
	<!-- jQuery JavaScript -->
	<!-- 	<script src="resources/js/jquery.min.js"></script> -->
	<!-- Kendo UI Web combined JavaScript -->
	<script src="resources/js/kendo.web.min.js"></script>
	
	
	<script type="text/javascript">
	
	var w = document.width*0.98; //Greds width
	
	function getKendoComboBoxSelectedValue(item){
		if (item != undefined) {
			if (item.dataItem()  != undefined ) {
				if (item.dataItem().id != undefined ) {
					return item.dataItem().id;		
				}
			}
		}
		return "";
		
	}		
	
	</script>
	<style>
    	.dotted {border: 2px dotted #000000; border-style: none none dotted; color: #fff; background-color: #fff; }
	</style>
	
</head>

<body>
	
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header><!-- #header-->

	<div id="content">
		<tiles:insertAttribute name="body" />
	</div><!-- #content-->

	<footer id="footer">
		<tiles:insertAttribute name="footer" />
<!-- 		<input id="currentContentPageName" value=""> -->
	</footer><!-- #footer -->
</body>
</html>
