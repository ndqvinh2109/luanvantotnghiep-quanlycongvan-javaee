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
<style type="text/css">
.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}

div#timKiemVanBanDen h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
	
}
#toolbar{
padding:5px 5px 5px 5px;
}


div#dialog_timkiemnangcao table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#dialog_timkiemnangcao table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 #dialog_timkiemnangcao table tr td input{
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

#dialog_timkiemnangcao table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}
#dialog_timkiemnangcao table tr td select{

color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 200px;
}


div#showketqua table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 
 div#showketqua table td, div#showketqua table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
div#showketqua table tr:nth-child(odd) {
  background-color: #e8edff;
}

div#showketqua table tr:nth-child(even) {
  background-color: #fff;
}

div#showketqua table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}

div#showketqua table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}

div#dialog_timkiemcoban table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#dialog_timkiemcoban table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
</style>

<script>
	$(document).ready(function(){
		$( "#navbar" ).accordion({
		      collapsible: true,
		      heightStyle: "content",
		      active: 1
		    });
		$("#ngayden").datepicker({
			 showAnim: 'drop',
		     dateFormat: 'yy-mm-dd'
		});
		$( "#dialog_timkiemnangcao").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: false,
		      buttons: {
		    	  'Tìm kiếm':function(){
			        	var trichyeu = $('#trichyeu').val();
			        	var ngayden = $('#ngayden').val();
			        	var soden = $('#soden').val();
			        	var sokyhieu = $('#sokyhieu').val();
			        	var coquanbanhanh = $('#coquanbanhanh').val();
			        	var loaivanban = $('#loaivanban').val();
			        	var linhvuc = $('#linhvuc').val();
			        	var sohoso = $('#sohoso').val();
			        	
			        	$.ajax({
			        		url: '/LuanVanTotNghiep/service/timKiemNangCao/' + trichyeu + '/' +
			        		ngayden + '/' + soden + '/' + sokyhieu + '/' + coquanbanhanh + '/' + loaivanban + '/' +
			        		linhvuc + '/' + sohoso,
			        		type: 'GET',
			        		dataType: "json",
			        		contentType: "application/json",
			        		success: function(data){
			        			console.log(data);
			        			if(data.vanbandenList.length == 0){
			        				alert("Không tìm thấy dữ liệu");
			        			}
			        			else{
			        			var htmlPrepare = '<table class="ui-widget ui-widget-content">';
			        			htmlPrepare += '<tr class="ui-widget-header"><th>';
			        			htmlPrepare += 'Ngày Đến</th><th>';
			        			htmlPrepare += 'Số Đến</th><th>';
			        			htmlPrepare += 'Số Hiệu Văn Bản</th><th>';
			        			htmlPrepare += 'Ngày Ban Hành</th><th>';
			        			htmlPrepare += 'Trích Yếu Nội Dung</th></tr>';
			        			
			        			for(var i = 0 ; i< data.vanbandenList.length;i++){
			        				htmlPrepare += '<tr><td>';
			        				htmlPrepare += data.vanbandenList[i].ngayDen + '</td><td>';
			        				htmlPrepare += data.vanbandenList[i].soDen + '</td><td>';
			        				htmlPrepare += data.vanbandenList[i].soKyHieuVanBan + '</td><td>';
			        				htmlPrepare += data.vanbandenList[i].ngayBanHanh + '</td><td>';
			        				htmlPrepare += data.vanbandenList[i].trichYeu + '</td></tr>';
			        			} 
			        			
			        			htmlPrepare += '</table>';
			        			
			        			$('#showketqua').html(htmlPrepare);
			        			}
			        		}
			        			
			        	});
			        	
			        },
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		$('#tukhoa').keyup(function(){
			var textInput = $('#tukhoa').val();
			if(textInput != ''){
			$.ajax({
        		url: '/LuanVanTotNghiep/service/timKiemCoBan/' + textInput,
        		type: 'GET',
        		dataType: "json",
        		contentType: "application/json",
        		success: function(data){
        			console.log(data);
        			
        			
        			var htmlPrepare = '<table class="ui-widget ui-widget-content">';
        			htmlPrepare += '<tr class="ui-widget-header"><th>';
        			htmlPrepare += 'Ngày Đến</th><th>';
        			htmlPrepare += 'Số Đến</th><th>';
        			htmlPrepare += 'Số Hiệu Văn Bản</th><th>';
        			htmlPrepare += 'Ngày Ban Hành</th><th>';
        			htmlPrepare += 'Trích Yếu Nội Dung</th></tr>';
        			
        			for(var i = 0 ; i< data.vanbandenListCoBan.length;i++){
        				htmlPrepare += '<tr><td>';
        				htmlPrepare += data.vanbandenListCoBan[i].ngayDen + '</td><td>';
        				htmlPrepare += data.vanbandenListCoBan[i].soDen + '</td><td>';
        				htmlPrepare += data.vanbandenListCoBan[i].soKyHieuVanBan + '</td><td>';
        				htmlPrepare += data.vanbandenListCoBan[i].ngayBanHanh + '</td><td>';
        				htmlPrepare += data.vanbandenListCoBan[i].trichYeu + '</td></tr>';
        			} 
        			
        			htmlPrepare += '</table>';
        			
        			$('#showketqua').html(htmlPrepare);
        			}
        		
        	});
			}
		});
		
		$( "#dialog_timkiemcoban").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: false,
		      buttons: {
		       		        
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      },
		      position: {
	                my: "left+400 bottom+290",
	                of: window
	            }
		    });
		$('#timkiemcoban').button().click(function(){
			
			$( "#dialog_timkiemcoban").dialog('open');
			return false;
			
		});
		$('#timkiemnangcao').button().click(function(){
			
		
			$( "#dialog_timkiemnangcao").dialog('open');
			return false;
		});
		
	});
