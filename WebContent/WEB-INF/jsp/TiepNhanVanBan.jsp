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
div#tiepnhanvanban table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#tiepnhanvanban table td, div#tiepnhanvanban table th{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 div#tiepnhanvanban table tr:nth-child(odd) {
  background-color: #e8edff;
}
div#tiepnhanvanban table tr:nth-child(even) {
  background-color: #fff;
}

div#tiepnhanvanban table tr:hover{
	background-color: #cfddee;
	cursor:pointer;
	
}

div#tiepnhanvanban table tr.hilightclick{
	background-color: #fdf7d9 !important;
	
}

#toolbar{
padding:5px 5px 5px 5px;
}

div#tiepnhanvanban h3{
	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
	
}
.ui-dialog-titlebar {
	background: url(/LuanVanTotNghiep/images/dialog.png) center left repeat-x;
	color: #ffffff;
	font-family: Arial,Verdana,Sans-serif;
	border: 1px solid #ffb053;
}



div#dialog_capnhatsodenngayden table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 
 }
 div#dialog_capnhatsodenngayden table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 
 
 #dialog_capnhatsodenngayden table tr td input{
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

#dialog_capnhatsodenngayden table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}
 
#dialog_capnhatsodenngayden table tr td textarea{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding:5px 5px;
width: 100%;
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
#dialog_capnhatsodenngayden table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
} 
#dialog_capnhatsodenngayden table tr td select{

color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 200px;
}


