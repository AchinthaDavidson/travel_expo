<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="">
<title>show guide</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Audiowide">
<link
	href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://it21209352.github.io/css/admin.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@600&display=swap"
	rel="stylesheet">

<style media="screen">
body {
	margin-left: 5%;
	margin-right: 5%;
	margin-top: 5%;
	background-position: center center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	color: white;
	font-family: 'Josefin Sans', sans-serif;
}

.tb_cart {
	border-spacing: 0 15px;
}

tr {
	background-color: black;
	opacity: 0.7;
}

td {
	text-align: left;
	padding:10px;
	
}

.table1 {
	border-spacing: 0;
}

#id1 {
	height: 50px;
}

#id2 {
	height: 50px;
}

#id03 {
	font-size: 20px;
}

#pay {
	background-color: #18b527;
	color: white;
	border: none;
	border-radius: 5px;
	height: 40px;
	font-size: 18px;
}
.data{
padding-top:5%;
}
</style>


</head>
<body background="https://it21209352.github.io/css/pictures/background.jpg">
	<div class="data">
		<table width=100%>
			<c:forEach var="s" items="${showDetails}">

				<c:set var="name" value="${s.name}" />
				<c:set var="image" value="${s.img}" />
				<c:set var="desc" value="${s.description}" />
				<c:set var="location" value="${s.location}" />
				<c:set var="contact" value="${s.contact}" />

				<tr><td width=22%><img src="https://wijethungaia.github.io/travelexpo.github.io/Guide/${s.img}" height="200" width="200"></td>
					<td>Name : ${s.name} <br>Location :
						${s.location}<br> Contact  : ${s.contact}<br><br>
						${s.description}
					</td>
				</tr>
				<tr></tr>
			</c:forEach>
		</table>
		
</body>
</html>
