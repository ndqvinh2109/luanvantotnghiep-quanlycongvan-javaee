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
<style>
div#phanNhomQuyenNguoiDung h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px 10px 30px;
	margin: 0px auto 0px;
	
}
#phanNhomQuyenNguoiDung{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	padding: 0 0 30px 0;
	
}	

#body_phannhomquyen h2 {
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

 
 #body_phannhomquyen table {
	/*font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;*/
	width: 480px;
	margin: 25px auto;
	text-align: center;
	border-collapse: collapse;
}

#body_phannhomquyen table th {
	font-size: 14px;
	font-weight: normal;
	padding: 10px 8px;
	color: #039;
}

#body_phannhomquyen table td {
	padding: 8px;
	color: #669;
}



div#body_phannhomquyen table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#body_phannhomquyen table tr:nth-child(even) {
  background-color: #f7f7f7;
}

#body_phannhomquyen form input.submitpq {
	cursor: pointer;
	width: 80px;
	height: 29px;
	line-height: 25px;
	font-size: 12px;
	font-weight: bold;
	color: #fff;
	background: #3c85fe;
	border: 1px solid #3079ED;
	margin: 5px 0px 0px 340px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
}
#body_phannhomquyen select{
width:100px;
}
)
</style>

<script type="text/javascript">
	$(document).ready(function(){
		
		
		$('#submit_capnhat').click(function(){
			$('.checkPhanQuyen').each(function(index,element){
				var manguoidung = $('#manguoidung').val();
				var marole = $(element).attr('id');
				var giatri = $(element).find('.giatriphanquyen').val();
					/* alert(marole + '//' + giatri); */
				
				$.ajax({
					url: '/LuanVanTotNghiep/service/addThemNhomQuyen/' + manguoidung + '/' + marole + '/' + giatri,
					type: 'POST',
					data: null,
					contentType: 'text/html; charset=UTF-8',
					success: function(result){
						
						
						
					}
				});
					
				
				
				
			});
			
			alert("Cập nhật quyền thành công");
			location.reload(true);
			return false;
			
		});
		
		$('#huybopq').click(function(){
			
			window.location = '${pageContext.request.contextPath}/service/phanQuyenNguoiDung/' + '${manguoidung}';
			
			return false;
		});
		
	});

</script>

</head>
<body>
	<div id="phanNhomQuyenNguoiDung">
		<h3>Quản lý quyền</h3>
			
			<div id="body_phannhomquyen">
			<h2>Quản lý quyền người dùng (<span style="color: red;">${tennguoidung}</span>)</h2>
				<form action="" method="post">
					<input type="hidden" value="${manguoidung}" id="manguoidung" />
					<table>
						<tr>
							<th>Tên quyền</th>
							<th>Quyền người dùng</th>
						</tr>
						<c:forEach var="role" items="${roleList}">
							<tr id="${role.getMaRoles()}" class="checkPhanQuyen">
								<td>${role.getTenRolesChiTiet()}</td>
								<td>
								
								<select class="giatriphanquyen">
									<option value='1'>Cho phép</option>
							     	<option value='2'>Từ chối</option>
							     	<option value='3' selected = 'selected'>Mặc định</option>
								</select>
								
								</td>
							</tr>
						</c:forEach>
					</table>
					
					<input type="submit" id="submit_capnhat" class="submitpq" value="Cập nhật"/><br>
					<input type="button" id="huybopq" class="submitpq" value="Hủy bỏ"/>
				</form>
			</div>
	
	</div>
</body>
</html>