<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="login.css">
<!-- <link href="login.css" rel="stylesheet" type="text/css"> 
		 -->

<link href="https://it21209352.github.io/css/login.css" rel="stylesheet">

<title>login</title>
</head>
<body  background="https://it21209352.github.io/css/pictures/background.jpg">
	<div class="split-screen">
		<div class="split-left">
			<section class="cpy">
				<h1>Explore Your Places</h1>
				<p>Visit Sri Lanka</p>
			</section>
		</div>
		<div class="split-right">
			<!-- LoginServlet -->
			<!--  <form action="log" method="post"> -->
			<form action="LoginServlet" method="post">

				<section class="cpy">
					<h2>SIGN IN</h2>
					<div class="sign-in">
						<p>
							Don't have an Account ? <a href="register.jsp"><Strong>SignUp
									Now</Strong></a>
						</p>
					</div>
				</section>

				<div class="con-email">
					<label for="email">Email</label> <input id="emil" type="email"
						name="Email" placeholder="Enter your Email" required>
				</div>

				<div class="con-password">
					<label for="password">Password</label> <input id="pwd"
						type="password" name="Pw" placeholder="Enter Password"
						pattern="(?-.*\d)(?-.*[a-z])(?-.*[A-Z]).{8,}" required> <i
						class="far fa-eye-slash"></i>
				</div>
				<br>

				<button class="log-btn" type="submit">LOGIN</button>
				<br>
			</form>
		</div>
</body>
</html>