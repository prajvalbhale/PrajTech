<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign UP</title>
</head>
<body>
	<form action="/user-insert-for-sign-up">
		<br>
		<br> First Name: <input type="text" name="UserFirstName"
			placeholder="UserFirstName"> Last Name: <input type="text"
			name="UserLastName" placeholder="UserLastName"> <br>
		<br> Mobile No: <input type="text" name="UserPhone"
			placeholder="UserPhone"> Mail ID: <input type="text"
			name="UserMail" placeholder="UserMail"> <br>
		<br> College Name: <input type="text" name="UserPhone"
			placeholder="CollegeName"> College PIN: <input type="text"
			name="UserMail" placeholder="CollegePIN"> <br>
		<br> Register No: <input type="text" name="UserPhone"
			placeholder="RegisterNo"> ID Card Pic: <input type="text"
			name="UserMail" placeholder="CollegeIDCardPic"> <br>
		<br> Confirm Password: <input type="text" name="ConfirmPassword"
			placeholder="ConfirmPassword"> <br>
		<br>
		<button type="submit" name="Submit">Submit</button>
		<br>
	</form>
</body>
</html>