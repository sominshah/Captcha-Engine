package captcha.engine.version.one.configuration;
import captcha.engine.version.one.pojo.*;
import captcha.engine.version.one.exception.*;
public interface CaptchaEngine
{
	public Captcha generateCaptcha() throws CaptchaException;
}