<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
		<link rel="stylesheet" href="./css/style.css" />
	</head>
	<body>
		<%
			if (session != null) {
				String errorLoginMessage = (String) session.getAttribute("errorLoginMessage"); 
				
				if (errorLoginMessage != null) {
					out.println(errorLoginMessage);
				}
			}
		%>
		
		<!-- check form -->
		<% 
			String form = (String) request.getParameter("form");
			if (form == null || form.equals("login")) {
		%>
			<jsp:include page="/form/login.jsp"></jsp:include>	
				
		<% } else { %>
			<jsp:include page="/form/signup.jsp"></jsp:include>	
		<% } %>
		
		<!-- Show login and sign up -->
		<div class="login-signup-buttons">
			<a href="/sbahia/login/?form=login" class="login">Login</a>
			<a href="/sbahia/signup/?form=signup" class="signup">Signup</a>
		</div>
	</body>
</html>