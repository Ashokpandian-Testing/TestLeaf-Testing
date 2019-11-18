package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class ButtonPage {
	
	
	@FindBy(id="home")
	public static WebElement GotoHome;
	
	@FindBy(id="position")
	public static WebElement Position;
	
	@FindBy(id="color")
	public static WebElement Color;
	
	@FindBy(id="size")
	public static WebElement Size;

}
