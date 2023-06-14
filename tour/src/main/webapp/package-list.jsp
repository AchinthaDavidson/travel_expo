
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Package Management Application</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- <img src="https://it21209352.github.io/css/pictures/roo4.jpg" alt="Mountains" style="width:100%" z-index="0">
 -->


<style>
body {
	background-image:
		url("https://it21209352.github.io/css/pictures/back10.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	color: #ffffff
}
</style>

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #6f42c1">
			<p class="navbar-brand">Package Management Application</p>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Refresh</a></li>

				<li><a href="home.jsp" class="nav-link">Home</a></li>

			</ul>
		</nav>
	</header>
	<br>

	<div class="row">


		<div class="container">
			<div class="backcover"
				style="background-color: rgb(0, 0, 0, 0.5); margin: auto; color: #f1f1f1;">
				<h3 class="text-center">List of Packages</h3>

				<hr>
				<div class="container text-left">

					<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
						New Package</a>
				</div>
				<br>



				<table class="table" style="color: #f8f9fa;">
					<!--<table class="table table-bordered">  -->
					<thead>
						<tr>
							<!-- <th>ID</th> -->
							<th>Package Name</th>
							<th>Locations</th>
							<th>Cost</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>


						<c:forEach var="pak" items="${listPackage}">

							<tr>
								<!--  <td><c:out value="${pak.id}" /></td>-->
								<td><c:out value="${pak.name}" /></td>
								<td><c:out value="${pak.locations}" /></td>

								<td><c:out value="${pak.cost}" /></td>

								<!-- if condtion to check ptype -->
								<td><c:set var="ptype" value="${pak.ptype}" /> <c:if
										test="${ptype == 0}">

										<a href="edit?id=<c:out value='${pak.id}' />">Edit</a>
									
									&nbsp;&nbsp;&nbsp;&nbsp; 
	
									<a href="delete?id=<c:out value='${pak.id}' />">Delete</a>

									</c:if> <!--end od the  if condtion to check ptype --></td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>
		</div>
	</div>

</body>
</html>

