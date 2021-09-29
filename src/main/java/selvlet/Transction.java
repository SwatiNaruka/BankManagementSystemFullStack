package selvlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bank.Bean.*;
import com.bank.Dao.Imp.CashOPerationImp;
import com.bank.Dao.Imp.Table;
import com.bank.service.TransctionService;
import com.bank.service.TransctionServiceIMP;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@WebServlet("/transction/*")
public class Transction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		
		String path=request.getServletPath().concat(request.getPathInfo());
		
		if(path.equals("/transction/cashDeposit")){
			System.out.println("deposit Ammount");
			OpenAccount x=new OpenAccount();
			DepositBean dep=new DepositBean();
			dep.setAccno(Integer.parseInt(request.getParameter("num")));
			dep.setDate(request.getParameter("date"));
			dep.setBalance(Integer.parseInt(request.getParameter("depBal")));
			
			dep.setWithdrawBalance(0);
			int bal=Integer.parseInt(request.getParameter("bal"));
			int depositbal=Integer.parseInt(request.getParameter("depBal"));
			//int sum = bal+depositbal;
			
			TransctionService t = new TransctionServiceIMP();
			int sum = t.deposit(bal, depositbal);			
			x.setAmount(sum);
			x.setACno(Integer.parseInt(request.getParameter("num")));
			CashOPerationImp cash=new CashOPerationImp();
			int status = cash.AddCashDeposit(dep, x);
			PrintWriter out = response.getWriter();
			if(status>=0) {
				System.out.println("cash deposited");
				request.setAttribute("status", status);
				  RequestDispatcher rd=request.getRequestDispatcher("../view/DepositDisplay.jsp");
				  rd.forward(request, response);
				  response.setContentType("text/html");
					out.print("<script>alert('Cash Deposited')</script>");
			}
		}		
		if(path.equals("/transction/cashWithdraw")) {
			System.out.println("hello CashWithdraw");
			OpenAccount x=new OpenAccount();
			WithdrawBean withdraw = new WithdrawBean();
			withdraw.setAccNo(Integer.parseInt(request.getParameter("num")));
			withdraw.setBalance(Integer.parseInt(request.getParameter("withBal")));
			withdraw.setDebitDate(request.getParameter("date"));
			withdraw.setDepositBalance(0);
			x.setACno(Integer.parseInt(request.getParameter("num")));
			
			int bal=Integer.parseInt(request.getParameter("bal"));
			int withdrawBal=Integer.parseInt(request.getParameter("withBal"));
			//int subtract;
			
			TransctionService t = new TransctionServiceIMP();
				
			int  subtract = t.subtract(withdrawBal, bal);
				
			  	x.setAmount(subtract);
			
				
			
			CashOPerationImp obj=new CashOPerationImp();
			int status = obj.AddCashWithDraw(withdraw,x);
			if(status >=0) {
				System.out.println("cash withdraw sucessfull");
				request.setAttribute("status1", status);		
				RequestDispatcher rd=request.getRequestDispatcher("../view/WithdrawDisplay.jsp");
				rd.forward(request, response);
			}			
		}
		
		if(path.equals("/transction/generateStmt")) {
			System.out.println("generate");
			String val=request.getParameter("values");			
			StatementBean obj=new StatementBean();
			
			obj.setAccNo(Integer.parseInt(val));
			obj.setStartDate(request.getParameter("startDate"));
			obj.setEndDate(request.getParameter("endDate"));
			
			
			request.setAttribute("data", obj);
			Table t =new Table();
			
			List<StatementBean> s =t.statementTable(obj);			
			if(s!=null) {
				
				request.setAttribute("statement", s);				
				RequestDispatcher rd=request.getRequestDispatcher("../view/Statement.jsp");
						rd.forward(request, response);
			}
		}		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
