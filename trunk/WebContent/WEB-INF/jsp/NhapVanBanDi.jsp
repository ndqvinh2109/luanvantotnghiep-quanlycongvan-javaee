<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
.ui-tooltip{
 border: 2px solid orange;
 padding: 15px 15px;
 }
 
 .error {
    background-color: #FFD9D9;
    border: 1px solid #F00;
  
}    
#nhapvanbandi textarea {
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
margin-bottom: 15px;
font-size: 1.5em;
padding: 11px 25px;
padding-left: 55px;
width: 90%;
height: 100px;
color: #777;
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset;
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset; 
transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-webkit-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-moz-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
-o-transition: border 0.15s linear 0s, box-shadow 0.15s linear 0s, color 0.15s linear 0s;
}

#nhapvanbandi textarea:focus {
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(40, 90, 160, 0.6);
outline: 0 none; 
}

#nhapvanbandi textarea#trichyeu {
background: #fff url('/LuanVanTotNghiep/images/speech.png') 5px 4px no-repeat;
}


#nhapvanbandi textarea#tukhoa {
background: #fff url('/LuanVanTotNghiep/images/speech.png') 5px 4px no-repeat;
}

#nhapvanbandi .txtinput { 
display: block;
font-family: "Helvetica Neue", Arial, sans-serif;
border-style: solid;
border-width: 1px;
border-color: #dedede;
margin-bottom: 20px;
font-size: 1.1em;
padding:11px 20px;
padding-left: 55px;
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

#nhapvanbandi .txtinput:focus { 
color: #333;
border-color: rgba(41, 92, 161, 0.4);
box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-moz-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1) inset, 0 0 8px rgba(41, 92, 161, 0.6);
outline: 0 none; 
}

#nhapvanbandi #aligned { 
box-sizing: border-box; 
float: left; 
width: 400px; 
margin-right: 50px;
margin-top:5px;
margin-bottom: 50px;
}

#nhapvanbandi #aside {
	float: left;
	width: 200px;
	box-sizing: border-box;
	margin-top:5px;
	
}

#nhapvanbandi select.selmenu {
font-size: 17px;
color: #676767;
padding: 6px !important;
border: 1px solid #aaa;
width: 200px;
}

#nhapvanbandi #aside h3{
	padding:7px 0px 10px 0px;
	color: #363636;
	font-family: "Droid Serif", Georgia, serif; 
	margin-top: 10px; 
	margin-bottom: 10px;
	padding: 12px 0; 
 
}

#nhapvanbandi #aligned h3{
	padding:0px 0px 7px 0px;
	color: #363636;
	font-family: "Droid Serif", Georgia, serif; 
	margin-top: 10px; 
	margin-bottom: 10px;
	width:90%;
}

#trangthaixuly .ttxl{
	
	display: block; margin-bottom: 8px;
}

#trangthaixuly .ttxl label{
	
	font-size: 1.2em; padding-bottom: 4px;
}

div#nhapvanbandi .title{
  	background: url(/LuanVanTotNghiep/images/titlebg.jpg) center left repeat-x;
	height: 14px;
	color: white;
	font-family: Arial,Verdana,Sans-serif;
	font-size: 14px;
	font-weight: bold;
	padding: 10px 20px;
	margin: 0px auto 0px;
  }
 
div#nhapvanbandi input#ngaybanhanh {
background: #fff url('/LuanVanTotNghiep/images/calendar.png') 4px 5px no-repeat;
}
div#nhapvanbandi input#ngaydi {
background: #fff url('/LuanVanTotNghiep/images/calendar.png') 4px 5px no-repeat;
}

div#nhapvanbandi input#ngayhieuluc {
background: #fff url('/LuanVanTotNghiep/images/calendar.png') 4px 5px no-repeat;
}

div#nhapvanbandi input#ngayketthuc {
background: #fff url('/LuanVanTotNghiep/images/calendar.png') 4px 5px no-repeat;
}

div#nhapvanbandi input#ngaynhapmay {
background: #fff url('/LuanVanTotNghiep/images/calendar.png') 4px 5px no-repeat;
}

div#nhapvanbandi input#nguoiky {
background: #fff url('/LuanVanTotNghiep/images/user.png') 4px 5px no-repeat;
}

