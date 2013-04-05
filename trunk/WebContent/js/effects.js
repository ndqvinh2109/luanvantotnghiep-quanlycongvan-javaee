$(document).ready(function(){
	/* Slide Bar Navigation */
	$(function() {
		$('#navigation a').stop().animate({'marginLeft':'-85px'}, 1000);

		$('#navigation > li').hover(
			function() {
				$('a',$(this)).stop().animate({'marginLeft':'-2px'}, 200);
			},
			function(){
				$('a',$(this)).stop().animate({'marginLeft':'-85px'}, 200);
			}
		);
	});
	
	/* Show Hide Slide Bar */
	
	
	$("#navigation .showmenu").click(function() {
		$("#left").toggle("slide", { direction: "left" }, 2);
		if ($("#content").css("width") == "774px") {
			$("#content").width(1024);
		} else {
			$("#content").width(774);
		}
		return false;
	});
	
});