package captcha.engine.version.one.configuration;
import captcha.engine.version.one.exception.*;
import captcha.engine.version.one.enums.*;
public class CaptchaConfigurator implements java.io.Serializable
{
private captcha.engine.version.one.pojo.CaptchaProperties captchaProperties;
public void setCaptchaProperties(captcha.engine.version.one.configuration.CaptchaProperties captchaProperties) throws CaptchaException
{
 int numberOfFonts=captchaProperties.getNumberOfFonts();	
 int captchaWidth=captchaProperties.getCaptchaWidth();
 int captchaHeight=captchaProperties.getCaptchaHeight();
 int fontSize=captchaProperties.getFontSize();  
 int captchaStringWidth=0;
 int captchaStringHeight=0;
 BackgroundColor backgroundColor=captchaProperties.getBackgroundColor();
 FontName fontName=captchaProperties.getFontName();
 FontStyle fontStyle=captchaProperties.setFontStyle();
 FontColor fontColor=captchaProperties.getFontColor();
 
if(captchaHeight>0 && fontSize>0)
{
	if(fontSize>captchaHeight) throw new CaptchaException("font size is greater than captcha height"); 

}
else
{
	if(captchaHeight<=0 && fontSize>0)
	{
		captchaHeight=(fontSize*2)+100;
	}
	else
	{
 		if(fontSize<=0 && captchaHeight>0) 
		{
		fontSize=captchaHeight/2;	
		}	

	}
	if(captchaHeight<=0 && fontSize<=0)
	{
	captchaHeight=200;
	fontSize=25;	
	}
}

captchaStringHeight=fontSize;
if(captchaWidth>0 && numberOfFonts<=0)
{
numberOfFonts=(captchaWidth-40)/fontSize;
}

if(numberOfFonts>0)
{
	int stringWidth=numberOfFonts * fontSize;
	captchaStringWidth=stringWidth;
    if(captchaWidth<=0)
    {
	captchaWidth=stringWidth+40;
    }
    else
    {
    	int diff=stringWidth-captchaWidth;
    	if(diff>0) captchaWidth=stringWidth+40;
    }
}


if(numberOfFonts<=0 && captchaWidth<=0)
{
captchaWidth=300;
numberOfFonts=6;
captchaStringWidth=numberOfFonts * fontSize;
}
if(numberOfFonts>=captchaWidth)throw new CaptchaException("Number Of Fonts is greater than or equal to captcha width"); 

System.out.println(" Captcha Configuration Class ");
System.out.println(" numberOfFonts : "+numberOfFonts);
System.out.println(" captchaWidth : "+captchaWidth);
System.out.println(" captchaHeight : "+captchaHeight);
System.out.println(" fontSize : "+fontSize);
System.out.println(" captchaStringWidth : "+captchaStringWidth);
System.out.println(" captchaStringHeight : "+captchaStringHeight);
System.out.println(" backgroundColor : "+backgroundColor);
System.out.println(" fontName : "+fontName);
System.out.println(" fontStyle : "+fontStyle);
System.out.println(" fontColor : "+fontColor);
System.out.println(" ____________________________________________________");
this.captchaProperties=new captcha.engine.version.one.pojo.CaptchaProperties();	
this.captchaProperties.setFontSize(fontSize);
this.captchaProperties.setNumberOfFonts(numberOfFonts);
this.captchaProperties.setCaptchaWidth(captchaWidth);
this.captchaProperties.setCaptchaHeight(captchaHeight);
this.captchaProperties.setCaptchaStringHeight(captchaStringHeight);
this.captchaProperties.setCaptchaStringWidth(captchaStringWidth);
this.captchaProperties.setBackgroundColor(backgroundColor);
this.captchaProperties.setFontName(fontName);
this.captchaProperties.setFontStyle(fontStyle);
}
public captcha.engine.version.one.pojo.CaptchaProperties getCaptchaProperties()
{
	return this.captchaProperties;
}
}