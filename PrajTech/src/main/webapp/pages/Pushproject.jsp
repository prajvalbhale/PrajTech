<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PUSH PROJECT</title>
</head>
<body>
	<form action="/insert-project" method="post" enctype="multipart/form-data">
		<a> 
			Project Name: <input type="text" name="name" placeholder="Project Name">
		</a>
		<br>
		<a> 
			Project Tech:<input type="text" name="technology" placeholder="Project Technologie">
		</a>
		<br>
		<a> 
			Project Desc:<input type="text" name="description" placeholder="Project description">
		</a>
		<br>
		<a> 
			Upload ZIP:<input type="file" name="zipFileData" placeholder="Project zip File">
		</a>
		<br>
		<a> 
			Upload JAR:<input type="file" name="jarFileData" placeholder="Project jar File">
		</a>
		<br>
		<a> 
			Upload DOC:<input type="file" name="docFileData" placeholder="Project doc File">
		</a>
		<br>
		<a> 
			Upload VIDEO:<input type="file" name="videoFileData" placeholder="Project video File">
		</a>
		
		<button type="submit">PUSH</button>
	</form>
</body>
</html>