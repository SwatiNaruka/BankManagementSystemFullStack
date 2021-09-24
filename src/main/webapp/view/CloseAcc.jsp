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

<div class="container">
	<form action="../Acc/getDetail" method="post"class="openForm" >
			<div class="row openFormStype">
				
				<div class="col-md-3">
					<label>Account number</label>	
				</div>
				<div class="col-md-6">
					<input type="text" class="form-control" placeholder="Enter Your Account Number" name="acNo">
				</div>
				<input type="submit"  class=" btn btn-primary acc-style" value="Get Details" >
			</div>	
	</form>
	
	<%@page import="com.bank.Bean.* "%>
    <%@page import="com.bank.Dao.Imp.* "%>
    <%@page import=" java.util.*" %>  
    
</div>
<div class="container">
		 <form  action="../Acc/closeAc" method="post"class="openForm" >
		 <% 
		 	OpenAccount a =(OpenAccount) request.getAttribute("detail");
		 	if(a != null){		 	
		 %>
		 		<div class="row openFormStype">
					<div class=" col-md-3">
									<label>Account No: </label>
							</div>					   
				         <div class="col-md-8">							
									<input type="text" class="form-control" name="Acno" value="<%=a.getACno() %>">
 						</div> 		              
				</div>
				<div class="row openFormStype">
					<div class=" col-md-3">
									<label>Name: </label>
							</div>					   
				         <div class="col-md-8">							
									<input type="text" class="form-control" name="name" value="<%= a.getName()%>">
 						</div> 		              
				</div>
				<div class="row openFormStype">
					<div class=" col-md-3">
									<label >Balance: </label>
							</div>					   
				         <div class="col-md-8">							
									<input type="text" class="form-control" name="balance" value="<%= a.getAmount()%>">
 						</div> 		              
				</div>
				<div class="row"style="text-align: center;">
					<div class=" col-12">
					<button type="submit"  class=" btn btn-primary btn-style" value="Delete" >Delete</button>
					</div>					   
				         	              
				</div>
		 <%} %>
		 </form>
</div>		 

</body>
</html>