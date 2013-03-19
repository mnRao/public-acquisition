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
  
  	<script src="resources/js/jquery-1.9.1.js"></script>
  	<script src="resources/js/jquery-ui-1.10.1.custom.js"></script>
  	<link 	href="resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"  type="text/css" media="screen" />
  	
  	<script src="resources/js/jquery.jqGrid.min.js" type="text/javascript"></script>
  	<script src="resources/js/grid.locale-en.js" 	type="text/javascript"></script>
	<link 	href="resources/css/ui.jqgrid.css" 		rel="stylesheet" type="text/css" media="screen"  />	
  
	<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
	
	<script type="text/javascript">

	
	</script>
	
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
	</footer><!-- #footer -->
</body>
</html>
