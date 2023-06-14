<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://it21209352.github.io/css/updateprofile.css">
<meta charset="ISO-8859-1">
<title>update profile</title>
</head>
<body>

	<!-- java code  -->
	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password= request.getParameter("pw");
	%>

	<div class='popup'>
		<div class='content'>
			<div class="details">

				<header>
					<p style="text-align: center; font-size: 20px;">Update your
						Details</p>
				</header>

				<form action= "updateServlet" method="post">
					<table class="t1">
						<tr>
							<td>Customer ID</td>
							<td><input type="text" name="cusid" value="<%= id %>"
								readonly></td>
						</tr>
						<tr>
							<td>Name</td>
							<td><input type="text" name="name" value="<%= name %>"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" name="Email" value="<%= email %>"></td>
						</tr>
						<tr>
							<td>Phone number</td>
							<td><input type="text" name="mobile" value="<%= phone %>"></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="text" name="password"
								value="<%= password %>"></td>
						</tr>
					</table>
					<input class="delt" type="submit" name="submit"
						value="update Account">
				</form>

			</div>
		</div>
	</div>
</body>
</html>