</script>
</head>
<body>
	<div id="timKiemVanBanDen">
		<h3>Tìm kiếm văn bản đến</h3>
		 <div id = "toolbar" class="ui-widget-header ui-corner-all">
			<button id="timkiemcoban">Tìm kiếm cơ bản</button>
			<button id="timkiemnangcao">Tìm kiếm nâng cao</button>
		</div>
		
		<div id="showketqua">
		
		</div>
	
	
	</div>
	<div id="dialog_timkiemnangcao" title="Tìm kiếm nâng cao">
		<table>
			<tr>
				<td>Trích yếu</td>
				<td><input type="text" id="trichyeu"/></td>
			</tr>
			<tr>
				<td>Ngày đến</td>
				<td><input type="text" id="ngayden"/></td>
			</tr>
			<tr>
				<td>Số đến</td>
				<td><input type="text" id="soden"/></td>
			</tr>
			<tr>
				<td>Số, ký hiệu</td>
				<td><input type="text" id="sokyhieu"/></td>
			</tr>
			<tr>
				<td>Cơ quan phát hành</td>
				<td>
					<select id="coquanbanhanh">
		    			<c:forEach var="donvi" items="${donViList}">
		    				<option value='<c:out value="${donvi.getMaDonVi()}"/>'><c:out value="${donvi.getTenDonVi()}"/></option>
		    			</c:forEach>
		    		 </select>
	    		 </td>
			</tr>
			<tr>
				<td>Loại văn bản</td>
				<td>
					<select id="loaivanban">
		    			<c:forEach var="loaivanban" items="${loaiVanBanList}">
		    					<option value='<c:out value="${loaivanban.getMaLoaiVanBan()}"/>'><c:out value="${loaivanban.getTenLoaiVanBan()}"/></option>
		    			</c:forEach>
	    			</select>
				</td>
			</tr>
			<tr>
				<td>Lĩnh vực</td>
				<td>
					<select id="linhvuc">
		    			<c:forEach var="linhvuc" items="${linhVucList}">
		    					<option value='<c:out value="${linhvuc.getMaLinhVuc()}"/>'><c:out value="${linhvuc.getTenLinhVuc()}"/></option>
		    			</c:forEach>
	    		 	</select>
				</td>
			</tr>
			<tr>
				<td>Sổ văn bản</td>
				<td>
					<select id="sohoso">
	    			<c:forEach var="sohoso" items="${hoSoLuuTruList}">
	    					<option value='<c:out value="${sohoso.getSoHoSo()}"/>'><c:out value="${sohoso.getTieuDeHoSo()}"/></option>
	    			</c:forEach>
	    			 </select>
				</td>
			</tr>
		</table>
	</div>
	<div id="dialog_timkiemcoban" title="Nhập từ khóa để tìm kiếm">
		<table>
			<tr>
				<td>Từ khóa</td>
				<td><input type="text" id="tukhoa"/></td>
			</tr>
		</table>
	</div>
</body>
</html>