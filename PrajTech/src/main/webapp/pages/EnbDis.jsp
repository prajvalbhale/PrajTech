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
	<h3>This will show the User Inserted project Details to the Admin
		for Enable/Disable</h3>
	<%
	List<ProjectEntity> pp = (List<ProjectEntity>)request.getAttribute("projectlist");
	%>
	
	<%for(ProjectEntity pe : pp) {%>
	<%=pe.getName() %>
	<%=pe.getJarFileData() %>
	<%=pe.getDocFileData() %>	
	<%} %>
	
</body>
</html>