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
<style type="text/css">
.cpan{
color: white;
background-color: #3d85fe;
border: 1px solid #4376c9;
font-weight: bold;

}
div#themnguoidung h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px 10px 30px;
	margin: 0px auto 0px;
	
}

#themnguoidung{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	padding: 0 0 30px 0;
	
}	

#body_inner{
margin: 10px 0 10px 50px;
}


div#body_inner table{
 margin: 0; border-collapse: collapse; width: 90%; 
}

div#body_inner table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#table_inner table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 
 div#table_inner table td, div#table_inner table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }

#toolbar{
padding:5px 5px 5px 5px;
}


#toolbar img {
  position: absolute;
  width: 16px;
  height: 16px;
  left: 2px;
  top: 50%;
  margin-top: -8px;
  
  	
}

#toolbar span{
  height: 20px;
  line-height: 20px;
  float: left;
  padding-left: 11px;
}

div#table_inner table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#table_inner table tr:nth-child(even) {
  background-color: #f7f7f7;
}

div#table_inner table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}
div#table_inner table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}
</style>


<script type="text/javascript">

	$(document).ready(function(){
		var manguoidung = null;
		$('#table_inner tr').not(':first').bind('click',function(){
			manguoidung = $(this).attr('id');
			$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
			var tennguoidung = $(this).find("td").eq(0).html();
			var diachi = $(this).find("td").eq(1).html();
			var email = $(this).find("td").eq(2).html();
			var sodienthoai = $(this).find("td").eq(3).html();
			var gioitinh = $(this).find("td").eq(4).html();
			var donvi = $(this).find("td").eq(5).html();
			var tendangnhap = $(this).find("td").eq(6).html();
			
			$('#tennguoidung').val(tennguoidung);
			$('#diachi').val(diachi);
			$('#email').val(email);
			$('#sodienthoai').val(sodienthoai);
			$('#gioitinh').val(gioitinh);
			$('#donvi').val(donvi);
			$('#username').val(tendangnhap);
		});    
		
		
		$('#themnguoidungsub').button().click(function(){
			
			var tennguoidung = $('#tennguoidung').val();
			var diachi = $('#diachi').val();
			var email = $('#email').val();
			var sodienthoai = $('#sodienthoai').val();
			var gioitinh = $('#gioitinh').val();
			var donvi = $('#donvi').val();
			var tendangnhap = $('#username').val();
			var password2 = $('#password2').val();
			if(tennguoidung.length==0){
				alert("Xin nhập trường Tên người dùng");
				$('#tennguoidung').focus();
				
			}
			else if(diachi.length==0){
				alert("Xin nhập trường Địa chỉ");
				$('#diachi').focus();
				
			}
			else if(email.length==0){
				alert("Xin nhập trường Email");
				$('#email').focus();
			}
			else if(sodienthoai.length==0){
				alert("Xin nhập trường Số điện thoại");
				$('#sodienthoai').focus();
			}
			else if(tendangnhap.length==0){
				alert("Xin nhập trường Tên đăng nhập");
				$('#username').focus();
				
			}
			else if(password2.length==0){
				alert("Xin nhập trường Mật khẩu");
				$('#password2').focus();
				
			}
			else{
			$.ajax({
				url : '/LuanVanTotNghiep/service/themNguoiDung/' + tennguoidung + '/' +
				diachi + '/' + email + '/' + sodienthoai + '/' + gioitinh + '/' + donvi + '/' +
				tendangnhap + '/' + password2,
				type: 'POST',
				contentType: 'text/html; charset=UTF-8',
				data: null,
				success: function(result){
					if(result){
						location.reload(true);
						
					}
					
				}
				
			});
			}
			
			
			return false;
		});
		$('#xoanguoidungsub').button().click(function(){
			if(confirm('Bạn có chắc xóa Cấp Độ Khẩn này không?')){
			$.ajax({
				url : '/LuanVanTotNghiep/service/xoaNguoiDung/' +  manguoidung,
				type: 'GET',
				contentType: 'text/html; charset=UTF-8',
				data: null,
				success: function(result){
					if(result){
						location.reload(true);
						
					}
					
				}
				
			});
			}
			return false;
		});
		
		$('#suanguoidungsub').button().click(function(){
	
			var tennguoidung = $('#tennguoidung').val();
			var diachi = $('#diachi').val();
			var email = $('#email').val();
			var sodienthoai = $('#sodienthoai').val();
			var gioitinh = $('#gioitinh').val();
			var donvi = $('#donvi').val();
			var tendangnhap = $('#username').val();
			var password2 = $('#password2').val();
			if(password2.length == 0){
				$.ajax({
					url : '/LuanVanTotNghiep/service/suaNguoiDung1/' +  manguoidung + '/' + tennguoidung + '/' +
					diachi + '/' + email + '/' + sodienthoai + '/' + gioitinh + '/' + donvi + '/' +
					tendangnhap,
					type: 'POST',
					contentType: 'text/html; charset=UTF-8',
					data: null,
					success: function(result){
						if(result){
							location.reload(true);
							
						}
						
					}
					
				});
				
			}
			else{
			
			$.ajax({
				url : '/LuanVanTotNghiep/service/suaNguoiDung2/' +  manguoidung + '/' + tennguoidung + '/' +
				diachi + '/' + email + '/' + sodienthoai + '/' + gioitinh + '/' + donvi + '/' +
				tendangnhap + '/' + password2,
				type: 'POST',
				contentType: 'text/html; charset=UTF-8',
				data: null,
				success: function(result){
					if(result){
						location.reload(true);
						
					}
					
				}
				
			});
			}
			
			return false;
		});

		$('#cleartruong').button().click(function(){
			$('#tennguoidung').val('');
			$('#diachi').val('');
			$('#email').val('');
			$('#sodienthoai').val('');
			$('#gioitinh').val(0);
			$('#donvi').val(1);
			$('#username').val('');
			return false;
		});
		
		$('#phanquyen').button().click(function(){
			
			window.location = '${pageContext.request.contextPath}/service/phanQuyenNguoiDung/' + manguoidung;
			
		});
		
	});

