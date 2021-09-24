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
	<form action="../Acc/manageAcDetail" method="post"class="openForm" >
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
		 <form  action="../Acc/manageAc" method="post"class="openForm" >
				 <div class="row openFormStype">
							<div class=" col-md-3">
							<% 
								OpenAccount obj=(OpenAccount) request.getAttribute("detail");
							if(obj !=null){
							%>
									<label>Full Name:</label>
							</div>					
							<div class="col-md-8">							
									<input type="text" class="form-control" value="<%=obj.getName() %>" name="name" />
							</div>
				</div>				
				<div class="row openFormStype">
					<div class="col-md-3">
						<label>Account number :</label>	
					</div>
					<div class="col-md-6">
						<input type="text" class="form-control" placeholder="Enter Your Account Number" name="accNo"value="<%=obj.getACno() %>">
					</div>
				</div>				
				<div class="row openFormStype">
							<div class=" col-md-3">
									<label>Father Name:</label>
							</div>					
							<div class="col-md-8">							
									<input type="text" class="form-control" placeholder="Enter Your full name" name="fname" value="<%=obj.getFatherName() %>">
 						</div>
				</div>	
				<div class="row openFormStype">
					<div class=" col-md-3">
									<label for="gender">Gender: </label>
							</div>
					   
				         <div class="col-md-8">							
									<input type="text" class="form-control" name="gender" value="<%=obj.getGender() %>">
 						</div>     
				              
				</div>
				
				<div class="row openFormStype">
					<div class="col-md-3">						
						<label for="marital">Martal Status: </label> 
					</div> 
					 <div class="col-md-8">							
									<input type="text" class="form-control" name="maritalStst" value="<%=obj.getMeritalStatus()%>">
 						</div> 
			               
				</div>
				<div class="row openFormStype">
					<div class="col-md-3">
						<label for="account">Type of Account: </label>  
					</div>	
					 <div class="col-md-8">							
									<input type="text" class="form-control" name="tyOA" value="<%=obj.getTypeOfAc() %>">
 						</div> 
				
				</div>
				<div class="row openFormStype">
							<div class=" col-md-3">
									<label>Date of Birth:</label>
							</div>					
							<div class="col-md-8">	
										<input type="date" placeholder="yyyy-mm-dd" name="Bdate" value="<%=obj.getDOB() %>">					
										
							</div>
				</div>
				<div class="row openFormStype">
					<div class="col-md-3">
							<label for="service">Service Required: </label>
					</div>
					 <div class="col-md-8">							
									<input type="text" class="form-control" name="serviceRequired" value="<%=obj.getServiseRequired() %>">
 						</div> 
				</div>
				<div class="row openFormStype">
							<div class=" col-md-3">
									<label>Opening Amount:</label>
							</div>					
							<div class="col-md-8">							
									<input type="text" class="form-control" name="amount" value="<%=obj.getAmount() %>">
							</div>
				</div>	
				
				<%-- <div class="row openFormStype">
					<div class=" col-md-3">
							<label>Select Photo:</label> 
					</div>				
				         <input type="file" name="uploadFile" name="photo" />
				         <img style="width:100px;height:100px;"alt="" src="<%= request.getContextPath()+("/upload/").concat(obj.getPhotoName())%>">				         
				</div> --%>
				
				<div class="row  AccBtn">
					<div class=" col-12">
					<input type="submit"  class=" btn btn-primary btn-style" value="Modify" >
					</div>
				</div>
				<%} %>
		 </form>
	
</div>



</body>
</html>