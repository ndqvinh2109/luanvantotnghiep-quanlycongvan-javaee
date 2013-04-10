<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
		$(function() {
		    $( "#navbar" ).accordion({
		      collapsible: true,
		      active:0
		    });
		    
		    $.ajax({
				url:'/LuanVanTotNghiep/service/showCount',
				type: 'GET',
				dataType: "json",
				contentType: "application/json",
				success: function(data){
					console.log(data);
					
					$('#countdangchoxuly').text(data.numberVanBanXuLy);
					$('#countvanbanchuatiepnhan').text(data.ListVanBanChuaTiepNhan.length);
					$('#countvanbanchuaxuly').text(data.ListVanBanChuaXuLy.length);
					$('#countvanbandangxuly').text(data.ListVanBanDangXuLy.length);
					$('#countvanbanhoanthanh').text(data.ListVanBanHoanThanh.length);
					
			}
				
			});
		    
		    
		    
		   
		  });
</script>

</head>
<body>
<div id="left">
	<div id ="navbar">
		<h3>Thanh nhắc việc</h3>
			
				<ul class="menu" id="thanhnhacviecnavbar">
					<li><a href="${pageContext.request.contextPath}/service/loadXuLyPheDuyetVanBan">Đang chờ xử lý<span id="countdangchoxuly"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/service/tiepNhanVanBanDen">Văn bản đến qua mạng<span id="countvanbanchuatiepnhan"></span></a>
					<li><a href="${pageContext.request.contextPath}/service/DanhSachVanBanTheoTTXL/1">Chưa xử lý<span id="countvanbanchuaxuly"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/service/DanhSachVanBanTheoTTXL/2">Đang xử lý<span id="countvanbandangxuly"></span></a></li>
					<li><a href="">Quá hạn</a></li>
					<li><a href="${pageContext.request.contextPath}/service/DanhSachVanBanTheoTTXL/3">Đã hoàn tất<span id="countvanbanhoanthanh"></span></a></li>
					<li><a href="">Đã lưu</a></li>
				</ul>
				
			
		<h3>Văn bản đến</h3>	
			
				<ul class="menu" id="vanbandennavbar">
					<li><a href="${pageContext.request.contextPath}/service/nhapvanbanden">Nhập công văn đến</a></li>
					<li><a href="${pageContext.request.contextPath}/service/showvanbanden/1">Danh mục công văn đến</a></li>
					<li><a href="${pageContext.request.contextPath}/service/nhapbuocthuocquytrinh">Nhập các bước trong quy trình</a></li>
					<li><a href="${pageContext.request.contextPath}/service/timKiemVanBanDen">Tra cứu công văn đến</a></li>
				</ul>
			
		<h3>Văn bản đi</h3>
			
				<ul class="menu" id="vanbandinavbar">
					<li><a href="${pageContext.request.contextPath}/service/nhapvanbandi">Nhập công văn đi</a></li>
					<li><a href="${pageContext.request.contextPath}/service/showvanbandi/1">Danh mục công văn đi</a></li>
					<li><a href="">Tra cứu công văn đi</a></li>
				</ul>
		
		<h3>Văn bản nội bộ</h3>	
				<ul class="menu" id="vanbannoibonavbar">
					<li><a href="">Nhập văn bản nội bộ</a></li>
					<li><a href="">Danh mục văn bản nội bộ</a></li>
					<li><a href="">Tra cứu văn bản nội bộ</a></li>
				</ul>
		<h3>Hồ sơ lưu trữ</h3>
			
				<ul class="menu" id="hosoluutrunavbar">
					<li><a href="${pageContext.request.contextPath}/service/nhapHoSoLuuTru">Nhập hồ sơ lưu trữ</a></li>
					<li><a href="">Xem hồ sơ lưu trữ</a></li>
					<li><a href="">Nhập hồ sơ kết thúc</a></li>
					
				</ul>
		<h3>Báo cáo</h3>
				<ul class="menu" id="baocaonavbar">
					<li><a href="${pageContext.request.contextPath}/service/baoCaoVanBanDen">Văn bản đến</a></li>
					<li><a href="">Văn bản đi</a></li>
				</ul>
		<h3>Tiện ích</h3>
				<ul class="menu" id="tienichnavbar">
					<li><a href="${pageContext.request.contextPath}/service/guiTinNhanNoiBo">Phòng gửi tin nhắn nội bộ</a></li>
				</ul>
	</div>	
</div>
</body>
</html>