<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>

<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core"%>    

<%@ page import="librarymvc.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	
	<jsp:include page="../components/navbar.jsp" />
			
	
	<div class="container">
	
		<a class="btn btn-primary" href="addbook">Add Book</a>
		<h1 class="text-center">Books Listing</h1>
		
		<table class="content-table mt-5 mx-auto" border="1" cellpadding="10px" cellspacing="5px">
			
					<tr>
                        <th>Book ID</th>
                        <th>Book Name</th>
                        <th>Date</th>
                        <th>Author</th>
                        <th>Action</th>
                    </tr>
		
					<c:forEach items="${allBooks}" var="book">
						
						<tr>
							<td><c:out value="${book.getId()}"></c:out></td>
							<td><c:out value="${book.getName()}"></c:out></td>
							<td><c:out value="${book.getDateadded()}"></c:out></td>
							<td><c:out value="${book.getAuthor()}"></c:out></td>
							<td>
								<div class="d-inline">
									<a class="btn btn-danger" href="<%=request.getContextPath()%>/editpage?id=${book.getId()}">Edit</a>
								</div>
								<form class="d-inline pb-2" action="<%= request.getContextPath()%>/delete/${book.getId()}" method="post">
									<button class="btn btn-success mt-2">delete</button>
								</form>
							</td>
						</tr>
					
					</c:forEach>

		</table>
			
	</div>

	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>