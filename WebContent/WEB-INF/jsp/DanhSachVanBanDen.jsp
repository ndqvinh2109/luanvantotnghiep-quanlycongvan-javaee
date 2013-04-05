<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Multiple File Upload</title>
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

#dialog-update table tr td textarea{
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
#dialog-update table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

#dialog-update table tr td input{
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

#dialog-update table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#dialog-update table tr td select{

color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 200px;
}

#dialog-update table tr td table tr td{
padding: 5px 5px 5px 5px;
}

div#dialog-update table{
border-collapse: collapse;
 }
 div#dialog-update table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
 }
 

div#dialog-dinhkem table{
border-collapse: collapse;
}
div#dialog-dinhkem table td{
 border: 1px solid #eee;
 padding: .6em 10px;
 text-align: left;
}

div#dialog-dinhkem table tr td input{
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

div#dialog-dinhkem table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

div#dialog-dinhkem table tr td textarea{
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
div#dialog-dinhkem table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}



#dialog_chitietvanban table tr td textarea{
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
#dialog_chitietvanban table tr td textarea:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

#dialog_chitietvanban table tr td input{
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

#dialog_chitietvanban table tr td input:focus{
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#dialog_chitietvanban table tr td select{

color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 200px;
}

#dialog_chitietvanban table tr td table tr td{
padding: 5px 5px 5px 5px;
}

#dialog_chitietvanban table{
border-collapse: collapse;
 }
#dialog_chitietvanban table td{
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

</style>

