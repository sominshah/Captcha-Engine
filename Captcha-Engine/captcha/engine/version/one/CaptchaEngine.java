package captcha.engine.version.one;
import captcha.engine.version.one.pojo.*;
import captcha.engine.version.one.enums.*;
import captcha.engine.version.one.configuration.*;
import captcha.engine.version.one.exception.*;
public class CaptchaEngine implements captcha.engine.version.one.configuration.CaptchaEngine 
{
	private captcha.engine.version.one.pojo.CaptchaProperties captchaProperties;

	private void initializeCaptchaProperty()
	{
		this.captchaProperties=new captcha.engine.version.one.pojo.CaptchaProperties();
	       	this.captchaProperties.setFontSize(36);
       		this.captchaProperties.setNumberOfFonts(5);
       		this.captchaProperties.setCaptchaWidth(150);
		this.captchaProperties.setCaptchaHeight(80);
		this.captchaProperties.setCaptchaStringHeight(36);
		this.captchaProperties.setCaptchaStringWidth(36*5);
		this.captchaProperties.setBackgroundColor(captcha.engine.version.one.enums.BackgroundColor.GRAY);
		this.captchaProperties.setFontName(captcha.engine.version.one.enums.FontName.DIALOG);
		this.captchaProperties.setFontStyle(captcha.engine.version.one.enums.FontStyle.BOLD);
		this.captchaProperties.setFontColor(captcha.engine.version.one.enums.FontColor.BLACK);
		this.setFontPlacingStyle(FontPlacingStyle.SIMPLE);
	}
	public CaptchaEngine()
	{
	initializeCaptchaProperty();
	}
	public CaptchaEngine(BackgroundColor bc)
	{
	initializeCaptchaProperty();
	this.captchaProperties.setBackgroundColor(bc);
	}
	public CaptchaEngine(BackgroundColor bc,FontColor fc)
	{
	initializeCaptchaProperty();
	this.captchaProperties.setBackgroundColor(bc);
	this.captchaProperties.setFontColor(fc);
	}
	public CaptchaEngine(FontColor fc)
	{
	initializeCaptchaProperty();
	this.captchaProperties.setFontColor(fc);
	}

	public CaptchaEngine(int captchaWidth,int captchaHeight) throws CaptchaException
	{
		if(captchaWidth<50)throw new CaptchaException("Captcha width can not be less than 50");
		if(captchaHeight<50)throw new CaptchaException("Captcha height can not be less than 50");
		initializeCaptchaProperty();
		int fontSize=(captchaHeight/2)-10;
		if(captchaHeight>=captchaWidth)fontSize=(captchaWidth/2)-10;
		int numberOfFonts=(captchaWidth-20)/(fontSize-10);	
	       	this.captchaProperties.setFontSize(fontSize);
       		this.captchaProperties.setNumberOfFonts(numberOfFonts); 
      		this.captchaProperties.setCaptchaWidth(captchaWidth);
		this.captchaProperties.setCaptchaHeight(captchaHeight);
		this.captchaProperties.setCaptchaStringHeight(fontSize);
		this.captchaProperties.setCaptchaStringWidth(fontSize*numberOfFonts);
	}

	public CaptchaEngine(int captchaWidth,int captchaHeight,BackgroundColor bc) throws CaptchaException
	{
		if(captchaWidth<50)throw new CaptchaException("Captcha width can not be less than 50");
		if(captchaHeight<50)throw new CaptchaException("Captcha height can not be less than 50");
		initializeCaptchaProperty();
		int fontSize=(captchaHeight/2)-10;
		if(captchaHeight>=captchaWidth)fontSize=(captchaWidth/2)-10;
		int numberOfFonts=(captchaWidth-20)/(fontSize-10);	
	       	this.captchaProperties.setFontSize(fontSize);
       		this.captchaProperties.setNumberOfFonts(numberOfFonts); 
      		this.captchaProperties.setCaptchaWidth(captchaWidth);
		this.captchaProperties.setCaptchaHeight(captchaHeight);
		this.captchaProperties.setCaptchaStringHeight(fontSize);
		this.captchaProperties.setCaptchaStringWidth(fontSize*numberOfFonts);
		this.captchaProperties.setBackgroundColor(bc);
	}

