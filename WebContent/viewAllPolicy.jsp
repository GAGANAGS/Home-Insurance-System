<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
	<div class="container">
		<ul class="nav">
			<li class="nav-item"><a class="nav-link"
				href="adminDashboard.spring">Dashboard</a></li>
		</ul>
		<h2>View All Quote Details</h2>
		<core:forEach items="${sessionScope.allQuote}" var="quote">
			<div class="imageClass">
				<h3>
					Quote Sqft <span class="badge bg-info">${quote.sqft}</span>
				</h3>
				<h3>
					Quote Cost per sqft <span class="badge bg-info">${quote.costpersqft}</span>
				</h3>
				<h3>
					Location <span class="badge bg-info">${quote.location}</span>
				</h3>
				<h3>
					Quote Price <span class="badge bg-info">${quote.price}</span>
				</h3>
			</div>
		</core:forEach>
	</div>
</body>
</html>