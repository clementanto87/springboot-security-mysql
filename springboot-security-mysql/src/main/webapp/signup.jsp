<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Dancing+Script"
	rel="stylesheet">
<style type="text/css">
body {
	font-family: font-family : 'Lora', serif;;
	font-size: 15px;
	line-height: 25px;
}

table {
	table-layout: fixed;
	word-wrap: break-word;
	text-align: center;
}

th {
	text-align: center;
}

button a {
	color: #fff;
}

button a:hover {
	color: #fff;
	text-decoration: none;
}

button a:active {
	color: #fff;
}

body {
	background-image: url("img/flight.PNG");
	/* background-color: #cccccc; */
	/* Full height */
	height: 800px;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

a {
	color: red;
}
.title {
	font-family: 'Dancing Script', Georgia, Times, serif;
	font-size: 50px;
}
</style>

</head>
<body style="color: #fff">


	<!--  Include Navbar.jsp for top navigation stats  -->
	<div class="container" style="margin-top: 50px"">
		<h1 class="col-sm-offset-2 col-md-8">
			<label class="title">Boeing Fleet</label>
		</h1>
	</div>
	<div class="container">

		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form action="/register" method="get">
				<label style="color: red">${message}</label>
				<div class="form-group">
					<label for="email">Email address:</label> <input type="email"
						class="form-control" id="email" name="username">
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" name="psw">
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" name="psw-repeat">
				</div>
				
				<button type="submit" class="btn btn-default">Submit</button>

			</form>
		</div>

	</div>

</body>
</html>