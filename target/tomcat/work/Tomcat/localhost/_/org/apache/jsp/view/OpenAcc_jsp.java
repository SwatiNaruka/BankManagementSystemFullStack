/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-09-24 06:51:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class OpenAcc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/view/Header.html", Long.valueOf(1632466174459L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../StyleCss/index.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/732623e199.js\" ></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/732623e199.js\" ></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./StyleCss/index.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container-fluid  sMenu\" id=\"link \" style=\"clear: both;\" style=\"display: hidden;\">\r\n");
      out.write("\t<div class=\"row\">\t\t\r\n");
      out.write("\t\t<div class=\"col-md-11 \"> \r\n");
      out.write("\t\t\t<ul>\t\r\n");
      out.write("\t\t\t\t<li><a href=\"/view/Deposit.jsp\">Cash Deposit</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/view/Withdraw.jsp\">Cash Withdraw</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/view/Statement.jsp\">Statement</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/view/OpenAcc.jsp\">Open Account</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/view/CloseAcc.jsp\">Close Account</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/view/Manage.jsp\">Manage Account</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"/view/AllDetail.jsp\">All a/c Detail</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-md-1 btn-style\">\t\t\t\r\n");
      out.write("\t\t\t\t<form action=\"./logout\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Logout\" style=\"float: rright;\">\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t <form  action=\"../Acc/openAc\" method=\"post\"class=\"openForm\"  enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t <div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\" col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>Full Name:</label>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-8\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"Enter Your full name\" name=\"name\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\" col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>Father Name:</label>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-8\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"Enter Your full name\" name=\"fname\">\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t<div class=\" col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"gender\">Gender: </label>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t              <input type=\"radio\" id=\"gender\" name=\"gender\" value=\"male\" class=\"inputStyle\"/>Male  \r\n");
      out.write("\t\t\t\t              <input type=\"radio\" id=\"gender\" name=\"gender\" value=\"female\"class=\"inputStyle\"/>Female\t\t \r\n");
      out.write("\t\t\t\t              <input type=\"radio\" id=\"gender\" name=\"gender\" value=\"others\"class=\"inputStyle\"/>Others <br/>  \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-3\">\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<label for=\"marital\">Martal Status: </label> \r\n");
      out.write("\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"marital\" name=\"marital\" value=\"married\"class=\"inputStyle\"/>Married  \r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"marital\" name=\"marital\" value=\"single\"class=\"inputStyle\"/>Single <br/>  \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"account\">Type of Account: </label>  \r\n");
      out.write("\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"account\" name=\"account\" value=\"Current Account\"class=\"inputStyle\"/>Current Account  \r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"account\" name=\"account\" value=\"Saving Account\"class=\"inputStyle\"/>Saving Account\t\t\t              \r\n");
      out.write("\t\t\t             <br/>  \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\" col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>Date of Birth:</label>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-8\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"date\" name=\"begin\" placeholder=\"yyyy-mm-dd\" value=\"\" min=\"1997-01-01\" max=\"2030-12-31\" name=\"date\">\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"service\">Service Required: </label>\r\n");
      out.write("\t\t\t\t\t</div>\t\t  \r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"service\" name=\"service\" value=\"atm card\" class=\"inputStyle\"/>ATM Card  \r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"service\" name=\"service\" value=\"mobile Banking\" class=\"inputStyle\"/>Mobile Banking \t\t\t              \r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"service\" name=\"service\" value=\"net Banking\" class=\"inputStyle\"/>Net Banking \r\n");
      out.write("\t\t\t              <input type=\"radio\" id=\"service\" name=\"service\" value=\"cheque Book\" class=\"inputStyle\"/>Cheque Book <br/>  \r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\" col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>Opening Amount:</label>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-8\">\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"amount\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"row openFormStype\">\r\n");
      out.write("\t\t\t\t\t<div class=\" col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>Select Photo:</label> \r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\r\n");
      out.write("\t\t\t\t         <input type=\"file\" name=\"uploadFile\" name=\"photo\" />\t\t\t\t         \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"row  AccBtn\">\r\n");
      out.write("\t\t\t\t\t<div class=\" col-12\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\"  class=\" btn btn-primary btn-style\" >Open Account</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t </form>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}