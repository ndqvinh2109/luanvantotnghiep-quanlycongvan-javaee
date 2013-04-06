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
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<style>
div#nhapHoSoLuuTru h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px 10px 30px;
	margin: 0px auto 0px;
	
}

#nhapHoSoLuuTru{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	
}
div#table_nhapHoSo table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 div#table_nhapHoSo table td, div#table_nhapHoSo table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
#content_nhapHoSo{
margin: 10px 0 10px 180px;
}
 div#content_nhapHoSo table{
 margin: 0; border-collapse: collapse; width: 70%; 
 }
 div#content_nhapHoSo table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 

 
 div#dialog_them table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 div#dialog_them table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#table_nhapHoSo table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#table_nhapHoSo table tr:nth-child(even) {
  background-color: #f7f7f7;
}

div#table_nhapHoSo table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}


div#dialog_themvanbanvaohoso table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 div#dialog_themvanbanvaohoso table td,div#dialog_themvanbanvaohoso table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#dialog_themvanbanvaohoso table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#dialog_themvanbanvaohoso table tr:nth-child(even) {
  background-color: #f7f7f7;
}

div#dialog_themvanbanvaohoso table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}
.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}
div#table_inner table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
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
#content_nhapHoSo table tr td input{
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

#content_nhapHoSo table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#dialog_them table tr td input{
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

#dialog_them table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

