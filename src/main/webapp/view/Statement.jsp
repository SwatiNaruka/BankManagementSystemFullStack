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

<%@page import="com.bank.Bean.* "%>
<%@page import="com.bank.Dao.Imp.* "%>
<%@page import=" java.util.*" %>  

<div class="container openForm statement">
			<form method="post" action="../transction/generateStmt">
					<div class="row" style="margin:15px;">
						<div class="col-md-4">
							<label>Select Account No:</label>
						</div>
						<div class="col-md-8">
							<select class="form-select" aria-label="Default select example" name="values">
							<%Table tab= new Table();
							List<OpenAccount> x = tab.table();
							for(OpenAccount y : x){
							%>
								  <option ><%=y.getACno() %></option>
								  <%} %>
							</select>						
						</div>	
					</div>
					<div class="row"style="margin:15px;">
						<div class="col-md-5">
							<label>Transction Date from YYYY-MM-DD</label>
						</div>
						<div class="col-md-6">
							<input type="date"  name="startDate">
						</div>
					</div>
					<div class="row" style="margin:15px;">
						<div class="col-md-5">
							<label>Transction Date to YYYY-MM-DD</label>
						</div>
						<div class="col-md-5">
							<input type="date"  name="endDate">
						</div>
						<div class="col-md-2">
							<button type="submit"  class=" btn btn-primary btn-style" >Search</button>
						</div>
					</div>
			</form>
	<div class="row" style="margin:15px; margin-top:20px;">
			 <table id="mytable" class="table table-style table-striped table-hover" style="color: #ef6c00;">
	    <thead>
	      <tr>
	        <th>Account No</th>
	        <th>Transction Date</th>
	        <th>Transction Id</th>
	        <th>Deposit Amount</th>
	         <th>Withdraw Amount</th>
	         <th>Account Balance</th>	         
	      </tr>
	    </thead>
    <tbody>
    <%@page import="com.bank.Bean.* "%>
    <%@page import="com.bank.Dao.Imp.* "%>
    <%@page import=" java.util.*" %>       
      	<% 
      		List<StatementBean> b =(List<StatementBean>) request.getAttribute("statement");	 
	      	if(b !=null){      	
	      		for(StatementBean a:b){      			
	      	%>
      <tr>
	        <td><%=a.getAccNo() %></td>
	        <td><%=a.getTransactionDate() %></td>
	         <td><%=a.getTransctionId() %></td>
	        <td><%=a.getDepositBal() %></td>
	        <td><%=a.getWithdrawbal() %></td>
	         <td><%=a.getAccountBal() %></td>
        </tr>
       <%} }%>   
     
 
    </tbody>
  </table>
  
  
  	</div >
  	
  	
</div>
<div class="container" style="display: -webkit-box;">
	<form method="post" action="../files">
		<% 
			
		    List<StatementBean> b1 =(List<StatementBean>)request.getAttribute("statement");	 
		      if(b1 != null){      	
		      		//for(StatementBean a:b1){ 
		      	StatementBean s = (StatementBean)request.getAttribute("data");	
		      	System.out.println(s.getAccNo());
		      	%>
		<div class="row" style="margin:15px; margin-top:20px;">
			
			<div class="col-md-12" style="display:contents;">
				<input type="hidden" name="startDate" value="<%=s.getStartDate() %>">
				<input type="hidden" name="endDate" value="<%=s.getEndDate() %>">
				<input type="hidden" name="values" value="<%=s.getAccNo() %>">
				
				<P>Download Details As:</P>
					<select class="form-select" name="file" aria-label="Default select example" name="values" style="margin-left: 20px; width: fit-content; height: fit-content;font-size: 15px;">
						<option style="font-size: 14px;">PDF</option>
						<option style="font-size: 14px;">EXCEL</option>
					</select>
				<button type="submit" class=" btn btn-primary btn-style" style="height:34px;margin-top: -4px !important; margin-left: 10px;width: 62px;" >OK</button>			
			</div>
			
		</div>
		<% }%>
	</form>	
</div>			
</body>
</html>