div#nhapvanbandi input#sotrang {
background: #fff url('/LuanVanTotNghiep/images/pad.png') 4px 5px no-repeat;
}

div#nhapvanbandi input#sodi {
background: #fff url('/LuanVanTotNghiep/images/input-tablet.png') 4px 5px no-repeat;
}

div#nhapvanbandi input#sovakyhieu {
background: #fff url('/LuanVanTotNghiep/images/input-tablet.png') 4px 5px no-repeat;
}


div#nhapvanbandi #buttons { display: block; padding-top: 10px; overflow: hidden; clear:both; margin:0 0 20px 230px;}

div#nhapvanbandi #buttons #themcongvan {
display: block;
float: left;
height: 3em;
padding: 0 1em;
border: 1px solid;
outline: 0;
font-weight: bold;
font-size: 1.3em;
color:  #fff;
text-shadow: 0px 1px 0px #222;
white-space: nowrap;
word-wrap: normal;
vertical-align: middle;
cursor: pointer;
-moz-border-radius: 2px;
-webkit-border-radius: 2px;
border-radius: 2px;
border-color: #5e890a #5e890a #000;
-moz-box-shadow: inset 0 1px 0 rgba(256,256,256, .35);
-ms-box-shadow: inset 0 1px 0 rgba(256,256,256, .35);
-webkit-box-shadow: inset 0 1px 0 rgba(256,256,256, .35);
box-shadow: inset 0 1px 0 rgba(256,256,256, .35);
background-color: rgb(226,238,175);
background-image: -moz-linear-gradient(top, rgb(226,238,175) 3%, rgb(188,216,77) 3%, rgb(144,176,38) 100%);
background-image: -webkit-gradient(linear, left top, left bottom, color-stop(3%,rgb(226,238,175)), color-stop(3%,rgb(188,216,77)), color-stop(100%,rgb(144,176,38))); 
background-image: -webkit-linear-gradient(top, rgb(226,238,175) 3%,rgb(188,216,77) 3%,rgb(144,176,38) 100%);
background-image: -o-linear-gradient(top, rgb(226,238,175) 3%,rgb(188,216,77) 3%,rgb(144,176,38) 100%);
background-image: -ms-linear-gradient(top, rgb(226,238,175) 3%,rgb(188,216,77) 3%,rgb(144,176,38) 100%);
background-image: linear-gradient(top, rgb(226,238,175) 3%,rgb(188,216,77) 3%,rgb(144,176,38) 100%); 
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2eeaf', endColorstr='#90b026',GradientType=0 );
}

div#nhapvanbandi #buttons #themcongvan:hover, div#nhapvanbandi #buttons #themcongvan:active {
border-color: #7c9826 #7c9826 #000;
color: #fff;
-moz-box-shadow: inset 0 1px 0 rgba(256,256,256,0.4),0 1px 3px rgba(0,0,0,0.5);
-ms-box-shadow: inset 0 1px 0 rgba(256,256,256,0.4),0 1px 3px rgba(0,0,0,0.5);
-webkit-box-shadow: inset 0 1px 0 rgba(256,256,256,0.4),0 1px 3px rgba(0,0,0,0.5);
box-shadow: inset 0 1px 0 rgba(256,256,256,0.4),0 1px 3px rgba(0,0,0,0.5);
background: rgb(228,237,189);
background: -moz-linear-gradient(top, rgb(228,237,189) 2%, rgb(207,219,120) 3%, rgb(149,175,54) 100%); 
background: -webkit-gradient(linear, left top, left bottom, color-stop(2%,rgb(228,237,189)), color-stop(3%,rgb(207,219,120)), color-stop(100%,rgb(149,175,54))); 
background: -webkit-linear-gradient(top, rgb(228,237,189) 2%,rgb(207,219,120) 3%,rgb(149,175,54) 100%); 
background: -o-linear-gradient(top, rgb(228,237,189) 2%,rgb(207,219,120) 3%,rgb(149,175,54) 100%); background: -ms-linear-gradient(top, rgb(228,237,189) 2%,rgb(207,219,120) 3%,rgb(149,175,54) 100%); background: linear-gradient(top, rgb(228,237,189) 2%,rgb(207,219,120) 3%,rgb(149,175,54) 100%); 
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e4edbd', endColorstr='#95af36',GradientType=0 );
}

