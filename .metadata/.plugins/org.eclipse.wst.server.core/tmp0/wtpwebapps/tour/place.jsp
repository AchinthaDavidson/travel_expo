 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stlesheet" href="">
<title>show places</title>
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
	text-align:left;
}

.table1 {
	border-spacing: 1;
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
</style>


</head>
<body  background="https://it21209352.github.io/css/pictures/background.jpg">
	 <div class="data">

		<p style="text-align: center; font-size: 30px;">place</p>

		<table height="80%" width="100%" class="table1">
			<c:forEach var="s" items="${showDetails}">

				<c:set var="name" value="${s.name}" />
				<c:set var="image" value="${s.img}" />
				<c:set var="desc" value="${s.description}" />
				<c:set var="location" value="${s.location}" />

				<tr height=40px>
					<td colspan="2" >${s.name}</td>
				</tr>
				<tr>
					
					<td><img src="https://wijethungaia.github.io/travelexpo.github.io/Place/${s.img}" height=200px width=200px alt=""></td>
					
					
					
					<td><p>Destination :${s.location}</p>${s.description}</td>
				</tr>


			</c:forEach>
		</table>

	</div>  
</body>
</html>
