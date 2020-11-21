<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
	
	<title>Access Denied Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	 
</head>

<body>

	<h2>Access Denied - You are not authorized to access this page</h2>
	<hr> 
	 
	<p>
		<a href="${pageContext.request.contextPath}/">Back to home page.</a>
	</p>
</body>
</html>