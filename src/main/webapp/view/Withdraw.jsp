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

<div class="container" style="width:70%;">	
	 <form  action="../Acc/getInfoWithdraw" method="post"class="depositInfo">			
				 <div class="row openFormStype">
							<div class=" col-md-3">
									<label>Account No:</label>
							</div>					
							<div class="col-md-9 " style="display: inherit;">							
									<input type="text" class="form-control" placeholder="Enter Ac number" name="Aname">
									<input type="submit"  class=" btn btn-primary acc-style" value="Get Details" >
							</div>							
				</div>
		</form>	
		

<%@page import="com.bank.Bean.*"%> 
<%@page import=" java.util.*" %>
<%@page import="com.bank.Dao.*;"%> 
		<div id="deposit">		
			<form  action="../transction/cashWithdraw" method="post" class="depositAmount">			
				 <div class="row " style="margin-bottom:33px;">				
							<div class="col-md-6 ">			
									
									<% OpenAccount x =(OpenAccount) request.getAttribute("account");
										//System.out.println("obj ="+obj);
										if(x !=null){
										
									%>
									<label>Account No:</label>										
									<input type="text" class="form-control" name="num" value="<%=x.getACno() %>">
							
							</div>
							<div class="col-md-6">	
									<label>Name:</label>				
									<input type="text" class="form-control" name="name"value="<%= x.getName()%>">
							</div>							
				</div>
				 <div class="row " style="margin-bottom:33px;">				
							<div class="col-md-6">	
									<label>Date:</label>
									<% long millis=System.currentTimeMillis();
										java.sql.Date date=new java.sql.Date(millis); 
									%>													
									<input type="text" class="form-control" name="date" value="<%= date.toString()%>">
							</div>
							<div class="col-md-6">	
									<label>Available Balance:</label>				
									<input type="text" class="form-control" name="bal" value="<%=x.getAmount()%>">
							</div>							
				</div>
				 <div class="row " style="margin-bottom:33px;">				
							<div class="col-12">	
									<label>Withdraw Amount:</label>													
									<input type="text" class="form-control" placeholder="Enter withdraw Amount" name="withBal" value="">
							</div>
				</div>				
				<div class="row  AccBtn" style="margin-bottom:33px;">
					<div class=" col-12">
					<button type="submit"  class=" btn btn-primary btn-style" >Cash Withdraw</button>
					</div>
				</div>
		</form>		
		
		
	</div>
	<% }%>
</div>

</body>
</html>