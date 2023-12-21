<%@ page import="librarymvc.model.*" %>
<%@ page import="java.util.*" %>
<%
	Librarian librarian = (Librarian) session.getAttribute("currentUser");
	if(librarian != null) {
%>

<nav class="navbar navbar-expand-md navbar-fixed-top main-nav mb-4">
    <div class="container">
        <ul class="nav navbar-nav mx-auto">
            <li class="nav-item">
            	<h2>Library Management System</h2>
            </li>
        </ul>
        <ul class="nav navbar-nav">
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">
    				<%= "Hi "+librarian.getUsername() %>
   				 </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary text-white" href="logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<%
	}
%>
