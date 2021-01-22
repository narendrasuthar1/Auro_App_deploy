<%@page import="com.dhanrajapp.bean.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<jsp:include page="adminnavbar.jsp" />
<jsp:include page="links.jsp" />
<%LoginBean bean=(LoginBean)session.getAttribute("adminrequest");%>
<h1 id="manage">Welcome <%=bean.getStaffid() %></h1>
</body>
</html>