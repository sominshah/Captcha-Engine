package captcha.engine.version.one;
import captcha.engine.version.one.pojo.*;
import captcha.engine.version.one.configuration.*;
import captcha.engine.version.one.enums.*;
import captcha.engine.version.one.exception.*;
import java.util.*;
import java.lang.reflect.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
public class CaptchaGenerator implements java.io.Serializable
{
	private static byte [] ascii;

	public CaptchaGenerator()
	{
	
	}
		

	public static Captcha generate(captcha.engine.version.one.pojo.CaptchaProperties captchaProperties) throws CaptchaException
	{
			
		try
		{
			System.out.println("Captcha adjusted Width: "+captchaProperties.getCaptchaWidth());
			System.out.println("Captcha adjusted Height: "+captchaProperties.getCaptchaHeight());
		BufferedImage img=new BufferedImage(captchaProperties.getCaptchaWidth(),captchaProperties.getCaptchaHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics=img.createGraphics();
		graphics.setColor(getColorByName(captchaProperties.getBackgroundColor().toString()));
		graphics.fillRect(0,0,captchaProperties.getCaptchaWidth(),captchaProperties.getCaptchaHeight());
	
			String str=UUID.randomUUID().toString();
			str=str.replaceAll("[^a-zA-Z0-9]","");
			String captchaValue=str.substring(0,captchaProperties.getNumberOfFonts());
			String captchaName=str.substring(captchaProperties.getNumberOfFonts());


			Font font=new Font(captchaProperties.getFontName().toString(),getFontStyleByName(captchaProperties.getFontStyle().toString()),captchaProperties.getFontSize());

			graphics.setFont(font);
			graphics.setColor(getColorByName(captchaProperties.getFontColor().toString()));

			if(captchaProperties.getFontPlacingStyle()==FontPlacingStyle.SIMPLE)
			{
			graphics.drawString(captchaValue,10,captchaProperties.getCaptchaHeight()-20);
			}
			if(captchaProperties.getFontPlacingStyle()==FontPlacingStyle.RANDOM_VERTICAL_POSITION_SPACING)
			{
			drawFontsOnRandomVerticalPositions(graphics,captchaValue,captchaProperties.getCaptchaHeight()-20);
			}

			File file=new File(captchaName+".jpg");
			ImageIO.write(img,"jpg",file);
			Captcha captcha=new Captcha();
			captcha.setName(captchaName+".jpg");
			captcha.setValue(captchaValue);
		
			return captcha;
		}catch(Exception e)
		{
			throw new CaptchaException(e.getMessage());	
		}
	}


	public static Captcha generate(captcha.engine.version.one.pojo.CaptchaProperties captchaProperties,java.io.ByteArrayOutputStream baos) throws CaptchaException
	{
			
		try
		{
		BufferedImage img=new BufferedImage(captchaProperties.getCaptchaWidth(),captchaProperties.getCaptchaHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics=img.createGraphics();
		graphics.setColor(getColorByName(captchaProperties.getBackgroundColor().toString()));
		graphics.fillRect(0,0,captchaProperties.getCaptchaWidth(),captchaProperties.getCaptchaHeight());
	
			String str=UUID.randomUUID().toString();
			str=str.replaceAll("[^a-zA-Z0-9]","");
			String captchaValue=str.substring(0,captchaProperties.getNumberOfFonts());
			String captchaName=str.substring(captchaProperties.getNumberOfFonts());


			Font font=new Font(captchaProperties.getFontName().toString(),getFontStyleByName(captchaProperties.getFontStyle().toString()),captchaProperties.getFontSize());

			graphics.setFont(font);
			graphics.setColor(getColorByName(captchaProperties.getFontColor().toString()));

			if(captchaProperties.getFontPlacingStyle()==FontPlacingStyle.SIMPLE)
			{
			graphics.drawString(captchaValue,10,captchaProperties.getCaptchaHeight()-20);
			}
			if(captchaProperties.getFontPlacingStyle()==FontPlacingStyle.RANDOM_VERTICAL_POSITION_SPACING)
			{
			drawFontsOnRandomVerticalPositions(graphics,captchaValue,captchaProperties.getCaptchaHeight()-20);
			}
			ImageIO.write(img,"png",baos);
			Captcha captcha=new Captcha();
			captcha.setName(captchaName+".jpg");
			captcha.setValue(captchaValue);
			return captcha;
		}catch(Exception e)
		{
			throw new CaptchaException(e.getMessage());	
		}
	}


	private static int getFontStyleByName(String name) throws CaptchaException
	{
		try
		{
			Field f=Font.class.getField(name.toUpperCase());
			return (int) f.get(null);

		}catch(Throwable t)
		{
			t.printStackTrace();
			throw new CaptchaException("Font Style is wrong.");	
		}
	}
	private static Color getColorByName(String name) throws CaptchaException
	{
		try
		{
			Field f=Color.class.getField(name.toUpperCase());
			return (Color) f.get(null);
		}catch(Throwable t)
		{
			t.printStackTrace();
			throw new CaptchaException("Captcha background color name is Wrong.");
		}
	}

	private static void drawFontsOnRandomVerticalPositions(Graphics g,String str,int height)
	{
	ascii=str.getBytes();
	
	FontMetrics fm = g.getFontMetrics(g.getFont());
	int heightSpace=fm.getHeight()/3;
	int i=0;
	int xPos=10;
		//char g='';
		while(i<str.length())
		{
		//g=str.charAt(i);
		if(getRandomNumber(i)%2==0) xPos=drawItem(g,g.getFont(),str.substring(i,i+1),xPos,height);
		else xPos=drawItem(g,g.getFont(),str.substring(i,i+1),xPos,height+heightSpace);
		i++;
		}	
	
	}


	public static int drawItem(Graphics g,Font f,String s,int x,int y)
	{
		// Draw string 's' in font 'f' onto graphics context 'g'.
		// x, y give the position at which to draw.
		// After drawing return the x-position for the next draw.
		
		int spaceBetweenFonts=7;
		FontMetrics fm=g.getFontMetrics(f);
		g.setFont(f);
		g.drawString(s,x,y);
		return x+fm.stringWidth(s)+spaceBetweenFonts;
	}

	
	private static int getRandomNumber(int stringIndex)
	{
	int r=1, m=1, c=13, i=1;	
	
		c=(int) ascii[stringIndex];
		r=c/2;
		r=((m*r)+i)%c;
		return r;
	}
}