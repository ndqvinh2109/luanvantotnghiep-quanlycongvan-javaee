<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<title>Insert title here</title>
<style>
	#showPieChart{
		overflow: hidden;
		border: 1px solid #c4c4c4;
		height:412	px;
	}
	#showPieChart img{
	margin: 0 0  40px 40px;
	
	
	}
	div#showPieChart h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
	
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="showPieChart">
	<h3>Biểu đồ thống kê tình hình xử lý công văn của chuyên viên <span style="color: #00aaff; text-shadow: 1px 1px 1px #fffff;"><c:out value="${tennguoidungPieChart}"/></span> </h3>
	
	<img alt ="Biểu đồ thống kê tình hình xử lý công văn của chuyên viên" src="${barUrl}"/>
	</div>
	
</body>
</html>