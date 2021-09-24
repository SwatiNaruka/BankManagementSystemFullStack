<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../StyleCss/index.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script src="https://kit.fontawesome.com/732623e199.js" ></script>

</head>
<body>
<%@ include file="Header.html"%>

<div class="tableStyle">
		<input type="text"value=""id="myinput"onkeyup="myFunction()" placeholder="search Account no">
	
	
</div>	
	
	 <table id="mytable" class="table table-style table-striped table-hover">
	    <thead>
	      <tr>
	        <th>Account No</th>
	        <th>Name</th>
	        <th>Father Name</th>
	        <th>Gender</th>
	         <th>Merital status</th>
	         <th>Type Of account</th>
	         <th>Date Of Birth</th>
	         <th>Service Required</th>
	         <th>Balance</th>
	          <th>Photo</th>
	      </tr>
	    </thead>
    <tbody>
    <%@page import="com.bank.Bean.* "%>
    <%@page import="com.bank.Dao.Imp.* "%>
    <%@page import=" java.util.*" %>    
      <tr>
      	<% Table ac = new Table();
      		List<OpenAccount> x = ac.table();
      		for(OpenAccount y : x){
       	%>
      
        <td><%=y.getACno() %></td>
        <td><%=y.getName() %></td>
         <td><%=y.getFatherName() %></td>
        <td><%=y.getGender() %></td>
        <td><%=y.getMeritalStatus() %></td>
         <td><%=y.getTypeOfAc() %></td>
         <td><%=y.getDOB() %></td>
        <td><%=y.getServiseRequired() %></td>
        <td><%=y.getAmount() %></td>
        <td><%=y.getPhotoName() %></td>
        
        
      </tr>
     <%} %>
   
    </tbody>
  </table>
  

<script type="text/javascript" src="../Js/index.js"></script>
</body>
</html>