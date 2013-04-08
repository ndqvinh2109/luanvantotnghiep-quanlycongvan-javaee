<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div#login-info {
	color: #eee;
	font-weight: bold;
	position: absolute;
	top: 0px;
	right: 0px;
	padding: 5px 10px;
}

span.username_banner {
	color: #FF0019;
}

}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url: '/LuanVanTotNghiep/service/showUsername',
			type: 'GET',
			data:null,
			success: function(data){
				console.log(data.userName);
				$('.username_banner').text(data.userName);
			}
		});
		
		
		
	});

</script>
</head>
<body>
<div id="banner">
	<a href="${pageContext.request.contextPath}/service/login.do"><img alt="Hệ thống quản lý công văn" src="/LuanVanTotNghiep/images/banner.png"/></a>
	<div id="login-info">
	<span>Xin chào <span class="username_banner"></span></span>
	</div>
</div>
</body>
</html>