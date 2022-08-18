<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "t" tagdir="/WEB-INF/tags" %>

<title>Edit Baby Name</title>
<t:base>
<div class="container mt-3">
	<a href="/logout" class="lead">Logout</a>
	<a href="/dashboard" class="lead">Dashboard</a>
	<h3 class="display-3">Edit Name</h3>
	<form:form action="/movies/${movie.id}/edit" method="post" modelAttribute="movie">
		<input type="hidden" name="_method" value="put">
		<input type="hidden" name="creator" value="${id}">
		<div class="mb-3">
			<form:label for="title" class="form-label lead" path="title">Name:</form:label>
			<form:errors path="title" class="text-danger" />
			<form:input type="text" class="form-control" path="title" value="${thisMovie.title}"/>
		</div>
		<div class="mb-3">
			<form:label for="genre" class="form-label lead" path="genre">Typical Gender:</form:label>
			<form:errors path="genre" class="text-danger" />
			<form:input type="text" class="form-control" path="genre" value="${thisMovie.genre}"/>
		</div>
		<div class="mb-3">
			<form:label for="origin" class="form-label lead" path="origin">Origin:</form:label>
			<form:errors path="origin" class="text-danger" />
			<form:input type="text" class="form-control" path="origin" value="${thisMovie.origin}"/>
		</div>
		<div class="mb-3">
			<form:label for="year" class="form-label lead" path="year">Year Planned:</form:label>
			<form:errors path="year" class="text-danger" />
			<form:input type="text" class="form-control" path="year" value="${thisMovie.year}"/>
		</div>
		<div class="mb-3">
			<form:label for="description" class="form-label lead" path="description">Meaning:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:textarea class="form-control" path="description" value="${thisMovie.description}"/>
		</div>
		<div class="d-flex align-items-center gap-2">
			
			<a class="btn btn-danger" href="/dashboard">Cancel</a>
			<button type="submit" class="btn btn-primary">Submit</button>

		</div>
	</form:form>
</div>
</t:base>