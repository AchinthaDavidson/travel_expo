<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
<title>display data from the table using jsp</title>
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
</head>
<body background="https://it21209352.github.io/css/pictures/background.jpg">
	<div class="data">
		<br> <img
			src="https://it21209352.github.io/css/pictures/logo.png" height="80"
			width="100" alt=""> <label class="logo">Travel Expo</label>
		<hr class="line" align="left">
		<h2>Update details</h2>
		<form class="" action="deleteplace" method="post">
			<select class="select" name="isTitles" id="isTitles">


				<%@ page import="com.packagemanager.dao.OOP_PackageDao"%>
				<%
				try {

					OOP_PackageDao newConObj = new OOP_PackageDao();

					Connection connection = null;

					Statement statement = null;

					ResultSet rs = null;

					Class.forName("com.mysql.jdbc.Driver");

					connection = DriverManager.getConnection(newConObj.getJdbcURL(), newConObj.getJdbcUsername(),
					newConObj.getJdbcPassword());

					statement = connection.createStatement();

					String QueryString = "SELECT * from place";
					rs = statement.executeQuery(QueryString);
				%>

				<%
				while (rs.next()) {
				%>
				<option class="dropdown" value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>



				<%
				}
				%>
				<%
				// close all the connections.
				rs.close();
				statement.close();
				connection.close();
				} catch (Exception ex) {

				out.println("Unable to connect to database.");
				}
				%>

			</select><br> <input class="button1" type="submit" value="Delete">
		</form>
</body>
</html>
