<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>User Login Page</h1>
	<form action="/login-page">
		User Name: <input type="text" name="UserMailID" placeholder="User Name">
		Password: <input type="text" name="ConfirmPassword" placeholder="Password">
		<button type="submit">Login</button>
	</form>
	<a href="/sign-up">Create Account!</a>
</body>
</html>