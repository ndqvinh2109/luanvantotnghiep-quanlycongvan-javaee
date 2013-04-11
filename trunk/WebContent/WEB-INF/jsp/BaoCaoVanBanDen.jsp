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
<style type="text/css">
#baocaovanbanden{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	
}	
div#baocaovanbanden h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
	
}
#table_content{
margin: 15px 0 15px 230px;
}

#table_content table tr td input{
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

#table_content table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#table_content table tr td select{

color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 200px;
}

div#table_content table{
border-collapse: collapse;
 }
 div#table_content table td{
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
	
	
</style>
<script>
	
	$(document).ready(function(){
		$( "#navbar").accordion({
		    collapsible: true,
		    heightStyle: "content",
		    active: 5
		  });
		
		
		 $( "#report_content" ).accordion({
		     collapsible: true,
		      heightStyle: "content"
		    });
		
		 $("#tungay").datepicker({
			  showAnim: 'clip',
		      dateFormat: 'yy-mm-dd'
		});
		
		$("#denngay").datepicker({
			 showAnim: 'clip',
		      dateFormat: 'yy-mm-dd'
		}); 
	$('#taotrangin').button().click(function(){
			/* var tungay = $('#tungay').val();
			var denngay = $('#denngay').val();
			var danhmuc = $('#danhmuc').val();
			$.ajax({
				url: '/LuanVanTotNghiep/service/PdfVanBanDen/' + danhmuc + '/' + tungay + '/' + denngay,
				type: 'POST',
				data: null
			});
		return false; */
	});	
	
	$('#excel').button().click(function(){
		
		
	});	
	$('#pdf').button().click(function(){
	
	
	});	
	
	

	
	});
</script>
</head>
<body>
	<div id="baocaovanbanden">
		<h3>Thống kê báo cáo văn bản đến</h3>
		<div id="table_content">
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
					<td>Theo danh mục:</td>
					<td>
						<select id="danhmuc" class="selmenu">
	    					<option value='1'>Loại văn bản</option>
	    					<option value='2'>Cấp độ bảo mật</option>
	    					<option value='3'>Cấp độ khẩn</option>
	    					<option value='4'>Lĩnh vực</option>
	    				</select>
					</td>
				</tr>
				
				
			</table>
		</div>
		<div id="toolbar" class="ui-widget-header ui-corner-all">
			<button id="taotrangin"><img src="/LuanVanTotNghiep/images/edit_add.png"/><span>Tạo trang in</span></button>
			<button id="excel"><img src="/LuanVanTotNghiep/images/edit_remove.png"/><span>Xuất Excel</span></button>
			<button id="pdf"><img src="/LuanVanTotNghiep/images/pencil.png"/><span>Xuất PDF</span></button>
			
		</div>
		<div id="report_content">
			
		
		</div>
	</div>
</body>
</html>