<%@page import="org.prajval.EntityLayer.UserEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#overlay {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	z-index: 1;
	background-color: rgba(0, 0, 0, 0.5);
}

#modal {
	max-width: 300px;
	max-height: 85px;
	margin: auto;
	background-color: white;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	position: absolute;
	border-radius: 5px;
}

#close-modal-btn {
	position: absolute;
	left: 280px;
}

#show-modal-btn, #two {
	margin-right: 5px;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>After User Login Home Page</h1>
	<a href="">HOME</a>
	<a href="">ABOUT</a>
	<a href="">DEVELOPER'S</a>
	<a href="">PROJECT/DOC'S</a>
	<a href="/my-profile">PROFILE</a>

	<!-- Pop UP Start -->
	<div id="overlay">
		<div id="modal">
			<button id="close-modal-btn" type="button" class="close"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<br>
			<h2>Your Subscription Going To Be End</h2>
		</div>
	</div>
	<!-- Pop UP END -->
	
	<script type="text/javascript">	
		const overlay = document.querySelector("#overlay");
		document.querySelector("#show-modal-btn").addEventListener("click", () => {
				overlay.style.display = "block";		
		})
		
		document.querySelector("#close-modal-btn").addEventListener("click", () => {
				overlay.style.display = "none";		
		})		
	</script>
</body>
</html>