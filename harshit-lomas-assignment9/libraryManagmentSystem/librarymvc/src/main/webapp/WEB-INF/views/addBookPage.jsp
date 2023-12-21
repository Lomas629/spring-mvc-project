<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
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
	
	<form action="add" method="post">
		
		BookId:<input type="number" placeholder="Enter book ID" name="bookid">
		BookName:<input type="text" placeholder="Enter book name" name="bookname">
		Date:<input type="text" placeholder="Enter Date" name="date" value="${currentDate}" readonly>
		
		<label for="author">Author</label>
		<select name="author">
			<option selected>...Choose</option>
			<c:forEach items="${allAuthors}" var="author">
			<option value="${author.getName()}"><c:out value="${author.getName()}"></c:out></option>
			</c:forEach>
		</select>
		
		<button>Add Book</button>
	
	</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>	