<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chào mừng quản trị</title>
<style>
	div#welcomeAdministrator h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px 10px 30px;
	margin: 0px auto 0px;
	
}
#welcomeAdministrator{
	background-color: #f7f7f7;
	overflow: hidden;
	
}	
.body_inner{
line-height: 40px; 

}



</style>
<script type="text/javascript">
	$(document).ready(function(){
		$( "#welcomeAdministrator" ).accordion({
		   collapsible: true,
		    heightStyle: "content"
		  });
		
	});

</script>
</head>
<body>
	<div id="welcomeAdministrator">
		<h3>Chào mừng quản trị</h3>
		<div class="body_inner">
		<b>Xin chào quản trị hệ thống. </b><br>
		<hr>
		Tại đây bạn có thể sử dụng các chức năng thuộc quyền quản trị như <i>Quản trị người dùng</i>,
		<i>Quản trị danh mục</i>, Lập báo cáo thống kê <i>Văn bản đến</i>, <i>Văn bản đi</i>, <i>Danh mục hồ sơ</i>.<br>
		
		Mọi thắc mắc hay ý kiến đóng góp xin vui lòng liên hệ với tác giả. Thông tin liên lạc xem ở mục Thông tin
		hoặc dùng liên kết Liên hệ.
		<br>Xin chân thành cám ơn.
		</div>
		<h3>Người dùng ADMIN có quyền</h3>
		<div class="body_inner">
		Tincidunt placerat tincidunt massa, integer. Nunc purus adipiscing integer aliquam augue urna, ac sit et adipiscing a porttitor. Facilisis turpis tristique, tincidunt placerat sociis, lacus odio? Non nec cras cum, mattis dis a placerat placerat non? Urna! Dolor! Tristique? Lorem! Et ac risus proin dignissim in in velit, montes. Proin ac! Lacus quis risus! Risus odio auctor! Lectus turpis dis, tristique nunc dictumst, adipiscing, tristique, sociis nisi ultricies pellentesque, pulvinar, nec sed, nisi a etiam duis scelerisque ultrices. Mauris elit tortor quis, quis magna? Velit mattis pellentesque turpis arcu habitasse, scelerisque mauris amet etiam porta integer pulvinar auctor augue purus.
		</div>
	</div>
	
</body>
</html>