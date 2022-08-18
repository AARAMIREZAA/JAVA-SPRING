<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Shelf</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container w-75 mx-auto">
		<div class="container">
			<div class="container d-flex align-items-center justify-content-between">
				<h1 class="text-center">Welcome, ${ currentUser.getUserName() }</h1>
				<a href="/logout">Logout</a>
			</div>
			<div class="container d-flex align-items-center justify-content-between">
				<h3 class="text-center">Books from everyone's shelves:</h3>
				<a href="/books/new">+ Add a book to my shelf!</a>
			</div>
		</div>
		<table class="table table-borderless border border-2">
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Author Name</td>
					<td>Posted By</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td><a href="/books/${book.getId() }">${book.getId() }</a></td>
						<td><a href="/books/${book.getId() }">${book.getTitle() }</a></td>
						<td>${book.getAuthor() }</td>
						<td>${book.getPoster().getUserName() }</td>
						<td class="d-flex gap-2 flex-nowrap">
							<c:if test="${book.getPoster().getId() eq user_id }">
							<a href="/books/${book.getId() }/edit" class="btn btn-primary">EDIT</a>
							
							<form action="/books/${book.getId()}/delete" method="POST">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" class="btn btn-primary btn-danger" value="DELETE" />
							</form>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>