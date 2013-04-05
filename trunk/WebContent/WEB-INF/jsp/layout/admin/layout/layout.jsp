<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<script src="/LuanVanTotNghiep/js/effects.js"></script>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/main.css">
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
	body {	
	font: 75%/120% Arial, Helvetica, sans-serif;
	background: url(/LuanVanTotNghiep/images/crossline-bg.gif); /* Cross line background */
}
</style>

</head>
	<body>
	
		<div id="container">
			<tiles:insertAttribute name="banner" />
			<tiles:insertAttribute name="leftbar" />
			<div id="wrapper">
				<tiles:insertAttribute name="navbar"/>
				<div id="content">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
		</div>
	
		
	</body>
</html>