<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Guide</title>
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
		<h2>Add New Guide</h2>
		<form class="" action="guideinsert" method="post" enctype='multipart/form-data'>
		
			Enter Guide Name<br> 
			<input type="text" class="text" name="name" value=""required><br>
			<br> Enter Guide location<br> 
			<input type="text" class="text" name="location" value="" required><br>
			<br> input contact<br> 
			<input type="text" class="text"pattern="[0-9]{10}" name="contact" value="" required><br>
			<br> input description<br>
			<textarea name="description" rows="8" cols="80" required></textarea>
			<br>
			<br>
			<!--<input type="text" name="description" value="">  -->
			Add Picture <br> 
			<label for="images" class="drop-container">
				<span class="drop-title">Drop files here</span> or 
				<input type="file" id="images" accept="image/*" value="img" name="img"  accept="image/*"required>
			</label> 
			<input type="submit" class="button1" name="" value="Insert">
		</form>
</body>
</html>