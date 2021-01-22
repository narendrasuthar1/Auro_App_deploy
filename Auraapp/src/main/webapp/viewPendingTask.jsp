<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dhanrajapp.util.Utility"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.dhanrajapp.bean.LoginBean"%>
<%@page import="com.dhanrajapp.bean.PendingTaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/stylesheet.css"%></style>
</head>
<body>
<%LoginBean bean=(LoginBean)session.getAttribute("adminrequest");
if("Y".equals(bean.getAdmin())){ %>
<jsp:include page="adminnavbar.jsp" />
<%}
else
{%>
<jsp:include page="usernavbar.jsp" />
<%}%>

<%List<PendingTaskBean> bean1 = (List<PendingTaskBean>)session.getAttribute("pendinglist");%>
<h1 id="manage">VIEW TASK</h1>
<html:form styleId="manage" action="/viewpending" >
<table  border="1">
<tr class="text">
	<th>Staff Id</th>
	<th>Finish</th>
	<th>Client Name</th>
	<th>Pending Task</th>
	<% if("Y".equals(bean.getAdmin())){ %>
	<th>Del</th>
	<%}%>
	
</tr>
<%for(PendingTaskBean beans:bean1){%>
<tr  id=<%=beans.getId()%> >
	<td><input class="text" type="text" id="staffid<%=beans.getStaffid()%>" name="staffid" value="<%=beans.getStaffid()%>" disabled></td>
	<td><input size="1" class="text" type="text" id="finish" maxlength="1" name="finish"></td>
<%-- 	<td><input class="text" type="text" id="sene<%=beans.getClientname()%>" name="sene" value="<%=beans.getClientname()%>" disabled></td>
 --%>	<%if(beans.getTask().contains("urgent")||beans.getTask().contains("Urgent")||beans.getTask().contains("URGENT")){%>
	<td><input class="text" type="text" id="task<%=beans.getTask()%>" name="sene" style="color:red" value="<%=beans.getTask()%>" disabled></td>
	<%}else{ %>
		<td><input class="text" type="text" id="task<%=beans.getTask()%>" name="sene" value="<%=beans.getTask()%>" disabled></td>
	<%} %>
	<% if("Y".equals(bean.getAdmin())){ %>
	<td><button class="text" type="button" value="Delete">X</button></td>
	<%}%>
</tr>
<%} %>
</table>
</html:form>
</body>
</html>