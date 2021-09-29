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
<body style="min-height: 1100px;">
<%@ include file="./Header.html" %>
<%@page import=" java.util.*" %>
<%@page import="com.bank.Bean.*"%> 
<%@page import="com.bank.Dao.*;"%> 

<div class="container">
	<div class="row">
		<div class="col-md-5 dashboard custmoreDiv"  >
		
			<i class="fas fa-users"></i>
			<h5>Total Account Holders </h5>
			
			<% DashBoard obj = (DashBoard)request.getAttribute("value");
				if(obj !=null){
			%>
			<p style="font-weight: 700;color: black;font-size: 27px;"><%=obj.getNum() %></p>
			
			<%} %>
			
		</div>
		<div class="col-md-5 dashboard transctionDiv custmoreDiv">
				<i class="fas fa-random"></i>
				<h5>Total Transction of this month</h5>
				
				<% DashBoard a = (DashBoard)request.getAttribute("date");
				if(a !=null){
			%>
			<p style="font-weight: 700;color: black;font-size: 27px;"><%=a.getNum() %></p>
			
			<%} %>
			
		</div>
	
	</div>
	
	
<div class="container">
		<div class="row">
			<div class="col-md-12">
			
					<strong >
						<img alt="" src="../image/Bank.png" class="image-chief">
					</strong>
			<P style="padding: 50px; font-size: 18px;text-align: center;color: #300759;">
					In this application, At dashboard we can see the total account holder and total transaction of current month.<br>
					Management can login and open customer account and do further processing like deposit, Withdraw, Manage Account and generate statement and can Access and Manage all the details of Customer like name, age, Services and Date of birth and can also close the  Account if required 
					<br>After keeping the record, we generate report on the monthly and half monthly on the basis of given date to date. Statement is generated in PDF and excel format of each customer and download at client side.
			
			</P>

			</div>
			
			<div class="col-md-12" style="text-align: center;">
				<h3 style="font-weight: 400; color:#ef6c00;">Technologies we Used for Front-end</h3>
				<ul>
					<li >HTML </li>
					
					<li>CSS</li>
					<li>JQUERY</li>
					<li>BOOTSTRAP</li>
				</ul>
				
			<h3 style="font-weight: 400; color:#ef6c00;">Technologies we Used for Back-end</h3>
				<ul>
					<li>JSP</li>
					<li>Servlet </li>
					<li>MySQL for DATABASE</li>
					
				</ul>	
				
			
			</div>
		</div>

</div>
	
		
	
	
</div>
<div class="container graph">

</div>



<script type="text/javascript" src="../Js/index.js"></script>

</body>
</html>