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
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/dropzone.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<script src="/LuanVanTotNghiep/js/dropzone.js"></script>
<title>Insert title here</title>
<style type="text/css">
div#formThemFileDinhKem form{
margin: 5px 140px 0 0;
}

div#formThemFileDinhKem table{
border-collapse: collapse;
}
div#formThemFileDinhKem table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
}

div#formThemFileDinhKem table tr td input{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding: 3px 2px;
width: 80%;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}

div#formThemFileDinhKemtable tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

div#formThemFileDinhKem table tr td textarea{
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
div#formThemFileDinhKem table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}
div#quanlyfiledinhkem h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
}
#quanlyfiledinhkem{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	}
#formThemFileDinhKem{
margin: 10px 0 10px 150px;
}

#formThemFileDinhKem form input.submitpq {
	cursor: pointer;
	width: 80px;
	height: 29px;
	line-height: 25px;
	font-size: 12px;
	font-weight: bold;
	color: #fff;
	background: #3c85fe;
	border: 1px solid #3079ED;
	margin: 5px 0px 0px 180px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
}
div#danhsachfileDinhKem{
padding: 0 0 10px 0;
}
div#danhsachfileDinhKem table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 div#danhsachfileDinhKem table td, div#danhsachfileDinhKem table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 div#danhsachfileDinhKem table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#danhsachfileDinhKem table tr:nth-child(even) {
  background-color: #f7f7f7;
}

div#danhsachfileDinhKem table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
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
div#danhsachfileDinhKem table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}

</style>
<script type="text/javascript">
	$(document).ready(function(){
		var mavanban = '${mavanbanDinhKem}';
		$('#mavanbandinhkem').val(mavanban);
		var madinhkem = null;
		$('#danhsachfileDinhKem tr').not(':first').bind('click',function(){
			madinhkem = $(this).attr('id');
			$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
		});    
			
		
		$('#Xemtt').button().click(function(){
			window.location = '${pageContext.request.contextPath}/service/xemtructuyendk/' + madinhkem ;
			return false;
		});
		$('#Xoatt').button().click(function(){
			if(confirm('Bạn có chắc xóa Tập tin này không?')){		
			$.ajax({
				url: '/LuanVanTotNghiep/service/xoaDinhKem/' + madinhkem,
				type: 'GET',
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
		$('#Downloadtt').button().click(function(){
			window.location = '${pageContext.request.contextPath}/service/downloaddk/' + madinhkem ;
			return false;
		});
		var mavanban2 = '${mavanbanDinhKem2}';
		if(mavanban2 != ''){
			window.location = '${pageContext.request.contextPath}/service/showFileDinhKem/' + mavanban2 + ".action";
		}
		$('#luulai').button().click(function(){
			location.reload(true);
			return false;
		});
		});
</script>
</head>
<body>
<%-- <a href="${pageContext.request.contextPath}/service/showvanbanden/1">Trở về</a> --%>

<div id="quanlyfiledinhkem">
	<h3>Danh sách tập tin đính kèm</h3>
	<div id="formThemFileDinhKem">
		<form:form method="post" class="dropzone" action="${pageContext.request.contextPath}/service/save/${mavanbanDinhKem}" commandName="filedinhkem" enctype="multipart/form-data">
		   <input type="hidden" name="mavanban" id="mavanbandinhkem" />
		  
		   <%--  <table>
		    	<tr>
			        <td><form:label path="tenFile">Tên tập tin</form:label></td>
			        <td><form:input path="tenFile" /></td> 
			    </tr>
			    <tr>
			        <td><form:label path="moTa">Mô tả tập tin</form:label></td>
			        <td><form:textarea path="moTa" /></td>
			    </tr>
			    <tr>
			        <td><form:label path="noiDung">Upload tâp tin</form:label></td>
			        <td><input type="file" name="file" id="file"></input></td>
			    </tr>
			    
			  </table>   --%>
			
			
		</form:form>
	
	</div>
	<div id="toolbar" class="ui-widget-header ui-corner-all">
			<button id="Xemtt"><img src="/LuanVanTotNghiep/images/add1.png"/><span>Xem</span></button>
			<button id="Xoatt"><img src="/LuanVanTotNghiep/images/button_cancel.png"/><span>Xóa</span></button>
			<button id="Downloadtt"><img src="/LuanVanTotNghiep/images/1366355835_Download.png"/><span>Tải về</span></button>
			<button id="luulai"><img src="/LuanVanTotNghiep/images/1366617912_save_accept.png"/><span>Lưu lại</span></button>
		</div>
	<div id="danhsachfileDinhKem">
		<table class="ui-widget ui-widget-content">
			<tr class="ui-widget-header">
				<th>Tên tập tin</th>
				<th>Mô tả tập tin</th>
			</tr>
			
			<c:forEach items="${showFileDinhKemList}" var="showfiledinhkem">
				<tr id="${showfiledinhkem.maFile}">
					<td>${showfiledinhkem.tenFile}</td>
					<td>${showfiledinhkem.moTa}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>

</div>

</body>
</html>