<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" pageEncoding="utf-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	
	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<title></title>
	<link rel="stylesheet" href="resources/style.css" type="text/css" />
</head>

<body>
	<div id="wrapper">
		<header id="header">
			<tiles:insertAttribute name="header" />
			<div id="menu-container">
				<tiles:insertAttribute name="menu" />
			</div>			
		</header><!-- #header-->
	</div><!-- #wrapper -->

	<div id="content">
		<tiles:insertAttribute name="body" />
	</div><!-- #content-->

	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer><!-- #footer -->

</body>
</html>
