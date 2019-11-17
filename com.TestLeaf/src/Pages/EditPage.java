package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage {
	
	@FindBy(id="email")
	public static WebElement EmailAddress;
	
	
	@FindBy(xpath="//input[@value=\"Append \"]")
	public static WebElement AppendText;
	
	@FindBy(name="username")
	public static WebElement GetDefaultText;
	
	@FindBy(xpath="(//input[@type=\"text\"])[4]")
	public static WebElement ClearMe;
	
	@FindBy(xpath="//Div[@id=\"contentblock\"]/section[1]/div[@class=\"example\"][5]")
	public static WebElement DisabledCheck;
	

}
