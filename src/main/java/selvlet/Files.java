package selvlet;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bank.Bean.StatementBean;
import com.bank.Dao.Imp.Table;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@WebServlet("/files")
public class Files extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			 String file = req.getParameter("file");
			// System.out.println("file name"+file);
		
	
			 if(file.equals("PDF")) {
				StatementBean obj=new StatementBean();
				String val=req.getParameter("values");
				obj.setAccNo(Integer.parseInt(val));
				obj.setStartDate(req.getParameter("startDate"));
				obj.setEndDate(req.getParameter("endDate"));
							
				Table t =new Table();
				
				List<StatementBean> s =t.statementTable(obj);				
								
				int status=	 pdf(s);
				if(status > 0) {
					downloadPDF(req, resp);
				}
				 
			 }
			 
			 if(file.equals("EXCEL")) {	
				 StatementBean obj=new StatementBean();
					String val=req.getParameter("values");
					obj.setAccNo(Integer.parseInt(val));
					obj.setStartDate(req.getParameter("startDate"));
					obj.setEndDate(req.getParameter("endDate"));
								
					Table t =new Table();
					
					List<StatementBean> s =t.statementTable(obj);				
									
				int status = excel(s);
				
						if(status >0) {
							downloadXL(req, resp);
							
						}
			 }
	}

		private void downloadXL(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String path ="statement.xlsx";				
			
			File downfile= new File(path);
			FileInputStream inStream = new FileInputStream(downfile);
			String relativePath = getServletContext().getRealPath("");
			//System.out.println("relativePath = " + relativePath);
			
			ServletContext context = getServletContext();
			
			String mimeType = context.getMimeType(path);
			if(mimeType == null) {
				mimeType = "application/octet-stream";
			}
			 System.out.println("MIME type: " + mimeType);
			 response.setContentType(mimeType);
			 response.setContentLength((int) downfile.length());
			 
			 String hkey = "Content-Disposition";
			 String hValue = String.format("attachment; filename=\"%s\"", downfile.getName());
			 response.setHeader(hkey, hValue);
			 
			 OutputStream outStream = response.getOutputStream();
			 byte[] buffer = new byte[4096];
		        int bytesRead = -1;
		        
			 while ((bytesRead = inStream.read(buffer)) != -1) {
		            outStream.write(buffer, 0, bytesRead);
		        }	         
		        inStream.close();
		        outStream.close();  
		
		
	}

		private int excel(List<StatementBean> s) {
			// TODO Auto-generated method stub
			
			 
			  XSSFWorkbook workbook = new XSSFWorkbook();
				 XSSFSheet sheet = workbook.createSheet("Statement");
		 
				 writeHeaderLine( sheet);
				  writeDataLine( s, workbook, sheet);
				
				
		 FileOutputStream out;
		try {
			out = new FileOutputStream(new File("statement.xlsx"));
			workbook.write(out);
			 out.close();
			 return 1;
		} catch ( IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 0;
		
			}
			 
			 
	}
	
		private void writeDataLine(List<StatementBean> s, XSSFWorkbook workbook, XSSFSheet sheet) {
			// TODO Auto-generated method stub'
			
			int count = 1;
			  for(StatementBean x :s) { 
				  Row row = sheet.createRow(count++);
					int colCount =0;
					
					 Cell cell = row.createCell(colCount++);		
					 cell.setCellValue(x.getAccNo());
					 
					 cell = row.createCell(1);
				     cell.setCellValue(x.getTransactionDate());
				     
				     cell = row.createCell(2);
				     cell.setCellValue(x.getTransctionId());
				     
				     cell = row.createCell(3);
				     cell.setCellValue(x.getDepositBal());
				     
				     cell = row.createCell(4);
				     cell.setCellValue(x.getWithdrawbal());
				     
				     cell = row.createCell(5);
				     cell.setCellValue(x.getAccountBal());
			  }			 	
		}

		private void writeHeaderLine(XSSFSheet sheet) {
			Row header =sheet.createRow(0);
			
			Cell headerCell = header.createCell(0);
	        headerCell.setCellValue("Account NO");
	 
	        headerCell = header.createCell(1);
	        headerCell.setCellValue("Transction Date");
	 
	        headerCell = header.createCell(2);
	        headerCell.setCellValue("Transction_Id");
	 
	        headerCell = header.createCell(3);
	        headerCell.setCellValue("Deposit Amount");
	 
	        headerCell = header.createCell(4);
	        headerCell.setCellValue("Withdraw Amount"); 
	        
	        headerCell = header.createCell(5);
	        headerCell.setCellValue("Account Balance"); 
			
		}

		public int pdf( List<StatementBean> s) {
			// TODO Auto-generated method stub
			// System.out.println("pdf");
			 Document doc =new Document(); 
			// String filepath = "Downloads";
			 
			 try {
				PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("statement.pdf"));
				doc.open();
				
				PdfPTable table=new PdfPTable(6);
				table.setWidthPercentage(110); //Width 100%
			    table.setSpacingBefore(10f); //Space before table
			    table.setSpacingAfter(10f); //Space after table
			 
			    float[] columnWidths = {1f, 1f, 1f, 1f, 1f,1f};
		        table.setWidths(columnWidths);
		        
		        PdfPCell cell1 = new PdfPCell(new Paragraph("Account NO"));
		        cell1.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell1.setPadding(8);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell2 = new PdfPCell(new Paragraph("Transction Date"));
		        cell2.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell2.setPadding(8);
		        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell3 = new PdfPCell(new Paragraph("Transction Id"));
		        cell3.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell3.setPadding(8);
		        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell4 = new PdfPCell(new Paragraph("Deposit Amount"));
		        cell4.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell4.setPadding(8);
		        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell5 = new PdfPCell(new Paragraph("Withdraw Amount"));
		        cell5.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell5.setPadding(8);
		        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell6 = new PdfPCell(new Paragraph("Account Balance"));
		        cell6.setBorderColor(BaseColor.LIGHT_GRAY);
		        cell6.setPadding(8);
		        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        table.addCell(cell1);
		        table.addCell(cell2);
		        table.addCell(cell3);
		        table.addCell(cell4);
		        table.addCell(cell5);
		        table.addCell(cell6);
		        
		       if(s !=null) {
		        	for(StatementBean a :s) {
		        		
		        	
		       
		        
		        PdfPCell data = new PdfPCell(new Paragraph(Integer.toString(a.getAccNo())));
				cell1.setBorderColor(BaseColor.LIGHT_GRAY);
				cell1.setPadding(8);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        
		    	PdfPCell data1 = new PdfPCell(new Paragraph((a.getTransactionDate())));
		    	cell2.setBorderColor(BaseColor.LIGHT_GRAY);
		    	cell2.setPadding(8);
		    	cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		    	PdfPCell data2 = new PdfPCell(new Paragraph(Integer.toString(a.getTransctionId())));		    	
		    	cell3.setBorderColor(BaseColor.LIGHT_GRAY);
		    	cell3.setPadding(8);
		    	cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				
		    	PdfPCell data3 = new PdfPCell(new Paragraph(Integer.toString(a.getDepositBal())));
		    	cell4.setBorderColor(BaseColor.LIGHT_GRAY);
		    	cell4.setPadding(8);
		    	cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		    	
		    	PdfPCell data4 = new PdfPCell(new Paragraph(Integer.toString(a.getWithdrawbal())));
		    	cell5.setBorderColor(BaseColor.LIGHT_GRAY);
		    	cell5.setPadding(8);
		    	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		    	
		    	PdfPCell data5 = new PdfPCell(new Paragraph(Integer.toString(a.getAccountBal())));
		    	cell5.setBorderColor(BaseColor.LIGHT_GRAY);
		    	cell5.setPadding(8);
		    	cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		    	cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		    	
				  table.addCell(data); 
				  table.addCell(data1); 
				  table.addCell(data2);
				  table.addCell(data3); 
				  table.addCell(data4);
				  table.addCell(data5);
		        	} 
		        	
		       }
		       doc.add(table);
				 
		        doc.close();
		        writer.close();
		        return 1;
			 } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				 return 0;
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 return 0;
			}
			  
			
		}
		
	//	D:\PDF_Folder
		public void downloadPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String path ="statement.pdf";				
			
					File downfile= new File(path);
					FileInputStream inStream = new FileInputStream(downfile);
					String relativePath = getServletContext().getRealPath("");
				//	System.out.println("relativePath = " + relativePath);
					
					ServletContext context = getServletContext();
					
					String mimeType = context.getMimeType(path);
					if(mimeType == null) {
						mimeType = "application/octet-stream";
					}
					 System.out.println("MIME type: " + mimeType);
					 response.setContentType(mimeType);
					 response.setContentLength((int) downfile.length());
					 
					 String hkey = "Content-Disposition";
					 String hValue = String.format("attachment; filename=\"%s\"", downfile.getName());
					 response.setHeader(hkey, hValue);
					 
					 OutputStream outStream = response.getOutputStream();
					 byte[] buffer = new byte[4096];
				        int bytesRead = -1;
				        
					 while ((bytesRead = inStream.read(buffer)) != -1) {
				            outStream.write(buffer, 0, bytesRead);
				        }	         
				        inStream.close();
				        outStream.close();  				
			}
}
	
	

