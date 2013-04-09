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
<style type="text/css">

.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}

#toolbar_thembuocquytrinh{
padding:5px 5px 5px 5px;
}
div#thembuocthuocquytrinh table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#thembuocthuocquytrinh table td, div#thembuocthuocquytrinh table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#thembuocthuocquytrinh table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#thembuocthuocquytrinh table tr:nth-child(even) {
  background-color: #fff;
}

div#thembuocthuocquytrinh table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}

div#thembuocthuocquytrinh table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}


div#dialog_thembuocthuocquytrinh table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#dialog_thembuocthuocquytrinh table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
#dialog_thembuocthuocquytrinh table tr td input{
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
#dialog_thembuocthuocquytrinh table tr td img{
height:20px;
width:20px;
}
#dialog_thembuocthuocquytrinh table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}
div#dialog-getcongviec  table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
div#dialog-getcongviec  table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
#dialog-getcongviec table tr td input{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding: 3px 2px;
width: 60%;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}

#dialog-getcongviec table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}


#dialog-getcongviec table tr td textarea{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding:5px 5px;
width: 400px;
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
#dialog-getcongviec table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

#dialog_thembuocthuocquytrinh table tr td select{
color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 275px;
}
 

.ui-spinner{

height: 30px;
width:250px;
padding:0
}

  
</style>
<script>
	$(document).ready(function(){
		$( "#navbar" ).accordion({
		      collapsible: true,
		      heightStyle: "content",
		      active: 1
		    });
		var maquytrinhpub = null;
		$('tr').not(':first').bind('click',function(){
			maquytrinhpub = $(this).attr('id');
			$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
			
		});
		$( "#dialog_error" ).dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: true,
		      buttons: {
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		$( "#songay" ).spinner({
			 spin: function( event, ui ) {
		         if ( ui.value < 1 ) {
		          $( this ).spinner( "value", 1 );
		          return false;
		        }
			 },
			 
			
		});
		
		
		
		$( "#dialog-getcongviec" ).dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: true,
		      buttons: {
		    	  "Thêm công việc": function() {
		    		  var noidungcongviec = $('#noidungcongviec').val();
		    		  var tencongviec = $('#tencongviec').val();
						$.ajax({
							url:'/LuanVanTotNghiep/service/addCongViec/' + noidungcongviec + '/' + tencongviec,
							type: 'POST',
							contentType: 'text/html; charset=UTF-8',
							data: null,
							success: function(result){
								if(result){
									$.ajax({
										url: '/LuanVanTotNghiep/service/showAllCongViec',
										type: 'GET',
										dataType: "json",
										contentType: "application/json",
										
										success: function(data){
											console.log(data);
											var congviecList = data;
											var htmlPrepare = '<select id="macongviec">';
											for(var i = 0; i < congviecList.length; i++){
												htmlPrepare += '<option value=' + congviecList[i].maCongViec + '>';
												htmlPrepare += congviecList[i].tenCongViec + '</option>';
												
											}
											htmlPrepare += "</select>";
											$('#capnhatmacongviec').html(htmlPrepare);
										}
									
									});
									
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
		
			$("#dialog-themcongviec").click(function(){
				$("#dialog-getcongviec").dialog("open");
					 return false;
			});
			
			$( "#dialog_thembuocthuocquytrinh").dialog({
				  autoOpen: false,
			      resizable: true,
			      height:'auto',
			      width:'auto',
			      modal: true,
			      buttons: {
			    	  "Thêm bước xử lý": function() {
			    		var sothutu = $('#sothutu').val();
			  			var maquytrinh = $('#maquytrinhbuoc').val();
			  			var manguoidung = $('#manguoidungbuoc').val();
			  			var macongviec = $('#macongviec').val();
			  			var songay = $('#songay').val();
			  			$.ajax({
			  				url: '/LuanVanTotNghiep/service/addBuocQuyTrinh/' + maquytrinh + '/' + sothutu + '/' + songay + '/' + manguoidung + '/' + macongviec,
			  				type: 'POST',
			  				data: null,
			  				contentType: 'text/html; charset=UTF-8',
			  				success: function(result){
			  					if(result)
			  						location.reload(true);
			  				}
			  			});
			  			$( this ).dialog( "close" );
				        },
			        Cancel: function() {
			          $( this ).dialog( "close" );
			        }
			      }
			    });
			
			$("#addbuocxulythuocquytrinh").button().click(function(){
				if(maquytrinhpub == null){
					$("#dialog_error").dialog("open");
					
				}
				else{
				$('#maquytrinhbuoc').val(maquytrinhpub);
				$('#maquytrinhbuoc').attr("disabled", "disabled");
				$.ajax({
					url: '/LuanVanTotNghiep/service/getmaxbuoc/' + maquytrinhpub,
					type: 'GET',
					data: null,
					success: function(result) {
						$('#sothutu').val(result + 1);
					}
				});
				
				
				$("#dialog_thembuocthuocquytrinh").dialog("open");
				}
					 return false;
			});
			
	});
	
</script>
</head>
<body>
<div id="thembuocthuocquytrinh">
	<h3>Thêm phiếu giao việc</h3>
	<div id="toolbar_thembuocquytrinh" class="ui-widget-header ui-corner-all">
		<!-- <button id="addbuocthuocquytrinh">Thiết đặt bước trong quy trình</button>
		<button id="resetbuocthuocquytrinh">Xóa trường</button> -->
		<button id="addbuocxulythuocquytrinh" title="Thêm bước xử lý trong quy trình">Thêm bước xử lý</button>
	</div>
	<table class="ui-widget ui-widget-content">
		<tr class="ui-widget-header">
		    <th>Mã Quy Trình</th>
		    <th>Tên Quy Trình</th>
	   	</tr>
	   	<c:forEach var="quytrinh" items="${quytrinhList}">
	    	<tr id="${quytrinh.getMaQuyTrinh()}">
	    		<td>${quytrinh.getMaQuyTrinh()}</td>
	    		<td>${quytrinh.getMoTa()}</td>
	       </tr>
	    </c:forEach>
	</table>
	
</div>
<div id="dialog-getcongviec" title="Thêm công việc">
	<form action="" method="post">
		<table>
			<tr>
				<td>Tên công việc</td>
				<td><input type= "text" id="tencongviec"/></td>
			</tr>
			<tr>
				<td>Nội dung công việc</td>
				<td><textarea rows="5" cols="40" id="noidungcongviec"></textarea></td>
			</tr>
			
		</table>
	</form>
</div>

<div id="dialog_thembuocthuocquytrinh" title="Thêm bước trong quy trình">
	<form action="" method="post">
		<table>
			<tr>
				<td>Bước</td>
				<td><input type="text" id="sothutu" readonly></td>
			</tr>
			<tr>
				<td>Mã quy trình</td>
				<td>
					<select id="maquytrinhbuoc">
  						<c:forEach var="quytrinh" items="${quytrinhList}">
	    						<option value='<c:out value="${quytrinh.getMaQuyTrinh()}"/>'><c:out value="${quytrinh.getMoTa()}"/></option>
	    				</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Mã người dùng</td>
				<td>
					<select id="manguoidungbuoc">
  						<c:forEach var="nguoidung" items="${nguoidungList}">
	    						<option value='<c:out value="${nguoidung.getMaNguoiDung()}"/>'><c:out value="${nguoidung.getTenNguoiDung()}"/></option>
	    				</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Nội dung công việc</td>
				<td  id="capnhatmacongviec">
					<select id="macongviec">
	  						<c:forEach var="congviec" items="${congviecList}">
		    						<option value='<c:out value="${congviec.getMaCongViec()}"/>'><c:out value="${congviec.getTenCongViec()}"/></option>
		    				</c:forEach>
					</select>
				<!-- <textarea rows="5" cols="40" id="noidungcongviec"></textarea> -->
				<img src="/LuanVanTotNghiep/images/table_row_insert.png" id="dialog-themcongviec"/>
				</td>
			</tr>
			
			<tr>
				<td>Số ngày xử lý</td>
				<td><input type="text" id="songay"/></td>
			</tr>
			
		</table>
	</form>
</div>
<div id="dialog_error" title="Bạn chưa chọn văn bản cần xử lý">
<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Bạn chưa chọn quy trình cần thêm bước xử lý. Để chọn quy trình,
 bạn hãy nhấp chuột vào quy trình đó.</p>
</div>
</body>
</html>