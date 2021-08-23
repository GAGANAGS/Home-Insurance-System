<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css"/>
</head>
<body>
<div class="container">
<ul class="nav">
  <li class="nav-item">
    <a class="nav-link" href="adminDashboard.spring">Dashboard</a>
  </li>
 </ul>
<form action="updateSelectedPolicy.spring" method="get">
<div class="form-outline mb-2">
    <label class="form-label">Please enter the quote id to search quote</label>
    <input type="text" name="qid" class="form-control" required/>    
</div>
<input type="submit" class="btn btn-outline-primary" value="Update Quote"/>
<input type="reset" class ="btn btn-outline-light" value="Reset"/>

</form>

<br/>

<span style="color:red">${sessionScope.pmsg}</span>

<core:if test="${sessionScope.quoteInfo != null}">
	<form action="updateQuote.spring" method="post">
	<div class="form-outline mb-2">
    <label class="form-label">Quote Id</label>
    <input type="number" name="qid" class="form-control" value="${sessionScope.quoteInfo.qid}" readonly/>    
	</div>
	
	<div class="form-outline mb-2">
    <label class="form-label">Quote Cost per sqft</label>
    <input type="number" name="quoteCostpersqft" class="form-control" value="${sessionScope.quoteInfo.costpersqft}"/>    
	</div>
	
	<div class="form-outline mb-2">
    <label class="form-label">Quote sqft</label>
    <input type="number" name="quoteSqft" class="form-control" value="${sessionScope.quoteInfo.sqft}"/>    
	</div>
	
	<div class="form-outline mb-2">
    <label class="form-label">Quote price</label>
    <input type="number" name="quotePrice" class="form-control" value="${sessionScope.quoteInfo.price}"/>    
	</div>
	
	<input type="submit" class="btn btn-outline-primary" value="Update Quote"/>
	<input type="reset" class ="btn btn-outline-light" value="Reset"/>
	</form>
</core:if>
<span style="color:red">${sessionScope.quoteUpdateMsg}</span>
</div>
</body>
</html>