<%@page import="com.dhanrajapp.bean.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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

<h1 id="manage">New Task</h1>
<br>
<html:form styleId="manage" styleClass="manage" >
	<table>
		<tr>
			<td>Staff Id:</td>
			<%
			if("Y".equals(bean.getAdmin())){ %>
			<td>
			<html:select property="staffId">
			<html:options property="staffList"/>
			</html:select>
			</td>
		<%}else{%>
			<td><html:text styleId="staffId" property="staffId" readonly="true" value="<%=bean.getStaffid() %>"></html:text></td>
		<%} %>
		</tr>
		<tr>
			<td>Client Name:</td>
			<td><html:text styleId="clientName" property="clientName"></html:text></td>
		</tr>
		<tr>
			<td>Pending Task:</td>
			<td><html:textarea styleId="pendingText" property="pendingText"></html:textarea></td>
		</tr>
	</table>
	<br>
	<button id="submit" style="margin-left: 102px" onclick="clear()" type="submit" >Submit</button>
	<button type="Reset">Cancel</button>
</html:form>
<script type="text/javascript">
function clear(){
	document.getElementById("clientName").value=null;
	document.getElementById("pendingText").value=null;
}
</script>
</body>
</html>