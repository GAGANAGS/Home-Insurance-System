<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<h2>Add Quote Details</h2>
		<form action="storeQuote.spring" method="post">
			<div class="form-outline mb-2">
				<label class="form-label">Quote sqft</label> <input type="number"
					name="quoteSqft" class="form-control" required />
			</div>
			<div class="form-outline mb-2">
				<label class="form-label">Years</label> <input type="number"
					name="quoteYears" class="form-control" required />
			</div>

			<div class="form-outline mb-2">
				<label class="form-label">Quote Cost per sqft</label> <input type="number"
					name="quoteCostpersqft" class="form-control" required />
			</div>

			<div class="form-outline mb-2">
				<label class="form-label">Quote Price</label> <input
					type="number" name="quotePrice" class="form-control" required />
			</div>


			<div class="form-outline mb-2">
				<label class="form-label">Location</label> <input type="text"
					name="location" class="form-control" required />
			</div>

			<input type="submit" class="btn btn-outline-primary"
				value="Store Quote" /> <input type="reset"
				class="btn btn-outline-light" value="Reset" />
		</form>
		<span style="color: red">${requestScope.msg}</span>
	</div>
</body>
</html>
