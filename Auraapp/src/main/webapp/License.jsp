<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<jsp:include page="adminnavbar.jsp" />
<jsp:include page="links.jsp" />
<h3>License Form</h3>
<html:form action="/license">
<table>
<tr>
	<td>Name:</td>
	<td><html:text property="name"></html:text></td>
</tr>
<tr>
	<td>Address:</td>
	<td><html:text property="address"></html:text></td>
</tr>
<tr>
	<td>Mobile No.:</td>
	<td><html:text property="mobile"></html:text></td>
</tr>
<tr>
	<td>Email:</td>
	<td><html:text property="email"></html:text></td>
</tr>
<tr>
	<td>Registration Date:</td>
	<td><html:text property="regdate" styleId="regdate" readonly="True"></html:text></td>
</tr>
<tr>
	<td>Expiry Date:</td>
	<td><html:text property="expdate" styleId="expdate" readonly="True"></html:text></td>
</tr>
</table>
<button type="submit">Submit</button>
<button type="reset">Cancel</button>
</html:form>

</body>
<script type="text/javascript">
var today = new Date();
var dd = today.getDate();

var mm = today.getMonth()+1; 
var yyyy = today.getFullYear();
if(dd<10) 
{
    dd='0'+dd;
} 

if(mm<10) 
{
    mm='0'+mm;
} 
today = dd+'/'+mm+'/'+yyyy;
document.getElementById("regdate").value=today;
yyyy=yyyy+1;
var today1 = dd+'/'+mm+'/'+yyyy;
document.getElementById("expdate").value=today1;
</script>
</html>