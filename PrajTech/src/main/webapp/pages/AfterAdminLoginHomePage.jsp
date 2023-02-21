<%@page import="org.prajval.EntityLayer.AdminEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ADMIN LOGGED IN SUCCESSFULLY</h1>
	<%
	AdminEntity users = (AdminEntity) session.getAttribute("admin");
	%>
	<%
	session.setMaxInactiveInterval(120);
	%>

	<%=users.getAdminMail()%>

	<div class="list-group">
		<a href="#" class="list-group-item list-group-item-action active" > 
		ADMIN OPERATION'S </a> 
		
		<a href="#" class="list-group-item list-group-item-action">
		Projects Under Review</a>
		
		<a href="#" class="list-group-item list-group-item-action">
		Update</a> 
		
		<a href="#" class="list-group-item list-group-item-action">
		A fourth link item</a> 
		
		<a href="#" class="list-group-item list-group-item-action ">
		A disabled link item</a>
	</div>
</body>
</html>