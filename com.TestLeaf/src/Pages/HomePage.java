package Pages;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
 
	public static WebElement element;

  public static WebElement TextEdit(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//h5[contains(text(),\"Edit\")]"));
		
		return element;
  }
	
	
}
