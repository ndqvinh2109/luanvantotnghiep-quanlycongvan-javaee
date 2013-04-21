<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/LuanVanTotNghiep/css/jquery.treeview.css">
<script src="/LuanVanTotNghiep/js/jquery-1.9.0.js"></script>
<script src="/LuanVanTotNghiep/js/jquery-ui.js"></script>
<script src="/LuanVanTotNghiep/js/jquery.treeview.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#tree").treeview({
		collapsed: true,
		animated: "fast",
		control:"#sidetreecontrol",
		prerendered: true,
		persist: "location"
	});
	});
</script>
</head>
<body>
<div class="treeheader">&nbsp;</div>
<div id="sidetreecontrol"> <a href="?#">Collapse All</a> | <a href="?#">Expand All</a> </div>
<ul class="treeview" id="tree">
<li class="expandable"><div class="hitarea expandable-hitarea"></div><img src="/LuanVanTotNghiep/css/images/folder.gif" /> Link 1
<ul>
<li>Sub link 1</li>
<li>Sub link 2</li>
<li>Sub link 3</li>
<li>Sub link 4</li>
<li>Sub link 5</li>
</ul>
</li>
<li class="expandable"><div class="hitarea expandable-hitarea"></div><img src="/LuanVanTotNghiep/css/images/folder.gif" /> Link 2
<ul>
<li>Sub link 1</li>
<li>Sub link 2</li>
<li>Sub link 3</li>
<li>Sub link 4</li>
<li>Sub link 5</li>
</ul>
</li>
<li class="expandable"><div class="hitarea expandable-hitarea"></div><img src="/LuanVanTotNghiep/css/images/folder.gif" /> Link 3
<ul>
<li>Sub link 1</li>
<li>Sub link 2</li>
<li>Sub link 3</li>
<li>Sub link 4</li>
<li>Sub link 5</li>
</ul>
</li>
<li class="expandable"><div class="hitarea expandable-hitarea"></div><img src="/LuanVanTotNghiep/css/images/folder.gif" /> Link 4
<ul>
<li>Sub link 1</li>
<li>Sub link 2</li>
<li>Sub link 3</li>
<li>Sub link 4</li>
<li>Sub link 5</li>
</ul>
</li>
<li class="expandable"><div class="hitarea expandable-hitarea"></div><img src="/LuanVanTotNghiep/css/images/folder.gif" /> Link 5
<ul>
<li>Sub link 1</li>
<li>Sub link 2</li>
<li>Sub link 3</li>
<li>Sub link 4</li>
<li>Sub link 5</li>
</ul>
</li>
</ul>


</body>
</html>