<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul id="navigation">
		<li class="login"><a href="<c:url value="/j_spring_security_logout" />" title="Đăng xuất" id="login"></a></li>
		<li class="showmenu"><a href="#" title="Hiện/Ẩn thanh menu"></a></li>
	</ul>
</body>
</html>