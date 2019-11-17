package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.EditPage;
import Pages.HomePage;

public class FirstTest extends TestBase {
	
//  @Test
//  public void ClickEdit() {	  
//	  HomePage.TextEdit(TestBase.driver).click();
//  }

	
	
  @Test(priority=0)
  public void ClickEdit() {	 
	  PageFactory.initElements(driver, HomePage.class);
	 HomePage.TextEdit.click();
  }
  
  @Test(priority=1,dependsOnMethods="ClickEdit")
  public void test01_EmailAddress() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.EmailAddress.sendKeys("as198184@gmail.com");
  }
  @Test(priority=2,dependsOnMethods="ClickEdit")
  public void test02_AppendText() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.AppendText.sendKeys("<-Text Appended->");
  }
  
  @Test(priority=3,dependsOnMethods="ClickEdit")
  public void test03_GetText() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  System.out.println(EditPage.GetDefaultText.getText());
  }
  
  @Test(priority=4,dependsOnMethods="ClickEdit")
  public void test04_ClearMe() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  EditPage.ClearMe.clear();
  }
  @Test(priority=5,dependsOnMethods="ClickEdit")
  public void test05_DisabledCheck() {	 
	  PageFactory.initElements(driver, EditPage.class);
	  System.out.println(EditPage.DisabledCheck.isDisplayed());
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
