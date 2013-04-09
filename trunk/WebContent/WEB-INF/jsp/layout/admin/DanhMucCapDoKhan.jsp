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
div#danhMucCapDoKhan h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px 10px 30px;
	margin: 0px auto 0px;
	
}

#danhMucCapDoKhan{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	
}	

#body_inner{
margin: 10px 0 10px 250px;
}


div#table_inner table{
 margin: 0; border-collapse: collapse; width: 100%; 
 }
 div#table_inner table td, div#table_inner table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#body_inner table{
 margin: 0; border-collapse: collapse; width: 70%; 
 }
 div#body_inner table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
  div#dialog_them table{
 margin: 1em; border-collapse: collapse; width: 95%; 
 }
 div#dialog_them table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#dialog_sua table{
 margin: 1em; border-collapse: collapse; width: 95%; 
 }
 div#dialog_sua table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#table_inner table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#table_inner table tr:nth-child(even) {
  background-color: #f7f7f7;
}

div#table_inner table tr:hover{
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

</style>
<script>

$(document).ready(function(){
	
	var madokhan = null;
	$('#table_inner tr').not(':first').bind('click',function(){
		madokhan = $(this).attr('id');
		$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
		var tendokhan = $(this).find("td").eq(0).html();
		var giatridokhan = $(this).find("td").eq(1).html();
		$('#tendokhan').val(tendokhan);
		$('#giatricapdo').val(giatridokhan);
	});    
	
	
	
	/* var getDoKhanList = function(){
		$.ajax({
			url: '/LuanVanTotNghiep/service/getCapDoKhanListJson',
			type:'GET',
			dataType: "json",
    		contentType: "application/json",
    		success: function(data){
    			console.log(data);
    			var htmlPrepare = '<table class="ui-widget ui-widget-content">';
    			htmlPrepare += '<tr class="ui-widget-header"><th>Tên Độ Khẩn</th><th>Giá Trị Cấp Độ</th></tr>';
    			for(var i = 0 ; i < data.length ; i++){
    				htmlPrepare += '<tr ' + 'id="' +data[i].maDoKhan+'"><td>';
    				htmlPrepare += data[i].tenDoKhan + '</td><td>';
    				htmlPrepare += data[i].giaTriCapDo + '</td></tr>';
    				
    			}
    			htmlPrepare += '</table>';
    			$('#table_inner').html(htmlPrepare);
    		}
			
		});
		
	};
	getDoKhanList(); */
	
	
	
	
	
	$( "#dialog_them").dialog({
		  autoOpen: false,
	      resizable: true,
	      height:'auto',
	      width:'auto',
	      modal: true,
	      buttons: {
	       	'Lưu' : function(){
	       	  		var tendokhanthem = $('#tendokhanthem').val();
		       		var giatricapdothem = $('#giatricapdothem').val();
		       		$.ajax({
		       			url: '/LuanVanTotNghiep/service/themCapDoKhan/' + tendokhanthem + '/' + giatricapdothem,
		       			type: 'POST',
		       			contentType: 'text/html; charset=UTF-8',
						data: null,
						success: function(result){
							if(result){
								alert("Thêm thành công");
								location.reload(true);
								/* getDoKhanList(); */
								
							}
							
						}
		       		});
		       		
		   	},
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      }
	      
	    });
	
	
	
	
	
	/* $( "#dialog_sua").dialog({
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
	      
	    }); */
	
	$('#themdokhan').button().click(function(){
		
		$( "#dialog_them").dialog('open');
		return false;
	});
	    
	$('#xoadokhan').button().click(function(){
		if(confirm('Bạn có chắc xóa Cấp Độ Khẩn này không?')){
		$.ajax({
			url: '/LuanVanTotNghiep/service/xoaCapDoKhan/' + madokhan,
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
	
	$('#suadokhan').button().click(function(){
		var tendokhan = $('#tendokhan').val();
   		var giatricapdo = $('#giatricapdo').val();
		$.ajax({
			url: '/LuanVanTotNghiep/service/suaCapDoKhan/' + madokhan + '/' + tendokhan + '/' + giatricapdo,
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
	
	
});
</script>
</head>
<body>
	<div id="danhMucCapDoKhan">
		<h3>Cập nhật thông tin danh mục Cấp độ khẩn</h3>
		<div id="body_inner">
			<table>
				<tr>
					<td>Tên độ khẩn</td>
					<td><input type="text" id="tendokhan" /></td>
				</tr>
				<tr>
					<td>Giá trị cấp độ</td>
					<td><input type="text" id="giatricapdo" /></td>
				</tr>
				
			</table>
		</div>
		
		<div id="toolbar" class="ui-widget-header ui-corner-all">
			<button id="themdokhan"><img src="/LuanVanTotNghiep/images/edit_add.png"/><span>Thêm</span></button>
			<button id="xoadokhan"><img src="/LuanVanTotNghiep/images/edit_remove.png"/><span>Xóa</span></button>
			<button id="suadokhan"><img src="/LuanVanTotNghiep/images/pencil.png"/><span>Sửa</span></button>
		</div>
		<div id="table_inner">
		<table class="ui-widget ui-widget-content">
			<tr class="ui-widget-header">
				<th>Tên độ khẩn</th>
				<th>Giá trị cấp độ</th>
			</tr>
			<c:forEach items="${capDoKhanList}" var="capdokhan">
			    <tr id = "${capdokhan.maDoKhan}">
			    	<td>${capdokhan.getTenDoKhan()}</td>
			    	<td>${capdokhan.getGiaTriCapDo()}</td>
			    </tr>
	   		</c:forEach>
		</table>
		</div>
	
	<div id="dialog_them" title="Thêm Độ Khẩn">
	<form action="" method="POST">
		<table>
				<tr>
					<td>Tên độ khẩn</td>
					<td><input type="text" id="tendokhanthem" /></td>
				</tr>
				<tr>
					<td>Giá trị cấp độ</td>
					<td><input type="text" id="giatricapdothem" /></td>
				</tr>
				
		</table>
	</form>
	</div>
	
	<%-- <div id="dialog_sua" title="Sửa Độ Khẩn">
	<form action="" method="POST">
		<table>
				<tr>
					<td>Tên độ khẩn</td>
					<td><input type="text" id="tendokhansua" /></td>
				</tr>
				<tr>
					<td>Giá trị cấp độ</td>
					<td><input type="text" id="giatricapdosua" /></td>
				</tr>
				
		</table>
	</form>
	</div> --%>
	
	</div>
</body>
</html>