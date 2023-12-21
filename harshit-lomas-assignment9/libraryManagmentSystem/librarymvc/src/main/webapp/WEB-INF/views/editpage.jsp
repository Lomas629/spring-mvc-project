<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="librarymvc.model.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="edit/${bookdetails.getId()}" method="post">
			BookId:<input type="number" placeholder="Enter book ID" name="bookid"
			value="${bookdetails.getId()}" readonly disabled="disabled"> 
			BookName:<input type="text"
			placeholder="Enter book name" name="bookname"
			value="${bookdetails.getName()}"> 
			Date:<input type="text"
			placeholder="Enter Date" name="date"
			value="${bookdetails.getDateadded()}" readonly disabled="disabled"> 
		<label for="author">Author</label>
		<select name="author">
			<option selected>...Choose</option>
			<c:forEach items="${allAuthors}" var="author">
				<option value="${author.getName()}"><c:out
						value="${author.getName()}"></c:out></option>
			</c:forEach>
		</select>

		<button>Edit Book</button>
	</form>


</body>
</html>