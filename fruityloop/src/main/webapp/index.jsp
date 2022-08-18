<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Fruit Store</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
</head>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<body class="container bg-dark text-white">
	<h1 class="text-center">Fruit Store</h1>
	<div class="d-flex flex-column bd-highlight">
	<c:forEach var="oneFruit" items="${fruits}">
		<p class="p-2 bd-highlight text-center">
			<c:out value="${oneFruit.name}" />
			<c:out value="${oneFruit.price}" />
		</p>
	</c:forEach>
	</div>
</body>
</html>