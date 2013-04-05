<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhập văn bản đến</title>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<style>
.ui-tooltip{
 border: 2px solid orange;
 padding: 15px 15px;
 }
 
 .error {
    background-color: #FFD9D9;
    border: 1px solid #F00;
  
}    
#accordion_body{
margin: 5px 0 0 50px;

}
</style>
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
		$("#ngayden").datepicker({
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
	   $("#ngayden").focus(function(){
		   $("#ngayden").datepicker('setDate', new Date());
		   
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

<script type="text/javascript">
		$(document).ready(function(){
			$('#themcongvan').click(function(){
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
				
				if($('#ngayden').val().length===0){
					alert("Bạn phải nhập Ngày văn bản đến");
				}
				else if($('#sovakyhieu').val().length===0){
					alert("Bạn phải nhập số và ký hiệu của văn bản");
				}
				else if($('#ngaybanhanh').val().length===0){
					alert("Bạn phải nhập ngày ban hành văn bản");
				}
				else if($('#ngayhieuluc').val().length===0){
					alert("Bạn phải nhập ngày văn bản có hiệu lực");
				}
				else if($('#ngayketthuc').val().length===0){
					alert("Bạn phải nhập ngày văn bản hết hiệu lực");
				}
				else if($('#ngaynhapmay').val().length===0){
					alert("Bạn phải nhập ngày văn bản được lưu trữ vào cơ sở dữ liệu");
				}
				else if($('#trichyeu').val().length===0){
					alert("Bạn phải nhập ngày trích yếu văn bản");
				}
				else if($('#tukhoa').val().length===0){
					alert("Bạn phải nhập từ khóa của văn bản");
				}
				else if($('#nguoiky').val().length===0){
					alert("Bạn phải nhập người ký văn bản");
				}
				else if($('#sotrang').val().length===0){
					alert("Bạn phải nhập số trang của văn bản");
				}
				else{
					 $.ajax({
							url: '/LuanVanTotNghiep/service/saveVanBanDen/' + soden + '/' + ngayden + '/' +
							coquanbanhanh + '/' + sovakyhieu + '/' + ngaybanhanh + '/' + ngayhieuluc + '/' +
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
</head>

<body>
<div id="nhapvanbanden">
	<h3 class="title">Nhập công văn đến</h3>
	<!-- <a href="/LuanVanTotNghiep/service/showvanbanden">Đính kèm văn bản</a>  -->
	<div id="accordion_body">
	<form action="" method="post">
	
			<div id="aligned">
				<h3>Số Đến:</h3>
				<input type="text" placeholder = "Số Đến" id="soden" title="Số đến là số thứ tự công văn đến đơn vị." value = "${maxsoden + 1}" class="txtinput" readonly/>
				
				<h3>Ngày đến:</h3>
				<input type="text" placeholder ="Ngày Đến" id="ngayden" class="txtinput" 
				title="Ngày công văn đến mặc định theo ngày hiện tại, nếu cần chọn công văn theo ngày
				 khác ngày hiện tại, hãy click vào lịch và chọn ngày cần nhập."/>	
			
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
				để nhập bổ sung Loại văn bản trước khi nhập văn bản có liên quan đến Loại văn bản này">
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
				title="Mỗi hồ sơ sẽ có một số hồ sơ, mỗi hồ sơ sẽ lưu trữ các văn bản có đặc điểm liên quan đến nhau cần phải lưu trữ trong cùng một hồ sơ.">
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