<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1>${book.title}</h1>
	<h2>Description: ${book.description}</h2>
	<h2>Language: ${book.language}</h2>
	<h2>Number of Pages: ${book.numberOfPages}</h2>
	 --%>
	  
	<h1>All Books</h1>
	<table>
    	<thead>
        	<tr>
            	<th>ID</th>
            	<th>Title</th>
            	<th>Language</th>
            	<th>Number of Pages</th>
        	</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.language}"></c:out></td>
				<td><c:out value="${book.numberOfPages}"></c:out></td>
			</tr>	
		</c:forEach>
         <!-- loop over all the books to show the details as in the wireframe! -->
    	</tbody>
	</table>

</body>
</html>