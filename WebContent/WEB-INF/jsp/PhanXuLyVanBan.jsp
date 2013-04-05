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
<script type="text/javascript">
	$(document).ready(function(){
			
				var icons = {
			      header: "ui-icon-circle-arrow-e",
			      activeHeader: "ui-icon-circle-arrow-s"
			    };
			    
		    $( "#showchitietbuocxuly" ).accordion({
		      icons: icons,
		      collapsible: true,
		      heightStyle: "content"
		    });
		    
		    $(".thoigianbatdauxuly").datepicker({
				  showAnim: 'drop',
			      dateFormat: 'yy-mm-dd'
			      
			});
		    
		    $(".thoigianhoanthanhxuly").datepicker({
				  showAnim: 'drop',
			      dateFormat: 'yy-mm-dd'
			});
		    
		   $("#thucoi").button().click(function(){
			   	var tempSoNgay = 0;
			   	var soNgay = 0;
			   	var changeType;
			   	var tempThoiGianXuLy;
			   	var parseDate;
			   $('.noidungchitietbuocxuly').each(function(index,element){
				   var indexPlusOne = index + 1;
				   var idThoiGianXuLy = "#thoigianbatdauxuly" + indexPlusOne;
				    $(idThoiGianXuLy).datepicker('setDate', new Date());
				    tempThoiGianXuLy = $(element).find('.thoigianbatdauxuly').val();
			    	parseDate = $.datepicker.parseDate('yy-mm-dd', tempThoiGianXuLy);
			    	parseDate.setDate(parseDate.getDate() + soNgay);
			    	$(idThoiGianXuLy).datepicker('setDate', parseDate);
			    	changeType = parseInt($(element).find('.songayxuly').val());
			    	tempSoNgay = tempSoNgay + changeType + 1;
			    	soNgay = parseInt(tempSoNgay);
				   
			    	var idThoiGianHoanThanh = "#thoigianhoanthanhxuly" + indexPlusOne;
			    	var tempThoiGianHoanThanh = $(element).find('.thoigianbatdauxuly').val();
			    	var parseDateHT = $.datepicker.parseDate('yy-mm-dd', tempThoiGianHoanThanh);
			    	var changeTypeHT = parseInt($(element).find('.songayxuly').val());
			    	var soNgayHT = parseInt(changeTypeHT);
			    	parseDateHT.setDate(parseDate.getDate() + soNgayHT);
			       	$(idThoiGianHoanThanh).datepicker('setDate', parseDateHT);
			    	 
				     
				   	
				});
			   
			   return false;
			   
		   });
		   
		  $('#themphanxuly').button().click(function(){
			  
			  $('.noidungchitietbuocxuly').each(function(index,element){
					var sothutu = $(element).attr('id');
					var manguoidung = $(element).find('.nguoidung').val();
					var thoigianbatdau = $(element).find('.thoigianbatdauxuly').val();
					var thoigianhoanthanh = $(element).find('.thoigianhoanthanhxuly').val();
					var maquytrinh = '${maquytrinh}';
					var mavanban = '${mavanban}';
					$.ajax({
						url: '/LuanVanTotNghiep/service/addBuocXuLy/' 
						+  sothutu + '/' + manguoidung + '/' + thoigianbatdau + '/' 
						+  thoigianhoanthanh + '/' + maquytrinh + '/' + mavanban,
						type: 'POST',
						data: null,
						contentType: 'text/html; charset=UTF-8',
						success: function(result){
							if(result){
								alert("Thành công");
								
							}
							
						}
					}); 
					
				});
			  return false;
		  });
		  
	});
</script>
<style type="text/css">
.noidungchitietbuocxuly table tr td input{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding: 3px 2px;
width: 50%;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}

.noidungchitietbuocxuly table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

.noidungchitietbuocxuly table tr td textarea{
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
padding:5px 5px;
width: 530px;
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
.noidungchitietbuocxuly table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

.noidungchitietbuocxuly table tr td select{
color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 275px;
}

#toolbar_phanxuly{
padding: 5px 5px 5px 5px;
margin-bottom: 10px;
}

div#showchitietbuocxuly table{
 margin: 1em 0; border-collapse: collapse; width: 100%; 

 }
 div#showchitietbuocxuly table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="phanxulyvanban">
		<h3>Phân xử lý văn bản</h3>
		<div id="toolbar_phanxuly" class="ui-widget-header ui-corner-all">
			<button id="thucoi" >Thiết lập ngày xử lý</button>
			<button id="themphanxuly">Phân xử lý</button>
		</div>
		<form action="" method="post">
			<div id="showchitietbuocxuly">
				<c:if test="${checkExist == true}">
			   		<c:forEach items="${buocList}" var="buoc">
			   			 <h3>Bước ${buoc.pkQuyTrinh.soThuTu}</h3>
			   		<div class="noidungchitietbuocxuly" id="${buoc.pkQuyTrinh.soThuTu}">
			   			<table>
			   				<tr>
			   				<td>Người xử lý:</td>
			   				<td>
			   					<select class="nguoidung">
			    					<option value='<c:out value="${buoc.nguoidung.maNguoiDung}"/>'><c:out value="${buoc.nguoidung.tenNguoiDung}"/></option>
			    				</select>	
			    				
			   				</td>
			   				</tr>
			   				<tr>
			   				<td>Nội dung công việc:</td>
			   				<td><textarea  class="noidungcongviecphanxuly" rows="5" cols="40" readonly>${buoc.congviec.noiDungCongViec}</textarea></td>
			   				</tr>
			   				
			   				
			   				
			   				<tr>
			   				<td>Số ngày xử lý:</td>
			   				<td><input type="text" value="${buoc.soNgay}" class="songayxuly" readonly/></td>
			   				</tr>
			   				
			   				<tr>
			   				<td>Thời gian bắt đầu:</td>
			   				<td><input type="text" class="thoigianbatdauxuly" id="thoigianbatdauxuly${buoc.pkQuyTrinh.soThuTu}" readonly/></td>
			   				</tr>
			   				
			   				<tr>
			   				<td>Thời gian hoàn thành:</td>
			   				<td><input type="text" class="thoigianhoanthanhxuly" id="thoigianhoanthanhxuly${buoc.pkQuyTrinh.soThuTu}" readonly/></td>
			   				</tr>
			   				
			   			</table>
			   			</div>
			   			</c:forEach>
			   			</c:if>
			</div>	
			
			<!-- <input type="submit" id="themphanxuly" value="Thêm"/> -->
			
		</form>
		
		</div>
	
</body>
</html>