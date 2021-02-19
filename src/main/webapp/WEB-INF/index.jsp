<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="UTF-8">
<title>Dojo Gold</title>
</head>
<body>
	<header>
		<h1>Your Gold: <c:out value="${goldCount}"/></h1>
	</header>
	
	<div class="places-div">
	
		<div class="farm">
			<form action="/goldCounter" method="POST">
				<h2>Farm</h2>
				<input type="hidden" name="hidden" value="farm">
				<p>(earns 10-20 gold)</p>
				<input type="submit" value="Find Gold!" class="btn">
			</form>
		</div>
		
		<div class="cave">
			<form action="/goldCounter" method="POST">
				<h2>Cave</h2>
				<input type="hidden" name="hidden" value="cave">
				<p>(earns 5-10 gold)</p>
				<input type="submit" value="Find Gold!" class="btn">
			</form>
		</div>
		
		<div class="house">
			<form action="/goldCounter" method="POST">
				<h2>House</h2>
				<input type="hidden" name="hidden" value="house">
				<p>(earns 2-5 gold)</p>
				<input type="submit" value="Find Gold!" class="btn">
			</form>
		</div>
		
		<div class="casino">
			<form action="/goldCounter" method="POST">
				<h2>Casino</h2>
				<input type="hidden" name="hidden" value="casino">
				<p>(earns 0-50 gold)</p>
				<input type="submit" value="Find Gold!" class="btn">
			</form>
		</div>
		
	</div>
	
	<div class="activities-div">
		<h1>Activities:</h1>
		<div>
           <c:forEach items="${activityList}" var="event">
           		<c:out value="${event}" escapeXml="false" />
           </c:forEach>
                       
        </div>
	</div>
</body>
</html>