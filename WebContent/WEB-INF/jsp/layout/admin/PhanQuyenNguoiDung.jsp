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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

div#phanquyenguoidung h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px 10px 30px;
	margin: 0px auto 0px;
	
}
#phanquyenguoidung{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	padding: 0 0 30px 0;
	
}	

#hienthiquyennguoidungthuocve {
	color:#111;
}

#hienthiquyennguoidungthuocve ul {
	list-style-type: none;
	font-weight: bold;
}

#hienthiquyennguoidungthuocve ul li {
	margin: 20px 0px 0px 200px;
}

#hienthiquyennguoidungthuocve ul li ul {
	/*list-style-image: url("images/nested.png");*/
	padding: 5px 0 5px 18px;
}

#hienthiquyennguoidungthuocve ul li ul li {
	display: block;
	color: #3E7E9D;
	background: url("/LuanVanTotNghiep/images/nested.png") no-repeat;
	height: 25px;
	line-height: 25px;
	text-indent: 30px;
	margin: 0px;
}

#hienthiquyennguoidungthuocve ul li a {
	color: #F8AF5A;
}

#hienthiquyennguoidungthuocve ul li a:hover {
	text-decoration: underline;
}

#hienthiquyennguoidungthuocve h2 {
	font-family: Georgia, "Times New Roman", Times, serif;
	letter-spacing: .10em;
	font-size: 24px;
	font-weight: 100;
	border-bottom: groove 2px #CCC;
	width: auto;
	line-height: 24px;
	font-variant: small-caps;
	text-transform: none;
	text-align: center;
	padding: 15px 0 0 0;
}	



</style>
<script>
	$(document).ready(function(){
		
		
	});
</script>
</head>
<body>

	<div id="phanquyenguoidung">
		<h3>Phân quyền người dùng</h3>
			
		<div id="hienthiquyennguoidungthuocve">
			<h2>Thông tin quyền của <span style="color: red;">${tennguoidung}</span></h2>
			<ul>
				<li> Người dùng thuộc nhóm quyền: (<a href="${pageContext.request.contextPath}/service/phanNhomQuyen/${manguoidung}">Quản lý nhóm quyền</a>)
			<ul>
				<c:forEach var="role" items="${roleList}">
					<li>${ role.roles.getTenRolesChiTiet()}</li>
				</c:forEach>
				
			</ul>
			</li>
			<li>Người dùng có các chức năng:
				<ul>
					<c:forEach var="role" items="${roleList}">
						<c:choose>
							<c:when test="${ role.roles.getTenRoles() eq 'ROLE_VAN_THU' }">
								<li>Lập công văn đến, công văn đi, văn bản nội bộ</li>
								<li>Tiếp nhận công văn đến qua mạng</li>
								<li>Cập nhật công văn đến, công văn đi, văn bản nội bộ</li>
								<li>Phân xử lý văn bản</li>
								<li>Ban hành công văn đi</li>
								<li>Tìm kiếm công văn đến, công văn đi, văn bản nội bộ</li>
								<li>Lập hồ sơ lưu trữ</li>
								<li>Cập nhật hồ sơ lưu trữ, Thêm văn bản vào hồ sơ</li>
								<li>Thống kê báo cáo công văn đến, công văn đi</li>
							</c:when>
							<c:when test="${ role.roles.getTenRoles() eq 'ROLE_LANH_DAO' }">
								<li>Nhập các bước trong quy trình</li>
								<li>Tìm kiếm công văn đến, công văn đi, văn bản nội bộ</li>
								<li>Phê duyệt văn bản</li>
								<li>Thống kê báo cáo công văn đến, công văn đi</li>
								<li>Thống kê hiệu suất xử lý công văn của chuyên viên</li>
							</c:when>
							<c:when test="${ role.roles.getTenRoles() eq 'ROLE_QUAN_TRI_HE_THONG'}">
								<li>Cập nhật danh mục công văn</li>
								<li>Cập nhật thông tin người dùng</li>
								<li>Phân quyền cho người dùng</li>
								
							</c:when>
							<c:when test="${role.roles.getTenRoles() eq 'ROLE_XU_LY'}">
								<li>Xử lý công văn</li>
								<li>Tìm kiếm công văn đến, công văn đi, văn bản nội bộ</li>
								
							</c:when>
							
							<c:otherwise>
								<li>Người dùng này chưa cấp quyền</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				
				</ul>
			</li>
			</ul>
		</div>
		
		<div id="table_phanquyen">
		
		</div>
	</div>

</body>
</html>