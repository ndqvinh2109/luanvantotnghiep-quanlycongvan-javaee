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
<script>
	$(document).ready(function(){
		var buoc = null;
		var maquytrinh = null;
		var mavanban = null;
		$('tr').bind('click',function(){
			mavanban = $(this).attr('id');
			maquytrinh = $(this).attr('class');
			buoc = $(this).find("td").eq(0).html();
			/* alert($(this).attr('id'));
			alert($(this).attr('class')); */
			$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
		});
		
		
		 $("#thoigianxuly").datepicker({
			  showAnim: 'clip',
		      dateFormat: 'yy-mm-dd'
		});
		 $("#thoigianxuly").datepicker('setDate', new Date());
		
		//$('#countdangchoxuly').text();
		$( "#dialog_capnhatxulypheduyet").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: true,
		      buttons: {
		        "Lưu": function(){
		        	var noidungxuly = $('#noidungxuly').val();
		        	var mavanbandia = $('#mvbtest').val();
		        	var buocdia = $('#bxltest').val();
		        	var maquytrinhdia = $('#qttest').val();
		        	var thoigianxuly = $('#thoigianxuly').val();
		        	$.ajax({
		        		url: '/LuanVanTotNghiep/service/capnhatnoidungxuly/' + mavanbandia + '/' + buocdia + '/' + noidungxuly + '/' + maquytrinhdia + '/' + thoigianxuly,
		        		type: 'POST',
		        		contentType: 'text/html; charset=UTF-8',
						data: null,
						success: function(data){
							if(data != 0){
								
							}
							
						}
		        	});
		        	alert("Xử lý thành công");
					location.reload('true');
		        	 $( this ).dialog( "close" );
		        	
		        },
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		
			$('#dialog-capnhatnoidung').button().click(function(){
				
				$('#mvbtest').attr("disabled", "disabled");
				$('#qttest').attr("disabled", "disabled");
				$.ajax({
					url: '/LuanVanTotNghiep/service/showcapnhatxuly/' + mavanban + '/' + buoc + '/' + maquytrinh,
					type: 'GET',
					dataType: "json",
					contentType: "application/json",
					success:function(data){
						var tr = data;
						console.log(tr);
						$('#bxltest').val(tr.buocxuly);
						$('#mvbtest').val(tr.mavanban);
						$('#qttest').val(tr.maquytrinh);
						var ttxl= tr.trangthaixuly;
						if(ttxl == 2){
							
							$('#ttxltest').val('Đang xử lý');
						}
						else{
							
							$('#ttxltest').val('Hoàn thành');
						}
						
					}
				});
								
				$("#dialog_capnhatxulypheduyet").dialog("open");
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
		$('#chitietvanbanden').button().click(function(){
			$('#coquanbanhanh1').attr("disabled", "disabled");
			$('#loaivanban1').attr("disabled", "disabled");
			$('#vitriluutru1').attr("disabled", "disabled");
			$('#linhvuc1').attr("disabled", "disabled");
			$('#capdokhan1').attr("disabled", "disabled");
			$('#capdobaomat1').attr("disabled", "disabled");
			$('#sohoso1').attr("disabled", "disabled");
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
			$( "#dialog_chitietvanban" ).dialog('open');
			return false;
			
		});
		$('#filedinhkem').button().click(function(){
			if(mavanban == null){
				alert("Bạn chưa chọn văn bản");
			}
			else{
				/* $('#mavanbandinhkem').val(mavanban);
				$("#dialog-dinhkem").dialog("open"); */
				window.location = '${pageContext.request.contextPath}/service/showFileDinhKem/' + mavanban + ".action";
				
			}
});
		
	});
</script>
<style type="text/css">
#dialog_chitietvanban table{
border-collapse: collapse;
 }
#dialog_chitietvanban table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
#toolbar_xulypheduyet{
padding:5px 5px 5px 5px;
}

#toolbar_xulypheduyet img {
  position: absolute;
  width: 16px;
  height: 16px;
  left: 2px;
  top: 50%;
  margin-top: -8px;
  
  	
}
#toolbar_xulypheduyet span{
  height: 20px;
  line-height: 20px;
  float: left;
  padding-left: 11px;
}
.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}
div#xulypheduyetvanban table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#xulypheduyetvanban table td, div#xulypheduyetvanban table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#xulypheduyetvanban table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#xulypheduyetvanban table tr:nth-child(even) {
  background-color: #fff;
}

