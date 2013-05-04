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
<style>


#tonghoptinhhinhxuly{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;

}	

#form_luachon{
margin: 15px 0 15px 230px;
}

#form_luachon table tr td input{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding: 3px 2px;
width: 90%;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}

#form_luachon table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#form_luachon table tr td select{

color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 200px;
}
div#form_luachon table{
border-collapse: collapse;
 }
 div#form_luachon table td{
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
.ui-tooltip{
 border: 2px solid orange;
 padding: 15px 15px;
 }
 
.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}
table#message{
	/*font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;*/
	width: 700px;
	margin: 5px auto;
	text-align: left;
	border-collapse: collapse;

}

table#message td {
	padding: 8px;
	color: #669;
}

div#content_thongke{
padding: 0 0 15px 0;
}
div#content_thongke table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 div#content_thongke table td, div#content_thongke table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }

div#content_thongke table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#content_thongke table tr:nth-child(even) {
  background-color: #f7f7f7;
}

div#content_thongke	 table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		 $("#tungay").datepicker({
			  showAnim: 'clip',
		      dateFormat: 'yy-mm-dd'
		});
		
		$("#denngay").datepicker({
			 showAnim: 'clip',
		     dateFormat: 'yy-mm-dd'
		}); 
		$.ajax({
			url:'/LuanVanTotNghiep/service/showNhacViec',
			type: 'GET',
			dataType: "json",
			contentType: "application/json",
			success: function(data){
				console.log(data);
								
				if(data.numberVanBanXuLy != 0){
						
				
				var htmlPrepare = '<table id="message">';
				for(var i = 0;i<data.listRoles.length;i++){
				  if(data.listRoles[i].tenRoles == 'ROLE_LANH_DAO'){
					  htmlPrepare += '<tr><td style="color:red">Thông báo phê duyệt:</td>';
					  htmlPrepare += '<td>Hiện tại bạn có văn bản cần phê duyệt.</td></tr>';
				  }
				  
				  if(data.listRoles[i].tenRoles == 'ROLE_XU_LY'){
					  htmlPrepare += '<tr><td style="color:red">Thông báo xử lý: </td>';
					  htmlPrepare += '<td>Hiện tại bạn có văn bản cần xử lý.</td></tr>';
				  }
				  
				 if(data.listRoles[i].tenRoles == 'ROLE_VAN_THU'){
					  var countVanBanDen = data.listVanBanDenChuaXuLy.length;
					  	if(countVanBanDen != 0){
							  htmlPrepare += '<tr><td style="color:red">Thông báo văn bản đến qua mạng: </td>';
							  htmlPrepare += '<td>Hiên tại có <b>' + countVanBanDen + ' </b>văn bản đến qua mạng chưa được tiếp nhận.</td></tr>';
					  	}
				  }
				  
				  console.log(data.listRoles[i].tenRoles);
				}
				
				
				htmlPrepare += '<tr><td colspan="2">' + 'Tổng số lượng văn bản đến đang chờ giải quyết: <b style="color: red">' + data.numberVanBanXuLy + '</b></td></tr>' ;
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
			$('#taotrangin').button().click(function(){
				var tungay = $('#tungay').val();
				var denngay = $('#denngay').val();
				var nguoidung = $('#nguoidung').val();
				if($('#tungay').val().length == 0){
					alert("Bạn chưa nhập thời gian để thống kê hiệu suất xử lý của chuyên viên");
					$('#tungay').focus();
					
				}
				else if($('#denngay').val().length == 0){
					alert("Bạn chưa nhập thời gian để thống kê hiệu suất xử lý của chuyên viên");
					$('#denngay').focus();
					
				}
				else{
				window.location = '${pageContext.request.contextPath}/service/thongKeHieuSuatVanBan/' + nguoidung + '/' + tungay + '/' + denngay;
				}
				return false;
				
			});	
	
			$('#thongketinhhinhxuly').button().click(function(){
				var tungay = $('#tungay').val();
				var denngay = $('#denngay').val();
				var nguoidung = $('#nguoidung').val();
				if($('#tungay').val().length == 0){
					alert("Bạn chưa nhập thời gian để thống kê hiệu suất xử lý của chuyên viên");
					$('#tungay').focus();
					
				}
				else if($('#denngay').val().length == 0){
					alert("Bạn chưa nhập thời gian để thống kê hiệu suất xử lý của chuyên viên");
					$('#denngay').focus();
					
				}
				else{
					$.ajax({
						url: '/LuanVanTotNghiep/service/thongKeTinhHinhXuLy/' + nguoidung + '/' + tungay + '/' + denngay,
						type: 'GET',
						dataType: "json",
						contentType: "application/json",
						success:  function(data){
							
							var htmlPrepare = "<table class='ui-widget ui-widget-content'>";
							htmlPrepare += '<tr class="ui-widget-header"><th>Số đến</th><th>Ngày đến</th><th>Số ký hiệu</th><th>Ngày ban hành</th><th>Trích yếu</th><th>Trạng thái</th><th>Xử lý</th></tr>'
							for(var i = 0; i < data.length ; i++){
								htmlPrepare += '<tr><td>';
								htmlPrepare += data[i].vanban.soDen + '</td><td>';
								htmlPrepare += data[i].vanban.ngayDen + '</td><td>';
								htmlPrepare += data[i].vanban.soKyHieuVanBan + '</td><td>';
								htmlPrepare += data[i].vanban.ngayBanHanh + '</td><td>';
								htmlPrepare += data[i].vanban.trichYeu + '</td><td>';
								if(data[i].vanban.trangThaiXuLy == 1){
									htmlPrepare += 'Chưa xử lý</td><td>';							
								}
								else if(data[i].vanban.trangThaiXuLy == 2){
									htmlPrepare += 'Đang xử lý</td><td>';
								}
								else{
									htmlPrepare += 'Hoàn thành</td><td>';
									
								}
								if(new Date(data[i].thoiGianXuLy) < new Date(data[i].thoiGianHoanThanh)){
									htmlPrepare +='Đúng hạn</td></tr>';
								}
								else{
									htmlPrepare +='Quá hạn</td></tr>';
									
								}
							}
							htmlPrepare += '</table>';
							console.log(data);
							$('#content_thongke').html(htmlPrepare);
						}
				});
				}
							
				return false;
			
			});	
			 
					
	});
	
  
</script>
</head>
<body>
	<div id="tonghoptinhhinhxuly">
		<h3>Tổng hợp xử lý Công văn đến theo chuyên viên</h3>
		<!-- <table class="ui-widget ui-widget-content">
			<tr class="ui-widget-header">
				<th>Tên người dùng</th>
			</tr>
			
		</table> -->
		<div id = "form_luachon">
		<table>
				<tr>
					<td>Từ ngày:</td>
					<td><input type="text" id="tungay" /></td>
				</tr>
				<tr>
					<td>Đến ngày:</td>
					<td><input type="text" id="denngay" /></td>
				</tr>
				<tr>
					<td>Tên người dùng</td>
					<td>
						<select id="nguoidung">
			    			<c:forEach var="nguoidung" items="${nguoidungList}">
			    					<option value='<c:out value="${nguoidung.getMaNguoiDung()}"/>'><c:out value="${nguoidung.getTenNguoiDung()}"/></option>
			    			</c:forEach>
	    				 </select>
					</td>
				</tr>		
				
			</table>
		</div>
		<div id="toolbar" class="ui-widget-header ui-corner-all">
			<button id="taotrangin"><img src="/LuanVanTotNghiep/images/statistics.png"/><span>Biểu đồ</span></button>
			<button id="thongketinhhinhxuly"><img src="/LuanVanTotNghiep/images/1366293005_view_detailed.png"/><span>Thống kê</span></button>
			
		</div>
		<div id="content_thongke">
			
		
		</div>
		<div id="chart_div" style="width: 900px; height: 500px;"></div>
	</div>
	
	
	<div id="message_nhacviec" title="Nhắc việc">
		
	</div>
	
	 
	
	
</body>
</html>