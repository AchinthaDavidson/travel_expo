
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Package Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
body {
	background-image:
		url("https://it21209352.github.io/css/pictures/back11.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	
}
</style>
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #ffc107">
			
			
			<div>
				<a href="" class="navbar-brand" > Package Management Application
				</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Packages</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
					<form action="insert" method="post">	

				<caption>
					<h2>
						
					
            			Add New Package
            	
					</h2>
				</caption>

				<c:if test="${pak != null}">
					<input type="hidden" name="id" value="<c:out value='${pak.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Package Name</label> <input type="text"
						value="<c:out value='${pak.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Locations</label> <input type="text"
						value="<c:out value='${pak.locations}' />" class="form-control"
						name="locations" required="required">
				</fieldset>

				<!-- <fieldset class="form-group">
					<label>Cost</label> <input type="text"
						value="<c:out value='${pak.cost}' />" class="form-control"
						name="cost">
				</fieldset> -->



				<button type="submit" class="btn btn-success">Save</button>
				</form>
			

			
			</div>

		</div>

	</div>
</html>
