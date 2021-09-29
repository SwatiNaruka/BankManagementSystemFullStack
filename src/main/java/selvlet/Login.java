package selvlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.Bean.DashBoard;
import com.bank.Dao.Imp.Table;

@WebServlet("/login")
public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user=req.getParameter("userID");
		String pass=req.getParameter("pass");
		
		if(user.equals("admin") && pass.equals("12345")) {
			HttpSession session =req.getSession();
			session.setAttribute("user" ,user);
			session.setAttribute("pass", pass);
			
			System.out.println("Login Sucess");
			Table obj = new Table();
			DashBoard a=obj.count();			
			if(a != null) {				
				req.setAttribute("value", a);
			}
			
					LocalDate date = LocalDate.now();
					LocalDate lastDate=date.withDayOfMonth(1);
					 
					
					DashBoard datecheck=new DashBoard();
					datecheck.setA(lastDate);
					datecheck.setB(date);
					
					System.out.println();
					DashBoard d=  obj.calculateDate(datecheck);	
					if(d !=null) {
					req.setAttribute("date", d);					
				}					
					RequestDispatcher rd=req.getRequestDispatcher("./view/main.jsp");
					rd.forward(req, resp);	
		}else {
			resp.sendRedirect("index.html");
			System.out.println("login failed");

		}
		
		
	}
	
}
