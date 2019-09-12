
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
	line-height: 1.8;
}

/* Full height image header */
.bgimg-1 {
	background-position: center;
	background-size: cover;
	background-image: url("/w3images/mac.jpg"); /* poner la nuestra */
	min-height: 100%;
}

.w3-bar .w3-button {
	padding: 16px;
}
</style>
<body>

	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-white w3-card" id="myNavbar">
			<a href="#home" class="w3-bar-item w3-button w3-wide">BlaBlaShop</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="#about" class="w3-bar-item w3-button">ABOUT</a> <a
					href="#team" class="w3-bar-item w3-button"><i
					class="fa fa-user"></i> TEAM</a> <a href="#shop"
					class="w3-bar-item w3-button"><i class="fa fa-th"></i> SHOP</a> <a
					href="#contact" class="w3-bar-item w3-button"><i
					class="fa fa-envelope"></i> CONTACT</a> <a href="#contact"
					onclick="document.getElementById('id01').style.display='block'"
					style="width: auto;" class="w3-bar-item w3-button"><i
					class="fa fa-sign-in"></i> LOG IN</a>
			</div>
			<!-- Hide right-floated links on small screens and replace them with a menu icon -->

			<a href="javascript:void(0)"
				class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium"
				onclick="w3_open()"> <i class="fa fa-bars"></i>
			</a>
		</div>
	</div>

	<!-- Sidebar on small screens when clicking the menu icon -->
	<nav
		class="w3-sidebar w3-bar-block w3-black w3-card w3-animate-left w3-hide-medium w3-hide-large"
		style="display: none" id="mySidebar">
		<a href="javascript:void(0)" onclick="w3_close()"
			class="w3-bar-item w3-button w3-large w3-padding-16">Close ×</a> <a
			href="#about" onclick="w3_close()" class="w3-bar-item w3-button">ABOUT</a>
		<a href="#team" onclick="w3_close()" class="w3-bar-item w3-button">TEAM</a>
		<a href="#shop" onclick="w3_close()" class="w3-bar-item w3-button">SHOP</a>
		<a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button">CONTACT</a>
		<a href="#contact"
			onclick="document.getElementById('id01').style.display='block'"
			style="width: auto;" class="w3-bar-item w3-button"><i
			class="fa fa-sign-in"></i> LOG IN</a>
	</nav>

	<!-- Header with full-height image -->
	<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
		<div class="w3-display-left w3-text-white" style="padding: 48px">
			<span class="w3-jumbo w3-hide-small">Shop smart, make it easy</span><br>
			<span class="w3-xxlarge w3-hide-large w3-hide-medium">Shop
				smart, make it easy</span><br> <span class="w3-large">Get the
				best quality products</span>
			<p>
				<a href="#about"
					class="w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off">Learn
					more and enjoy your shopping experience</a>
			</p>
		</div>
		<div class="w3-display-bottomleft w3-text-grey w3-large"
			style="padding: 24px 48px">
			<i class="fa fa-instagram w3-hover-opacity"></i> <i
				class="fa fa-github w3-hover-opacity"></i> <i
				class="fa fa-twitter w3-hover-opacity"></i> <i
				class="fa fa-linkedin w3-hover-opacity"></i>
		</div>
	</header>

	<!-- About Log in -->

	<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */
.container {
	padding: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: #474e5d;
	padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 35px;
	top: 15px;
	font-size: 40px;
	font-weight: bold;
	color: #f1f1f1;
}

