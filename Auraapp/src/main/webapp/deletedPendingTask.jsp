<%@page import="com.dhanrajapp.db.PendingDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.dhanrajapp.util.Utility"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.dhanrajapp.bean.LoginBean"%>
<%@page import="com.dhanrajapp.bean.PendingTaskBean"%>
<%@page import="com.dhanrajapp.action.UpdateUsersAction"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/stylesheet.css"%></style>
</head>
<body>
<%
LoginBean bean=(LoginBean)session.getAttribute("adminrequest");
PendingDao Dao=new PendingDao();
String licenseid=""+bean.getLicense();
List<PendingTaskBean> beans=Dao.getDeletedPending(licenseid);
%>
<jsp:include page="adminnavbar.jsp" />


<h1 id="manage">Deleted Task</h1>
<br>
<html:form styleId="manage" action="/addpending">

<%if(Utility.listIsNullOrEmpty(beans)){ %>

<%}else{ %>
<table border="1">
<tr class="text">
	<th>DEL</th>
	<th>Pending Task</th>
	<th>URG</th>
	<th>Staff ID</th>
	<th>Status</th>
	<th>Remarks</th>
</tr>
<%for(PendingTaskBean bean1:beans){%>
<tr class="text">
	<td><button id="del" onclick="deletebtn(<%=bean1.getId()%>)" type="button">X</button></td>
	
	<%
	String task_status=bean1.getTask_status();
	if(Utility.stringIsNullOrEmpty(task_status)){
		task_status="";
	}
	
	String remark=bean1.getRemark();
	if(Utility.stringIsNullOrEmpty(remark)){
		remark="";
	}
	
	%>
	<td><input id="task<%=bean1.getTask()%>" value="<%=bean1.getTask()%>" readonly></td>
	<td>
		 <button type="button" style="<%if(bean1.getUrg().equals("NO")) 
		 {%> background-color:blue; <%}else{ %> background-color:red;<%} %> size: 10px;" id="button<%=bean1.getId()%>" >.</button>
 	</td>
	<td id=<%=bean1.getId()%>>
	<%
	String beanId=""+bean1.getId();
	if(Utility.stringIsNullOrEmpty(bean1.getStaffid())){ %>
		<input id="task<%=bean1.getStaffid()%>" readonly>
	<%}else{ %>
		<input id="task<%=bean1.getStaffid()%>" value="<%=bean1.getStaffid()%>" readonly>
	<% }%>	
	</td>
	<td><input type="text" id="<%=bean1.getId()%>" value="<%=task_status%>" name="status" readonly></td>
	<td><input type="text" id="remark" value="<%=remark %>" name="remark" readonly></td>
</tr>
<%} %>
</table>
<%} %>
</html:form>
</body>
<script type="text/javascript">

</script>
</html>