<script type="text/javascript">
$(document).ready(function(){
	
	var mavanban = null;
	$('tr').not(':first').bind('click',function(){
		mavanban = $(this).attr('id');
		/* var customerId = $(this).find("td").eq(2).html();    
		alert(customerId); */
		$(this).addClass("hilightclick").siblings().removeClass("hilightclick"); 
		//$('#toolbar a').attr('href','${pageContext.request.contextPath}/service/' + mavanban);
	});

	/*--------------------Delete VanBanDen------------------------------*/
	$( "#dialog_error" ).dialog({
		  autoOpen: false,
	      resizable: true,
	      height:140,
	      width:400,
	      modal: true,
	      buttons: {
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
	
	$( "#dialog-confirm" ).dialog({
		  autoOpen: false,
	      resizable: true,
	      height:170,
	      width:400,
	      modal: true,
	      buttons: {
	        "Xóa": function() {
	        	//alert(mavanban);
				$.ajax({
					url: '/LuanVanTotNghiep/service/deletevanbanden/' + mavanban,
					type: 'GET',
					data: null,
					success:function(result){
						if(result){
							location.reload(true);
						}
						
					}
				});
	        },
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
		$('#delete').button().click(function(){
			if(mavanban == null){
				$("#dialog_error").dialog("open");
			}
			else{
				$("#dialog-confirm").dialog("open");
			}
		});
		
/*---------------------------------------End Delete VanBanDen---------------------------*/
 
 
 
 /*--------------------------------Update VanBanDen-------------------------------------*/
 
 
		$("#ngaybanhanh").datepicker({
			  showAnim: 'clip',
		      dateFormat: 'yy-mm-dd'
		});
		
		$("#ngayhieuluc").datepicker({
			 showAnim: 'clip',
		      dateFormat: 'yy-mm-dd'
		});
		$("#ngayketthuc").datepicker({
			 showAnim: 'drop',
		      dateFormat: 'yy-mm-dd'
		});
		$("#ngayden").datepicker({
			 showAnim: 'drop',
		      dateFormat: 'yy-mm-dd'
		}); 
		$("#ngaynhapmay").datepicker({
			 showAnim: 'drop',
		      dateFormat: 'yy-mm-dd'
		}); 
		
		
		
		$( "#dialog-update" ).dialog({
			  autoOpen: false,
		      resizable: true,
		      height:600,
		      width:500,
		      modal: true,
		      buttons: {
		        "Lưu": function() {
		        	 //$( this ).dialog( "close" );
		        	var soden = $('#soden').val();
					var ngayden=$('#ngayden').val();
					var coquanbanhanh=$('#coquanbanhanh').val();
					var sovakyhieu = $('#sovakyhieu').val();
					var ngaybanhanh = $('#ngaybanhanh').val();
					var ngayhieuluc= $('#ngayhieuluc').val();
					var ngayketthuc= $('#ngayketthuc').val();
					var ngaynhapmay= $('#ngaynhapmay').val();
					var loaivanban= $('#loaivanban').val();
					var vitriluutru= $('#vitriluutru').val();
					var linhvuc= $('#linhvuc').val();
					var capdokhan= $('#capdokhan').val();
					var capdobaomat= $('#capdobaomat').val();
					var sohoso= $('#sohoso').val();
					var trangthaixuly = $('input:radio[name=radio]:checked').val();
					var trichyeu= $('#trichyeu').val();
					var tukhoa= $('#tukhoa').val();
					var nguoiky= $('#nguoiky').val();
					var sotrang= $('#sotrang').val();
					var maVanBan = $('#mavanban').val();
					$.ajax({
						url: '/LuanVanTotNghiep/service/updateVanBanDen/' + soden + '/' + ngayden + '/' +
						coquanbanhanh + '/' + sovakyhieu + '/' + ngaybanhanh + '/' + ngayhieuluc + '/' +
						ngayketthuc + '/' + ngaynhapmay + '/' + loaivanban + '/' + vitriluutru + '/' + linhvuc + '/' + capdokhan +
						'/' + capdobaomat + '/' + sohoso + '/' + trangthaixuly + '/' + trichyeu + '/' +
						tukhoa + '/' + nguoiky + '/' + sotrang + '/' + maVanBan ,
						type: "POST",
						contentType: 'text/html; charset=UTF-8',
						data: null,
						success:function(result){
							if(result){
								location.reload(true);
							}
							
						}
					});
					
					return false;
		        	
		        	 
		        },
		        Cancel: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
			$('#update').button().click(function(){
				if(mavanban == null){
					$("#dialog_error").dialog("open");
				}
				else{
				$.ajax({
					url: '/LuanVanTotNghiep/service/getmavanban/' + mavanban,
					type: 'GET',
					dataType: "json",
					contentType: "application/json",
					success: function(data){
						$('#soden').val(data.vanbandenupdate.soDen);
						$('#ngayden').val(data.vanbandenupdate.ngayDen);
						$('#sovakyhieu').val(data.vanbandenupdate.soKyHieuVanBan);
						$('#ngaybanhanh').val(data.vanbandenupdate.ngayBanHanh);
						$('#ngayhieuluc').val(data.vanbandenupdate.ngayHieuLuc);
						$('#ngayketthuc').val(data.vanbandenupdate.ngayHetHieuLuc);
						$('#ngaynhapmay').val(data.vanbandenupdate.ngayNhapMay);
						$('#trichyeu').val(data.vanbandenupdate.trichYeu);
						$('#tukhoa').val(data.vanbandenupdate.tuKhoa);
						$('#nguoiky').val(data.vanbandenupdate.nguoiKy);
						$('#sotrang').val(data.vanbandenupdate.soTrang);
						$('#mavanban').val(data.vanbandenupdate.maVanBan);
						$('#coquanbanhanh').val(data.coquanbanhanh);
						$('#loaivanban').val(data.loaivanban);
						$('#vitriluutru').val(data.vitriluutru);
						$('#linhvuc').val(data.linhvuc);
						$('#capdokhan').val(data.capdokhan);
						$('#capdobaomat').val(data.capdobaomat);
						$('#sohoso').val(data.sohoso);
						var ttxl = data.trangthaixuly;
						if(ttxl == 1){
							$('#radio1').attr('checked', true);
						}
						else if(ttxl == 2){
							$('#radio2').attr('checked', true);
						}
						else{
							$('#radio3').attr('checked', true);
						}
						console.log(data);
					}
				});
				
				$("#dialog-update").dialog("open");
				}
				//alert(mavanban);
			});
			
			
/*------------------------------------End Update VanBanDen-----------------------------------------*/



/*-----------------------------------File Dinh Kem----------------------------------------*/
 
    $( "#dialog-dinhkem" ).dialog({
		  autoOpen: false,
	      resizable: true,
	      height:'auto',
	      width:'auto',
	      modal: true,
	      buttons: {
	    	'Thêm tập tin': function(){
	    		
	    			    		
	    		},
	        Cancel: function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
		
 
 
$('#filedinhkem').button().click(function(){
			if(mavanban == null){
				$("#dialog_error").dialog("open");
			}
			else{
				$('#mavanbandinhkem').val(mavanban);
				$("#dialog-dinhkem").dialog("open");
			}
});
 
 
/*------------------------------------End File Dinh Kem-----------------------------------*/
		
		
/*----------------------------------------Chi tiet van ban_--------------------------------*/	

$( "#dialog_chitietvanban" ).dialog({
		  autoOpen: false,
	      resizable: true,
	      height:600,
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
		url: '/LuanVanTotNghiep/service/getmavanban/' + mavanban,
		type: 'GET',
		dataType: "json",
		/* contentType: 'text/html; charset=UTF-8', */
		contentType: "application/json",
		success: function(data){
			$('#soden1').val(data.vanbandenupdate.soDen);
			$('#ngayden1').val(data.vanbandenupdate.ngayDen);
			$('#sovakyhieu1').val(data.vanbandenupdate.soKyHieuVanBan);
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
	
	$("#dialog_chitietvanban").dialog("open");
	}
	
});
	
	


/*----------------------------------------End Chi tiet van ban---------------------------------*/		

$('#phanxuly').button().click(function(){
	window.location = '${pageContext.request.contextPath}/service/' + mavanban;
	
});

});


</script>

</head>
<body>

<div id="accordion">
 <h3>Danh sách công văn đến</h3>
 <div id = "toolbar" class="ui-widget-header ui-corner-all">
	<button id="delete">Xóa</button>
	<button id="update">Sửa</button>
	<button id="filedinhkem">Đính kèm tập tin</button>
	<button id="chitietvanbanden">Xem chi tiết</button>
	<button id="phanxuly">Phân xử lý</button>
	
 </div>
 
<table class="ui-widget ui-widget-content">
	<tr class="ui-widget-header">
	    <th>Ngày Đến</th>
	    <th>Số Đến</th>
	   	<th>Số Hiệu Văn Bản</th>
	   	<th>Ngày Ban Hành</th>
	   	<th>Trích yếu Nội Dung</th>
  	</tr>
	<c:forEach items="${vanbandenList}" var="vanbanden">
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

<div id="dialog-confirm" title="Bạn có muốn xóa công văn đến này không?">
  <p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Những dữ liệu liên quan đến công văn này như: Tập tin đính kèm, Quy trình xử lý, Ý kiến đóng góp, sẽ xóa cùng với công văn đó. Bạn có chắc không?</p>
</div>

<div id="dialog-update" title="Chỉnh sửa công văn đến">
	<form action="" method="post">
		<table>
			<tr>
				<td>Mã văn bản</td>
				<td><input type="text" id="mavanban" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Số đến</td>
				<td><input type="text" id="soden" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Ngày đến</td>
				<td><input type="text" id="ngayden" value = ""/></td>
			</tr>
			<tr>
				<td>Số và ký hiệu</td>
				<td><input type="text" id="sovakyhieu" value = ""/></td>
			</tr>
			<tr>
				<td>Ngày ban hành</td>
				<td><input type="text" id="ngaybanhanh" value = ""/></td>
			</tr>
			<tr>
				<td>Ngày hiệu lực</td>
				<td><input type="text" id="ngayhieuluc" value = ""/></td>
			</tr>
			<tr>
				<td>Ngày kết thúc</td>
				<td><input type="text" id="ngayketthuc" value = ""/></td>
			</tr>
			<tr>
				<td>Ngày nhập máy</td>
				<td><input type="text" id="ngaynhapmay" value = ""/></td>
			</tr>
			<tr>
				<td>Trích yếu</td>
				<td><textarea rows="5" cols="40" id="trichyeu"></textarea></td>
			</tr>
			<tr>
				<td>Từ khóa</td>
				<td><textarea rows="5" cols="40" id="tukhoa"></textarea></td>
			</tr>
			<tr>
				<td>Người ký</td>
				<td><input type="text" id="nguoiky" value = ""/></td>
			</tr>
			<tr>
				<td>Số trang</td>
				<td><input type="text" id="sotrang" value = ""/></td>
			</tr>
			<tr>
				<td>Cơ quan ban hành</td>
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
				<td>Vị trí lưu trữ</td>
				<td>
					<select id="vitriluutru">
	    			<c:forEach var="vitriluutru" items="${viTriLuuTruList}">
	    					<option value='<c:out value="${vitriluutru.getStt()}"/>'><c:out value="${vitriluutru.getViTri()}"/></option>
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
				<td>Cấp độ khẩn</td>
				<td>
					<select id="capdokhan">
	    			<c:forEach var="capdokhan" items="${capDoKhanList}">
	    					<option value='<c:out value="${capdokhan.getMaDoKhan()}"/>'><c:out value="${capdokhan.getTenDoKhan()}"/></option>
	    			</c:forEach>
	    		 </select>
				</td>
			</tr>
			<tr>
				<td>Cấp độ bảo mật</td>
				<td>
					<select id="capdobaomat">
	    			<c:forEach var="capdobaomat" items="${capDoBaoMatList}">
	    					<option value='<c:out value="${capdobaomat.getMaDoMat()}"/>'><c:out value="${capdobaomat.getTenDoMat()}"/></option>
	    			</c:forEach>
	    		 </select>
				</td>
			</tr>
			<tr>
				<td>Số hồ sơ</td>
				<td>
					<select id="sohoso">
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
				   			<td>Chưa xử lý<input type="radio" id="radio1" name="radio" value='1' checked="checked" /></td>
				   		</tr>
				   		<tr>
				   			<td>Đang xử lý<input type="radio" id="radio2" name="radio" value='2' /></td>
				   		</tr>
				   		<tr>
				   			<td>Hoàn thành<input type="radio" id="radio3" name="radio" value='3' /></td>
				   		</tr>
				   	</table>
				</td>
			</tr>
		</table>
	</form>
</div>

<div id="dialog-dinhkem" title="Đính kèm tập tin" >
	<form:form method="post" action="save.html" commandName="filedinhkem" enctype="multipart/form-data">
    <table>
    	<tr>
    		<td>Mã văn bản</td>
    		<td><input type="text" name="mavanban" id="mavanbandinhkem" readonly/></td>
    	</tr>
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
	    <tr>
	    	<td><input type="submit" value="Lưu"/></td>
	        <td>
	            
	        </td>
	    </tr>
	</table>  
</form:form>

</div>

<div id="dialog_error" title="Bạn chưa chọn văn bản cần xử lý">
<p><span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>Bạn chưa chọn công văn đến cần xử lý. Để chọn công văn,
 bạn hãy nhấp chuột vào công văn đó.</p>
</div>

<div id="dialog_chitietvanban" title="Chi tiết văn bản">
	<table>
			<tr>
				<td>Mã văn bản</td>
				<td><input type="text" id="mavanban1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Số đến</td>
				<td><input type="text" id="soden1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Ngày đến</td>
				<td><input type="text" id="ngayden1" value = "" readonly/></td>
			</tr>
			<tr>
				<td>Số và ký hiệu</td>
				<td><input type="text" id="sovakyhieu1" value = "" readonly/></td>
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
		
		<div id="show_filedinhkemList">
		
		</div>
</div>

</body>
</html>
