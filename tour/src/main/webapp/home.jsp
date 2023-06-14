<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Lobster+Two:ital@1&display=swap"
	rel="stylesheet">

<link href="https://wijethungaia.github.io/travelexpo.github.io/CSS/home.css" rel="stylesheet">


<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>


<%--  
	<c:forEach var="cus" items="${cusDetails}">
		<form action="home" method="post">
			<input type="hidden" name="Email" value="${cus.email}"> <input
				type="submit" value="account details">
		</form>
	</c:forEach>
 --%>
	<!-- top topic -->
	<div class="image">
  <div class="topic">
    <center>
      <img src="https://it21209352.github.io/css/pictures/logo.png" width="90" height="80" style="margin-top:-1;">
      <label>Traval Expo</label>
  </div>
  <div class="topic1">
    <h1 style="font-size:100px;font-family: 'Lobster Two', cursive;">
   <span>Discover</span>
              <span>Story-worthy </span>
              <span>travel moments</span>

    </h1>
  </div>
  <div class="login">
    <!-- <button type="button" name="button">Login</button> -->
    <div class="dropdown">
      <img class="" style="margin-left: 50px;"
        src="https://it21209352.github.io/css/pictures/user.png" alt="logo"
        height="60" width="60">

      <div class="dropdown-content">
        <a href="homeservlet">Account</a>
        
        <a href="AboutUs.html">About us</a>
        <a href="logout">LOGOUT</a>

      </div>
    </div>
  </div>
  <img src="https://wijethungaia.github.io/travelexpo.github.io/Place/home.jpg" alt="" class="image1"></center>
  
</div>
	





		<!-- MAIN (Center website) -->



		<!-- catogaries -->
		<div class="Cateories">
			​
			<div class="row1">
				<div class="column1">
					<a href="showplace"> <img
						src="https://it21209352.github.io/css/pictures/location.png"
						alt="..." height="70%" width="15%">
						<h2 style="color: lightgreen;">Best Places for visit</h2>
						<p style="color: white; align: justify;">Siygiria, Nuwara
							Eliya, Pinnewala Elephant Orphanage, Trincomalee, Udawalawe
							National Park, Sinharaja Forest Reserve, and many more. Because
							of the artistic diversity of places to visit in Sri Lanka, it has
							become a very popular destination for tourists.</p>
					</a>
				</div>
				<div class="column1">
					<a href="showpackage"> <img
						src="https://it21209352.github.io/css/pictures/places.png"
						alt="..." height="70%" width="15%">
						<h2 style="color: lightgreen;"> Crete your own
							Package</h2>
						<p style="color: white; align: justify;">Pick places you like
							to visit. Choose your guide.Leave the rest to us.</p>
					</a>
				</div>
				<!-- <div class="column1">
					<a href="#"> <img
						src="https://it21209352.github.io/css/pictures/hotels.png"
						alt="..." height="80%" width="20%">
						<h2 style="color: lightgreen;">Book a hotel</h2>
						<p style="color: white; align: justify;">hotels are vary
							according to your choice. In packages hotels assigned according
							to the places that you travel. these are some hotels that famous
							around specific places.pal wild coast tented lodge , kaju green
							eco lodges , taj samudra hotel , gladari hotel and many more.</p>
					</a>
				</div> -->
				<div class="column1">
					<a href="Showguide"> <img
						src="https://wijethungaia.github.io/travelexpo.github.io/Place/user.png" alt="..."
						height="80%" width="20%">
						<h2 style="color: lightgreen;">Find guide for you</h2>
						<p style="color: white; align: justify;">Giudes are assigned
							to every package that you pick and also you can select specific
							tour guide as you like.</p>
					</a>
				</div>
			</div>
		</div>
<!-- video -->
		 <table border="0" width="100%">
			<tr height="400">
				<td><video autoplay muted loop id="myVideo" z-index="0">
						<source
							src="https://it21209352.github.io/css/pictures/Sri Lanka Tourism.mp4"
							type="video/mp4">
					</video></td>
			</tr>
		</table> 

		<!-- random image -->
		<div class="Cateories" style="background-color: white;">
			​
			<div class="row1">
				<div class="column1 cimg">
					<a href="#">
						<p align="justify" style="margin-top: 30%; font-size: 20px;padding-top:20%">
							The tropical climate, beautiful beaches and incredible food of
							Sri Lanka are just some of the many reasons to include the South
							Asian country on your travel wish list.
						</p>
					</a>
				</div>

				<div class="column1 cimg">
					<a href="#"> <img
						src="https://it21209352.github.io/css/pictures/sigiriya.jpg"
						alt="...">

					</a>
				</div>
				<div class="column1 cimg">
					<a href="#"> <img
						src="https://it21209352.github.io/css/pictures/9arch.jpg"
						alt="..." height=250px> <img
						src="https://it21209352.github.io/css/pictures/wildlife.jpg"
						alt="...">
					</a>
				</div>
			</div>
		</div>



		<!-- footer -->
		<div class="footer">
			<BR>
			<h3>THANK YOU FOR CHOOSING Travel EXPO</h3>
			<p>We offer a wide range of tour programs from Northeast to down
				south covering Nature, Culture, wildlife, National Parks,
				Ecotourism, and many more areas to fulfil our clients’
				requirements</p>

			<ul class="socials">
				<li><a href="#"> <img
						src="https://it21209352.github.io/css/pictures//FB.png"
						height="50px" width="25px">
				</a></li>
				<li><a
					href="https://api.whatsapp.com/send/?phone=94718922774&text&app_absent=0">
						<img src="https://it21209352.github.io/css/pictures//WA.png"
						height="50px" width="50px">
				</a></li>
				<li><a href="#"><img
						src="https://it21209352.github.io/css/pictures//Tweet.png"
						height="50px" width="50px" alt=""></a></li>
				<li><a href="#"><img
						src="https://it21209352.github.io/css/pictures//Locat.png"
						height="50px" width="50px" height="100px" width="100px" alt=""></a></li>
				<li><a href="#"><img
						src="https://it21209352.github.io/css/pictures//inter.png"
						height="50px" width="50px" alt=""></a></li>

			</ul>
			<div class="footer-bottom">
				<p>
					copyright &copy;2022 <a href="#">Project Group 12</a>
				</p>
			</div>
</body>
</html>
