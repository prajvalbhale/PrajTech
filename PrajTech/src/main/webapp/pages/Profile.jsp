<%@page import="org.prajval.EntityLayer.UserEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.body {
	background-color: gray;
}

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

#show-modal-btn, #moni, #logout, #two {
	margin-right: 5px;
}

.flip-card {
	background-color: transparent;
	width: 300px;
	height: 200px;
	border: 1px;
	perspective: 1000px; /* Remove this if you don't want the 3D effect */
}

/* This container is needed to position the front and back side */
.flip-card-inner {
	position: relative;
	width: 100%;
	height: 100%;
	text-align: center;
	transition: transform 0.8s;
	transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.flip-card:hover .flip-card-inner {
	transform: rotateY(180deg);
}

/* Position the front and back side */
.flip-card-front, .flip-card-back {
	position: absolute;
	width: 100%;
	height: 100%;
	-webkit-backface-visibility: hidden; /* Safari */
	backface-visibility: hidden;
}

/* Style the front side (fallback if image is missing) */
.flip-card-front {
	background-color: white;
	color: black;
}

/* Style the back side */
.flip-card-back {
	background-color: white;
	color: black;
	transform: rotateY(180deg);
}
</style>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<%@ include file="./base.jsp"%>
</head>
<body>
	<%
	UserEntity users = (UserEntity) session.getAttribute("user");
	%>
	<%
	session.setMaxInactiveInterval(120);
	%>

	<section>
		<div class="container py-5">
			<div class="row">
				<div class="col-lg-4">
					<div class="card mb-6">
						<div class="card-body text-center">
							<div class="flip-card">
								<div class="flip-card-inner">
									<div class="flip-card-front">
										<img
											src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp"
											alt="Avatar" style="width: 190px; height: 200px;">
									</div>
									<div class="flip-card-back">
										<h1><%=users.getUserFirstName()%></h1>
										<p>College Name</p>
									</div>
								</div>
							</div>
							<br>
							<div class="d-flex justify-content-center mb-2">
								<button type="button" class="btn btn-primary"
									id="show-modal-btn">Push Project</button>
									<!-- Pop UP Start For Project Insertion-->
									<div id="overlay">
										<div id="modal">
											<button id="close-modal-btn" type="button" class="close"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<br> 
											<a href="/push-mini-project">
											<button id="two" type="button"
												class="btn btn-outline-primary">Mini Project</button>
											</a> 
											
											<a href="/push-full-project">
											<button id="two" type="button"
												class="btn btn-outline-primary">Full Project</button>
											</a>
										</div>
									</div>
									<!-- Pop UP END -->
								<div class="website-content"></div>

								<a href="">
									<button id="moni" type="button"
										class="btn btn-outline-primary ms-1">Monetization</button>
								</a> <a href="/logout">
									<button id="logout" type="button" class="btn btn-danger">Logout</button>
								</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-7">
					<div class="card mb-4">
						<div class="card-body">
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Full Name</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0"><%=users.getUserFirstName()%></p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Email</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0"><%=users.getUserMailID()%></p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Mobile</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">mobile number</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">College Name</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">college name/p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Register Number</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">register number</p>
								</div>
							</div>
							<hr>
							<div class="row">
								<div class="col-sm-3">
									<p class="mb-0">Account Status</p>
								</div>
								<div class="col-sm-9">
									<p class="text-muted mb-0">account status</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</section>

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