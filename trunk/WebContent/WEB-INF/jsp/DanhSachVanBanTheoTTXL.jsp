<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

div#danhsachvanbantheottxl table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#danhsachvanbantheottxl table td, div#danhsachvanbantheottxl table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#danhsachvanbantheottxl table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#danhsachvanbantheottxl table tr:nth-child(even) {
  background-color: #fff;
}

div#danhsachvanbantheottxl table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}
div#danhsachvanbantheottxl h3{
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<title>Insert title here</title>
</head>

<body>
	<div id="danhsachvanbantheottxl">
		<h3>Danh sách văn bản theo trạng thái xử lý</h3>
		
		<table class="ui-widget ui-widget-content">
			<tr class="ui-widget-header">
			    <th>Ngày Đến</th>
			    <th>Số Đến</th>
			   	<th>Số Hiệu Văn Bản</th>
			   	<th>Ngày Ban Hành</th>
			   	<th>Trích yếu Nội Dung</th>
		  	</tr>
		<c:forEach items="${vanbandenttxlList}" var="vanbanden">
		    <tr id = "${vanbanden.maVanBan}">
		    	<td>${vanbanden.getNgayDen()}</td>
		    	<td>${vanbanden.getSoDen()}</td>
		    	<td>${vanbanden.soKyHieuVanBan}</td>
		        <td>${vanbanden.ngayBanHanh}</td>
		      	<td>${vanbanden.trichYeu}</td>
		   </tr>
		   
		</c:forEach>
	
</table>
	</div>
</body>
</html>