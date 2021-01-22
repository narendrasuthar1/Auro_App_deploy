<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<style><%@include file="/stylesheet.css"%></style>
</head>
<body id="manage" class="text">
<jsp:include page="links.jsp" />
<br>
<h3 ><b>AURA TECHNOLOGIES</b></h3>
<img alt="logo" src="<html:rewrite page='/aura.png'/>" width="20%" height="20%"/>    
<html:form action="/login" styleClass="text">
<table style="margin-left:auto; margin-right:auto">
<tr>
<td>License No.:</td>
<td><html:text property="licenseNo"></html:text></td>
</tr>
<tr>
<td>Staff Id:</td>
<td><html:text property="staffId"></html:text></td>
</tr>
<tr>
<td>Password:</td>
<td><html:password property="password"></html:password></td>
</tr>
</table>
<br>
<button style="margin-left:88px" type="Submit">Submit</button>
<button type="Reset">Cancel</button>
</html:form>
</body>
<a href="License.jsp">License Table</a> 
</html>