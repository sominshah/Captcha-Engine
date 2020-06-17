package servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import captcha.engine.version.one.pojo.*;
public class aaa extends HttpServlet
{
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
try
{
Captcha captcha=(Captcha) rq.getSession().getAttribute("Captcha");
System.out.println("Captcha Name: "+captcha.getName());
System.out.println("Captcha Value: "+captcha.getValue());
System.out.println("Request arrived");
String name=rq.getParameter("nm");
String captchaStr=rq.getParameter("captcha");
System.out.println("Receive data");
System.out.println("name : "+name);
System.out.println("Captcha Value: "+captchaStr+" "+captcha.isValid(captchaStr));
boolean captchaVal=captcha.isValid(captchaStr);
rs.setContentType("text/html");
PrintWriter pw=rs.getWriter();
pw.println("<!Doctype html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Captcha Test</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<center>");
pw.println("<h2>Captcha Testing</h2>");
pw.println("<b>Name:</b>"+name+"");
if(captchaVal)
{
pw.println("<b>Captcha Value: Correct</b>");
}else
{
pw.println("<b>Captcha Value: Incorrect</b>");
}
pw.println("</form>");
pw.println("</center>");
pw.println("</body>");
pw.println("</html>");
}catch(Exception e)
{
System.out.println(e);
}
}
}