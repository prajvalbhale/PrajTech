<%@page import="org.prajval.EntityLayer.ProjectEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>DISPLAY THE PROJECT LIST'S</h1>
	<%
	List<ProjectEntity> pe = (List<ProjectEntity>) request.getAttribute("zipFileData");
	%>

</body>
</html>