<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.dhanrajapp.bean.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/stylesheet.css"%></style>
</head>
<body>
<%List<LoginBean> beans=(List<LoginBean>)session.getAttribute("userList");%>


<h1 id="manage">Daily Task</h1>
<html:form action="/taskDone">
<table>
<%for(LoginBean bean1:beans) {%>
<tr>
	<th>DATE</th>
	<th><input type="text" id="staffid<%=bean1.getStaffid() %>" value="<%=bean1.getStaffid()%>"> </th>
</tr>
<%} %>
</table>
<button type="Submit">Submit</button>
<button type="Reset">Cancel</button>
</html:form>
</body>
</html>