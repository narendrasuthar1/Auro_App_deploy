<%@page import="com.dhanrajapp.action.UpdateUsersAction"%>
<%@page import="com.dhanrajapp.util.Utility"%>
<%@page import="com.dhanrajapp.bean.LoginBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/stylesheet.css"%></style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<jsp:include page="adminnavbar.jsp" />
<jsp:include page="links.jsp" />
<H1 id="manage">Manage Users</H1>	
<br>
<%List<LoginBean> beans=(List<LoginBean>)session.getAttribute("userList");%>
<html:form styleId="manage" action="/updateUser" >
<table id="mytable" border=1>
<tr class="text">
<th>Seniority</th>
<th>StaffId</th>
<th>Password</th>
<th>Check</th>
</tr>
<%for(LoginBean bean:beans){%>
<tr  id=<%=bean.getId()%> >
<td><input class="text" type="text" id="sene<%=bean.getId()%>" name="sene" value="<%=bean.getSeniority()%>" disabled></td>
<td><input class="text" type="text" id="staffid<%=bean.getId()%>" name="staffid" value="<%=bean.getStaffid()%>" disabled></td>
<td><input class="text" type="text" id="pass<%=bean.getId()%>" name="pass" value="<%=bean.getPassword() %>" disabled></td>
<td><input class="text" type="checkbox" id="check<%=bean.getId()%>" onclick="check(<%=bean.getId()%>)" name="checkbox"></td>
</tr>
<%} %>
</table>
<input type="hidden" name="staffid12" id="staffValue">
<br>
<button  id="bt" type="submit">Update</button>
<button type="button" onclick="goBack()">Cancel</button>

</html:form>
<table id="mytable1" border="1"></table>
<script type="text/javascript">
function goBack(){
	window.location.href = 'login.jsp';
}
</script>

<script type="text/javascript">
function check(i){
	var checkbox=document.getElementById("check"+i);
	if(checkbox.checked==true){
		document.getElementById("sene"+i).disabled=false;
		document.getElementById("staffid"+i).disabled=false;
		document.getElementById("pass"+i).disabled=false;
	}
	else{
		document.getElementById("sene"+i).disabled=true;
		document.getElementById("staffid"+i).disabled=true;
		document.getElementById("pass"+i).disabled=true;
	}
}
</script>

<script type="text/javascript">
var sum=[];
$(function(){
$("#bt").click(function(){
    $('#mytable input[type=checkbox]:checked').each(function(){
    	var r1=$(this).closest('tr').attr('id');
    	sum.push(r1+"#"+document.getElementById("sene"+r1).value+"#"+document.getElementById("staffid"+r1).value+"#"+document.getElementById("pass"+r1).value);
    });	    
	document.getElementById("staffValue").value=sum;
  });
});
</script>
</body>
</html>	