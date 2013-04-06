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
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url:'/LuanVanTotNghiep/service/showNhacViec',
			type: 'GET',
			dataType: "json",
			contentType: "application/json",
			success: function(data){
				console.log(data);
				//alert(data.numberVanBanXuLy);
				$('#countdangchoxuly').text(data.numberVanBanXuLy);
				$('#countvanbanchuatiepnhan').text(data.ListVanBanChuaTiepNhan.length);
				$('#countvanbanchuaxuly').text(data.ListVanBanChuaXuLy.length);
				$('#countvanbandangxuly').text(data.ListVanBanDangXuLy.length);
				$('#countvanbanhoanthanh').text(data.ListVanBanHoanThanh.length);
				if(data.numberVanBanXuLy != 0){
						
				
				var htmlPrepare = '<table>';
				for(var i = 0;i<data.listRoles.length;i++){
				  if(data.listRoles[i].tenRoles == 'ROLE_LANH_DAO'){
					  htmlPrepare += '<tr><td>Thông báo phê duyệt: </td>';
					  htmlPrepare += '<td>Hiện tại bạn có văn bản cần phê duyệt.</td></tr>';
				  }
				  if(data.listRoles[i].tenRoles == 'ROLE_XU_LY'){
					  htmlPrepare += '<tr><td>Thông báo xử lý: </td>';
					  htmlPrepare += '<td>Hiện tại bạn có văn bản cần xử lý.</td></tr>';
				  }
				 /* if(data.listRoles[i].tenRoles == 'ROLE_VAN_THU'){
					  var countVanBanDen = data.listVanBanDenChuaXuLy.length;
					  	if(countVanBanDen != 0){
							  htmlPrepare += '<tr><td>Thông báo văn bản đến qua mạng: </td>';
							  htmlPrepare += '<td>Hiên tại có ' + countVanBanDen + ' văn bản đến qua mạng chưa được tiếp nhận.</td></tr>';
					  	}
				  } */
				  
				  console.log(data.listRoles[i].tenRoles);
				}
				
				
				htmlPrepare += '<tr><td colspan="2">' + 'Tổng số lượng văn bản đến đang chờ giải quyết: ' + data.numberVanBanXuLy + '</td></tr>' ;
				htmlPrepare += '</table>';
				$('#message_nhacviec').html(htmlPrepare);
				$( "#message_nhacviec" ).dialog({
				      height: 'auto',
				      width: 'auto',
				      modal: true
				});
			}
		}
			
		});
					
	});
</script>
</head>
<body>
	<div id="tonghoptinhhinhxuly">
		<h3>Tổng hợp xử lý Công văn đến theo chuyên viên</h3>
	</div>
	<div id="message_nhacviec" title="Nhắc việc">
	
	</div>
	
	<%-- <div id="dialog-form" title="Đăng nhập vào hệ thống">
		 <p class="validateTips">Vui lòng nhập thông tin đăng nhập.</p>
		<form method="post" action="">
			<input type="text" id="tendangnhap" placeholder="Tên đăng nhập" class="txtinput"/>
			<input type="password" id="password" placeholder="Mật khẩu" class="txtinput"/>
			<input type="submit" id="login" value="Đăng nhập"/>
			<input type="reset" id="huy" value="Hủy" />
		</form>
		
		
		
		
	</div> --%>
	<!-- <button id="login">Đăng nhập</button> -->
	
	
</body>
</html>