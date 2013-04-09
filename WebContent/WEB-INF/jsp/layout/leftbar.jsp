<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<style>

.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}
#nav_dialog_message_leftbar table{
margin: 1em 0; border-collapse: collapse; width: 100%; 
}

#nav_dialog_message_leftbar td{
border-bottom: 1px solid #eee;
padding: 20px 1px;
text-align: left;
}

#content_message_leftbar{
margin: 1em 0; border-collapse: collapse; width: 100%; 
}

#content_message_leftbar td{
border-bottom: 1px solid #eee;
padding: 20px 1px;
text-align: left;
}
#nav_dialog_message_leftbar table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}

#dialog_guitinnhannoiboleftbar textarea{
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
#dialog_guitinnhannoiboleftbar textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

</style>
<script type="text/javascript">
	$(function(){
		
		
		$('#nav_dialog_message_leftbar tr').bind('click',function(){
			$('#content_message_leftbar').empty();
			
			$('#userName_leftbar').val($(this).attr('id'));
			$( "#dialog_guitinnhannoiboleftbar").dialog('open');
			$('#input_message_leftbar').val('');
			return false;
		});
		
		
		$( "#dialog_guitinnhannoiboleftbar").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:350,
		      width:560,
		      modal: false,
		      show: {
		          effect: "clip",
		          duration: 300
		        },
		      hide: {
			          effect: "clip",
			          duration: 300
			        },
		      buttons: {
		    	  
		       	'Gửi' : function(){
		       		var userName = $('#userName_leftbar').val();
		       		var noidung = $('#input_message_leftbar').val();
		       		$.ajax({
		       			url: '/LuanVanTotNghiep/service/addMessageReply/' + userName + '/' + noidung,
		       			type: 'POST',
		       			contentType: 'text/html; charset=UTF-8',
						data: null,
						success: function(result){
							if(result){
								var nameNguoiDung = '${nameNguoiDung}';
					       		
					       		$('#content_message_leftbar').prepend(
					            	'<tr><td style="color: red"><b>'+nameNguoiDung+'</b></td><td style="word-wrap: break-word;-ms-word-wrap: break-word;max-width: 440px;">'+noidung +'</td></tr>'
					          	);
								
							}
							
						}
		       			
		       		});
		       		
		       		
		       		
		       		
		       		
		       		 
		       		$('#input_message_leftbar').val('');
		       	},     
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      },
		      position: {
	                my: "left+110 bottom+300",
	                of: window
	            }
		      
		    });
		
		
		
		
		
		
		$( "#nav_dialog_message_leftbar").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: false,
		      show: {
		          effect: "slide",
		          duration: 300
		        },
		      hide: {
			          effect: "slide",
			          duration: 300
			        },
		      buttons: {
		       		        
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      },
		      position: {
	                my: "right-150 bottom+150",
	                of: window
	            }
		      
		    });
		$('#evtMessage').click(function(){
			var htmlPrepare = '<input type="hidden" id="userName_leftbar" value="" /><textarea id="input_message_leftbar" placeholder="Nhập nội dung cần gửi"></textarea><table id="content_message_leftbar"></table>';
			$('#dialog_guitinnhannoiboleftbar').html(htmlPrepare);
			$( "#nav_dialog_message_leftbar").dialog('open');
			
			return false;
		});
		
		});
	
</script>
</head>
<body>
	<ul id="navigation">
		<li class="login"><a href="<c:url value="/j_spring_security_logout" />" title="Đăng xuất" id="login"></a></li>
		<li class="showmenu"><a href="#" title="Hiện/Ẩn thanh menu"></a></li>
		<li class="admin"><a href="${pageContext.request.contextPath}/service/welcomeAdmin" title="Trang quản trị"></a></li>
		<li class="showMessage"><a id="evtMessage" href="" title="Tin nhắn"></a></li>
	</ul>
	
	<div id="nav_dialog_message_leftbar" title="Tin nhắn nội bộ">
		<table>
			<c:forEach items="${MessageListReadYet}" var="message">
	    <tr id="${message.getTacGia()}" >
	    	<td style="color:red"><b>${message.getTenTacGia()}</b></td>
	    	<td>${message.getNoiDung()}</td>
	    </tr>
	   
	</c:forEach>
		</table>
		
		
		<div id="dialog_guitinnhannoiboleftbar" title="Gửi tin nhắn">
		
			
		</div>		
	</div>
	
</body>
</html>