.ui-spinner{

height: 30px;
width:240px;
padding:0
}
</style>
<script>
$(document).ready(function(){
	var sohoso = null;
		$('#table_nhapHoSo tr').not(':first').bind('click',function(){
		sohoso = $(this).attr('id');
		$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
		var mahoso = $(this).find("td").eq(0).html();
		var tieudehoso = $(this).find("td").eq(1).html();
		var thoigianbatdau = $(this).find("td").eq(2).html();
		var thoigianketthuc = $(this).find("td").eq(3).html();
		var thoihanbaoquan = $(this).find("td").eq(4).html();
		$('#mahoso').val(mahoso);
		$('#tieudehoso').val(tieudehoso);
		$('#thoigianbatdau').val(thoigianbatdau);
		$('#thoigianketthuc').val(thoigianketthuc);
		$('#thoihanbaoquan').val(thoihanbaoquan);
	});
	
	$("#thoigianbatdau").datepicker({
		  showAnim: 'clip',
	      dateFormat: 'yy-mm-dd'
	});
	
	$("#thoigianketthuc").datepicker({
		 showAnim: 'drop',
	      dateFormat: 'yy-mm-dd'
	});
	$("#thoigianbatdauthem").datepicker({
		  showAnim: 'clip',
	      dateFormat: 'yy-mm-dd'
	});
	
	$("#thoigianketthucthem").datepicker({
		 showAnim: 'drop',
	      dateFormat: 'yy-mm-dd'
	});
	$( "#thoihanbaoquan" ).spinner({
		 spin: function( event, ui ) {
	         if ( ui.value < 1 ) {
	          $( this ).spinner( "value", 1 );
	          return false;
	        }
		 }
		
	});
	$( "#thoihanbaoquanthem" ).spinner({
		 spin: function( event, ui ) {
	         if ( ui.value < 1 ) {
	          $( this ).spinner( "value", 1 );
	          return false;
	        }
		 }
		
	});
	$( "#dialog_them").dialog({
		  autoOpen: false,
	      resizable: true,
	      height:'auto',
	      width:'auto',
	      modal: true,
	      show: {
	          effect: "slide",
	          duration: 500
	        },
	      hide: {
		          effect: "slide",
		          duration: 500
		        },
	      buttons: {
	       	'Lưu': function(){
	       		var mahosothem = $('#mahosothem').val();
	    		var tieudehosothem = $('#tieudehosothem').val();
	    		var thoigianbatdauthem = $('#thoigianbatdauthem').val();
	    		var thoigianketthucthem = $('#thoigianketthucthem').val();
	    		var thoihanbaoquanthem = $('#thoihanbaoquanthem').val();
	    		$.ajax({
	    			url: '/LuanVanTotNghiep/service/addHoSoLuuTru/' + mahosothem + '/' + tieudehosothem + '/' +
	    			thoigianbatdauthem + '/' + thoigianketthucthem + '/' + thoihanbaoquanthem,
	    			type: 'POST',
	    			contentType: 'text/html; charset=UTF-8',
	    			data: null,
	    			success: function(result){
	    				if(result){
	    					alert("Thêm thành công");
	    					
	    					location.reload(true);
	    					
	    				}
	    				
	    			}
	    			
	    		});
	       		
	       	},	        
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      },
	      
	    });
	
	$('#themhoso').button().click(function(){
		
		$( "#dialog_them").dialog('open');
		return false;
		
	});
	
	
	$('#xoahoso').button().click(function(){
		if(confirm('Bạn có chắc xóa hồ sơ lưu trữ này không?')){
			$.ajax({
				url: '/LuanVanTotNghiep/service/xoaHoSoLuuTru/' + sohoso,
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
	
	
	$('#suahoso').button().click(function(){
		var mahoso = $('#mahoso').val();
		var tieudehoso = $('#tieudehoso').val();
		var thoigianbatdau = $('#thoigianbatdau').val();
		var thoigianketthuc = $('#thoigianketthuc').val();
		var thoihanbaoquan = $('#thoihanbaoquan').val();
		$.ajax({
			url: '/LuanVanTotNghiep/service/updateHoSoLuuTru/' + sohoso + '/'+ mahoso + '/' + tieudehoso + '/' +
			thoigianbatdau + '/' + thoigianketthuc + '/' + thoihanbaoquan,
			type: 'POST',
			contentType: 'text/html; charset=UTF-8',
			data: null,
			success: function(result){
				if(result){
					alert("Sửa thành công");
					
					location.reload(true);
					
				}
				
			}
			
		});
		return false;
	});
	var sohosodialog = null;
	$('#dialog_themvanbanvaohoso tr').not(':first').bind('click',function(){
		sohosodialog = $(this).attr('id');
		alert(sohosodialog);
		
	});
	$( "#dialog_themvanbanvaohoso").dialog({
		  autoOpen: false,
	      resizable: true,
	      height:'auto',
	      width:'auto',
	      modal: true,
	      buttons: {
	       	'Thêm': function(){
	       		
	       		/*  var maVanBan = $('.sokyhieuvanban').val();
				$('.donvidoclap').each(function(index,element){
					if($(element).find('.madonvidoclap').is(':checked')){
					var madonvi = $(element).find('.madonvidoclap').val();
					$.ajax({
						url: '/LuanVanTotNghiep/service/addVanBanGuiDonVi/' + maVanBan + '/' + madonvi,
						type: 'POST',
						data: null,
						success:function(result){
							if(result){
								alert("Thành công");
							}
							
						}
					});
				}
    	 	  }); */
	       		
	       		
	       	},      
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      },
	      
	    });
	$('#themvanban').button().click(function(){
		$( "#dialog_themvanbanvaohoso").dialog('open');
		return false;
	});
	
});
</script>
</head>
<body>

	<div id="nhapHoSoLuuTru">
		<h3>Nhập hồ sơ lưu trữ</h3>
		
		<div id="content_nhapHoSo">
			<form action="" method="post">
				<table>
					<tr>
						<td>Mã hồ sơ</td>
						<td><input type="text" id="mahoso" /></td>
					</tr>
					<tr>
						<td>Tiêu đề hồ sơ</td>
						<td><input type="text" id="tieudehoso" /></td>
					</tr>
					<tr>
						<td>Thời gian bắt đầu</td>
						<td><input type="text" id="thoigianbatdau" /></td>
					</tr>
					<tr>
						<td>Thời gian kết thúc</td>
						<td><input type="text" id="thoigianketthuc" /></td>
					</tr>
					<tr>
						<td>Thời hạn bảo quản</td>
						<td><input type="text" id="thoihanbaoquan" /></td>
					</tr>
				</table>
			</form>
			
		</div>
		<div id="toolbar" class="ui-widget-header ui-corner-all">
			<button id="themhoso"><img src="/LuanVanTotNghiep/images/edit_add.png"/><span>Thêm</span></button>
			<button id="xoahoso"><img src="/LuanVanTotNghiep/images/edit_remove.png"/><span>Xóa</span></button>
			<button id="suahoso"><img src="/LuanVanTotNghiep/images/pencil.png"/><span>Sửa</span></button>
			<button id="themvanban"><img src="/LuanVanTotNghiep/images/pencil.png"/><span>Thêm văn bản vào hồ sơ</span></button>
		</div>
		<div id="table_nhapHoSo">
			<table class="ui-widget ui-widget-content">
				<tr class="ui-widget-header">
					<th>Mã hồ sơ</th>
					<th>Tiêu đề hồ sơ</th>
					<th>Thời gian bắt đầu</th>
					<th>Thời gian kết thúc</th>
					<th>Thời hạn bảo quản(Năm)</th>
				</tr>
				
				<c:forEach items="${hosoluutruList}" var="hosoluutru">
				    <tr id = "${hosoluutru.getSoHoSo()}">
				    	<td>${hosoluutru.getMaHoSo()}</td>
				    	<td>${hosoluutru.getTieuDeHoSo()}</td>
				    	<td>${hosoluutru.getThoiGianBatDau()}</td>
				    	<td>${hosoluutru.getThoiGianKetThuc()}</td>
				    	<td>${hosoluutru.getThoiGianBaoQuan()}</td>
				    </tr>
	   			</c:forEach>
	   		
			</table>
		</div>
		<div id="dialog_them" title="Thêm hồ sơ lưu trữ">
			<form action="" method="post">
				<table>
					<tr>
						<td>Mã hồ sơ</td>
						<td><input type="text" id="mahosothem" /></td>
					</tr>
					<tr>
						<td>Tiêu đề hồ sơ</td>
						<td><input type="text" id="tieudehosothem" /></td>
					</tr>
					<tr>
						<td>Thời gian bắt đầu</td>
						<td><input type="text" id="thoigianbatdauthem" /></td>
					</tr>
					<tr>
						<td>Thời gian kết thúc</td>
						<td><input type="text" id="thoigianketthucthem" /></td>
					</tr>
					<tr>
						<td>Thời hạn bảo quản</td>
						<td><input type="text" id="thoihanbaoquanthem" /></td>
					</tr>
				</table>
			</form>
		</div>
		
		<div id="dialog_themvanbanvaohoso" title="Thêm văn bản vào hồ sơ">
			<table class="ui-widget ui-widget-content">
				<tr class="ui-widget-header">
					<th>Trích yếu</th>
					<th>Ký hiệu</th>
					<th>Loại văn bản</th>
					<th>Trạng thái xử lý</th>
					<th>Chọn</th>
				</tr>
				<c:forEach var="vanban" items="${vanbanList}">
				<tr id="${vanban.maVanBan}">
					<td>${vanban.trichYeu}</td>
					<td>${vanban.soKyHieuVanBan}</td>
					<td>${vanban.loaivanban.tenLoaiVanBan}</td>
					<c:if test="${vanban.trangThaiXuLy == 1}">
						<td>Chưa xử lý</td>
					</c:if>
					<c:if test="${vanban.trangThaiXuLy == 2}">
						<td>Đang xử lý</td>
					</c:if>
					<c:if test="${vanban.trangThaiXuLy == 3}">
						<td>Hoàn thành</td>
					</c:if>
					<td><input type="checkbox" value="${vanban.maVanBan}" /></td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>