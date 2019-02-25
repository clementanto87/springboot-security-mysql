<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style type="text/css">
form {
	width: 50%;
	margin: 0 auto;
}

.signup{
	margin-left:500px;
}
</style>
</head>

<body>
	<form action="login" method="post">
		<h1>Login Page</h1>
		<span class="red">User Name:</span> <input name="username" type="text">
		Password: <input name="password" type="password">
		<button type="submit">Submit</button>
	</form>
	<br><br>
	<div class="signup">Sign up to the application <a href=signup>click</a></div>
</body>
</html>