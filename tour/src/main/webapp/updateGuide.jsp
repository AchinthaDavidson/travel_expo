<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
<title>updateGuide</title>
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

		<h2>Update guide</h2>
		<form class="" action="Guideupdate" method="post"
			enctype='multipart/form-data'>
			<select class="text" name="isTitles" id="isTitles">
				<%@ page import="com.packagemanager.dao.OOP_PackageDao"%>
				<%
	try {
	
		OOP_PackageDao newConObj = new OOP_PackageDao();
	
		Connection connection = null;
		
		Statement statement = null;

		ResultSet rs = null;
			
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection(newConObj.getJdbcURL(), newConObj.getJdbcUsername(), newConObj.getJdbcPassword());
		
	statement = connection.createStatement();
	
	String QueryString = "SELECT * from guide";
	rs = statement.executeQuery(QueryString);
	%>

				<%
	while (rs.next()) {
	%>
				<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>



				<% } %>
				<%
	// close all the connections.
	rs.close();
	statement.close();
	connection.close();
	} catch (Exception ex) {
	
	out.println("Unable to connect to database.");
	}
	%>

			</select><br>
			<br> Enter New Guide Name<br> 
			<input type="text" class="text" name="name" value="" required><br>
			<br> Enter new Guide location<br> 
			<input type="text" class="text" name="location" value="" required><br>
			<br> input contact<br>
			 <input type="text" class="text" pattern="[0-9]{10}" name="contact" value="" required><br>
			<br> input description<br>
			<textarea name="description" rows="8" cols="80" required></textarea>
			<br>
			<br>
			<%-- <input type="text" name="description" value=""> --%>
			Insert Picture<br> 
			<label for="images" class="drop-container">
				<span class="drop-title">Drop files here</span> or 
				<input type="file" id="images" accept="image/*" name="img" value="img" accept="image/*" required>
			</label><br>

			<%-- input Image
	      <input type="file" name="img"  value=""> --%>
			<input type="submit" class="button1" name="" value="Update">
		</form>
</body>
</html>
