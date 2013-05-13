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
#dialog_chitietvanban table{
border-collapse: collapse;
 }
#dialog_chitietvanban table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
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
 #show_filedinhkemList{
padding: 20px 0;
}

#show_filedinhkemList a{
text-decoration:none;
color:blue;
}

#show_filedinhkemList a:hover{
color: red;
}
#show_filedinhkemList table{
border-collapse: collapse;
}
#show_filedinhkemList table td,#show_filedinhkemList table th{
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
			        	var trichyeu = $('#trichyeu').val() || "@";
			        	var ngayden = $('#ngayden').val() || "@";
			        	var soden = $('#soden').val() || 0;
			        	var sokyhieu = $('#sokyhieu').val() || "@";
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
        				htmlPrepare += '<tr id="' + data.vanbandenListCoBan[i].maVanBan + '"><td>';
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
		
		/* var mavanban = null;
		$(document).on("click", "tr", function(){
			 mavanban = $(this).attr('id');
			 alert(mavanban);
		}); */
		var mavanban = null;
		$("body").delegate("tr", "click", function(){
			mavanban = $(this).attr('id');
			
		 	/* alert(mavanban); */
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
		
		$( "#dialog_chitietvanban" ).dialog({
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
		$("#chitietvanbanden").button().click(function(){
			$('#coquanbanhanh1').attr("disabled", "disabled");
			$('#loaivanban1').attr("disabled", "disabled");
			$('#vitriluutru1').attr("disabled", "disabled");
			$('#linhvuc1').attr("disabled", "disabled");
			$('#capdokhan1').attr("disabled", "disabled");
			$('#capdobaomat1').attr("disabled", "disabled");
			$('#sohoso1').attr("disabled", "disabled");
			if(mavanban == null){
				$("#dialog_error").dialog("open");
			}
			else{
				$.ajax({
					url: '/LuanVanTotNghiep/service/getNguoiDungXuLy/' + mavanban,
					type: 'GET',
					dataType: "json",
					contentType: "application/json",
					success: function(data){
						console.log(data);
						console.log(data.ListBXLDaXuLy.length);
						var htmlPrepare = '';
						for(var i = 0; i< data.ListBXLDaXuLy.length;i++){
							htmlPrepare += '<li style = "color:#2bcc3e;padding: 5px 0">' +data.ListBXLDaXuLy2[i]+ '<b>' + data.ListBXLDaXuLy[i] + '</b></li>';
							htmlPrepare += '<span style="color:red"> - ' + data.ListBXLDaXuLy1[i] + '</span>';
							
						}
						
						$('#guichondxuly').html(htmlPrepare);
									
					}
					
				});
				$.ajax({
					url: '/LuanVanTotNghiep/service/getmavanban/' + mavanban,
					type: 'GET',
					dataType: "json",
					/* contentType: 'text/html; charset=UTF-8', */
					contentType: "application/json",
					success: function(data){
						$('#soden1').val(data.vanbandenupdate.soDen);
						$('#ngayden1').val(data.vanbandenupdate.ngayDen);
						$('#sovakyhieu1').text(data.vanbandenupdate.soKyHieuVanBan);
						$('#ngaybanhanh1').text(data.vanbandenupdate.ngayBanHanh);
						$('#ngayhieuluc1').val(data.vanbandenupdate.ngayHieuLuc);
						$('#ngayketthuc1').val(data.vanbandenupdate.ngayHetHieuLuc);
						$('#ngaynhapmay1').val(data.vanbandenupdate.ngayNhapMay);
						$('#trichyeu1').val(data.vanbandenupdate.trichYeu);
						$('#tukhoa1').val(data.vanbandenupdate.tuKhoa);
						$('#nguoiky1').val(data.vanbandenupdate.nguoiKy);
						$('#sotrang1').val(data.vanbandenupdate.soTrang);
						$('#mavanban1').val(data.vanbandenupdate.maVanBan);
						$('#coquanbanhanh1').val(data.coquanbanhanh);
						$('#loaivanban1').val(data.loaivanban);
						$('#vitriluutru1').val(data.vitriluutru);
						$('#linhvuc1').val(data.linhvuc);
						$('#capdokhan1').val(data.capdokhan);
						$('#capdobaomat1').val(data.capdobaomat);
						$('#sohoso1').val(data.sohoso);
						var ttxl = data.trangthaixuly;
						if(ttxl == 1){
							$('#radio11').attr('checked', true);
						}
						else if(ttxl == 2){
							$('#radio21').attr('checked', true);
						}
						else{
							$('#radio31').attr('checked', true);
						}
						
						var htmlPrepare = '<table class="data"><tr><th>File đính kèm</th><th>Tải về máy</th><th>Xem</th></tr>';
						for(var i = 0 ; i < data.fileDinhKemList.length;i++){
							var j = i + 1;
							htmlPrepare += '<tr><td style="color: #e29126">';
							htmlPrepare += 'File đính kèm' +j+ '</td><td>';
							htmlPrepare += '<a href="${pageContext.request.contextPath}/service/download/' + data.fileDinhKemList[i].maFile + '">Download</a>' + '</td><td>';
							htmlPrepare += '<a href="${pageContext.request.contextPath}/service/xemtructuyen/' + data.fileDinhKemList[i].maFile + '">Xem</a>' + '</td></tr>';
						}
					
							htmlPrepare += '</table>';
							$('#show_filedinhkemList').html(htmlPrepare);
							
						console.log(data);
					}
				});
				
			}
			$( "#dialog_chitietvanban" ).dialog('open');
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
			<button id="chitietvanbanden"><img src="/LuanVanTotNghiep/images/view_detail.png"/><span>Xem chi tiết</span></button>
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
	<div id="dialog_chitietvanban" title="Chi tiết văn bản">
		<h3 style="padding: 10px 0px;color: #0163c8">Thông tin chung:</h3>
		<table>
		<tr>
			<td style="background-color: #e8edff">Số văn bản</td>
			<td><span id="sovakyhieu1" style="color:#6fabe9"></span></td>
		</tr>
		<tr>
			<td style="background-color: #e8edff">Ngày ban hành</td>
			<td><span id="ngaybanhanh1" style="color:#9ab937"></span></td>
		</tr>
		<tr>
			<td style="background-color: #e8edff">Loại văn bản</td>
			<td>
				<select id="loaivanban1">
		    			<c:forEach var="loaivanban" items="${loaiVanBanList}">
		    					<option value='<c:out value="${loaivanban.getMaLoaiVanBan()}"/>'><c:out value="${loaivanban.getTenLoaiVanBan()}"/></option>
		    			</c:forEach>
		    	</select>
	    	</td>
		</tr>
		<tr>
			<td style="background-color: #e8edff">Cơ quan ban hành</td>
			<td>
				<select id="coquanbanhanh1">
	    			<c:forEach var="donvi" items="${donViList}">
	    				<option value='<c:out value="${donvi.getMaDonVi()}"/>'><c:out value="${donvi.getTenDonVi()}"/></option>
	    			</c:forEach>
	    		 </select>
			</td>
		</tr>
		<tr>
			<td style="background-color: #e8edff">Lĩnh vực, chủ đề</td>
			<td>
				<select id="linhvuc1">
	    			<c:forEach var="linhvuc" items="${linhVucList}">
	    					<option value='<c:out value="${linhvuc.getMaLinhVuc()}"/>'><c:out value="${linhvuc.getTenLinhVuc()}"/></option>
	    			</c:forEach>
	    		 </select>
			</td>
		</tr>
		<tr>
			<td style="background-color: #e8edff; ">Độ khẩn</td>
			<td>
				<select id="capdokhan1">
	    			<c:forEach var="capdokhan" items="${capDoKhanList}">
	    					<option value='<c:out value="${capdokhan.getMaDoKhan()}"/>'><c:out value="${capdokhan.getTenDoKhan()}"/></option>
	    			</c:forEach>
	    		 </select>
			</td>
		</tr>
		</table>
		<h3 style="padding: 10px 0px;color: #0163c8">Các người dùng đã phê duyệt/xử lý văn bản:</h3>
		
		<ul id="guichondxuly">
		
		</ul>
		<h3 style="padding: 15px 0px 0px 0px;color: #0163c8">Các file đính kèm:</h3>
		<div id="show_filedinhkemList">
		
		</div>
</div>
</body>
</html>