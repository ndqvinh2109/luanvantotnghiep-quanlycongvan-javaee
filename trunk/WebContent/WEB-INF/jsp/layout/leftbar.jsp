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
#nav_dialog_message{
margin: 1em 0; border-collapse: collapse; width: 100%; 
}

#nav_dialog_message td{
border-bottom: 1px solid #eee;
padding: .6em 1px;
text-align: left;
}
</style>
<script type="text/javascript">
	$(function(){
		$( "#nav_dialog_message").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: true,
		      buttons: {
		       		        
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      },
		      
		    });
		$('#evtMessage').click(function(){
			$( "#nav_dialog_message").dialog('open');
			
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
	
	<div id="nav_dialog_message" title="Tin nhắn nội bộ">
		<table>
			<c:forEach items="${MessageListReadYet}" var="message">
	    <tr>
	    	<td style="color:red"><b>${message.getTacGia()}</b></td>
	    	<td>${message.getNoiDung()}</td>
	    </tr>
	   
	</c:forEach>
		</table>
	</div>
	
</body>
</html>