</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#ngayden").datepicker({
			 showAnim: 'drop',
		     dateFormat: 'yy-mm-dd'
		});
		$("#ngayden").focus(function(){
			   $("#ngayden").datepicker('setDate', new Date());
		});
		var kyhieuvanban = null;
		var mavanban = null;
		$('#tiepnhanvanban tr').bind('click',function(){
			kyhieuvanban = $(this).find("td").eq(2).html(); 
			mavanban = $(this).attr('id');
			/* alert(kyhieuvanban); */
			$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
		});
		
		
		$( "#dialog_capnhatsodenngayden").dialog({
			  autoOpen: false,
		      resizable: true,
		      height:'auto',
		      width:'auto',
		      modal: true,
		      buttons: {
		        "Lưu": function(){
		        	var soden = $('#soden').val();
					var ngayden=$('#ngayden').val();
					var coquanbanhanh=$('#coquanbanhanh1').val();
					var ngaybanhanh = $('#ngaybanhanh1').val();
					var ngayhieuluc= $('#ngayhieuluc1').val();
					var ngayketthuc= $('#ngayketthuc1').val();
					var ngaynhapmay= $('#ngaynhapmay1').val();
					var loaivanban= $('#loaivanban1').val();
					var vitriluutru= $('#vitriluutru1').val();
					var linhvuc= $('#linhvuc1').val();
					var capdokhan= $('#capdokhan1').val();
					var capdobaomat= $('#capdobaomat1').val();
					var sohoso= $('#sohoso1').val();
					var trangthaixuly = $('input:radio[name=radio]:checked').val();
					var trichyeu= $('#trichyeu1').val();
					var tukhoa= $('#tukhoa1').val();
					var nguoiky= $('#nguoiky1').val();
					var sotrang= $('#sotrang1').val();
					var mavanban = $('#mavanban').val();
					var sovakyhieu = $('#kyhieuvanban').val();
					$.ajax({
						url: '/LuanVanTotNghiep/service/updateVanBanDenTiepNhan/' + soden + '/' + ngayden + '/' +
						coquanbanhanh + '/' + sovakyhieu + '/' + ngaybanhanh + '/' + ngayhieuluc + '/' +
						ngayketthuc + '/' + ngaynhapmay + '/' + loaivanban + '/' + vitriluutru + '/' + linhvuc + '/' + capdokhan +
						'/' + capdobaomat + '/' + sohoso + '/' + trangthaixuly + '/' + trichyeu + '/' +
						tukhoa + '/' + nguoiky + '/' + sotrang + '/' + mavanban ,
						type: "POST",
						contentType: 'text/html; charset=UTF-8',
						data: null,
						success:function(result){
							if(result){
								location.reload(true);
							}
							
						}
					});
		        	 
		        	 /* $( this ).dialog( "close" ); */
		        	
		        },
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		
		
		$('#tiepnhan').button().click(function(){
			
			$('#coquanbanhanh1').attr("disabled", "disabled");
			$('#loaivanban1').attr("disabled", "disabled");
			$('#vitriluutru1').attr("disabled", "disabled");
			$('#linhvuc1').attr("disabled", "disabled");
			$('#capdokhan1').attr("disabled", "disabled");
			$('#capdobaomat1').attr("disabled", "disabled");
			$('#sohoso1').attr("disabled", "disabled");
			$('#mavanban').val(mavanban);
			$('#kyhieuvanban').val(kyhieuvanban);
			$( "#dialog_capnhatsodenngayden").dialog('open');
			$.ajax({
				url: '/LuanVanTotNghiep/service/getmavanbantiepnhan/' + mavanban,
				type: 'GET',
				dataType: "json",
				/* contentType: 'text/html; charset=UTF-8', */
				contentType: "application/json",
				success: function(data){
					$('#ngaybanhanh1').val(data.vanbandenupdate.ngayBanHanh);
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
					
					var htmlPrepare = '<table class="data"><tr><th>Tên tập tin</th><th>Mô tả tập tin</th><th>Tải về máy</th><th>Xem</th></tr>';
					for(var i = 0 ; i < data.fileDinhKemList.length;i++){
						htmlPrepare += '<tr><td>';
						htmlPrepare += data.fileDinhKemList[i].tenFile + '</td><td>';
						htmlPrepare += data.fileDinhKemList[i].moTa + '</td><td>';
						htmlPrepare += '<a href="${pageContext.request.contextPath}/service/download/' + data.fileDinhKemList[i].maFile + '">Download</a>' + '</td><td>';
						htmlPrepare += '<a href="${pageContext.request.contextPath}/service/xemtructuyen/' + data.fileDinhKemList[i].maFile + '">Xem</a>' + '</td></tr>';
					}
				
						htmlPrepare += '</table>';
						$('#show_filedinhkemList').html(htmlPrepare);
					console.log(data);
				}
			});
			return false;
			
		});
	});

</script>
</head>
<body>
	<div id="tiepnhanvanban">
		<h3>Danh sách văn bản chờ tiếp nhận</h3>
		 <div id = "toolbar" class="ui-widget-header ui-corner-all">
			<button id="tiepnhan">Tiếp nhận</button>
		</div>
 
		<table class="ui-widget ui-widget-content">
			<tr class="ui-widget-header">
			    <th>Ngày Đến</th>
			    <th>Số Đến</th>
			   	<th>Số Hiệu Văn Bản</th>
			   	<th>Ngày Ban Hành</th>
			   	<th>Trích yếu Nội Dung</th>
		  	</tr>
			<c:forEach items="${ListVanBanChuaTiepNhan}" var="vanbanden">
			    <tr id = "${vanbanden.maVanBan}">
			    	<td>${vanbanden.getNgayDen()}</td>
			    	<td>${vanbanden.getSoDen()}</td>
			    	<td>${vanbanden.soKyHieuVanBan}</td>
			        <td>${vanbanden.ngayBanHanh}</td>
			      	<td>${vanbanden.trichYeu}</td>
			   </tr>
			   
			</c:forEach>
			
		</table>	
	
	</div>

	<div id="dialog_capnhatsodenngayden" title="Cập nhật thông tin văn bản đến qua mạng">
		<form method="post" action="">
			<input type="hidden" id="mavanban" value="" readonly/>
			<table>
				<!-- <tr>
					<td>Mã văn bản</td>
					<td><input type="text" id="mavanban" value="" readonly/></td>
				</tr> -->
				<tr>
					<td>Số Đến</td>
					<td><input type="text" id="soden" value="${maxsoden + 1}" readonly/></td>
				</tr>
				<tr>
					<td>Ngày Đến</td>
					<td><input type="text" id="ngayden" value="" readonly/></td>
				</tr>
				<tr>
					<td>Số Và Ký Hiệu</td>
					<td><input type="text" id="kyhieuvanban" value="" readonly/></td>
				</tr>
				
			<tr>
				<td>Ngày ban hành</td>
				<td><input type="text" id="ngaybanhanh1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Ngày hiệu lực</td>
				<td><input type="text" id="ngayhieuluc1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Ngày kết thúc</td>
				<td><input type="text" id="ngayketthuc1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Ngày nhập máy</td>
				<td><input type="text" id="ngaynhapmay1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Trích yếu</td>
				<td><textarea rows="5" cols="40" id="trichyeu1" readonly></textarea></td>
			</tr>
			<tr>
				<td>Từ khóa</td>
				<td><textarea rows="5" cols="40" id="tukhoa1" readonly></textarea></td>
			</tr>
			<tr>
				<td>Người ký</td>
				<td><input type="text" id="nguoiky1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Số trang</td>
				<td><input type="text" id="sotrang1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Cơ quan ban hành</td>
				<td>
					<select id="coquanbanhanh1">
	    			<c:forEach var="donvi" items="${donViList}">
	    				<option value='<c:out value="${donvi.getMaDonVi()}"/>'><c:out value="${donvi.getTenDonVi()}"/></option>
	    			</c:forEach>
	    		 </select>
				</td>
			</tr>
			<tr>
				<td>Loại văn bản</td>
				<td>
					<select id="loaivanban1">
		    			<c:forEach var="loaivanban" items="${loaiVanBanList}">
		    					<option value='<c:out value="${loaivanban.getMaLoaiVanBan()}"/>'><c:out value="${loaivanban.getTenLoaiVanBan()}"/></option>
		    			</c:forEach>
	    			</select>
				</td>
			</tr>
			<tr>
				<td>Vị trí lưu trữ</td>
				<td>
					<select id="vitriluutru1">
	    			<c:forEach var="vitriluutru" items="${viTriLuuTruList}">
	    					<option value='<c:out value="${vitriluutru.getStt()}"/>'><c:out value="${vitriluutru.getViTri()}"/></option>
	    			</c:forEach>
	    		 </select>
				</td>
			</tr>
			<tr>
				<td>Lĩnh vực</td>
				<td>
					<select id="linhvuc1">
	    			<c:forEach var="linhvuc" items="${linhVucList}">
	    					<option value='<c:out value="${linhvuc.getMaLinhVuc()}"/>'><c:out value="${linhvuc.getTenLinhVuc()}"/></option>
	    			</c:forEach>
	    		 	</select>
				</td>
			</tr>
			<tr>
				<td>Cấp độ khẩn</td>
				<td>
					<select id="capdokhan1">
	    			<c:forEach var="capdokhan" items="${capDoKhanList}">
	    					<option value='<c:out value="${capdokhan.getMaDoKhan()}"/>'><c:out value="${capdokhan.getTenDoKhan()}"/></option>
	    			</c:forEach>
	    		 </select>
				</td>
			</tr>
			<tr>
				<td>Cấp độ bảo mật</td>
				<td>
					<select id="capdobaomat1">
	    			<c:forEach var="capdobaomat" items="${capDoBaoMatList}">
	    					<option value='<c:out value="${capdobaomat.getMaDoMat()}"/>'><c:out value="${capdobaomat.getTenDoMat()}"/></option>
	    			</c:forEach>
	    		 </select>
				</td>
			</tr>
			<tr>
				<td>Số hồ sơ</td>
				<td>
					<select id="sohoso1">
	    			<c:forEach var="sohoso" items="${hoSoLuuTruList}">
	    					<option value='<c:out value="${sohoso.getSoHoSo()}"/>'><c:out value="${sohoso.getTieuDeHoSo()}"/></option>
	    			</c:forEach>
	    			 </select>
				</td>
			</tr>
			<tr>
				<td>Trạng thái xử lý</td>
				<td>
					
				   	<table>
				   		<tr>
				   			<td>Chưa xử lý<input type="radio" id="radio11" name="radio" value='1' checked="checked" /></td>
				   		</tr>
				   		<tr>
				   			<td>Đang xử lý<input type="radio" id="radio21" name="radio" value='2' /></td>
				   		</tr>
				   		<tr>
				   			<td>Hoàn thành<input type="radio" id="radio31" name="radio" value='3' /></td>
				   		</tr>
				   	</table>
				</td>
			</tr>
			</table>	
		</form>
		
		<div id="show_filedinhkemList">
		
		</div>
	</div>

</body>
</html>