<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body onload="myfunction()">
<p>"ID" <span id="sene1"></span></p>
<p>"Staff-id" <span id="staffid1"></span></p>
<p>"Password" <span id="pass1"></span></p>
</body>
<script type="text/javascript">
function myfunction(){
	document.getElementById("sene1").innerHTML= sessionStorage.getItem("sene");
	document.getElementById("staffid1").innerHTML = sessionStorage.getItem("staffid");
	document.getElementById("pass1").innerHTML = sessionStorage.getItem("pass");
}

//alert(sene);
//alert(staffid);
</script>
</html>