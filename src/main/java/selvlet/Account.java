package selvlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bank.Bean.OpenAccount;
import com.bank.Dao.Imp.AccountForm;
import com.bank.Dao.Imp.CashOPerationImp;
@WebServlet("/Acc/*")
public class Account extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "upload";
	 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 60; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 100; // 50MB
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String path=req.getServletPath().concat(req.getPathInfo());
			
		if(path.equals("/Acc/closeAc")){
			
			OpenAccount obj =new OpenAccount();
			obj.setACno(Integer.parseInt(req.getParameter("Acno")));
			AccountForm a= new AccountForm();
			int status =a.DeleteAccount(obj);
			if(status >0) {
				req.setAttribute("delete", status);
				RequestDispatcher rd=req.getRequestDispatcher("../view/CloseAccDisplay.jsp");
				rd.forward(req, resp);
			}
			
		}
		if(path.equals("/Acc/openAc")){
			
			String name = null,fname=null,gander=null,maritalStatus=null,TypeOfAcc=null,Dob=null,serviceAcc=null,OpemAmount=null;
			
			 if (!ServletFileUpload.isMultipartContent(req)) {
		            // if not, we stop here
		            PrintWriter writer = resp.getWriter();
		            writer.println("Error: Form must has enctype=multipart/form-data.");
		            writer.flush();
		            return;
		        }		 
		        // configures upload settings
		        DiskFileItemFactory factory = new DiskFileItemFactory();
		        // sets memory threshold - beyond which files are stored in disk
		        factory.setSizeThreshold(MEMORY_THRESHOLD);
		        // sets temporary location to store files
		        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));		 
		        ServletFileUpload upload = new ServletFileUpload(factory);
		         
		        // sets maximum size of upload file
		        upload.setFileSizeMax(MAX_FILE_SIZE);
		         
		        // sets maximum size of request (include file + form data)
		        upload.setSizeMax(MAX_REQUEST_SIZE);
		 
		        // constructs the directory path to store upload file
		        // this path is relative to application's directory
		        String uploadPath = getServletContext().getRealPath("")
		                + File.separator + UPLOAD_DIRECTORY;
		         
		        // creates the directory if it does not exist
		        File uploadDir = new File(uploadPath);
		        if (!uploadDir.exists()) {
		            uploadDir.mkdir();
		        }
		 
		        try {
		            // parses the request's content to extract file data
		            @SuppressWarnings("unchecked")
		            List<FileItem> formItems = upload.parseRequest(req);
		            OpenAccount x=new OpenAccount();
		            if (formItems != null && formItems.size() > 0) {
		                // iterates over form's fields
		                for (FileItem item : formItems) {
		                    // processes only fields that are not form fields
		                	if(item.isFormField()) {
		                		if(item.getFieldName().equals("name")) {
		                			name=item.getString();
		                			x.setName(name);
		                			
		                		}else if(item.getFieldName().equals("fname")) {
		                			fname=item.getString();
		                			x.setFatherName(fname);
		                			
		                		}else if(item.getFieldName().equals("gender")) {
		                			 gander=item.getString();
		                			x.setGender(gander);
		                			
		                		}else if(item.getFieldName().equals("marital")) {
		                			maritalStatus=item.getString();
		                			x.setMeritalStatus(maritalStatus);
		                		}else if(item.getFieldName().equals("account")) {
		                			TypeOfAcc=item.getString();
		                			x.setTypeOfAc(TypeOfAcc);
		                			
		                		}else if(item.getFieldName().equals("begin")) {
		                			Dob=item.getString();
		                			System.out.println("DOB:"+Dob);
		                			x.setDOB(Dob);
		                			
		                		}else if(item.getFieldName().equals("service")) {
		                			serviceAcc=item.getString();
		                			x.setServiseRequired(serviceAcc);
		                		}else if(item.getFieldName().equals("amount")) {
		                			OpemAmount=item.getString();
		                			x.setAmount(Integer.parseInt(OpemAmount));
		                		}
		                	}
		                	
		                    if (!item.isFormField()) {
		                        String fileName = new File(item.getName()).getName();
		                        String filePath = uploadPath + File.separator + fileName;
		                        File storeFile = new File(filePath);
		 
		                        // saves the file on disk
		                        item.write(storeFile);
		                       x.setPhotoName(fileName); 
		                       Random rm =new Random();
		           				int xm =rm.nextInt(10001);
		                       x.setACno(xm);
		                       AccountForm obj=new AccountForm();
		                       
		                      int status= obj.submitFormData(x);
		                      	if(status >0) {
		                      		System.out.println("data inserted");
								        				resp.getWriter().print("data submmited");
		                      	}
								  req.setAttribute("message", "Upload has been done successfully!");
		                    }
		                }
		            }
		        } catch (Exception ex) {
		        	req.setAttribute("message",
							"There was an error: " + ex.getMessage());
		        }
		        // redirects client to message page
		        getServletContext().getRequestDispatcher("/message.jsp").forward(
		                req, resp);
		}
		if(path.equals("/Acc/manageAcDetail")) {
			System.out.println("get information");
			OpenAccount x=new OpenAccount();
			x.setACno(Integer.parseInt(req.getParameter("acNo")));
			AccountForm obj =new AccountForm();
			
			OpenAccount list = obj.getAccountDetail(x);
			if(list !=null) {
				req.setAttribute("detail", list);
				System.out.println("list= "+list);
				RequestDispatcher rd=req.getRequestDispatcher("../view/Manage.jsp");
				rd.forward(req, resp);
				
			}
			
		}
		if(path.equals("/Acc/getDetail")) {
			System.out.println("get information");
			OpenAccount x=new OpenAccount();
			x.setACno(Integer.parseInt(req.getParameter("acNo")));
			AccountForm obj =new AccountForm();
			
			OpenAccount list = obj.getAccountDetail(x);
			if(list !=null) {
				req.setAttribute("detail", list);
				
				RequestDispatcher rd=req.getRequestDispatcher("../view/CloseAcc.jsp");
				rd.forward(req, resp);
			}
			
		}
		if(path.equals("/Acc/manageAc")){	
			
			System.out.println("manage account");
			
			  OpenAccount x =new OpenAccount();
			  
			  x.setName(req.getParameter("name"));
			  x.setACno(Integer.parseInt(req.getParameter("accNo")));
			  x.setFatherName(req.getParameter("fname"));
			  x.setGender(req.getParameter("gender"));
			  x.setMeritalStatus(req.getParameter("maritalStst"));
			  x.setTypeOfAc(req.getParameter("tyOA"));
			  x.setDOB(req.getParameter("Bdate"));
			  x.setServiseRequired(req.getParameter("serviceRequired"));
			  x.setAmount(Integer.parseInt(req.getParameter("amount")));
		
			  AccountForm y = new AccountForm(); 
			  int status = y.ModifyData(x); 
			  if(status >= 0) {
				  System.out.println("accountManages");
				  req.setAttribute("update", status);
				  RequestDispatcher rd=req.getRequestDispatcher("../view/ManageAccDisplay.jsp");
				  rd.forward(req, resp); 
			  		
			  		
			  }
		}
		if(path.equals("/Acc/getInfodeposit")){
			String name=req.getParameter("Aname");
			OpenAccount x = new OpenAccount();
			x.setACno(Integer.parseInt(name));
					System.out.println(x.getACno());
					CashOPerationImp obj= new CashOPerationImp();	
					OpenAccount y =	obj.getInfo(x);
					if(y!=null) {
						req.setAttribute("account", y);
						//System.out.println("y=" +y);
						RequestDispatcher rd=req.getRequestDispatcher("../view/Deposit.jsp");
								rd.forward(req, resp);
					}
		}
		if(path.equals("/Acc/getInfoWithdraw")){
			String name=req.getParameter("Aname");
			OpenAccount x = new OpenAccount();
			x.setACno(Integer.parseInt(name));
					System.out.println(x.getACno());
					CashOPerationImp obj= new CashOPerationImp();	
					OpenAccount y =	obj.getInfo(x);
					if(y!=null) {
						req.setAttribute("account", y);
						//System.out.println("y=" +y);
						RequestDispatcher rd=req.getRequestDispatcher("../view/Withdraw.jsp");
								rd.forward(req, resp);
					}
		}
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
