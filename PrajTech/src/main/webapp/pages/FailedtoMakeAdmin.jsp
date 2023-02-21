<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
var seconds=0;
function displaysec(){
	seconds += 1;
}
setInterval(displaysec, 1000);

function redirectpage() {
	window.location="/make-admin";
}
setTimeout('redirectpage()', 3000);
</script>
<meta charset="ISO-8859-1">
<title>PrajTech</title>
<link rel="stylesheet" href="static/css/style.css">
<style type="text/css">
.ani{
  position: fixed;
  top:-100%; right:-100%; left:-100%; bottom:-100%;
  margin:auto;
  z-index:0;
}
.usersignup{
  font-size: 20px;
}
</style>
</head>
<body>
<img class="ani" alt="succee signup" src="animations/failed_ani.gif">
<h2>Failed to Make Admin!! Try Again..</h2>
<h3>Be Here You Will Automatically Redirect On <br> Sign Up Page</h3>
</body>
</html>