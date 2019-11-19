package Pages;

import org.testng.annotations.Test;

import TestCases.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
 
//	public static WebElement element;

//  public static WebElement TextEdit(WebDriver driver) {
//		
//		element = driver.findElement(By.xpath("//h5[contains(text(),\"Edit\")]"));
//		
//		return element;
//  }
//  
	
	
  
  @FindBy(xpath="//h5[contains(text(),\"Edit\")]")
  public static WebElement TextEdit;
//  public static WebElement TextEdit(WebDriver driver) {
//		
//		element = driver.findElement(By.xpath("//h5[contains(text(),\"Edit\")]"));
//		
//		return element;
//}
  
  @FindBy(xpath="//img[@alt='Buttons']")
  public static WebElement Button;
  
  
  @FindBy(xpath="//img[@alt='Link']")
  public static WebElement Link;
	
	
}
