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
</head>
<style>
.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}
	div#guiTinNhanNoiBo h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
	
}
#content_message{
margin: 1em 0; border-collapse: collapse; width: 100%; 
}

#content_message td{
border-bottom: 1px solid #eee;
padding: .6em 1px;
text-align: left;
}

div#guiTinNhanNoiBo table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#guiTinNhanNoiBo table td, div#guiTinNhanNoiBo table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#guiTinNhanNoiBo table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#guiTinNhanNoiBo table tr:nth-child(even) {
  background-color: #fff;
}

div#guiTinNhanNoiBo table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}

div#guiTinNhanNoiBo table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}

div#dialog_guitinnhannoibo textarea{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding:5px 5px;
width: 500px;
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
div#dialog_guitinnhannoibo textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('tr').bind('click',function(){
			$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
			$('#content_message').empty();
			$('#manguoidung').val($(this).attr('id'));
			$( "#dialog_guitinnhannoibo").dialog('open');
			
			return false;
		});
		
		
		$( "#dialog_guitinnhannoibo").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:350,
		      width:560,
		      modal: false,
		      buttons: {
		    	  
		       	'Gửi' : function(){
		       		var manguoidung = $('#manguoidung').val();
		       		var noidung = $('#input_message').val();
		       		$.ajax({
		       			url: '/LuanVanTotNghiep/service/addMessage/' + manguoidung + '/' + noidung,
		       			type: 'POST',
		       			contentType: 'text/html; charset=UTF-8',
						data: null,
						success: function(result){
							if(result){
								var nameNguoiDung = '${nameNguoiDung}';
					       		
					       		$('#content_message').prepend(
					            	'<tr><td style="color: red"><b>'+nameNguoiDung+'</b></td><td style="word-wrap: break-word;-ms-word-wrap: break-word;max-width: 440px;">'+noidung +'</td></tr>'
					          	);
								
							}
							
						}
		       			
		       		});
		       		
		       		
		       		
		       		
		       		
		       		$('#input_message').val('');
		       	},     
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      },
		      
		    });
	});
	

</script>
<body>

	<div id="guiTinNhanNoiBo">
		<h3>Gửi Tin Nhắn Nội Bộ</h3>
		<table class="ui-widget ui-widget-content">
			<tr class="ui-widget-header">
			    <th>Người dùng</th>
			</tr>
			<c:forEach items="${nguoidungList}" var="nguoidung">
			    <tr id = "${nguoidung.maNguoiDung}">
			    	<td>${nguoidung.getTenNguoiDung()}</td>
			   </tr>
			   
			</c:forEach>
			
		</table>
		
		<div id="dialog_guitinnhannoibo" title="Gửi tin nhắn">
		<input type="hidden" id="manguoidung" value="" />
		<textarea id="input_message" placeholder="Nhập nội dung cần gửi"></textarea>
			<table id="content_message">
			
			
			</table>
			
		</div>		
	</div>
	
</body>

</html>