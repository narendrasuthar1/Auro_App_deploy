<%@page import="com.dhanrajapp.db.LoginDao"%>
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
<meta http-equiv="refresh" content="600">
</head>
<body>
<%
LoginBean bean=(LoginBean)session.getAttribute("adminrequest");
PendingDao Dao=new PendingDao();
String licenseid=""+bean.getLicense();
List<PendingTaskBean> beans=Dao.getPending(licenseid);
%>
<%
if("Y".equals(bean.getAdmin())){ %>
<jsp:include page="adminnavbar.jsp" />
<%}
else
{%>
<jsp:include page="usernavbar.jsp" />
<%}%>

<!-- <h1 id="manage">Pending Task</h1> -->
<%
LoginDao dao=new LoginDao(); 
//List<String> staffList=dao.getStaffid(); %>

<div id="manage">
<input style="position: fixed;opacity:0.5;border: 1px solid red;border-radius: 5px;" type="text" id="search_text" autocomplete="off" size="80" name="searchbar" onclick="addTask()">
<!-- 
<button style="margin-left: 720px"><a href='deletedPendingTask.jsp'>Deleted Task</a></button> -->
<br>
<br>
<%if(Utility.listIsNullOrEmpty(beans)){ %>

<%}else{ %>
<table id="mytable" border="1">
<thead>
	<tr class="text">
	<% if("Y".equals(bean.getAdmin())){ %>
		<th>Del</th>
	<%}%>
	
		<th>Pending Task</th>
		<th>Urg</th>
		<th>Staff</th>
		<th>Status</th>
		<th>Remarks</th>
</tr>
</thead>
<tbody>
	<%for(PendingTaskBean bean1:beans){%>
<tr class="text" id="content">
	<% if("Y".equals(bean.getAdmin())){ %>
	<td style="text-align:center;" width=3% ><button id="del" style="border-width: thin;" onclick="deletebtn(<%=bean1.getId()%>,'delete')" type="button">.</button></td>
	<%}%>
	<td style="text-align: left;" width="34%"><%=bean1.getTask()%></td>
	<% if("Y".equals(bean.getAdmin())){ %>
	<td width=3% >
		 <button type="button" style="<%if(bean1.getUrg().equals("NO")) 
		 {%> background-color:; <%}else{ %> background-color:red;<%} %>  size: 10px;border-width: thin;"  id="button<%=bean1.getId()%>" onclick="randomColor(<%=bean1.getId()%>)">.</button>
 	</td>
	<%}else{ %>
	<td width=3% >
		 <button type="button" disabled="disabled" style="<%if(bean1.getUrg().equals("NO")) 
		 {%> background-color:; <%}else{ %> background-color:red;<%} %>  size: 10px;border-width: thin;"  id="button<%=bean1.getId()%>" onclick="randomColor(<%=bean1.getId()%>)">.</button>
 	</td>
	<%} %>
	<td  style="text-align: center;" onkeydown="enter(<%=bean1.getId()%>,this,'staffid')" contenteditable="true" width="5%"><%=bean1.getStaffid()%></td>
	
	<td  style="text-align: center;" onkeydown="enter(<%=bean1.getId()%>,this,'task_status')" contenteditable="true" width="5%"><%=bean1.getTask_status()%></td>
	
	<td id="test" style="text-align: left;"onkeydown="enter(<%=bean1.getId()%>,this,'remark')" contenteditable="true" width="55%"><%=bean1.getRemark()%></td>
</tr>
<%}%>
</tbody>
<tfoot></tfoot>
</table>
<%} %>

</div>
<%-- </html:form> --%>
</body>
<script>
$(function(){
    var textArea = $('#content'),
    hiddenDiv = $(document.createElement('div')),
    content = null;
    
    textArea.addClass('noscroll');
    hiddenDiv.addClass('hiddendiv');
    
    $(textArea).after(hiddenDiv);
    
    textArea.on('keyup', function(){
        content = $(this).val();
        content = content.replace(/\n/g, '<br>');
        hiddenDiv.html(content + '<br class="lbr">');
        $(this).css('height', hiddenDiv.height());
    });
});
</script>
<script>

	//*** Adding New Task script ***//

	function addTask(){
		
		var input = document.getElementById("search_text");
		input.addEventListener("keyup", function(event) {
		  if (event.keyCode === 13) {
		    
			  var x=document.getElementById("search_text").value;
				
			   $.ajax({			
					type   :  "GET",
					url : "addpending.do?taskName="+x,
					async : true,
					success : function(calculateAmount)
					{
						location.reload();
						
					}
					});
		   
		  }
		  
		});
	}
	//*** delete task by delete Button script ***//
	
	function deletebtn(i){
		var del_id=i;
		if (confirm("Do you want to Delete the Task?") == true) {
			var delvalue='NOT ACTIVE';
			var deltext='status';
			ajax1(del_id,delvalue,deltext);
		}
		
	}

	//*** color changes script ***//
	
    function randomColor(i){
        //clicks += 1;
		var color = ['red','blue'];
		var urgent;
		var urg_id=i;
		var urgtext='urg';
		var col =document.getElementById("button"+i).style.backgroundColor;
		if(col==color[0]){
			document.getElementById("button"+i).style.backgroundColor = color[1];
			urgent= 'NO';
		}
		else{
			document.getElementById("button"+i).style.backgroundColor = color[0];
			urgent= 'YES';
		}
		ajax1(urg_id,urgent,urgtext);	 
    };
    
  //*** staffid changes script ***//
  
	 function changes(value1){
	  
		var staffid= $(value1).closest('td').attr('id');
		var text='staffid';
		var staffvalue=value1.value;
		
		ajax1(staffid,staffvalue,text);
		/* alert("success"); */
		 /*  $('#staffid'+value1' option[value='value1']').prop('selected', true);   */
		
	}  
	
    
  //***Staffid, Status & Remark updation script ***//
    function enter(i,ele,text) {
        if(event.keyCode == 13||event.keyCode === 9) {
        	var id=i;
        	var name=text;
            var value = ele.innerText;
    		ajax1(id,value,name);
    		/* alert("success"); */
        }
    }
  
  	//*** Main Ajax Function ***//
 	function ajax1(id,value,name){
 		$.ajax({			
    		type   :  "GET",
    		url : "updatepending.do?id="+id+"&value="+value+"&name="+name,
    		async : true,
    		success : function(calculateAmount)
    		{
    			location.reload();
    		}
    		});
 	}
	</script>
	<script>
	$('#search_text').on('keyup',function(){
	    /* var table1 = $('#mytable').DataTable(); */
	    var table = $('#mytable').DataTable(); 
	      /*  table1.columns( 1 ).search($(this).val()).draw(); */
	       table.search($(this).val()).draw(); 
	});
	
//*** 	Remove Search box in datatable ***//
	$('#mytable').dataTable({
		bPaginate: false,
		sDom: 'lrtip',
		bSort : false
	});
	$(function() {
		  $("#mytable td").each(function() {
		    if ($(this).text() == ' '||$(this).text() == '') {
		      $(this).css('background-color', '#D3D3D3');
		    }
		    if ($(this).text() == 'Ready'||$(this).text() == 'Ok') {
			      $(this).css('background-color', '#00FF00');
			    }
		    if ($(this).text() == 'Fees') {
			      $(this).css('background-color', '#FFFF99');
			    }
		    if ($(this).text() == 'Recheck-Ready') {
			      $(this).css('color', 'red');
			    }
		  });
		});
</script>	
</html>