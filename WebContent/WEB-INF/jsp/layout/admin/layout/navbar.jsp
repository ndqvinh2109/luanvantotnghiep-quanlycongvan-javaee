<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
			
		$(function() {
		    $( "#navbar" ).accordion({
		      collapsible: true,
		      heightStyle: "content"
		    });
		  });
</script>

</head>
<body>
<div id="left">
	<div id ="navbar">
		<h3>Quản trị người dùng</h3>
			
				<ul class="menu">
					<li><a href="${pageContext.request.contextPath}/service/themNguoiDung">Quản trị người dùng</a></li>
					<li><a href="${pageContext.request.contextPath}/service/phanCapNguoiDung">Phân quyền người dùng</a></li>
					<li><a href="">Thêm quyền</a></li>
					<li><a href="">Cập nhật quyền</a></li>
				</ul>
				
		<h3>Quản trị danh mục</h3>	
			
				<ul class="menu">
					<li><a href="">Cấp độ bảo mật</a></li>
					<li><a href="${pageContext.request.contextPath}/service/danhMucCapDoKhan">Cấp độ khẩn</a></li>
					<li><a href="">Loại văn bản</a></li>
					<li><a href="">Lĩnh vực</a></li>
					<li><a href="">Nơi lưu trữ</a></li>
					<li><a href="">Hồ sơ lưu trữ</a></li>
					<li><a href="">Chức vụ</a></li>
				</ul>
			
		
	</div>	
</div>
</body>
</html>