</script>
</head>
<body>
	<div id="themnguoidung">
		<h3>Thêm người dùng mới</h3>
		<div id="body_inner">
			<form action="" method="post">
				<table>
					<tr>
						<td class="cpan" colspan="2">Thông tin người dùng</td>
						
					</tr>
					<tr>
						<td>Tên người dùng</td>
						<td><input type="text" id="tennguoidung" /></td>
					</tr>
					<tr>
						<td>Địa chỉ</td>
						<td><input type="text" id="diachi" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" id="email" /></td>
					</tr>
					<tr>
						<td>Số điện thoại</td>
						<td><input type="text" id="sodienthoai" /></td>
					</tr>
					<tr>
						<td>Giới tính</td>
						<td>
							<select id="gioitinh">
								<option value="0">Nam</option>
								<option value="1">Nữ</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Đơn vị</td>
						<td>
							<select id="donvi">
	    						<c:forEach var="donvi" items="${donviList}">
	    							<option value='<c:out value="${donvi.getMaDonVi()}"/>'><c:out value="${donvi.getTenDonVi()}"/></option>
	    						</c:forEach>
	    					</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="cpan">Thông tin đăng nhập</td>
						
					</tr>
					<tr>
						<td>Tên đăng nhập</td>
						<td><input type="text" id="username" /></td>
					</tr>
					<tr>
						<td>Mật khẩu</td>
						<td><input type="password" id="password2" /></td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="toolbar" class="ui-widget-header ui-corner-all">
			<button id="themnguoidungsub"><img src="/LuanVanTotNghiep/images/add1.png"/><span>Thêm</span></button>
			<button id="xoanguoidungsub"><img src="/LuanVanTotNghiep/images/button_cancel.png"/><span>Xóa</span></button>
			<button id="suanguoidungsub"><img src="/LuanVanTotNghiep/images/form_edit.png"/><span>Sửa</span></button>
			<button id="cleartruong"><img src="/LuanVanTotNghiep/images/history_clear.png"/><span>Xóa trường</span></button>
			<button id="phanquyen"><img src="/LuanVanTotNghiep/images/document_redirect.png"/><span>Phân quyền</span></button>
		</div>
		
		<div id="table_inner">
			<table class="ui-widget ui-widget-content">
			<tr class="ui-widget-header">
				<th>Họ và tên</th>
				<th>Địa chỉ</th>
				<th>Email</th>
				<th>Số điện thoại</th>
				<th>Giới tính</th>
				<th>Đơn vị</th>
				<th>Tên đăng nhập</th>
			</tr>
			<c:forEach items="${nguoidungList}" var="nguoidung">
			    <tr id = "${nguoidung.getMaNguoiDung()}">
			    	<td>${nguoidung.getTenNguoiDung()}</td>
				    <td>${nguoidung.getDiaChi()}</td>
				    <td>${nguoidung.getEmail()}</td>
				    <td>${nguoidung.getSoDienThoai()}</td>
				    <td>${nguoidung.getGioiTinh()}</td>
				    <td>${nguoidung.donvi.maDonVi}</td>
				    <td>${nguoidung.getUserName()}</td>
				    
			    </tr>
	   		</c:forEach>
		</table>
		</div>
	</div>
	
</body>
</html>