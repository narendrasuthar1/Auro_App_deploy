<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<%@page import="com.dhanrajapp.bean.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<jsp:include page="adminnavbar.jsp" />
<jsp:include page="links.jsp" />
<h3><b>Task Done</b></h3>
<%List<LoginBean> beans=(List<LoginBean>)session.getAttribute("userList");%>
<html:form action="/taskDone">
<table>
<%for(LoginBean bean:beans) {%>
<tr>
	<th>DATE</th>
	<th><input type="text" id="staffid<%=bean.getStaffid() %>" value="<%=bean.getStaffid()%>"> </th>
</tr>
<%} %>
</table>
<button type="Submit">Submit</button>
<button type="Reset">Cancel</button>
</html:form>
</body>
</html>