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
<script>
	$(document).ready(function(){
		var buoc = null;
		var maquytrinh = null;
		var mavanban = null;
		$('tr').bind('click',function(){
			buoc = $(this).attr('id');
			maquytrinh = $(this).attr('class');
			mavanban = $(this).find("td").eq(4).html();
			/* alert($(this).attr('id'));
			alert($(this).attr('class')); */
			$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
		});
		
		$( "#dialog_capnhatxulypheduyet").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: true,
		      buttons: {
		        "Lưu": function(){
		        	var noidungxuly = $('#noidungxuly').val();
		        	var mavanbandia = $('#mvbtest').val();
		        	var buocdia = $('#bxltest').val();
		        	var maquytrinhdia = $('#qttest').val();
		        	$.ajax({
		        		url: '/LuanVanTotNghiep/service/capnhatnoidungxuly/' + mavanbandia + '/' + buocdia + '/' + noidungxuly + '/' + maquytrinhdia,
		        		type: 'POST',
		        		contentType: 'text/html; charset=UTF-8',
						data: null,
						success: function(data){
							if(data != 0){
								
								alert("Thanh cong roi");
							}
							
						}
		        	});
		        	 
		        	 $( this ).dialog( "close" );
		        	
		        },
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		
			$('#dialog-capnhatnoidung').button().click(function(){
				
				$('#mvbtest').attr("disabled", "disabled");
				$('#qttest').attr("disabled", "disabled");
				$.ajax({
					url: '/LuanVanTotNghiep/service/showcapnhatxuly/' + mavanban + '/' + buoc + '/' + maquytrinh,
					type: 'GET',
					dataType: "json",
					contentType: "application/json",
					success:function(data){
						var tr = data;
						console.log(tr);
						$('#bxltest').val(tr.buocxuly);
						$('#mvbtest').val(tr.mavanban);
						$('#qttest').val(tr.maquytrinh);
						var ttxl= tr.trangthaixuly;
						if(ttxl == 2){
							
							$('#ttxltest').val('Đang xử lý');
						}
						else{
							
							$('#ttxltest').val('Hoàn thành');
						}
						
					}
				});
				
				$("#dialog_capnhatxulypheduyet").dialog("open");
				return false;
			});
			
		/* $('#capnhatnoidungxuly').click(function(){
			$.ajax({
				url: '',
				method: 'POST',
				contentType: 'text/html; charset=UTF-8',
				data: null,
			});
			
			return false;
		}); */
		
	});
</script>
<style type="text/css">

.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}
div#xulypheduyetvanban table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#xulypheduyetvanban table td, div#xulypheduyetvanban table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#xulypheduyetvanban table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#xulypheduyetvanban table tr:nth-child(even) {
  background-color: #fff;
}

div#xulypheduyetvanban table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}

div#xulypheduyetvanban table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}

#toolbar_xulypheduyet{
padding:5px 5px 5px 5px;
}

#dialog_capnhatxulypheduyet table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
#dialog_capnhatxulypheduyet table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
#dialog_capnhatxulypheduyet table tr td input{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding: 3px 2px;
width: 70%;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}

#dialog_capnhatxulypheduyet table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#dialog_capnhatxulypheduyet table tr td textarea{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding:5px 5px;
width: 300px;
height:100px;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}
#dialog_capnhatxulypheduyet table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

#dialog_capnhatxulypheduyet table tr td select{
color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 275px;
}

/* #dialog_capnhatxulypheduyet */

</style>
</head>
<body>
	<div id="xulypheduyetvanban">
		<h3>Văn bản đang chờ xử lý</h3>
		
		<div id="toolbar_xulypheduyet" class="ui-widget-header ui-corner-all">
			<button id="dialog-capnhatnoidung">Xử lý</button>
		</div>
		<table class="ui-widget ui-widget-content">
				<tr class="ui-widget-header">
					<th>Ngày Đến</th>
				    <th>Số Đến</th>
				    <th>Ngày Ban Hành</th>
				    <th>Trích Yếu Nội Dung</th>
				    <th>Mã Văn Bản</th>
	   		    </tr>
		<c:forEach var="buocxuly" items="${buocxulyList}">
			<c:if test="${buocxuly.valueChuyen == true && buocxuly.valueXuLy == false}">
				<tr id="${buocxuly.buoc.pkQuyTrinh.soThuTu}" class="${buocxuly.buoc.pkQuyTrinh.maQuyTrinh}">
					<td>${buocxuly.vanban.ngayDen}</td>
					<td>${buocxuly.vanban.soDen}</td>
					<td>${buocxuly.vanban.ngayBanHanh}</td>
					<td>${buocxuly.vanban.trichYeu}</td>
					<td>${buocxuly.vanban.maVanBan}</td>
				</tr>
			</c:if>
		</c:forEach>
		
		</table>
		
		
		
		<div id="dialog_capnhatxulypheduyet" title="Xử lý văn bản">
		<form action="" method="post">
		
		<table border="1">
		<tr>
			<td>Bước xử lý</td>
			<td><input type="text" id="bxltest" readonly/></td>
		</tr>
		<tr>
			<td>Quy trình</td>
			<td>
				<select id="qttest">
	  				<c:forEach var="quytrinh" items="${quytrinhListAll}">
		    				<option value='<c:out value="${quytrinh.maQuyTrinh}"/>'><c:out value="${quytrinh.moTa}"/></option>
		    		</c:forEach>
				</select>
			
			<!-- <input type="text" id="qttest" /> -->
			
			</td>
		</tr>
		<tr>
			<td>Mã văn bản</td>
			<td>
			
				<select id="mvbtest">
	  				<c:forEach var="vanban" items="${vanbanListAll}">
		    				<option value='<c:out value="${vanban.maVanBan}"/>'><c:out value="${vanban.soKyHieuVanBan}"/></option>
		    		</c:forEach>
				</select>
				
		
			
			</td>
		</tr>
		
		<tr>
		<td>Trạng thái xử lý:</td>
		<td><input type="text" id="ttxltest" readonly/></td>
		</tr>
		
		<tr>
		<td>Nội dung xử lý:</td>
		<td><textarea rows="5" cols = "40" id="noidungxuly"></textarea></td>
		</tr>
		</table>
		
		</form>
		</div>
	</div>
	
</body>
</html>