.close:hover, .close:focus {
	color: #f44336;
	cursor: pointer;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>
<body>

	<h2>Modal Sign up Form</h2>

	<div id="id01" class="modal">
		<span onclick="document.getElementById('id01').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<form class="modal-content" action="/action_page.php">
			<div class="container">
				<h1>Sign Up</h1>
				<p>Please fill in this form to create your account in BlaBlaShop</p>
				<hr>
				<label for="email"><b>Email</b></label> <input type="text"
					placeholder="Enter Email" name="email" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required> <label
					for="psw-repeat"><b>Repeat Password</b></label> <input
					type="password" placeholder="Repeat Password" name="psw-repeat"
					required> <label> <input type="checkbox"
					checked="checked" name="remember" style="margin-bottom: 15px">
					Remember me
				</label>

				<p>
					By creating an account you agree to our <a href="#"
						style="color: dodgerblue">Terms & Privacy</a>.
				</p>

				<div class="clearfix">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn">Cancel</button>
					<button type="submit" class="signupbtn">Sign Up</button>
				</div>
			</div>
		</form>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>


<!-- About Section -->
<div class="w3-container" style="padding: 128px 16px" id="about">
	<h3 class="w3-center">ABOUT THE COMPANY</h3>
	<p class="w3-center w3-large">Key features of our company</p>
	<div class="w3-row-padding w3-center" style="margin-top: 64px">
		<div class="w3-quarter">
			<i class="fa fa-desktop w3-margin-bottom w3-jumbo w3-center"></i>
			<p class="w3-large">Responsive</p>
			<p>BlaBlaShop's responsive design creates flexible layouts
				perfectly adjusted for your personal device.</p>
		</div>
		<div class="w3-quarter">
			<i class="fa fa-heart w3-margin-bottom w3-jumbo"></i>
			<p class="w3-large">Passion</p>
			<p>BlaBlaShop not only takes care of our products but also about
				you.</p>
		</div>
		<div class="w3-quarter">
			<i class="fa fa-diamond w3-margin-bottom w3-jumbo"></i>
			<p class="w3-large">Design</p>
			<p>User-friendly design to dive into your daily pantry and
				shopping list.</p>
		</div>
		<div class="w3-quarter">
			<i class="fa fa-cog w3-margin-bottom w3-jumbo"></i>
			<p class="w3-large">Support</p>
			<p>In order to meet your expectations BlaBlaShop enables you to
				experience real-time feedback and client support.</p>
		</div>
	</div>
</div>

<!-- Promo Section - "Shop" -->
<div class="w3-container w3-light-grey" style="padding: 128px 16px">
	<div class="w3-row-padding">
		<div class="w3-col m6">
			<h3>Welcome to BlaBlaShop</h3>
			<p>
				Make your shopping list much more easier! <br>BlaBlashop allows
				you to track your pantry and other household products. Moreover, you
				can pick a wide variety of them!
			</p>
			<p>
				<a href="#work" class="w3-button w3-black"><i class="fa fa-th"> </i>
					Select any category</a>
			</p>
		</div>
		<div class="w3-col m6">
			<img class="w3-image w3-round-large"
				src="/pictures/logo.jpg" alt="BlaBlaShop logo2" width="700"
				height="394">
		</div>
	</div>
</div>

<!-- Team Section -->
<div class="w3-container" style="padding: 128px 16px" id="team">
	<h3 class="w3-center">THE TEAM</h3>
	<p class="w3-center w3-large">The ones who runs this company</p>
	<div class="w3-row-padding w3-grayscale" style="margin-top: 64px">
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-card">
				<img src=""/pictures/victor.jpg" alt="Victor" style="width: 100%">
				<div class="w3-container">
					<h3>Víctor Bernardos Gutierrez</h3>
					<p class="w3-opacity">Junior JEE Programmer</p>
					<p>.</p>
					<p>
						<button class="w3-button w3-light-grey w3-block">
							<i class="fa fa-envelope"></i> Contact
						</button>
					</p>
				</div>
			</div>
		</div>
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-card">
				<img src=""/pictures/alba.jpg" alt="Alba" style="width: 100%">
				<div class="w3-container">
					<h3>Alba Paramio García</h3>
					<p class="w3-opacity">Junior JEE Programmer</p>
					<p>.</p>
					<p>
						<button class="w3-button w3-light-grey w3-block">
							<i class="fa fa-envelope"></i> Contact
						</button>
					</p>
				</div>
			</div>
		</div>
		<div class="w3-col l3 m6 w3-margin-bottom">
			<div class="w3-card">
				<img src=""/pictures/logo.jpg" alt="César" style="width: 100%">
				<div class="w3-container">
					<h3>César González Arias</h3>
					<p class="w3-opacity">Junior JEE Programmer</p>
					<p>.</p>
					<p>
						<button class="w3-button w3-light-grey w3-block">
							<i class="fa fa-envelope"></i> Contact
						</button>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Work Section -->
<div class="w3-container" style="padding: 128px 16px" id="work">
	<h3 class="w3-center">YOUR PERSONAL PANTRY</h3>
	<p class="w3-center w3-large">What BlaBlaShop offers you</p>

	<div class="w3-row-padding" style="margin-top: 64px">
		<div class="w3-col l3 m6">
			<img src="/pictures/topp.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Your top products">
		</div>
		<div class="w3-col l3 m6">
			<img src="/pictures/vegetables.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Vegetables">
		</div>
		<div class="w3-col l3 m6">
			<img src="/pictures/fruit.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Fruit">
		</div>
		<div class="w3-col l3 m6">
			<img src="/pictures/protein.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Protein">
		</div>
	</div>

	<div class="w3-row-padding w3-section">
		<div class="w3-col l3 m6">
			<img src="/pictures/dairy.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Dairy products">
		</div>
		<div class="w3-col l3 m6">
			<img src="/pictures/grains.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Seeds">
		</div>
		<div class="w3-col l3 m6">
			<img src="/pictures/drinks.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Drinks">
		</div>
		<div class="w3-col l3 m6">
			<img src="/pictures/household.jpg" style="width: 100%"
				onclick="onClick(this)" class="w3-hover-opacity" alt="Household">
		</div>
	</div>
</div>

<!-- Modal for full size images on click-->
<div id="modal01" class="w3-modal w3-black"
	onclick="this.style.display='none'">
	<span
		class="w3-button w3-xxlarge w3-black w3-padding-large w3-display-topright"
		title="Close Modal Image">×</span>
	<div
		class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
		<img id="img01" class="w3-image">
		<p id="caption" class="w3-opacity w3-large"></p>
	</div>
</div>

<!-- Contact Section -->
<div class="w3-container w3-light-grey" style="padding: 128px 16px"
	id="contact">
	<h3 class="w3-center">CONTACT</h3>
	<p class="w3-center w3-large">Lets get in touch. Send us a message:</p>
	<div style="margin-top: 48px">
		<p>
			<i class="fa fa-map-marker fa-fw w3-xxlarge w3-margin-right"></i>
			León, ES
		</p>
		<p>
			<i class="fa fa-phone fa-fw w3-xxlarge w3-margin-right"></i> Phone:
			+34 987000000
		</p>
		<p>
			<i class="fa fa-envelope fa-fw w3-xxlarge w3-margin-right"> </i>
			Email: info@blablashop.com
		</p>
		<br>
		<form action="/action_page.php" target="_blank">
			<p>
				<input class="w3-input w3-border" type="text" placeholder="Name"
					required name="Name">
			</p>
			<p>
				<input class="w3-input w3-border" type="text" placeholder="Email"
					required name="Email">
			</p>
			<p>
				<input class="w3-input w3-border" type="text" placeholder="Subject"
					required name="Subject">
			</p>
			<p>
				<input class="w3-input w3-border" type="text" placeholder="Message"
					required name="Message">
			</p>
			<p>
				<button class="w3-button w3-black" type="submit">
					<i class="fa fa-paper-plane"></i> SEND US A MESSAGE
				</button>
			</p>
		</form>
		<!-- Image of location/map -->
		<img src="/pictures/logo.jpg" class="w3-image w3-greyscale"
			style="width: 100%; margin-top: 48px">
	</div>
</div>

<!-- Footer -->
<footer class="w3-center w3-black w3-padding-64">
	<a href="#home" class="w3-button w3-light-grey"><i
		class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
	<div class="w3-xlarge w3-section">
		<i class="fa fa-facebook-official w3-hover-opacity"
			style="color: green"></i> <i class="fa fa-instagram w3-hover-opacity"
			style="color: green"></i> <i class="fa fa-github w3-hover-opacity"
			style="color: green"></i> <i class="fa fa-twitter w3-hover-opacity"
			style="color: green"></i> <i class="fa fa-linkedin w3-hover-opacity"
			style="color: green"></i>
	</div>
	<p>© 2019 BlaBlaShop</p>
</footer>

<script>
	// Modal Image Gallery
	function onClick(element) {
		document.getElementById("img01").src = element.src;
		document.getElementById("modal01").style.display = "block";
		var captionText = document.getElementById("caption");
		captionText.innerHTML = element.alt;
	}

	// Toggle between showing and hiding the sidebar when clicking the menu icon
	var mySidebar = document.getElementById("mySidebar");

	function w3_open() {
		if (mySidebar.style.display === 'block') {
			mySidebar.style.display = 'none';
		} else {
			mySidebar.style.display = 'block';
		}
	}

	// Close the sidebar with the close button
	function w3_close() {
		mySidebar.style.display = "none";
	}
</script>

</body>
</html>