div#nhapvanbandi #buttons #huynhap{
	display: block;
float: left;
color: #515151;
text-shadow: -1px 1px 0px #fff;
margin-right: 20px;
height: 3em;
padding: 0 1em;
outline: 0;
font-weight: bold;
font-size: 1.3em;
white-space: nowrap;
word-wrap: normal;
vertical-align: middle;
cursor: pointer;
-moz-border-radius: 2px;
-webkit-border-radius: 2px;
border-radius: 2px;
background-color: #fff;
background-image: -moz-linear-gradient(top,  rgb(255,255,255) 2%, rgb(240,240,240) 2%, rgb(222,222,222) 100%);
background-image: -webkit-gradient(linear, left top, left bottom, color-stop(2%,rgb(255,255,255)), color-stop(2%,rgb(240,240,240)), color-stop(100%,rgb(222,222,222)));
background-image: -webkit-linear-gradient(top,  rgb(255,255,255) 2%,rgb(240,240,240) 2%,rgb(222,222,222) 100%);
background-image: -o-linear-gradient(top,  rgb(255,255,255) 2%,rgb(240,240,240) 2%,rgb(222,222,222) 100%);    background-image: -ms-linear-gradient(top,  rgb(255,255,255) 2%,rgb(240,240,240) 2%,rgb(222,222,222) 100%);
background-image: linear-gradient(top,  rgb(255,255,255) 2%,rgb(240,240,240) 2%,rgb(222,222,222) 100%); 
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#dedede',GradientType=0 );
border: 1px solid #969696;
box-shadow: 0 1px 2px rgba(144, 144, 144, 0.4);
-moz-box-shadow: 0 1px 2px rgba(144, 144, 144, 0.4);
-webkit-box-shadow: 0 1px 2px rgba(144, 144, 144, 0.4);
text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);
	
}
div#nhapvanbandi #buttons #huynhap:hover {
text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75);	
color: #818181;
background-color: #fff;
background-image: -moz-linear-gradient(top,  rgb(255,255,255) 2%, rgb(244,244,244) 2%, rgb(229,229,229) 100%);
background-image: -webkit-gradient(linear, left top, left bottom, color-stop(2%,rgb(255,255,255)), color-stop(2%,rgb(244,244,244)), color-stop(100%,rgb(229,229,229)));
background-image: -webkit-linear-gradient(top,  rgb(255,255,255) 2%,rgb(244,244,244) 2%,rgb(229,229,229) 100%);background-image: -o-linear-gradient(top,  rgb(255,255,255) 2%,rgb(244,244,244) 2%,rgb(229,229,229) 100%); background-image: -ms-linear-gradient(top,  rgb(255,255,255) 2%,rgb(244,244,244) 2%,rgb(229,229,229) 100%); background-image: linear-gradient(top,  rgb(255,255,255) 2%,rgb(244,244,244) 2%,rgb(229,229,229) 100%); 
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#e5e5e5',GradientType=0 );
border-color: #aeaeae;
box-shadow: inset 0 1px 0 rgba(256,256,256,0.4),0 1px 3px rgba(0,0,0,0.5);
}

