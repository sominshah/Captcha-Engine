package captcha.engine.version.one.pojo;
public class Captcha implements java.io.Serializable
{
	private String name;
	private String value;	
	public Captcha()
	{
	this.name=null;
	this.value=null;
	}
public String getValue()
{
return this.value;
}
public String getName()
{
	return this.name;
}
public void setName(String name)
{
	this.name=name;
}
public void setValue(String value)
{
    this.value=value;
}
public boolean isValid(String value)
{
return this.value.equals(value);
}
}