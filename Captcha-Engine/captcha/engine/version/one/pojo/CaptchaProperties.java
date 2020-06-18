package captcha.engine.version.one.pojo;
import captcha.engine.version.one.enums.*;
public class CaptchaProperties implements java.io.Serializable
{

private int numberOfFonts;	
private int captchaWidth;
private int captchaHeight;
private int captchaStringHeight;
private int captchaStringWidth;
private BackgroundColor backgroundColor;
private int fontSize;
private FontName fontName;
private FontStyle fontStyle;
private FontColor fontColor;
private FontPlacingStyle fontPlacingStyle;
public CaptchaProperties()
{
this.numberOfFonts=0;	
this.captchaWidth=0;
this.captchaHeight=0;
this.captchaStringHeight=0;
this.captchaStringWidth=0;
this.backgroundColor=null;
this.fontName=null;
this.fontStyle=null;
this.fontColor=null;
this.fontPlacingStyle=null;
this.fontSize=0;
}
public void setFontPlacingStyle(FontPlacingStyle fontPlacingStyle)
{
this.fontPlacingStyle=fontPlacingStyle;
}
public FontPlacingStyle getFontPlacingStyle()
{
return this.fontPlacingStyle;
}

public void setFontSize(int fontSize)
{
this.fontSize=fontSize;
}
public int getFontSize()
{
return this.fontSize;
}
public void setNumberOfFonts(int numberOfFonts)
{
 this.numberOfFonts=numberOfFonts;
}
public int getNumberOfFonts()
{
	return this.numberOfFonts;
}
public void setCaptchaWidth(int captchaWidth)
{
this.captchaWidth=captchaWidth;
}
public int getCaptchaWidth()
{
	return this.captchaWidth;
}
public void setCaptchaHeight(int captchaHeight)
{
	this.captchaHeight=captchaHeight;
}
public int getCaptchaHeight()
{
	return this.captchaHeight;
}
public void setCaptchaStringHeight(int captchaStringHeight)
{
this.captchaStringHeight=captchaStringHeight;
}
public int getCaptchaStringHeight()
{
	return this.captchaStringHeight;
}
public void setCaptchaStringWidth(int captchaStringWidth)
{
	this.captchaStringWidth=captchaStringWidth;
}
public int getCaptchaStringWidth()
{
return this.captchaStringWidth;
}

public void setBackgroundColor(BackgroundColor backgroundColor)
{
	this.backgroundColor=backgroundColor;
}
public  BackgroundColor getBackgroundColor()
{
	return  this.backgroundColor;
}
public void setFontName(FontName fontName)
{
	this.fontName=fontName;
}
public FontName getFontName()
{ 
	return this.fontName;
}
public void setFontStyle (FontStyle fontStyle)
{
	this.fontStyle=fontStyle;
}
public FontStyle getFontStyle()
{
return this.fontStyle;
} 
public void setFontColor(FontColor fontColor)
{
	this.fontColor=fontColor;
}
public FontColor getFontColor()
{
	return this.fontColor;
} 
}