	public CaptchaEngine(int captchaWidth,int captchaHeight ,int numberOfFonts,BackgroundColor bc) throws CaptchaException
	{
		initializeCaptchaProperty();
		int fontSize=(captchaHeight/numberOfFonts)+20;	
		if(captchaWidth<captchaHeight)fontSize=(captchaWidth/numberOfFonts)+20;
	       	this.captchaProperties.setFontSize(fontSize);
       		this.captchaProperties.setNumberOfFonts(numberOfFonts); 
      		this.captchaProperties.setCaptchaWidth(captchaWidth);
		this.captchaProperties.setCaptchaHeight(captchaHeight);
		this.captchaProperties.setCaptchaStringHeight(fontSize);
		this.captchaProperties.setCaptchaStringWidth(fontSize*numberOfFonts);
		this.captchaProperties.setBackgroundColor(bc);
	}

	public CaptchaEngine(int captchaWidth,int captchaHeight ,int numberOfFonts,BackgroundColor bc,FontColor fc) throws CaptchaException
	{
		initializeCaptchaProperty();
		int fontSize=(captchaHeight/numberOfFonts)+20;	
		if(captchaWidth<captchaHeight)fontSize=(captchaWidth/numberOfFonts)+20;
	       	this.captchaProperties.setFontSize(fontSize);
       		this.captchaProperties.setNumberOfFonts(numberOfFonts); 
      		this.captchaProperties.setCaptchaWidth(captchaWidth);
		this.captchaProperties.setCaptchaHeight(captchaHeight);
		this.captchaProperties.setCaptchaStringHeight(fontSize);
		this.captchaProperties.setCaptchaStringWidth(fontSize*numberOfFonts);
		this.captchaProperties.setBackgroundColor(bc);
		this.captchaProperties.setFontColor(fc);
	}

	public CaptchaEngine(int captchaWidth,int captchaHeight ,int numberOfFonts) throws CaptchaException
	{
		initializeCaptchaProperty();
		int fontSize=(captchaHeight/numberOfFonts)+20;	
		if(captchaWidth<captchaHeight)fontSize=(captchaWidth/numberOfFonts)+20;
	       	this.captchaProperties.setFontSize(fontSize);
       		this.captchaProperties.setNumberOfFonts(numberOfFonts); 
      		this.captchaProperties.setCaptchaWidth(captchaWidth);
		this.captchaProperties.setCaptchaHeight(captchaHeight);
		this.captchaProperties.setCaptchaStringHeight(fontSize);
		this.captchaProperties.setCaptchaStringWidth(fontSize*numberOfFonts);
	}


	public CaptchaEngine(captcha.engine.version.one.configuration.CaptchaConfigurator configuration)
	{
		this.captchaProperties=configuration.getCaptchaProperties();
	}

	public void setFontPlacingStyle(FontPlacingStyle fontPlacingStyle)
	{
	this.captchaProperties.setFontPlacingStyle(fontPlacingStyle);
	}	

	public Captcha generateCaptcha() throws CaptchaException
	{
		try
		{
		Captcha captcha=CaptchaGenerator.generate(captchaProperties);
		return captcha;
		}catch(Exception e)
		{
			throw new CaptchaException(e.getMessage());	
		}
	}

	public Captcha generateCaptcha(java.io.ByteArrayOutputStream baos) throws CaptchaException
	{
		try
		{
		Captcha captcha=CaptchaGenerator.generate(captchaProperties,baos);
		return captcha;
		}catch(Exception e)
		{
			throw new CaptchaException(e.getMessage());	
		}
	}
	
}