#nhapvanbandi{
	background-color: #f7f7f7;
	overflow: hidden;
	border: 1px solid #c4c4c4;
	
}
#accordion_body{
margin: 5px 0 0 50px;

}
</style>
<script type="text/javascript">
		$(document).ready(function(){
			$( "#navbar" ).accordion({
			      collapsible: true,
			      heightStyle: "content",
			      active: 2
			    });
			$('#themcongvan').click(function(){
				/* var sodi = $('#sodi').val();
				var ngaydi=$('#ngaydi').val(); */
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
				
				/* if($('#ngaydi').val().length===0){
					alert("Bạn phải nhập Ngày văn bản đi");
				} */
				if($('#sovakyhieu').val().length===0){
					alert("Bạn phải nhập số và ký hiệu của văn bản");
					$('#sovakyhieu').focus();
				}
				else if($('#ngaybanhanh').val().length===0){
					alert("Bạn phải nhập ngày ban hành văn bản");
					$('#ngaybanhanh').focus();
				}
				else if($('#ngayhieuluc').val().length===0){
					alert("Bạn phải nhập ngày văn bản có hiệu lực");
					$('#ngayhieuluc').focus();
				}
				else if($('#ngayketthuc').val().length===0){
					alert("Bạn phải nhập ngày văn bản hết hiệu lực");
					$('#ngayketthuc').focus();
				}
				else if($('#ngaynhapmay').val().length===0){
					alert("Bạn phải nhập ngày văn bản được lưu trữ vào cơ sở dữ liệu");
					$('#ngaynhapmay').focus();
				}
				else if($('#trichyeu').val().length===0){
					alert("Bạn phải nhập ngày trích yếu văn bản");
					$('#trichyeu').focus();
				}
				else if($('#tukhoa').val().length===0){
					alert("Bạn phải nhập từ khóa của văn bản");
					$('#tukhoa').focus();
				}
				else if($('#nguoiky').val().length===0){
					alert("Bạn phải nhập người ký văn bản");
					$('#nguoiky').focus();
				}
				else if($('#sotrang').val().length===0){
					alert("Bạn phải nhập số trang của văn bản");
					$('#sotrang').focus();
				}
				else{
					 $.ajax({
							url: '/LuanVanTotNghiep/service/saveVanBanDi/' + coquanbanhanh + '/' + sovakyhieu + '/' + ngaybanhanh + '/' + ngayhieuluc + '/' +
							ngayketthuc + '/' + ngaynhapmay + '/' + loaivanban + '/' + vitriluutru + '/' + linhvuc + '/' + capdokhan +
							'/' + capdobaomat + '/' + sohoso + '/' + trangthaixuly + '/' + trichyeu + '/' +
							tukhoa + '/' + nguoiky + '/' + sotrang,
							type: "POST",
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
		});
		
</script>
<script type="text/javascript">
	$(function(){
		$("#ngaybanhanh").datepicker({
			  showAnim: 'clip',
		      dateFormat: 'yy-mm-dd'
		});
		
		$("#ngayhieuluc").datepicker({
			 showAnim: 'drop',
		      dateFormat: 'yy-mm-dd'
		});
		$("#ngayketthuc").datepicker({
			 showAnim: 'fold',
		      dateFormat: 'yy-mm-dd'
		});
		$("#ngaydi").datepicker({
			 showAnim: 'slide',
		      dateFormat: 'yy-mm-dd'
		}); 
		$("#ngaynhapmay").datepicker({
			 showAnim: 'slideDown',
		      dateFormat: 'yy-mm-dd'
		}); 
		$( "#sotrang" ).spinner({
			 spin: function( event, ui ) {
		         if ( ui.value < 1 ) {
		          $( this ).spinner( "value", 1 );
		          return false;
		        }
			 }
			
		});
		
	    
	    $(function() {
	        $( document ).tooltip({ track:true });
	      });
	   $("#ngaydi").focus(function(){
		   $("#ngaydi").datepicker('setDate', new Date());
		   
	   });
	   
	   $("#ngaybanhanh").focus(function(){
		   $("#ngaybanhanh").datepicker('setDate', new Date());
		 
	   });
	   
	   $("#ngayhieuluc").focus(function(){
		   var t = $('#ngaybanhanh').val();
	       var parseDate = $.datepicker.parseDate('yy-mm-dd', t);
	       $("#ngayhieuluc").datepicker('setDate', parseDate);
		   
	   });
	   
	   $("#ngaynhapmay").focus(function(){
		   $("#ngaynhapmay").datepicker('setDate', new Date());
		 
	   });
	   
	   
	});
	
</script>
</head>
<body>
<div id="nhapvanbandi">
	<h3 class="title">Nhập công văn đi</h3>
	<div id="accordion_body">
	<form action="" method="post">
			<div id="aligned">
				<%-- <h3>Số Đi:</h3>
				<input type="text" placeholder = "Số Đi" id="sodi" title="Số đi là số thứ tự công văn phát hành." value = "${maxSoDi + 1}" class="txtinput" readonly/>
				
				<h3>Ngày Đi:</h3>
				<input type="text" placeholder ="Ngày Đi" id="ngaydi" class="txtinput" 
				title="Ngày công văn đi mặc định theo ngày hiện tại, nếu cần chọn công văn theo ngày
				 khác ngày hiện tại, hãy click vào lịch và chọn ngày cần nhập."/>	 --%>
				<h3>Số và Ký Hiệu:</h3>
				<input type="text" placeholder ="Số và Ký Hiệu" id="sovakyhieu" class="txtinput" 
				title="Số ký hiệu văn bản không được để trống. Nếu văn bản không có số bạn hãy
				nhập một vài ký tự đại diện (VD: ABC, XYZ) thay thế."/>
				<h3>Ngày Ban Hành:</h3>
				<input type="text" placeholder ="Ngày Ban Hành" id="ngaybanhanh" class="txtinput"
				title="Ngày ban hành văn bản là ngày tháng năm ghi trên văn bản. Ngày này bắt buộc phải có. Mặc định
				theo ngày hiện tại, nếu cần chọn ngày khác, hãy click vào lịch và chọn ngày cần nhập." />
				<h3>Ngày Hiệu Lực:</h3>
				<input type="text" placeholder ="Ngày Hiệu Lực" id="ngayhieuluc" class="txtinput"
				title="Ngày hiệu lực của văn bản. Mặc định, Ngày hiệu lực = Ngày ban hành. Nếu ngày hiệu lực khác ngày ban hành
				thì bạn có thể sửa lại."/>
				<h3>Ngày Kết Thúc:</h3>
				<input type="text" placeholder ="Ngày Kết Thúc" id="ngayketthuc" class="txtinput"
				title = "Ngày văn bản hết hiệu lực."/>
				<h3>Ngày Nhập Máy:</h3>
				<input type="text" placeholder ="Ngày Nhập Máy" id="ngaynhapmay" class="txtinput"
				title="Ngày văn bản là ngày được văn thư nhập vào trong máy. Mặc định là ngày hiện tại." />
				<h3>Trích Yếu:</h3>
				<textarea rows="5" placeholder ="Trích Yếu" cols="40" id="trichyeu" class="txtinput" 
				title="Nội dung trích yếu văn bản có thể bỏ trống. Tuy nhiên, nếu không có trích yếu thì bạn
				cũng nên đọc qua nội dung văn bản xem nội dung là vấn đề gì rồi điền vào đây."></textarea>
				<h3>Từ Khóa Tra Cứu:</h3>
				<textarea rows="5" placeholder ="Từ Khóa" cols="40" id="tukhoa" class="txtinput"
				title="Từ khóa tra cứu là các từ viết tắt, cô đọng, đặc trưng nhằm giúp người tra cứu, tìm
				kiếm có thể tìm ra văn bản này."></textarea>
				<h3>Người Ký:</h3>
				<input type = "text" id="nguoiky" placeholder ="Người Ký" class="txtinput"
				title="Họ tên người ký công văn."/>
				
			</div>	
			<div id="aside">
				<h3>Cơ Quan Ban Hành:</h3>	
				<select id="coquanbanhanh" class="selmenu"
				title="Cơ quan ban hành văn bản lấy từ danh mục các Cơ quan ban hành văn bản. Nếu danh sách chưa có cơ quan ban hành thì
				hãy vào chức năng Quản trị danh mục để nhập Cơ quan văn bản trước khi nhập văn bản của cơ quan này.">
	    			<c:forEach var="donvi" items="${donViList}">
	    				<option value='<c:out value="${donvi.getMaDonVi()}"/>'><c:out value="${donvi.getTenDonVi()}"/></option>
	    			</c:forEach>
	    		 </select>
	    		 <h3>Loại Văn Bản:</h3>	
				<select id="loaivanban" class="selmenu"
				title="Loại văn bản lấy từ danh sách Loại văn bản. Nếu Loại văn bản chưa có trong danh sách thì hãy vào chức năng Quản trị danh mục
				để nhập bổ sung Loại văn bản trước khi nhập văn bản có liên quan đi Loại văn bản này">
	    			<c:forEach var="loaivanban" items="${loaiVanBanList}">
	    					<option value='<c:out value="${loaivanban.getMaLoaiVanBan()}"/>'><c:out value="${loaivanban.getTenLoaiVanBan()}"/></option>
	    			</c:forEach>
	    		</select>
	    		<h3>Vị Trí Lưu Trữ:</h3>	
				<select id="vitriluutru" class="selmenu"
				title="Vị trí nơi lưu trữ bản giấy của công văn." >
	    			<c:forEach var="vitriluutru" items="${viTriLuuTruList}">
	    					<option value='<c:out value="${vitriluutru.getStt()}"/>'><c:out value="${vitriluutru.getViTri()}"/></option>
	    			</c:forEach>
	    		 </select>
	    		 <h3>Lĩnh Vưc:</h3>	
				<select id="linhvuc" class="selmenu"
				title="Lĩnh vực liên quan là phân loại văn bản theo các nhóm chủ đề, lĩnh vực khác nhau, sẽ giúp kiểm soát văn bản có hệ thống, dễ tra cứu
				, phân loại." >
	    			<c:forEach var="linhvuc" items="${linhVucList}">
	    					<option value='<c:out value="${linhvuc.getMaLinhVuc()}"/>'><c:out value="${linhvuc.getTenLinhVuc()}"/></option>
	    			</c:forEach>
	    		 </select>
	    		 <h3>Cấp Độ Khẩn:</h3>	
				<select id="capdokhan" class="selmenu"
				title="Cấp độ khẩn của công văn thể hiện mức độ quan trọng của công văn." >
	    			<c:forEach var="capdokhan" items="${capDoKhanList}">
	    					<option value='<c:out value="${capdokhan.getMaDoKhan()}"/>'><c:out value="${capdokhan.getTenDoKhan()}"/></option>
	    			</c:forEach>
	    		 </select>
	    		 <h3>Cấp Độ Bảo Mật:</h3>	
				<select id="capdobaomat" class="selmenu"
				title="Cấp độ bảo mật nhằm phân loại hạn chế đối tượng truy cập
				vào các văn bản, tài liệu quan trọng.">
	    			<c:forEach var="capdobaomat" items="${capDoBaoMatList}">
	    					<option value='<c:out value="${capdobaomat.getMaDoMat()}"/>'><c:out value="${capdobaomat.getTenDoMat()}"/></option>
	    			</c:forEach>
	    		 </select>
	    		 <h3>Số Hồ Sơ:</h3>	
				<select id="sohoso" class="selmenu"
				title="Mỗi hồ sơ sẽ có một số hồ sơ, mỗi hồ sơ sẽ lưu trữ các văn bản có đặc điểm liên quan đi nhau cần phải lưu trữ trong cùng một hồ sơ.">
	    			<c:forEach var="sohoso" items="${hoSoLuuTruList}">
	    					<option value='<c:out value="${sohoso.getSoHoSo()}"/>'><c:out value="${sohoso.getTieuDeHoSo()}"/></option>
	    			</c:forEach>
	    		 </select>
	    			 <h3>Số Trang:</h3>
					<input type = "text" id="sotrang" placeholder ="Số Trang" class="txtinput"
					title="Số trang văn bản không được để trống." />
				  <div id="trangthaixuly" title="Là trạng thái xử lý của văn bản, mặc định khi nhập văn bản thì Trạng thái xử lý của văn bản là Chưa xử lý">
				  	<h3>Trạng Thái Xử Lý:</h3>
				  	<span class="ttxl">
				    <input type="radio" id="radio3" name="radio" value='1' checked="checked"  />
				   	<label for="radio3">Chưa xử lý</label>
				   	</span>
				  	<span class="ttxl">
				  	<input type="radio" id="radio1" name="radio" value='2'/>
				   	<label for="radio1">Đang xử lý</label>
				   	</span>	
				    <span class="ttxl">
				    <input type="radio" id="radio2" name="radio" value='3' />
				  	<label for="radio2">Hoàn thành</label>
				    </span>
				    
				   
  				  </div>
			</div>	
			
			<div id="buttons">
			<input type="submit" id="themcongvan" value="Ghi nhận" title="Bấm nút [Ghi nhận] để thực hiện ghi thông tin vào cơ sở dữ liệu."/>
			<input type="reset" id="huynhap" value="Xóa trắng"  />
			</div>
			
			
			
	</form>
	</div>
</div>


</body>
</html>