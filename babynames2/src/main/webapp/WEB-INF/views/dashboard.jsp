

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<title>Baby Names</title>
<t:base>
	<div class="container">
		<h1 class="display-1">Welcome, ${user.username}. Here are some suggestions.</h1>
		<a class="lead" href="/logout">Logout</a> <a class="lead"
			href="/movies/new">New Name</a>

		<h6 class="display-6">Baby Names</h6>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Baby Name</th>
					<th>Typical Gender</th>
					<th>Origin</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="movie" items="${globalWatchlist}">
					<tr>
						<td class="align-middle"><a href="/movies/${movie.id}">${movie.title}</a></td>
						<td class="align-middle">${movie.genre}</td>
						<td class="align-middle">${movie.origin}</td>
						<td class="d-flex align-items-center gap-2">
							<c:choose>
								<c:when test="${movie.creator.id == user.id}">

									<a href="/movies/${movie.id}/edit" class="btn btn-info">Edit</a>
									<form class="mb-0" action="/movies/${movie.id}/delete" method="post">
										<input type="hidden" name="_method" value="delete">
										<button class="btn btn-danger" type="submit">Delete</button>
									</form>
									
								</c:when>
								<c:otherwise>
									<button class="btn btn-info" disabled>Edit</button>
									<button class="btn btn-danger" disabled>Delete</button>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${movie.users.contains(user)}">
									<form class="mb-0" action="/movies/${movie.id}/cancel" method="post">
										<input type="hidden" name="_method" value="put">
										<button class="btn btn-warning" type="submit">Undo</button>
									</form>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</t:base>