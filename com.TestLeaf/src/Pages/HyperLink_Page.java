package Pages;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;

import java.util.List;

import org.openqa.selenium.WebElement;

public class HyperLink_Page {
	
	
	@FindBy(xpath="(//a[contains(text(),\"Go to Home Page\")])[1]")
	public static WebElement GotoHomePage;
	
	
	
	@FindBy(xpath="(//a[contains(text(),\"Find where am\")])[1]")
	public static WebElement Find;
	
	
	
	@FindBy(xpath="(//a[contains(text(),\"Verify am I\")])[1]")
	public static WebElement brokenLink;
	
	
	
	@FindBy(xpath="(//a[contains(text(),\"Go to Home Page\")])[2]")
	public static WebElement sameLink;
	
	
	@FindBy(xpath="//a")
	public static List<WebElement> LinkCount;

}
