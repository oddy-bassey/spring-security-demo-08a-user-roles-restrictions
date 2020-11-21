<!-- Adding support for spring form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Adding support for spring security taglibs -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<title>revoltcode Company Home Page</title>
	</head>
	
	<body>
		<h2>@revoltcode company home page ::))</h2>
		<hr>
		<p>Welcome to revoltcode company home page :) My friend got a job:)</p>
		
		
		<hr>
			<!-- display username and role -->
			<p>
				User: <security:authentication property="principal.username" />
				<br><br>
				Role(s): <security:authentication property="principal.authorities"/>
			</p>
		<hr>
		
		<security:authorize access="hasRole('MANAGER')">
			<!-- Add a link to point to /leaders ... this is for managers -->
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				Only for manager peeps
			</p>
			<hr>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<!-- Add a link to point to /leaders ... this is for managers -->
			<p>
				<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
				Only for Admin peeps
			</p>
			<hr>
		</security:authorize>
		
		<!-- ADd a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
			<input type="submit" value="logout"/>
		</form:form>
	</body>
</html>













