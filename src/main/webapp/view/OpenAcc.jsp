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
	
		 <form  action="../Acc/openAc" method="post"class="openForm"  enctype="multipart/form-data">
				 <div class="row openFormStype">
							<div class=" col-md-3">
									<label>Full Name:</label>
							</div>					
							<div class="col-md-8">							
									<input type="text" class="form-control" placeholder="Enter Your full name" name="name">
							</div>
				</div>
				
				<div class="row openFormStype">
							<div class=" col-md-3">
									<label>Father Name:</label>
							</div>					
							<div class="col-md-8">							
									<input type="text" class="form-control" placeholder="Enter Your full name" name="fname">
 						</div>
				</div>	
				<div class="row openFormStype">
					<div class=" col-md-3">
									<label for="gender">Gender: </label>
							</div>
					    
				              <input type="radio" id="gender" name="gender" value="male" class="inputStyle"/>Male  
				              <input type="radio" id="gender" name="gender" value="female"class="inputStyle"/>Female		 
				              <input type="radio" id="gender" name="gender" value="others"class="inputStyle"/>Others <br/>  
				</div>
				
				<div class="row openFormStype">
					<div class="col-md-3">						
						<label for="marital">Martal Status: </label> 
					</div> 
			              <input type="radio" id="marital" name="marital" value="married"class="inputStyle"/>Married  
			              <input type="radio" id="marital" name="marital" value="single"class="inputStyle"/>Single <br/>  
				</div>
				<div class="row openFormStype">
					<div class="col-md-3">
						<label for="account">Type of Account: </label>  
					</div>	
			              <input type="radio" id="account" name="account" value="Current Account"class="inputStyle"/>Current Account  
			              <input type="radio" id="account" name="account" value="Saving Account"class="inputStyle"/>Saving Account			              
			             <br/>  
				
				</div>
				<div class="row openFormStype">
							<div class=" col-md-3">
									<label>Date of Birth:</label>
							</div>					
							<div class="col-md-8">	
										<input type="date" name="begin" placeholder="yyyy-mm-dd" value="" min="1997-01-01" max="2030-12-31" name="date">					
										
							</div>
				</div>
				<div class="row openFormStype">
					<div class="col-md-3">
							<label for="service">Service Required: </label>
					</div>		  
			              <input type="radio" id="service" name="service" value="atm card" class="inputStyle"/>ATM Card  
			              <input type="radio" id="service" name="service" value="mobile Banking" class="inputStyle"/>Mobile Banking 			              
			              <input type="radio" id="service" name="service" value="net Banking" class="inputStyle"/>Net Banking 
			              <input type="radio" id="service" name="service" value="cheque Book" class="inputStyle"/>Cheque Book <br/>  
							
				</div>
				<div class="row openFormStype">
							<div class=" col-md-3">
									<label>Opening Amount:</label>
							</div>					
							<div class="col-md-8">							
									<input type="text" class="form-control" name="amount">
							</div>
				</div>	
				
				<div class="row openFormStype">
					<div class=" col-md-3">
							<label>Select Photo:</label> 
					</div>				
				         <input type="file" name="uploadFile" name="photo" />				         
				</div>
				
				<div class="row  AccBtn">
					<div class=" col-12">
					<button type="submit"  class=" btn btn-primary btn-style" >Open Account</button>
					</div>
				</div>
		 </form>
	
</div>


		

</body>
</html>