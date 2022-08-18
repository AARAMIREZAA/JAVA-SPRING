<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add A Book</title>
</head>
<body>
	<h1>New Book</h1>

	<form action="/books/new" method="post">
		<div>
			<label for="title" >Title</label>
			<input name="title"/>
		</div>
		<div>
			<label for="description">Description</label>
			<input name="description"/>
		</div>
		<div>
			<label for="language">Language</label>
			<input name="language"/>
		</div>
		<div>
			<label for="numberOfPages">Number of pages</label>
			<input type="number" name="numberOfPages"/>
		</div>
		<input type="submit" value="SUBMIT"/>
	</form>

</body>
</html>