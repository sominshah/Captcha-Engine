package captcha.engine.version.one.configuration;
import captcha.engine.version.one.exception.*;
import captcha.engine.version.one.enums.*;
public interface CaptchaProperties
{
public void setNumberOfFonts(int numberOfFonts);
public int getNumberOfFonts();
public void setCaptchaWidth(int captchaWidth);
public int getCaptchaWidth();
public void setCaptchaHeight(int captchaHeight);
public int getCaptchaHeight()throws CaptchaException;
public void setFontSize(int fontSize);
public int getFontSize();
public void setBackgroundColor(BackgroundColor backgroundColor);
public  BackgroundColor getBackgroundColor();
public void setFontName(FontName fontName);
public FontName getFontName();
public void setFontStyle (FontStyle fontStyle);
public FontStyle setFontStyle();
public void setFontColor(FontColor fontColor);
public FontColor getFontColor();
}