<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://it21209352.github.io/css/register.css">
<title>register</title>
</head>
<body>
	<div class="split-screen">
		<div class="split-left">
			<section class="cpy">
				<h1>
					Travel far enough, <br>You meet Yourself
				</h1>
				<p>Visit Sri Lanka</p>
			</section>
		</div>
		<div class="split-right">
			<form action="RegisterServlet" method="post">
				<section class="cpy">
					<h2>SIGNUP</h2>
					<div class="sign-in">
						<p>
							Already have an Account ? <a href="Login.jsp"><Strong>Sign
									In</Strong></a>
						</p>
					</div>
				</section>

				<div class="con-name">
					<label for="name">Name</label> <input id="nme" type="text"
						name="Name" placeholder="Enter your Name" required>
				</div>

				<div class="con-email">
					<label for="email">Email</label> <input id="emil" type="email"
						name="Email" placeholder="Enter your Email" required>
				</div>

				<div class="con-tel">
					<label for="telphone">Telephone</label> <input id="TP" type="text"
						name="Mobile" placeholder="Enter your mobile number" required>
				</div>

				<div class="con-password">
					<label for="password"> Create Password</label> <input id="pwd"
						type="password" name="psw" placeholder="Enter Password"
						pattern="(?-.*\d)(?-.*[a-z])(?-.*[A-Z]).{8,}" required> <i
						class="far fa-eye-slash"></i>
				</div>
				
				<div class="con-password">
					<label for="password"> Re-Enter Password</label> <input id="rpwd"
						type="password" name="psw" placeholder="Enter Password"
						pattern="(?-.*\d)(?-.*[a-z])(?-.*[A-Z]).{8,}" required onkeyup='check();'> <i
						class="far fa-eye-slash"></i>
						  <span id = "message2" style="color:red"> </span>
				</div>
				

				<section class="copy legal">
					<p>
						<span class="small">Agree to accept our <a href="#">Privacy
								Policy</a> &amp; <a href="#">Terms and Conditions</a></span>
					</p>
				</section>
				<br>

				<button class="log-btn" type="submit"  id="submit" disabled>SIGN UP</button>
			</form>
		</div>
		<script>
		function check(){
			if(document.getElementById("pwd").value !=
			document.getElementById("rpwd").value)
			{
				      document.getElementById("message2").innerHTML = "**Passwords are not same";
				      return false;
				    }
				else{
					document.getElementById("message2").innerHTML = " ";
					document.getElementById("submit").disabled=false;
				}
			}
		</script>
</body>
</html>