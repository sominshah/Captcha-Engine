package captcha.engine.version.one.web;
import captcha.engine.version.one.*;
import captcha.engine.version.one.pojo.*;
import captcha.engine.version.one.enums.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CaptchaEngineWeb extends HttpServlet
{
public void doPost(HttpServletRequest rq,HttpServletResponse rs)
{
doGet(rq,rs);
}
public void doGet(HttpServletRequest rq,HttpServletResponse rs)
{
try
{
String error="";
int numberOfFonts=5;
int captchaWidth=150;
int captchaHeight=50;
BackgroundColor backgroundColor=BackgroundColor.WHITE;
FontColor fontColor=FontColor.BLACK;

ServletConfig servletConfig=getServletConfig();
if(servletConfig!=null)
{
String BackColorStr=servletConfig.getInitParameter("BackgroundColor");
if(BackColorStr!=null)
{
if(BackColorStr.equalsIgnoreCase("BLUE"))backgroundColor=BackgroundColor.BLUE;
else if(BackColorStr.equalsIgnoreCase("WHITE"))backgroundColor=BackgroundColor.WHITE;
else if(BackColorStr.equalsIgnoreCase("GREEN"))backgroundColor=BackgroundColor.GREEN;
else if(BackColorStr.equalsIgnoreCase("BLACK"))backgroundColor=BackgroundColor.BLACK;	
else if(BackColorStr.equalsIgnoreCase("CYAN"))backgroundColor=BackgroundColor.CYAN;
else if(BackColorStr.equalsIgnoreCase("DARK_GRAY"))backgroundColor=BackgroundColor.DARK_GRAY;
else if(BackColorStr.equalsIgnoreCase("GRAY"))backgroundColor=BackgroundColor.GRAY;
else if(BackColorStr.equalsIgnoreCase("LIGHT_GRAY"))backgroundColor=BackgroundColor.LIGHT_GRAY;
else if(BackColorStr.equalsIgnoreCase("MAGENTA"))backgroundColor=BackgroundColor.MAGENTA;
else if(BackColorStr.equalsIgnoreCase("PINK"))backgroundColor=BackgroundColor.PINK;
else if(BackColorStr.equalsIgnoreCase("RED"))backgroundColor=BackgroundColor.RED;
else if(BackColorStr.equalsIgnoreCase("YELLOW"))backgroundColor=BackgroundColor.YELLOW;
else if(BackColorStr.equalsIgnoreCase("ORANGE"))backgroundColor=BackgroundColor.ORANGE;
}

String fontStr=servletConfig.getInitParameter("FontColor");
if(fontStr!=null)
{
if(fontStr.equalsIgnoreCase("BLUE"))fontColor=FontColor.BLUE;
else if(fontStr.equalsIgnoreCase("WHITE"))fontColor=FontColor.WHITE;
else if(fontStr.equalsIgnoreCase("GREEN"))fontColor=FontColor.GREEN;
else if(fontStr.equalsIgnoreCase("BLACK"))fontColor=FontColor.BLACK;	
else if(fontStr.equalsIgnoreCase("CYAN"))fontColor=FontColor.CYAN;
else if(fontStr.equalsIgnoreCase("DARK_GRAY"))fontColor=FontColor.DARK_GRAY;
else if(fontStr.equalsIgnoreCase("GRAY"))fontColor=FontColor.GRAY;
else if(fontStr.equalsIgnoreCase("LIGHT_GRAY"))fontColor=FontColor.LIGHT_GRAY;
else if(fontStr.equalsIgnoreCase("MAGENTA"))fontColor=FontColor.MAGENTA;
else if(fontStr.equalsIgnoreCase("PINK"))fontColor=FontColor.PINK;
else if(fontStr.equalsIgnoreCase("RED"))fontColor=FontColor.RED;
else if(fontStr.equalsIgnoreCase("YELLOW"))fontColor=FontColor.YELLOW;
else if(fontStr.equalsIgnoreCase("ORANGE"))fontColor=FontColor.ORANGE;
}	
try
{
if(servletConfig.getInitParameter("NumberOfFonts")!=null)numberOfFonts=Integer.parseInt(servletConfig.getInitParameter("NumberOfFonts"));
}catch(Throwable t)
{
numberOfFonts=5;
System.out.println("Error: incorrect value of the 'NumberOfFonts' written in the deployment descriptor (web.xml)");
error="Error: incorrect value of the 'NumberOfFonts' written in the deployment descriptor (web.xml)";
}

try
{
if(servletConfig.getInitParameter("CaptchaWidth")!=null)captchaWidth=Integer.parseInt(servletConfig.getInitParameter("CaptchaWidth"));
}
catch(Throwable t)
{
captchaWidth=300;
System.out.println("Error: incorrect value of the value of the 'CaptchaWidth' written in the deployment descriptor (web.xml)");
error="Error: incorrect value of 'CaptchaWidth' written in the deployment descriptor (web.xml)";
}

try
{
if(servletConfig.getInitParameter("CaptchaHeight")!=null)captchaHeight=Integer.parseInt(servletConfig.getInitParameter("CaptchaHeight"));
}catch(Throwable t)
{
captchaHeight=150;
System.out.println("Error: incorrect value of the 'CaptchaHeight' written in the deployment descriptor (web.xml)");
error="Error: incorrect value of the 'CaptchaHeight' written in the deployment descriptor (web.xml)";
}
}

CaptchaEngine captchaEngine=new CaptchaEngine(captchaWidth,captchaHeight,numberOfFonts,backgroundColor,fontColor);
captchaEngine.setFontPlacingStyle(FontPlacingStyle.RANDOM_VERTICAL_POSITION_SPACING);
ByteArrayOutputStream baos = new ByteArrayOutputStream();
Captcha captcha=captchaEngine.generateCaptcha(baos);
HttpSession session=rq.getSession();
session.setAttribute("Captcha",captcha);
rs.getOutputStream().write(baos.toByteArray());
}catch(Throwable t)
{
try
{
System.out.println(t.getMessage());
rs.setContentType("text/html");
rs.getWriter().println(t.getMessage());
}catch(Exception e)
{
}
}
}
}
