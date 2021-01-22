<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="links.jsp" />
<style><%@include file="/stylesheet.css"%></style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light inverse">
 
  <div class="collapse navbar-collapse" id="navbarNavDropdown" >
    <ul class="navbar-nav">
     <!--  <li class="nav-item active">
        <a class="nav-link" href="userpage.jsp">Home <span class="sr-only">(current)</span></a>
      </li> -->
       <li class="nav-item active">
        <a class="nav-link" href="addPendingTask.jsp">Pending Task</a>
      </li>
     <!--  <li class="nav-item dropdown">
        <a class="nav-link " href="#taskdone" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Work Done
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <li><a class="dropdown-item" href="adddailytask.jsp">Add</a></li>
          <li><a class="dropdown-item" href="#">Delete</a></li>
          <li><a class="dropdown-item" href="#">View</a></li>
        </ul>
      </li> -->
      <li class="nav-item">
        <a class="nav-link" href="login.jsp">Logout</a>
      </li>
    </ul>
  </div>
</nav>
</body>
</html>