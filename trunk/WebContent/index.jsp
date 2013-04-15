<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head>
<meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/style1.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>

<style>
	body {
		background: #e1c192 url('/LuanVanTotNghiep/images/wood_pattern.jpg');
	}
	#remember{
		float:left;
	}
	#login{
		margin: 0 0 0 120px;
	}
	#title_dn{
		font-size: 14px;
	}
</style>

<script type="text/javascript">
$(function(){
    $(".showpassword").each(function(index,input) {
        var $input = $(input);
        $("<p class='opt'/>").append(
            $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function() {
                var change = $(this).is(":checked") ? "text" : "password";
                var rep = $("<input placeholder='Password' type='" + change + "' />")
                    .attr("id", $input.attr("id"))
                    .attr("name", $input.attr("name"))
                    .attr('class', $input.attr('class'))
                    .val($input.val())
                    .insertBefore($input);
                $input.remove();
                $input = rep;
             })
        ).append($("<label for='showPassword'/>").text("Show password")).insertAfter($input.parent());
    });

    $('#showPassword').click(function(){
		if($("#showPassword").is(":checked")) {
			$('.icon-lock').addClass('icon-unlock');
			$('.icon-unlock').removeClass('icon-lock');    
		} else {
			$('.icon-unlock').addClass('icon-lock');
			$('.icon-lock').removeClass('icon-unlock');
		}
    });
});
</script>
</head>
<body>
	
	<form class="form-2" name="login_form"
	                        action="<c:url value='j_spring_security_check'/>" method="POST">
		<h1><span class="log-in">Đăng nhập</span><br><span id="title_dn">Hệ thống quản lý công văn Chi cục thuế Thành Phố Cần Thơ.</span></h1>
		
		<p>
			<c:if test="${not empty param.login_error}">
	   		<font color="red"><c:out value="${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'Bad credentials', 'Tên đăng nhập/ Mật khẩu chưa chính xác')}"/>.</font>
	   		</c:if>
		</p>
		<p class="float">
			<label for="login"><i class="icon-user"></i>Tên đăng nhập</label>
			<input type='text' id='username' name='j_username' placeholder="Tên đăng nhập" required
	        value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
		</p>
		<p class="float">
			<label for="password"><i class="icon-lock"></i>Mật khẩu</label>
			<input type="password" name='j_password' class="showpassword" placeholder="Mật khẩu" required>
		</p>
		
		
		<p class="clearfix"> 
			<input type="checkbox" name="_spring_security_remember_me" id="remember">
			<label for="remember">Remember me</label>
			<input type="submit" name="submit" value="Đăng nhập" id="login">
		</p>
		
		
		
	</form>
	
		
</body>
</html>