package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.HomePage;

public class FirstTest {
	
//  @Test
//  public void ClickEdit() {	  
//	  HomePage.TextEdit(TestBase.driver).click();
//  }

	
	
  @Test
  public void ClickEdit() {	  
	 HomePage.TextEdit.click();
  }
  
  
  
}
