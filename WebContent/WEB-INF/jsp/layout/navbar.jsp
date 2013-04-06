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
		<h3>Thanh nhắc việc</h3>
			
				<ul class="menu">
					<li><a href="${pageContext.request.contextPath}/service/loadXuLyPheDuyetVanBan">Đang chờ xử lý<span id="countdangchoxuly"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/service/tiepNhanVanBanDen">Văn bản đến qua mạng<span id="countvanbanchuatiepnhan"></span></a>
					<li><a href="">Chưa xử lý<span id="countvanbanchuaxuly"></span></a></li>
					<li><a href="">Đang xử lý<span id="countvanbandangxuly"></span></a></li>
					<li><a href="">Quá hạn</a></li>
					<li><a href="">Đã hoàn tất<span id="countvanbanhoanthanh"></span></a></li>
					<li><a href="">Đã lưu</a></li>
				</ul>
				
			
		<h3>Văn bản đến</h3>	
			
				<ul class="menu">
					<li><a href="${pageContext.request.contextPath}/service/nhapvanbanden">Nhập công văn đến</a></li>
					<li><a href="${pageContext.request.contextPath}/service/showvanbanden">Danh mục công văn đến</a></li>
					<li><a href="${pageContext.request.contextPath}/service/nhapbuocthuocquytrinh">Nhập các bước trong quy trình</a></li>
					<li><a href="${pageContext.request.contextPath}/service/timKiemVanBanDen">Tra cứu công văn đến</a></li>
				</ul>
			
		<h3>Văn bản đi</h3>
			
				<ul class="menu">
					<li><a href="${pageContext.request.contextPath}/service/nhapvanbandi">Nhập công văn đi</a></li>
					<li><a href="${pageContext.request.contextPath}/service/showvanbandi">Danh mục công văn đi</a></li>
					<li><a href="">Tra cứu công văn đi</a></li>
				</ul>
		
		<h3>Văn bản nội bộ</h3>	
				<ul class="menu">
					<li><a href="">Nhập văn bản nội bộ</a></li>
					<li><a href="">Danh mục văn bản nội bộ</a></li>
					<li><a href="">Tra cứu văn bản nội bộ</a></li>
				</ul>
		<h3>Hồ sơ lưu trữ</h3>
			
				<ul class="menu">
					<li><a href="${pageContext.request.contextPath}/service/nhapHoSoLuuTru">Nhập hồ sơ lưu trữ</a></li>
					<li><a href="">Xem hồ sơ lưu trữ</a></li>
					<li><a href="">Nhập hồ sơ kết thúc</a></li>
					
				</ul>
		<h3>Báo cáo</h3>
				<ul class="menu">
					<li><a href="">Văn bản đến</a></li>
					<li><a href="">Văn bản đi</a></li>
				</ul>
	</div>	
</div>
</body>
</html>