div#xulypheduyetvanban table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}

div#xulypheduyetvanban table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}

#toolbar_xulypheduyet{
padding:5px 5px 5px 5px;
}

#dialog_capnhatxulypheduyet table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
#dialog_capnhatxulypheduyet table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
#dialog_capnhatxulypheduyet table tr td input{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding: 3px 2px;
width: 70%;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}

#dialog_capnhatxulypheduyet table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#dialog_capnhatxulypheduyet table tr td textarea{
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
#dialog_capnhatxulypheduyet table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

#dialog_capnhatxulypheduyet table tr td select{
color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 275px;
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
/* #dialog_capnhatxulypheduyet */

</style>
</head>
<body>
	<div id="xulypheduyetvanban">
		<h3>Văn bản đang chờ xử lý</h3>
		
		<div id="toolbar_xulypheduyet" class="ui-widget-header ui-corner-all">
			<button id="dialog-capnhatnoidung"><img src="/LuanVanTotNghiep/images/process.png"/><span>Xử lý văn bản</span></button>
			<button id="chitietvanbanden"><img src="/LuanVanTotNghiep/images/view_detail.png"/><span>Xem chi tiết</span></button>
			<button id="filedinhkem"><img src="/LuanVanTotNghiep/images/attachment (2).png"/><span>Đính kèm tập tin</span></button>
		</div>
		<table class="ui-widget ui-widget-content">
				<tr class="ui-widget-header">
					<th>Bước</th>
					<th>Số Đến</th>
				    <th>Ngày Đến</th>
				    <th>Ngày Ban Hành</th>
				    <th>Trích Yếu</th>
	   		    </tr>
		<c:forEach var="buocxuly" items="${buocxulyList}">
			<c:if test="${buocxuly.valueChuyen == true && buocxuly.valueXuLy == false}">
				<tr id="${buocxuly.vanban.maVanBan}" class="${buocxuly.buoc.pkQuyTrinh.maQuyTrinh}">
					<td>${buocxuly.buoc.pkQuyTrinh.soThuTu}</td>
					<td>${buocxuly.vanban.soDen}</td>
					<td>${buocxuly.vanban.ngayDen}</td>
					<td>${buocxuly.vanban.ngayBanHanh}</td>
					<td>${buocxuly.vanban.trichYeu}</td>
					<%-- <td>${buocxuly.vanban.maVanBan}</td> --%>
				</tr>
			</c:if>
		</c:forEach>
		
		</table>
		
		
		
		<div id="dialog_capnhatxulypheduyet" title="Xử lý văn bản">
		<form action="" method="post">
		<input type="hidden" id="bxltest"/>
		<input type="hidden" id="thoigianxuly" />
		<table border="1">
		<!-- <tr>
			<td>Bước xử lý</td>
			<td><input type="text" id="bxltest" readonly/></td>
		</tr> -->
		<tr>
			<td>Quy trình</td>
			<td>
				<select id="qttest">
	  				<c:forEach var="quytrinh" items="${quytrinhListAll}">
		    				<option value='<c:out value="${quytrinh.maQuyTrinh}"/>'><c:out value="${quytrinh.moTa}"/></option>
		    		</c:forEach>
				</select>
			
			<!-- <input type="text" id="qttest" /> -->
			
			</td>
		</tr>
		<tr>
			<td>Ký hiệu văn bản</td>
			<td>
			
				<select id="mvbtest">
	  				<c:forEach var="vanban" items="${vanbanListAll}">
		    				<option value='<c:out value="${vanban.maVanBan}"/>'><c:out value="${vanban.soKyHieuVanBan}"/></option>
		    		</c:forEach>
				</select>
				
		
			
			</td>
		</tr>
		
		<tr>
		<td>Trạng thái xử lý:</td>
		<td><input type="text" id="ttxltest" readonly/></td>
		</tr>
		
		<tr>
		<td>Nội dung xử lý:</td>
		<td><textarea rows="5" cols = "40" id="noidungxuly"></textarea></td>
		</tr>
		</table>
		
		</form>
		</div>
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