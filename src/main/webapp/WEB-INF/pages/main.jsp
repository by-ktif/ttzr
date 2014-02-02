<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>Co sie dzieje!</title>
	<link rel="stylesheet" href="css/main.css" type="text/css">
	<link rel="stylesheet" href="css/colorbox.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/jquery.colorbox.js"></script>
	<script src="js/ttlz.js"></script>
	<script>
		$(document).ready(function(){
			$(".inline").colorbox({inline:true, width:"50%"});
			populateTable(${msgUsers}, ${msgGamesBets});
		});
	</script>
</head>
<body>
<div class="MainTable">
<table id="ttlz-main-table"><tbody/></table>
</div>

<p><a class='inline' href="#inline_content">Inline HTML</a></p>
<div style='display:none'>
	<div id='inline_content' style='padding:10px; background:#fff;'>
		Предыдущие матчи:
		<div class="MainTable" style="width:100%">
		<table>
			<tr>
				<td>Матч</td>
				<td><div><div class="User">Оля</div><div class="Total">0</div></div></td>
				<td><div><div class="User">Леша</div><div class="Total">0</div></div></td>
				<td><div><div class="User">Катя</div><div class="Total">0</div></div></td>
				<td><div><div class="User">Игорь</div><div class="Total">0</div></div></td>
				<td>Резальтат</td>
			</tr>
			<tr>
				<td>Аргентина - Ямайка</td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td>1:1</td>
			</tr>
			<tr>
				<td>Аргентина - Ямайка</td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td>1:1</td>
			</tr>
			<tr>
				<td>Аргентина - Ямайка</td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td><div><div class="User">1:1</div><div class="Total">2</div></div></td>
				<td></td>
			</tr>
		</table>
		</div>
	</div>
</div>

</body>
</html>