package TestCases;

import org.testng.annotations.Test;

import Pages.HomePage;

public class FirstTest extends TestBase{
	
  @Test
  public void ClickEdit() {	  
	  HomePage.TextEdit(TestBase.driver).click();
  }
}
