<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://it21209352.github.io/css/profile.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>user profile</title>
</head>
<body>
	<div class='popup'>
		<div class='content'>
			<div class="details">

				<header>
					<p style="text-align: center; font-size: 30px;">User Account</p>
				</header>

				<div>
					<center>
						<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
							class="avatar img-circle img-thumbnail" alt="avatar">
							
							 <a href="backtohomemethod">back to home</a>
					</center>
				</div>

				<p style="text-align: center; font-size: 20px;">
					<b>Personal Details</b>
					
					
				</p>

				<table class="t1" align="left">
					<c:forEach var="cus" items="${cusDetails}">

						<c:set var="id" value="${cus.id}" />
						<c:set var="name" value="${cus.name}" />
						<c:set var="email" value="${cus.email}" />
						<c:set var="phone" value="${cus.phone}" />
						<c:set var="password" value="${cus.password}" />

						<tr>
							<td>MY ID</td>
							<td>${cus.id}</td>
						</tr>
						<tr>
							<td>MY NAME</td>
							<td>${cus.name}</td>
						</tr>
						<tr>
							<td>MY EMAIL</td>
							<td>${cus.email}</td>
						</tr>
						<tr>
							<td>MY PHONE</td>
							<td>${cus.phone}</td>
						</tr>
						<tr>
							<td>MY PASSWORD</td>
							<td>${cus.password}</td>
						</tr>

					</c:forEach>
				</table>
				<!-- update -->
				<c:url value="updatedetails.jsp" var="cusUpdate">
					<c:param name="id" value="${id}" />
					<c:param name="name" value="${name}" />
					<c:param name="email" value="${email}" />
					<c:param name="phone" value="${phone}" />
					<c:param name="pw" value="${password}" />
				</c:url>

				<br> <a href="${cusUpdate}">
				<input class="delt"type="submit" name="update" value="Update detalis"></a><br>
				<br>

				<!-- delete -->
				<c:url value="deletedetail.jsp" var="cusDelete">
					<c:param name="id" value="${id}" />
					<c:param name="name" value="${name}" />
					<c:param name="email" value="${email}" />
					<c:param name="phone" value="${phone}" />
					<c:param name="pw" value="${password}" />
				</c:url>

				<a href="${cusDelete}">
				<input class="delt" type="submit" name="delete" value="Delete account"></a>
				<%-- 
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
						New Package</a> --%>

			</div>
		</div>
	</div>
</body>

</html>