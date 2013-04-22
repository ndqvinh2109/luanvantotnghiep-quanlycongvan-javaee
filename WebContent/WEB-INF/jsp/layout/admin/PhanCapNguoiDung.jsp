<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery.treeview.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<script src="/LuanVanTotNghiep/js/jquery.treeview.js"></script>
<style type="text/css">
div#phancapnguoidung h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
	
}

div#phancapnguoidung{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	padding: 0 0 10px 0;
	
}	
div#treephancapnguoidung{
	float:left;
	width:300px;
	margin: 5px 5px 0 0;
	border: 1px solid #aaaaaa;
	background-color: white;
	
}
div#treephancapnguoidung a{
	text-decoration: none;
	background-color: white;
	
}
div#tablephancapnguoidug{
	overflow:hidden;
	margin: 5px 0 0 5px;
	border: 1px solid #aaaaaa;
	
}
div#tablephancapnguoidug table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 
 div#tablephancapnguoidug table td, div#tablephancapnguoidug table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
div#tablephancapnguoidug table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#tablephancapnguoidug table tr:nth-child(even) {
  background-color: #f7f7f7;
}

div#tablephancapnguoidug table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}
div#tablephancapnguoidug table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	
	$('#phancapnguoidung a').click(function(evt){
		evt.preventDefault();
		var madonvi = $(this).attr("id");
			
		$.ajax({
			url: '/LuanVanTotNghiep/service/getNguoiDungListTheoDonVi/' + madonvi,
			type: 'GET',
			dataType: "json",
    		contentType: "application/json",
    		success: function(data){
    			
    			console.log(data);
    			var htmlPrepare = '<table class="ui-widget ui-widget-content"><tr class="ui-widget-header"><td>Họ và tên</td><td>Địa chỉ</td><td>Email</td><td>Số điện thoại</td><td>Giới tính</td><td>Tên đăng nhập</td></tr>';
    			for(var i = 0; i < data.length; i++){
    				htmlPrepare += '<tr><td>';
    				htmlPrepare += data[i].tenNguoiDung + '</td><td>';
    				htmlPrepare += data[i].diaChi + '</td><td>';
    				htmlPrepare += data[i].email + '</td><td>';
    				htmlPrepare += data[i].soDienThoai + '</td><td>';
    				htmlPrepare += data[i].gioiTinh + '</td><td>';
    				htmlPrepare += data[i].userName + '</td></tr>';
    			}
    			htmlPrepare += '</table>';
    			$('#tablephancapnguoidug').html(htmlPrepare);
    		}
			
		});
			
	});
	
	$("#tree").treeview({
		collapsed: true,
		animated: "fast",
		control:"#sidetreecontrol",
		prerendered: true,
		persist: "location"
	});
	
	
	
	});
</script>
</head>
<body>
	<div id="phancapnguoidung">
		<h3>Quản lý phân cấp quyền người dùng</h3>
		<div id="treephancapnguoidung">
			<div class="treeheader">&nbsp;</div>
			<div id="sidetreecontrol"> <a href="?#">Collapse All</a> | <a href="?#">Expand All</a> </div>
					<ul class="treeview" id="tree">
							<li class="expandable"><div class="hitarea expandable-hitarea"></div><img src="/LuanVanTotNghiep/css/images/1366575805_224320-folder-image-people.png" /> <a href="#" class="tendonvi" id="${donvi.maDonVi}">${donvi.tenDonVi}</a>
									<ul> <!-- style="display: none;" -->
										<c:forEach var="donvipt" items="${donviptList}">
											<c:if test="${donvipt.kieuDonVi == 3 }">
												<li><img src="/LuanVanTotNghiep/css/images/1366576381_user-home.png" /> <a href="#" class="tendonvi" id="${donvipt.maDonVi}">${donvipt.tenDonVi}</a></li>
											</c:if>
											<c:if test="${donvipt.kieuDonVi == 2 }">
												<li><img src="/LuanVanTotNghiep/css/images/1366576630_folder_add.png" /> <a href="#" class="tendonvi" id="${donvipt.maDonVi}">${donvipt.tenDonVi}</a></li>
											</c:if>
											
										
										</c:forEach>
									</ul>
							</li>
					</ul>
					
					
		</div>
		<div id="tablephancapnguoidug">
			
		</div>
	</div>
	
</body>
</html>